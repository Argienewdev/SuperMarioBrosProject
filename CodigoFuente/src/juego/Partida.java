package juego;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import elementos.Sprite;
import elementos.personajes.ContextoMario;
import fabricas.FabricaEntidades;
import fabricas.FabricaSilueta;
import fabricas.FabricaSonidos;
import fabricas.FabricaSprites;
import generadores.GeneradorDeNivel;
import generadores.GeneradorSonidos;
import ranking.Jugador;
import sensoresDeTeclas.SensorDeTeclasJuego;
import ventanas.ControladorVistas;

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
	
	private FabricaSonidos fabricaSonidos;
	
	private GeneradorSonidos generadorSonidos;
	
	@SuppressWarnings("exports")
	public Partida(SensorDeTeclasJuego sensorDeTeclasJuego, Juego juego) {
		this.juego = juego;
		this.sensorDeTeclasJuego = sensorDeTeclasJuego;
		this.numeroNivelActual = 1;
		this.generadorDeNivel = new GeneradorDeNivel(this.juego.obtenerModoDeJuegoSeleccionado(), this.juego.obtenerPantallaDeJuego(), this.juego.obtenerControladorVistas());
		this.fabricaSonidos = generadorDeNivel.obtenerFabricaSonidos();
		this.generadorSonidos = generadorDeNivel.obtenerGeneradorSonidos();
		this.generadorSonidos.reproducirMusicaFondo();
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
		if(tiempoLlegoACero()) {
			matarJugador();
		}
	}

	public BucleJugador obtenerBucleJugador(){
		return this.bucleJugador;
	}
	
	public void cambiarNivel() {
		this.juego.obtenerControladorVistas().eliminarNivelActual();
		this.numeroNivelActual++;
		this.juego.obtenerControladorVistas().cambiarNivel();
		this.nivel = generarNivel(numeroNivelActual, this);
		this.nivel.establecerMario(jugable);
		this.coordinadorActualizacionesJugador.obtenerControladorDeMovimiento().actualizarNivel(this.nivel);
		this.masterMind.cambiarNivel(this.nivel);
		
		Timer timer = new Timer(juego.obtenerControladorVistas().obtenerDuracionPantallaEntreNiveles(), new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		generadorSonidos.reproducirMusicaFondo();
	        }
	    });
	    timer.setRepeats(false);
	    timer.start();
	}
	
	public void reiniciarNivel() {
		generadorSonidos.detenerMusicaFondo();
		this.juego.obtenerControladorVistas().eliminarNivelActual();
		this.juego.obtenerControladorVistas().reiniciarNivel();
		this.nivel = generarNivel(numeroNivelActual, this);
		this.nivel.establecerMario(jugable);
		this.coordinadorActualizacionesJugador.obtenerControladorDeMovimiento().actualizarNivel(this.nivel);
		this.masterMind.cambiarNivel(this.nivel);
		
	    Timer timer = new Timer(juego.obtenerControladorVistas().obtenerDuracionPantallaEntreNiveles(), new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		generadorSonidos.reproducirMusicaFondo();
	        }
	    });
	    timer.setRepeats(false);
	    timer.start();
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
	
	public GeneradorSonidos obtenerGeneradorDeSonidos() {
		return this.generadorSonidos;
	}
	
	private boolean tiempoLlegoACero() {
		return this.juego.obtenerControladorVistas().obtenerPantallaDeJuego().obtenterTiempoEnCero();
	}
	
	private void matarJugador() {
		this.generadorSonidos.detenerMusicaFondo();
     	this.generadorSonidos.pierdeVida();
     	this.jugable.perderVida();
     	this.reiniciarNivel();
	}
	
	
}
