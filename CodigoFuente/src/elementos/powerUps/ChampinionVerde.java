package elementos.powerUps;

import java.util.Vector;

import elementos.Sprite;
import observers.ObserverGrafico;
import visitors.Visitante;

public class ChampinionVerde extends PowerUp {
	
	// Constructor
	public ChampinionVerde(Sprite sprite, Vector<Integer> posicion, Visitante visitor,
						   int velocidad, Vector<Integer> direccion, 
						   ObserverGrafico observerGrafico, int puntosOtorgados) {
		super(sprite, posicion, visitor, velocidad, direccion, observerGrafico, puntosOtorgados);
	}
	
	// Metodos
	@Override
	public void aceptarVisitante (Visitante visitante) {
		visitante.visitarChampinionVerde(this);
	}

}
