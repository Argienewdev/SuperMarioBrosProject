package juego;

import java.awt.Point;

public class Jugador {
	private static final int VIDAS_INICIALES = 3;
	
	private int vidas;
	
	private Point posicion;

	private int posicionY;
	
	private int posicionX;
	
	public Jugador(Point posicion) {
		vidas = VIDAS_INICIALES;
		posicionX = posicion.x;
		posicionY = posicion.y;
		this.posicion = posicion;
	}
	
	public Point actualizar(Point velocidad) {
		posicionX += velocidad.x;
		posicionY += velocidad.y;
		posicion.move(posicionX, posicionY);
		return posicion;
	}
	
	public boolean marioEnElPiso() {
		//TODO Esto en realidad se determina con el gestor de colisiones
		return posicionY >= 400;
	}
}
