package juego;

import elementos.entidades.Jugable;
import elementos.personajes.MarioDefault;
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
	
	private Nivel nivel;
	
	public Partida(SensorDeTeclasJuego sensorDeTeclasJuego) {
		this.sensorDeTeclasJuego = sensorDeTeclasJuego;
		//TODO la partida indica al nivel que se genere, luego pido al jugador para tenerlo y que 
		//el controlador de vistas y el coordinador puedan acceder a el para alterarlo
		this.fabricaSpritesModoAlternativo = new FabricaSpritesModoAlternativo("src/imagenes/sprites");
		this.fabricaSpritesModoOriginal = new FabricaSpritesModoOriginal("src/imagenes/sprites");
		//TODO Falta un condicional para ver que fabrica mandarle a la fabrica de entidades, la partida deberia saber el modo
		this.fabricaEntidades = new FabricaEntidades(fabricaSpritesModoOriginal);
		this.generadorDeNivel = new GeneradorDeNivel(fabricaEntidades);
		nivel = generadorDeNivel.generarNivel("src/niveles/nivel-1.txt");
		jugador = nivel.getMario();
		this.coordinadorActualizacionesJugador = new CoordinadorActualizacionesJugador(this.sensorDeTeclasJuego, this.jugador);
		this.bucleJugador = new BucleJugador(this);
	}
	
	public Jugable obtenerJugador() {
		return jugador;
	}
	
	public void actualizar() {
		coordinadorActualizacionesJugador.actualizar();
	}
}
