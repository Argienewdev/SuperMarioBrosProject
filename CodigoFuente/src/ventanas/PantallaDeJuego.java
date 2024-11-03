package ventanas;

import java.awt.Dimension;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

import elementos.Silueta;
import elementos.entidades.Jugable;
import observers.ObserverGrafico;

@SuppressWarnings("serial")
public class PantallaDeJuego extends Pantalla {

    private ArrayList<ObserverGrafico> labelsElementoDeJuego;

    private ArrayList<ObserverGrafico> labelsElementoDeJuegoARemover;

    private ArrayList<ObserverGrafico> labelsElementoDeJuegoAAgregar;

    private Dimension size;
    
    private Jugable marioJugable;
    
    private ObserverGrafico marioLabel;
    
    private InterfazJuego hud;
    
    private JLabel fondo;
    
    private Point posicionOriginalJugable;
    
    private Point posicionOriginalLabelJugable;
    
    private JLayeredPane layeredPane;
   
    public PantallaDeJuego() {
        configurarVentana();
        this.labelsElementoDeJuego = new ArrayList<ObserverGrafico>();
        this.labelsElementoDeJuegoARemover = new ArrayList<ObserverGrafico>();
        this.labelsElementoDeJuegoAAgregar = new ArrayList<ObserverGrafico>();
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
    	hud = new InterfazJuego();
    	hud.setBounds(0, 0, ConstantesGlobales.PANEL_ANCHO, ConstantesGlobales.PANEL_ALTO);
    	layeredPane.add(hud, JLayeredPane.PALETTE_LAYER);
        hud.setVisible(true);
        revalidate();
        repaint();
	}

    public void registrarFondo(Silueta siluetaFondo) {
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

	public void agregarLabelAAgregar(ObserverGrafico labelElementoDeJuego) {
		this.labelsElementoDeJuegoAAgregar.add(labelElementoDeJuego);
	}
	
	private void agregarLabelsAAgregar() {
		for(ObserverGrafico observer : this.labelsElementoDeJuegoAAgregar) {
			this.agregarLabel(observer);
		}
		this.labelsElementoDeJuegoAAgregar = new ArrayList<ObserverGrafico>();
	}
	
	private void removerLabelsARemover() {
		this.labelsElementoDeJuego.removeAll(labelsElementoDeJuegoARemover);
		this.labelsElementoDeJuegoARemover = new ArrayList<ObserverGrafico>();
	}
	
	public void agregarLabel(ObserverGrafico labelElementoDeJuego) {
		labelsElementoDeJuego.add(labelElementoDeJuego);
		layeredPane.add(labelElementoDeJuego, JLayeredPane.MODAL_LAYER);
		labelElementoDeJuego.setVisible(true);
		this.revalidate();
        this.repaint();
    }
	
    public void refrescar() {
    	this.agregarLabelsAAgregar();
    	
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

        	if (fondoMovido) {
    			for (ObserverGrafico observerGrafico : this.labelsElementoDeJuego) {
    				Point posicionLabel = observerGrafico.getLocation();
    				posicionLabel.x -=  desplazamiento;
    				observerGrafico.obtenerEntidadObservada().establecerPosicionGrafica(posicionLabel);
    				observerGrafico.actualizar();
    				if (observerGrafico.obtenerRemovido()) {
    					layeredPane.remove(observerGrafico);
    					this.labelsElementoDeJuegoARemover.add(observerGrafico);
    				}
    			}
    			removerLabelsARemover();
    			
    			int cambioDesplazamiento = this.marioJugable.obtenerDesplazamiento() - desplazamiento;
    			this.marioJugable.establecerDesplazamiento(cambioDesplazamiento);
            }
        	this.revalidate();
        	this.repaint();
        }
    }

    
    public void eliminarNivelActual() {
    	layeredPane.remove(fondo);
    	layeredPane.remove(hud);
    	this.removerElementos();
    	this.labelsElementoDeJuego = new ArrayList<ObserverGrafico>();
    	this.labelsElementoDeJuegoAAgregar = new ArrayList<ObserverGrafico>();
    	this.labelsElementoDeJuegoARemover = new ArrayList<ObserverGrafico>();
    }
    
    public void cambiarDeNivel() {
    	crearHUD();
    	this.marioJugable.establecerPosicionLogica(new Point(this.posicionOriginalJugable.x, this.posicionOriginalJugable.y + (50 - marioJugable.obtenerAlto())));
    	this.marioJugable.establecerPosicionGrafica(this.marioJugable.obtenerPosicionLogica());
    	this.marioJugable.moverHitbox(posicionOriginalJugable);
    	this.marioLabel.setLocation(this.posicionOriginalLabelJugable.x, this.posicionOriginalLabelJugable.y + (50 - marioJugable.obtenerAlto()));
    	this.marioJugable.establecerDesplazamiento(0);
    	this.revalidate();
    	this.repaint();
    }

	private void removerElementos() {
		for(ObserverGrafico observerGrafico : this.labelsElementoDeJuego) {
			layeredPane.remove(observerGrafico);
		}
	}
    
	//TODO ven esto mal?, porque en vez de usar un obtener hud y perdirle el tiempo lo llamo directo de la pantalla de juego
	public boolean obtenterTiempoEnCero() {
		return this.hud.obtenerTiempoEnCero();
	}
    
}