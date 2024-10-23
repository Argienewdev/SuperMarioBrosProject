package elementos.entidades;

import java.awt.Point;
import elementos.Sprite;
import elementos.powerUps.Monedas;
import visitors.Visitante;

public abstract class Jugable extends Entidad {
	
	protected int vidas;
	
	protected int puntos;
	
	protected Monedas monedas;
	
	private boolean colisionAbajo;
	
	private boolean colisionArriba;
	
	private boolean enElAire;
	
	private boolean retrocediendo;
	
	private boolean avanzando;
	
	public Jugable(Sprite sprite, Point posicion, Visitante visitor) {
		super(sprite, posicion, visitor);
		this.colisionAbajo = true;
		this.colisionArriba = false;
		this.enElAire = false;
		this.retrocediendo = false;
		this.avanzando = false;
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
        this.moverHitbox(this.posicion);
        this.setVelocidadDireccional(new Point(0, getVelocidadDireccional().y));
	}
	
	public void retrotraerMovimientoVertical(int posY) {
		Point nuevaPosicion = new Point(this.obtenerHitbox().x, posY);
		this.moverHitbox(this.posicion);
		this.setPosicion(nuevaPosicion);
		this.setVelocidadDireccional(new Point(getVelocidadDireccional().x, 0));
		this.setEnElAire(false);
	}
	
	public boolean getEnElAire() {
		return enElAire;
	}
	
	public void setEnElAire(boolean enElAire) {
		this.enElAire = enElAire;
	}
	
	public boolean getRetrocediendo() {
		return retrocediendo;
	}
	
	public void setRetrocediendo(boolean retrocediendo) {
		this.retrocediendo = retrocediendo;
	}
	public boolean getAvanzando() {
		return avanzando;
	}
	
	public void setAvanzando(boolean avanzando) {
		this.avanzando = avanzando;
	}

}
