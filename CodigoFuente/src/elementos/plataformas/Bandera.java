package elementos.plataformas;

import java.awt.Point;
import elementos.Sprite;
import observers.ObserverGrafico;
import visitors.Visitante;

public class Bandera extends Meta {
	
	protected boolean activada;

	public Bandera(Sprite sprite, Point posicion, Visitante visitor, ObserverGrafico observerGrafico) {
		super(sprite, posicion, visitor, observerGrafico);
		this.activada = false;
	}

	@Override
	public void aceptarVisitante(Visitante visitante) {
		visitante.visitarBandera(this);
	}
	
	public boolean obtenerFueActivada() {
		return this.activada;
	}
	
	public void establecerActivada(boolean activada) {
		this.activada = activada;
	}

}
