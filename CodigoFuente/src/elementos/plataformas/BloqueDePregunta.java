package elementos.plataformas;

import java.util.Vector;

import elementos.Sprite;
import elementos.powerUps.PowerUp;
import juego.Nivel;
import visitors.Visitante;

public class BloqueDePregunta extends BloqueSolido {
	
	protected PowerUp powerUp;
	
	protected boolean estaVacio;
	
	public BloqueDePregunta (Sprite sprite, Vector<Integer> pos, 
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
			Nivel nivel = powerUp.getNivel();
			nivel.addPowerUps(powerUp);
		}
		return this.powerUp;
	}

}
