package elementos;

import java.util.Vector;

import visitors.*;

public abstract class ElementoDeJuego implements Visitado {
	
	protected Sprite sprite;
	
	protected Vector<Integer> posicion;
	
	protected Visitante visitor;
	

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
		return sprite;
	}
	
	public Vector<Integer> getPosicion() {
		return posicion;
	}
	
	public Visitante getVisitor() {
		return visitor;
	}

	public abstract void aceptarVisitante(Visitante visitante);
	
}