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
			aRetornar = fabricaSprites.obtenerMarioRecuperacionCayendo();
		}else if(spriteAereoFrontal(fabricaSprites)) {
			aRetornar = fabricaSprites.obtenerMarioRecuperacionFrontalSaltando();
		} else if(spriteAereoReverso(fabricaSprites)) {
			aRetornar = fabricaSprites.obtenerMarioRecuperacionReversoSaltando();
		}else if(avanzando()) {
			aRetornar = fabricaSprites.obtenerMarioRecuperacionFrontalCaminando();
		} else if(retrocediendo()){
			aRetornar = fabricaSprites.obtenerMarioRecuperacionReversoCaminando();
		} else if(spriteFrontal(fabricaSprites)){
			aRetornar = fabricaSprites.obtenerMarioRecuperacionFrontalQuieto();
		} else if(spriteReverso(fabricaSprites)){
			aRetornar = fabricaSprites.obtenerMarioRecuperacionReversoQuieto();
		} else {
			aRetornar = obtenerSpriteInicial(fabricaSprites);
		}
		contexto.establecerSprite(aRetornar);
	}
	
	public Sprite obtenerSpriteInicial(FabricaSprites fabricaSprites) {
		return fabricaSprites.obtenerMarioRecuperacionFrontalQuieto();
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
		return contexto.obtenerSprite().equals(fabricaSprites.obtenerMarioRecuperacionFrontalCaminando()) ||
				contexto.obtenerSprite().equals(fabricaSprites.obtenerMarioRecuperacionFrontalQuieto()) ||
				contexto.obtenerSprite().equals(fabricaSprites.obtenerMarioRecuperacionFrontalSaltando());
	}
	
	private boolean spriteReverso(FabricaSprites fabricaSprites) {
		return contexto.obtenerSprite().equals(fabricaSprites.obtenerMarioRecuperacionReversoCaminando()) ||
				contexto.obtenerSprite().equals(fabricaSprites.obtenerMarioRecuperacionReversoQuieto()) ||
				contexto.obtenerSprite().equals(fabricaSprites.obtenerMarioRecuperacionReversoSaltando());
	}

}
