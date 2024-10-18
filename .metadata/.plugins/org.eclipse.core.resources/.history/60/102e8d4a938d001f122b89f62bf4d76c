package elementos;

import java.awt.Point;
import java.awt.Rectangle;

import visitors.*;

public abstract class ElementoDeJuego implements Visitado {
	
	protected Sprite sprite;
	
	protected Rectangle hitbox;
	
	protected Point posicion;
	
	protected Visitante visitor;
	
	@SuppressWarnings("exports")
	public ElementoDeJuego(Sprite sprite, Point posicion, Visitante visitor) {
		this.sprite = sprite;
		this.posicion = posicion;
		this.visitor = visitor;
		int x =  posicion.x;
		int y = posicion.y;
		int ancho = obtenerAncho();
		int alto = obtenerAlto();
		this.hitbox = new Rectangle(x,y,ancho,alto);
	}
	
	public void setSprite(Sprite sprite) {
		this.sprite = sprite;
	}
	
	
	
	public void setVisitor(Visitante visitor) {
		this.visitor = visitor;
	}
	
	public Sprite getSprite() {
		return this.sprite;
	}
	
	@SuppressWarnings("exports")
	public Rectangle obtenerHitbox() {
		return hitbox;
	}
	
	@SuppressWarnings("exports")
	public Point getPosicion() {
		return this.posicion;
	}
	
	public Visitante getVisitor() {
		return this.visitor;
	}
	
	public int obtenerAncho() {
		return 50;
	}
	
	public int obtenerAlto() {
		return 50;
	}
	
	@SuppressWarnings("exports")
	public void obtenerPosicion( Point posicion) {
		this.posicion = posicion;
	}
	
	public Visitante obtenerVisitante() {
		return visitor;
	}
	
	public boolean huboColision (ElementoDeJuego elemento) {
		return hitbox.intersects(elemento.obtenerHitbox());
	}

	public abstract void aceptarVisitante(Visitante visitante);
	
}