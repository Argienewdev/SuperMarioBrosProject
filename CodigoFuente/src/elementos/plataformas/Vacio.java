package elementos.plataformas;

import java.awt.Point;
import elementos.Sprite;
import fabricas.FabricaSprites;
import visitors.Visitante;

public class Vacio extends Plataforma {
	
	public Vacio (Sprite sprite, Point posicion, Visitante visitor) {
		super(sprite,posicion,visitor);
		this.setSolido(false);
	}
	
	public void aceptarVisitante (Visitante visitante) {
		visitante.visitar(this);
	}

}
