package elementos.entidades;

import java.util.Vector;
import fabricas.Sprite;
import observers.ObserverGrafico;
import visitors.Visitante;

public abstract class NoJugable extends Entidad {
	
	// Constructor
	public NoJugable(Sprite sprite, Vector<Integer> posicion, Visitante visitor, 
					 int velocidad, Vector<Integer> direccion, ObserverGrafico observerGrafico) {
		super(sprite, posicion, visitor, velocidad, direccion, observerGrafico);
	}

	public abstract void aceptarVisitante(Visitante visitante);
	
}
