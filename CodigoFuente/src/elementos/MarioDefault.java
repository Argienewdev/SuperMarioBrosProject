package elementos;

public class MarioDefault implements EstadoMario{
	
	protected ContextoMario contexto;
	
	public MarioDefault() {
	}
	
	public void setContext(ContextoMario contexto) {
		this.contexto=contexto;
	}
}
