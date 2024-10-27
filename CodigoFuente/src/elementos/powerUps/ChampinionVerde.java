package elementos.powerUps;

import java.awt.Point;
import elementos.Sprite;
import fabricas.FabricaSprites;
import observers.ObserverGrafico;
import visitors.Visitante;

public class ChampinionVerde extends PowerUp {
	
	public ChampinionVerde(Sprite sprite, Point posicion, Visitante visitor, Point velocidadDireccional, 					 
						   ObserverGrafico observerGrafico) {
		super(sprite, posicion, visitor, velocidadDireccional, observerGrafico);
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
		if(removido) {
			eliminarEntidadGraficamente(fabricaSprites);
		}else {
			if(!this.estaDentroDeBloqueDePreguntas && getContadorTicks() < ticksHastaSalirDelBloque) {
				this.setSprite(fabricaSprites.getChampinionVerdeSaliendoDelBloqueDePreguntas());
			}else if(getContadorTicks() >= ticksHastaSalirDelBloque) {
				this.setSprite(fabricaSprites.getChampinionVerde());
			}		
		}
	}

}
