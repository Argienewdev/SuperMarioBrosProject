package elementos.plataformas;

import java.util.Vector;

import elementos.Sprite;
import visitors.Visitante;

public abstract class Meta extends Plataforma{

	public Meta(Sprite sprite, Vector<Integer> posicion, Visitante visitor) {
		super(sprite, posicion, visitor);
		this.solido = false;
	}

	@Override
	public abstract void aceptarVisitante(Visitante visitante);

}
