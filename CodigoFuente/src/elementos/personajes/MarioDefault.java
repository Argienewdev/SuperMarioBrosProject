package elementos.personajes;

import java.util.Vector;

import visitors.Visitante;

public class MarioDefault implements MarioState {
	
	protected ContextoMario contexto;
	
	public MarioDefault(ContextoMario contexto) {
		this.contexto = contexto;
	}
	
	public void setContext(ContextoMario contexto) {
		this.contexto = contexto;
	} 

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
