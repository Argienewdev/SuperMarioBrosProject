package ventanas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.Timer;
import elementos.entidades.Jugable;
import juego.*;
import ranking.Ranking;
import sensoresDeTeclas.SensorDeTeclasJuego;
import sensoresDeTeclas.SensorDeTeclasMenu;

public class ControladorVistas {
	
	private JFrame ventana;
	
	private Jugable jugable;
	
	private PantallaDeJuego pantallaDeJuego;
	
	private PantallaFinal pantallaFinal;
	
	private PantallaInicial pantallaInicial;
	
	private SensorDeTeclasMenu sensorDeTeclasMenu;
	
	private SensorDeTeclasJuego sensorDeTeclasJuego;
	
	private PantallaEntreNiveles pantallaEntreNiveles;
	
	private PantallaRanking pantallaRanking;
	
	private PantallaIngresoNombre pantallaIngresoNombre;
	
	@SuppressWarnings("unused")
	private BucleVentana bucleVentana;
	
	private Juego juego;
	
	private Pantalla panelActual;
	
	private static final int DURACION_PANTALLA_ENTRE_NIVELES = 3000;
	
	public ControladorVistas(Juego juego){
		this.sensorDeTeclasMenu = new SensorDeTeclasMenu();
		this.juego = juego;
		configurarVentana();
		registrarOyenteInicial();	
		this.bucleVentana = new BucleVentana(this);
	}
	
	public void establecerPanelActual (Pantalla panelActual) {
		this.panelActual = panelActual;
	}
	public PantallaDeJuego obtenerPantallaDeJuego() {
		return this.pantallaDeJuego;
	}
	
	public PantallaFinal obtenerPantallaFinal() {
		return pantallaFinal;
	}
	
	public Ranking obtenerRanking() {
		return juego.obtenerRanking();
	}
	
	public PantallaIngresoNombre obtenerPantallaIngresoNombre() {
		return pantallaIngresoNombre;
	}
	
	
	public InterfazJuego obtenerHUD() {
		return this.pantallaDeJuego.obtenerHUD();
	}
	
	public Juego obtenerJuego() {
		return this.juego;
	}
	
	public int obtenerDuracionPantallaEntreNiveles(){
		return DURACION_PANTALLA_ENTRE_NIVELES;
	}
	
	protected void configurarVentana(){
		this.ventana = new JFrame("Super Mario Bros");
		this.ventana.setIconImage(new ImageIcon(getClass().getResource("/imagenes/icono.png")).getImage());
		this.ventana.setVisible(true);
		accionarPantallaInicial();
		this.ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.ventana.setResizable(false);
		this.ventana.setSize(ConstantesGlobales.VENTANA_ANCHO, ConstantesGlobales.VENTANA_ALTO);
		this.ventana.setLocationRelativeTo(null);
		this.ventana.pack();
		this.ventana.setVisible(true);
	}
	
	protected void registrarOyenteInicial(){
		this.ventana.addKeyListener(sensorDeTeclasMenu);
	}
	
	protected void registrarOyenteJuego(){
		this.ventana.removeKeyListener(sensorDeTeclasMenu);
		this.ventana.addKeyListener(sensorDeTeclasJuego);
		this.ventana.requestFocusInWindow();
	}

	private void actualizarVentana(Pantalla pantalla) {
		this.ventana.setContentPane(pantalla);
		this.panelActual = pantalla;
		this.ventana.revalidate();
		this.ventana.repaint();
	}
	
