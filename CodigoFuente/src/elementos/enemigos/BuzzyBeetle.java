package elementos.enemigos;

import java.awt.Point;
import elementos.Sprite;
import observers.ObserverGrafico;
import visitors.Visitante;

public class BuzzyBeetle extends Enemigo {
	
	public BuzzyBeetle(Sprite sprite, Point posicion, Visitante visitor,
					    Point velocidadDireccional, ObserverGrafico observerGrafico) {
		super(sprite, posicion, visitor, velocidadDireccional, observerGrafico);
		this.puntosOtorgadosPorEliminacion = 30;
		this.puntosSustraidosPorMuerteCausada = 15;
	}
	
	@Override
	public void aceptarVisitante (Visitante visitante) {
		visitante.visitarBuzzyBeetle(this);
	}

}
