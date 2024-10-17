package elementos.enemigos;

import java.util.Vector;

import fabricas.Sprite;
import observers.ObserverGrafico;
import visitors.Visitante;

public class Bowser extends Enemigo {

	// Atributos
    protected static final int VIDAS = 5;

    // Constructor
    public Bowser(Sprite sprite, Vector<Integer> posicion, Visitante visitor, 
    			  int velocidad, Vector<Integer> direccion, ObserverGrafico observerGrafico) {
        super(sprite, posicion, visitor, velocidad, direccion, observerGrafico);
        this.puntosOtorgadosPorEliminacion = 0;
        this.puntosSustraidosPorMuerteCausada = 0;
    }

    // Metodos
    @Override
    public void aceptarVisitante(Visitante visitante) {
        visitante.visitarBowser(this);
    }

}
