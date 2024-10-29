package elementos.personajes;

import java.awt.Point;
import java.awt.Rectangle;

import elementos.Sprite;
import fabricas.FabricaSprites;
import ventanas.ConstantesGlobales;
import visitors.Visitante;
import visitors.VisitorMarioRecuperacion;

public class MarioRecuperacion extends MarioDefault {
	
	private int tiempoEnRecuperacion;
	
	public MarioRecuperacion () {
		this.tiempoEnRecuperacion = 180;
	}
	
	public void actualizarTiempo() {
		tiempoEnRecuperacion--;
		if (tiempoEnRecuperacion <= 0)
			contexto.reiniciarEstado();
	}
	
	 public void aceptarVisitante(Visitante visitante) {
	        visitante.visitarMarioRecuperacion(this);
    }
	
	@Override
	public Visitante getVisitor() {
		 return new VisitorMarioRecuperacion(this);
	}
	
	public void actualizarHitboxYPosicion(FabricaSprites fabricaSprites) {
		Rectangle nuevaHitbox = new Rectangle(this.getContext().getPosicion().x, this.getContext().getPosicion().y + (this.getContext().getSprite().getAltoImagen() - obtenerSpriteInicial(fabricaSprites).getAltoImagen()), obtenerSpriteInicial(fabricaSprites).getAnchoImagen(), obtenerSpriteInicial(fabricaSprites).getAltoImagen());
		Point nuevaPosicion = new Point(nuevaHitbox.getLocation());
		this.getContext().setPosicion(nuevaPosicion);
		this.getContext().setHitbox(nuevaHitbox);
	}
	
	public void actualizarSprite(FabricaSprites fabricaSprites) {
		actualizarTiempo();
		Sprite aRetornar = null;
		if(contexto.getPosicion().y > (ConstantesGlobales.NIVEL_PISO)){
			aRetornar = fabricaSprites.getMarioRecuperacionCayendo();
		}else if(spriteAereoFrontal(fabricaSprites)) {
			aRetornar = fabricaSprites.getMarioRecuperacionFrontalSaltando();
		} else if(spriteAereoReverso(fabricaSprites)) {
			aRetornar = fabricaSprites.getMarioRecuperacionReversoSaltando();
		}else if(avanzando()) {
			aRetornar = fabricaSprites.getMarioRecuperacionFrontalCaminando();
		} else if(retrocediendo()){
			aRetornar = fabricaSprites.getMarioRecuperacionReversoCaminando();
		} else if(spriteFrontal(fabricaSprites)){
			aRetornar = fabricaSprites.getMarioRecuperacionFrontalQuieto();
		} else if(spriteReverso(fabricaSprites)){
			aRetornar = fabricaSprites.getMarioRecuperacionReversoQuieto();
		} else {
			aRetornar = obtenerSpriteInicial(fabricaSprites);
		}
		contexto.setSprite(aRetornar);
	}
	
	public Sprite obtenerSpriteInicial(FabricaSprites fabricaSprites) {
		return fabricaSprites.getMarioRecuperacionFrontalQuieto();
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
		return contexto.getSprite().equals(fabricaSprites.getMarioRecuperacionFrontalCaminando()) ||
				contexto.getSprite().equals(fabricaSprites.getMarioRecuperacionFrontalQuieto()) ||
				contexto.getSprite().equals(fabricaSprites.getMarioRecuperacionFrontalSaltando());
	}
	
	private boolean spriteReverso(FabricaSprites fabricaSprites) {
		return contexto.getSprite().equals(fabricaSprites.getMarioRecuperacionReversoCaminando()) ||
				contexto.getSprite().equals(fabricaSprites.getMarioRecuperacionReversoQuieto()) ||
				contexto.getSprite().equals(fabricaSprites.getMarioRecuperacionReversoSaltando());
	}

}
