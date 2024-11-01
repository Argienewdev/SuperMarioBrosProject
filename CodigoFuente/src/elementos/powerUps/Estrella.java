package elementos.powerUps;

import java.awt.Point;
import elementos.Sprite;
import fabricas.FabricaSprites;
import observers.ObserverGrafico;
import visitors.Visitante;

public class Estrella extends PowerUp {
	
	public static final int TIEMPO_DURACION = 10;
	
	public Estrella(Sprite sprite,Point posicion, Visitante visitor, ObserverGrafico observerGrafico) {
		super(sprite, posicion, visitor, observerGrafico);
		this.esMovible = true;
		this.estaDentroDeBloqueDePreguntas = true;
		this.ticksHastaSalirDelBloque = 50;
	}
	
	@Override
	public void aceptarVisitante (Visitante visitante) {
		visitante.visitarEstrella(this);
	}
	
	public int obtenerPuntosPorDefault() {
		return 20;
	}
	
	public int obtenerPuntosPorSuper() {
		return 30;
	}
	
	public int obtenerPuntosPorInvulnerable() {
		return 35;
	}
	
	public int obtenerPuntosPorFuego() {
		return obtenerPuntosPorSuper();
	}

	@Override
	public void actualizarSprite(FabricaSprites fabricaSprites) {
		if (this.obtenerRemovido()) {
			this.eliminarEntidadGrafica(fabricaSprites);
		} else {
			if (!this.estaDentroDeBloqueDePreguntas && obtenerContadorTicks() < ticksHastaSalirDelBloque) {
				this.establecerSprite(fabricaSprites.obtenerEstrellaApagada());
				this.actualizarHitboxYPosicion(fabricaSprites);
			} else if (obtenerContadorTicks() >=  ticksHastaSalirDelBloque) {
				this.establecerSprite(fabricaSprites.obtenerEstrellaEncendida());
				this.actualizarHitboxYPosicion(fabricaSprites);
			}		
		}
	}

}