	protected void accionarInicioJuego(String modo) {
		this.pantallaDeJuego = new PantallaDeJuego();
		this.sensorDeTeclasJuego = new SensorDeTeclasJuego();
		this.pantallaIngresoNombre = new PantallaIngresoNombre(this, modo);
		this.jugable = juego.crearPartida(this.sensorDeTeclasJuego, modo);
		this.pantallaEntreNiveles = new PantallaEntreNiveles(this.juego.obtenerSpriteMario()); 
		this.pantallaDeJuego.registrarJugable(this.jugable);
		this.registrarOyenteJuego();	    
		this.mostrarPantallaEntreNiveles();
		this.pantallaEntreNiveles.actualizarVidas(this.jugable.obtenerVidas());
		this.pantallaEntreNiveles.actualizarPuntaje(this.jugable.obtenerPuntos());
		this.pantallaEntreNiveles.actualizarNivel(this.jugable.obtenerNivel().obtenerNumeroNivel());
		Timer timer = new Timer(DURACION_PANTALLA_ENTRE_NIVELES, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarPantallaDeJuego();
			}
		});
		timer.setRepeats(false);
		timer.start();
	}
	
	public void accionarPantallaFinal() {
		this.pantallaFinal = new PantallaFinal(this, sensorDeTeclasMenu);
		this.pantallaFinal.establecerEnFoco(true);
		this.pantallaFinal.puntajeJugador(juego.obtenerPartida().obtenerJugable().obtenerPuntos());
		this.actualizarVentana(pantallaFinal);
	}

	public void accionarPantallaIngresoNombre() {
		this.actualizarVentana(pantallaIngresoNombre);
		this.pantallaIngresoNombre.requestFocusInWindow();
		this.pantallaIngresoNombre.solicitarFocoCampoTexto();
	}
	
	public void accionarPantallaInicial(){
		this.pantallaInicial =  new PantallaInicial(sensorDeTeclasMenu, this);
		this.ventana.add(pantallaInicial);
		this.ventana.setContentPane(pantallaInicial);
		this.panelActual = pantallaInicial;
	}

	public void mostrarPantallaEntreNiveles(){
		this.actualizarVentana(pantallaEntreNiveles);
		this.juego.obtenerPartida().desactivarMovimientoEnemigos();
		this.juego.obtenerPartida().desactivarMovimientoPersonaje();
	}
	
	public void mostrarPantallaDeJuego() {
		this.actualizarVentana(pantallaDeJuego);
		this.juego.obtenerPartida().activarMovimientoEnemigos();
		this.juego.obtenerPartida().activarMovimientoPersonaje();
	}
	
	public void mostrarPantallaInicial() {
		this.pantallaInicial.setVisible(true);
		this.ventana.revalidate();
		this.ventana.repaint();
	}
	
	public void mostrarPantallaFinal() {
		this.pantallaFinal.setVisible(true);
		this.ventana.revalidate();
		this.ventana.repaint();
	}
	
	public void mostrarPantallaIngresoNombre() {
		this.pantallaIngresoNombre.setVisible(true);
		this.ventana.revalidate();
		this.ventana.repaint();
	}
	
	public void mostrarPantallaRanking() {
		this.pantallaRanking = new PantallaRanking(juego.obtenerRanking().obtenerTopRanking(), sensorDeTeclasMenu,this);
		this.pantallaInicial.establecerEnFoco(false);
		actualizarVentana(pantallaRanking);
	}
	
	public void ocultarPantallaInicial(){
		this.ventana.remove(pantallaInicial);
		this.ventana.revalidate();
		this.ventana.repaint();
	}
	
	public void ocultarPantallaRanking(){
		this.ventana.remove(pantallaRanking);
		this.ventana.revalidate();
		this.ventana.repaint();
	}
	
	public void dePantallaRankingAPantallaInicial(){
		this.pantallaRanking.establecerEnFoco(false);
		this.pantallaInicial.establecerEnFoco(true);
		actualizarVentana(pantallaInicial);
	}
	
	public void dePantallaFinalAPantallaInicial() {
		this.pantallaFinal.establecerEnFoco(false);
		this.pantallaInicial.establecerEnFoco(true);
		this.ventana.setContentPane(pantallaInicial);
	    this.panelActual = pantallaInicial;
	    this.ventana.removeKeyListener(sensorDeTeclasJuego); 
	    this.ventana.requestFocusInWindow();
	    this.ventana.revalidate();
	    this.ventana.repaint();
	    this.ventana.addKeyListener(sensorDeTeclasMenu);      
	}

	public void refrescar() {
		if (this.panelActual.esRefrescable()) {
			this.panelActual.refrescar();
			this.ventana.requestFocusInWindow();
			this.ventana.revalidate();
			this.ventana.repaint();
		}
	}
	
	public void eliminarNivelActual() {
		this.pantallaDeJuego.eliminarNivelActual();
	}
	
	public void reiniciarNivel() {
		cambiarNivel();
	}
	
	public void cambiarNivel() {
		mostrarPantallaEntreNiveles();
		this.pantallaEntreNiveles.actualizarVidas(jugable.obtenerVidas());
		this.pantallaEntreNiveles.actualizarPuntaje(jugable.obtenerPuntos());
		this.pantallaEntreNiveles.actualizarNivel(jugable.obtenerNivel().obtenerNumeroNivel());
		this.pantallaDeJuego.cambiarDeNivel();
		ActionListener listener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarPantallaDeJuego();
            }
		};
		Timer timer = new Timer(DURACION_PANTALLA_ENTRE_NIVELES, listener);
        timer.setRepeats(false);
        timer.start();  
	}
	
	public void cerrarJuego() {
		this.juego.cierreDeJuego();
	}
}
