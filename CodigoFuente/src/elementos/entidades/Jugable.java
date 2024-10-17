package elementos.entidades;

import java.util.Vector;

import elementos.powerUps.Monedas;
import fabricas.Sprite;
import observers.ObserverGrafico;
import visitors.Visitante;

public abstract class Jugable extends Entidad {
	
	// Atributos
	protected int vidas;
	
	protected int puntos;
	
	protected Monedas monedas;
	
	// Constructor
	public Jugable(Sprite sprite, Vector<Integer> posicion, Visitante visitor, 
				   int velocidad, Vector<Integer> direccion, 
				   ObserverGrafico observerGrafico, int vidas) {
		super(sprite, posicion, visitor, velocidad, direccion, observerGrafico);
		this.vidas = vidas;
		this.puntos = 0;
	}
	
	// Metodos
	public void ganarVida(int vidas) {
		this.vidas++;
	}
	
	public void perderVida(int vidas) {
		this.vidas--;
	}
	
	public void ganarPuntos(int puntos) {
		this.puntos++;
	}
	
	public void perderPuntos(int puntos) {
		this.puntos--;
	}
	
	public void recogerMoneda() {
		// TODO Auto-generated method stub
	}
	
	public void perderMoneda() {
		// TODO Auto-generated method stub
	}
	
	public int getVidas() {
		return this.vidas;
	}
	
	public int getPuntos() {
		return this.puntos;
	}
	
	public Monedas getMonedas() {
		return this.monedas;
	}
	
	public abstract void saltar(Vector<Integer> direccion);
	
	public abstract void aceptarVisitante(Visitante visitante);

}
