package juego;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import javax.swing.JOptionPane;
import javax.swing.Timer;

import elementos.Sprite;
import elementos.personajes.ContextoMario;
import fabricas.FabricaSilueta;
import fabricas.FabricaSprites;
import fabricas.FabricaSpritesModoOriginal;
import generadores.GeneradorDeNivel;
import observers.ObserverLogicoJugable;
import ranking.Jugador;
import ranking.Ranking;
import sensoresDeTeclas.SensorDeTeclasJuego;
import ventanas.ControladorVistas;
import ventanas.PantallaDeJuego;

public class Juego {
			
	private ControladorVistas controladorVistas;
	
	private Partida partida;
		
	private PantallaDeJuego pantallaDeJuego;
	
	private Ranking ranking;
	
	private Jugador jugador;
	
	private String modoDeJuegoSeleccionado;
	
	public Juego() {
		ranking = cargarEstadoRanking();
		//Utilizar solo cuando se quiere establecer un nuevo ranking
		//Unicamente en el primer juego creado, despues volver a comentar
//		ranking.reiniciarRanking();
	}
	
	public Sprite obtenerSpriteMario(){
		return this.partida.obtenerSpriteMario();
	}
	
	public Ranking obtenerRanking() {
		return this.ranking;
	}
	
	public void render() {
		//TICK
	}
	
	public ControladorVistas obtenerControladorVistas() {
		return this.controladorVistas;
	}
	
	public PantallaDeJuego obtenerPantallaDeJuego() {
		return this.pantallaDeJuego;
	}
	
	public String obtenerModoDeJuegoSeleccionado() {
		return this.modoDeJuegoSeleccionado;
	}

	public ContextoMario crearPartida(SensorDeTeclasJuego sensorDeTeclasJuego, String modo) {
		this.modoDeJuegoSeleccionado = modo;
		this.pantallaDeJuego = this.controladorVistas.obtenerPantallaDeJuego();
		this.partida = new Partida(sensorDeTeclasJuego, this);
		ContextoMario jugable = partida.obtenerJugable();
		jugable.establecerObserverLogico(new ObserverLogicoJugable(this));
		return jugable;
	}
	
	public Partida obtenerPartida() {
		return this.partida;
	}
	
	public void finalizarJuego (){
		partida.obtenerGeneradorDeSonidos().detenerMusicaFondo();
		Timer timer = new Timer(3000, new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	            partida.obtenerGeneradorDeSonidos().pierdeJuego();
	        }
	    });
	    timer.setRepeats(false);
	    timer.start();
		jugador = new Jugador();
		jugador.actualizarPuntos(partida.obtenerJugable().obtenerPuntos());
		controladorVistas.establecerJugador(jugador);
		
		BucleJugador bucle =  partida.obtenerBucleJugador();
		bucle.detenerBucleJugador();
		
		controladorVistas.accionarPantallaIngresoNombre();
		String nombreIngresado = controladorVistas.obtenerPantallaIngresoNombre().obtenerNombreJugador();
		jugador.establecerNombre(nombreIngresado);
		
		if (!nombreIngresado.isEmpty()) {
	        controladorVistas.obtenerPantallaIngresoNombre().guardarNombre(nombreIngresado);
	    }

	}
	

	public void establecerControladorVistas(ControladorVistas controladorVistas) {
		this.controladorVistas = controladorVistas;
	}
	
	public void cierreDeJuego() {
		 ranking.guardarEstado();
	     mostrarMensaje("Gracias por jugar!");
	     System.exit(0);
	}
	
	public Ranking cargarEstadoRanking() {
    	Ranking ranking = null;
    	try {
    		FileInputStream fileInputStream = new FileInputStream ("./src/puntos");
    		ObjectInputStream objectInputStream = new ObjectInputStream (fileInputStream);
    		ranking = (Ranking) objectInputStream.readObject();
    		objectInputStream.close();
    	} catch (FileNotFoundException e) {
    		//No hacer nada
    	} catch (IOException e) {
    		e.printStackTrace();
    	} catch (ClassNotFoundException e) {
    		e.printStackTrace();
    	}
    	return ranking;
    }
	
	private void mostrarMensaje(String mensaje) {
		JOptionPane.showMessageDialog(null,mensaje);
	}


	public Jugador obtenerJugador() {
		return jugador;
	}
	
}
