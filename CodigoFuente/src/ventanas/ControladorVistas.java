package ventanas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

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
	
	private Juego juego;
	
	public ControladorVistas(Juego juego){
		sensorDeTeclasMenu = new SensorDeTeclasMenu();
		pantallaInicial= new PantallaInicial(sensorDeTeclasMenu, this);
		sensorDeTeclasJuego = new SensorDeTeclasJuego();
		pantallaDeJuego = new PantallaDeJuego();
		this.juego = juego;
		pantallaEntreNiveles = new PantallaEntreNiveles(juego.obtenerSpriteMario()); 
		pantallaRanking = new PantallaRanking(juego.obtenerRanking().obtenerTopRanking());
		pantallaFinal= new PantallaFinal(this);
		pantallaIngresoNombre = new PantallaIngresoNombre(this);
		configurarVentana();
		RegistrarOyenteInicial();	
	}
	
	public void configurarVentana(){
		ventana = new JFrame("Super Mario Bros");
		ventana.setIconImage(new ImageIcon(getClass().getResource("/imagenes/icono.png")).getImage());
		ventana.setVisible(true);
		ventana.add(pantallaInicial);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setResizable(false);
		ventana.setSize(DimensionesConstantes.VENTANA_ANCHO, DimensionesConstantes.VENTANA_ALTO);
		ventana.setLocationRelativeTo(null);
		ventana.pack();
		ventana.setVisible(true);
		ventana.addWindowListener(new WindowAdapter() { 
			public void  WindowClosing (WindowEvent e) {
				juego.cierreDeJuego();
			}	
		});
	}
		
	public void accionarInicioJuego(String modo) {
		int duracionDePantallaEntreNiveles = 0;
		
	    RegistrarOyenteJuego();
	    	    
	    marioJugable = juego.crearPartida(sensorDeTeclasJuego, modo);
	    pantallaDeJuego.registrarJugable(marioJugable);
	    
	    mostrarPantallaEntreNiveles();
	    pantallaEntreNiveles.actualizarVidas(marioJugable.getVidas());
	    pantallaEntreNiveles.actualizarPuntaje(marioJugable.getPuntos());
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

	
	public void accionarPantallaModoDeJuego() {
		
	}


	public void cambiarModoDeJuego() {
		
	}
	
	public void mostrarPantallaDeJuego() {
		ventana.setContentPane(pantallaDeJuego);
		ventana.revalidate();
	    ventana.repaint();	
	}
	
	public void mostrarPantallaFinal() {
		ventana.setContentPane(pantallaFinal);
	    ventana.revalidate();
	    ventana.repaint();
		
	}

	public void mostrarPantallaInicial() {
		ventana.setContentPane(pantallaInicial);
	    ventana.revalidate();
	    ventana.repaint();
	}
	
	public void mostrarPantallaRanking() {
		ventana.setContentPane(pantallaRanking);
		ventana.revalidate();
		ventana.repaint();
	}
	
	public void accionarPantallaIngresoNombre() {
		ventana.setContentPane(pantallaIngresoNombre);
		ventana.revalidate();
		ventana.repaint();
		SwingUtilities.invokeLater(() -> pantallaIngresoNombre.solicitarFocoCampoTexto());
	}
	
	public void refrescar(){
		if(ventana.getKeyListeners()[0] == sensorDeTeclasMenu) {
			pantallaInicial.actualizarFoco();
		}else {
			pantallaDeJuego.refrescar();
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
		int duracionPantallaEntreNiveles = 1000;
		
		mostrarPantallaEntreNiveles();
		pantallaEntreNiveles.actualizarVidas(marioJugable.getVidas());
	    pantallaEntreNiveles.actualizarPuntaje(marioJugable.getPuntos());
     	
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
	
	public Ranking obtenerRanking() {
		return juego.obtenerRanking();
	}

	public void mostrarPantallaIngresoNombre(int puntaje) {
		// TODO Auto-generated method stub
		
	}
	
	public void establecerJugador (Jugador jugador) {
		pantallaIngresoNombre.establecerJugador(jugador);
	}
	
	public PantallaFinal obtenerPantallaFinal() {
		return pantallaFinal;
	}

}
