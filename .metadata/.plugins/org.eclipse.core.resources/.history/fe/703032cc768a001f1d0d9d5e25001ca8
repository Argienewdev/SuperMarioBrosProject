package elementos;

import java.util.Vector;
import fabricas.Sprite;
import visitors.*;

public class ElementoDeJuego {
	protected Sprite sprite;
	protected Vector<Integer> posicion;
	protected Visitante visitor;
	
	public ElementoDeJuego(Sprite sprite,Vector<Integer> posicion, Visitante visitor){
		this.sprite=sprite;
		this.posicion=posicion;
		this.visitor=visitor;
	}
	
	public void setSprite(Sprite sprite) {
		this.sprite=sprite;
	}
	
	public void setPosicion(Vector<Integer> posicion) {
		this.posicion=posicion;
	}
	
	public void setVisitor(Visitante visitor) {
		this.visitor=visitor;
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
}
