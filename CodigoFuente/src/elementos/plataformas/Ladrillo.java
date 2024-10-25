package elementos.plataformas;

import java.awt.Point;
import java.awt.Rectangle;

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
	public void eliminarDelNivel() {
		this.miNivel.addPlataformasAfectables(this);
		this.hitbox = new Rectangle(0, 0, 0, 0);
		this.removido = true;
	}

}
