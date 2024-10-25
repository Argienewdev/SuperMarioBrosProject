package elementos.personajes;

import elementos.Sprite;
import fabricas.FabricaSprites;
import ventanas.DimensionesConstantes;
import visitors.Visitante;
import visitors.VisitorSuperMario;

public class SuperMario extends MarioDefault {
	
	@Override
    public void aceptarVisitante(Visitante visitante) {
        visitante.visitar(this);
    }
	
	@Override
	public Visitante getVisitor() {
		return new VisitorSuperMario(this);
	}
	
	public void actualizarSprite(FabricaSprites fabricaSprites) {
		Sprite aRetornar = null;
		if(contexto.getPosicion().y > (DimensionesConstantes.NIVEL_PISO)){
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
		contexto.setSprite(aRetornar);
	}
	
	public Sprite obtenerSpriteInicial(FabricaSprites fabricaSprites) {
		return fabricaSprites.getSuperMarioFrontalQuieto();
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
		return contexto.getSprite().equals(fabricaSprites.getSuperMarioFrontalCaminando()) ||
				contexto.getSprite().equals(fabricaSprites.getSuperMarioFrontalQuieto()) ||
				contexto.getSprite().equals(fabricaSprites.getSuperMarioFrontalSaltando());
	}
	
	private boolean spriteReverso(FabricaSprites fabricaSprites) {
		return contexto.getSprite().equals(fabricaSprites.getSuperMarioReversoCaminando()) ||
				contexto.getSprite().equals(fabricaSprites.getSuperMarioReversoQuieto()) ||
				contexto.getSprite().equals(fabricaSprites.getSuperMarioReversoSaltando());
	}
}