package elementos.powerUps;

import java.awt.Point;
import elementos.Sprite;
import fabricas.FabricaSprites;
import observers.ObserverGrafico;
import visitors.Visitante;

public class SuperChampinion extends PowerUp {
	
	public SuperChampinion(Sprite sprite, Point posicion, Visitante visitor,
						   Point velocidadDireccional, ObserverGrafico observerGrafico) {
		super(sprite, posicion, visitor, velocidadDireccional, observerGrafico);
		this.esMovible = true;
		this.estaDentroDeBloqueDePreguntas = true;
		this.ticksHastaSalirDelBloque = 50;
	}
	
	@Override
	public void aceptarVisitante (Visitante visitante) {
		visitante.visitarSuperChampinion(this);
	}

	public int obtenerPuntosPorDefault() {
		return 10;
	}
	
	public int obtenerPuntosPorSuper() {
		return 50;
	}
	
	public int obtenerPuntosPorInvulnerable() {
		return obtenerPuntosPorSuper();
	}
	
	public int obtenerPuntosPorFuego() {
		return obtenerPuntosPorSuper();
	}

	@Override
	public void actualizarSprite(FabricaSprites fabricaSprites) {
		if(!this.estaDentroDeBloqueDePreguntas && getContadorTicks() < ticksHastaSalirDelBloque) {
			this.setSprite(fabricaSprites.getSuperChampinionSaliendoDelBloqueDePreguntas());
		}else if(getContadorTicks() >= ticksHastaSalirDelBloque) {
			this.setSprite(fabricaSprites.getSuperChampinionQuieto());
		}
	}
}
