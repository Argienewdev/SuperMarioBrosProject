package elementos.enemigos;

import java.awt.Point;
import elementos.Sprite;
import fabricas.FabricaSprites;
import observers.ObserverGrafico;
import visitors.Visitante;

public class ContextoKoopaTroopa extends Enemigo {
	
	private EstadoKoopa estado;

    public ContextoKoopaTroopa(Sprite sprite,Point posicion, Visitante visitor,
							   Point velocidadDireccional, 
							   ObserverGrafico observerGrafico, KoopaDefault estado) {
    	super(sprite, posicion, visitor, velocidadDireccional, observerGrafico);
    	this.estado = estado;
    	this.puntosOtorgadosPorEliminacion = 90;
    	this.puntosSustraidosPorMuerteCausada = 45;
    	estado.setContext(this);
    }

    public EstadoKoopa getEstado() {
    	return this.estado;
    }
    
    public void cambiarEstado(EstadoKoopa estado) {
        this.estado = estado;
    }
    
    @Override
    public void aceptarVisitante(Visitante visitante) {
        visitante.visitarContextoKoopaTroopa(this);
    }

	@Override
	public void actualizarSprite(FabricaSprites fabricaSprites) {
		this.estado.actualizarSprite(fabricaSprites);
	}
	
	public void  eliminarEntidadGraficamente(FabricaSprites fabricaSprites) {
		this.setSprite(fabricaSprites.getSpriteInvisible());
	}
    
}
