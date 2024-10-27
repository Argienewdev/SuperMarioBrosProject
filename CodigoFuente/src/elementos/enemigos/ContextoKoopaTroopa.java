package elementos.enemigos;

import java.awt.Point;
import elementos.Sprite;
import fabricas.FabricaSprites;
import observers.ObserverGrafico;
import visitors.Visitante;

public class ContextoKoopaTroopa extends Enemigo {
	
	private EstadoKoopa estadoKoopa;
	
	private boolean cambiarEstado;

    public ContextoKoopaTroopa(Sprite sprite,Point posicion, Visitante visitor,
							   Point velocidadDireccional, 
							   ObserverGrafico observerGrafico, KoopaDefault estado) {
    	super(sprite, posicion, visitor, velocidadDireccional, observerGrafico);
    	this.estadoKoopa = estado;
    	this.puntosOtorgadosPorEliminacion = 90;
    	this.puntosSustraidosPorMuerteCausada = 45;
    	estado.setContext(this);
    	this.cambiarEstado = false;
    }

    public EstadoKoopa getEstado() {
    	return this.estadoKoopa;
    }
    
    public void cambiarEstado(EstadoKoopa estado) {
        this.estadoKoopa = estado;
        estado.setContext(this);
		this.cambiarEstado = true;
    }
    
    @Override
    public void aceptarVisitante(Visitante visitante) {
        visitante.visitarContextoKoopaTroopa(this);
    }

	@Override
	public void actualizarSprite(FabricaSprites fabricaSprites) {
		this.estadoKoopa.actualizarSprite(fabricaSprites);
		if(cambiarEstado) {
			estadoKoopa.actualizarHitboxYPosicion(fabricaSprites);
			this.cambiarEstado = false;
		}
	}
	public void  eliminarEntidadGraficamente(FabricaSprites fabricaSprites) {
		this.setSprite(fabricaSprites.getSpriteInvisible());
	}
    
}
