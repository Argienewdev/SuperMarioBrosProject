package elementos.powerUp;

import java.util.Vector;

import fabricas.Sprite;
import visitors.Visitante;

public class Estrella extends PowerUp {
	
	public static final int TIEMPO_DURACION = 10;
	
	public Estrella (Sprite sprite, Vector<Integer> posicion, Vector<Integer> direccion, int velocidad) {
		this.sprite = sprite;
		this.posicion = posicion;
		this.direccion = direccion;
		this.velocidad = velocidad;
	}
	
	public void aceptarVisitante (Visitante visitante) {
		visitante.visitarEstrella(this);
	}

}
