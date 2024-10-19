package juego;

import elementos.entidades.Jugable;
import fabricas.FabricaEntidades;
import fabricas.FabricaSprites;
import fabricas.FabricaSpritesModoAlternativo;
import fabricas.FabricaSpritesModoOriginal;
import generadores.GeneradorDeNivel;
import sensoresDeTeclas.SensorDeTeclasJuego;

public class Partida {
	
	//TODO para que me lo guardo? es necesario?
	private SensorDeTeclasJuego sensorDeTeclasJuego;
	
	private Jugable jugador;
	
	private BucleJugador bucleJugador;
	
	private CoordinadorActualizacionesJugador coordinadorActualizacionesJugador;
	
	private GeneradorDeNivel generadorDeNivel;
	
	private FabricaEntidades fabricaEntidades;
	
	private FabricaSprites fabricaSpritesModoAlternativo;
	
	private FabricaSprites fabricaSpritesModoOriginal;
	
	public Partida(SensorDeTeclasJuego sensorDeTeclasJuego) {
		this.sensorDeTeclasJuego = sensorDeTeclasJuego;
		this.coordinadorActualizacionesJugador = new CoordinadorActualizacionesJugador(this.sensorDeTeclasJuego);
		//TODO la partida indica al nivel que se genere, luego pido al jugador para tenerlo y que 
		//el controlador de vistas y el coordinador puedan acceder a el para alterarlo
		this.fabricaSpritesModoAlternativo = new FabricaSpritesModoAlternativo("../imagenes/sprites");
		this.fabricaSpritesModoOriginal = new FabricaSpritesModoOriginal("../imagenes/sprites");
		// Falta un condicional para ver que fabrica mandarle a la fabrica de entidades, la partida deberia saber el modo
		this.fabricaEntidades = new FabricaEntidades(fabricaSpritesModoOriginal);
		this.generadorDeNivel = new GeneradorDeNivel(fabricaEntidades);
		this.generadorDeNivel.generarNivel("../niveles/nivel-1.txt");
		//REVISAR
		this.bucleJugador = new BucleJugador(this);
	}
	
	public Jugable obtenerJugador() {
		return jugador;
	}
	
	public void actualizar() {
		//TODO TICK
	}
}
