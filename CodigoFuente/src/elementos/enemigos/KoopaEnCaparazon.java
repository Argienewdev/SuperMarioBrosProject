package elementos.enemigos;

import java.awt.Point;
import java.awt.Rectangle;
import fabricas.FabricaSprites;
import visitors.Visitante;
import visitors.VisitorKoopaEnCaparazon;

public class KoopaEnCaparazon implements EstadoKoopa {

	protected ContextoKoopaTroopa contexto;
	
	protected static final int VELOCIDAD_NECESARIA_PARA_MATAR_ENEMIGO = 20;
	
	public void establecerContexto(ContextoKoopaTroopa contexto) {
		this.contexto = contexto;
	}
	
	@Override
	public void invertirDireccion() {}
	
	@Override
	public void mover() {
		Point velocidad = new Point(0, 0);
		this.contexto.establecerVelocidadDireccional(velocidad);
	}
	
	@Override
    public void aceptarVisitante(Visitante visitante) {
        visitante.visitarKoopaEnCaparazon(this);
    }

	public ContextoKoopaTroopa getContext() {
		return this.contexto;
	}

	@Override
	public Visitante obtenerVisitante() {
		return new VisitorKoopaEnCaparazon(this);
	}

	@Override
	public void actualizarSprite(FabricaSprites fabricaSprites) {
		if(this.getContext().obtenerRemovido()) {
			contexto.establecerSprite(fabricaSprites.obtenerSpriteInvisible());
			eliminarEntidadGrafica(fabricaSprites);
		}else {
			contexto.establecerSprite(fabricaSprites.obtenerKoopaTroopaCaparazonEstático()); 
		}
	}
	
	public void eliminarEntidadGrafica(FabricaSprites fabricaSprites) {
<<<<<<< HEAD
    	this.getContext().incrementarContadorTicks();
		if(this.getContext().getContadorTicks() == 1){
			this.getContext().establecerSprite(this.getContext().obtenerSpriteDeMuerte(fabricaSprites));
			this.actualizarHitboxYPosicion(fabricaSprites);
		} else if(this.getContext().getContadorTicks() == this.getContext().getTicksAnimacion()) {
			this.getContext().establecerSprite(fabricaSprites.getSpriteInvisible());
			this.getContext().eliminarDelNivel();
		}
=======
		this.getContext().establecerSprite(fabricaSprites.obtenerSpriteInvisible());
		this.getContext().eliminarDelNivel();
>>>>>>> f5445ae5b60ed4951b202a4e547b7803378805c8
	}
	
	@Override
	public void actualizarHitboxYPosicion(FabricaSprites fabricaSprites) {
		int x = this.getContext().obtenerPosicion().x;
		int y = this.getContext().obtenerPosicion().y + (this.getContext().obtenerAlto() - this.getContext().obtenerSprite().obtenerAltoImagen());
		int ancho = this.getContext().obtenerSprite().obtenerAnchoImagen();
		int alto = this.getContext().obtenerSprite().obtenerAltoImagen();
		Rectangle nuevaHitbox = new Rectangle(x, y, ancho, alto);
		Point nuevaPosicion = new Point(nuevaHitbox.getLocation());
		this.getContext().setHitbox(nuevaHitbox);
		this.getContext().establecerPosicion(nuevaPosicion);
	}
	
	public int obtenerVelocidadNecesariaParaMatarKoopa() {
		return VELOCIDAD_NECESARIA_PARA_MATAR_ENEMIGO;
	}
	
}
