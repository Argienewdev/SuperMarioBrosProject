package elementos.entidades;

import java.awt.Point;
import elementos.Sprite;
import observers.ObserverGrafico;
import visitors.Visitante;

public class Fireball extends NoJugable {
	
	protected static final int DANIO = 1; // Consultar valor
	
	protected Jugable miJugador;
	
	public Fireball(Sprite sprite, Point posicion, Visitante visitor,
					int velocidad, Point velocidadDireccional,
					ObserverGrafico observerGrafico, Jugable miJugador) {
		super(sprite, posicion, visitor, velocidadDireccional, observerGrafico);
		this.miJugador = miJugador;
	}
	
	// Metodos
	@Override
	public void aceptarVisitante (Visitante visitante) {
		visitante.visitar(this);
	}
	
	public Jugable obtenerJugador() {
		return miJugador;
	}

}
