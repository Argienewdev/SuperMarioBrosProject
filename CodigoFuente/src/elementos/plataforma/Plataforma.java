package elementos.plataforma;

import java.util.Vector;

import elementos.ElementoDeJuego;
import elementos.Sprite;
import visitors.Visitante;

public abstract class Plataforma extends ElementoDeJuego {
	
	//Atributos de instancia
	protected boolean solido;
	
    public Plataforma(Sprite sprite, Vector<Integer> posicion, Visitante visitor) {
		super(sprite, posicion, visitor);
		// TODO Auto-generated constructor stub
	}

    //Operaciones
    public void setSolido (boolean sol) {
        solido = sol;
    }
    
    public  boolean esSolida() {
        return solido;
    }
}
