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
	public Visitante obtenerVisitante() {
		 return new VisitorMarioRecuperacion(this);
	}
	
	public void actualizarHitboxYPosicion(FabricaSprites fabricaSprites) {
		Rectangle nuevaHitbox = new Rectangle(this.obtenerContexto().obtenerPosicion().x, this.obtenerContexto().obtenerPosicion().y + (this.obtenerContexto().obtenerSprite().obtenerAltoImagen() - obtenerSpriteInicial(fabricaSprites).obtenerAltoImagen()), obtenerSpriteInicial(fabricaSprites).obtenerAnchoImagen(), obtenerSpriteInicial(fabricaSprites).obtenerAltoImagen());
		Point nuevaPosicion = new Point(nuevaHitbox.getLocation());
		this.obtenerContexto().establecerPosicion(nuevaPosicion);
		this.obtenerContexto().setHitbox(nuevaHitbox);
	}
	
	public void actualizarSprite(FabricaSprites fabricaSprites) {
		actualizarTiempo();
		Sprite aRetornar = null;
		if(contexto.obtenerPosicion().y > (ConstantesGlobales.NIVEL_PISO)){
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
		contexto.establecerSprite(aRetornar);
	}
	
	public Sprite obtenerSpriteInicial(FabricaSprites fabricaSprites) {
		return fabricaSprites.getMarioRecuperacionFrontalQuieto();
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
		return contexto.obtenerSprite().equals(fabricaSprites.getMarioRecuperacionFrontalCaminando()) ||
				contexto.obtenerSprite().equals(fabricaSprites.getMarioRecuperacionFrontalQuieto()) ||
				contexto.obtenerSprite().equals(fabricaSprites.getMarioRecuperacionFrontalSaltando());
	}
	
	private boolean spriteReverso(FabricaSprites fabricaSprites) {
		return contexto.obtenerSprite().equals(fabricaSprites.getMarioRecuperacionReversoCaminando()) ||
				contexto.obtenerSprite().equals(fabricaSprites.getMarioRecuperacionReversoQuieto()) ||
				contexto.obtenerSprite().equals(fabricaSprites.getMarioRecuperacionReversoSaltando());
	}

}
