package elementos.enemigos;

import java.awt.Point;
import visitors.Visitante;
import visitors.VisitorKoopaDefault;

public class KoopaDefault implements EstadoKoopa {
	
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
        visitante.visitar(this);
    }

	public ContextoKoopaTroopa getContext() {
		return this.contexto;
	}
	public Visitante getVisitor() {
		return new VisitorKoopaDefault(this);
	}

}
