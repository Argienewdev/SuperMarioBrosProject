package elementos.enemigos;

import java.util.Vector;

import elementos.Sprite;
import observers.ObserverGrafico;
import visitors.Visitante;

public class Goomba extends Enemigo {
	
    public Goomba(Sprite sprite, Vector<Integer> posicion, Visitante visitor,
    			  int velocidad, Vector<Integer> direccion, ObserverGrafico observerGrafico) {
        super(sprite, posicion, visitor, velocidad, direccion, observerGrafico);
        this.puntosOtorgadosPorEliminacion = 60;
        this.puntosSustraidosPorMuerteCausada = 30;
    }
    
    @Override
    public void aceptarVisitante(Visitante visitante) {
        visitante.visitarGoomba(this);
    }
    
}