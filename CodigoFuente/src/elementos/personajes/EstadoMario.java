package elementos.personajes;

import fabricas.FabricaSprites;
import visitors.Visitante;

public interface EstadoMario{
	
	public ContextoMario getContext();
	
	public void actualizarSprite(FabricaSprites fabricaSprites);

	public void aceptarVisitante(Visitante visitante);

	public void setContext(ContextoMario contextoMario);
	
	public Visitante getVisitor();
	
	public void actualizarHitboxYPosicion(FabricaSprites fabricaSprites);
	
	public void realizarAccionEspecial();
	
	public void actualizarTiempo(int tiempoDelta);
		
}
