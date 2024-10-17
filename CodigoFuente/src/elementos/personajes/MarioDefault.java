package elementos.personajes;

import java.util.Vector;

import visitors.Visitante;

public class MarioDefault implements MarioState {
	
	protected ContextoMario contexto;
	protected int monedas;
	
	public MarioDefault() {
		this.contexto = null;
		monedas = 0;
	}
	
	public void setContext(ContextoMario contexto) {
		this.contexto = contexto;
	} 
	
	public ContextoMario getContext() {
		return contexto;
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
	
	public void aceptarVisitante(Visitante visitante) {
		visitante.visitarMarioDefault(this);
	}
	
	public void incrementarMonedas (int cantidad) {
		if ((monedas + cantidad) >= 100) {
			contexto.ganarVida();
			monedas += cantidad - 100;
		}
		else 
			monedas += cantidad;
	}


	
}
