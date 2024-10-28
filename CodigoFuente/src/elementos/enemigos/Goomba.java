package elementos.enemigos;

import java.awt.Point;

import elementos.Sprite;
import fabricas.FabricaSprites;
import observers.ObserverGrafico;
import visitors.Visitante;

public class Goomba extends Enemigo {
	
	private static final int TICKS_PARA_ELIMINAR = 10;
	
    public Goomba(Sprite sprite, Point posicion, Visitante visitor, ObserverGrafico observerGrafico) {
        super(sprite, posicion, visitor, observerGrafico);
        this.puntosOtorgadosPorEliminacion = 60;
        this.puntosSustraidosPorMuerteCausada = 30;
        this.ticksAnimacion = 5;
    }
    
    @Override
    public void aceptarVisitante(Visitante visitante) {
        visitante.visitarGoomba(this);
    }

	@Override
	public void actualizarSprite(FabricaSprites fabricaSprites) {
		if(this.removido) {
			this.setVelocidadDireccional(new Point(0, 0));
			eliminarEntidadGrafica(fabricaSprites);
		}
	}
	
	public void eliminarEntidadGrafica(FabricaSprites fabricaSprites) {
		if(getContadorTicks() == 1){
			this.setSprite(fabricaSprites.getGoombaAplastado());
			this.actualizarHitboxYPosicion(fabricaSprites);
		} else if(getContadorTicks() == ticksAnimacion) {
			this.setSprite(fabricaSprites.getSpriteInvisible());
			this.eliminarDelNivel();
		}
	}
} 