package elementos.enemigos;

import java.util.Vector;

import fabricas.Sprite;
import visitors.Visitante;

public class BuzzyBeetle extends Enemigo {
	
	public BuzzyBeetle (Sprite sprite, Vector<Integer> posicion, Vector<Integer> direccion, int velocidad) {
		this.sprite = sprite;
		this.posicion = posicion;
		this.direccion = direccion;
		this.velocidad = velocidad;
	}
	
	public void aceptarVisitante (Visitante visitante) {
		visitante.visitarBuzzyBeetle(this);
	}

}
