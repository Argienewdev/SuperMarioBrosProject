package elementos.enemigos;

import java.util.Vector;

import fabricas.Sprite;
import visitors.Visitante;

public class Bowser extends Enemigo {

    protected static final int VIDAS = 5;

   
    public Bowser (Sprite sprite, Vector<Integer> posicion,Visitante visitor, Vector<Integer> direccion, int velocidad) {
        super(sprite, posicion,visitor, direccion,velocidad,0,0);
    }

    public void aceptarVisitante(Visitante visitante) {
        visitante.visitarBowser(this);
    }


}
