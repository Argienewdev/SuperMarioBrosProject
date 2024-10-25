package elementos.plataformas;

import java.awt.Point;
import elementos.Sprite;
import visitors.Visitante;

public class Piso extends BloqueSolido{
	
	public Piso(Sprite sprite, Point posicion, Visitante visitor) {
		super(sprite, posicion, visitor);
		this.setSolido(true);
	}

	@Override
	public void aceptarVisitante(Visitante visitante) {
		visitante.visitar(this);
	}

}
