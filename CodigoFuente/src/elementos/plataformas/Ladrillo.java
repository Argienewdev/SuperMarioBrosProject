package elementos.plataformas;

import java.util.Vector;

import elementos.Sprite;
import visitors.Visitante;

public class Ladrillo extends BloqueSolido {
	
	public Ladrillo(Sprite sprite, Vector<Integer> posicion, Visitante visitor) {
		super(sprite, posicion, visitor);
	}

	@Override
	public void aceptarVisitante(Visitante visitante) {
		visitante.visitarLadrillo(this);
	}

}
