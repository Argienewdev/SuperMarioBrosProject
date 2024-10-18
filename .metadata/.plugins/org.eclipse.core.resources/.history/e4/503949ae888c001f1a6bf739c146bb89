package elementos.enemigos;

import java.util.Vector;

import fabricas.Sprite;
import observers.ObserverGrafico;
import visitors.Visitante;

public class Spiny extends Enemigo {
	
	// Constructor
    public Spiny(Sprite sprite, Vector<Integer> posicion, Visitante visitor, 
    			 int velocidad, Vector<Integer> direccion, ObserverGrafico observerGrafico) {
    	super(sprite, posicion, visitor, velocidad, direccion, observerGrafico);
    	this.puntosOtorgadosPorEliminacion = 60;
    	this.puntosSustraidosPorMuerteCausada = 30;
    }

    // Metodos
    @Override
    public void aceptarVisitante(Visitante visitante) {
        visitante.visitarSpiny(this);
    }
    
}
