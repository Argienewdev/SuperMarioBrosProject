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
    public PiranhaPlant (Sprite sprite, Vector<Integer> posicion,Visitante visitor, Vector<Integer> direccion, int velocidad, Tuberia miTuberia) {
    	super(sprite, posicion,visitor, direccion,velocidad,30,-30);
        this.miTuberia = miTuberia;
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
