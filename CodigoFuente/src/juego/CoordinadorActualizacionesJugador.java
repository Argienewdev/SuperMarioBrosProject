
package juego;

import java.awt.Point;

import elementos.Sprite;
import elementos.entidades.Jugable;
import fabricas.FabricaEntidades;
import sensoresDeTeclas.SensorDeTeclasJuego;

public class CoordinadorActualizacionesJugador {
	
	private static final int POSICION_INICIAL_X = 50;
	
	private static final int POSICION_INICIAL_Y = 400;
	
	private FabricaEntidades fabricaEntidades;
	
	private ControladorMovimiento controladorMovimiento;
	
	private ActualizadorGraficoJugador actualizadorGraficoJugador;
	
	private EntidadJugador entidadJugador;
	
	private Jugable jugador;
	
	private Point posicion;
	
	private Point velocidad;
	
	private Sprite marioSprite;
	
	public CoordinadorActualizacionesJugador(SensorDeTeclasJuego sensorDeTeclasJuego) {
		actualizadorGraficoJugador = new ActualizadorGraficoJugador();
		posicion = new Point(POSICION_INICIAL_X,POSICION_INICIAL_Y);
		velocidad = new Point(0,0);
		marioSprite = actualizadorGraficoJugador.obtenerSpriteInicial();
		controladorMovimiento = new ControladorMovimiento(posicion, sensorDeTeclasJuego);
		//TODO todavia no me cierra que mario este aca en esta clase
		//TODO el jugador es creado por el coordinador de actualizaciones? no creo
		entidadJugador = new EntidadJugador(posicion, marioSprite);
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
		//TODO entidadJugador.actualizar(posicion, marioSprite);
	}

	public void actualizar() {
		velocidad = actualizarVelocidad();
		posicion = actualizarPosicion(); 
		actualizarSprite();
		actualizarMarioLabel();
	}
	
	public Jugable obtenerJugador() {
		return jugador;
	}
}
