package elementos.powerUps;

import java.awt.Point;
import elementos.Sprite;
import fabricas.FabricaSprites;
import observers.ObserverGrafico;
import visitors.Visitante;

public class Monedas extends PowerUp {
	
	public Monedas(Sprite sprite, Point posicion, Visitante visitor,
			   	   ObserverGrafico observerGrafico, boolean dentroDeBloqueDePreguntas) {
		super(sprite, posicion, visitor, observerGrafico);
		//TODO se deberian setear con los establecer al crear el elemento?
		this.esMovible = false;
		this.estaDentroDeBloqueDePreguntas = dentroDeBloqueDePreguntas;
	}
	
	public void aceptarVisitante(Visitante visitante) {
		visitante.visitarMonedas(this);
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
