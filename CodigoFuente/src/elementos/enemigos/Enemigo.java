package elementos.enemigos;

import java.awt.Point;
import elementos.Sprite;
import elementos.entidades.NoJugable;
import fabricas.FabricaSprites;
import observers.ObserverGrafico;
import visitors.Visitante;

public abstract class Enemigo extends NoJugable {
	
	protected static final int VELOCIDAD_HORIZONTAL_ENEMIGO = 2;
	
	protected int puntosOtorgadosPorEliminacion;
		
	protected int puntosSustraidosPorMuerteCausada;
	
	@SuppressWarnings("exports")
	public Enemigo(Sprite sprite, Point posicion, Visitante visitor, ObserverGrafico observerGrafico) {
		super(sprite, posicion, visitor, observerGrafico);
		this.colisionAbajo = true;
	}
    
    public int obtenerPuntosOtorgadosPorEliminacion() {
        return this.puntosOtorgadosPorEliminacion;
    }
    
    public int obtenerPuntosSustraidosPorMuerteCausada() {
        return this.puntosSustraidosPorMuerteCausada;
    }

    private void moverDerecha() {
    	Point velocidad = new Point(VELOCIDAD_HORIZONTAL_ENEMIGO, this.obtenerVelocidadDireccional().y);
    	this.establecerVelocidadDireccional(velocidad);
    }
    
    private void moverIzquierda() {
    	Point velocidad = new Point(-VELOCIDAD_HORIZONTAL_ENEMIGO, this.obtenerVelocidadDireccional().y);
    	this.establecerVelocidadDireccional(velocidad);
    }
    
    public void invertirDireccion() {
    	if(removido) {
    		Point velocidad = new Point(0, 0);
    		this.establecerVelocidadDireccional(velocidad);
    	}else {
    		Point velocidad = new Point(-this.obtenerVelocidadDireccional().x, this.obtenerVelocidadDireccional().y);
    		this.establecerVelocidadDireccional(velocidad);
    	}
    }
    
    protected abstract Sprite obtenerSpriteDeMuerte(FabricaSprites fabricaSprites);
    
    public void actualizarSprite(FabricaSprites fabricaSprites) {
    	if(this.removido) {
			eliminarEntidadGrafica(fabricaSprites);
			this.establecerVelocidadDireccional(new Point(0, 0));
		}
    }
    
    public void eliminarEntidadGrafica(FabricaSprites fabricaSprites) {
    	this.incrementarContadorTicks();
		if(getContadorTicks() == 1){
			this.establecerSprite(obtenerSpriteDeMuerte(fabricaSprites));
			this.actualizarHitboxYPosicion(fabricaSprites);
		} else if(getContadorTicks() == ticksAnimacion) {
			this.establecerSprite(fabricaSprites.getSpriteInvisible());
			this.eliminarDelNivel();
		}
	}
    
    public int obtenerVelocidadHorizontalEnemigo() {
    	return VELOCIDAD_HORIZONTAL_ENEMIGO;
    }
    
    public abstract void aceptarVisitante(Visitante visitante);

    @Override
	public void mover() {
    	if(removido) {
    		Point velocidad = new Point(0, 0);
    		this.establecerVelocidadDireccional(velocidad);
    	} else {
    		if (this.obtenerVelocidadDireccional().x <= 0) {
    			moverIzquierda();
    		} else if (this.obtenerVelocidadDireccional().x > 0) {
    			moverDerecha();
    		}
    	}
	}
    
   
}
