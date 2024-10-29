package elementos.enemigos;

import java.awt.Point;
import elementos.Sprite;
import fabricas.FabricaSprites;
import observers.ObserverGrafico;
import visitors.Visitante;

public class Spiny extends Enemigo {
	
	private static final int TICKS_PARA_ELIMINAR = 1;
	
    public Spiny(Sprite sprite, Point posicion, Visitante visitor, ObserverGrafico observerGrafico) {
    	super(sprite, posicion, visitor, observerGrafico);
    	this.puntosOtorgadosPorEliminacion = 60;
    	this.puntosSustraidosPorMuerteCausada = 30;
    	this.ticksAnimacion = TICKS_PARA_ELIMINAR;
    }

    @Override
    public void aceptarVisitante(Visitante visitante) {
        visitante.visitarSpiny(this);
    }

	@Override
	public void actualizarSprite(FabricaSprites fabricaSprites) {
		if(this.removido) {
			eliminarEntidadGrafica(fabricaSprites);
		} else if(this.getVelocidadDireccional().x < 0) {
			this.setSprite(fabricaSprites.getSpinyReversoCaminando());
		} else if(this.getVelocidadDireccional().x > 0) {
			this.setSprite(fabricaSprites.getSpinyFrontalCaminando());
		}
	}
	
	public void eliminarEntidadGrafica(FabricaSprites fabricaSprites) {
		this.setSprite(fabricaSprites.getSpriteInvisible());
		this.eliminarDelNivel();
	}
	
}
