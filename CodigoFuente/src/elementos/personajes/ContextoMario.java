package elementos.personajes;

import java.util.Vector;

import elementos.Sprite;
import elementos.entidades.Jugable;
import visitors.Visitante;

public class ContextoMario extends Jugable {

	private EstadoMario estadoMario;
	
	public ContextoMario(Sprite sprite, Vector<Integer> posicion,
						 Visitante visitor, int vidas, MarioDefault estadoMario) {
		super(sprite, posicion, visitor);
		this.estadoMario = estadoMario;
	}
	
	public void cambiarEstado(EstadoMario estadoMario) {
		this.estadoMario = estadoMario;
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
