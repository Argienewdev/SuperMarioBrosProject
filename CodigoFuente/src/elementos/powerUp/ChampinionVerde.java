package elementos.powerUp;

import java.util.Vector;

import fabricas.Sprite;
import visitors.Visitante;

public class ChampinionVerde extends PowerUp {
	
	public ChampinionVerde (Sprite sprite, Vector<Integer> posicion) {
		this.sprite = sprite;
		this.posicion = posicion;
	}
	
	public void aceptarVisitante (Visitante visitante) {
		visitante.visitarChampinionVerde(this);
	}

}
