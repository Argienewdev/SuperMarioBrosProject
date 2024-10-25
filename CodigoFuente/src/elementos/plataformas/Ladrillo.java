package elementos.plataformas;

import java.awt.Point;
import elementos.Sprite;
import visitors.Visitante;

public class Ladrillo extends BloqueSolido {
	
	public Ladrillo(Sprite sprite, Point posicion, Visitante visitor) {
		super(sprite, posicion, visitor);
	}

	@Override
	public void aceptarVisitante(Visitante visitante) {
		visitante.visitarLadrillo(this);
	}

}
