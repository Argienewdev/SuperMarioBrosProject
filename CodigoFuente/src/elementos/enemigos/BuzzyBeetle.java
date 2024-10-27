package elementos.enemigos;

import java.awt.Point;
import elementos.Sprite;
import fabricas.FabricaSprites;
import observers.ObserverGrafico;
import visitors.Visitante;

public class BuzzyBeetle extends Enemigo {
	
	public BuzzyBeetle(Sprite sprite, Point posicion, Visitante visitor,
					    Point velocidadDireccional, ObserverGrafico observerGrafico) {
		super(sprite, posicion, visitor, velocidadDireccional, observerGrafico);
		this.puntosOtorgadosPorEliminacion = 30;
		this.puntosSustraidosPorMuerteCausada = 15;
	}
	
	@Override
	public void aceptarVisitante (Visitante visitante) {
		visitante.visitarBuzzyBeetle(this);
	}

	@Override
	public void actualizarSprite(FabricaSprites fabricaSprites) {
		if(this.removido) {
			eliminarEntidadGraficamente(fabricaSprites);
			this.setVelocidadDireccional(new Point(0,0));
		}else if(this.getVelocidadDireccional().x == 0) {
			this.setSprite(fabricaSprites.getBuzzyBeetleFrontalCaminando());
		} else if(this.getVelocidadDireccional().x < 0) {
			this.setSprite(fabricaSprites.getBuzzyBeetleReversoCaminando());
		} else if(this.getVelocidadDireccional().x > 0) {
			this.setSprite(fabricaSprites.getBuzzyBeetleFrontalCaminando());
		}
	}
	
	public void eliminarEntidadGraficamente(FabricaSprites fabricaSprites) {
		if(getContadorTicks() < ticksAnimacion) {
			this.setSprite(fabricaSprites.getBuzzyBeetleFrontalQuieto());
		} else if(getContadorTicks() == ticksAnimacion) {
			this.setSprite(fabricaSprites.getSpriteInvisible());
		} else {
			this.eliminarDelNivel();
		}
	}

}