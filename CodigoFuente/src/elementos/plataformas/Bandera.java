package elementos.plataformas;

import java.util.Vector;

import fabricas.Sprite;
import visitors.Visitante;

public class Bandera extends Meta {

	public Bandera(Sprite sprite, Vector<Integer> posicion, Visitante visitor) {
		super(sprite, posicion, visitor);
	}

}
