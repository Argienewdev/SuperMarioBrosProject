package elementos.enemigos;

import java.util.Vector;

import elementos.Sprite;
import elementos.entidades.NoJugable;
import observers.ObserverGrafico;
import visitors.Visitante;

public abstract class Enemigo extends NoJugable {
	
	// Atributos
	protected int puntosOtorgadosPorEliminacion;
		
	protected int puntosSustraidosPorMuerteCausada;
	
	// Constructor
	public Enemigo(Sprite sprite, Vector<Integer> posicion, Visitante visitor, 
				   int velocidad, Vector<Integer> direccion, ObserverGrafico observerGrafico) {
		super(sprite, posicion, visitor, velocidad, direccion, observerGrafico);
	}
    
    // Metodos
    public int getPuntosOtorgadosPorEliminacion() {
        return this.puntosOtorgadosPorEliminacion;
    }
    
    public int getPuntosSustraidosPorMuerteCausada() {
        return this.puntosSustraidosPorMuerteCausada;
    }

    public abstract void aceptarVisitante(Visitante visitante);
    
}
