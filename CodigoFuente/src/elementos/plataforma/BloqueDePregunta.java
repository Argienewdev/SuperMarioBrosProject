package elementos.plataforma;

import java.util.Vector;

import elementos.powerUp.PowerUp;
import fabricas.Sprite;
import visitors.Visitante;

public class BloqueDePregunta extends BloqueSolido {
	
	protected PowerUp powerUp;
	
	public BloqueDePregunta (Sprite sprite, Vector<Integer> pos,Visitante visitor,PowerUp powerUp) {
		super(sprite,pos,visitor);
		this.powerUp = powerUp;
		
	}
	
	public void setPowerUp (PowerUp powerUp) {
		this.powerUp = powerUp;
	}
	
	public PowerUp getPowerUp() {
		return powerUp;
	}
	
	public void aceptarVisitante (Visitante visitante) {
		visitante.visitarBloqueDePregunta(this);
	}

}
