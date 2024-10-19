package juego;

import java.util.ArrayList;

import elementos.entidades.Jugable;
import fabricas.FabricaEntidades;
import fabricas.FabricaSilueta;
import fabricas.FabricaSiluetaModoOriginal;
import fabricas.FabricaSprites;
import fabricas.FabricaSpritesModoAlternativo;
import fabricas.FabricaSpritesModoOriginal;
import generadores.GeneradorDeNivel;
import sensoresDeTeclas.SensorDeTeclasJuego;
import sensoresDeTeclas.SensorDeTeclasMenu;
import ventanas.ControladorVistas;

public class Juego {
	
	protected ArrayList<Nivel> niveles;
	
	private static Juego juego;
	
	private BucleJuego bucleJuego;
	
	private ControladorVistas controladorVistas;
	
	private Partida partida;

	private FabricaSprites fabricaSprites;

	private FabricaEntidades fabricaEntidades;

	private GeneradorDeNivel generadorDeNivel;
	
	private FabricaSilueta fabricaSilueta;
	
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

	public Jugable crearPartida(SensorDeTeclasJuego sensorDeTeclasJuego, String modo) {
		System.out.println("Modo recibido: [" + modo + "]");
		if (modo.equals("Modo original")) {
			System.out.println("hhh");
			this.fabricaSilueta = new FabricaSiluetaModoOriginal("src/imagenes/siluetas/siluetaModoOriginal.png");
			this.fabricaSprites = new FabricaSpritesModoOriginal("src/imagenes/sprites");
		} else if (modo.equals("Modo alternativo")) {
			System.out.println("iiii");
			this.fabricaSilueta = new FabricaSiluetaModoOriginal("src/imagenes/siluetas/siluetaModoAlternativo.png");
			this.fabricaSprites = new FabricaSpritesModoAlternativo("src/imagenes/sprites");
		}
		this.fabricaEntidades = new FabricaEntidades(fabricaSprites);
		this.generadorDeNivel = new GeneradorDeNivel(fabricaEntidades, fabricaSilueta);
		partida = new Partida(sensorDeTeclasJuego, generadorDeNivel);
		return partida.obtenerJugador();
	}
}
