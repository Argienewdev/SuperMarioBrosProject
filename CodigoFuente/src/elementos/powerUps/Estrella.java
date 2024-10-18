package elementos.powerUps;

import java.awt.Point;
import java.util.Vector;

import elementos.Sprite;
import observers.ObserverGrafico;
import visitors.Visitante;

public class Estrella extends PowerUp {
	
	public static final int TIEMPO_DURACION = 10;
	
	public Estrella(Sprite sprite,Point posicion, Visitante visitor,
					Point velocidadDireccional, ObserverGrafico observerGrafico) {
		super(sprite, posicion, visitor, velocidadDireccional, observerGrafico);
	}
	
	@Override
	public void aceptarVisitante (Visitante visitante) {
		visitante.visitarEstrella(this);
	}
	
	public int obtenerPuntosPorDefault() {
		return 20;
	}
	
	public int obtenerPuntosPorSuper() {
		return 30;
	}
	
	public int obtenerPuntosPorInvencible() {
		return 35;
	}
	
	public int obtenerPuntosPorFuego() {
		return obtenerPuntosPorSuper();
	}

}
