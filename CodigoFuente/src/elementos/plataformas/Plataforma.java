package elementos.plataformas;

import java.awt.Point;

import elementos.ElementoDeJuego;
import elementos.Sprite;
import visitors.Visitante;

public abstract class Plataforma extends ElementoDeJuego{
	
	protected boolean solido;

	public Plataforma(Sprite sprite, Point posicion, Visitante visitor) {
		super(sprite, posicion, visitor);
	}
	
	public void setSolido(boolean solido) {
		this.solido =solido;
	}
	
	public boolean esSolido() {
		return this.solido;
	}
}
