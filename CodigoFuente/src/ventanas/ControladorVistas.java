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
		//TODO cuando apretas enter en la pantalla de ranking se sigue actualizando la pantalla inicial y escucha el
		//enter. La solucion seria ponerle una bandera a todas las pantallas que se llame enfocada y que sea verdadera
		//o falsa según sea necesario. Modificar esas banderas es responsabilidad del controlador de vistas. 
		this.sensorDeTeclasMenu = new SensorDeTeclasMenu();
		this.pantallaInicial= new PantallaInicial(sensorDeTeclasMenu, this);
		this.sensorDeTeclasJuego = new SensorDeTeclasJuego();
		this.pantallaDeJuego = new PantallaDeJuego();
		this.juego = juego;
		this.pantallaEntreNiveles = new PantallaEntreNiveles(juego.obtenerSpriteMario()); 
		this.pantallaRanking = new PantallaRanking(juego.obtenerRanking().obtenerTopRanking(),sensorDeTeclasMenu,this);
		this.pantallaFinal= new PantallaFinal(this);
		this.pantallaIngresoNombre = new PantallaIngresoNombre(this);
		
		configurarVentana();
		RegistrarOyenteInicial();	
	}
	
	public void configurarVentana(){
		ventana = new JFrame("Super Mario Bros");
		ventana.setIconImage(new ImageIcon(getClass().getResource("/imagenes/icono.png")).getImage());
		ventana.setVisible(true);
		accionarPantallaInicial();
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setResizable(false);
		ventana.setSize(DimensionesConstantes.VENTANA_ANCHO, DimensionesConstantes.VENTANA_ALTO);
		ventana.setLocationRelativeTo(null);
		ventana.pack();
		ventana.setVisible(true);
		ventana.addWindowListener(new WindowAdapter() { 
			public void  windowClosing (WindowEvent e) {
				//juego.cierreDeJuego();
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
	
	public void mostrarPantallaDeJuego() {
		ventana.setContentPane(pantallaDeJuego);
		ventana.revalidate();
	    ventana.repaint();	
	}
	
	public void mostrarPantallaFinal() {
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
		ventana.setContentPane(pantallaRanking); 
		ventana.repaint();
		ventana.revalidate();
	}
	
	public void hacerCambio(){
		ventana.setContentPane(pantallaInicial);
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
		if(ventana.getKeyListeners()[0] == sensorDeTeclasMenu) {
			pantallaInicial.actualizarFoco();
			if(ventana.isAncestorOf(pantallaRanking)) {
				pantallaRanking.refrescar();
				ventana.requestFocusInWindow();
			}
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
		ActionListener listener;
		int duracionAnimacionBandera = 0;
		listener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
		};
		Timer timerAnimacionFinDeNivel = new Timer(duracionAnimacionBandera, listener);
		timerAnimacionFinDeNivel.setRepeats(false);
		timerAnimacionFinDeNivel.start();
		
		
		
		int duracionPantallaEntreNiveles = 0;
		mostrarPantallaEntreNiveles();
		pantallaEntreNiveles.actualizarVidas(marioJugable.getVidas());
	    pantallaEntreNiveles.actualizarPuntaje(marioJugable.getPuntos());
		pantallaDeJuego.cambiarDeNivel();
		listener = new ActionListener() {
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

}
