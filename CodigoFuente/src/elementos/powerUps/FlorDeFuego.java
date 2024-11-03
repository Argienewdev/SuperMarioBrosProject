package elementos.powerUps;

import java.awt.Point;
import elementos.Sprite;
import fabricas.FabricaSprites;
import observers.ObserverGrafico;
import visitors.Visitante;

public class FlorDeFuego extends PowerUp {
	
	@SuppressWarnings("exports")
	public FlorDeFuego(Sprite sprite, Point posicion, Visitante visitor,					   
					   ObserverGrafico observerGrafico) {
		super(sprite, posicion, visitor, observerGrafico);
		this.esMovible = false;
		this.estaDentroDeBloqueDePreguntas = true;
		this.ticksAnimacion = 0;
		this.ticksHastaSalirDelBloque = 40;
	}
	
	
	public int obtenerPuntosPorDefault() {
		return 5;
	}
	
	public int obtenerPuntosPorSuper() {
		return 30;
	}
	
	public int obtenerPuntosPorInvulnerable() {
		return obtenerPuntosPorSuper();
	}
	
	public int obtenerPuntosPorFuego() {
		return 50;
	}

	public void actualizarSprite(FabricaSprites fabricaSprites) {
		if (this.obtenerRemovido()) {
			this.eliminarEntidadGrafica(fabricaSprites);
		} else {
			if (!this.estaDentroDeBloqueDePreguntas && obtenerContadorTicks() < ticksHastaSalirDelBloque) {
				this.establecerSprite(fabricaSprites.obtenerFlorDeFuegoSaliendoDelBloqueDePreguntas());
				this.actualizarHitboxYPosicion(fabricaSprites);
			} else if (obtenerContadorTicks() ==  ticksHastaSalirDelBloque) {
				this.establecerSprite(fabricaSprites.obtenerFlorDeFuegoQuieto());
				this.actualizarHitboxYPosicion(fabricaSprites);
			} 
		}
	}

	public void aceptarVisitante (Visitante visitante) {
		visitante.visitarFlorDeFuego(this);
	}
	
}
