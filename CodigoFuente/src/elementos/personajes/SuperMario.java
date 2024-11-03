package elementos.personajes;

import elementos.Sprite;
import fabricas.FabricaSprites;
import ventanas.ConstantesGlobales;
import visitors.Visitante;
import visitors.VisitorSuperMario;

public class SuperMario extends MarioDefault {
	
	public Visitante obtenerVisitante() {
		return new VisitorSuperMario(this, this.contexto.obtenerNivel().obtenerPartida().obtenerGeneradorDeSonidos());
	}
	
	public Sprite obtenerSpriteInicial(FabricaSprites fabricaSprites) {
		return fabricaSprites.obtenerSuperMarioFrontalQuieto();
	}
	
	public void aceptarVisitante(Visitante visitante) {
		visitante.visitarSuperMario(this);
	}
	
	public void actualizarSprite(FabricaSprites fabricaSprites) {
		Sprite aRetornar = null;
		if (bajoElNivelDelPiso()){
			aRetornar = fabricaSprites.obtenerSuperMarioCayendo();
		} else if (mirandoAlFrente() && enElAire()) {
			aRetornar = fabricaSprites.obtenerSuperMarioFrontalSaltando();
		} else if (!mirandoAlFrente() && enElAire()) {
			aRetornar = fabricaSprites.obtenerSuperMarioReversoSaltando();
		} else if (avanzando()) {
			aRetornar = fabricaSprites.obtenerSuperMarioFrontalCaminando();
		} else if (retrocediendo()){
			aRetornar = fabricaSprites.obtenerSuperMarioReversoCaminando();
		} else if (mirandoAlFrente() && !avanzando()){
			aRetornar = fabricaSprites.obtenerSuperMarioFrontalQuieto();
		} else if (!mirandoAlFrente() && !retrocediendo()){
			aRetornar = fabricaSprites.obtenerSuperMarioReversoQuieto();
		} else {
			aRetornar = obtenerSpriteInicial(fabricaSprites);
		}
		contexto.establecerSprite(aRetornar);
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
	
	private boolean mirandoAlFrente() {
		return contexto.obtenerMirandoAlFrente();
	}
	
	private boolean bajoElNivelDelPiso() {
		return contexto.obtenerPosicionLogica().y > (ConstantesGlobales.NIVEL_PISO);
	}
	
}