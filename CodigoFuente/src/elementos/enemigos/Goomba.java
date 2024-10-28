package elementos.enemigos;

import java.awt.Point;
import elementos.Sprite;
import fabricas.FabricaSprites;
import observers.ObserverGrafico;
import visitors.Visitante;

public class Goomba extends Enemigo {
	
    public Goomba(Sprite sprite, Point posicion, Visitante visitor, ObserverGrafico observerGrafico) {
        super(sprite, posicion, visitor, observerGrafico);
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
			eliminarEntidadGraficaYLogicamente(fabricaSprites);
			this.setVelocidadDireccional(new Point(0, 0));
		}
	}
	
	public void eliminarEntidadGraficaYLogicamente(FabricaSprites fabricaSprites) {
		if(getContadorTicks() < ticksAnimacion) {
			this.setSprite(fabricaSprites.getGoombaAplastado());
		} else if(getContadorTicks() == ticksAnimacion) {
			this.setSprite(fabricaSprites.getSpriteInvisible());
		} else {
			this.eliminarDelNivel();
		}
	}
} 