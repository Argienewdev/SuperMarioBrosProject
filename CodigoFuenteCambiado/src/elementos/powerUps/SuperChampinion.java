package elementos.powerUps;

import java.awt.Point;
import elementos.Sprite;
import elementos.personajes.ContextoMario;
import observers.ObserverGrafico;
import visitors.Visitante;

public class SuperChampinion extends PowerUp {
	
	public SuperChampinion(Sprite sprite, Point posicion, Visitante visitor,
						   Point velocidadDireccional, ObserverGrafico observerGrafico) {
		super(sprite, posicion, visitor, velocidadDireccional, observerGrafico);
	}
	
	@Override
	public void aceptarVisitante (Visitante visitante) {
		visitante.visitar(this);
	}

	public int obtenerPuntosPorDefault() {
		return 10;
	}
	
	public int obtenerPuntosPorSuper() {
		return 50;
	}
	
	public int obtenerPuntosPorInvencible() {
		return obtenerPuntosPorSuper();
	}
	
	public int obtenerPuntosPorFuego() {
		return obtenerPuntosPorSuper();
	}
	
	

}
