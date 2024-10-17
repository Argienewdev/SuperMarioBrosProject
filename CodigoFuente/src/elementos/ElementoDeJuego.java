package elementos;

import java.util.Vector;

import visitors.*;

public abstract class ElementoDeJuego implements Visitado {
	
	protected Sprite sprite;
	
	protected Vector<Integer> posicion;
	
	protected Visitante visitor;
	
	public ElementoDeJuego(Sprite sprite, Vector<Integer> posicion, Visitante visitor){
		this.sprite = sprite;
		this.posicion = posicion;
		this.visitor = visitor;
	}
	
	public void setSprite(Sprite sprite) {
		this.sprite = sprite;
	}
	
	public void setPosicion(Vector<Integer> posicion) {
		this.posicion = posicion;
	}
	
	public void setVisitor(Visitante visitor) {
		this.visitor = visitor;
	}
	
	public Sprite getSprite() {
		return this.sprite;
	}
	
	public Vector<Integer> getPosicion() {
		return this.posicion;
	}
	
	public Visitante getVisitor() {
		return this.visitor;
	}

	public abstract void aceptarVisitante(Visitante visitante);
	
}