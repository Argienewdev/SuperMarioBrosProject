package elementos.powerUps;

import java.util.Vector;

import elementos.Sprite;
import observers.ObserverGrafico;
import visitors.Visitante;

public class Moneda extends PowerUp {

	protected int cantidadMonedas;
	
	// Constructor
	public Moneda(Sprite sprite, Vector<Integer> posicion, Visitante visitor, 
				   int velocidad, Vector<Integer> direccion, 
				   ObserverGrafico observerGrafico, int puntosOtorgados) {
		super(sprite, posicion, visitor, velocidad, direccion, observerGrafico, puntosOtorgados);
		this.monedas = 0;
	
	public int getCantidadMonedas() {
		return this.cantidadMonedas;
	}
	
	public void aceptarVisitante(Visitante visitante) {
		visitante.visitarMonedas(this);
	}
	
}
