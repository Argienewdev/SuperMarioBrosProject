package elementos.plataformas;

import java.awt.Point;
import elementos.Sprite;
import visitors.Visitante;

public abstract class Meta extends Plataforma{

	public Meta(Sprite sprite, Point posicion, Visitante visitor) {
		super(sprite, posicion, visitor);
		this.solido = false;
	}

	@Override
	public abstract void aceptarVisitante(Visitante visitante);

}
