package elementos.plataformas;

import java.util.Vector;

import elementos.ElementoDeJuego;
import elementos.Sprite;
import visitors.Visitante;

public abstract class Plataforma extends ElementoDeJuego{
	
	protected boolean solido;

	public Plataforma(Sprite sprite, Vector<Integer> posicion, Visitante visitor) {
		super(sprite, posicion, visitor);
	}
	
	public void setSolido(boolean solido) {
		this.solido =solido;
	}
	
	public boolean esSolido() {
		return this.solido;
	}
}
