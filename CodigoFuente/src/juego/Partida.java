package juego;

import Ranking.Jugador;
import elementos.personajes.ContextoMario;
import fabricas.FabricaEntidades;
import fabricas.FabricaSprites;
import generadores.GeneradorDeNivel;
import sensoresDeTeclas.SensorDeTeclasJuego;

public class Partida {
	
	private SensorDeTeclasJuego sensorDeTeclasJuego;
	
	private ContextoMario jugable;
	
	private BucleJugador bucleJugador;
	
	private CoordinadorActualizacionesJugador coordinadorActualizacionesJugador;
	
	private GeneradorDeNivel generadorDeNivel;

	private FabricaEntidades fabricaEntidades;
	
	private FabricaSprites fabricaSpritesModoAlternativo;
	
	private FabricaSprites fabricaSpritesModoOriginal;
	
	private Nivel nivel;
	
	private BucleEntidadesNoJugables bucleEntidadesNoJugables;
	
	private MasterMind masterMind;
	
	private Jugador jugador;
	
	
	@SuppressWarnings("exports")
	public Partida(SensorDeTeclasJuego sensorDeTeclasJuego, GeneradorDeNivel generadorDeNivel, FabricaSprites fabricaSprites) {
		this.sensorDeTeclasJuego = sensorDeTeclasJuego;
		this.generadorDeNivel = generadorDeNivel;
		this.nivel = generadorDeNivel.generarNivel("src/niveles/nivel-1.txt");
		this.jugable = this.nivel.getMario();
		this.coordinadorActualizacionesJugador = new CoordinadorActualizacionesJugador(this.sensorDeTeclasJuego, this.jugable, fabricaSprites, nivel);
		this.bucleJugador = new BucleJugador(this);
		this.masterMind = new MasterMind(fabricaSprites, this.nivel);
		this.bucleEntidadesNoJugables = new BucleEntidadesNoJugables(this.masterMind);
	}
	
	public ContextoMario obtenerJugable() {
		return this.jugable;
	}
	
	public void actualizar() {
		this.coordinadorActualizacionesJugador.actualizar();
	}
}
