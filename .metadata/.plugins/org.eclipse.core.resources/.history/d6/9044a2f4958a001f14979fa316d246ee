package elementos.entidades;

import java.util.Vector;

import fabricas.Sprite;
import visitors.Visitante;

public class Fireball extends NoJugable {
	
	protected static final int DANIO=1;
	
	public Fireball (Sprite sprite, Vector<Integer> posicion,Visitante visitor, Vector<Integer> direccion, int velocidad, int danio) {
		super(sprite, posicion,visitor,direccion,velocidad);
	}
	
	public void aceptarVisitante (Visitante visitante) {
		visitante.visitarFireball(this);
	}

}
