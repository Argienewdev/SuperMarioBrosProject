package elementos.personajes;

import java.awt.Point;

import elementos.Sprite;
import elementos.enemigos.BuzzyBeetle;
import fabricas.FabricaEntidades;
import fabricas.FabricaSprites;
import observers.ObserverGrafico;
import ventanas.DimensionesConstantes;
import visitors.Visitante;
import visitors.VisitorBuzzyBeetle;
import visitors.VisitorMarioFuego;

public class MarioFuego extends MarioDefault {
	
	protected FabricaEntidades fabricaEntidades;
	
	public MarioFuego(FabricaEntidades fabricaEntidades) {
		this.fabricaEntidades=fabricaEntidades;
	}
	
	@Override
    public void aceptarVisitante(Visitante visitante) {
        visitante.visitarMarioFuego(this);
    }
	
	@Override
	public Visitante getVisitor() {
		return new VisitorMarioFuego(this);
	}
	
	public void actualizarSprite(FabricaSprites fabricaSprites) {
		Sprite aRetornar = null;
		if(contexto.getPosicion().y > (DimensionesConstantes.NIVEL_PISO)){
			aRetornar = fabricaSprites.getMarioFuegoCayendo();
		}else if(spriteAereoFrontal(fabricaSprites)) {
			aRetornar = fabricaSprites.getMarioFuegoFrontalSaltando();
		} else if(spriteAereoReverso(fabricaSprites)) {
			aRetornar = fabricaSprites.getMarioFuegoReversoSaltando();
		}else if(avanzando()) {
			aRetornar = fabricaSprites.getMarioFuegoFrontalCaminando();
		} else if(retrocediendo()){
			aRetornar = fabricaSprites.getMarioFuegoReversoCaminando();
		} else if(spriteFrontal(fabricaSprites)){
			aRetornar = fabricaSprites.getMarioFuegoFrontalQuieto();
		} else if(spriteReverso(fabricaSprites)){
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
		System.out.println("Lanzar bola");
	}
	
}
