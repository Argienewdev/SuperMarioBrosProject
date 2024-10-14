package elementos.enemigos;

import java.util.LinkedList;
import java.util.Vector;

import fabricas.Sprite;
import visitors.Visitante;

public class Lakitu extends Enemigo {
    //Atributos de instancia
    protected LinkedList<Spiny> spinys;

    //Constructor
    public Lakitu (Sprite sprite, Vector<Integer> pos, Vector<Integer> dir, int velocidad) {
         this.sprite = sprite;
         posicion = pos;
         direccion = dir;
         this.velocidad = velocidad;
         spinys = new LinkedList<Spiny>();
    }

    //Operaciones
    public void acumularSpiny (Spiny spiny) {
        spinys.addLast(spiny);
    }
    public Spiny lanzarSpiny () {
        Spiny spiny = spinys.removeLast();
        return spiny;
    }
    public void aceptarVisitante(Visitante visitante) {
        visitante.visitarLakitu(this);
    }
}