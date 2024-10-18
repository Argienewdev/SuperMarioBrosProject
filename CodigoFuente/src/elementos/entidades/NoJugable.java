package elementos.entidades;

import java.awt.Point;

import elementos.Sprite;
import observers.ObserverGrafico;
import visitors.Visitante;

public abstract class NoJugable extends Entidad {
	
	public NoJugable(Sprite sprite, Point posicion, Visitante visitor, 
					 int velocidad, Point direccion, ObserverGrafico observerGrafico) {
		super(sprite, posicion, visitor);
		this.velocidad = velocidad;
		this.direccion = direccion;
		this.observerGrafico = observerGrafico;
	}

	public abstract void aceptarVisitante(Visitante visitante);
	
}
