package ventanas;

import java.awt.Dimension;
import java.awt.Point;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

import elementos.Silueta;
import elementos.entidades.Jugable;
import fabricas.FabricaSilueta;
import observers.ObserverGrafico;

@SuppressWarnings("serial")
public class PantallaDeJuego extends Pantalla {

    private ArrayList<ObserverGrafico> labelsElementoDeJuego;

    private ArrayList<ObserverGrafico> labelsElementoDeJuegoARemover;

    private Dimension size;
    
    private Jugable marioJugable;
    
    private ObserverGrafico marioLabel;
    
    private Interfaz hud;
    
    private JLabel labelsMovibles;
    
    private JLabel fondo;
    
    private Point posicionOriginalJugable;
    
    private Point posicionOriginalLabelJugable;
    
    private JLayeredPane layeredPane;
   
    public PantallaDeJuego() {
        configurarVentana();
        this.labelsElementoDeJuego = new ArrayList<ObserverGrafico>();
        this.labelsElementoDeJuegoARemover = new ArrayList<ObserverGrafico>();
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

	public void registrarJugable(Jugable jugable) {
        this.marioJugable = jugable;
        this.marioLabel = jugable.obtenerObserverGrafico();
        establecerPosicionOriginalJugable();
        establecerPosicionOriginalLabelJugable();
        layeredPane.add(this.marioLabel, JLayeredPane.MODAL_LAYER);
        this.marioLabel.setVisible(true);
        revalidate();
        repaint();
    }

    private void establecerPosicionOriginalLabelJugable() {
		this.posicionOriginalLabelJugable = this.marioJugable.obtenerPosicionGrafica();
	}

	private void establecerPosicionOriginalJugable () {
		this.posicionOriginalJugable = this.marioJugable.obtenerPosicionLogica();	
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
        
        int desplazamiento = this.marioJugable.obtenerDesplazamiento();
        boolean fondoMovido = false;
        
        if (desplazamiento > 0) {
            Point posicionFondo = fondo.getLocation();
            int nuevaPosicionFondoX = posicionFondo.x - (desplazamiento / 2);

            // Ver que el fondo no se desplace mas de lo posible
            int anchoFondo = fondo.getWidth();
            if (nuevaPosicionFondoX < -anchoFondo + ConstantesGlobales.PANEL_ANCHO) {
                nuevaPosicionFondoX = -anchoFondo + ConstantesGlobales.PANEL_ANCHO;
            }
            
        	if (nuevaPosicionFondoX != posicionFondo.x) {
        		fondo.setLocation(nuevaPosicionFondoX, posicionFondo.y);
        		fondoMovido = true; // Se ha movido el fondo
        	}

        	/*TODO 
        	Thread Suspended (uncaught exception ConcurrentModificationException))	
        	PantallaDeJuego.refrescar() line: 153	
        	ControladorVistas.refrescar() line: 167	
        	Juego.actualizar() line: 56	
        	*/
        	
        	if (fondoMovido) {
    			for (ObserverGrafico observerGrafico : this.labelsElementoDeJuego) {
    				Point posicionLabel = observerGrafico.getLocation();
    				posicionLabel.x -= desplazamiento;
    				observerGrafico.obtenerEntidadObservada().establecerPosicionGrafica(posicionLabel);
    				observerGrafico.actualizar();
    				if (observerGrafico.obtenerRemovido() || observerGrafico.obtenerEntidadObservada().obtenerPosicionGrafica().x < -100) {
    					this.labelsElementoDeJuegoARemover.add(observerGrafico);
    				}
    			}
    			this.labelsElementoDeJuego.removeAll(labelsElementoDeJuegoARemover);
    			
    			int cambioDesplazamiento = this.marioJugable.obtenerDesplazamiento() - desplazamiento;
    			this.marioJugable.establecerDesplazamiento(cambioDesplazamiento);
    			revalidate();
    			repaint();
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
    	crearHUD();
    	this.marioJugable.establecerPosicionLogica(new Point(this.posicionOriginalJugable.x, this.posicionOriginalJugable.y + (50 - marioJugable.obtenerAlto())));
    	this.marioJugable.establecerPosicionGrafica(this.marioJugable.obtenerPosicionLogica());
    	this.marioJugable.moverHitbox(posicionOriginalJugable);
    	this.marioLabel.setLocation(this.posicionOriginalLabelJugable.x, this.posicionOriginalLabelJugable.y + (50 - marioJugable.obtenerAlto()));
    	this.marioJugable.establecerDesplazamiento(0);
    	revalidate();
    	repaint();
    }

	private void removerElementos() {
		for(ObserverGrafico observerGrafico : this.labelsElementoDeJuego) {
			layeredPane.remove(observerGrafico);
		}
	}
    
    
}