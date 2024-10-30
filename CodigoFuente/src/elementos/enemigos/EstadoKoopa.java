package elementos.enemigos;

import fabricas.FabricaSprites;
import visitors.Visitante;

public interface EstadoKoopa {

	public void aceptarVisitante(Visitante visitante);
	
	public void actualizarSprite(FabricaSprites fabricaSprites);
	
	public Visitante obtenerVisitante();

	public void establecerContexto(ContextoKoopaTroopa contextoKoopaTroopa);

	public void actualizarHitboxYPosicion(FabricaSprites fabricaSprites);

	public void mover();
	
	public void invertirDireccion();
}
