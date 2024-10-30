package elementos.powerUps;

import java.awt.Point;
import elementos.Sprite;
import fabricas.FabricaSprites;
import observers.ObserverGrafico;
import visitors.Visitante;

public class ChampinionVerde extends PowerUp {
	
	public ChampinionVerde(Sprite sprite, Point posicion, Visitante visitor, 					 
						   ObserverGrafico observerGrafico) {
		super(sprite, posicion, visitor, observerGrafico);
		this.esMovible = true;
		this.estaDentroDeBloqueDePreguntas = true;
		this.ticksHastaSalirDelBloque = 50;
		
	}
	
	public void aceptarVisitante (Visitante visitante) {
		visitante.visitarChampinionVerde(this);
	}
	
	public int obtenerPuntosPorDefault() {
		return 100;
	}
	
	public int obtenerPuntosPorSuper() {
		return obtenerPuntosPorDefault();
	}
	
	public int obtenerPuntosPorInvulnerable() {
		return obtenerPuntosPorDefault();
	}
	
	public int obtenerPuntosPorFuego() {
		return obtenerPuntosPorDefault();
	}

	@Override
	public void actualizarSprite(FabricaSprites fabricaSprites) {
		if(this.obtenerRemovido()) {
			this.eliminarEntidadGrafica(fabricaSprites);
		}else {
			if(!this.estaDentroDeBloqueDePreguntas && getContadorTicks() < ticksHastaSalirDelBloque) {
				this.establecerSprite(fabricaSprites.obtenerChampinionVerdeSaliendoDelBloqueDePreguntas());
			}else if(getContadorTicks() >= ticksHastaSalirDelBloque) {
				this.establecerSprite(fabricaSprites.obtenerChampinionVerde());
			}		
		}
	}

}
