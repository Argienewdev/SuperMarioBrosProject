package elementos.personajes;

public class MarioDefault implements EstadoMario {
	
	protected ContextoMario contexto;
	
	public void setContext(ContextoMario contexto) {
		this.contexto = contexto;
	}
	
	public ContextoMario getContext() {
		return this.contexto;
	}
	
}
