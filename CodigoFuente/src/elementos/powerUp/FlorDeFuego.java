package elementos.powerUp;

import java.util.Vector;

import fabricas.Sprite;
import visitors.Visitante;

public class FlorDeFuego extends PowerUp {
	
	public FlorDeFuego (Sprite sprite, Vector<Integer> posicion) {
		this.sprite = sprite;
		this.posicion = posicion;
	}
	
	public void aceptarVisitante (Visitante visitante) {
		visitante.visitarFlorDeFuego(this);
	}

}
