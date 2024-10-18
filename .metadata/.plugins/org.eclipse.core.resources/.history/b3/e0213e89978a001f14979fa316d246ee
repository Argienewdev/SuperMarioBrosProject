package elementos.entidades;

import java.util.Vector;

import fabricas.Sprite;
import visitors.Visitante;

public abstract class Jugable extends Entidad{
	
	protected int vidas;
	
	public Jugable(Sprite sprite, Vector<Integer> posicion, Visitante visitor, Vector<Integer> direccion,
			int velocidad, int vidas) {
		super(sprite, posicion, visitor, direccion, velocidad);
		this.vidas=vidas;
	}
	
	public void ganarVida(int vidas) {
		vidas++;
	}
	
	public void perderVida(int vidas) {
		vidas--;
	}
	
	public int getVidas() {
		return vidas;
	}

}
