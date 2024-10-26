package ventanas;

import java.awt.Dimension;
import java.awt.Point;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import elementos.entidades.Jugable;
import juego.Juego;
import juego.Nivel;
import observers.ObserverGrafico;

@SuppressWarnings("serial")
public class PantallaDeJuego extends JPanel {

    private ArrayList<ObserverGrafico> labelsElementoDeJuego;

    private Dimension size;
    
    private Jugable marioJugable;
    
    private ObserverGrafico marioLabel;
    
    private Interfaz hud;
    
    private JLabel fondo;
    
    private ObserverGrafico observerGrafico;
    
    private Point posicionOriginalJugable;
    
    private Point posicionOriginalLabelJugable;
   
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

    @SuppressWarnings("exports")
	public void registrarJugable(Jugable jugable) {
        marioJugable = jugable;
        marioLabel = jugable.getObserverGrafico();
        setPosicionOriginalJugable();
        setPosicionOriginalLabelJugable();
        agregarLabel(marioLabel);
        mostrarLabels();
        establecerFondo();
        revalidate();
        repaint();
    }

    private void setPosicionOriginalLabelJugable() {
		this.posicionOriginalLabelJugable = this.marioLabel.getLocation();
		
	}

	private void setPosicionOriginalJugable () {
		this.posicionOriginalJugable = this.marioJugable.getPosicion();	
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

        // Solo mover el fondo y los labels si Mario está más allá de la mitad de la pantalla
        if (posicionMario.x >= MITAD_PANTALLA) {
            // Calcular cuánto se debe mover el fondo
            int desplazamiento = posicionMario.x - MITAD_PANTALLA;

            // Obtener la posición actual del fondo
            Point posicionFondo = fondo.getLocation();

            // Mueve el fondo hacia la izquierda
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
        		fondoMovido = true; // Se ha movido el fondo
        		revalidate();
        		repaint();
        	}

         // Si el fondo se movió, mover los labels
        	if (fondoMovido) {
        		for (ObserverGrafico observerGrafico : this.labelsElementoDeJuego) {
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

        // Asegurarse de que Mario siempre esté actualizado
        marioLabel.actualizar();
        revalidate();
        repaint();
    }

    
    public void eliminarNivelActual() {
    	remove(fondo);
    	removerElementos();
    	this.labelsElementoDeJuego = new ArrayList<ObserverGrafico>();
    }
    
    public void cambiarDeNivel() {
    	this.marioJugable.establecerPosicion(this.posicionOriginalJugable);
    	this.marioLabel.setLocation(this.posicionOriginalLabelJugable);
    	agregarLabel(marioLabel);
    	mostrarLabels();
    	establecerFondo();
    	revalidate();
    	repaint();
    	System.out.println("ERROR: Mostrar labels se ejecuta unicamente cuando la lista tiene a mario unicamente");
    }

	private void removerElementos() {
		for (ObserverGrafico observerGrafico : this.labelsElementoDeJuego) {
			remove(observerGrafico);
		}
	}
    
    
}