package elementos.personajes;

import java.awt.Point;
import java.awt.Rectangle;

import elementos.Sprite;
import fabricas.FabricaSprites;
import ventanas.ConstantesGlobales;
import visitors.Visitante;
import visitors.VisitorMarioDefault;

public class MarioDefault implements EstadoMario {
	
	protected ContextoMario contexto;
	
	public void establecerContexto(ContextoMario contexto) {
		this.contexto = contexto;
	}
	
	public ContextoMario obtenerContexto() {
		return this.contexto;
	}
	
	public void actualizarHitboxYPosicion(FabricaSprites fabricaSprites) {
		int nuevaPosicionX = this.obtenerContexto().obtenerPosicion().x;
		int nuevaPosicionY = this.obtenerContexto().obtenerPosicion().y + (this.obtenerContexto().obtenerHitbox().height - obtenerSpriteInicial(fabricaSprites).getAltoImagen());
		Rectangle nuevaHitbox = new Rectangle(nuevaPosicionX, nuevaPosicionY, obtenerSpriteInicial(fabricaSprites).getAnchoImagen(), obtenerSpriteInicial(fabricaSprites).getAltoImagen());
		Point nuevaPosicion = new Point(nuevaHitbox.getLocation());
		this.obtenerContexto().establecerPosicion(nuevaPosicion);
		this.obtenerContexto().setHitbox(nuevaHitbox);
	}
	
	@Override
    public void aceptarVisitante(Visitante visitante) {
        visitante.visitarMarioDefault(this);
    }

	@Override
	public Visitante obtenerVisitante() {
		return new VisitorMarioDefault(this);
	}
	
	public void actualizarSprite(FabricaSprites fabricaSprites) {
		Sprite aRetornar = null;
		if(contexto.obtenerPosicion().y > (ConstantesGlobales.NIVEL_PISO)){
			aRetornar = fabricaSprites.getMarioDefaultCayendo();
		}else if(spriteAereoFrontal(fabricaSprites)) {
			aRetornar = fabricaSprites.getMarioDefaultFrontalSaltando();
		} else if(spriteAereoReverso(fabricaSprites)) {
			aRetornar = fabricaSprites.getMarioDefaultReversoSaltando();
		}else if(avanzando()) {
			aRetornar = fabricaSprites.getMarioDefaultFrontalCaminando();
		} else if(retrocediendo()){
			aRetornar = fabricaSprites.getMarioDefaultReversoCaminando();
		} else if(spriteFrontal(fabricaSprites)){
			aRetornar = fabricaSprites.getMarioDefaultFrontalQuieto();
		} else if(spriteReverso(fabricaSprites)){
			aRetornar = fabricaSprites.getMarioDefaultReversoQuieto();
		} else {
			aRetornar = obtenerSpriteInicial(fabricaSprites);
		}
		contexto.establecerSprite(aRetornar);
	}
	
	public Sprite obtenerSpriteInicial(FabricaSprites fabricaSprites) {
		return fabricaSprites.getMarioDefaultFrontalQuieto();
	}
	
	private boolean enElAire() {
		return contexto.obtenerEnElAire();
	}
	
	private boolean avanzando() {
		return contexto.obtenerAvanzando();
	}
	
	private boolean retrocediendo() {
		return contexto.obtenerRetrocediendo();
	}
	
	private boolean spriteAereoFrontal(FabricaSprites fabricaSprites) {
		return enElAire() && (avanzando() || (spriteFrontal(fabricaSprites) && !retrocediendo()));
	}
	
	private boolean spriteAereoReverso(FabricaSprites fabricaSprites) {
		return enElAire() && (retrocediendo() || (spriteReverso(fabricaSprites) && !avanzando()));
	}
	
	private boolean spriteFrontal(FabricaSprites fabricaSprites) {
		return contexto.obtenerSprite().equals(fabricaSprites.getMarioDefaultFrontalCaminando()) ||
				contexto.obtenerSprite().equals(fabricaSprites.getMarioDefaultFrontalQuieto()) ||
				contexto.obtenerSprite().equals(fabricaSprites.getMarioDefaultFrontalSaltando());
	}
	
	private boolean spriteReverso(FabricaSprites fabricaSprites) {
		return contexto.obtenerSprite().equals(fabricaSprites.getMarioDefaultReversoCaminando()) ||
				contexto.obtenerSprite().equals(fabricaSprites.getMarioDefaultReversoQuieto()) ||
				contexto.obtenerSprite().equals(fabricaSprites.getMarioDefaultReversoSaltando());
	}

	public void realizarAccionEspecial() {		
	}
	
	public void actualizarTiempo() {
	}
	
}