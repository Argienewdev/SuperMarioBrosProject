package juego;

import elementos.entidades.Jugable;
import elementos.personajes.ContextoMario;
import elementos.personajes.MarioDefault;
import fabricas.FabricaEntidades;
import fabricas.FabricaSprites;
import fabricas.FabricaSpritesModoAlternativo;
import fabricas.FabricaSpritesModoOriginal;
import generadores.GeneradorDeNivel;
import sensoresDeTeclas.SensorDeTeclasJuego;

public class Partida {
	
	private SensorDeTeclasJuego sensorDeTeclasJuego;
	
	private ContextoMario jugador;
	
	private BucleJugador bucleJugador;
	
	private CoordinadorActualizacionesJugador coordinadorActualizacionesJugador;
	
	private GeneradorDeNivel generadorDeNivel;

	private FabricaEntidades fabricaEntidades;
	
	private FabricaSprites fabricaSpritesModoAlternativo;
	
	private FabricaSprites fabricaSpritesModoOriginal;
	
	private GestorDeColisiones gestorDeColisiones;
	
	private Nivel nivel;
	
	private BucleEntidadesNoJugables bucleEntidadesNoJugables;
	
	private MasterMind masterMind;
	
	@SuppressWarnings("exports")
	public Partida(SensorDeTeclasJuego sensorDeTeclasJuego, GeneradorDeNivel generadorDeNivel, FabricaSprites fabricaSprites) {
		this.sensorDeTeclasJuego = sensorDeTeclasJuego;
		this.generadorDeNivel = generadorDeNivel;
		this.nivel = generadorDeNivel.generarNivel("src/niveles/nivel-1.txt");
		this.jugador = this.nivel.getMario();
		this.gestorDeColisiones = new GestorDeColisiones(this.nivel);
		this.coordinadorActualizacionesJugador = new CoordinadorActualizacionesJugador(this.sensorDeTeclasJuego, this.jugador, fabricaSprites, this.nivel, gestorDeColisiones);
		this.bucleJugador = new BucleJugador(this);
		this.masterMind = new MasterMind(fabricaSprites, this.nivel);
		this.bucleEntidadesNoJugables = new BucleEntidadesNoJugables(this.masterMind);
	}
	
	public ContextoMario obtenerJugador() {
		return this.jugador;
	}
	
	public void actualizar() {
		this.coordinadorActualizacionesJugador.actualizar();
	}
}
