package elementos.enemigos;

import java.awt.Point;
import elementos.Sprite;
import observers.ObserverGrafico;
import visitors.Visitante;

public class Spiny extends Enemigo {
	
    public Spiny(Sprite sprite, Point posicion, Visitante visitor, 
    			 int velocidad, Point direccion, ObserverGrafico observerGrafico) {
    	super(sprite, posicion, visitor, velocidad, direccion, observerGrafico);
    	this.puntosOtorgadosPorEliminacion = 60;
    	this.puntosSustraidosPorMuerteCausada = 30;
    }

    @Override
    public void aceptarVisitante(Visitante visitante) {
        visitante.visitarSpiny(this);
    }
    
}
