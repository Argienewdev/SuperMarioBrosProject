package elementos.plataforma;

import java.util.Vector;

import fabricas.Sprite;
import visitors.Visitante;

public class Vacio extends Plataforma {
	
	public Vacio (Sprite sprite, Vector<Integer> posicion) {
		this.sprite = sprite;
		this.posicion = posicion;
	}
	
	public void aceptarVisitante (Visitante visitante) {
		visitante.visitarVacio(this);
	}

}
