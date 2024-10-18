package elementos.entidades;

import java.util.Vector;

import elementos.Sprite;
import observers.ObserverGrafico;
import visitors.Visitante;

public abstract class NoJugable extends Entidad {
	
	// Constructor
	public NoJugable(Sprite sprite, Vector<Integer> posicion, Visitante visitor, 
					 int velocidad, Vector<Integer> direccion, ObserverGrafico observerGrafico) {
		super(sprite, posicion, visitor);
		this.velocidad=velocidad;
		this.direccion=direccion;
		this.observerGrafico=observerGrafico;
	}

	public abstract void aceptarVisitante(Visitante visitante);
	
}
