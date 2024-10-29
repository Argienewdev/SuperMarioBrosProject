package elementos.enemigos;

import java.awt.Point;
import elementos.Sprite;
import fabricas.FabricaSprites;
import observers.ObserverGrafico;
import visitors.Visitante;

public class Lakitu extends Enemigo {
    
	private static final int TICKS_PARA_ELIMINAR = 1;
	
    public Lakitu(Sprite sprite, Point posicion, Visitante visitor, ObserverGrafico observerGrafico) {
    	super(sprite, posicion, visitor, observerGrafico);
    	this.puntosOtorgadosPorEliminacion = 60;
    	this.puntosSustraidosPorMuerteCausada = 0;
    	this.ticksAnimacion = TICKS_PARA_ELIMINAR;
    }
    
    @Override
    public void aplicarGravedad() {
    }

    public void lanzarSpiny () {
    	//TODO
    }
    
    @Override
    public void aceptarVisitante(Visitante visitante) {
        visitante.visitarLakitu(this);
    }

    @Override
	public void actualizarSprite(FabricaSprites fabricaSprites) {
		if(this.removido) {
			eliminarEntidadGrafica(fabricaSprites);
		} else {
			this.setSprite(fabricaSprites.getLakituFrontalFueraDeLaNube());
		}
	}
	
	public void eliminarEntidadGrafica(FabricaSprites fabricaSprites) {
		this.setSprite(fabricaSprites.getSpriteInvisible());
		this.eliminarDelNivel();
	}
    
}