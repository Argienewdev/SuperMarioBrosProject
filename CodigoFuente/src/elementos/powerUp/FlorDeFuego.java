package elementos.powerUp;

import java.util.Vector;

import fabricas.Sprite;
import visitors.Visitante;

public class FlorDeFuego extends PowerUp {
	
	public FlorDeFuego (Sprite sprite, Vector<Integer> posicion,Visitante visitor) {
		super(sprite,posicion,visitor,new Vector<Integer>(0,0),0,5);
	}
	
	public void aceptarVisitante (Visitante visitante) {
		visitante.visitarFlorDeFuego(this);
	}

}
