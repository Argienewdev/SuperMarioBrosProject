package elementos.powerUps;

import java.awt.Point;
import java.util.Vector;

import elementos.Sprite;
import fabricas.FabricaSprites;
import observers.ObserverGrafico;
import visitors.Visitante;

public class Estrella extends PowerUp {
	
	public static final int TIEMPO_DURACION = 10;
	
	public Estrella(Sprite sprite,Point posicion, Visitante visitor,
					Point velocidadDireccional, ObserverGrafico observerGrafico) {
		super(sprite, posicion, visitor, velocidadDireccional, observerGrafico);
		this.esMovible = true;
		this.estaDentroDeBloqueDePreguntas = true;
	}
	
	@Override
	public void aceptarVisitante (Visitante visitante) {
		visitante.visitar(this);
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
		// TODO Auto-generated method stub
		
	}

}
