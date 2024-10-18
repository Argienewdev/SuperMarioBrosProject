package elementos.powerUps;

import java.util.Vector;

import elementos.Sprite;
import observers.ObserverGrafico;
import visitors.Visitante;

public class Monedas extends PowerUp {

	protected int cantidadMonedas;
	
	// Constructor
	public Monedas(Sprite sprite, Vector<Integer> posicion, Visitante visitor,  
			   ObserverGrafico observerGrafico,int cantidadMonedas) {
	super(sprite, posicion, visitor, 0, new Vector<Integer>(0,0), observerGrafico);
	this.cantidadMonedas = cantidadMonedas;
	}
	
	public void consumirMonedas() {
		this.cantidadMonedas--;
	}
	
	public void aumentarMonedas() {
		this.cantidadMonedas++;
	}
	
	public int getCantidadMonedas() {
		return this.cantidadMonedas;
	}
	
	public void aceptarVisitante(Visitante visitante) {
		visitante.visitarMonedas(this);
	}
	
}
