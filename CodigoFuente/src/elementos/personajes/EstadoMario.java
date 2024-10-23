package elementos.personajes;

import visitors.Visitante;

public interface EstadoMario{
	
	public ContextoMario getContext();

	public void aceptarVisitante(Visitante visitante);

	public void setContext(ContextoMario contextoMario);
	
	public Visitante getVisitor();
}
