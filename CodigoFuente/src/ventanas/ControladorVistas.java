package ventanas;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.Timer;

import elementos.entidades.Jugable;
import juego.*;
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
	
	protected Juego juego;	

	
	public ControladorVistas(Juego juego){
		sensorDeTeclasMenu = new SensorDeTeclasMenu();
		pantallaInicial= new PantallaInicial(sensorDeTeclasMenu, this);
		pantallaFinal= new PantallaFinal();
		sensorDeTeclasJuego = new SensorDeTeclasJuego();
		pantallaDeJuego= new PantallaDeJuego();
		this.juego = juego;
		pantallaEntreNiveles= new PantallaEntreNiveles(juego.obtenerSpriteMario()); 
		
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
	}
	
	public void accionarInicioJuego(String modo) {
		RegistrarOyenteJuego();
		ventana.remove(pantallaInicial);
		mostrarPantallaEntreNiveles();
		
		marioJugable = juego.crearPartida(sensorDeTeclasJuego, modo);
		pantallaDeJuego.registrarJugable(marioJugable);
     	
		//TODO ese 0 deberia ser 2000 pero no quiero q este tanto la pantalla
		Timer timer = new Timer(0, new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	ventana.remove(pantallaEntreNiveles);
	                mostrarPantallaDeJuego();
	                
	            }
	        });
	        timer.setRepeats(false);
	        timer.start(); 
	        
	       
	}
	
	public void mostrarPantallaEntreNiveles(){
		ventana.add(pantallaEntreNiveles);
	}
	
	public void RegistrarOyenteInicial(){
		ventana.addKeyListener(sensorDeTeclasMenu);
	}
	
	public void RegistrarOyenteJuego(){
		ventana.removeKeyListener(sensorDeTeclasMenu);
		ventana.addKeyListener(sensorDeTeclasJuego);
		ventana.requestFocusInWindow();
	}

	
	public void accionarPantallaPuntajes() {
		
	}
	
	public void accionarPantallaEntreNiveles(){
		ventana.add(pantallaEntreNiveles);
		pantallaEntreNiveles.setVisible(true);
	}

	
	public void accionarPantallaModoDeJuego() {
		
	}


	public void cambiarModoDeJuego() {
		
	}
	
	public void mostrarPantallaDeJuego() {
		 ventana.add(pantallaDeJuego);		
	}
	
	public void mostrarPantallaFinal() {
		ventana.setContentPane(pantallaFinal);
		
	}

	public void mostrarPantallaInicial() {
		ventana.setContentPane(pantallaInicial);
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
	
	public void cambiarNivel() {
		//TODO
	}

}
