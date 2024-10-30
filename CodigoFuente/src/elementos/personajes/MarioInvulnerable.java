package elementos.personajes;

import java.awt.Point;
import java.awt.Rectangle;

import elementos.Sprite;
import fabricas.FabricaSprites;
import ventanas.ConstantesGlobales;
import visitors.Visitante;
import visitors.VisitorMarioInvulnerable;

public class MarioInvulnerable  extends MarioDefault {

	protected int duracion;
	
	private EstadoMario estadoPrevio;
	
	public MarioInvulnerable (EstadoMario estadoPrevio) {
		this.estadoPrevio = estadoPrevio;
		this.duracion = 600;
	}
	
	@Override
    public void aceptarVisitante(Visitante visitante) {
        visitante.visitarMarioInvulnerable(this);
    }
	
	public void actualizarHitboxYPosicion(FabricaSprites fabricaSprites) {
		Rectangle nuevaHitbox = new Rectangle(this.obtenerContexto().obtenerPosicion().x, this.obtenerContexto().obtenerPosicion().y + (this.obtenerContexto().obtenerSprite().establecerAltoImagen() - obtenerSpriteInicial(fabricaSprites).establecerAltoImagen()), obtenerSpriteInicial(fabricaSprites).obtenerAnchoImagen(), obtenerSpriteInicial(fabricaSprites).establecerAltoImagen());
		Point nuevaPosicion = new Point(nuevaHitbox.getLocation());
		this.obtenerContexto().establecerPosicion(nuevaPosicion);
		this.obtenerContexto().setHitbox(nuevaHitbox);
	}
	
	@Override
	public Visitante obtenerVisitante() {
		 return new VisitorMarioInvulnerable(this);
	}
	
	public void actualizarSprite(FabricaSprites fabricaSprites) {
		//TODO esta llamada no va aca
		actualizarTiempo();
		Sprite aRetornar = null;
		try {
			if(contexto.obtenerPosicion().y > (ConstantesGlobales.NIVEL_PISO)){
				aRetornar = fabricaSprites.getMarioInvulnerableCayendo();
			}else if(spriteAereoFrontal(fabricaSprites)) {
				aRetornar = fabricaSprites.getMarioInvulnerableFrontalSaltando();
			} else if(spriteAereoReverso(fabricaSprites)) {
				aRetornar = fabricaSprites.getMarioInvulnerableReversoSaltando();
			}else if(avanzando()) {
				aRetornar = fabricaSprites.getMarioInvulnerableFrontalCaminando();
			} else if(retrocediendo()){
				aRetornar = fabricaSprites.getMarioInvulnerableReversoCaminando();
			} else if(spriteFrontal(fabricaSprites)){
				aRetornar = fabricaSprites.getMarioInvulnerableFrontalQuieto();
			} else if(spriteReverso(fabricaSprites)){
				aRetornar = fabricaSprites.getMarioInvulnerableReversoQuieto();
			} else {
				aRetornar = obtenerSpriteInicial(fabricaSprites);
			}
			contexto.establecerSprite(aRetornar);
		}catch(NullPointerException e) {
			e.printStackTrace();
		}
	}
	
	public Sprite obtenerSpriteInicial(FabricaSprites fabricaSprites) {
		return fabricaSprites.getMarioInvulnerableFrontalQuieto();
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
		return contexto.obtenerSprite().equals(fabricaSprites.getMarioInvulnerableFrontalCaminando()) ||
				contexto.obtenerSprite().equals(fabricaSprites.getMarioInvulnerableFrontalQuieto()) ||
				contexto.obtenerSprite().equals(fabricaSprites.getMarioInvulnerableFrontalSaltando());
	}
	
	private boolean spriteReverso(FabricaSprites fabricaSprites) {
		return contexto.obtenerSprite().equals(fabricaSprites.getMarioInvulnerableReversoCaminando()) ||
				contexto.obtenerSprite().equals(fabricaSprites.getMarioInvulnerableReversoQuieto()) ||
				contexto.obtenerSprite().equals(fabricaSprites.getMarioInvulnerableReversoSaltando());
	}
	
	public void actualizarTiempo () {
		duracion--;
		if (duracion <= 0)
			contexto.cambiarEstado(estadoPrevio);
	}
}
