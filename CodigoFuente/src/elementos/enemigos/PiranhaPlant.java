package elementos.enemigos;

import java.awt.Point;
import elementos.Sprite;
import fabricas.FabricaSprites;
import observers.ObserverGrafico;
import visitors.Visitante;

public class PiranhaPlant extends Enemigo {
	    
    protected boolean dentroTuberia;
    

    public PiranhaPlant(Sprite sprite, Point posicion, Visitante visitor,
    					ObserverGrafico observerGrafico) {
    	super(sprite, posicion, visitor, observerGrafico);
    	this.puntosOtorgadosPorEliminacion = 30;
    	this.puntosSustraidosPorMuerteCausada = 30;
    }

    public void setDentroTuberia() {
        this.dentroTuberia = true;
    }
    
    public void setFueraTuberia() {
        this.dentroTuberia = false;
    }
    
    public boolean enTuberia() {
        return this.dentroTuberia;
    }
    
    @Override
    public void aceptarVisitante (Visitante visitante) {
        visitante.visitarPiranhaPlant(this);
    }

	@Override
	public void actualizarSprite(FabricaSprites fabricaSprites) {
		// TODO Auto-generated method stub
		// Segun su velocidad direccional actualizar el sprite
	}
	public void  eliminarEntidadGraficaYLogicamente(FabricaSprites fabricaSprites) {
		this.setSprite(fabricaSprites.getSpriteInvisible());
	}

}
