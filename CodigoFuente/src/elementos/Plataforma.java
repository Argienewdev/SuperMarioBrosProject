package elementos;

import java.util.Vector;

import fabricas.Sprite;
import visitors.Visitante;

public abstract class Plataforma extends ElementoDeJuego{
	
	protected boolean solido;

	public Plataforma(Sprite sprite, Vector<Integer> posicion, Visitante visitor, boolean solido) {
		super(sprite, posicion, visitor);
		this.solido =solido;
	}
	
	public void setSolido(boolean solido) {
		this.solido =solido;
	}
	
	public boolean esSolido() {
		return solido;
	}
}
