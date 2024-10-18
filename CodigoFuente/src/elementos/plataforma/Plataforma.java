package elementos.plataforma;

import java.util.Vector;

import elementos.ElementoDeJuego;
import elementos.Sprite;
import visitors.Visitante;

public abstract class Plataforma extends ElementoDeJuego {
	
	protected boolean solido;
	
    public Plataforma(Sprite sprite, Vector<Integer> posicion, Visitante visitor) {
		super(sprite, posicion, visitor);
	}

    public void setSolido (boolean sol) {
        this.solido = sol;
    }
    
    public  boolean esSolida() {
        return this.solido;
    }
}
