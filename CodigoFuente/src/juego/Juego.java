package juego;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Ranking.Jugador;
import Ranking.Ranking;
import elementos.Sprite;
import elementos.entidades.Jugable;
import elementos.personajes.ContextoMario;
import fabricas.FabricaEntidades;
import fabricas.FabricaPlataformas;
import fabricas.FabricaSilueta;
import fabricas.FabricaSiluetaModoAlternativo;
import fabricas.FabricaSiluetaModoOriginal;
import fabricas.FabricaSprites;
import fabricas.FabricaSpritesModoAlternativo;
import fabricas.FabricaSpritesModoOriginal;
import generadores.GeneradorDeNivel;
import observers.ObserverLogicoJugable;
import sensoresDeTeclas.SensorDeTeclasJuego;
import sensoresDeTeclas.SensorDeTeclasMenu;
import ventanas.ControladorVistas;
import ventanas.PantallaDeJuego;

public class Juego {
	
	protected ArrayList<Nivel> niveles;
		
	private ControladorVistas controladorVistas;
	
	private Partida partida;

	private FabricaSprites fabricaSprites;

	private GeneradorDeNivel generadorDeNivel;
	
	private FabricaSilueta fabricaSilueta;
	
	private PantallaDeJuego pantallaDeJuego;
	
	private Ranking ranking;
	
	private Jugador jugador;
	
	public Juego() {
		ranking = new Ranking();
	}
	
	public void actualizar() {
		controladorVistas.refrescar();
	}
	
	public Sprite obtenerSpriteMario(){
		this.fabricaSprites = new FabricaSpritesModoOriginal("src/imagenes/sprites");
		return fabricaSprites.getMarioDefaultFrontalQuieto();
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
		if (modo.equals("Modo original")) {
			this.fabricaSilueta = new FabricaSiluetaModoOriginal("src/imagenes/siluetas");
			this.fabricaSprites = new FabricaSpritesModoOriginal("src/imagenes/sprites");
		} else if (modo.equals("Modo alternativo")) {
			this.fabricaSilueta = new FabricaSiluetaModoAlternativo("src/imagenes/siluetas");
			this.fabricaSprites = new FabricaSpritesModoAlternativo("src/imagenes/sprites");
		}
		this.pantallaDeJuego = this.controladorVistas.obtenerPantallaDeJuego();
		this.generadorDeNivel = new GeneradorDeNivel(fabricaSprites, fabricaSilueta, pantallaDeJuego, controladorVistas);
		
		this.partida = new Partida(sensorDeTeclasJuego, generadorDeNivel, fabricaSprites,this);
		ContextoMario jugable = partida.obtenerJugable();
		jugable.establecerObserverLogico(new ObserverLogicoJugable(this));
		jugador = new Jugador();
		jugador.establecerNombre(controladorVistas.obtenerPantallaIngresoNombre().obtenerNombreJugador());
		return jugable;
	}
	
	public Partida obtenerPartida() {
		return this.partida;
	}
	
	public void finalizarPartida () {
		jugador.actualizarPuntos(partida.obtenerJugable().getPuntos());
		ranking.agregarJugador(jugador);
		guardarEstado();
		controladorVistas.mostrarPantallaFinal();
	}

	public void establecerControladorVistas(ControladorVistas controladorVistas) {
		this.controladorVistas=controladorVistas;
	}
	
	public void cierreDeJuego() {
		 guardarEstado();
	     //TODO liberarRecursos(); si fuera necesario
	     mostrarMensaje("Gracias por jugar!");
	     System.exit(0);
	}
	
	private void guardarEstado() {
		try {
			FileOutputStream  fileOutputStream = new FileOutputStream("./src/puntajes");
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(ranking);
			objectOutputStream.flush();
			objectOutputStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		  catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void mostrarMensaje(String mensaje) {
		JOptionPane.showMessageDialog(null,mensaje);
	}
	
}
