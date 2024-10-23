package elementos.powerUps;

import java.awt.Point;
import elementos.Sprite;
import fabricas.FabricaSprites;
import observers.ObserverGrafico;
import visitors.Visitante;

public class FlorDeFuego extends PowerUp {
	
	public FlorDeFuego(Sprite sprite, Point posicion, Visitante visitor,					   
					   ObserverGrafico observerGrafico) {
		super(sprite, posicion, visitor, new Point (0,0), observerGrafico);
	}
	
	@Override
	public void aceptarVisitante (Visitante visitante) {
		visitante.visitar(this);
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
		// TODO Auto-generated method stub
		
	}

}
