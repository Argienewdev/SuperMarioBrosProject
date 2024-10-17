package elementos.powerUps;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Vector;

import elementos.Sprite;
import observers.ObserverGrafico;
import visitors.Visitante;

public class Monedas extends PowerUp {

	// Atributos
	protected int monedas;
	
	// Constructor
	public Monedas(Sprite sprite, Vector<Integer> posicion, Visitante visitor, 
				   int velocidad, Vector<Integer> direccion, 
				   ObserverGrafico observerGrafico, int puntosOtorgados) {
		super(sprite, posicion, visitor, velocidad, direccion, observerGrafico, puntosOtorgados);
		this.monedas = 0;
	}
	
	// Metodos
	public int getMonedas() {
		return this.monedas;
	}
	
	public void consumirMoneda() {
		this.monedas--;
	}
	
	public void agregarMoneda() {
		this.monedas++;
	}
	
	@Override
	public void aceptarVisitante(Visitante visitante) {
		visitante.visitarMonedas(this);
	}
	
}
