package elementos.plataformas;

import java.awt.Point;
import elementos.Sprite;
import observers.ObserverGrafico;
import visitors.Visitante;

public class Vacio extends BloqueSolido{
	
	public Vacio(Sprite sprite, Point posicion, Visitante visitor, ObserverGrafico observerGrafico) {
		super(sprite, posicion, visitor, observerGrafico);
		this.setSolido(true);
	}

	@Override
	public void aceptarVisitante(Visitante visitante) {
		visitante.visitarVacio(this);
	}

}
