package juego;

import java.util.ArrayList;

import elementos.Sprite;
import elementos.entidades.Jugable;
import fabricas.FabricaEntidades;
import fabricas.FabricaPlataformas;
import fabricas.FabricaSilueta;
import fabricas.FabricaSiluetaModoAlternativo;
import fabricas.FabricaSiluetaModoOriginal;
import fabricas.FabricaSprites;
import fabricas.FabricaSpritesModoAlternativo;
import fabricas.FabricaSpritesModoOriginal;
import generadores.GeneradorDeNivel;
import sensoresDeTeclas.SensorDeTeclasJuego;
import sensoresDeTeclas.SensorDeTeclasMenu;
import sonido.ReproductorDeMusicaFondo;
import ventanas.ControladorVistas;
import ventanas.PantallaDeJuego;

public class Juego {
	
	protected ArrayList<Nivel> niveles;
	
	private static Juego juego;
	
	private BucleJuego bucleJuego;
		
	private ControladorVistas controladorVistas;
	
	private Partida partida;

	private FabricaSprites fabricaSprites;

	private FabricaEntidades fabricaEntidades;
	
	private FabricaPlataformas fabricaPlataformas;

	private GeneradorDeNivel generadorDeNivel;
	
	private FabricaSilueta fabricaSilueta;
	
	private PantallaDeJuego pantallaDeJuego;
	
	public static void main(String args[]) {
		juego = new Juego();
		juego.controladorVistas = new ControladorVistas(juego);
		juego.bucleJuego = new BucleJuego(juego);
		ReproductorDeMusicaFondo reproductorDeMusicaFondo = new ReproductorDeMusicaFondo();
		reproductorDeMusicaFondo.playMusic("src/sonido/musica_juego.wav");
	}
	
	public void actualizar() {
		controladorVistas.refrescar();
	}
	
	public Sprite obtenerSpriteMario(){
		this.fabricaSprites = new FabricaSpritesModoOriginal("src/imagenes/sprites");
		return fabricaSprites.getMarioDefaultFrontalQuieto();
	}
	
	public void render() {
		//TICK
	}

	public Jugable crearPartida(SensorDeTeclasJuego sensorDeTeclasJuego, String modo) {
		if (modo.equals("Modo original")) {
			this.fabricaSilueta = new FabricaSiluetaModoOriginal("src/imagenes/siluetas");
			this.fabricaSprites = new FabricaSpritesModoOriginal("src/imagenes/sprites");
		} else if (modo.equals("Modo alternativo")) {
			this.fabricaSilueta = new FabricaSiluetaModoAlternativo("src/imagenes/siluetas");
			this.fabricaSprites = new FabricaSpritesModoAlternativo("src/imagenes/sprites");
		}
		this.fabricaEntidades = new FabricaEntidades(fabricaSprites);
		this.fabricaPlataformas = new FabricaPlataformas(fabricaSprites);
		this.pantallaDeJuego = this.controladorVistas.obtenerPantallaDeJuego();
		this.generadorDeNivel = new GeneradorDeNivel(fabricaEntidades, fabricaSilueta, fabricaPlataformas, pantallaDeJuego, controladorVistas);
		partida = new Partida(sensorDeTeclasJuego, generadorDeNivel, fabricaSprites);
		return partida.obtenerJugador();
	}
}
