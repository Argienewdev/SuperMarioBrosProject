package juego;

import java.util.ArrayList;

import ventanas.ControladorVistas;

public class Juego {
	
	protected ArrayList<Nivel> niveles;
	
	private static Juego juego;
	
	//private BucleJuego bucleJuego;
	
	private BucleJugador bucleJugador;
	
	private CoordinadorActualizacionesJugador coordinadorActualizacionesJugador;
	
	private ControladorVistas controladorVistas;
	
	public static void main(String args[]) {
		juego = new Juego();
		//juego.bucleJuego = new BucleJuego();
		juego.coordinadorActualizacionesJugador = new CoordinadorActualizacionesJugador();
		juego.controladorVistas = new ControladorVistas();
		juego.bucleJugador = new BucleJugador(juego);
	}
	
	public void actualizar() {
		coordinadorActualizacionesJugador.actualizar();
	}
	
	public void render() {
		//controladorVistas.actualizar();
	}
}
