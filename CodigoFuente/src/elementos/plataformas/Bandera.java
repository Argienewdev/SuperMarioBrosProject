package elementos.plataformas;

import java.awt.Point;
import elementos.Sprite;
import observers.ObserverGrafico;
import visitors.Visitante;

public class Bandera extends Meta {

	public Bandera(Sprite sprite, Point posicion, Visitante visitor, ObserverGrafico observerGrafico) {
		super(sprite, posicion, visitor, observerGrafico);
	}

	@Override
	public void aceptarVisitante(Visitante visitante) {
		visitante.visitarBandera(this);
	}

}
