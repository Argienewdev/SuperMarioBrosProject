package ventanas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import elementos.entidades.Jugable;
import observers.ObserverGrafico;
import sensoresDeTeclas.SensorDeTeclasJuego;

public class PantallaDeJuego extends JPanel {
	
	private ArrayList<JLabel> labelsElementoDeJuego;
	
	private Dimension size;
	private Jugable marioJugable;
	private JLabel marioLabel;
	private JLabel fondo;
	private SensorDeTeclasJuego sensorDeTeclasJuego;
	private ObserverGrafico observerGrafico;
	private boolean enElSuelo = true; // Nueva variable para controlar el estado de Mario
	private int fondoX = 0; // Nueva variable para la posición X del fondo
	private double velocidadFondo = 2; // Ajusta la velocidad a la que se mueve fondo 
	private final int GRAVEDAD = 2;  // Constante de gravedad
	private int velocidadY = 0;      // Velocidad vertical inicial de Mario

	public PantallaDeJuego(SensorDeTeclasJuego sensorDeTeclasJuego) {
		setVisible(true);
		this.fondo = new JLabel();
		configurarVentana();
	    this.sensorDeTeclasJuego = sensorDeTeclasJuego;
	    this.labelsElementoDeJuego = new ArrayList<JLabel>();
	}
	
	@Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        dibujarCuadricula(g);
    }
    
    private void dibujarCuadricula(Graphics g) {
        int width = getWidth();
        int height = getHeight();
        int gridSize = 50; // Tamaño de cada celda de la cuadrícula

        // Dibuja líneas verticales
        for (int x = 0; x <= width; x += gridSize) {
            g.drawLine(x, 0, x, height);
        }

        // Dibuja líneas horizontales
        for (int y = 0; y <= height; y += gridSize) {
            g.drawLine(0, y, width, y);
        }

        // Dibuja las coordenadas en cada celda
        g.setColor(Color.RED); // Color del texto
        g.setFont(new Font("Arial", Font.PLAIN, 10)); // Fuente del texto

        for (int row = 0; row * gridSize < height; row++) {
            for (int col = 0; col * gridSize < width; col++) {
                // Calcula las coordenadas en formato (fila, columna)
                String coordenadas = "(" + row + ", " + col + ")";
                // Ajusta la posición del texto
                g.drawString(coordenadas, col * gridSize + 5, row * gridSize + 15);
            }
        }
    }
	
	protected void configurarVentana(){
		setVisible(true);
		setLayout(null);
		this.size = new Dimension(2200, DimensionesConstantes.PANEL_ALTO);
		setPreferredSize(size);
		setMaximumSize(size);
		setMinimumSize(size);
	}
	
	protected void establecerFondo(){
		ImageIcon fondoImagen = new ImageIcon("src/imagenes/fondoPantallaJuego.png");
		fondo = new JLabel(fondoImagen);
	    fondo.setBounds(fondoX, 0, 4000, size.height); // Ajusta la posición X del fondo
	    add(fondo);
	}
	
	public void registrarJugable(Jugable jugable) {
		marioJugable = jugable;
		ImageIcon marioIcono = new ImageIcon(marioJugable.getSprite().getRutaImagen());
		marioLabel = new JLabel(marioIcono);
		Point aux = parsearPosicionDelJugable(marioJugable.getPosicion());
		marioLabel.setBounds(aux.x, aux.y,marioIcono.getIconWidth(), marioIcono.getIconHeight());
		agregarLabel(marioLabel);
		mostrarLabels();
		establecerFondo();
		revalidate();
		repaint();
	}
	
	public void agregarLabel(JLabel labelElementoDeJuego) {
		labelsElementoDeJuego.add(labelElementoDeJuego);
		mostrarLabels();
	}
	
	public void mostrarLabels() {
		for(JLabel label : labelsElementoDeJuego) {
			add(label);
			label.setVisible(true);
			revalidate();
			repaint();
		}
	}
	
	private Point parsearPosicionDelJugable(Point posicion) {
		Point toReturn = new Point();
		toReturn.x = parsearPosicionX(posicion.x);
		toReturn.y = parsearPosicionY(posicion.y);
		return toReturn;
	}
	
	private int parsearPosicionX(int posX) {
		return posX;
	}
	
	private int parsearPosicionY(int posY) {
		return posY+35;
	}
    
	public void refrescar() {
	    int deltaX = 0;

	    // Movimiento horizontal con verificación de límites
	    if (sensorDeTeclasJuego.obtenerAPresionada()) {
	        if (marioJugable.getPosicion().x > 0) {
	            deltaX = -10;  // Mover a la izquierda
	        } else {
	            deltaX = 0;  // Evitar que salga del límite izquierdo
	        }
	    }
	    if (sensorDeTeclasJuego.obtenerDPresionada()) {
	        if (marioJugable.getPosicion().x < getWidth() - marioLabel.getWidth()) {
	            deltaX = 10;  // Mover a la derecha
	        } else {
	            deltaX = 0;  // Evitar que salga del límite derecho
	        }
	    }

	    // Movimiento vertical (salto) con gravedad
	    if (sensorDeTeclasJuego.obtenerWPresionada() && enElSuelo) {
	        velocidadY = -20;
	        enElSuelo = false;
	    }
	    if (!enElSuelo) {
	        velocidadY += GRAVEDAD;  // Aplicar gravedad
	    }

	    // Actualización de la posición de Mario
	    Point nuevaPosicion = new Point(marioJugable.getPosicion());
	    nuevaPosicion.x += deltaX;
	    nuevaPosicion.y += velocidadY;

	    // Ajustar la posición para evitar desbordamientos
	    nuevaPosicion.x = Math.max(0, Math.min(nuevaPosicion.x, getWidth() - marioLabel.getWidth()));

	    // Verificar si Mario toca el suelo
	    if (nuevaPosicion.y >= 600) {
	        nuevaPosicion.y = 600;
	        enElSuelo = true;
	        velocidadY = 0;
	    } else if (nuevaPosicion.y < 0) {
	        nuevaPosicion.y = 0;
	        velocidadY = 0;
	    }

	    // Actualizar la posición del Jugable y el JLabel
	    marioJugable.setPosicion(nuevaPosicion);
	    marioLabel.setLocation(parsearPosicionDelJugable(nuevaPosicion));

	    // Mover el fondo y otros labels si Mario se mueve hacia la derecha
	    if (deltaX > 0 && fondoX > -(4000 - getWidth())) {
	        fondoX -= deltaX * velocidadFondo;
	        fondo.setBounds(fondoX, 0, 4000, size.height);

	        // Desplazar los labels junto con el fondo
	        for (JLabel label : labelsElementoDeJuego) {
	            Point posActual = label.getLocation();
	            label.setLocation(posActual.x - (int) (deltaX * velocidadFondo), posActual.y);
	        }
	    }

	    // Redibujar el panel
	    repaint();
	}



	
	
}
