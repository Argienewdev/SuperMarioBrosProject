package elementos.enemigos;

import java.util.Vector;

import fabricas.Sprite;
import visitors.Visitante;

public class Spiny extends Enemigo{
 
    public Spiny (Sprite sprite, Vector<Integer> pos, Vector<Integer> dir, int velocidad) {
        this.sprite = sprite;
        posicion = pos;
        direccion = dir;
        this.velocidad = velocidad;
    }

    public void aceptarVisitante(Visitante visitante) {
        visitante.visitarSpiny(this);
    }
}
