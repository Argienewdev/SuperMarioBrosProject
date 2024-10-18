package elementos.powerUps;

import java.awt.Point;
import java.util.Vector;

import elementos.Sprite;
import elementos.entidades.NoJugable;
import observers.ObserverGrafico;
import visitors.Visitante;

public abstract class PowerUp extends NoJugable {

	public PowerUp(Sprite sprite, Point posicion, Visitante visitor, 
				   int velocidad, Point direccion, ObserverGrafico observerGrafico) {
		super(sprite, posicion, visitor, velocidad, direccion, observerGrafico);
	}
	
	public abstract void aceptarVisitante(Visitante visitante);
	
	public abstract int getPuntosOtorgados();
	
}
