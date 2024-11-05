package ventanas;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import fuentes.Fuente;
import juego.ConstantesGlobales;
import sensoresDeTeclas.SensorDeTeclasMenu;

@SuppressWarnings("serial")
public class PantallaInicial extends Pantalla {
	
	private static final int CANTIDAD_BOTONES = 3;
	
	protected JLabel fondo;
	
	protected JLabel botonModo1;
	
	protected JLabel botonModo2;
	
	protected JLabel botonEnfocado;
	
	protected JLabel botonRanking;

	protected SensorDeTeclasMenu sensor;
	
	private ArregloDeBotones arregloDeBotones;
	
	protected Dimension size = new Dimension(ConstantesGlobales.PANEL_ANCHO, ConstantesGlobales.PANEL_ALTO);
	
	protected ControladorVistas controlador;
	
	Fuente tipoFuentes;
	
	private String modo;
	
	private boolean enFoco;
	
	@SuppressWarnings("exports")
	public PantallaInicial(SensorDeTeclasMenu sensor, ControladorVistas controladorVistas){
		this.enFoco = true;
		this.controlador =  controladorVistas;
		this.sensor = sensor;
		this.fondo = new JLabel();
		botonModo1 = new JLabel("MODO ORIGINAL");
		botonModo2 = new JLabel("MODO ALTERNATIVO"); 
		botonRanking =  new JLabel("RANKING");
		inicializarArregloDeBotones();
		configurarFuente();
		configurarVentana();
		ajustarDisposicion();
		registrarOyenteTeclas();
	}
	
	protected void inicializarArregloDeBotones() {
		arregloDeBotones = new ArregloDeBotones(CANTIDAD_BOTONES);
		arregloDeBotones.agregar(botonModo1);
		arregloDeBotones.agregar(botonModo2);
		arregloDeBotones.agregar(botonRanking);
	}
	
	protected void configurarFuente() {
		tipoFuentes =  new Fuente();
	    botonModo1.setFont(tipoFuentes.fuente(tipoFuentes.pxl, 0, ConstantesGlobales.PANEL_ANCHO / 30));
	    botonModo2.setFont(tipoFuentes.fuente(tipoFuentes.pxl, 0, ConstantesGlobales.PANEL_ANCHO / 30));
	    botonRanking.setFont(tipoFuentes.fuente(tipoFuentes.pxl, 0, ConstantesGlobales.PANEL_ANCHO / 30));
	    botonModo1.setForeground(Color.WHITE);
	    botonModo2.setForeground(Color.WHITE);
	    botonRanking.setForeground(Color.WHITE);
	    botonEnfocado = botonModo1;
	    arregloDeBotones.siguiente();
	    botonEnfocado.setForeground(Color.DARK_GRAY);
	}
	
	protected void configurarVentana(){
		new JPanel();
		setLayout(null);
		setPreferredSize(size);
		setMaximumSize(size);
		setMinimumSize(size);
		setBounds(0, 0, size.width * 2, size.height);
		establecerFondo();
	}
	
	protected void establecerFondo(){
		 ImageIcon fondoImagen = new ImageIcon("src/imagenes/fondos/fondoModoOriginal/fondoMenuPrincipal.png");
		 
		 fondo = new JLabel(fondoImagen);
		 fondo.setPreferredSize(size);
		 fondo.setMaximumSize(size);
		 fondo.setMinimumSize(size);
		 add(fondo);
	}
	
	
	protected void ajustarDisposicion(){
		botonModo1.setBounds((size.width - botonModo1.getPreferredSize().width) / 2, (size.height / 2) - 30, botonModo1.getPreferredSize().width, botonModo1.getPreferredSize().height);
		botonModo2.setBounds((size.width - botonModo2.getPreferredSize().width) / 2, (size.height / 2) + 30, botonModo2.getPreferredSize().width, botonModo2.getPreferredSize().height);
		botonRanking.setBounds((size.width - botonRanking.getPreferredSize().width) / 2, (size.height / 2) + 90, botonRanking.getPreferredSize().width, botonRanking.getPreferredSize().height);
		fondo.add(botonModo1);
		fondo.add(botonModo2);
		fondo.add(botonRanking);
		fondo.setBounds(0, 0, size.width, size.height);
	}
	
	private void registrarOyenteTeclas(){
		botonEnfocado.setFocusable(true);
		this.setFocusable(true);
		this.requestFocusInWindow(); 
		addKeyListener(sensor);
	}
	
	public void establecerEnFoco(boolean condicion){
		this.enFoco =  condicion;
	}
	
	public boolean obtenerEnFoco(){
		return this.enFoco;
	}
	
	 public void refrescar() {
		 if (this.enFoco) {
		 if (this.sensor.obtenerEnterPresionado() && !this.sensor.obtenerEnterAccionada()){
			
			 if (botonEnfocado ==  botonModo1){
				this.controlador.accionarInicioJuego("Modo original");
			 }
			 else if (botonEnfocado ==  botonModo2){
				 this.controlador.accionarInicioJuego("Modo alternativo");
			 } 
			 else if (botonEnfocado ==  botonRanking) {
				 this.controlador.mostrarPantallaRanking();
				 this.sensor.accionarEnter();
			 }
			 
		 }
		 
	        if (this.sensor.obtenerSPresionado() && !sensor.obtenerSAccionada()) {
	        	this.botonEnfocado.setForeground(Color.WHITE);
	        	this.botonEnfocado = arregloDeBotones.siguiente();
	        	this. botonEnfocado.setForeground(Color.DARK_GRAY);
	        	this.sensor.accionarS();
	        } else if (sensor.obtenerWPresionado()  && !sensor.obtenerWAccionada()) {
	        	this.botonEnfocado.setForeground(Color.WHITE);
	        	this.botonEnfocado = arregloDeBotones.previo();
	        	this.botonEnfocado.setForeground(Color.DARK_GRAY);
	        	this.sensor.accionarW();
	        }
		 }
	       
    }
	 
	 
	public void guardarModo(String modo) {
		this.modo = modo;
	}
	
	public String obtenerModo() {
		return modo;
	}
	
}