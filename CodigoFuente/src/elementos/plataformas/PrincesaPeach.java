package elementos.plataformas;

import java.awt.Point;
import elementos.Sprite;
import fabricas.FabricaSprites;
import visitors.Visitante;

public class PrincesaPeach extends Meta{

	public PrincesaPeach(Sprite sprite, Point posicion, Visitante visitor) {
		super(sprite, posicion, visitor);
	}

	@Override
	public void aceptarVisitante(Visitante visitante) {
		visitante.visitar(this);
	}

}
