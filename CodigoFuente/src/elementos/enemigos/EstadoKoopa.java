package elementos.enemigos;

import java.awt.Point;

import fabricas.FabricaSprites;
import visitors.Visitante;

public interface EstadoKoopa {

	public void aceptarVisitante(Visitante visitante);
	
	public void actualizarSprite(FabricaSprites fabricaSprites);
	
	public Visitante getVisitor();

	public void setContext(ContextoKoopaTroopa contextoKoopaTroopa);

	public void actualizarHitboxYPosicion(FabricaSprites fabricaSprites);

	public void moverIzquierda();
	
	public void invertirDireccion();

	public void moverDerecha();
}
