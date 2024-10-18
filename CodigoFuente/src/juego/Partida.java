package juego;

import elementos.entidades.Jugable;
import sensoresDeTeclas.SensorDeTeclasJuego;

public class Partida {
	
	//TODO para que me lo guardo? es necesario?
	private SensorDeTeclasJuego sensorDeTeclasJuego;
	
	private Jugable jugador;
	
	private BucleJugador bucleJugador;
	
	private CoordinadorActualizacionesJugador coordinadorActualizacionesJugador;
	
	public Partida(SensorDeTeclasJuego sensorDeTeclasJuego) {
		this.sensorDeTeclasJuego = sensorDeTeclasJuego;
		coordinadorActualizacionesJugador = new CoordinadorActualizacionesJugador(this.sensorDeTeclasJuego);
		//TODO la partida indica al nivel que se genere, luego pido al jugador para tenerlo y que 
		//el controlador de vistas y el coordinador puedan acceder a el para alterarlo
		bucleJugador = new BucleJugador(this);
	}
	
	public Jugable obtenerJugador() {
		return jugador;
	}
	
	public void actualizar() {
		//TODO TICK
	}
}
