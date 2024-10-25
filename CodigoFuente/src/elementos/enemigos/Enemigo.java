package elementos.enemigos;

import java.awt.Point;
import elementos.Sprite;
import elementos.entidades.NoJugable;
import observers.ObserverGrafico;
import visitors.Visitante;

public abstract class Enemigo extends NoJugable {
	
	protected int puntosOtorgadosPorEliminacion;
		
	protected int puntosSustraidosPorMuerteCausada;
	
	public Enemigo(Sprite sprite, Point posicion, Visitante visitor, 
				   Point velocidadDireccional, ObserverGrafico observerGrafico) {
		super(sprite, posicion, visitor, velocidadDireccional, observerGrafico);
		this.colisionAbajo = true;
	}
    
    public int getPuntosOtorgadosPorEliminacion() {
        return this.puntosOtorgadosPorEliminacion;
    }
    
    public int getPuntosSustraidosPorMuerteCausada() {
        return this.puntosSustraidosPorMuerteCausada;
    }

    public abstract void aceptarVisitante(Visitante visitante);
    
}
