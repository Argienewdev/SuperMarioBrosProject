package elementos.enemigos;

import java.util.Vector;

import fabricas.Sprite;
import observers.ObserverGrafico;
import visitors.Visitante;

public class ContextoKoopaTroopa extends Enemigo {
	
	// Atributos
	private KoopaState estado;

	// Constructor
    public ContextoKoopaTroopa(Sprite sprite,Vector<Integer> posicion, Visitante visitor,
							   int velocidad, Vector<Integer> direccion, 
							   ObserverGrafico observerGrafico, KoopaState estado) {
    	super(sprite, posicion, visitor, velocidad, direccion, observerGrafico);
    	this.estado = estado;
    	this.puntosOtorgadosPorEliminacion = 90;
    	this.puntosSustraidosPorMuerteCausada = 45;
    }

    // Metodos
    public KoopaState getEstado() {
    	return this.estado;
    }
    
    public void cambiarEstado(KoopaState estado) {
        this.estado = estado;
    }
    
    @Override
    public void aceptarVisitante(Visitante visitante) {
        estado.aceptarVisitante(visitante);
    }
    
}
