package elementos.entidades;

import java.util.Vector;

import elementos.Sprite;
import elementos.powerUps.Moneda;
import observers.ObserverGrafico;
import visitors.Visitante;

public abstract class Jugable extends Entidad {
	
	// Atributos
	protected int vidas;
	
	protected int puntos;
	
	protected Moneda monedas;
	
	
	// Metodos
	public void ganarVida() {
		this.vidas++;
	}
	
	public void perderVida() {
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
	
	public Moneda getMonedas() {
		return this.monedas;
	}
	
	public abstract void saltar(Vector<Integer> direccion);
	
	public abstract void aceptarVisitante(Visitante visitante);

}
