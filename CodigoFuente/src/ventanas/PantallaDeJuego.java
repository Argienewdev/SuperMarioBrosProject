package ventanas;

import java.awt.Dimension;
import java.awt.Point;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import elementos.Silueta;
import elementos.entidades.Jugable;
import juego.ConstantesGlobales;
import observers.ObserverGrafico;

@SuppressWarnings("serial")
public class PantallaDeJuego extends Pantalla {

    private List<ObserverGrafico> labelsElementoDeJuego;

    private Dimension size;
    
    private Jugable jugable;
    
    private ObserverGrafico labelJugable;
    
    private InterfazJuego hud;
    
    private JLabel fondo;
    
    private Point posicionOriginalLogicaJugable;
    
    private Point posicionOriginalLabelJugable;
    
    private JLayeredPane layeredPane;
   
    public PantallaDeJuego() {
        this.configurarVentana();
        this.labelsElementoDeJuego = new CopyOnWriteArrayList<>();
    }
    
    public InterfazJuego obtenerHUD() {
    	return this.hud;
    }
    
    private void configurarVentana(){
        this.setVisible(true);
        this.setLayout(null);
        establecerTamanio();
        crearLayeredPane();
        this.add(this.layeredPane);
        this.crearHUD();
        this.revalidate();
        this.repaint();
    }
    
    private void crearLayeredPane() {
    	this.layeredPane = new JLayeredPane();
        this.layeredPane.setPreferredSize(this.size);
        this.layeredPane.setBounds(0, 0, ConstantesGlobales.PANEL_ANCHO, ConstantesGlobales.PANEL_ALTO);
	}

	private void establecerTamanio() {
    	this.size = new Dimension(ConstantesGlobales.PANEL_ANCHO, ConstantesGlobales.PANEL_ALTO);
        this.setPreferredSize(this.size);
        this.setMaximumSize(this.size);
        this.setMinimumSize(this.size);
	}

	private void crearHUD() {
    	this.hud = new InterfazJuego();
    	this.hud.setBounds(0, 0, ConstantesGlobales.PANEL_ANCHO, ConstantesGlobales.PANEL_ALTO);
    	this.layeredPane.add(this.hud, JLayeredPane.PALETTE_LAYER);
        this.hud.setVisible(true);
        this.revalidate();
        this.repaint();
	}

    public void registrarFondo(Silueta siluetaFondo) {
    	ImageIcon fondoImagen = new ImageIcon(siluetaFondo.obtenerRutaSilueta());
        this.fondo = new JLabel(fondoImagen);
        this.establecerFondo();
    }
    
	private void establecerFondo() {
        this.fondo.setBounds(0, 0, this.fondo.getIcon().getIconWidth(), this.fondo.getIcon().getIconHeight());
        this.layeredPane.add(this.fondo, JLayeredPane.DEFAULT_LAYER); 
        this.revalidate();
        this.repaint();
    }

	public void registrarJugable(Jugable jugable) {
        this.jugable = jugable;
        this.labelJugable = jugable.obtenerObserverGrafico();
        this.establecerPosicionOriginalJugable();
        this.establecerPosicionOriginalLabelJugable();
        this.layeredPane.add(this.labelJugable, JLayeredPane.MODAL_LAYER);
        this.labelJugable.setVisible(true);
        this.revalidate();
        this.repaint();
    }

    private void establecerPosicionOriginalLabelJugable() {
		this.posicionOriginalLabelJugable = this.jugable.obtenerPosicionGrafica();
	}

	private void establecerPosicionOriginalJugable () {
		this.posicionOriginalLogicaJugable = this.jugable.obtenerPosicionLogica();	
	}
	
	public void agregarLabel(ObserverGrafico labelElementoDeJuego) {
		this.labelsElementoDeJuego.add(labelElementoDeJuego);
		this.layeredPane.add(labelElementoDeJuego, JLayeredPane.MODAL_LAYER);
		labelElementoDeJuego.setVisible(true);
		this.revalidate();
        this.repaint();
    }
	
    public void refrescar() {
        this.actualizarHUD();
        this.moverLabels();
    }

    
    private void moverLabels() {
    	int desplazamiento = this.jugable.obtenerDesplazamiento();
        boolean fondoMovido = false;
        
        if (desplazamiento > 0) {
            Point posicionFondo = this.fondo.getLocation();
            int nuevaPosicionFondoX = posicionFondo.x - (desplazamiento / 2);
            int anchoFondo = this.fondo.getWidth();
            
            if (nuevaPosicionFondoX < -anchoFondo + ConstantesGlobales.PANEL_ANCHO) {
                nuevaPosicionFondoX = -anchoFondo + ConstantesGlobales.PANEL_ANCHO;
            }
            
        	if (nuevaPosicionFondoX != posicionFondo.x) {
        		this.fondo.setLocation(nuevaPosicionFondoX, posicionFondo.y);
        		fondoMovido = true; 
        	}

        	if (fondoMovido) {
    			for (ObserverGrafico observerGrafico : this.labelsElementoDeJuego) {
    				Point posicionLabel = observerGrafico.getLocation();
    				posicionLabel.x -=  desplazamiento;
    				observerGrafico.obtenerEntidadObservada().establecerPosicionGrafica(posicionLabel);
    				observerGrafico.actualizar();
    				if (observerGrafico.obtenerRemovido()) {
    					this.layeredPane.remove(observerGrafico);
    					this.labelsElementoDeJuego.remove(observerGrafico);
    				}
    			}
    			int cambioDesplazamiento = this.jugable.obtenerDesplazamiento() - desplazamiento;
    			this.jugable.establecerDesplazamiento(cambioDesplazamiento);
            }
        	this.revalidate();
        	this.repaint();
        }
	}

	private void actualizarHUD() {
    	this.hud.actualizarTiempo();
        this.hud.actualizarVidas(jugable.obtenerVidas());
        this.hud.actualizarPuntaje(jugable.obtenerPuntos());
        this.hud.actualizarNivel(jugable.obtenerNivel().obtenerNumeroNivel());
	}

	public void eliminarNivelActual() {
    	this.removerLabelsDelPanel();
    	this.labelsElementoDeJuego = new CopyOnWriteArrayList<>();
    }
    
    public void cambiarDeNivel() {
    	this.crearHUD();
    	this.establecerJugableEnNuevoNivel();
    	this.revalidate();
    	this.repaint();
    }

	private void establecerJugableEnNuevoNivel() {
		this.jugable.establecerPosicionLogica(new Point(this.posicionOriginalLogicaJugable.x, this.posicionOriginalLogicaJugable.y + (50 - jugable.obtenerAlto())));
    	this.jugable.establecerPosicionGrafica(this.jugable.obtenerPosicionLogica());
    	this.jugable.moverHitbox(this.jugable.obtenerPosicionLogica());
    	this.labelJugable.setLocation(this.posicionOriginalLabelJugable.x, this.posicionOriginalLabelJugable.y + (50 - jugable.obtenerAlto()));
    	this.jugable.establecerDesplazamiento(0);
    	this.revalidate();
    	this.repaint();
	}

	private void removerLabelsDelPanel() {
		this.layeredPane.remove(fondo);
    	this.layeredPane.remove(hud);
		for(ObserverGrafico observerGrafico : this.labelsElementoDeJuego) {
			this.layeredPane.remove(observerGrafico);
		}
		this.revalidate();
    	this.repaint();
	}
    
}