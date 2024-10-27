package elementos.entidades;

import java.awt.Point;
import elementos.Sprite;
import elementos.powerUps.Monedas;
import fabricas.FabricaSprites;
import observers.ObserverGrafico;
import observers.ObserverLogicoJugable;
import visitors.Visitante;

public abstract class Jugable extends Entidad  {
	
	protected int vidas;
	
	protected int puntos;
	
	protected Monedas monedas;
		
	private boolean enElAire;
	
	private boolean retrocediendo;
	
	private boolean avanzando;
	
	private ObserverLogicoJugable observerLogico;
	
	public Jugable(Sprite sprite, Point posicion, Visitante visitor, 
				   Point velocidadDireccional, ObserverGrafico observerGrafico) {
		super(sprite, posicion, visitor, velocidadDireccional, observerGrafico);
		this.colisionAbajo = true;
		this.colisionArriba = false;
		this.enElAire = false;
		this.retrocediendo = false;
		this.avanzando = false;
		this.vidas = 3;
		this.puntos = 0;
	}
	
	public void ganarVida() {
		this.vidas++;
	}
	
	public void perderVida() {
		this.vidas--;
		if (vidas == 0) { 
			//TODO revisar si es necesario
			muerte();
		}
	}
	
	public void ganarPuntos(int puntos) {
		this.puntos += puntos; 
	}
	
	public void perderPuntos(int puntos) {
		if(puntos > this.puntos) {
			this.puntos = 0;
		}else {
			this.puntos -= puntos;
		}
	}
	
	public void recogerMoneda() {
		//TODO SACAR, la moneda te da puntos cuando mario visita a la moneda
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
		
	public boolean getColisionAbajo() {
		return this.colisionAbajo;
	}
	
	public abstract void reiniciarEstado();
	
	public void setColisionArriba(boolean colisionArriba) {
		this.colisionArriba = colisionArriba;
	}
	
	public boolean getColisionArriba() {
		return this.colisionArriba;
	}
	
	public void retrotraerMovimientoHorizontal(int posX) {
		Point nuevaPosicion = new Point(posX, this.obtenerHitbox().y);
        this.moverHitbox(nuevaPosicion);
		this.setPosicion(nuevaPosicion);
        this.setVelocidadDireccional(new Point(0, getVelocidadDireccional().y));
	}
	
	public void retrotraerMovimientoVertical(int posY) {
		Point nuevaPosicion = new Point(this.obtenerHitbox().x, posY);
		this.moverHitbox(nuevaPosicion);
		this.setPosicion(nuevaPosicion);
		if(this.getColisionAbajo()) {
			this.setEnElAire(false);
		}
	}
	
	public boolean getEnElAire() {
		return this.enElAire;
	}
	
	public void setEnElAire(boolean enElAire) {
		this.enElAire = enElAire;
	}
	
	public boolean getRetrocediendo() {
		return retrocediendo;
	}
	
	public ObserverLogicoJugable obtenerObserverLogico() {
		return this.observerLogico;
	}
	
	public void setRetrocediendo(boolean retrocediendo) {
		this.retrocediendo = retrocediendo;
	}
	
	public boolean getAvanzando() {
		return this.avanzando;
	}
	
	public void setAvanzando(boolean avanzando) {
		this.avanzando = avanzando;
	}
	
	public void establecerObserverLogico (ObserverLogicoJugable observerLogico) {
		this.observerLogico = observerLogico;
	}
	
	public void muerte() {
		observerLogico.actualizar();
	}
	
	public abstract void aceptarVisitante(Visitante visitante);
	
	public abstract void actualizarSprite(FabricaSprites fabricaSprites);

	public abstract void realizarAccionEspecial();
	
}
