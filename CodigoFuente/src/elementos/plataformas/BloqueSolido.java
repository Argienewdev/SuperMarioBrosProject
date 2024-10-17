package elementos.plataformas;

import java.util.Vector;

import fabricas.Sprite;
import visitors.Visitante;

public abstract class BloqueSolido extends Plataforma{
	
	public BloqueSolido(Sprite sprite, Vector<Integer> posicion, Visitante visitor) {
		super(sprite, posicion, visitor);
		this.setSolido(true);
	}

}
