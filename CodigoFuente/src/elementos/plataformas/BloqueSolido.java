package elementos.plataformas;

import java.awt.Point;
import java.util.Vector;

import elementos.Sprite;
import visitors.Visitante;

public abstract class BloqueSolido extends Plataforma{
	
	public BloqueSolido(Sprite sprite, Point posicion, Visitante visitor) {
		super(sprite, posicion, visitor);
		this.setSolido(true);
	}

}
