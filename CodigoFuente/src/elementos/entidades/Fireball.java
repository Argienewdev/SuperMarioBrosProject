package elementos.entidades;

import java.awt.Point;
import elementos.Sprite;
import observers.ObserverGrafico;
import visitors.Visitante;

public class Fireball extends NoJugable {
	
	protected static final int DANIO = 1; // Consultar valor
	
	public Fireball(Sprite sprite, Point posicion, Visitante visitor, 
					int velocidad, Point direccion, ObserverGrafico observerGrafico) {
		super(sprite, posicion, visitor, velocidad, direccion, observerGrafico);
	}
	
	// Metodos
	@Override
	public void aceptarVisitante (Visitante visitante) {
		visitante.visitarFireball(this);
	}

}
