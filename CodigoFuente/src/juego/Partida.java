package juego;

import elementos.Sprite;
import elementos.personajes.ContextoMario;
import fabricas.FabricaEntidades;
import fabricas.FabricaSilueta;
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

	private Nivel nivel;
	
	private BucleEntidadesNoJugables bucleEntidadesNoJugables;
	
	private MasterMind masterMind;
	
	private int numeroNivelActual;
	
	private Juego juego;
	
	private FabricaSprites fabricaSprites;
	
	@SuppressWarnings("exports")
	public Partida(SensorDeTeclasJuego sensorDeTeclasJuego, Juego juego) {
		this.juego = juego;
		this.sensorDeTeclasJuego = sensorDeTeclasJuego;
		this.numeroNivelActual = 1;
		this.generadorDeNivel = new GeneradorDeNivel(this.juego.obtenerModoDeJuegoSeleccionado(), this.juego.obtenerPantallaDeJuego(), this.juego.obtenerControladorVistas());
		this.nivel = generarNivel(this.numeroNivelActual, this);
		this.fabricaSprites = generadorDeNivel.obtenerFabricaSprites();
		this.jugable = this.nivel.obtenerMario();
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
	
	public BucleJugador obtenerBucleJugador(){
		return this.bucleJugador;
	}
	
	public void cambiarNivel() {
		this.juego.obtenerControladorVistas().eliminarNivelActual();
		this.numeroNivelActual++;
		this.nivel = generarNivel(numeroNivelActual, this);
		this.nivel.establecerMario(jugable);
		this.coordinadorActualizacionesJugador.obtenerControladorDeMovimiento().actualizarNivel(this.nivel);
		this.masterMind.cambiarNivel(this.nivel);
		this.juego.obtenerControladorVistas().cambiarNivel();
	}
	
	public void reiniciarNivel() {
		this.juego.obtenerControladorVistas().eliminarNivelActual();
		this.juego.obtenerControladorVistas().reiniciarNivel();
		this.nivel = generarNivel(numeroNivelActual, this);
		this.nivel.establecerMario(jugable);
		this.coordinadorActualizacionesJugador.obtenerControladorDeMovimiento().actualizarNivel(this.nivel);
		this.masterMind.cambiarNivel(this.nivel);
	}
	
	public void finalizarPartida() {
		this.numeroNivelActual = 1;
		detenerBucleJuego();
		detenerBucleEntidadesNoJugables();
	}
	
	private void detenerBucleJuego() {
		this.juego.finalizarJuego();		
	}

	private void detenerBucleEntidadesNoJugables() {
		this.bucleEntidadesNoJugables.detenerBucleEntidadesNoJugables();
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

	public Sprite obtenerSpriteMario() {
		return this.fabricaSprites.obtenerMarioDefaultFrontalQuieto();
	}
}
