package juego;

import java.awt.Point;

public class ActualizadorDePosicionDeJugador {
	
	private Point posicion;

	private int posicionY;
	
	private int posicionX;
	
	private GestorDeColisiones gestorDeColisiones;
	
	public ActualizadorDePosicionDeJugador(Point posicion, GestorDeColisiones gestorDeColisiones) {
		this.posicionX = posicion.x;
		this.posicionY = posicion.y;
		this.posicion = posicion;
		this.gestorDeColisiones = gestorDeColisiones;
	}
	
	public Point actualizar(Point velocidad) {
		posicionX += velocidad.x;
		posicionY += velocidad.y;
		posicion.move(posicionX, posicionY);
		return posicion;
	}
	
	public boolean marioEnElPiso() {
		// Se deberia pasar el piso 
		return gestorDeColisiones.verificarColisiones(null);
	}
}
