package elementos.powerUps;

import java.util.Vector;

import elementos.Sprite;
import observers.ObserverGrafico;
import visitors.Visitante;

public class Estrella extends PowerUp {
	
	// Atributos
	public static final int TIEMPO_DURACION = 10;
	
	// Constructor
	public Estrella(Sprite sprite, Vector<Integer> posicion, Visitante visitor,
						   int velocidad, Vector<Integer> direccion, 
						   ObserverGrafico observerGrafico) {
		super(sprite, posicion, visitor, velocidad, direccion, observerGrafico);
	}
	
	// Metodos
	@Override
	public void aceptarVisitante (Visitante visitante) {
		visitante.visitarEstrella(this);
	}

}
