package elementos.powerUp;

import java.util.Vector;

import fabricas.Sprite;
import visitors.Visitante;

public class ChampinionVerde extends PowerUp {
	
	public ChampinionVerde (Sprite sprite, Vector<Integer> posicion,Visitante visitor) {
		super(sprite,posicion,visitor,new Vector<Integer>(0,0),0,100);
	}
	
	public void aceptarVisitante (Visitante visitante) {
		visitante.visitarChampinionVerde(this);
	}

}
