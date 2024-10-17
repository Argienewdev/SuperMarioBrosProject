package elementos.powerUps;

import java.util.Vector;

import elementos.Sprite;
import elementos.entidades.NoJugable;
import observers.ObserverGrafico;
import visitors.Visitante;

public abstract class PowerUp extends NoJugable {


	
	// Constructor
	public PowerUp(Sprite sprite, Vector<Integer> posicion, Visitante visitor, 
				   int velocidad, Vector<Integer> direccion, ObserverGrafico observerGrafico) {
		super(sprite, posicion, visitor, velocidad, direccion, observerGrafico);
	}
	
	
	public abstract void aceptarVisitante(Visitante visitante);
	
}
