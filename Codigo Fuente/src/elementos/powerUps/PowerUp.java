package elementos.powerUps;

import java.awt.Point;
import elementos.Sprite;
import elementos.entidades.NoJugable;
import elementos.personajes.ContextoMario;
import observers.ObserverGrafico;
import visitors.Visitante;

public abstract class PowerUp extends NoJugable {

	public PowerUp(Sprite sprite, Point posicion, Visitante visitor, 
				    Point velocidadDireccional, ObserverGrafico observerGrafico) {
		super(sprite, posicion, visitor, velocidadDireccional, observerGrafico);
	}
	
	public abstract void aceptarVisitante(Visitante visitante);
	
	public abstract int obtenerPuntosPorDefault();
	
	public abstract int obtenerPuntosPorSuper();
	
	public abstract int obtenerPuntosPorInvencible();
	
	public abstract int obtenerPuntosPorFuego();
}
