package elementos.enemigos;

import java.util.Vector;

import fabricas.Sprite;
import visitors.Visitante;

public class Spiny extends Enemigo{
 
    public Spiny (Sprite sprite, Vector<Integer> posicion,Visitante visitor, Vector<Integer> direccion, int velocidad) {
    	super(sprite, posicion,visitor, direccion,velocidad,60,-30);
    }

    public void aceptarVisitante(Visitante visitante) {
        visitante.visitarSpiny(this);
    }
}
