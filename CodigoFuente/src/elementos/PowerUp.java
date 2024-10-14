package elementos;

import java.util.Vector;

import fabricas.Sprite;
import visitors.Visitante;

public abstract class PowerUp extends NoJugable{

	protected int puntos;
	
	public PowerUp(Sprite sprite, Vector<Integer> posicion, Visitante visitor, Vector<Integer> direccion,
			int velocidad, int puntos) {
		super(sprite, posicion, visitor, direccion, velocidad);
		this.puntos=puntos;
	}
	
	public int getPuntos() {
		return puntos;
	}
}
