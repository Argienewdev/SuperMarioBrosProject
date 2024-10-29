package elementos.enemigos;

import java.awt.Point;
import elementos.Sprite;
import elementos.entidades.BolaDeFuego;
import fabricas.FabricaEntidades;
import fabricas.FabricaSprites;
import observers.ObserverGrafico;
import visitors.Visitante;

public class Lakitu extends Enemigo {
    
	private static final int TICKS_PARA_ELIMINAR = 1;

	private static final int VELOCIDAD_HORIZONTAL_ENEMIGO = 1;
	
	private static final int INTERVALO_PARA_DISPARAR = 300;
	
	private int contadorTicksDisparo;
	
	FabricaEntidades fabricaEntidades;
	
    public Lakitu(Sprite sprite, Point posicion, Visitante visitor, ObserverGrafico observerGrafico, FabricaEntidades fabricaEntidades) {
    	super(sprite, posicion, visitor, observerGrafico);
    	this.fabricaEntidades = fabricaEntidades;
    	this.puntosOtorgadosPorEliminacion = 60;
    	this.puntosSustraidosPorMuerteCausada = 0;
    	this.ticksAnimacion = TICKS_PARA_ELIMINAR;
    	this.contadorTicksDisparo = 0;
    }
    
    @Override
    public void aplicarGravedad() {
    }

    public void lanzarSpiny() {
    	if(contadorTicksDisparo < INTERVALO_PARA_DISPARAR) {
    		this.contadorTicksDisparo++;
    	}else {
    		this.contadorTicksDisparo = 0;
    		int posX = getPosicion().x + this.obtenerAncho();
    		int posY = getPosicion().y + this.obtenerAlto();
    		Point posicionInicialSpiny = new Point(posX, posY);
    		Spiny spiny = fabricaEntidades.getSpiny(posicionInicialSpiny);
    		getNivel().addSpinyAAgregar(spiny);
    	}
    }
    
    @Override
    public void aceptarVisitante(Visitante visitante) {
        visitante.visitarLakitu(this);
    }

    @Override
	public void actualizarSprite(FabricaSprites fabricaSprites) {
    	lanzarSpiny();
		if(this.removido) {
			eliminarEntidadGrafica(fabricaSprites);
		} else if(this.getVelocidadDireccional().x < 0) {
			this.setSprite(fabricaSprites.getLakituFrontalFueraDeLaNube());
		} else if(this.getVelocidadDireccional().x > 0) {
			this.setSprite(fabricaSprites.getLakituReversoFueraDeLaNube());
		}
	}
	
	public void eliminarEntidadGrafica(FabricaSprites fabricaSprites) {
		this.setSprite(fabricaSprites.getSpriteInvisible());
		this.eliminarDelNivel();
	}
    
}