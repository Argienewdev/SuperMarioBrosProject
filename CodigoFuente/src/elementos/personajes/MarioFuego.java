package elementos.personajes;

import java.awt.Point;
import java.awt.Rectangle;

import elementos.Sprite;
import elementos.entidades.BolaDeFuego;
import fabricas.FabricaEntidades;
import fabricas.FabricaSprites;
import ventanas.ConstantesGlobales;
import visitors.Visitante;
import visitors.VisitorMarioFuego;

public class MarioFuego extends MarioDefault {
	
	protected FabricaEntidades fabricaEntidades;
	
	protected boolean frente;
	
	public MarioFuego(FabricaEntidades fabricaEntidades) {
		this.fabricaEntidades = fabricaEntidades;
		frente = true;
	}
	
	@Override
    public void aceptarVisitante(Visitante visitante) {
        visitante.visitarMarioFuego(this);
    }
	
	@Override
	public Visitante obtenerVisitante() {
		return new VisitorMarioFuego(this);
	}
	
	public void actualizarHitboxYPosicion(FabricaSprites fabricaSprites) {
		Rectangle nuevaHitbox = new Rectangle(this.obtenerContexto().obtenerPosicion().x, this.obtenerContexto().obtenerPosicion().y + (this.obtenerContexto().obtenerSprite().obtenerAltoImagen() - obtenerSpriteInicial(fabricaSprites).obtenerAltoImagen()), obtenerSpriteInicial(fabricaSprites).obtenerAnchoImagen(), obtenerSpriteInicial(fabricaSprites).obtenerAltoImagen());
		Point nuevaPosicion = new Point(nuevaHitbox.getLocation());
		this.obtenerContexto().establecerPosicion(nuevaPosicion);
		this.obtenerContexto().setHitbox(nuevaHitbox);
	}
	
	public void actualizarSprite(FabricaSprites fabricaSprites) {
		Sprite aRetornar = null;
		if(contexto.obtenerPosicion().y > (ConstantesGlobales.NIVEL_PISO)){
			aRetornar = fabricaSprites.obtenerMarioFuegoCayendo();
		}else if(spriteAereoFrontal(fabricaSprites)) {
			frente = true;
			aRetornar = fabricaSprites.obtenerMarioFuegoFrontalSaltando();
		} else if(spriteAereoReverso(fabricaSprites)) {
			frente = false;
			aRetornar = fabricaSprites.obtenerMarioFuegoReversoSaltando();
		}else if(avanzando()) {
			frente = true;
			aRetornar = fabricaSprites.obtenerMarioFuegoFrontalCaminando();
		} else if(retrocediendo()){
			frente = false;
			aRetornar = fabricaSprites.obtenerMarioFuegoReversoCaminando();
		} else if(spriteFrontal(fabricaSprites)){
			frente = true;
			aRetornar = fabricaSprites.obtenerMarioFuegoFrontalQuieto();
		} else if(spriteReverso(fabricaSprites)){
			frente = false;
			aRetornar = fabricaSprites.obtenerMarioFuegoReversoQuieto();
		} else {
			aRetornar = obtenerSpriteInicial(fabricaSprites);
		}
		contexto.establecerSprite(aRetornar);
	}
	
	public Sprite obtenerSpriteInicial(FabricaSprites fabricaSprites) {
		return fabricaSprites.obtenerMarioFuegoFrontalQuieto();
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
		return contexto.obtenerSprite().equals(fabricaSprites.obtenerMarioFuegoFrontalCaminando()) ||
				contexto.obtenerSprite().equals(fabricaSprites.obtenerMarioFuegoFrontalQuieto()) ||
				contexto.obtenerSprite().equals(fabricaSprites.obtenerMarioFuegoFrontalSaltando());
	}
	
	private boolean spriteReverso(FabricaSprites fabricaSprites) {
		return contexto.obtenerSprite().equals(fabricaSprites.obtenerMarioFuegoReversoCaminando()) ||
				contexto.obtenerSprite().equals(fabricaSprites.obtenerMarioFuegoReversoQuieto()) ||
				contexto.obtenerSprite().equals(fabricaSprites.obtenerMarioFuegoReversoSaltando());
	}

	
	public void realizarAccionEspecial() {	
		lanzarBolaDeFuego();
	}

	private void lanzarBolaDeFuego() {
		int posX = obtenerContexto().obtenerPosicion().x + obtenerContexto().obtenerAncho();
		int posY = obtenerContexto().obtenerPosicion().y;
		Point posicionInicialBolaDeFuego = new Point(posX,posY);
		Point velocidadDireccionalBolaDeFuego = new Point(0,0);
		if(frente) {
			velocidadDireccionalBolaDeFuego = new Point(15,0);
		}else {
			velocidadDireccionalBolaDeFuego = new Point(-15,0);
		}
		BolaDeFuego bolaDeFuego= fabricaEntidades.obtenerBolaDeFuego(posicionInicialBolaDeFuego, velocidadDireccionalBolaDeFuego, contexto);
		contexto.obtenerNivel().addBolaDeFuegoAAgregar(bolaDeFuego);
	}
	
}
