package elementos.enemigos;

import java.util.Vector;

import visitors.Visitante;

public class KoopaDefault implements KoopaState {
	
	// Atributos
	protected ContextoKoopaTroopa contexto;
	
	public KoopaDefault() {
	}

	// Metodos
	public void setContext(ContextoKoopaTroopa contexto) {
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
	public void aceptarVisitante(Visitante visitante) {
		// TODO Auto-generated method stub
	}

	public ContextoKoopaTroopa getContext() {
		return contexto;
	}

}
