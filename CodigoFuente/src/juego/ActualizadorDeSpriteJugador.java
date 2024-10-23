
package juego;

import java.awt.Point;

import elementos.Sprite;
import elementos.entidades.Jugable;
import fabricas.FabricaSprites;
import fabricas.FabricaSpritesModoOriginal;
import ventanas.DimensionesConstantes;

public class ActualizadorDeSpriteJugador {
	
	private FabricaSprites fabricaSprites;
	
	private Jugable marioJugable;
	
	public ActualizadorDeSpriteJugador(FabricaSprites fabricaSprites, Jugable marioJugable) {
		this.fabricaSprites = fabricaSprites;
		this.marioJugable = marioJugable;
	}
	
	public void actualizar() {
		Sprite aRetornar = null;
		if(marioJugable.getPosicion().y > (DimensionesConstantes.PANEL_ALTO - 150)){
			aRetornar = fabricaSprites.getMarioDefaultCayendo();
		}else if(spriteAereoFrontal()) {
			aRetornar = fabricaSprites.getMarioDefaultFrontalSaltando();
		} else if(spriteAereoReverso()) {
			aRetornar = fabricaSprites.getMarioDefaultReversoSaltando();
		}else if(avanzando()) {
			aRetornar = fabricaSprites.getMarioDefaultFrontalCaminandoPrimeraTransicion();
		} else if(retrocediendo()){
			aRetornar = fabricaSprites.getMarioDefaultReversoCaminandoPrimeraTransicion();
		} else if(spriteFrontal()){
			aRetornar = fabricaSprites.getMarioDefaultFrontalQuieto();
		} else if(spriteReverso()){
			aRetornar = fabricaSprites.getMarioDefaultReversoQuieto();
		}
		marioJugable.setSprite(aRetornar);
	}
	
	public Sprite obtenerSpriteInicial() {
		return fabricaSprites.getMarioDefaultFrontalQuieto();
	}
	
	private boolean enElAire() {
		return marioJugable.getEnElAire();
	}
	
	private boolean avanzando() {
		return marioJugable.getAvanzando();
	}
	
	private boolean retrocediendo() {
		return marioJugable.getRetrocediendo();
	}
	
	private boolean spriteAereoFrontal() {
		return enElAire() && (avanzando() || (spriteFrontal() && !retrocediendo()));
	}
	
	private boolean spriteAereoReverso() {
		return enElAire() && (retrocediendo() || (spriteReverso() && !avanzando()));
	}
	
	private boolean spriteFrontal() {
		return marioJugable.getSprite().getRutaImagen().equals(fabricaSprites.getMarioDefaultFrontalCaminandoPrimeraTransicion().getRutaImagen()) ||
				marioJugable.getSprite().getRutaImagen().equals(fabricaSprites.getMarioDefaultFrontalQuieto().getRutaImagen()) ||
				marioJugable.getSprite().getRutaImagen().equals(fabricaSprites.getMarioDefaultFrontalSaltando().getRutaImagen());
	}
	
	private boolean spriteReverso() {
		return marioJugable.getSprite().getRutaImagen().equals(fabricaSprites.getMarioDefaultReversoCaminandoPrimeraTransicion().getRutaImagen()) ||
				marioJugable.getSprite().getRutaImagen().equals(fabricaSprites.getMarioDefaultReversoQuieto().getRutaImagen()) ||
				marioJugable.getSprite().getRutaImagen().equals(fabricaSprites.getMarioDefaultReversoSaltando().getRutaImagen());
	}
	
}
