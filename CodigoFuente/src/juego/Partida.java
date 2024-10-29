package juego;

import elementos.personajes.ContextoMario;
import fabricas.FabricaEntidades;
import fabricas.FabricaSprites;
import generadores.GeneradorDeNivel;
import ranking.Jugador;
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
	
	private int numeroNivelActual;
	
	private Juego juego;

	private Jugador jugador;
	
	@SuppressWarnings("exports")
	public Partida(SensorDeTeclasJuego sensorDeTeclasJuego, GeneradorDeNivel generadorDeNivel, FabricaSprites fabricaSprites, Juego juego) {
		this.juego = juego;
		this.sensorDeTeclasJuego = sensorDeTeclasJuego;
		this.generadorDeNivel = generadorDeNivel;
		this.numeroNivelActual = 1;
		this.nivel = generarNivel(this.numeroNivelActual, this);
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
	
	public void cambiarNivel() {
		this.juego.obtenerControladorVistas().eliminarNivelActual();
		this.numeroNivelActual++;
		this.nivel = generarNivel(numeroNivelActual, this);
		this.nivel.setMario(jugable);
		this.coordinadorActualizacionesJugador.obtenerControladorDeMovimiento().actualizarNivel(this.nivel);
		this.masterMind.cambiarNivel(this.nivel);
		this.juego.obtenerControladorVistas().cambiarNivel();
	}
	
	public void reiniciarNivel() {
		this.juego.obtenerControladorVistas().eliminarNivelActual();
		this.nivel = generarNivel(numeroNivelActual, this);
		this.nivel.setMario(jugable);
		this.coordinadorActualizacionesJugador.obtenerControladorDeMovimiento().actualizarNivel(this.nivel);
		this.juego.obtenerControladorVistas().reiniciarNivel();
		this.masterMind.cambiarNivel(this.nivel);
	}
	
	public void finalizarPartida() {
		this.juego.obtenerBucleJuego().stop();
		this.bucleEntidadesNoJugables.stop();
		this.bucleJugador.stop();
	}
	
	private Nivel generarNivel(int numeroNivelActual, Partida partida) {
		
		return generadorDeNivel.generarNivel(numeroNivelActual, this);
	}

	public int obtenerNumeroDeNivelActual() {
		return this.numeroNivelActual;
	}
	
	public GeneradorDeNivel obtenerGeneradorDeNivel() {
		return this.generadorDeNivel;
	}
	
	public Juego obtenerJuego() {
		return this.juego;
	}
}
