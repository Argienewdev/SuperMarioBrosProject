package elementos.personajes;

import elementos.Sprite;
import fabricas.FabricaSprites;
import ventanas.ConstantesGlobales;
import visitors.Visitante;
import visitors.VisitorSuperMario;

public class SuperMario extends MarioDefault {
	
	@Override
    public void aceptarVisitante(Visitante visitante) {
        visitante.visitarSuperMario(this);
    }
	
	@Override
	public Visitante obtenerVisitante() {
		return new VisitorSuperMario(this);
	}
	
	public void actualizarSprite(FabricaSprites fabricaSprites) {
		Sprite aRetornar = null;
		if(contexto.obtenerPosicion().y > (ConstantesGlobales.NIVEL_PISO)){
			aRetornar = fabricaSprites.getSuperMarioCayendo();
		}else if(spriteAereoFrontal(fabricaSprites)) {
			aRetornar = fabricaSprites.getSuperMarioFrontalSaltando();
		} else if(spriteAereoReverso(fabricaSprites)) {
			aRetornar = fabricaSprites.getSuperMarioReversoSaltando();
		}else if(avanzando()) {
			aRetornar = fabricaSprites.getSuperMarioFrontalCaminando();
		} else if(retrocediendo()){
			aRetornar = fabricaSprites.getSuperMarioReversoCaminando();
		} else if(spriteFrontal(fabricaSprites)){
			aRetornar = fabricaSprites.getSuperMarioFrontalQuieto();
		} else if(spriteReverso(fabricaSprites)){
			aRetornar = fabricaSprites.getSuperMarioReversoQuieto();
		} else {
			aRetornar = fabricaSprites.getSuperMarioFrontalQuieto();
		}
		contexto.establecerSprite(aRetornar);
	}
	
	public Sprite obtenerSpriteInicial(FabricaSprites fabricaSprites) {
		return fabricaSprites.getSuperMarioFrontalQuieto();
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
		return contexto.obtenerSprite().equals(fabricaSprites.getSuperMarioFrontalCaminando()) ||
				contexto.obtenerSprite().equals(fabricaSprites.getSuperMarioFrontalQuieto()) ||
				contexto.obtenerSprite().equals(fabricaSprites.getSuperMarioFrontalSaltando());
	}
	
	private boolean spriteReverso(FabricaSprites fabricaSprites) {
		return contexto.obtenerSprite().equals(fabricaSprites.getSuperMarioReversoCaminando()) ||
				contexto.obtenerSprite().equals(fabricaSprites.getSuperMarioReversoQuieto()) ||
				contexto.obtenerSprite().equals(fabricaSprites.getSuperMarioReversoSaltando());
	}
}