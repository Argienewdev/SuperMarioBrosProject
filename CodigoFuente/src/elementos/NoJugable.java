package elementos;

import java.util.Vector;

import fabricas.Sprite;
import visitors.Visitante;

public abstract class NoJugable extends Entidad{

	public NoJugable(Sprite sprite, Vector<Integer> posicion, Visitante visitor, Vector<Integer> direccion,
			int velocidad) {
		super(sprite, posicion, visitor, direccion, velocidad);
	}
}
