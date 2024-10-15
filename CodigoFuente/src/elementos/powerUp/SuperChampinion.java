package elementos.powerUp;

import java.util.Vector;

import fabricas.Sprite;
import visitors.Visitante;

public class SuperChampinion extends PowerUp {
	
	public SuperChampinion (Sprite sprite, Vector<Integer> posicion,Visitante visitor, Vector<Integer> direccion, int velocidad) {
		super(sprite,posicion,visitor,new Vector<Integer>(0,0),0,10);
	}
	public void aceptarVisitante (Visitante visitante) {
		visitante.visitarSuperChampinion(this);
	}

}
