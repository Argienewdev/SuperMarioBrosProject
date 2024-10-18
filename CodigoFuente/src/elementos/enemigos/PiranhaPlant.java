package elementos.enemigos;

import java.awt.Point;
import elementos.Sprite;
import observers.ObserverGrafico;
import visitors.Visitante;

public class PiranhaPlant extends Enemigo {
	    
    protected boolean dentroTuberia;
    

    public PiranhaPlant(Sprite sprite, Point posicion, Visitante visitor, 
    					int velocidad, Point direccion,
    					ObserverGrafico observerGrafico) {
    	super(sprite, posicion, visitor, velocidad, direccion, observerGrafico);
    	this.puntosOtorgadosPorEliminacion = 30;
    	this.puntosSustraidosPorMuerteCausada = 30;
    }

    public void setDentroTuberia() {
        this.dentroTuberia = true;
    }
    
    public void setFueraTuberia() {
        this.dentroTuberia = false;
    }
    
    public boolean enTuberia() {
        return this.dentroTuberia;
    }
    
    @Override
    public void aceptarVisitante (Visitante visitante) {
        visitante.visitarPiranhaPlant(this);
    }

}
