package elementos.plataforma;

import java.util.Vector;

import elementos.powerUp.Moneda;
import fabricas.Sprite;
import visitors.Visitante;

public class Ladrillo extends BloqueSolido {
	
	protected Moneda monedas;
	
	public Ladrillo (Sprite sprite, Vector<Integer> pos, Moneda monedas) {
		super(sprite,pos);
		this.monedas = monedas;
	}
	
	public void setMoneda (Moneda monedas) {
		this.monedas = monedas;
	}
	
	public Moneda getMoneda() {
		return monedas;
	}
	
	public void aceptarVisitante (Visitante visitante) {
		visitante.visitarLadrillo(this);
	}
	
	

}
