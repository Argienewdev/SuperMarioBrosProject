package elementos.plataformas;

import java.awt.Point;
import elementos.Sprite;
import observers.ObserverGrafico;
import visitors.Visitante;

public class Piso extends BloqueSolido{
	
	public Piso(Sprite sprite, Point posicion, Visitante visitor, ObserverGrafico observerGrafico) {
		super(sprite, posicion, visitor, observerGrafico);
		this.setSolido(true);
	}

	@Override
	public void aceptarVisitante(Visitante visitante) {
		visitante.visitarPiso(this);
	}

}
