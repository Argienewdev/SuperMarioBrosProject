package elementos.powerUps;

import java.util.Vector;

import fabricas.Sprite;
import observers.ObserverGrafico;
import visitors.Visitante;

public class FlorDeFuego extends PowerUp {
	
	// Constructor
	public FlorDeFuego(Sprite sprite, Vector<Integer> posicion, Visitante visitor,
					   int velocidad, Vector<Integer> direccion, 
					   ObserverGrafico observerGrafico, int puntosOtorgados) {
		super(sprite, posicion, visitor, velocidad, direccion, observerGrafico, puntosOtorgados);
	}
	
	// Metodos
	@Override
	public void aceptarVisitante (Visitante visitante) {
		visitante.visitarFlorDeFuego(this);
	}

}
