package elementos.enemigos;

import java.util.Vector;

import elementos.Sprite;
import observers.ObserverGrafico;
import visitors.Visitante;

public class ContextoKoopaTroopa extends Enemigo {
	
	private EstadoKoopa estado;

    public ContextoKoopaTroopa(Sprite sprite,Vector<Integer> posicion, Visitante visitor,
							   int velocidad, Vector<Integer> direccion, 
							   ObserverGrafico observerGrafico, KoopaDefault estado) {
    	super(sprite, posicion, visitor, velocidad, direccion, observerGrafico);
    	this.estado = estado;
    	this.puntosOtorgadosPorEliminacion = 90;
    	this.puntosSustraidosPorMuerteCausada = 45;
    	estado.setContext(this);
    }

    public EstadoKoopa getEstado() {
    	return this.estado;
    }
    
    public void cambiarEstado(EstadoKoopa estado) {
        this.estado = estado;
    }
    
    @Override
    public void aceptarVisitante(Visitante visitante) {
        this.estado.aceptarVisitante(visitante);
    }
    
}
