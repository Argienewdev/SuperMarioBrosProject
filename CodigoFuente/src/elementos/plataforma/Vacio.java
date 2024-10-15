package elementos.plataforma;

import java.util.Vector;

import fabricas.Sprite;
import visitors.Visitante;

public class Vacio extends Plataforma {
	
	public Vacio (Sprite sprite, Vector<Integer> posicion,Visitante visitor) {
		super(sprite,posicion,visitor,false);
	}
	
	public void aceptarVisitante (Visitante visitante) {
		visitante.visitarVacio(this);
	}

}
