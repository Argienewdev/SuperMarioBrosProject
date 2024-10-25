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
import javax.swing.Timer;

import elementos.entidades.Jugable;
import observers.ObserverGrafico;
import sensoresDeTeclas.SensorDeTeclasJuego;

public class PantallaDeJuego extends JPanel {

    private ArrayList<ObserverGrafico> labelsElementoDeJuego;

    private Dimension size;
    
    private Jugable marioJugable;
    
    private ObserverGrafico marioLabel;
    
    private Interfaz hud;
    
    private JLabel fondo;
    
    private ObserverGrafico observerGrafico;

    private static final int MITAD_PANTALLA = (DimensionesConstantes.PANEL_ANCHO / 2) - 100;

    public PantallaDeJuego() {
        this.fondo = new JLabel();
        hud = new Interfaz();
        configurarVentana();
        this.labelsElementoDeJuego = new ArrayList<ObserverGrafico>();
    }

    protected void configurarVentana(){
        setVisible(true);
        setLayout(null);
        this.size = new Dimension(DimensionesConstantes.PANEL_ANCHO, DimensionesConstantes.PANEL_ALTO);
        setPreferredSize(size);
        setMaximumSize(size);
        setMinimumSize(size);
        hud.setBounds(0, 0, DimensionesConstantes.PANEL_ANCHO, DimensionesConstantes.PANEL_ALTO);
        add(hud);
        hud.setVisible(true);
    }
    
    protected void establecerFondo() {
        ImageIcon fondoImagen = new ImageIcon("src/imagenes/fondoPantallaJuego.png");
        fondo = new JLabel(fondoImagen);
        fondo.setBounds(0, 0, fondoImagen.getIconWidth(), fondoImagen.getIconHeight());
        add(fondo);
    }

    public void registrarJugable(Jugable jugable) {
        marioJugable = jugable;
        marioLabel = new ObserverGrafico(jugable);
        agregarLabel(jugable.getObserverGrafico());
        mostrarLabels();
        establecerFondo();
        
        revalidate();
        repaint();
    }

    public void agregarLabel(ObserverGrafico labelElementoDeJuego) {
        labelsElementoDeJuego.add(labelElementoDeJuego);
    }

    public void mostrarLabels() {
        for(JLabel label : labelsElementoDeJuego) {
            add(label);
            label.setVisible(true);
            revalidate();
            repaint();
        }
    }

    public void refrescar() {
    	hud.actualizarTiempo();
    	hud.actualizarVidas(marioJugable.getVidas());
    	hud.actualizarPuntaje(marioJugable.getPuntos());
        // Obtener la posición actual de Mario
        Point posicionMario = marioLabel.getLocation();
        boolean fondoMovido = false; // Bandera para indicar si el fondo se ha movido
        
        if (posicionMario.x >= MITAD_PANTALLA && fondo.getLocation().x + fondo.getWidth() > DimensionesConstantes.PANEL_ANCHO) {
        	int desplazamiento = posicionMario.x - MITAD_PANTALLA;

        	// Mueve el fondo hacia la izquierda en función del desplazamiento de Mario
        	Point posicionFondo = fondo.getLocation();
        	int nuevaPosicionFondoX = posicionFondo.x - desplazamiento;

        	// Obtener el ancho del fondo para limitar el desplazamiento
        	int anchoFondo = fondo.getWidth();

        	// Asegúrate de que el fondo no se desplace más allá de su posición inicial
        	if (nuevaPosicionFondoX < -anchoFondo + DimensionesConstantes.PANEL_ANCHO) {
        		nuevaPosicionFondoX = -anchoFondo + DimensionesConstantes.PANEL_ANCHO; // Limitar movimiento del fondo
        	}

        	// Solo mueve el fondo si su posición ha cambiado
        	if (nuevaPosicionFondoX != posicionFondo.x) {
        		fondo.setLocation(nuevaPosicionFondoX, posicionFondo.y);
        		revalidate();
        		repaint();
        		fondoMovido = true; // Se ha movido el fondo
        	}

        	// Si el fondo se movió, mover los labels
        	if (fondoMovido) {
        		for (ObserverGrafico observerGrafico : this.labelsElementoDeJuego) {
        			if (observerGrafico != marioLabel) { // No mover a Mario aquí
        				Point posicionLabel = observerGrafico.getLocation();
        				posicionLabel.x -= (posicionFondo.x - nuevaPosicionFondoX); // Mover los labels hacia la izquierda
        				observerGrafico.getEntidadObservada().setPosicion(posicionLabel);
        				observerGrafico.getEntidadObservada().moverHitbox(posicionLabel);
        				observerGrafico.actualizar();
        				revalidate();
        				repaint();
        			}
        		}
        	}

        	// Mantener a Mario en el centro de la pantalla
        	posicionMario.x = MITAD_PANTALLA;
        	marioLabel.setLocation(posicionMario);
        	revalidate();
        	repaint();
        }

        // Actualizar la posición y refrescar los gráficos
        marioLabel.actualizar(); // Asegura que Mario siempre esté actualizado
        revalidate();
        repaint();
    }

    
}
