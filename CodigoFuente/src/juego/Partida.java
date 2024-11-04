package juego;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import elementos.Sprite;
import elementos.personajes.ContextoMario;
import fabricas.FabricaSprites;
import generadores.GeneradorDeNivel;
import generadores.GeneradorSonidos;
import sensoresDeTeclas.SensorDeTeclasJuego;

public class Partida {
	
	private Juego juego;
		
	private ContextoMario jugable;
	
	private BucleJugador bucleJugador;
	
	private BucleEntidadesNoJugables bucleEntidadesNoJugables;
	
	private SensorDeTeclasJuego sensorDeTeclasJuego;
	
	private MasterMind masterMind;
	
	private CoordinadorActualizacionesJugador coordinadorActualizacionesJugador;
	
	private GeneradorDeNivel generadorDeNivel;

	private Nivel nivel;
			
	private int numeroNivelActual;
	
	public Partida(SensorDeTeclasJuego sensorDeTeclasJuego, Juego juego) {
		this.juego = juego;
		this.sensorDeTeclasJuego = sensorDeTeclasJuego;
		this.numeroNivelActual = 1;
		this.generadorDeNivel = new GeneradorDeNivel(this.juego.obtenerModoDeJuegoSeleccionado(), 
													 this.juego.obtenerPantallaDeJuego(), 
													 this.juego.obtenerControladorVistas());
		obtenerGeneradorSonidos().reproducirMusicaFondo();
		this.nivel = generarNivel(this.numeroNivelActual, this);
		this.jugable = this.nivel.obtenerMario();
		this.coordinadorActualizacionesJugador = new CoordinadorActualizacionesJugador(this.sensorDeTeclasJuego, 
																					   this.jugable, 
																					   obtenerFabricaSprites(), 
																					   this.nivel);
		this.bucleJugador = new BucleJugador(this);
		this.masterMind = new MasterMind(this.generadorDeNivel.obtenerFabricaSprites(), this.nivel);
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
		obtenerGeneradorSonidos().establecerFinNivelFalso();
		Timer timer = new Timer(juego.obtenerControladorVistas().obtenerDuracionPantallaEntreNiveles(), new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		obtenerGeneradorSonidos().reproducirMusicaFondo();
	        }
	    });
	    timer.setRepeats(false);
	    timer.start();
	}
	
	public void reiniciarNivel() {
		obtenerGeneradorSonidos().detenerMusicaFondo();
		this.juego.obtenerControladorVistas().eliminarNivelActual();
		this.juego.obtenerControladorVistas().reiniciarNivel();
		this.nivel = generarNivel(numeroNivelActual, this);
		this.nivel.establecerMario(jugable);
		this.coordinadorActualizacionesJugador.obtenerControladorDeMovimiento().actualizarNivel(this.nivel);
		this.masterMind.cambiarNivel(this.nivel);
	    Timer timer = new Timer(juego.obtenerControladorVistas().obtenerDuracionPantallaEntreNiveles(), new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		obtenerGeneradorSonidos().reproducirMusicaFondo();
	        }
	    });
	    timer.setRepeats(false);
	    timer.start();
	}
	
	public void finalizarPartida() {
		this.numeroNivelActual = 1;
		this.detenerBucleJuego();
		this.detenerBucleEntidadesNoJugables();
	}
	
	private void detenerBucleJuego() {
		this.juego.finalizarJuego();		
	}

	private void detenerBucleEntidadesNoJugables() {
		this.bucleEntidadesNoJugables.detenerBucleEntidadesNoJugables();
	}

	private Nivel generarNivel(int numeroNivelActual, Partida partida) {
		return this.generadorDeNivel.generarNivel(numeroNivelActual, partida);
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
		return obtenerFabricaSprites().obtenerMarioDefaultFrontalQuieto();
	}
	
	private boolean tiempoLlegoACero() {
		return this.juego.obtenerControladorVistas().obtenerPantallaDeJuego().obtenterTiempoEnCero();
	}
	
	private void matarJugador() {
		obtenerGeneradorSonidos().detenerMusicaFondo();
     	obtenerGeneradorSonidos().seAcaboElTiempo();
     	this.jugable.perderVida();
     	this.reiniciarNivel();
	}
	public SensorDeTeclasJuego obtenerSensorDeTeclasJuego() {
		return this.sensorDeTeclasJuego;
	}

	public void desactivarMovimientoEnemigos() {
		this.masterMind.desactivarMovimientoEnemigos();
	}

	public void activarMovimientoEnemigos() {
		this.masterMind.activarMovimientoEnemigos();
	}
	
	public void desactivarMovimientoPersonaje() {
		this.coordinadorActualizacionesJugador.obtenerControladorDeMovimiento().desactivarMovimientoPersonaje();
	}

	public void activarMovimientoPersonaje() {
		this.coordinadorActualizacionesJugador.obtenerControladorDeMovimiento().activarMovimientoPersonaje();
	}
	
	public GeneradorSonidos obtenerGeneradorSonidos() {
		return this.generadorDeNivel.obtenerGeneradorSonidos();
	}
	
	public FabricaSprites obtenerFabricaSprites() {
		return this.generadorDeNivel.obtenerFabricaSprites();
	}

}
