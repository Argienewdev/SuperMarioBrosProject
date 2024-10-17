package elementos.powerUps;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Vector;

import fabricas.Sprite;
import observers.ObserverGrafico;
import visitors.Visitante;

public class Monedas extends PowerUp {

	// Atributos
	protected Collection<Integer> monedas;
	
	// Constructor
	public Monedas(Sprite sprite, Vector<Integer> posicion, Visitante visitor, 
				   int velocidad, Vector<Integer> direccion, 
				   ObserverGrafico observerGrafico, int puntosOtorgados) {
		super(sprite, posicion, visitor, velocidad, direccion, observerGrafico, puntosOtorgados);
		this.monedas = new ArrayList<Integer>(); // Detallar mejor
	}
	
	// Metodos
	public Collection<Integer> getMonedas() {
		return this.monedas;
	}
	
	@Override
	public void aceptarVisitante(Visitante visitante) {
		visitante.visitarMonedas(this);
	}
	
}
