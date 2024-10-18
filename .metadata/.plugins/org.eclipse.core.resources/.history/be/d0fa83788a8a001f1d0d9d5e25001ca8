package elementos.enemigos;

import java.util.Vector;

import fabricas.Sprite;
import visitors.Visitante;

public class Bowser extends Enemigo {

    protected int vidas = 5;

   
    public Bowser (Sprite sprite, Vector<Integer> pos, Vector<Integer> dir, int velocidad) {
        this.velocidad = velocidad;
        this.direccion = dir;
        this.posicion = pos;
        this.sprite = sprite;
    }

    public void aceptarVisitante(Visitante visitante) {
        visitante.visitarBowser(this);
    }


}
