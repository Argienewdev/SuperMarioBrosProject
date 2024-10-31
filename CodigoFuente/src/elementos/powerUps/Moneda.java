package elementos.powerUps;

import java.awt.Point;
import elementos.Sprite;
import fabricas.FabricaSprites;
import observers.ObserverGrafico;
import visitors.Visitante;

public class Moneda extends PowerUp {
	
	public Moneda(Sprite sprite, Point posicion, Visitante visitor,
			   	   ObserverGrafico observerGrafico, boolean dentroDeBloqueDePreguntas) {
		super(sprite, posicion, visitor, observerGrafico);
		this.esMovible = false;
		this.estaDentroDeBloqueDePreguntas = dentroDeBloqueDePreguntas;
	}
	
	public void aceptarVisitante(Visitante visitante) {
		visitante.visitarMoneda(this);
	}
	
	public int obtenerPuntosPorDefault() {
		return 5;
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
			if(!this.estaDentroDeBloqueDePreguntas ) {
				this.establecerSprite(fabricaSprites.obtenerMonedaEncendida());
			} 
		}
	}
}
