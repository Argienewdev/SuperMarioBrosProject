package elementos.personajes;

import java.util.Vector;

import elementos.Sprite;
import elementos.entidades.Jugable;
import observers.ObserverGrafico;
import visitors.Visitante;

public class ContextoMario extends Jugable {

	private MarioState estado;
	
	public ContextoMario(Sprite sprite, Vector<Integer> posicion, Visitante visitor, 
						 int velocidad, Vector<Integer> direccion, 
						 ObserverGrafico observerGrafico, int vidas, MarioState estado) {
		super(sprite, posicion, visitor, velocidad, direccion, observerGrafico, vidas);
		this.estado = estado;
	}
	
	public MarioState getEstado() {
		return this.estado;
	}
	
	public void cambiarEstado(MarioState estado) {
		this.estado = estado;
	}
	
	@Override
	public void saltar(Vector<Integer> direccion) {
		// TODO Auto-generated method stub
	}

	@Override
	public void aceptarVisitante(Visitante visitante) {
		visitante.visitarContextoMario(this);
	}

}
