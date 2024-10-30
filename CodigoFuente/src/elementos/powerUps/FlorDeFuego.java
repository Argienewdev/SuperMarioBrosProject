package elementos.powerUps;

import java.awt.Point;
import elementos.Sprite;
import fabricas.FabricaSprites;
import observers.ObserverGrafico;
import visitors.Visitante;

public class FlorDeFuego extends PowerUp {
	
	public FlorDeFuego(Sprite sprite, Point posicion, Visitante visitor,					   
					   ObserverGrafico observerGrafico) {
		super(sprite, posicion, visitor, observerGrafico);
		this.esMovible = false;
		this.estaDentroDeBloqueDePreguntas = true;
		this.ticksAnimacion = 0;
		this.ticksHastaSalirDelBloque = 40;
	}
	
	@Override
	public void aceptarVisitante (Visitante visitante) {
		visitante.visitarFlorDeFuego(this);
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

	@Override
	public void actualizarSprite(FabricaSprites fabricaSprites) {
		if(this.obtenerRemovido()) {
			this.eliminarEntidadGrafica(fabricaSprites);
		}else {
			if(!this.estaDentroDeBloqueDePreguntas && getContadorTicks() < ticksHastaSalirDelBloque) {
				this.establecerSprite(fabricaSprites.obtenerFlorDeFuegoSaliendoDelBloqueDePreguntas());
			} else if(getContadorTicks() == ticksHastaSalirDelBloque) {
				this.establecerSprite(fabricaSprites.obtenerFlorDeFuegoQuieto());
			} 
		}
	}

}
