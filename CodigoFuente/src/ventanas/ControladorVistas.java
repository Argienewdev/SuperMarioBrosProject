package ventanas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

import elementos.personajes.ContextoMario;
import juego.*;
import ranking.Jugador;
import ranking.Ranking;
import sensoresDeTeclas.SensorDeTeclasJuego;
import sensoresDeTeclas.SensorDeTeclasMenu;

public class ControladorVistas {
	
	private JFrame ventana;
	
	private ContextoMario marioJugable;
	
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
	
	public ControladorVistas(Juego juego){
		
		this.sensorDeTeclasMenu = new SensorDeTeclasMenu();
		this.pantallaInicial= new PantallaInicial(sensorDeTeclasMenu, this);
		this.sensorDeTeclasJuego = new SensorDeTeclasJuego();
		this.juego = juego;
		this.pantallaRanking = new PantallaRanking(juego.obtenerRanking().obtenerTopRanking(),sensorDeTeclasMenu,this);
		this.pantallaFinal = new PantallaFinal(this, sensorDeTeclasMenu);
		
		configurarVentana();
		RegistrarOyenteInicial();	
		bucleVentana = new BucleVentana(this);
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
		int duracionDePantallaEntreNiveles = 2000;
		
		this.pantallaDeJuego = new PantallaDeJuego();
		this.pantallaIngresoNombre = new PantallaIngresoNombre(this, modo);
	    RegistrarOyenteJuego();
	    	    
	    marioJugable = juego.crearPartida(sensorDeTeclasJuego, modo);
	    this.pantallaEntreNiveles = new PantallaEntreNiveles(juego.obtenerSpriteMario()); 
	    pantallaDeJuego.registrarJugable(marioJugable);
	    
	    mostrarPantallaEntreNiveles();
	    pantallaEntreNiveles.actualizarVidas(marioJugable.obtenerVidas());
	    pantallaEntreNiveles.actualizarPuntaje(marioJugable.obtenerPuntos());
	    pantallaEntreNiveles.actualizarNivel(marioJugable.obtenerNivel().obtenerNumeroNivel());
	    Timer timer = new Timer(duracionDePantallaEntreNiveles, new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            mostrarPantallaDeJuego();
	        }
	    });
	    timer.setRepeats(false);
	    timer.start();
	}

	
	public void mostrarPantallaEntreNiveles(){
		ventana.setContentPane(pantallaEntreNiveles);
		ventana.revalidate();
	    ventana.repaint();	
	}
	
	public void RegistrarOyenteInicial(){
		ventana.addKeyListener(sensorDeTeclasMenu);
	}
	
	public void RegistrarOyenteJuego(){
		ventana.removeKeyListener(sensorDeTeclasMenu);
		ventana.addKeyListener(sensorDeTeclasJuego);
		ventana.requestFocusInWindow();
	}
	
	public void accionarPantallaRanking() {
		ventana.setContentPane(pantallaRanking);
	    ventana.revalidate();
	    ventana.repaint();	
	}
	
	public void mostrarPantallaDeJuego() {
		ventana.setContentPane(pantallaDeJuego);
		ventana.revalidate();
	    ventana.repaint();	
	}
	
	public void accionarPantallaFinal() {
	    pantallaFinal.establecerEnFoco(true);
	    pantallaFinal.puntajeJugador(juego.obtenerJugador().obtenerPuntaje());
	    ventana.setContentPane(pantallaFinal);
	    ventana.revalidate();
	    ventana.repaint();
		
	}

	public void mostrarPantallaInicial() {
		pantallaInicial.setVisible(true);
	    ventana.revalidate();
	    ventana.repaint();
	}
	
	public void accionarPantallaInicial(){
		ventana.add(pantallaInicial);
		ventana.setContentPane(pantallaInicial);
	}
	
	public void ocultarPantallaInicial(){
		ventana.remove(pantallaInicial);
		ventana.revalidate();
		ventana.repaint();
	}
	
	public void mostrarPantallaRanking() {
		pantallaInicial.establecerEnFoco(false);
		ventana.setContentPane(pantallaRanking); 
		ventana.repaint();
		ventana.revalidate();
	}
	
	public void dePantallaRankingAPantallaInicial(){
		pantallaRanking.establecerEnFoco(false);
		pantallaInicial.establecerEnFoco(true);
		ventana.setContentPane(pantallaInicial);
		ventana.revalidate();
		ventana.repaint();
	}
	
	public void dePantallaFinalAPantallaInicial() {
	    pantallaFinal.establecerEnFoco(false);
	    pantallaInicial.establecerEnFoco(true);
	    ventana.setContentPane(pantallaInicial);
	    ventana.removeKeyListener(sensorDeTeclasJuego); 
	    ventana.addKeyListener(sensorDeTeclasMenu);      
	    ventana.requestFocusInWindow();
	    ventana.revalidate();
	    ventana.repaint();
	}

	
	public void ocultarPantallaRanking(){
		ventana.remove(pantallaRanking);
		ventana.revalidate();
		ventana.repaint();
	}
	
	public void accionarPantallaIngresoNombre() {
		ventana.setContentPane(pantallaIngresoNombre);
		ventana.revalidate();
		ventana.repaint();
		SwingUtilities.invokeLater(() -> pantallaIngresoNombre.solicitarFocoCampoTexto());
	}
	
	public void refrescar() {
	    if (ventana.getKeyListeners()[0] == sensorDeTeclasMenu) {
	        pantallaInicial.actualizarFoco();
	        if (ventana.getContentPane() == pantallaRanking) {
	            pantallaRanking.refrescar();
	        }
	        ventana.requestFocusInWindow();
	    } else {
	        if (ventana.getContentPane() == pantallaDeJuego) {
	            pantallaDeJuego.refrescar();
	        } 
	         else if (ventana.getContentPane() == pantallaFinal) {
	            pantallaFinal.establecerEnFoco(true);
	            ventana.requestFocusInWindow();
	        }
	    }
	    ventana.revalidate();
	    ventana.repaint();
	}

	
	public PantallaDeJuego obtenerPantallaDeJuego() {
		return this.pantallaDeJuego;
	}
	
	public void eliminarNivelActual() {
		this.pantallaDeJuego.eliminarNivelActual();
	}
	
	public void reiniciarNivel() {
		cambiarNivel();
	}
	
	public void cambiarNivel() {
		int duracionPantallaEntreNiveles = 2000;
		
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
		Timer timer = new Timer(duracionPantallaEntreNiveles, listener);
        timer.setRepeats(false);
        timer.start();  
	}
	
	public void cerrarJuego() {
		juego.cierreDeJuego();
	}
	
	@SuppressWarnings("exports")
	public Ranking obtenerRanking() {
		return juego.obtenerRanking();
	}

	@SuppressWarnings("exports")
	public void establecerJugador (Jugador jugador) {
		pantallaIngresoNombre.establecerJugador(jugador);
	}
	
	public PantallaFinal obtenerPantallaFinal() {
		return pantallaFinal;
	}
	
	public PantallaIngresoNombre obtenerPantallaIngresoNombre() {
		return pantallaIngresoNombre;
	}

}
