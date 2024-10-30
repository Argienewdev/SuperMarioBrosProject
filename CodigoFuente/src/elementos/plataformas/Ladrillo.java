package elementos.plataformas;

import java.awt.Point;
import java.awt.Rectangle;

import elementos.Sprite;
import observers.ObserverGrafico;
import visitors.Visitante;

public class Ladrillo extends Plataforma {
	
	public Ladrillo(Sprite sprite, Point posicion, Visitante visitor, ObserverGrafico observerGrafico) {
		super(sprite, posicion, visitor, observerGrafico);
	}

	@Override
	public void aceptarVisitante(Visitante visitante) {
		visitante.visitarLadrillo(this);
	}
	public void eliminarDelNivel() {
		this.miNivel.agregarPlataformasAfectables(this);
		this.hitbox = new Rectangle(0, 0, 0, 0);
		this.removido = true;
	}

}
