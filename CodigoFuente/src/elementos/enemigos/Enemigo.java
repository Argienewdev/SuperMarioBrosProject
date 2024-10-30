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
    
    public int getPuntosOtorgadosPorEliminacion() {
        return this.puntosOtorgadosPorEliminacion;
    }
    
    public int getPuntosSustraidosPorMuerteCausada() {
        return this.puntosSustraidosPorMuerteCausada;
    }

    private void moverDerecha() {
    	Point velocidad = new Point(VELOCIDAD_HORIZONTAL_ENEMIGO, this.getVelocidadDireccional().y);
    	this.setVelocidadDireccional(velocidad);
    }
    
    private void moverIzquierda() {
    	Point velocidad = new Point(-VELOCIDAD_HORIZONTAL_ENEMIGO, this.getVelocidadDireccional().y);
    	this.setVelocidadDireccional(velocidad);
    }
    
    public void invertirDireccion() {
    	if(removido) {
    		Point velocidad = new Point(0, 0);
    		this.setVelocidadDireccional(velocidad);
    	}else {
    		Point velocidad = new Point(-this.getVelocidadDireccional().x, this.getVelocidadDireccional().y);
    		this.setVelocidadDireccional(velocidad);
    	}
    }
    
    protected abstract Sprite getSpriteDeMuerte(FabricaSprites fabricaSprites);
    
    public void actualizarSprite(FabricaSprites fabricaSprites) {
    	if(this.removido) {
			eliminarEntidadGrafica(fabricaSprites);
			this.setVelocidadDireccional(new Point(0, 0));
		}
    }
    
    public void eliminarEntidadGrafica(FabricaSprites fabricaSprites) {
    	this.incrementarContadorTicks();
		if(getContadorTicks() == 1){
			this.setSprite(getSpriteDeMuerte(fabricaSprites));
			this.actualizarHitboxYPosicion(fabricaSprites);
		} else if(getContadorTicks() == ticksAnimacion) {
			this.setSprite(fabricaSprites.getSpriteInvisible());
			this.eliminarDelNivel();
		}
	}
    
    public int getVelocidadHorizontalEnemigo() {
    	return VELOCIDAD_HORIZONTAL_ENEMIGO;
    }
    
    public abstract void aceptarVisitante(Visitante visitante);

    @Override
	public void mover() {
    	if(removido) {
    		Point velocidad = new Point(0, 0);
    		this.setVelocidadDireccional(velocidad);
    	} else {
    		if (this.getVelocidadDireccional().x <= 0) {
    			moverIzquierda();
    		} else if (this.getVelocidadDireccional().x > 0) {
    			moverDerecha();
    		}
    	}
	}
    
   
}
