package elementos.enemigos;

import java.awt.Point;
import java.awt.Rectangle;
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
        visitante.visitarKoopaEnCaparazon(this);
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
		contexto.setSprite(fabricaSprites.getKoopaTroopaCaparazonEstático()); 
	}
	
	@Override
	public void actualizarHitboxYPosicion(FabricaSprites fabricaSprites) {
		try {
			int x = this.getContext().getPosicion().x;
			int y = this.getContext().getPosicion().y + (this.getContext().getSprite().getAltoImagen() - this.getContext().obtenerHitbox().height);
			int ancho = this.getContext().getSprite().getAnchoImagen();
			int alto = this.getContext().getSprite().getAltoImagen();
			Rectangle nuevaHitbox = new Rectangle(x, y, ancho, alto);
			Point nuevaPosicion = new Point(nuevaHitbox.getLocation());
			this.getContext().setPosicion(nuevaPosicion);
			this.getContext().setHitbox(nuevaHitbox);
		}catch (NullPointerException e) {
			e.printStackTrace();
		}
	}
}
