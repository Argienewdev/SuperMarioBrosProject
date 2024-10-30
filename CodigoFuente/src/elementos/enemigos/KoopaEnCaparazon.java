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

	public ContextoKoopaTroopa obtenerContext() {
		return this.contexto;
	}

	@Override
	public Visitante obtenerVisitante() {
		return new VisitorKoopaEnCaparazon(this);
	}

	@Override
	public void actualizarSprite(FabricaSprites fabricaSprites) {
		if(this.obtenerContext().obtenerRemovido()) {
			contexto.establecerSprite(fabricaSprites.obtenerSpriteInvisible());
			eliminarEntidadGrafica(fabricaSprites);
		}else {
			contexto.establecerSprite(fabricaSprites.obtenerKoopaTroopaCaparazonEstático()); 
		}
	}
	
	public void eliminarEntidadGrafica(FabricaSprites fabricaSprites) {
    	this.obtenerContext().incrementarContadorTicks();
		if(this.obtenerContext().obtenerContadorTicks() == 1){
			this.obtenerContext().establecerSprite(this.obtenerContext().obtenerSpriteDeMuerte(fabricaSprites));
			this.actualizarHitboxYPosicion(fabricaSprites);
		} else if(this.obtenerContext().obtenerContadorTicks() == this.obtenerContext().obtenerTicksAnimacion()) {
			this.obtenerContext().establecerSprite(fabricaSprites.obtenerSpriteInvisible());
			this.obtenerContext().eliminarDelNivel();
		}
	}
	
	@Override
	public void actualizarHitboxYPosicion(FabricaSprites fabricaSprites) {
		int x = this.obtenerContext().obtenerPosicion().x;
		int y = this.obtenerContext().obtenerPosicion().y + (this.obtenerContext().obtenerAlto() - this.obtenerContext().obtenerSprite().obtenerAltoImagen());
		int ancho = this.obtenerContext().obtenerSprite().obtenerAnchoImagen();
		int alto = this.obtenerContext().obtenerSprite().obtenerAltoImagen();
		Rectangle nuevaHitbox = new Rectangle(x, y, ancho, alto);
		Point nuevaPosicion = new Point(nuevaHitbox.getLocation());
		this.obtenerContext().setHitbox(nuevaHitbox);
		this.obtenerContext().establecerPosicion(nuevaPosicion);
	}
	
	public int obtenerVelocidadNecesariaParaMatarKoopa() {
		return VELOCIDAD_NECESARIA_PARA_MATAR_ENEMIGO;
	}
	
}
