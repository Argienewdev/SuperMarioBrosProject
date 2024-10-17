package elementos.powerUps;

import java.util.Vector;

import fabricas.Sprite;
import observers.ObserverGrafico;
import visitors.Visitante;

public class ChampinionVerde extends PowerUp {
	
	// Constructor
	public ChampinionVerde(Sprite sprite, Vector<Integer> posicion, Visitante visitor,						 
						   ObserverGrafico observerGrafico) {
		super(sprite, posicion, visitor, 0, new Vector<Integer>(0,0), observerGrafico);
		/* El cero  y el vector (0,0), corresponden a la velocidad y dirección, que en 
		 * este caso son nulos al ser un power Up estático
		 */
	}
	
	// Metodos
	@Override
	public void aceptarVisitante (Visitante visitante) {
		visitante.visitarChampinionVerde(this);
	}

}
