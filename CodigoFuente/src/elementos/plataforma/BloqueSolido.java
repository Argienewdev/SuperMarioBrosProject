package elementos.plataforma;

import java.util.Vector;

import fabricas.Sprite;
import visitors.Visitante;

public class BloqueSolido extends Plataforma {
    //Constructor
    public BloqueSolido (Sprite sprite, Vector<Integer> pos) {
        this.sprite = sprite;
        posicion = pos;
        setSolido(true);
    }

    //Operaciones
    public void aceptarVisitante(Visitante visitante) {
        visitante.visitarBloqueSolido(this);
    }
}