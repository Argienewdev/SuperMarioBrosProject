package elementos.enemigos;

import java.awt.Point;
import elementos.Sprite;
import elementos.entidades.BolaDeFuego;
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
//    	int posX = getContext().getPosicion().x;
//		int posY = getContext().getPosicion().y;
//		Point posicionInicialBolaDeFuego = new Point(posX,posY);
//		Point velocidadDireccionalBolaDeFuego = new Point(0,0);
//		BolaDeFuego bolaDeFuego= fabricaEntidades.getBolaDeFuego(posicionInicialBolaDeFuego, velocidadDireccionalBolaDeFuego, contexto);
//		contexto.getNivel().addBolaDeFuego(bolaDeFuego);
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