package elementos.enemigos;

import java.util.Vector;

import elementos.personajes.ContextoMario;
import visitors.Visitante;

public class KoopaCaparazonEstatico implements EstadoKoopa {

	protected ContextoKoopaTroopa contexto;
	
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
		visitante.visitarKoopaCaparazonEstatico(this);
	}

	public ContextoKoopaTroopa getContext() {
		return this.contexto;
	}

}
