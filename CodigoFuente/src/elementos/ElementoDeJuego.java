package elementos;

import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.JLabel;

import juego.Nivel;
import observers.ObserverGrafico;
import visitors.*;

public abstract class ElementoDeJuego implements Visitado {
	
	protected Sprite sprite;
	
	protected Rectangle hitbox;
	
	protected Point posicion;
	
	protected Visitante visitante;
	
    protected Nivel miNivel;
    
    protected JLabel label;
    
    protected ObserverGrafico observerGrafico;
    
    protected boolean removido;
    
	@SuppressWarnings("exports")
	public ElementoDeJuego(Sprite sprite, Point posicion, Visitante visitante, ObserverGrafico observerGrafico) {
		this.sprite = sprite;
		Point posicionConsiderandoSprite = getPosicionConsiderandoSprite(posicion, sprite);
		this.posicion = posicionConsiderandoSprite;
		this.visitante = visitante;
		this.observerGrafico = observerGrafico;
		this.removido = false;
		int ancho = sprite.getAnchoImagen();
		int alto = sprite.getAltoImagen();
		int x =  posicionConsiderandoSprite.x;
		int y = posicionConsiderandoSprite.y;
		this.hitbox = new Rectangle(x, y, ancho, alto);
	}
	
	private Point getPosicionConsiderandoSprite(Point posicion, Sprite sprite) {
		return new Point(posicion.x, posicion.y + (50 - sprite.getAltoImagen()));
	}
	
	public void setSprite(Sprite sprite) {
		this.sprite = sprite;
	}
	
	public void setVisitor(Visitante visitor) {
		this.visitante = visitor;
	}
	
	public void setNivel (Nivel nivel) {
		this.miNivel = nivel;
	}
	
	@SuppressWarnings("exports")
	public void setPosicion (Point posicion) {
		this.posicion = posicion;
	}
	
	public Sprite getSprite() {
		return this.sprite;
	}
	
	@SuppressWarnings("exports")
	public Rectangle obtenerHitbox() {
		return this.hitbox;
	}
	
	@SuppressWarnings("exports")
	public void moverHitbox(Point nuevaPosicion) {
		this.hitbox.setLocation(nuevaPosicion);
	}
	
	@SuppressWarnings("exports")
	public Point getPosicion() {
		return this.posicion;
	}
	
	public Visitante getVisitor() {
		return this.visitante;
	}
	
    public Nivel getNivel() {
    	return this.miNivel;
    }
	
	public int obtenerAncho() {
		return hitbox.width;
	}
	
	public int obtenerAlto() {
		return hitbox.height;
	}
	
	public boolean huboColision(ElementoDeJuego elemento) {
		return this.hitbox.intersects(elemento.obtenerHitbox());
	}

	public void setObserverGrafico(ObserverGrafico observerGrafico) {
    	this.observerGrafico = observerGrafico;
    }
    
    public ObserverGrafico getObserverGrafico() {
    	return this.observerGrafico;
    }
	
	public abstract void aceptarVisitante(Visitante visitante);
	
	public void setRemovido(boolean removido) {
		this.removido = removido;
	}
	
	public boolean getRemovido() {
		return this.removido;
	}
}