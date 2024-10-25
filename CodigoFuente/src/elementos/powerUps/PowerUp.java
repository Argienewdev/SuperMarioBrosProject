package elementos.powerUps;

import java.awt.Point;
import elementos.Sprite;
import elementos.entidades.NoJugable;
import observers.ObserverGrafico;
import visitors.Visitante;

public abstract class PowerUp extends NoJugable {
	
	protected int ticksHastaSalirDelBloque;
	
	protected int contadorTicks;
	
	protected boolean esMovible;
	
	protected boolean estaDentroDeBloqueDePreguntas;

	public PowerUp(Sprite sprite, Point posicion, Visitante visitor, 
				    Point velocidadDireccional, ObserverGrafico observerGrafico) {
		super(sprite, posicion, visitor, velocidadDireccional, observerGrafico);
		this.contadorTicks = 0;
	}
	
	public abstract void aceptarVisitante(Visitante visitante);
	
	public abstract int obtenerPuntosPorDefault();
	
	public abstract int obtenerPuntosPorSuper();
	
	public abstract int obtenerPuntosPorInvulnerable();
	
	public abstract int obtenerPuntosPorFuego();
	
	public boolean estaDentroDeBloqueDePreguntas() {
		return this.estaDentroDeBloqueDePreguntas;
	}

	public boolean esMovible() {
		return this.esMovible;
	}
	
	public void establecerEsMovible(boolean esMovible) {
		this.esMovible = esMovible;
	}
	
	public void establecerEstaDentroDeBloqueDePreguntas(boolean estaDentroDeBloqueDePreguntas) {
		this.estaDentroDeBloqueDePreguntas = estaDentroDeBloqueDePreguntas;
	}

	public int getTicksHastaSalirDelBloque() {
		return this.ticksHastaSalirDelBloque;
	}
	
	public int getContadorTicks() {
		return this.contadorTicks;
	}
	
	public void incrementarContadorTicks() {
		this.contadorTicks++;
	}
	
}
