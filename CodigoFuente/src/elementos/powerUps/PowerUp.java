package elementos.powerUps;

import java.util.Vector;

import elementos.Sprite;
import elementos.entidades.NoJugable;
import observers.ObserverGrafico;
import visitors.Visitante;

public abstract class PowerUp extends NoJugable {

	// Atributos
	protected int puntosOtorgados;
	
	// Constructor
	public PowerUp(Sprite sprite, Vector<Integer> posicion, Visitante visitor, 
				   int velocidad, Vector<Integer> direccion, 
				   ObserverGrafico observerGrafico, int puntosOtorgados) {
		super(sprite, posicion, visitor, velocidad, direccion, observerGrafico);
		this.puntosOtorgados = puntosOtorgados;
	}
	
	// Metodos
	public int getPuntosOtorgados() {
		return this.puntosOtorgados;
	}
	
	public abstract void aceptarVisitante(Visitante visitante);
	
}
