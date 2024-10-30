package ventanas;

import java.awt.Dimension;
import java.awt.Point;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import elementos.Silueta;
import elementos.entidades.Jugable;
import fabricas.FabricaSilueta;
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
   
    private static final int MITAD_PANTALLA = (ConstantesGlobales.PANEL_ANCHO / 2) - 100;

    public PantallaDeJuego() {
        configurarVentana();
        this.labelsElementoDeJuego = new ArrayList<ObserverGrafico>();
    }

    protected void configurarVentana(){
        setVisible(true);
        setLayout(null);
        this.size = new Dimension(ConstantesGlobales.PANEL_ANCHO, ConstantesGlobales.PANEL_ALTO);
        setPreferredSize(size);
        setMaximumSize(size);
        setMinimumSize(size);
        
        // Crear el JLayeredPane para gestionar las capas
        layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(size);
        layeredPane.setBounds(0, 0, ConstantesGlobales.PANEL_ANCHO, ConstantesGlobales.PANEL_ALTO);
        add(layeredPane);
        
        revalidate();
        repaint();
        
        crearHUD();
    }
    
    private void crearHUD() {
    	hud = new Interfaz();
    	hud.setBounds(0, 0, ConstantesGlobales.PANEL_ANCHO, ConstantesGlobales.PANEL_ALTO);
    	layeredPane.add(hud, JLayeredPane.PALETTE_LAYER);
        hud.setVisible(true);
        revalidate();
        repaint();
	}

    public void registrarFondo(FabricaSilueta fabricaSilueta) {
    	Silueta siluetaFondo = fabricaSilueta.obtenerSilueta();
    	ImageIcon fondoImagen = new ImageIcon(siluetaFondo.obtenerRutaSilueta());
        this.fondo = new JLabel(fondoImagen);
        establecerFondo();
    }
    
	protected void establecerFondo() {
        fondo.setBounds(0, 0, this.fondo.getIcon().getIconWidth(), this.fondo.getIcon().getIconHeight());
        layeredPane.add(fondo, JLayeredPane.DEFAULT_LAYER); 
        revalidate();
        repaint();
    }

    @SuppressWarnings("exports")
	public void registrarJugable(Jugable jugable) {
        marioJugable = jugable;
        marioLabel = jugable.obtenerObserverGrafico();
        establecerPosicionOriginalJugable();
        establecerPosicionOriginalLabelJugable();
        agregarLabel(marioLabel);
        revalidate();
        repaint();
    }

    private void establecerPosicionOriginalLabelJugable() {
		this.posicionOriginalLabelJugable = this.marioJugable.obtenerPosicion();
	}

	private void establecerPosicionOriginalJugable () {
		this.posicionOriginalJugable = this.marioJugable.obtenerPosicion();	
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
    	//TODO El warpeo de mario se debe a que para cuando este metodo se da cuenta que mario supero la mitad de la pantalla
    	//la posicion grafica de mario ya se actualizo, entonces cuando se ejecuta este metodo, la posicion grafica de mario es retrotraida
    	//y es visible para el jugador
        hud.actualizarTiempo();
        hud.actualizarVidas(marioJugable.obtenerVidas());
        hud.actualizarPuntaje(marioJugable.obtenerPuntos());
        hud.actualizarNivel(marioJugable.obtenerNivel().obtenerNumeroNivel());

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
            if (nuevaPosicionFondoX < -anchoFondo + ConstantesGlobales.PANEL_ANCHO) {
                nuevaPosicionFondoX = -anchoFondo + ConstantesGlobales.PANEL_ANCHO; // Limitar movimiento del fondo
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
                    if (!observerGrafico.obtenerEntidadObservada().obtenerRemovido()) {
                        Point posicionLabel = observerGrafico.getLocation();
                        posicionLabel.x -= (posicionFondo.x - nuevaPosicionFondoX); // Desplazar los labels
                        observerGrafico.obtenerEntidadObservada().establecerPosicion(posicionLabel);
                        observerGrafico.obtenerEntidadObservada().moverHitbox(posicionLabel);
                    } else {
                        // TODO: Eliminar label del nivel 
                    }
                    observerGrafico.actualizar();
                    revalidate();
                    repaint();
                }
            }
        }
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
    	this.marioJugable.establecerPosicion(new Point(this.posicionOriginalJugable.x, this.posicionOriginalJugable.y + (50 - marioJugable.obtenerAlto())));
    	this.marioJugable.moverHitbox(posicionOriginalJugable);
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