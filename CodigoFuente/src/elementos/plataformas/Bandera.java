package elementos.plataformas;

import java.util.Vector;

import elementos.Sprite;
import visitors.Visitante;

public class Bandera extends Meta {

	public Bandera(Sprite sprite, Vector<Integer> posicion, Visitante visitor) {
		super(sprite, posicion, visitor);
	}

	@Override
	public void aceptarVisitante(Visitante visitante) {
		visitante.visitarBandera(this);
	}

}
