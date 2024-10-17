package elementos.entidades;

import java.util.Vector;

import elementos.Sprite;
import observers.ObserverGrafico;
import visitors.Visitante;

public class Fireball extends NoJugable {
	
	// Atributos
	protected static final int DANIO = 1; // Consultar valor
	
	// Constructor
	public Fireball(Sprite sprite, Vector<Integer> posicion, Visitante visitor, 
					int velocidad, Vector<Integer> direccion, ObserverGrafico observerGrafico) {
		super(sprite, posicion, visitor, velocidad, direccion, observerGrafico);
	}
	
	// Metodos
	@Override
	public void aceptarVisitante (Visitante visitante) {
		visitante.visitarFireball(this);
	}

}
