package elementos.personajes;

public class MarioDefault implements EstadoMario{
	
	protected ContextoMario contexto;
	
	public MarioDefault() {
	}
	
	public void setContext(ContextoMario contexto) {
		this.contexto=contexto;
	}
}
