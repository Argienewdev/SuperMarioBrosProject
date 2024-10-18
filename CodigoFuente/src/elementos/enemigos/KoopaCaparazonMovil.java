package elementos.enemigos;

import java.awt.Point;

import visitors.Visitante;

public class KoopaCaparazonMovil implements EstadoKoopa {

	protected ContextoKoopaTroopa contexto;

	public void setContext(ContextoKoopaTroopa contexto) {
		this.contexto = contexto;
	}
	
	@Override
	public void moverAIzquierda(Point direccion) {
		// TODO Auto-generated method stub
	}

	@Override
	public void moverADerecha(Point direccion) {
		// TODO Auto-generated method stub
	}

	@Override
	public void aceptarVisitante(Visitante visitante) {
		visitante.visitarKoopaCaparazonMovil(this);
	}

	public ContextoKoopaTroopa getContext() {
		return this.contexto;
	}

}
