package juego;

import java.util.ArrayList;

import elementos.entidades.Jugable;
import sensoresDeTeclas.SensorDeTeclasJuego;
import sensoresDeTeclas.SensorDeTeclasMenu;
import ventanas.ControladorVistas;

public class Juego {
	
	protected ArrayList<Nivel> niveles;
	
	private static Juego juego;
	
	private BucleJuego bucleJuego;
	
	private ControladorVistas controladorVistas;
	
	private Partida partida;
	
	public static void main(String args[]) {
		juego = new Juego();
		//juego.bucleJuego = new BucleJuego();
		juego.controladorVistas = new ControladorVistas(juego);
		juego.bucleJuego = new BucleJuego(juego);
	}
	
	public void actualizar() {
		controladorVistas.refrescar();
	}
	
	public void render() {
		//TICK
	}

	public Jugable crearPartida(SensorDeTeclasJuego sensorDeTeclasJuego) {
		partida = new Partida(sensorDeTeclasJuego);
		return partida.obtenerJugador();
	}
}
