package elementos.entidades;

import java.awt.Point;
import elementos.Sprite;
import elementos.powerUps.Monedas;
import visitors.Visitante;

public abstract class Jugable extends Entidad {
	
	protected int vidas;
	
	protected int puntos;
	
	protected Monedas monedas;
	
	private boolean colisionADerecha;
	
	private boolean colisionAIzquierda;
	
	public Jugable(Sprite sprite, Point posicion, Visitante visitor) {
		super(sprite, posicion, visitor);
		this.colisionADerecha = false;
		this.colisionAIzquierda = false;
	}
	
	public void ganarVida() {
		this.vidas++;
	}
	
	public void perderVida() {
		this.vidas--;
	}
	
	public void ganarPuntos(int puntos) {
		this.puntos += puntos; 
	}
	
	public void perderPuntos(int puntos) {
		this.puntos -= puntos;
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
	
	public abstract void saltar(Point direccion);
	
	public abstract void aceptarVisitante(Visitante visitante);
	
	public void setColisionADerecha(boolean colisionADerecha) {
		this.colisionADerecha = colisionADerecha;
	}
	
	public boolean getColisionADerecha() {
		return this.colisionADerecha;
	}
	
	public void setColisionAIzquierda(boolean colisionAIzquierda) {
		this.colisionAIzquierda = colisionAIzquierda;
	}
	
	public boolean getColisionAIzquierda() {
		System.out.println("Detecte colision a izquierda");
		return this.colisionAIzquierda;
	}
	
	public void retrotraerMovimiento() {
	    if (this.colisionADerecha) {
	        Point newPos = new Point(this.getPosicion().x - this.getVelocidadDireccional().x, this.getPosicion().y);
	        this.setPosicion(newPos);
	    } else {
	    	Point newPos = new Point(this.getPosicion().x + this.getVelocidadDireccional().x, this.getPosicion().y);
	        this.setPosicion(newPos);
	    }
	}

}
