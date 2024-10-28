package elementos.enemigos;

import java.awt.Point;
import elementos.Sprite;
import fabricas.FabricaSprites;
import observers.ObserverGrafico;
import visitors.Visitante;

public class Lakitu extends Enemigo {
    
    public Lakitu(Sprite sprite, Point posicion, Visitante visitor, 
    			   Point velocidadDireccional, ObserverGrafico observerGrafico) {
    	super(sprite, posicion, visitor, velocidadDireccional, observerGrafico);
    	this.puntosOtorgadosPorEliminacion = 60;
    	this.puntosSustraidosPorMuerteCausada = 0;
    }

    public void lanzarSpiny () {
    	// TODO   
    }
    
    @Override
    public void aceptarVisitante(Visitante visitante) {
        visitante.visitarLakitu(this);
    }

	@Override
	public void actualizarSprite(FabricaSprites fabricaSprites) {
		//TODO
	}
	
	public void eliminarEntidadGraficaYLogicamente(FabricaSprites fabricaSprites) {
		this.setSprite(fabricaSprites.getSpriteInvisible());
	}
    
}