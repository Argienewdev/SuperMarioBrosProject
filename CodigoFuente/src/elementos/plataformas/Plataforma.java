package elementos.plataformas;

import java.awt.Point;

import elementos.ElementoDeJuego;
import elementos.Sprite;
import fabricas.FabricaSprites;
import observers.ObserverGrafico;
import visitors.Visitante;

public abstract class Plataforma extends ElementoDeJuego {
	
	protected boolean solido;
	
	protected boolean removido;
	
	public Plataforma(Sprite sprite, Point posicion, Visitante visitor, ObserverGrafico observerGrafico) {
		super(sprite, posicion, visitor, observerGrafico);
		removido = false;
	}
	
	public void setSolido(boolean solido) {
		this.solido = solido;
	}

	public boolean esSolido() {
		return this.solido;
	}
	
	public  void actualizarSprite(FabricaSprites fabricaSprites) {
		if(this.removido) {
			this.setSprite(fabricaSprites.getSpriteInvisible());
		}
	}
}
