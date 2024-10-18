package juego;

import java.awt.Point;

public class CoordinadorActualizacionesJugador {
	
	private static final int POSICION_INICIAL_X = 50;
	
	private static final int POSICION_INICIAL_Y = 400;
	
	private ControladorMovimiento controladorMovimiento;
	
	private ActualizadorGraficoJugador actualizadorGraficoJugador;
	
	private EntidadJugador entidadJugador;
	
	private Point posicion;
	
	private Point velocidad;
	
	//TODO private ImageIcon o Sprite marioSprite;
	
	public CoordinadorActualizacionesJugador() {
		actualizadorGraficoJugador = new ActualizadorGraficoJugador();
		posicion = new Point(POSICION_INICIAL_X,POSICION_INICIAL_Y);
		controladorMovimiento = new ControladorMovimiento(posicion);
		velocidad = new Point(0,0);
		/**
		ImageIcon o Sprite marioSprite = actualizadorGraficoJugador.obtenerSpriteInicial();
		 
		ControladorMovimiento debe recibir el sprite inicial para Mario
		**/
		
		//TODO el jugador es creado por el coordinador de actualizaciones? no creo
		entidadJugador = new EntidadJugador();
	}
	
	private Point actualizarVelocidad() {
		return controladorMovimiento.actualizarVelocidad();
	}
	
	private Point actualizarPosicion() {
		return controladorMovimiento.actualizarPosicion();
	}
	
	private void actualizarSprite() {
		//Sprite o ImageIcon marioSprite = actualizadorGraficoJugador.actualizar(velocidad);
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

}
