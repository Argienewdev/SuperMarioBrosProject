package juego;

import elementos.entidades.Jugable;
import elementos.personajes.MarioDefault;
import fabricas.FabricaEntidades;
import fabricas.FabricaSprites;
import fabricas.FabricaSpritesModoAlternativo;
import fabricas.FabricaSpritesModoOriginal;
import generadores.GeneradorDeNivel;
import sensoresDeTeclas.SensorDeTeclasJuego;

public class Partida {
	
	//TODO para que me lo guardo? es necesario?
	private SensorDeTeclasJuego sensorDeTeclasJuego;
	
	private Jugable jugador;
	
	private BucleJugador bucleJugador;
	
	private CoordinadorActualizacionesJugador coordinadorActualizacionesJugador;
	
	private GeneradorDeNivel generadorDeNivel;

	private FabricaEntidades fabricaEntidades;
	
	private FabricaSprites fabricaSpritesModoAlternativo;
	
	private FabricaSprites fabricaSpritesModoOriginal;
	
	private Nivel nivel;
	
	@SuppressWarnings("exports")
	public Partida(SensorDeTeclasJuego sensorDeTeclasJuego, GeneradorDeNivel generadorDeNivel) {
		this.sensorDeTeclasJuego = sensorDeTeclasJuego;
		this.generadorDeNivel = generadorDeNivel;
		this.generadorDeNivel.generarNivel("src/niveles/nivel-1.txt");
		this.nivel = generadorDeNivel.generarNivel("src/niveles/nivel-1.txt");
		this.jugador = nivel.getMario();
		this.coordinadorActualizacionesJugador = new CoordinadorActualizacionesJugador(this.sensorDeTeclasJuego, this.jugador);
		this.bucleJugador = new BucleJugador(this);
	}
	
	public Jugable obtenerJugador() {
		return jugador;
	}
	
	public void actualizar() {
		coordinadorActualizacionesJugador.actualizar();
	}
}
