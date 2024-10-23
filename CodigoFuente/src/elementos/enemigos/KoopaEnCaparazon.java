package elementos.enemigos;

import java.awt.Point;
import java.util.Vector;

import elementos.personajes.ContextoMario;
import visitors.Visitante;

public class KoopaEnCaparazon implements EstadoKoopa {

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
	}

	public ContextoKoopaTroopa getContext() {
		return this.contexto;
	}

}
