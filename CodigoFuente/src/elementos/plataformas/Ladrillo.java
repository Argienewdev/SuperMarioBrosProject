package elementos.plataformas;

import java.util.Vector;

import elementos.powerUps.Monedas;
import fabricas.Sprite;
import visitors.Visitante;

public class Ladrillo extends BloqueSolido{
	
	protected Monedas monedas;
	
	public Ladrillo(Sprite sprite, Vector<Integer> posicion, Visitante visitor) {
		super(sprite, posicion, visitor);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void aceptarVisitante(Visitante visitante) {
		// TODO Auto-generated method stub
		
	}

}
