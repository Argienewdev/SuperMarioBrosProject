package elementos;

import java.util.Vector;

import fabricas.Sprite;
import visitors.Visitante;

public class Ladrillo extends BloqueSolido{
	
	protected Monedas monedas;
	
	public Ladrillo(Sprite sprite, Vector<Integer> posicion, Visitante visitor) {
		super(sprite, posicion, visitor);
		// TODO Auto-generated constructor stub
	}

}
