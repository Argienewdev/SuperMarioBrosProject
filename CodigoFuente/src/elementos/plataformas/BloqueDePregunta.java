package elementos.plataformas;

import java.awt.Point;


import elementos.Sprite;
import elementos.powerUps.PowerUp;
import fabricas.FabricaSprites;
import visitors.Visitante;

public class BloqueDePregunta extends Plataforma {
	
	protected PowerUp powerUp;
	
	protected boolean estaVacio;
	
	public BloqueDePregunta (Sprite sprite, Point pos, 
							 Visitante visitor, PowerUp powerUp) {
		super(sprite,pos,visitor);
		this.powerUp = powerUp;
		if (powerUp != null)
			this.estaVacio = false;
		else
			this.estaVacio = true;
	}
	
	public void setPowerUp (PowerUp powerUp) {
		this.powerUp = powerUp;
		this.estaVacio = false;
	}
	
	public PowerUp getPowerUp() {
		return this.powerUp;
	}
	
	public void aceptarVisitante (Visitante visitante) {
		visitante.visitarBloqueDePregunta(this);
	}

	public boolean estaVacio() {
		return this.estaVacio;
	}
	
	public void setVacio (boolean vacio) {
		this.estaVacio = vacio;
	}
	
	public PowerUp liberarPowerUp() { 
		if (!estaVacio) {
			powerUp.establecerEstaDentroDeBloqueDePreguntas(false);
			this.estaVacio = true;
		}
		return this.powerUp;
	}
	public  void actualizarSprite(FabricaSprites fabricaSprites) {
		if(estaVacio) {
			this.setSprite(fabricaSprites.getBloqueDePreguntaApagado());
		}
	}

}
