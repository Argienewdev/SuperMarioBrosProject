package elementos.enemigos;

import java.util.LinkedList;
import java.util.Vector;

import fabricas.Sprite;
import visitors.Visitante;

public class Lakitu extends Enemigo {
    
    //Constructor
    public Lakitu (Sprite sprite, Vector<Integer> posicion,Visitante visitor, Vector<Integer> direccion, int velocidad) {
    	super(sprite, posicion,visitor, direccion,velocidad,60,0);
    }

    //Operaciones
    public void lanzarSpiny () {
    }
    public void aceptarVisitante(Visitante visitante) {
        visitante.visitarLakitu(this);
    }
}