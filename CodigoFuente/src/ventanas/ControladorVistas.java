package ventanas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
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
	
	private Jugable marioJugable;
	
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
	
	private static int DURACION_PANTALLA_ENTRE_NIVELES = 3000;
	
	public ControladorVistas(Juego juego){
		this.sensorDeTeclasMenu = new SensorDeTeclasMenu();
		this.juego = juego;
		configurarVentana();
		RegistrarOyenteInicial();	
		bucleVentana = new BucleVentana(this);
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
	
	@SuppressWarnings("exports")
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
	
	public void configurarVentana(){
		ventana = new JFrame("Super Mario Bros");
		ventana.setIconImage(new ImageIcon(getClass().getResource("/imagenes/icono.png")).getImage());
		ventana.setVisible(true);
		accionarPantallaInicial();
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setResizable(false);
		ventana.setSize(ConstantesGlobales.VENTANA_ANCHO, ConstantesGlobales.VENTANA_ALTO);
		ventana.setLocationRelativeTo(null);
		ventana.pack();
		ventana.setVisible(true);
		ventana.addWindowListener(new WindowAdapter() { 
			@SuppressWarnings("unused")
			public void  WindowClosing (WindowEvent e) {
				juego.cierreDeJuego();
			}	
		});
	}
	
	public void accionarInicioJuego(String modo) {
		this.pantallaDeJuego = new PantallaDeJuego();
		this.sensorDeTeclasJuego = new SensorDeTeclasJuego();
		this.pantallaIngresoNombre = new PantallaIngresoNombre(this, modo);
	    marioJugable = juego.crearPartida(sensorDeTeclasJuego, modo);
	    this.pantallaEntreNiveles = new PantallaEntreNiveles(juego.obtenerSpriteMario()); 
	    pantallaDeJuego.registrarJugable(marioJugable);
	    RegistrarOyenteJuego();	    
	    
	    mostrarPantallaEntreNiveles();
	    pantallaEntreNiveles.actualizarVidas(marioJugable.obtenerVidas());
	    pantallaEntreNiveles.actualizarPuntaje(marioJugable.obtenerPuntos());
	    pantallaEntreNiveles.actualizarNivel(marioJugable.obtenerNivel().obtenerNumeroNivel());
	    Timer timer = new Timer(DURACION_PANTALLA_ENTRE_NIVELES, new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	            mostrarPantallaDeJuego();
	        }
	    });
	    timer.setRepeats(false);
	    timer.start();
	}

	private void actualizarVentana(Pantalla pantalla) {
		ventana.setContentPane(pantalla);
		this.panelActual = pantalla;
		ventana.revalidate();
		ventana.repaint();
	}
	
	public void mostrarPantallaEntreNiveles(){
		this.actualizarVentana(pantallaEntreNiveles);
		this.juego.obtenerPartida().desactivarMovimientoEnemigos();
		this.juego.obtenerPartida().desactivarMovimientoPersonaje();
	}
	
	public void RegistrarOyenteInicial(){
		ventana.addKeyListener(sensorDeTeclasMenu);
	}
	
	public void RegistrarOyenteJuego(){
		ventana.removeKeyListener(sensorDeTeclasMenu);
		ventana.addKeyListener(sensorDeTeclasJuego);
		ventana.requestFocusInWindow();
	}
	
	public void mostrarPantallaDeJuego() {
		actualizarVentana(pantallaDeJuego);
		this.juego.obtenerPartida().activarMovimientoEnemigos();
		this.juego.obtenerPartida().activarMovimientoPersonaje();
	}
	
	public void accionarPantallaFinal() {
		this.pantallaFinal = new PantallaFinal(this, sensorDeTeclasMenu);
	    pantallaFinal.establecerEnFoco(true);
	    pantallaFinal.puntajeJugador(juego.obtenerPartida().obtenerJugable().obtenerPuntos());
	    actualizarVentana(pantallaFinal);
	}

	public void mostrarPantallaInicial() {
		pantallaInicial.setVisible(true);
	    ventana.revalidate();
	    ventana.repaint();
	}
	
	public void accionarPantallaInicial(){
		this.pantallaInicial =  new PantallaInicial(sensorDeTeclasMenu, this);
		ventana.add(pantallaInicial);
		ventana.setContentPane(pantallaInicial);
		this.panelActual = pantallaInicial;
	}
	
	public void ocultarPantallaInicial(){
		ventana.remove(pantallaInicial);
		ventana.revalidate();
		ventana.repaint();
	}
	
	public void mostrarPantallaRanking() {
		this.pantallaRanking = new PantallaRanking(juego.obtenerRanking().obtenerTopRanking(), sensorDeTeclasMenu,this);
		pantallaInicial.establecerEnFoco(false);
		actualizarVentana(pantallaRanking);
	}
	
	public void dePantallaRankingAPantallaInicial(){
		pantallaRanking.establecerEnFoco(false);
		pantallaInicial.establecerEnFoco(true);
		actualizarVentana(pantallaInicial);
	}
	
	public void dePantallaFinalAPantallaInicial() {
	    pantallaFinal.establecerEnFoco(false);
	    pantallaInicial.establecerEnFoco(true);
	    ventana.setContentPane(pantallaInicial);
	    this.panelActual = pantallaInicial;
	    ventana.removeKeyListener(sensorDeTeclasJuego); 
	    ventana.requestFocusInWindow();
	    ventana.revalidate();
	    ventana.repaint();
	    ventana.addKeyListener(sensorDeTeclasMenu);      
	}

	public void ocultarPantallaRanking(){
		ventana.remove(pantallaRanking);
		ventana.revalidate();
		ventana.repaint();
	}
	
	public void accionarPantallaIngresoNombre() {
		actualizarVentana(pantallaIngresoNombre);
		pantallaIngresoNombre.requestFocusInWindow();
		pantallaIngresoNombre.solicitarFocoCampoTexto();
	}
	
	public void refrescar() {
		if (panelActual.esRefrescable()) {
			panelActual.refrescar();
			ventana.requestFocusInWindow();
			ventana.revalidate();
		    ventana.repaint();
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
		pantallaEntreNiveles.actualizarVidas(marioJugable.obtenerVidas());
	    pantallaEntreNiveles.actualizarPuntaje(marioJugable.obtenerPuntos());
     	pantallaEntreNiveles.actualizarNivel(marioJugable.obtenerNivel().obtenerNumeroNivel());
		pantallaDeJuego.cambiarDeNivel();
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
		juego.cierreDeJuego();
	}
}
