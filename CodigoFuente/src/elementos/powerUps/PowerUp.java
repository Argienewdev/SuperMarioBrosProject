package elementos.powerUps;

import java.awt.Point;
import elementos.Sprite;
import elementos.entidades.NoJugable;
import elementos.plataformas.BloqueDePregunta;
import fabricas.FabricaSprites;
import observers.ObserverGrafico;
import visitors.Visitante;

public abstract class PowerUp extends NoJugable {
	
	protected static final int VELOCIDAD_HORIZONTAL_POWERUP = 4;

	protected int ticksHastaSalirDelBloque;
	
	protected boolean esMovible;
	
	protected boolean estaDentroDeBloqueDePreguntas;
	
	protected BloqueDePregunta bloquePregunta;

	public PowerUp(Sprite sprite, Point posicion, Visitante visitor, ObserverGrafico observerGrafico) {
		super(sprite, posicion, visitor, observerGrafico);
	}
	
	public abstract void aceptarVisitante(Visitante visitante);
	
	public abstract int obtenerPuntosPorDefault();
	
	public abstract int obtenerPuntosPorSuper();
	
	public abstract int obtenerPuntosPorInvulnerable();
	
	public abstract int obtenerPuntosPorFuego();
	
	public abstract void actualizarSprite(FabricaSprites fabricaSprites);
	
	public boolean estaDentroDeBloqueDePreguntas() {
		return this.estaDentroDeBloqueDePreguntas;
	}
	
	public int getTicksHastaSalirDelBloque() {
		return this.ticksHastaSalirDelBloque;
	}


    private void moverDerecha() {
    	Point velocidad = new Point(VELOCIDAD_HORIZONTAL_POWERUP, this.getVelocidadDireccional().y);
    	this.setVelocidadDireccional(velocidad);
    }
    
    private void moverIzquierda() {
    	Point velocidad = new Point(-VELOCIDAD_HORIZONTAL_POWERUP, this.getVelocidadDireccional().y);
    	this.setVelocidadDireccional(velocidad);
    }
    
    public void invertirDireccion() {
    	Point velocidad = new Point(-this.getVelocidadDireccional().x, this.getVelocidadDireccional().y);
    	this.setVelocidadDireccional(velocidad);
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
	
	public void eliminarEntidadGrafica(FabricaSprites fabricaSprites) {
		this.setSprite(fabricaSprites.getSpriteInvisible());
		this.getNivel().addEntidadesAEliminar(this);
	}
	
	public BloqueDePregunta getBloquePregunta() {
		return this.bloquePregunta;
	}
	
	public void setBloquePregunta(BloqueDePregunta bloquePregunta) {
		this.bloquePregunta = bloquePregunta;
	}
	
	@Override
	public void mover() {
		if(removido) {
    		Point velocidad = new Point(0, 0);
    		this.setVelocidadDireccional(velocidad);
    	}else {
    		if (this.getVelocidadDireccional().x <= 0) {
    			moverIzquierda();
    		} else if (this.getVelocidadDireccional().x > 0){
    			moverDerecha();
    		}
    	}
	}
	
}
