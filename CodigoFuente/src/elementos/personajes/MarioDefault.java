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
		int nuevaPosicionY = this.obtenerContexto().obtenerPosicion().y + (this.obtenerContexto().obtenerHitbox().height - obtenerSpriteInicial(fabricaSprites).obtenerAltoImagen());
		Rectangle nuevaHitbox = new Rectangle(nuevaPosicionX, nuevaPosicionY, obtenerSpriteInicial(fabricaSprites).obtenerAnchoImagen(), obtenerSpriteInicial(fabricaSprites).obtenerAltoImagen());
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
			aRetornar = fabricaSprites.obtenerMarioDefaultCayendo();
		}else if(spriteAereoFrontal(fabricaSprites)) {
			aRetornar = fabricaSprites.obtenerMarioDefaultFrontalSaltando();
		} else if(spriteAereoReverso(fabricaSprites)) {
			aRetornar = fabricaSprites.obtenerMarioDefaultReversoSaltando();
		}else if(avanzando()) {
			aRetornar = fabricaSprites.obtenerMarioDefaultFrontalCaminando();
		} else if(retrocediendo()){
			aRetornar = fabricaSprites.obtenerMarioDefaultReversoCaminando();
		} else if(spriteFrontal(fabricaSprites)){
			aRetornar = fabricaSprites.obtenerMarioDefaultFrontalQuieto();
		} else if(spriteReverso(fabricaSprites)){
			aRetornar = fabricaSprites.obtenerMarioDefaultReversoQuieto();
		} else {
			aRetornar = obtenerSpriteInicial(fabricaSprites);
		}
		contexto.establecerSprite(aRetornar);
	}
	
	public Sprite obtenerSpriteInicial(FabricaSprites fabricaSprites) {
		return fabricaSprites.obtenerMarioDefaultFrontalQuieto();
	}
	
	private boolean enElAire() {
		return !contexto.obtenerColisionAbajo();
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
		return contexto.obtenerSprite().equals(fabricaSprites.obtenerMarioDefaultFrontalCaminando()) ||
				contexto.obtenerSprite().equals(fabricaSprites.obtenerMarioDefaultFrontalQuieto()) ||
				contexto.obtenerSprite().equals(fabricaSprites.obtenerMarioDefaultFrontalSaltando());
	}
	
	private boolean spriteReverso(FabricaSprites fabricaSprites) {
		return contexto.obtenerSprite().equals(fabricaSprites.obtenerMarioDefaultReversoCaminando()) ||
				contexto.obtenerSprite().equals(fabricaSprites.obtenerMarioDefaultReversoQuieto()) ||
				contexto.obtenerSprite().equals(fabricaSprites.obtenerMarioDefaultReversoSaltando());
	}

	public void realizarAccionEspecial() {		
	}
	
	public void actualizarTiempo() {
	}
	
}