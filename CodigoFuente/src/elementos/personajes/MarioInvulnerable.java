package elementos.personajes;

import elementos.Sprite;
import fabricas.FabricaSprites;
import ventanas.DimensionesConstantes;
import visitors.Visitante;
import visitors.VisitorMarioInvulnerable;

public class MarioInvulnerable  extends MarioDefault {

	protected int duracion = 10000;
	
	private EstadoMario estadoPrevio;
	
	public MarioInvulnerable (EstadoMario estadoPrevio) {
		this.estadoPrevio = estadoPrevio;
	}
	
	@Override
    public void aceptarVisitante(Visitante visitante) {
        visitante.visitarMarioInvulnerable(this);
    }
	
	@Override
	public Visitante getVisitor() {
		 return new VisitorMarioInvulnerable(this);
	}
	
	public void actualizarSprite(FabricaSprites fabricaSprites) {
		Sprite aRetornar = null;
		try {
			if(contexto.getPosicion().y > (DimensionesConstantes.NIVEL_PISO)){
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
			contexto.setSprite(aRetornar);
		}catch(NullPointerException e) {
			e.printStackTrace();
		}
	}
	
	public Sprite obtenerSpriteInicial(FabricaSprites fabricaSprites) {
		return fabricaSprites.getMarioInvulnerableFrontalQuieto();
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
		return contexto.getSprite().equals(fabricaSprites.getMarioInvulnerableFrontalCaminando()) ||
				contexto.getSprite().equals(fabricaSprites.getMarioInvulnerableFrontalQuieto()) ||
				contexto.getSprite().equals(fabricaSprites.getMarioInvulnerableFrontalSaltando());
	}
	
	private boolean spriteReverso(FabricaSprites fabricaSprites) {
		return contexto.getSprite().equals(fabricaSprites.getMarioInvulnerableReversoCaminando()) ||
				contexto.getSprite().equals(fabricaSprites.getMarioInvulnerableReversoQuieto()) ||
				contexto.getSprite().equals(fabricaSprites.getMarioInvulnerableReversoSaltando());
	}
	
	public void actualizarTiempo (int tiempoDelta) {
		duracion -= tiempoDelta;
		if (duracion <= 0)
			contexto.cambiarEstado(estadoPrevio);
	}
}
