package elementos.enemigos;

import java.awt.Point;
import elementos.Sprite;
import fabricas.FabricaSprites;
import observers.ObserverGrafico;
import visitors.Visitante;

public class BuzzyBeetle extends Enemigo {
	
	private static final int TICKS_PARA_ELIMINAR = 10;
	
	public BuzzyBeetle(Sprite sprite, Point posicion, Visitante visitor, ObserverGrafico observerGrafico) {
		super(sprite, posicion, visitor, observerGrafico);
		this.puntosOtorgadosPorEliminacion = 30;
		this.puntosSustraidosPorMuerteCausada = 15;
        this.ticksAnimacion = TICKS_PARA_ELIMINAR;
	}
	
	@Override
	public void aceptarVisitante (Visitante visitante) {
		visitante.visitarBuzzyBeetle(this);
	}

	@Override
	public void actualizarSprite(FabricaSprites fabricaSprites) {
		if(this.removido) {
			this.establecerVelocidadDireccional(new Point(0,0));
			eliminarEntidadGrafica(fabricaSprites);
		} else if(this.obtenerVelocidadDireccional().x < 0) {
			this.establecerSprite(fabricaSprites.obtenerBuzzyBeetleReversoCaminando());
		} else if(this.obtenerVelocidadDireccional().x > 0) {
			this.establecerSprite(fabricaSprites.obtenerBuzzyBeetleFrontalCaminando());
		}
	}
	
	@Override
	protected Sprite obtenerSpriteDeMuerte(FabricaSprites fabricaSprites) {
		return fabricaSprites.obtenerBuzzyBeetleMuerto();
	}

}