package elementos.enemigos;

import java.awt.Point;
import elementos.Sprite;
import observers.ObserverGrafico;
import visitors.Visitante;

public class Lakitu extends Enemigo {
    
    public Lakitu(Sprite sprite, Point posicion, Visitante visitor, 
    			  int velocidad, Point direccion, ObserverGrafico observerGrafico) {
    	super(sprite, posicion, visitor, velocidad, direccion, observerGrafico);
    	this.puntosOtorgadosPorEliminacion = 60;
    	this.puntosSustraidosPorMuerteCausada = 0;
    }

    public void lanzarSpiny () {
    	// TODO Auto-generated method stub    
    }
    
    @Override
    public void aceptarVisitante(Visitante visitante) {
        visitante.visitarLakitu(this);
    }
    
}