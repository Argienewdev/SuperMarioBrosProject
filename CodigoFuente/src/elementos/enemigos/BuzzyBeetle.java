package elementos.enemigos;

import java.util.Vector;

import elementos.Sprite;
import observers.ObserverGrafico;
import visitors.Visitante;

public class BuzzyBeetle extends Enemigo {
	
	public BuzzyBeetle(Sprite sprite, Vector<Integer> posicion, Visitante visitor,
					   int velocidad, Vector<Integer> direccion, ObserverGrafico observerGrafico) {
		super(sprite, posicion, visitor, velocidad, direccion, observerGrafico);
		this.puntosOtorgadosPorEliminacion = 30;
		this.puntosSustraidosPorMuerteCausada = 15;
	}
	
	@Override
	public void aceptarVisitante (Visitante visitante) {
		visitante.visitarBuzzyBeetle(this);
	}

}
