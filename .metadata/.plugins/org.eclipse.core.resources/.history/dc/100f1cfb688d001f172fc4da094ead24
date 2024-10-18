package elementos.entidades;

import java.util.Vector;

import elementos.Sprite;
import elementos.powerUps.Monedas;
import visitors.Visitante;

public abstract class Jugable extends Entidad {
	
	// Atributos
	protected int vidas;
	
	protected int puntos;
	
	protected Monedas monedas;
	
	public Jugable(Sprite sprite, Vector<Integer> posicion, Visitante visitor) {
		super(sprite, posicion, visitor);
	}
	
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
	
	public Monedas getMonedas() {
		return this.monedas;
	}
	
	public abstract void saltar(Vector<Integer> direccion);
	
	public abstract void aceptarVisitante(Visitante visitante);

}
