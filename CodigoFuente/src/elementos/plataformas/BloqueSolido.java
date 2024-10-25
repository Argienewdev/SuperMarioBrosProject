package elementos.plataformas;

import java.awt.Point;
import elementos.Sprite;
import visitors.Visitante;

public class BloqueSolido extends Plataforma{
	
	public BloqueSolido(Sprite sprite, Point posicion, Visitante visitor) {
		super(sprite, posicion, visitor);
		this.setSolido(true);
	}

	@Override
	public void aceptarVisitante(Visitante visitante) {
		visitante.visitarBloqueSolido(this);
	}

}
