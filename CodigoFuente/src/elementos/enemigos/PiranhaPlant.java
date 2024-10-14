package elementos.enemigos;

import java.util.Vector;

import elementos.plataforma.Tuberia;
import fabricas.Sprite;
import visitors.Visitante;

public class PiranhaPlant extends Enemigo{
    //Atributos de instancia
    protected Tuberia miTuberia;
    protected boolean dentroTuberia;

    //Constructor
    public PiranhaPlant (Sprite sprite, Vector<Integer> pos, Vector<Integer> dir, int velocidad, Tuberia tub) {
        this.sprite = sprite;
        posicion = pos;
        direccion = dir;
        this.velocidad = velocidad;
        miTuberia = tub;
    }

    public void setDentroTuberia() {
        dentroTuberia = true;
    }
    
    public void setFueraTuberia() {
        dentroTuberia = false;
    }
    
    public boolean enTuberia() {
        return dentroTuberia;
    }
    
    public void aceptarVisitante (Visitante visitante) {
        visitante.visitarPiranhaPlant(this);
    }


}
