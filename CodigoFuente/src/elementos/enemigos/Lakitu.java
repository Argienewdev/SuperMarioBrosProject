package elementos.enemigos;

import java.awt.Point;
import elementos.Sprite;
import elementos.entidades.BolaDeFuego;
import fabricas.FabricaEntidades;
import fabricas.FabricaSprites;
import observers.ObserverGrafico;
import visitors.Visitante;

public class Lakitu extends Enemigo {
    
	private static final int TICKS_PARA_ELIMINAR = 20;

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
    		int posX = obtenerPosicion().x + this.obtenerAncho();
    		int posY = obtenerPosicion().y + this.obtenerAlto();
    		Point posicionInicialSpiny = new Point(posX, posY);
    		Spiny spiny = fabricaEntidades.obtenerSpiny(posicionInicialSpiny);
    		obtenerNivel().agregarSpinyAAgregar(spiny);
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
		} else if(this.obtenerVelocidadDireccional().x < 0) {
			this.establecerSprite(fabricaSprites.obtenerLakituFrontalFueraDeLaNube());
		} else if(this.obtenerVelocidadDireccional().x > 0) {
			this.establecerSprite(fabricaSprites.obtenerLakituReversoFueraDeLaNube());
		}
	}
    
	@Override
	protected Sprite obtenerSpriteDeMuerte(FabricaSprites fabricaSprites) {
		return fabricaSprites.obtenerLakituMuerto();
	}
}