package elementos.powerUps;

import java.awt.Point;
import elementos.Sprite;
import fabricas.FabricaSprites;
import observers.ObserverGrafico;
import visitors.Visitante;

public class Monedas extends PowerUp {

	protected int cantidadMonedas;
	
	public Monedas(Sprite sprite, Point posicion, Visitante visitor,
			   	   ObserverGrafico observerGrafico, int cantidadMonedas, boolean dentroDeBloqueDePreguntas) {
		super(sprite, posicion, visitor, observerGrafico);
		this.cantidadMonedas = cantidadMonedas;
		//TODO se deberian setear con los establecer al crear el elemento?
		this.esMovible = false;
		this.estaDentroDeBloqueDePreguntas = dentroDeBloqueDePreguntas;
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
	
	public int obtenerPuntosPorInvulnerable() {
		return obtenerPuntosPorDefault();
	}
	
	public int obtenerPuntosPorFuego() {
		return obtenerPuntosPorDefault();
	}

	@Override
	public void actualizarSprite(FabricaSprites fabricaSprites) {
		if(this.getRemovido()) {
			this.eliminarEntidadGrafica(fabricaSprites);
		}
	}
}
