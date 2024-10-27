package elementos.enemigos;

import java.awt.Point;
import elementos.Sprite;
import fabricas.FabricaSprites;
import observers.ObserverGrafico;
import visitors.Visitante;

public class Goomba extends Enemigo {
	
    public Goomba(Sprite sprite, Point posicion, Visitante visitor,
    			   Point velocidadDireccional, ObserverGrafico observerGrafico) {
        super(sprite, posicion, visitor, velocidadDireccional, observerGrafico);
        this.puntosOtorgadosPorEliminacion = 60;
        this.puntosSustraidosPorMuerteCausada = 30;
    }
    
    @Override
    public void aceptarVisitante(Visitante visitante) {
        visitante.visitarGoomba(this);
    }

	@Override
	public void actualizarSprite(FabricaSprites fabricaSprites) {
		if(this.removido) {
			eliminarEntidadGraficamente(fabricaSprites);
		}
	}
	
	public void eliminarEntidadGraficamente(FabricaSprites fabricaSprites) {
		if(getContadorTicks() < ticksAnimacion) {
			this.setRemovido(true);
			this.setSprite(fabricaSprites.getGoombaAplastado());
		} else if(getContadorTicks() == ticksAnimacion) {
			this.setSprite(fabricaSprites.getSpriteInvisible());
		} else {
			this.eliminarDelNivel();
		}
	}
} 