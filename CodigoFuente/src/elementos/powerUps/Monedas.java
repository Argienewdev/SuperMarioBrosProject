package elementos.powerUps;

import java.util.Vector;

import fabricas.Sprite;
import observers.ObserverGrafico;
import visitors.Visitante;

public class Monedas extends PowerUp {

	// Atributos
	protected int cantidadMonedas;
	
	// Constructor
	public Monedas(Sprite sprite, Vector<Integer> posicion, Visitante visitor,  
				   ObserverGrafico observerGrafico,int cantidadMonedas) {
		super(sprite, posicion, visitor, 0, new Vector<Integer>(0,0), observerGrafico);
		this.cantidadMonedas = cantidadMonedas;
	}
	
	// Metodos
	public int getCantidadMonedas() {
		return cantidadMonedas;
	}
	
	@Override
	public void aceptarVisitante(Visitante visitante) {
		visitante.visitarMonedas(this);
	}
	
}
