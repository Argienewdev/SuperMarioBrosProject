package elementos.enemigos;

import java.awt.Point;
import elementos.Sprite;
import elementos.entidades.NoJugable;
import fabricas.FabricaSprites;
import observers.ObserverGrafico;
import visitors.Visitante;

public abstract class Enemigo extends NoJugable {
	
	protected int velocidadHorizontalEnemigo;
	
	protected int puntosOtorgadosPorEliminacion;
		
	protected int puntosSustraidosPorMuerteCausada;
	
	@SuppressWarnings("exports")
	public Enemigo(Sprite sprite, Point posicion, Visitante visitor, ObserverGrafico observerGrafico) {
		super(sprite, posicion, visitor, observerGrafico);
		this.colisionAbajo = true;
		this.velocidadHorizontalEnemigo = 2;
	}
    
	public int obtenerVelocidadHorizontalEnemigo() {
		return velocidadHorizontalEnemigo;
	}
	
    public int obtenerPuntosOtorgadosPorEliminacion() {
        return this.puntosOtorgadosPorEliminacion;
    }
    
    public int obtenerPuntosSustraidosPorMuerteCausada() {
        return this.puntosSustraidosPorMuerteCausada;
    }

    protected abstract Sprite obtenerSpriteDeMuerte(FabricaSprites fabricaSprites);
    
    
    protected void moverDerecha() {
    	Point velocidad = new Point(velocidadHorizontalEnemigo, this.obtenerVelocidadDireccional().y);
    	this.establecerVelocidadDireccional(velocidad);
    	this.establecerMirandoAlFrente(true);
    }
    
    protected void moverIzquierda() {
    	Point velocidad = new Point(-velocidadHorizontalEnemigo, this.obtenerVelocidadDireccional().y);
    	this.establecerVelocidadDireccional(velocidad);
    	this.establecerMirandoAlFrente(false);
    }
    
    public void invertirDireccion() {
    	if (removido) {
    		Point velocidad = new Point(0, 0);
    		this.establecerVelocidadDireccional(velocidad);
    	} else {
    		Point velocidad = new Point(-this.obtenerVelocidadDireccional().x, this.obtenerVelocidadDireccional().y);
    		this.establecerVelocidadDireccional(velocidad);
    	}
    }
    
    public void actualizarSprite(FabricaSprites fabricaSprites) {
    	if (this.removido) {
			eliminarEntidadGrafica(fabricaSprites);
			this.establecerVelocidadDireccional(new Point(0, 0));
		}
    }
    
    public void eliminarEntidadGrafica(FabricaSprites fabricaSprites) {
    	this.incrementarContadorTicks();
		if (obtenerContadorTicks() ==  1){
			this.establecerSprite(obtenerSpriteDeMuerte(fabricaSprites));
			this.actualizarHitboxYPosicion(fabricaSprites);
		} else if (obtenerContadorTicks() ==  ticksAnimacion) {
			this.establecerSprite(fabricaSprites.obtenerSpriteInvisible());
			this.obtenerNivel().removerEnemigo(this);
			this.observerGrafico.establecerRemovido(true);
		}
	}
    
    public abstract void aceptarVisitante(Visitante visitante);

	public void mover() {
    	if (removido) {
    		Point velocidad = new Point(0, 0);
    		this.establecerVelocidadDireccional(velocidad);
    	} else {
    		if (this.obtenerVelocidadDireccional().x <=  0) {
    			moverIzquierda();
    		} else if (this.obtenerVelocidadDireccional().x > 0) {
    			moverDerecha();
    		}
    	}
	}
    
   
}
