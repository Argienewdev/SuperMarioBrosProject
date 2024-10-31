package elementos.plataformas;

import java.awt.Point;
import java.util.ArrayList;
import java.util.LinkedList;

import elementos.Sprite;
import elementos.powerUps.PowerUp;
import fabricas.FabricaSprites;
import observers.ObserverGrafico;
import visitors.Visitante;

public class BloqueDePregunta extends Plataforma {
	
	protected LinkedList<PowerUp> coleccionPowerUps;
	
	public BloqueDePregunta (Sprite sprite, Point pos, 
							 Visitante visitor, PowerUp powerUp,
							 ObserverGrafico observerGrafico) {
		super(sprite,pos,visitor,observerGrafico);
		this.coleccionPowerUps = new LinkedList<PowerUp>();
		if (powerUp != null) {
			this.coleccionPowerUps.add(powerUp);
		}
	}
	
	public void agregarPowerUp (PowerUp powerUp) {
		this.coleccionPowerUps.add(powerUp);
	}
	
	public PowerUp obtenerPowerUp() {
		return this.coleccionPowerUps.getLast();
	}
	
	public PowerUp removerPowerUp() {
		return this.coleccionPowerUps.removeLast();
	}
	
	public void aceptarVisitante (Visitante visitante) {
		visitante.visitarBloqueDePregunta(this);
	}

	public boolean estaVacio() {
		return coleccionPowerUps.isEmpty();
	}
	
	public PowerUp liberarPowerUp() {
		PowerUp powerUpARemover = null;
		if (!estaVacio()) {
			powerUpARemover = this.coleccionPowerUps.removeLast();
			powerUpARemover.establecerEstaDentroDeBloqueDePreguntas(false);
		}
		return powerUpARemover;
	}
	public  void actualizarSprite(FabricaSprites fabricaSprites) {
		if(estaVacio()) {
			this.establecerSprite(fabricaSprites.obtenerBloqueDePreguntaApagado());
		}
	}

}
