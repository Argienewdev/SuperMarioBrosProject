package ventanas;

import java.awt.Dimension;
import java.awt.Point;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import elementos.ElementoDeJuego;
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
    
    private JLayeredPane layeredPane;
   
    private static final int MITAD_PANTALLA = (DimensionesConstantes.PANEL_ANCHO / 2) - 100;

    public PantallaDeJuego() {
        configurarVentana();
        establecerFondo();
        this.labelsElementoDeJuego = new ArrayList<ObserverGrafico>();
    }

    protected void configurarVentana(){
        setVisible(true);
        setLayout(null);
        this.size = new Dimension(DimensionesConstantes.PANEL_ANCHO, DimensionesConstantes.PANEL_ALTO);
        setPreferredSize(size);
        setMaximumSize(size);
        setMinimumSize(size);
        
        // Crear el JLayeredPane para gestionar las capas
        layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(size);
        layeredPane.setBounds(0, 0, DimensionesConstantes.PANEL_ANCHO, DimensionesConstantes.PANEL_ALTO);
        add(layeredPane);
        
        revalidate();
        repaint();
        
        crearHUD();
    }
    
    private void crearHUD() {
    	hud = new Interfaz();
    	hud.setBounds(0, 0, DimensionesConstantes.PANEL_ANCHO, DimensionesConstantes.PANEL_ALTO);
    	layeredPane.add(hud, JLayeredPane.PALETTE_LAYER);
        hud.setVisible(true);
        revalidate();
        repaint();
	}

	protected void establecerFondo() {
        ImageIcon fondoImagen = new ImageIcon("src/imagenes/fondoPantallaJuego.png");
        fondo = new JLabel(fondoImagen);
        fondo.setBounds(0, 0, fondoImagen.getIconWidth(), fondoImagen.getIconHeight());
        layeredPane.add(fondo, JLayeredPane.DEFAULT_LAYER); 
        revalidate();
        repaint();
    }

    @SuppressWarnings("exports")
	public void registrarJugable(Jugable jugable) {
        marioJugable = jugable;
        marioLabel = jugable.getObserverGrafico();
        setPosicionOriginalJugable();
        setPosicionOriginalLabelJugable();
        agregarLabel(marioLabel);
        revalidate();
        repaint();
    }

    private void setPosicionOriginalLabelJugable() {
		this.posicionOriginalLabelJugable = this.marioJugable.getPosicion();
	}

	private void setPosicionOriginalJugable () {
		this.posicionOriginalJugable = this.marioJugable.getPosicion();	
	}

	public void agregarLabel(ObserverGrafico labelElementoDeJuego) {
		labelsElementoDeJuego.add(labelElementoDeJuego);
		layeredPane.add(labelElementoDeJuego, JLayeredPane.MODAL_LAYER);
		labelElementoDeJuego.setVisible(true);
        revalidate();
        repaint();
    }
	
	public void agregarbola(ObserverGrafico labelElementoDeJuego) {
        labelsElementoDeJuego.add(labelElementoDeJuego);
    }

    public void refrescar() {
    	System.out.println(marioJugable.getPosicion().x + " " + marioJugable.getPosicion().y);
    	System.out.println(marioLabel.getLocation().x + " " + marioLabel.getLocation().y);
    	//TODO El warpeo de mario se debe a que para cuando este metodo se da cuenta que mario supero la mitad de la pantalla
    	//la posicion grafica de mario ya se actualizo, entonces cuando se ejecuta este metodo, la posicion grafica de mario es retrotraida
    	//y es visible para el jugador
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
        	/*TODO 
        	Thread Suspended (uncaught exception ConcurrentModificationException))	
        	PantallaDeJuego.refrescar() line: 153	
        	ControladorVistas.refrescar() line: 167	
        	Juego.actualizar() line: 56	
        	BucleJuego.tick() line: 87	
        	BucleJuego.run() line: 63	
        	Thread.run() line: 1589	
        	*/
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
    	layeredPane.remove(fondo);
    	layeredPane.remove(hud);
    	removerElementos();
    	this.labelsElementoDeJuego = new ArrayList<ObserverGrafico>();
    }
    
    public void cambiarDeNivel() {
    	establecerFondo();
    	crearHUD();
    	//TODO esto evita que si alguna version super de mario cambia de nivel, aparezca metida en el piso
    	//debido a que primero cambia de nivel y despues revierte su estado
    	/*for(ElementoDeJuego e : this.marioJugable.getNivel().getElementosDeJuego()) {
    		System.out.println(e.getClass().getName());
    	}*/
    	System.out.println("HITBOX MARIO: " + marioJugable.obtenerHitbox().x + " " + marioJugable.obtenerHitbox().y);
    	System.out.println(marioJugable.obtenerAlto() + " " + marioJugable.obtenerAncho());
    	this.marioJugable.establecerPosicion(new Point(this.posicionOriginalJugable.x, this.posicionOriginalJugable.y + (50 - marioJugable.obtenerAlto())));
    	System.out.println("HITBOX MARIO: " + marioJugable.obtenerHitbox().x + " " + marioJugable.obtenerHitbox().y);
    	System.out.println(marioJugable.obtenerAlto() + " " + marioJugable.obtenerAncho());
    	this.marioJugable.moverHitbox(posicionOriginalJugable);
    	System.out.println("HITBOX MARIO: " + marioJugable.obtenerHitbox().x + " " + marioJugable.obtenerHitbox().y);
    	System.out.println(marioJugable.obtenerAlto() + " " + marioJugable.obtenerAncho());
    	this.marioLabel.setLocation(this.posicionOriginalLabelJugable.x, this.posicionOriginalLabelJugable.y + (50 - marioJugable.obtenerAlto()));
    	agregarLabel(marioLabel);
    	revalidate();
    	repaint();
    }

	private void removerElementos() {
		for(ObserverGrafico observerGrafico : this.labelsElementoDeJuego) {
			layeredPane.remove(observerGrafico);
		}
	}
    
    
}