package elementos.plataformas;

import java.awt.Point;
import java.util.ArrayList;
import elementos.Sprite;
import elementos.powerUps.PowerUp;
import fabricas.FabricaSprites;
import observers.ObserverGrafico;
import visitors.Visitante;

public class BloqueDePregunta extends Plataforma {
	
	protected ArrayList<PowerUp> coleccionPowerUps;
	
	public BloqueDePregunta (Sprite sprite, Point pos, 
							 Visitante visitor, PowerUp powerUp,
							 ObserverGrafico observerGrafico) {
		super(sprite,pos,visitor,observerGrafico);
		this.coleccionPowerUps = new ArrayList<PowerUp>();
		if (powerUp != null) {
			this.coleccionPowerUps.add(powerUp);
		}
	}
	
	public void agregarPowerUp (PowerUp powerUp) {
		this.coleccionPowerUps.add(powerUp);
	}
	
	public PowerUp obtenerPowerUp() {
		return this.coleccionPowerUps.get(coleccionPowerUps.size() - 1);
	}
	
	public PowerUp removerPowerUp() {
		return this.coleccionPowerUps.remove(coleccionPowerUps.size() - 1);
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
			powerUpARemover = this.coleccionPowerUps.remove(coleccionPowerUps.size() - 1);
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
