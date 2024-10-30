package ventanas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import fuentes.Fuentes;
import sensoresDeTeclas.SensorDeTeclasMenu;

@SuppressWarnings("serial")
public class PantallaInicial extends JPanel {
	
	private static final int CANTIDAD_BOTONES = 3;
	
	protected JLabel fondo;
	
	protected JLabel modo1;
	
	protected JLabel modo2;
	
	protected JLabel currentLabel;
	
	protected JLabel ranking;

	protected SensorDeTeclasMenu sensor;
	
	private ArregloDeBotones arregloDeBotones;
	
	protected Dimension size = new Dimension(ConstantesGlobales.PANEL_ANCHO, ConstantesGlobales.PANEL_ALTO);
	
	protected ControladorVistas controlador;
	
	Fuentes tipoFuentes;
	
	private String modo;
	
	private boolean enFoco;
	
	@SuppressWarnings("exports")
	public PantallaInicial(SensorDeTeclasMenu sensor, ControladorVistas controladorVistas){
		this.enFoco = true;
		this.controlador= controladorVistas;
		this.sensor = sensor;
		this.fondo = new JLabel();
		modo1 = new JLabel("MODO DE JUEGO 1");
		modo2 = new JLabel("MODO DE JUEGO 2"); 
		ranking= new JLabel("RANKING");
		inicializarArregloDeBotones();
		configurarFuente();
		configurarVentana();
		ajustarDisposicion();
		registrarOyenteTeclas();
	}
	
	protected void ajustarDisposicion(){
		modo1.setBounds((size.width - modo1.getPreferredSize().width) / 2, (size.height / 2) - 30, modo1.getPreferredSize().width, modo1.getPreferredSize().height);
        modo2.setBounds((size.width - modo2.getPreferredSize().width) / 2, (size.height / 2) + 30, modo2.getPreferredSize().width, modo2.getPreferredSize().height);
        ranking.setBounds((size.width - ranking.getPreferredSize().width) / 2, (size.height / 2) + 90, ranking.getPreferredSize().width, ranking.getPreferredSize().height);
        fondo.add(modo1);
        fondo.add(modo2);
        fondo.add(ranking);
        fondo.setBounds(0, 0, size.width, size.height);
	}
	
	protected void registrarOyenteTeclas(){
		currentLabel.setFocusable(true);
		this.setFocusable(true);
	    this.requestFocusInWindow(); 
	    addKeyListener(sensor);
	}
	
	public void configurarFuente() {
		tipoFuentes= new Fuentes();
	    modo1.setFont(tipoFuentes.fuente(tipoFuentes.pxl, 0, ConstantesGlobales.PANEL_ANCHO / 30));
	    modo2.setFont(tipoFuentes.fuente(tipoFuentes.pxl, 0, ConstantesGlobales.PANEL_ANCHO / 30));
	    ranking.setFont(tipoFuentes.fuente(tipoFuentes.pxl, 0, ConstantesGlobales.PANEL_ANCHO / 30));
	    modo1.setForeground(Color.WHITE);
	    modo2.setForeground(Color.WHITE);
	    ranking.setForeground(Color.WHITE);
	    currentLabel = modo1;
	    arregloDeBotones.siguiente();
	    currentLabel.setForeground(Color.DARK_GRAY);
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
	
	private void inicializarArregloDeBotones() {
		arregloDeBotones = new ArregloDeBotones(CANTIDAD_BOTONES);
		arregloDeBotones.agregar(modo1);
		arregloDeBotones.agregar(modo2);
		arregloDeBotones.agregar(ranking);
	}
	
	 public void actualizarFoco() {
		 if(enFoco) {
		 if(sensor.obtenerEnterPresionado() && !sensor.obtenerEnterAccionada()){
			
			 if(currentLabel == modo1){
				controlador.accionarInicioJuego("Modo original");
			 }
			 else if(currentLabel == modo2){
				 controlador.accionarInicioJuego("Modo alternativo");
			 } 
			 else if(currentLabel == ranking) {
				 controlador.mostrarPantallaRanking();
				 sensor.accionarEnter();
			 }
			 
		 }
		 
	        if (sensor.obtenerSPresionado() && !sensor.obtenerSAccionada()) {
	            currentLabel.setForeground(Color.WHITE);
	            currentLabel = arregloDeBotones.siguiente();
	            currentLabel.setForeground(Color.DARK_GRAY);
	            sensor.accionarS();
	        } else if (sensor.obtenerWPresionado()  && !sensor.obtenerWAccionada()) {
	            currentLabel.setForeground(Color.WHITE);
	            currentLabel = arregloDeBotones.previo();
	            currentLabel.setForeground(Color.DARK_GRAY);
	            sensor.accionarW();
	        }
		 }
	       
    }
	 
	 public void establecerEnFoco(boolean condicion){
	    	this.enFoco= condicion;
	    }
	    
	 public boolean obtenerEnFoco(){
	    	return this.enFoco;
	 }
	 
	public void guardarModo (String modo) {
		this.modo = modo;
	}
	
	public String obtenerModo() {
		return modo;
	}
	
}
