package elementos.plataformas;

import java.awt.Point;
import elementos.Sprite;
import observers.ObserverGrafico;
import visitors.Visitante;

public abstract class Meta extends Plataforma{

	@SuppressWarnings("exports")
	public Meta(Sprite sprite, Point posicion, Visitante visitor, ObserverGrafico observerGrafico) {
		super(sprite, posicion, visitor, observerGrafico);
		this.solido = false;
	}

	public abstract void aceptarVisitante(Visitante visitante);

}
