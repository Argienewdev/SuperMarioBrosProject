
package juego;

import java.awt.Point;

import elementos.Sprite;
import elementos.entidades.Jugable;
import fabricas.FabricaEntidades;
import fabricas.FabricaSprites;
import sensoresDeTeclas.SensorDeTeclasJuego;

public class CoordinadorActualizacionesJugador {
	
	private ControladorMovimiento controladorMovimiento;
	
	private ActualizadorDeSpriteJugador actualizadorDeSpriteJugador;
	
	private Jugable marioJugable;
	
	private Point posicion;
	
	private Point velocidad;
	
	private Sprite marioSprite;
	
	private FabricaSprites fabricaSprites;
	
	private GestorDeColisiones gestorDeColisiones;
	
	private Nivel nivel;
	
	public CoordinadorActualizacionesJugador(SensorDeTeclasJuego sensorDeTeclasJuego, Jugable marioJugable, FabricaSprites fabricaSprites, Nivel nivel, GestorDeColisiones gestorDeColisiones) {
		this.fabricaSprites = fabricaSprites;
		this.marioJugable = marioJugable;
		this.actualizadorDeSpriteJugador = new ActualizadorDeSpriteJugador(this.fabricaSprites);
		this.posicion = new Point(this.marioJugable.getPosicion().x,this.marioJugable.getPosicion().y);
		this.velocidad = new Point(0,0);
		this.marioSprite = this.marioJugable.getSprite();
		this.gestorDeColisiones = gestorDeColisiones;
		this.nivel = nivel;
		this.controladorMovimiento = new ControladorMovimiento(this.marioJugable, sensorDeTeclasJuego, nivel, gestorDeColisiones);
	}
	
	private Point actualizarPosicion() {
		return this.controladorMovimiento.actualizarPosicion();
	}
	
	private void actualizarSprite() {
		this.marioSprite = actualizadorDeSpriteJugador.actualizar(velocidad);
	}
	
	private void actualizarMarioLabel() {
		this.marioJugable.getObserverGrafico().actualizar();
	}

	public void actualizar() {
		this.velocidad = actualizarPosicion();
		actualizarSprite();
		actualizarMarioLabel();
	}
	
	
}