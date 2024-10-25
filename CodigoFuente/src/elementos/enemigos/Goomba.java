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
	}
	public void  elminarEntidadGraficamente(FabricaSprites fabricaSprites) {
		//this.setSprite(fabricaSprites.getGoombaAplastado());
		this.setSprite(fabricaSprites.getSpriteInvisible());

	}
} 