package elementos.entidades;

import java.util.Vector;

import fabricas.Sprite;
import visitors.Visitante;

public class Fireball extends NoJugable {
	
	protected int danio;
	
	public Fireball (Sprite sprite, Vector<Integer> posicion, Vector<Integer> direccion, int velocidad, int danio) {
		this.sprite = sprite;
		this.posicion = posicion;
		this.direccion = direccion;
		this.velocidad = velocidad;
		this.danio = danio;
	}
	
	public void aceptarVisitante (Visitante visitante) {
		visitante.visitarFireball(this);
	}

}
