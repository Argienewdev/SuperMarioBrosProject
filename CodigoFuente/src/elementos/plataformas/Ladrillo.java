package elementos.plataformas;

import java.util.Vector;

import elementos.Sprite;
import elementos.powerUps.Monedas;
import visitors.Visitante;

public class Ladrillo extends BloqueSolido{
	
	protected Monedas monedas;
	
	public Ladrillo(Sprite sprite, Vector<Integer> posicion, Visitante visitor, Monedas monedas) {
		super(sprite, posicion, visitor);
		this.monedas = monedas;
	}

	@Override
	public void aceptarVisitante(Visitante visitante) {
		// TODO Auto-generated method stub
		
	}

}
