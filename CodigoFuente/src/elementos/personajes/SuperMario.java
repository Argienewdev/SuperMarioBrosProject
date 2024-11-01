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
		if (contexto.obtenerPosicionLogica().y > (ConstantesGlobales.NIVEL_PISO)){
			aRetornar = fabricaSprites.obtenerSuperMarioCayendo();
		} else if (spriteAereoFrontal(fabricaSprites)) {
			aRetornar = fabricaSprites.obtenerSuperMarioFrontalSaltando();
		} else if (spriteAereoReverso(fabricaSprites)) {
			aRetornar = fabricaSprites.obtenerSuperMarioReversoSaltando();
		} else if (avanzando()) {
			aRetornar = fabricaSprites.obtenerSuperMarioFrontalCaminando();
		} else if (retrocediendo()){
			aRetornar = fabricaSprites.obtenerSuperMarioReversoCaminando();
		} else if (spriteFrontal(fabricaSprites)){
			aRetornar = fabricaSprites.obtenerSuperMarioFrontalQuieto();
		} else if (spriteReverso(fabricaSprites)){
			aRetornar = fabricaSprites.obtenerSuperMarioReversoQuieto();
		} else {
			aRetornar = fabricaSprites.obtenerSuperMarioFrontalQuieto();
		}
		contexto.establecerSprite(aRetornar);
	}
	
	public Sprite obtenerSpriteInicial(FabricaSprites fabricaSprites) {
		return fabricaSprites.obtenerSuperMarioFrontalQuieto();
	}
	
	private boolean enElAire() {
		return !contexto.obtenerColisionAbajo();
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
		return contexto.obtenerSprite().equals(fabricaSprites.obtenerSuperMarioFrontalCaminando()) ||
				contexto.obtenerSprite().equals(fabricaSprites.obtenerSuperMarioFrontalQuieto()) ||
				contexto.obtenerSprite().equals(fabricaSprites.obtenerSuperMarioFrontalSaltando());
	}
	
	private boolean spriteReverso(FabricaSprites fabricaSprites) {
		return contexto.obtenerSprite().equals(fabricaSprites.obtenerSuperMarioReversoCaminando()) ||
				contexto.obtenerSprite().equals(fabricaSprites.obtenerSuperMarioReversoQuieto()) ||
				contexto.obtenerSprite().equals(fabricaSprites.obtenerSuperMarioReversoSaltando());
	}
}