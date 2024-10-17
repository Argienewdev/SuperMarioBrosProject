package elementos.powerUps;

import java.util.Vector;

import elementos.Sprite;
import observers.ObserverGrafico;
import visitors.Visitante;

public class FlorDeFuego extends PowerUp {
	
	public FlorDeFuego(Sprite sprite, Vector<Integer> posicion, Visitante visitor,					   
					   ObserverGrafico observerGrafico) {
		super(sprite, posicion, visitor, 0, new Vector<Integer>(0,0), observerGrafico);
		/* El cero  y el vector (0,0), corresponden a la velocidad y dirección, que en 
		 * este caso son nulos al ser un power Up estático
		 */
	}
	
	@Override
	public void aceptarVisitante (Visitante visitante) {
		visitante.visitarFlorDeFuego(this);
	}

}
