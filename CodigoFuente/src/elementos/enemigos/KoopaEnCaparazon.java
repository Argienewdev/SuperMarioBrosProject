package elementos.enemigos;

import java.awt.Point;
import java.util.Vector;

import elementos.personajes.ContextoMario;
import fabricas.FabricaSprites;
import visitors.Visitante;
import visitors.VisitorKoopaEnCaparazon;

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
        visitante.visitar(this);
    }

	public ContextoKoopaTroopa getContext() {
		return this.contexto;
	}

	@Override
	public Visitante getVisitor() {
		return new VisitorKoopaEnCaparazon(this);
	}

	@Override
	public void actualizarSprite(FabricaSprites fabricaSprites) {
		//TODO
	}
	
}
