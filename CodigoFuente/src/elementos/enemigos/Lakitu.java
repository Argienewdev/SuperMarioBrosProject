package elementos.enemigos;

import java.util.LinkedList;
import java.util.Vector;

import fabricas.Sprite;
import observers.ObserverGrafico;
import visitors.Visitante;

public class Lakitu extends Enemigo {
    
    // Constructor
    public Lakitu(Sprite sprite, Vector<Integer> posicion, Visitante visitor, 
    			  int velocidad, Vector<Integer> direccion, ObserverGrafico observerGrafico) {
    	super(sprite, posicion, visitor, velocidad, direccion, observerGrafico);
    	this.puntosOtorgadosPorEliminacion = 60;
    	this.puntosSustraidosPorMuerteCausada = 0;
    }

    // Metodos
    public void lanzarSpiny () {
    	// TODO Auto-generated method stub    
    }
    
    @Override
    public void aceptarVisitante(Visitante visitante) {
        visitante.visitarLakitu(this);
    }
    
}