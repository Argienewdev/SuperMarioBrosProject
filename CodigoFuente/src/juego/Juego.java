package juego;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JOptionPane;

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
import launcher.Jugador;
import launcher.Ranking;
import sensoresDeTeclas.SensorDeTeclasJuego;
import sensoresDeTeclas.SensorDeTeclasMenu;
import sonido.ReproductorDeMusicaFondo;
import ventanas.ControladorVistas;
import ventanas.PantallaDeJuego;

public class Juego {
	
	protected ArrayList<Nivel> niveles;
		
	private ControladorVistas controladorVistas;
	
	private Partida partida;

	private FabricaSprites fabricaSprites;

	private FabricaEntidades fabricaEntidades;
	
	private FabricaPlataformas fabricaPlataformas;

	private GeneradorDeNivel generadorDeNivel;
	
	private FabricaSilueta fabricaSilueta;
	
	private PantallaDeJuego pantallaDeJuego;
	
	private Ranking ranking;
	
	public Juego() {
		ranking = new Ranking();
		try {
			FileInputStream  fileInputStream = new FileInputStream("./puntajes");
			ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
			Jugador jugador = (Jugador) objectInputStream.readObject();
			objectInputStream.close();
		} catch (FileNotFoundException e) {
		
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
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

	public ContextoMario crearPartida(SensorDeTeclasJuego sensorDeTeclasJuego, String modo) {
		if (modo.equals("Modo original")) {
			this.fabricaSilueta = new FabricaSiluetaModoOriginal("src/imagenes/siluetas");
			this.fabricaSprites = new FabricaSpritesModoOriginal("src/imagenes/sprites");
		} else if (modo.equals("Modo alternativo")) {
			this.fabricaSilueta = new FabricaSiluetaModoAlternativo("src/imagenes/siluetas");
			this.fabricaSprites = new FabricaSpritesModoAlternativo("src/imagenes/sprites");
		}
		this.fabricaEntidades = new FabricaEntidades(fabricaSprites);
		this.fabricaPlataformas = new FabricaPlataformas(fabricaSprites, fabricaEntidades);
		this.pantallaDeJuego = this.controladorVistas.obtenerPantallaDeJuego();
		this.generadorDeNivel = new GeneradorDeNivel(fabricaEntidades, fabricaSilueta, fabricaPlataformas, pantallaDeJuego, controladorVistas);
		partida = new Partida(sensorDeTeclasJuego, generadorDeNivel, fabricaSprites);
		return partida.obtenerJugador();
	}
	
	public void finalizarPartida (Jugador jugador) {
		jugador.actualizarPuntos();
		ranking.agregarJugador(jugador);
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
			FileOutputStream  fileOutputStream = new FileOutputStream("./puntajes");
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
