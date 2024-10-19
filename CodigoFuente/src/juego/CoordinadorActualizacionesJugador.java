
package juego;

import java.awt.Point;

import elementos.Sprite;
import elementos.entidades.Jugable;
import fabricas.FabricaEntidades;
import sensoresDeTeclas.SensorDeTeclasJuego;

public class CoordinadorActualizacionesJugador {
	
	private ControladorMovimiento controladorMovimiento;
	
	private ActualizadorGraficoJugador actualizadorGraficoJugador;
	
	private Jugable marioJugable;
	
	private Point posicion;
	
	private Point velocidad;
	
	private Sprite marioSprite;
	
	public CoordinadorActualizacionesJugador(SensorDeTeclasJuego sensorDeTeclasJuego, Jugable marioJugable) {
		this.actualizadorGraficoJugador = new ActualizadorGraficoJugador();
		this.posicion = new Point(marioJugable.getPosicion().x,marioJugable.getPosicion().y);
		this.velocidad = new Point(0,0);
		this.marioSprite = marioJugable.getSprite();
		this.controladorMovimiento = new ControladorMovimiento(marioJugable, sensorDeTeclasJuego);
		this.marioJugable = marioJugable;
	}
	
	private Point actualizarVelocidad() {
		return controladorMovimiento.actualizarVelocidad();
	}
	
	private Point actualizarPosicion() {
		return controladorMovimiento.actualizarPosicion();
	}
	
	private void actualizarSprite() {
		marioSprite = actualizadorGraficoJugador.actualizar(marioSprite, velocidad);
		//TODO Recibe la velocidad para ver en que direccion va para retornar el sprite adecuado
		//este metodo guarda el sprite para mario en un atributo
	}
	
	private void actualizarMarioLabel() {
		marioJugable.setPosicion(posicion);
	}

	public void actualizar() {
		velocidad = actualizarVelocidad();
		posicion = actualizarPosicion(); 
		actualizarSprite();
		actualizarMarioLabel();
	}
	
}