package elementos.enemigos;

import java.awt.Point;
import elementos.Sprite;
import fabricas.FabricaSprites;
import observers.ObserverGrafico;
import visitors.Visitante;

public class Spiny extends Enemigo {
	
    public Spiny(Sprite sprite, Point posicion, Visitante visitor, 
    			  Point direccion, ObserverGrafico observerGrafico) {
    	super(sprite, posicion, visitor, direccion, observerGrafico);
    	this.puntosOtorgadosPorEliminacion = 60;
    	this.puntosSustraidosPorMuerteCausada = 30;
    }

    @Override
    public void aceptarVisitante(Visitante visitante) {
        visitante.visitarSpiny(this);
    }

	@Override
	public void actualizarSprite(FabricaSprites fabricaSprites) {
		// TODO Auto-generated method stub
		// Segun su velocidad direccional actualizar el sprite
	}
	public void  elminarEntidadGraficamente(FabricaSprites fabricaSprites) {
		this.setSprite(fabricaSprites.getSpriteInvisible());
	}
    
}
