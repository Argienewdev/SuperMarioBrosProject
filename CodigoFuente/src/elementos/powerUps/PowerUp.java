package elementos.powerUps;

import java.awt.Point;
import elementos.Sprite;
import elementos.entidades.NoJugable;
import elementos.plataformas.BloqueDePregunta;
import fabricas.FabricaSprites;
import observers.ObserverGrafico;
import visitors.Visitante;

public abstract class PowerUp extends NoJugable {
	
	protected int ticksHastaSalirDelBloque;
	
	protected boolean esMovible;
	
	protected boolean estaDentroDeBloqueDePreguntas;
	
	protected BloqueDePregunta bloquePregunta;

	public PowerUp(Sprite sprite, Point posicion, Visitante visitor, 
				    Point velocidadDireccional, ObserverGrafico observerGrafico) {
		super(sprite, posicion, visitor, velocidadDireccional, observerGrafico);
	}
	
	public abstract void aceptarVisitante(Visitante visitante);
	
	public abstract int obtenerPuntosPorDefault();
	
	public abstract int obtenerPuntosPorSuper();
	
	public abstract int obtenerPuntosPorInvulnerable();
	
	public abstract int obtenerPuntosPorFuego();
	
	public abstract void actualizarSprite(FabricaSprites fabricaSprites);
	
    public abstract void eliminarEntidadGraficamente(FabricaSprites fabricaSprites);
	
	public boolean estaDentroDeBloqueDePreguntas() {
		return this.estaDentroDeBloqueDePreguntas;
	}
	
	public int getTicksHastaSalirDelBloque() {
		return this.ticksHastaSalirDelBloque;
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
	
	public void  elminarEntidadGraficamente(FabricaSprites fabricaSprites) {
		this.setSprite(fabricaSprites.getSpriteInvisible());
	}
	
	public BloqueDePregunta getBloquePregunta() {
		return this.bloquePregunta;
	}
	
	public void setBloquePregunta(BloqueDePregunta bloquePregunta) {
		this.bloquePregunta = bloquePregunta;
	}
	
}
