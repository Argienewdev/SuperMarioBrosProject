package elementos.plataformas;

import java.awt.Point;
import java.util.Vector;

import elementos.Sprite;
import fabricas.FabricaSprites;
import visitors.Visitante;

public class BloqueSolido extends Plataforma{
	
	public BloqueSolido(Sprite sprite, Point posicion, Visitante visitor) {
		super(sprite, posicion, visitor);
		this.setSolido(true);
	}

	@Override
	public void aceptarVisitante(Visitante visitante) {
		visitante.visitar(this);
	}

}
