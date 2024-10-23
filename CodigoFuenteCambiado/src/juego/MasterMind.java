
package juego;

import java.awt.Point;

import elementos.entidades.NoJugable;
import observers.ObserverEntidades;

public class MasterMind {
	
	protected ObserverEntidades observer;
	
	protected GestorDeColisiones gestor;
	
	public MasterMind (ObserverEntidades observer, GestorDeColisiones gestor) {
		this.observer = observer;
		this.gestor = gestor;
	}
	
	@SuppressWarnings("exports")
	public boolean moverEntidad (NoJugable entidad, Point posicion) {
		Point posActual = entidad.getPosicion();
		mover(entidad,posicion);
		boolean pudoMover = gestor.verificarColisiones(entidad);
		if (pudoMover)
			observer.actualizar();
		else  
			mover(entidad,posActual);
		return pudoMover;
	}
	
	private void mover (NoJugable entidad, Point posicion) {
		Point posActual = entidad.getPosicion();
		int posX = posicion.x;
		int posY = posicion.y;
		posActual.move(posX,posY);
	}

}
