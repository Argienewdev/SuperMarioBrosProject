package elementos.enemigos;

import java.awt.Point;
import java.awt.Rectangle;
import fabricas.FabricaSprites;
import visitors.Visitante;
import visitors.VisitorKoopaEnCaparazon;

public class KoopaEnCaparazon implements EstadoKoopa {

	protected ContextoKoopaTroopa contexto;
	
	protected static final int VELOCIDAD_NECESARIA_PARA_MATAR_ENEMIGO = 20;
	
	public void setContext(ContextoKoopaTroopa contexto) {
		this.contexto = contexto;
	}
	
	@Override
	public void invertirDireccion() {}
	
	@Override
	public void mover() {
		Point velocidad = new Point(0, 0);
		this.contexto.setVelocidadDireccional(velocidad);
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
		if(this.getContext().getRemovido()) {
			contexto.setSprite(fabricaSprites.getSpriteInvisible());
			eliminarEntidadGrafica(fabricaSprites);
		}else {
			contexto.setSprite(fabricaSprites.getKoopaTroopaCaparazonEstático()); 
		}
	}
	
	public void eliminarEntidadGrafica(FabricaSprites fabricaSprites) {
		this.getContext().setSprite(fabricaSprites.getSpriteInvisible());
		this.getContext().eliminarDelNivel();
	}
	
	@Override
	public void actualizarHitboxYPosicion(FabricaSprites fabricaSprites) {
		int x = this.getContext().getPosicion().x;
		int y = this.getContext().getPosicion().y + (this.getContext().obtenerAlto() - this.getContext().getSprite().getAltoImagen());
		int ancho = this.getContext().getSprite().getAnchoImagen();
		int alto = this.getContext().getSprite().getAltoImagen();
		Rectangle nuevaHitbox = new Rectangle(x, y, ancho, alto);
		Point nuevaPosicion = new Point(nuevaHitbox.getLocation());
		this.getContext().setHitbox(nuevaHitbox);
		this.getContext().setPosicion(nuevaPosicion);
	}
	
	public int obtenerVelocidadNecesariaParaMatarKoopa() {
		return VELOCIDAD_NECESARIA_PARA_MATAR_ENEMIGO;
	}
	
}
