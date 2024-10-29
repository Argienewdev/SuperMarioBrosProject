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
		frente=true;
	}
	
	@Override
    public void aceptarVisitante(Visitante visitante) {
        visitante.visitarMarioFuego(this);
    }
	
	@Override
	public Visitante getVisitor() {
		return new VisitorMarioFuego(this);
	}
	
	public void actualizarHitboxYPosicion(FabricaSprites fabricaSprites) {
		Rectangle nuevaHitbox = new Rectangle(this.getContext().getPosicion().x, this.getContext().getPosicion().y + (this.getContext().getSprite().getAltoImagen() - obtenerSpriteInicial(fabricaSprites).getAltoImagen()), obtenerSpriteInicial(fabricaSprites).getAnchoImagen(), obtenerSpriteInicial(fabricaSprites).getAltoImagen());
		Point nuevaPosicion = new Point(nuevaHitbox.getLocation());
		this.getContext().setPosicion(nuevaPosicion);
		this.getContext().setHitbox(nuevaHitbox);
	}
	
	public void actualizarSprite(FabricaSprites fabricaSprites) {
		Sprite aRetornar = null;
		if(contexto.getPosicion().y > (ConstantesGlobales.NIVEL_PISO)){
			aRetornar = fabricaSprites.getMarioFuegoCayendo();
		}else if(spriteAereoFrontal(fabricaSprites)) {
			frente = true;
			aRetornar = fabricaSprites.getMarioFuegoFrontalSaltando();
		} else if(spriteAereoReverso(fabricaSprites)) {
			frente = false;
			aRetornar = fabricaSprites.getMarioFuegoReversoSaltando();
		}else if(avanzando()) {
			frente = true;
			aRetornar = fabricaSprites.getMarioFuegoFrontalCaminando();
		} else if(retrocediendo()){
			frente = false;
			aRetornar = fabricaSprites.getMarioFuegoReversoCaminando();
		} else if(spriteFrontal(fabricaSprites)){
			frente = true;
			aRetornar = fabricaSprites.getMarioFuegoFrontalQuieto();
		} else if(spriteReverso(fabricaSprites)){
			frente = false;
			aRetornar = fabricaSprites.getMarioFuegoReversoQuieto();
		} else {
			aRetornar = obtenerSpriteInicial(fabricaSprites);
		}
		contexto.setSprite(aRetornar);
	}
	
	public Sprite obtenerSpriteInicial(FabricaSprites fabricaSprites) {
		return fabricaSprites.getMarioFuegoFrontalQuieto();
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
		return contexto.getSprite().equals(fabricaSprites.getMarioFuegoFrontalCaminando()) ||
				contexto.getSprite().equals(fabricaSprites.getMarioFuegoFrontalQuieto()) ||
				contexto.getSprite().equals(fabricaSprites.getMarioFuegoFrontalSaltando());
	}
	
	private boolean spriteReverso(FabricaSprites fabricaSprites) {
		return contexto.getSprite().equals(fabricaSprites.getMarioFuegoReversoCaminando()) ||
				contexto.getSprite().equals(fabricaSprites.getMarioFuegoReversoQuieto()) ||
				contexto.getSprite().equals(fabricaSprites.getMarioFuegoReversoSaltando());
	}

	
	public void realizarAccionEspecial() {	
		lanzarBolaDeFuego();
	}

	private void lanzarBolaDeFuego() {
		
		int posX = getContext().getPosicion().x;
		int posY = getContext().getPosicion().y;
		Point posicionInicialBolaDeFuego = new Point(posX,posY);
		Point velocidadDireccionalBolaDeFuego = new Point(0,0);
		if(frente) {
			velocidadDireccionalBolaDeFuego = new Point(15,0);
		}else {
			velocidadDireccionalBolaDeFuego = new Point(-15,0);
		}
		BolaDeFuego bolaDeFuego= fabricaEntidades.getBolaDeFuego(posicionInicialBolaDeFuego, velocidadDireccionalBolaDeFuego, contexto);
		contexto.getNivel().addBolaDeFuego(bolaDeFuego);
		
	}
	
	public void actualizarTiempoDelta(int tiempoDelta) {
		
	}
	
}
