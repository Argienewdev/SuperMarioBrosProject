package elementos.enemigos;

import java.util.Vector;

import fabricas.Sprite;
import visitors.Visitante;

public class Goomba extends Enemigo {
    //Constructor
    public Goomba (Sprite sprite, Vector<Integer> posicion,Visitante visitor, Vector<Integer> direccion, int velocidad) {
        super(sprite, posicion,visitor, direccion,velocidad,60,-30);
    }
    //Operaciones
    public void aceptarVisitante(Visitante visitante) {
        visitante.visitarGoomba(this);
    }
}