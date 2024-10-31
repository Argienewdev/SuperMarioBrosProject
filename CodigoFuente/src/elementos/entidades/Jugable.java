package elementos.entidades;

import java.awt.Point;
import elementos.Sprite;
import elementos.powerUps.Moneda;
import fabricas.FabricaSprites;
import observers.ObserverGrafico;
import observers.ObserverLogicoJugable;
import visitors.Visitante;

public abstract class Jugable extends Entidad  {
	
	protected int vidas;
	
	protected int puntos;
	
	protected Moneda monedas;
		
	private boolean retrocediendo;
	
	private boolean avanzando;
	
	private ObserverLogicoJugable observerLogico;
	
	protected boolean mirandoAlFrente;
	
	public Jugable(Sprite sprite, Point posicion, Visitante visitor, ObserverGrafico observerGrafico) {
		super(sprite, posicion, visitor, observerGrafico);
		this.colisionAbajo = true;
		this.colisionArriba = false;
		this.retrocediendo = false;
		this.avanzando = false;
		this.vidas = 3;
		this.puntos = 0;
		this.mirandoAlFrente=true;
	}
	
	public void ganarVida() {
		this.vidas++;
	}
	
	public void perderVida() {
		this.vidas--;
		if (vidas == 0) { 
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
	
	public int obtenerVidas() {
		return this.vidas;
	}
	
	public int obtenerPuntos() {
		return this.puntos;
	}
	
	public Moneda obtenerMonedas() {
		//TODO es necesario?
		return this.monedas;
	}
		
	public boolean obtenerColisionAbajo() {
		return this.colisionAbajo;
	}
	
	public abstract void reiniciarEstado();
	
	public void establecerColisionArriba(boolean colisionArriba) {
		this.colisionArriba = colisionArriba;
	}
	
	public boolean obtenerColisionArriba() {
		return this.colisionArriba;
	}
	
	public void retrotraerMovimientoHorizontal(int posX) {
		Point nuevaPosicion = new Point(posX, this.obtenerHitbox().y);
        this.moverHitbox(nuevaPosicion);
		this.establecerPosicion(nuevaPosicion);
        this.establecerVelocidadDireccional(new Point(0, obtenerVelocidadDireccional().y));
	}
	
	public void retrotraerMovimientoVertical(int posY) {
		Point nuevaPosicion = new Point(this.obtenerHitbox().x, posY);
		this.moverHitbox(nuevaPosicion);
		this.establecerPosicion(nuevaPosicion);
	}
	
	public boolean obtenerRetrocediendo() {
		return retrocediendo;
	}
	
	public ObserverLogicoJugable obtenerObserverLogico() {
		return this.observerLogico;
	}
	
	public void establecerRetrocediendo(boolean retrocediendo) {
		this.retrocediendo = retrocediendo;
	}
	
	public boolean obtenerAvanzando() {
		return this.avanzando;
	}
	
	public void establecerAvanzando(boolean avanzando) {
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
	
	public boolean obtenerMirandoAlFrente() {
		return this.mirandoAlFrente;
	}
	
	public void establecerMirandoAlFrente(boolean mirandoAlFrente) {
		this.mirandoAlFrente = mirandoAlFrente;
	}
	
}
