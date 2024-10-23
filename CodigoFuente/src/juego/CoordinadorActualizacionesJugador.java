
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
	
	private FabricaSprites fabricaSprites;
	
	private GestorDeColisiones gestorDeColisiones;
	
	private Nivel nivel;
	
	public CoordinadorActualizacionesJugador(SensorDeTeclasJuego sensorDeTeclasJuego, Jugable marioJugable, FabricaSprites fabricaSprites, Nivel nivel, GestorDeColisiones gestorDeColisiones) {
		this.fabricaSprites = fabricaSprites;
		this.marioJugable = marioJugable;
		this.actualizadorDeSpriteJugador = new ActualizadorDeSpriteJugador(this.fabricaSprites, marioJugable);
		this.gestorDeColisiones = gestorDeColisiones;
		this.nivel = nivel;
		this.controladorMovimiento = new ControladorMovimiento(this.marioJugable, sensorDeTeclasJuego, nivel, gestorDeColisiones);
	}
	
	public void actualizar() {
		actualizarPosicion();
		actualizarSprite();
		actualizarObserverMario();
	}
	
	private void actualizarPosicion() {
		this.controladorMovimiento.actualizarPosicion();
	}
	
	private void actualizarSprite() {
		actualizadorDeSpriteJugador.actualizar();
	}
	
	private void actualizarObserverMario() {
		this.marioJugable.getObserverGrafico().actualizar();
	}

}