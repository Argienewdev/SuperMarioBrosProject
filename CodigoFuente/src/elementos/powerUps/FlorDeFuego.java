package elementos.powerUps;

import java.awt.Point;
import elementos.Sprite;
import observers.ObserverGrafico;
import visitors.Visitante;

public class FlorDeFuego extends PowerUp {
	
	public FlorDeFuego(Sprite sprite, Point posicion, Visitante visitor,					   
					   ObserverGrafico observerGrafico) {
		super(sprite, posicion, visitor, 0, new Point (0,0), observerGrafico);
	}
	
	@Override
	public void aceptarVisitante (Visitante visitante) {
		visitante.visitarFlorDeFuego(this);
	}
	
	public int obtenerPuntosPorDefault() {
		return 5;
	}
	
	public int obtenerPuntosPorSuper() {
		return 30;
	}
	
	public int obtenerPuntosPorInvencible() {
		return obtenerPuntosPorSuper();
	}
	
	public int obtenerPuntosPorFuego() {
		return 50;
	}

}
