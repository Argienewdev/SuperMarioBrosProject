package elementos.powerUp;

import java.util.Vector;

import fabricas.Sprite;
import visitors.Visitante;

public class Moneda extends PowerUp {
	
	protected int cantidad;
	
	public Moneda (Sprite sprite, Vector<Integer> posicion, int cantidad) {
		this.sprite = sprite;
		this.posicion = posicion;
		this.cantidad = cantidad;
	}
	
	public void setCantidadMonedas (int cantidad) {
		this.cantidad = cantidad;
	}
	
	public int getCantidadMonedas() {
		return cantidad;
	}
	
	public void decrementarCantidad() {
		cantidad--;
	}
	
	public void aceptarVisitante(Visitante visitante) {
		visitante.visitarMoneda(this);
	}
	

}
