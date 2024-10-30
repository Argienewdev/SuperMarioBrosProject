package elementos.enemigos;

import java.awt.Point;
import elementos.Sprite;
import fabricas.FabricaSprites;
import observers.ObserverGrafico;
import visitors.Visitante;

public class PiranhaPlant extends Enemigo {
	    
    protected boolean dentroTuberia;
    
    protected int limiteInferior;
    
    protected int limiteSuperior;

    public PiranhaPlant(Sprite sprite, Point posicion, Visitante visitor,
    					ObserverGrafico observerGrafico) {
    	super(sprite, posicion, visitor, observerGrafico);
    	this.puntosOtorgadosPorEliminacion = 30;
    	this.puntosSustraidosPorMuerteCausada = 30;
    	limiteInferior = this.obtenerPosicion().y;
    	limiteSuperior = this.obtenerPosicion().y-this.sprite.obtenerAltoImagen();
    }

    public void establecerDentroTuberia() {
        this.dentroTuberia = true;
    }
    
    @Override
    public void aplicarGravedad() {
    }
    
    public void establecerFueraTuberia() {
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
	
	@Override
	protected Sprite obtenerSpriteDeMuerte(FabricaSprites fabricaSprites) {
		return fabricaSprites.getPiranhaPlantMuerto();
	}
	public void mover() {
		if(this.obtenerPosicion().y==limiteInferior) {
			moverArriba();
		}else if (this.obtenerPosicion().y==limiteSuperior){
			moverAbajo();
		}
	}

	private void moverAbajo() {
		Point velocidad = new Point(0, 1);
    	this.establecerVelocidadDireccional(velocidad);
	}

	private void moverArriba() {
		Point velocidad = new Point(0, -1);
    	this.establecerVelocidadDireccional(velocidad);
	}

}
