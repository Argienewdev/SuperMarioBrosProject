package elementos.enemigos;

import java.util.Vector;

import fabricas.Sprite;
import visitors.Visitante;

public class Goomba extends Enemigo {
    //Constructor
    public Goomba (Sprite sprite, Vector<Integer> pos, Vector<Integer> dir, int velocidad) {
        this.sprite = sprite;
        posicion = pos;
        direccion = dir;
        this.velocidad = velocidad;
    }
    //Operaciones
    public void aceptarVisitante(Visitante visitante) {
        visitante.visitarGoomba(this);
    }
}