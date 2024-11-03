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
	
	protected boolean haceRuidoAlSalir;

	public PowerUp(Sprite sprite, Point posicion, Visitante visitor, ObserverGrafico observerGrafico) {
		super(sprite, posicion, visitor, observerGrafico);
		this.haceRuidoAlSalir = true;
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
	
	public int obtenerTicksHastaSalirDelBloque() {
		return this.ticksHastaSalirDelBloque;
	}

    protected void moverDerecha() {
    	Point velocidad = new Point(VELOCIDAD_HORIZONTAL_POWERUP, this.obtenerVelocidadDireccional().y);
    	this.establecerVelocidadDireccional(velocidad);
    }
    
    protected void moverIzquierda() {
    	Point velocidad = new Point(-VELOCIDAD_HORIZONTAL_POWERUP, this.obtenerVelocidadDireccional().y);
    	this.establecerVelocidadDireccional(velocidad);
    }
    
    public void invertirDireccion() {
    	Point velocidad = new Point(-this.obtenerVelocidadDireccional().x, this.obtenerVelocidadDireccional().y);
    	this.establecerVelocidadDireccional(velocidad);
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
		this.establecerSprite(fabricaSprites.obtenerSpriteInvisible());
		this.obtenerNivel().removerPowerUp(this);
		this.observerGrafico.establecerRemovido(true);
	}
	
	public BloqueDePregunta obtenerBloquePregunta() {
		return this.bloquePregunta;
	}
	
	public void establecerBloquePregunta(BloqueDePregunta bloquePregunta) {
		this.bloquePregunta = bloquePregunta;
	}
	
	@Override
	public void mover() {
		if (removido) {
    		Point velocidad = new Point(0, 0);
    		this.establecerVelocidadDireccional(velocidad);
    	} else {
    		if (this.obtenerVelocidadDireccional().x < 0) {
    			moverIzquierda();
    		} else if (this.obtenerVelocidadDireccional().x >=  0){
    			moverDerecha();
    		}
    	}
	}
	
	public boolean obtenerHaceRuidoAlSalir() {
		return this.haceRuidoAlSalir;
	}
	
}
