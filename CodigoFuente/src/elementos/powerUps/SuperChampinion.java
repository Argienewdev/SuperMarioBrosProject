package elementos.powerUps;

import java.util.Vector;

import fabricas.Sprite;
import observers.ObserverGrafico;
import visitors.Visitante;

public class SuperChampinion extends PowerUp {
	
	// Constructor
	public SuperChampinion(Sprite sprite, Vector<Integer> posicion, Visitante visitor,
						   int velocidad, Vector<Integer> direccion, 
						   ObserverGrafico observerGrafico) {
		super(sprite, posicion, visitor, velocidad, direccion, observerGrafico);
	}
	
	// Metodos
	@Override
	public void aceptarVisitante (Visitante visitante) {
		visitante.visitarSuperChampinion(this);
	}

}
