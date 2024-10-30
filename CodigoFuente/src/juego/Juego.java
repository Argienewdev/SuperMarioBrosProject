package juego;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import javax.swing.JOptionPane;
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

	private FabricaSprites fabricaSprites;

	private FabricaSilueta fabricaSilueta;

	private GeneradorDeNivel generadorDeNivel;
		
	private PantallaDeJuego pantallaDeJuego;
	
	private Ranking ranking;
	
	private Jugador jugador;
	
	public Juego() {
		ranking = cargarEstadoRanking();
	}
	
	public Sprite obtenerSpriteMario(){
		return fabricaSprites.obtenerMarioDefaultFrontalQuieto();
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

	public ContextoMario crearPartida(SensorDeTeclasJuego sensorDeTeclasJuego, String modo) {
		this.pantallaDeJuego = this.controladorVistas.obtenerPantallaDeJuego();
		this.generadorDeNivel = new GeneradorDeNivel(modo, pantallaDeJuego, controladorVistas);
		this.fabricaSprites = generadorDeNivel.obtenerFabricaSprites();
		this.fabricaSilueta = generadorDeNivel.obtenerFabricaSilueta();
		this.pantallaDeJuego.registrarFondo(fabricaSilueta);
		this.partida = new Partida(sensorDeTeclasJuego, generadorDeNivel, fabricaSprites,this);
		ContextoMario jugable = partida.obtenerJugable();
		jugable.establecerObserverLogico(new ObserverLogicoJugable(this));
		return jugable;
	}
	
	public Partida obtenerPartida() {
		return this.partida;
	}
	
	public void finalizarJuego (){
		jugador = new Jugador();
		jugador.actualizarPuntos(partida.obtenerJugable().obtenerPuntos());
		controladorVistas.establecerJugador(jugador);
		controladorVistas.accionarPantallaIngresoNombre();
		ranking.agregarJugador(jugador);
		ranking.guardarEstado();
		BucleJugador bucle = partida.obtenerBucleJugador();
		bucle.detenerBucleJugador();
	}
	

	public void establecerControladorVistas(ControladorVistas controladorVistas) {
		this.controladorVistas=controladorVistas;
	}
	
	public void cierreDeJuego() {
		 ranking.guardarEstado();
	     mostrarMensaje("Gracias por jugar!");
	     System.exit(0);
	}
	
	public Ranking cargarEstadoRanking() {
    	Ranking ranking = null;
    	try {
    		FileInputStream fileInputStream = new FileInputStream ("./src/puntajes");
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
