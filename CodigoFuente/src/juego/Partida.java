package juego;

import elementos.entidades.Jugable;
import generadores.GeneradorDeNivel;
import sensoresDeTeclas.SensorDeTeclasJuego;

public class Partida {
	
	//TODO para que me lo guardo? es necesario?
	private SensorDeTeclasJuego sensorDeTeclasJuego;
	
	private Jugable jugador;
	
	private BucleJugador bucleJugador;
	
	private CoordinadorActualizacionesJugador coordinadorActualizacionesJugador;
	
	private GeneradorDeNivel generadorDeNivel;
	
	@SuppressWarnings("exports")
	public Partida(SensorDeTeclasJuego sensorDeTeclasJuego, GeneradorDeNivel generadorDeNivel) {
		this.sensorDeTeclasJuego = sensorDeTeclasJuego;
		this.coordinadorActualizacionesJugador = new CoordinadorActualizacionesJugador(this.sensorDeTeclasJuego);
		this.generadorDeNivel = generadorDeNivel;
		this.generadorDeNivel.generarNivel("../niveles/nivel-1.txt");
		this.bucleJugador = new BucleJugador(this);
	}
	
	public Jugable obtenerJugador() {
		return jugador;
	}
	
	public void actualizar() {
		//TODO TICK
	}
}
