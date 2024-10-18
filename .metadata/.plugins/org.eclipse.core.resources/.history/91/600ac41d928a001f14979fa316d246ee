package elementos.enemigos;

import java.util.Vector;

import elementos.entidades.NoJugable;
import fabricas.Sprite;
import visitors.Visitante;

public abstract class Enemigo extends NoJugable{
	
	protected int killPoint;
	protected int deathPoint;
	
	public Enemigo(Sprite sprite, Vector<Integer> posicion, Visitante visitor, Vector<Integer> direccion,
			int velocidad, int killPoint, int deathPoint) {
		super(sprite, posicion, visitor, direccion, velocidad);
		this.killPoint=killPoint;
		this.deathPoint=deathPoint;
	}
	
	public int getPuntosKill() {
		return killPoint;
	}
	
	public int getPuntosDeath() {
		return deathPoint;
	}


}
