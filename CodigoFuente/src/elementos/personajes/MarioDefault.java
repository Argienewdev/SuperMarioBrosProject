package elementos.personajes;

import java.awt.Point;
import java.awt.Rectangle;

import elementos.Sprite;
import fabricas.FabricaSprites;
import ventanas.DimensionesConstantes;
import visitors.Visitante;
import visitors.VisitorMarioDefault;

public class MarioDefault implements EstadoMario {
	
	protected ContextoMario contexto;
	
	public void setContext(ContextoMario contexto) {
		this.contexto = contexto;
	}
	
	public ContextoMario getContext() {
		return this.contexto;
	}
	
	public void actualizarHitboxYPosicion(FabricaSprites fabricaSprites) {
		Rectangle nuevaHitbox = new Rectangle(this.getContext().getPosicion().x, this.getContext().getPosicion().y + (this.getContext().getSprite().getAltoImagen() - obtenerSpriteInicial(fabricaSprites).getAltoImagen()), obtenerSpriteInicial(fabricaSprites).getAnchoImagen(), obtenerSpriteInicial(fabricaSprites).getAltoImagen());
		Point nuevaPosicion = new Point(nuevaHitbox.getLocation());
		this.getContext().setPosicion(nuevaPosicion);
		this.getContext().setHitbox(nuevaHitbox);
	}
	
	@Override
    public void aceptarVisitante(Visitante visitante) {
        visitante.visitar(this);
    }

	@Override
	public Visitante getVisitor() {
		return new VisitorMarioDefault(this);
	}
	
	public void actualizarSprite(FabricaSprites fabricaSprites) {
		Sprite aRetornar = null;
		if(contexto.getPosicion().y > (DimensionesConstantes.NIVEL_PISO)){
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
		contexto.setSprite(aRetornar);
	}
	
	public Sprite obtenerSpriteInicial(FabricaSprites fabricaSprites) {
		return fabricaSprites.getMarioDefaultFrontalQuieto();
	}
	
	private boolean enElAire() {
		return contexto.getEnElAire();
	}
	
	private boolean avanzando() {
		return contexto.getAvanzando();
	}
	
	private boolean retrocediendo() {
		return contexto.getRetrocediendo();
	}
	
	private boolean spriteAereoFrontal(FabricaSprites fabricaSprites) {
		return enElAire() && (avanzando() || (spriteFrontal(fabricaSprites) && !retrocediendo()));
	}
	
	private boolean spriteAereoReverso(FabricaSprites fabricaSprites) {
		return enElAire() && (retrocediendo() || (spriteReverso(fabricaSprites) && !avanzando()));
	}
	
	private boolean spriteFrontal(FabricaSprites fabricaSprites) {
		return contexto.getSprite().equals(fabricaSprites.getMarioDefaultFrontalCaminando()) ||
				contexto.getSprite().equals(fabricaSprites.getMarioDefaultFrontalQuieto()) ||
				contexto.getSprite().equals(fabricaSprites.getMarioDefaultFrontalSaltando());
	}
	
	private boolean spriteReverso(FabricaSprites fabricaSprites) {
		return contexto.getSprite().equals(fabricaSprites.getMarioDefaultReversoCaminando()) ||
				contexto.getSprite().equals(fabricaSprites.getMarioDefaultReversoQuieto()) ||
				contexto.getSprite().equals(fabricaSprites.getMarioDefaultReversoSaltando());
	}
	
}