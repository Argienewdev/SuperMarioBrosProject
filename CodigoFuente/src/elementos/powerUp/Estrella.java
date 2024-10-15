package elementos.powerUp;

import java.util.Vector;

import fabricas.Sprite;
import visitors.Visitante;

public class Estrella extends PowerUp {
	
	public static final int TIEMPO_DURACION = 10;
	
	public Estrella (Sprite sprite, Vector<Integer> posicion,Visitante visitor, Vector<Integer> direccion, int velocidad) {
        super(sprite, posicion,visitor, direccion,velocidad,20);
	}
	
	public void aceptarVisitante (Visitante visitante) {
		visitante.visitarEstrella(this);
	}

}
