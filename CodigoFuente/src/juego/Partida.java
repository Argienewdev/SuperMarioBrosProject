package juego;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import elementos.Sprite;
import elementos.entidades.Jugable;
import elementos.personajes.ContextoMario;
import fabricas.FabricaSprites;
import generadores.GeneradorDeNivel;
import generadores.GeneradorSonidos;
import sensoresDeTeclas.SensorDeTeclasJuego;

public class Partida {
	
	private Juego juego;
		
	private Jugable jugable;
	
	private BucleJugador bucleJugador;
	
	private BucleEntidadesNoJugables bucleEntidadesNoJugables;
	
	private MasterMind masterMind;
	
	private CoordinadorActualizacionesJugador coordinadorActualizacionesJugador;
	
	private GeneradorDeNivel generadorDeNivel;

	private Nivel nivel;
			
	private int numeroNivelActual;
	
	public Partida(SensorDeTeclasJuego sensorDeTeclasJuego, Juego juego) {
		this.juego = juego;
		this.numeroNivelActual = 1;
		this.generadorDeNivel = new GeneradorDeNivel(this.juego.obtenerModoDeJuegoSeleccionado(), 
													 this.juego.obtenerPantallaDeJuego(), 
													 this.juego.obtenerControladorVistas());
		obtenerGeneradorSonidos().reproducirMusicaFondo();
		this.nivel = generarNivel(this.numeroNivelActual, this);
		this.jugable = this.nivel.obtenerMario();
		this.coordinadorActualizacionesJugador = new CoordinadorActualizacionesJugador(sensorDeTeclasJuego, 
																					   this.jugable, 
																					   obtenerFabricaSprites(), 
																					   this.nivel);
		this.bucleJugador = new BucleJugador(this);
		this.masterMind = new MasterMind(obtenerFabricaSprites(), this.nivel);
		this.bucleEntidadesNoJugables = new BucleEntidadesNoJugables(this.masterMind);
	}
	
	public int obtenerNumeroDeNivelActual() {
		return this.numeroNivelActual;
	}
	
	public Jugable obtenerJugable() {
		return this.jugable;
	}
	
	public BucleJugador obtenerBucleJugador(){
		return this.bucleJugador;
	}
	
	public GeneradorSonidos obtenerGeneradorSonidos() {
		return this.generadorDeNivel.obtenerGeneradorSonidos();
	}
	
	public FabricaSprites obtenerFabricaSprites() {
		return this.generadorDeNivel.obtenerFabricaSprites();
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
	
	public void actualizar() {
		this.coordinadorActualizacionesJugador.actualizar();
		if(tiempoLlegoACero()) {
			matarJugador();
		}
	}
	
	public void cambiarNivel() {
		eliminarNivelActual();
		generarNuevoNivel();
		actualizarReferenciasANivelActual();
		iniciarTemporizadorCambioDeNivel();
	}

	private void eliminarNivelActual() {
		this.juego.obtenerControladorVistas().eliminarNivelActual();
	}
	
	private void generarNuevoNivel() {
		this.numeroNivelActual++;
		this.juego.obtenerControladorVistas().cambiarNivel();
		this.nivel = generarNivel(this.numeroNivelActual, this);
		this.nivel.establecerMario(this.jugable);
	}
	
	private void actualizarReferenciasANivelActual() {
		this.coordinadorActualizacionesJugador.obtenerControladorDeMovimiento().actualizarNivel(this.nivel);
		this.masterMind.cambiarNivel(this.nivel);
	}
	
	private void iniciarTemporizadorCambioDeNivel() {
	    int duracionEntreNiveles = this.juego.obtenerControladorVistas().obtenerDuracionPantallaEntreNiveles();
	    Timer temporizadorCambio = new Timer(duracionEntreNiveles, new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	obtenerGeneradorSonidos().reproducirMusicaFondo();
	        }
	    });
	    temporizadorCambio.setRepeats(false);
	    temporizadorCambio.start();
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
	
	private boolean tiempoLlegoACero() {
		return this.juego.obtenerControladorVistas().obtenerPantallaDeJuego().obtenterTiempoEnCero();
	}
	
	private void matarJugador() {
		obtenerGeneradorSonidos().detenerMusicaFondo();
     	obtenerGeneradorSonidos().seAcaboElTiempo();
     	this.jugable.perderVida();
     	this.reiniciarNivel();
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

}
