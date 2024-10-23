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
	
	private boolean colisionAbajo;
	
	private boolean colisionArriba;
	
	public Jugable(Sprite sprite, Point posicion, Visitante visitor) {
		super(sprite, posicion, visitor);
		this.colisionADerecha = false;
		this.colisionAIzquierda = false;
		this.colisionAbajo = true;
		this.colisionArriba = false;
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
		return this.colisionAIzquierda;
	}
	
	public void setColisionAbajo(boolean colisionAbajo) {
		this.colisionAbajo = colisionAbajo;
	}
	
	public boolean getColisionAbajo() {
		return this.colisionAbajo;
	}
	
	public void setColisionArriba(boolean colisionArriba) {
		this.colisionArriba = colisionArriba;
	}
	
	public boolean getColisionArriba() {
		return this.colisionArriba;
	}
	
	public void retrotraerMovimientoHorizontal() {
    	Point oldPos = new Point(this.obtenerHitbox().x - this.getVelocidadDireccional().x, this.obtenerHitbox().y);
        this.moverHitbox(oldPos);
        setVelocidadDireccional(new Point(0, getVelocidadDireccional().y));
	}
	
	public void retrotraerMovimientoVertical(int posY) {
		Point oldPos = new Point(0,0);
		oldPos.move(this.obtenerHitbox().x, posY);
		this.moverHitbox(oldPos);
		setPosicion(oldPos);
		setVelocidadDireccional(new Point(getVelocidadDireccional().x, 0));
	}

}
