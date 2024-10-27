package elementos.entidades;

import java.awt.Point;
import elementos.Sprite;
import elementos.powerUps.Monedas;
import observers.ObserverLogicoJugable;
import visitors.Visitante;

public abstract class Jugable extends Entidad  {
	
	protected int vidas;
	
	protected int puntos;
	
	protected Monedas monedas;
		
	private boolean enElAire;
	
	private boolean retrocediendo;
	
	private boolean avanzando;
	
	private boolean impactado;
	
	private ObserverLogicoJugable observerLogico;
	
	public Jugable(Sprite sprite, Point posicion, Visitante visitor) {
		super(sprite, posicion, visitor);
		this.colisionAbajo = true;
		this.colisionArriba = false;
		this.enElAire = false;
		this.retrocediendo = false;
		this.avanzando = false;
		this.vidas = 2;
		this.puntos = 0;
		this.impactado = false;
	}
	
	public void ganarVida() {
		this.vidas += 1;
	}
	
	public void perderVida() {
		vidas --;
		if (vidas == 0) 
			muerte();
	}
	
	public void ganarPuntos(int puntos) {
		this.puntos += puntos; 
	}
	
	public void perderPuntos(int puntos) {
		this.puntos -= puntos;
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
	
	public abstract void aceptarVisitante(Visitante visitante);
	
	public boolean getColisionAbajo() {
		return this.colisionAbajo;
	}
	
	public void setColisionArriba(boolean colisionArriba) {
		this.colisionArriba = colisionArriba;
	}
	
	public boolean getColisionArriba() {
		return this.colisionArriba;
	}
	
	public void retrotraerMovimientoVertical(int posY) {
		Point nuevaPosicion = new Point(this.obtenerHitbox().x, posY);
		this.moverHitbox(this.posicion);
		this.setPosicion(nuevaPosicion);
		this.setVelocidadDireccional(new Point(getVelocidadDireccional().x, 0));
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
	
	public void setImpactado(boolean impacto) {
		this.impactado = impacto;
	}
	
	public boolean getImpactado() {
		//TODO hacer q me empuje para atras
		return this.impactado;
	}
	
	public void establecerObserverLogico (ObserverLogicoJugable observerLogico) {
		this.observerLogico = observerLogico;
	}
	
	public void muerte() {
		observerLogico.actualizar();
	}

	public abstract void realizarAccionEspecial();
	
}
