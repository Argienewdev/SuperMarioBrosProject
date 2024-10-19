package elementos.powerUps;

import java.awt.Point;
import elementos.Sprite;
import observers.ObserverGrafico;
import visitors.Visitante;

public class Monedas extends PowerUp {

	protected int cantidadMonedas;
	
	public Monedas(Sprite sprite, Point posicion, Visitante visitor, 
			   	   ObserverGrafico observerGrafico, int cantidadMonedas) {
		super(sprite, posicion, visitor, new Point (0,0), observerGrafico);
		this.cantidadMonedas = cantidadMonedas;
	}
	
	public void consumirMonedas() {
		this.cantidadMonedas--;
	}
	
	public void aumentarMonedas() {
		this.cantidadMonedas++;
	}
	
	public int getCantidadMonedas() {
		return this.cantidadMonedas;
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
	
	public int obtenerPuntosPorInvencible() {
		return obtenerPuntosPorDefault();
	}
	
	public int obtenerPuntosPorFuego() {
		return obtenerPuntosPorDefault();
	}
}
