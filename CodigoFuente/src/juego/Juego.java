package juego;

import java.util.ArrayList;

import elementos.entidades.Jugable;
import fabricas.FabricaEntidades;
import fabricas.FabricaPlataformas;
import fabricas.FabricaSilueta;
import fabricas.FabricaSiluetaModoAlternativo;
import fabricas.FabricaSiluetaModoOriginal;
import fabricas.FabricaSprites;
import fabricas.FabricaSpritesModoAlternativo;
import fabricas.FabricaSpritesModoOriginal;
import generadores.GeneradorDeNivel;
import sensoresDeTeclas.SensorDeTeclasJuego;
import sensoresDeTeclas.SensorDeTeclasMenu;
import ventanas.ControladorVistas;
import ventanas.PantallaDeJuego;

public class Juego {
	
	protected ArrayList<Nivel> niveles;
	
	private static Juego juego;
	
	private BucleJuego bucleJuego;
	
	private ControladorVistas controladorVistas;
	
	private Partida partida;

	private GeneradorDeNivel generadorDeNivel;
	
	private PantallaDeJuego pantallaDeJuego;
	
	public static void main(String args[]) {
		juego = new Juego();
		//juego.bucleJuego = new BucleJuego();
		juego.controladorVistas = new ControladorVistas(juego);
		juego.bucleJuego = new BucleJuego(juego);
	}
	
	public void actualizar() {
		controladorVistas.refrescar();
	}
	
	public void render() {
		//TICK
	}

	public Jugable crearPartida(SensorDeTeclasJuego sensorDeTeclasJuego, String modo) {
		this.pantallaDeJuego = this.controladorVistas.obtenerPantallaDeJuego();
		this.generadorDeNivel = new GeneradorDeNivel(modo, pantallaDeJuego, controladorVistas);
		FabricaSprites fabricaSprites= generadorDeNivel.getFabricaSprites();
		partida = new Partida(sensorDeTeclasJuego, generadorDeNivel, fabricaSprites);
		return partida.obtenerJugador();
	}
}
