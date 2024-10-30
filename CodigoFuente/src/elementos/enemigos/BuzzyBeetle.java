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
			this.setVelocidadDireccional(new Point(0,0));
			eliminarEntidadGrafica(fabricaSprites);
		} else if(this.getVelocidadDireccional().x < 0) {
			this.setSprite(fabricaSprites.getBuzzyBeetleReversoCaminando());
		} else if(this.getVelocidadDireccional().x > 0) {
			this.setSprite(fabricaSprites.getBuzzyBeetleFrontalCaminando());
		}
	}
	
	@Override
	protected Sprite getSpriteDeMuerte(FabricaSprites fabricaSprites) {
		return fabricaSprites.getBuzzyBeetleMuerto();
	}

}