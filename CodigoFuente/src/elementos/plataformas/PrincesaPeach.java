package elementos.plataformas;

import java.awt.Point;
import elementos.Sprite;
import observers.ObserverGrafico;
import visitors.Visitante;

public class PrincesaPeach extends Meta {

	protected boolean activada;

	@SuppressWarnings("exports")
	public PrincesaPeach(Sprite sprite, Point posicion, Visitante visitor, ObserverGrafico observerGrafico) {
		super(sprite, posicion, visitor, observerGrafico);
		this.activada = false;
	}

	public void aceptarVisitante(Visitante visitante) {
		visitante.visitarPrincesaPeach(this);
	}
	
	public boolean obtenerFueActivada() {
		return this.activada;
	}
	
	public void establecerActivada(boolean activada) {
		this.activada = activada;
	}

}
