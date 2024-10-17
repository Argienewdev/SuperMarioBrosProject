package elementos.personajes;

import java.util.Vector;

import visitors.Visitante;

public class MarioInvulnerable  extends MarioDefault {
	
	public MarioInvulnerable(ContextoMario contexto) {
		super(contexto);
	}

	// Atributos
	protected static final int DURACION = 10;
	
	// Metodos
	@Override
	public void moverAIzquierda(Vector<Integer> direccion) {
		// TODO Auto-generated method stub
	}

	@Override
	public void moverADerecha(Vector<Integer> direccion) {
		// TODO Auto-generated method stub
	}

	@Override
	public void saltar(Visitante visitante) {
		// TODO Auto-generated method stub
	}
	
	@Override
	public void aceptarVisitante(Visitante visitante) {
		// TODO Auto-generated method stub
	}
	
}
