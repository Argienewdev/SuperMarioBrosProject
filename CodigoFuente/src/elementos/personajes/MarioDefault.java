package elementos.personajes;

import visitors.Visitante;
import visitors.VisitorMarioDefault;

public class MarioDefault implements EstadoMario {
	
	protected ContextoMario contexto;
	
	public void setContext(ContextoMario contexto) {
		this.contexto = contexto;
	}
	
	public ContextoMario getContext() {
		return this.contexto;
	}
	
	@Override
    public void aceptarVisitante(Visitante visitante) {
        visitante.visitar(this);
    }

	@Override
	public Visitante getVisitor() {
		return new VisitorMarioDefault(this);
	}
	
}