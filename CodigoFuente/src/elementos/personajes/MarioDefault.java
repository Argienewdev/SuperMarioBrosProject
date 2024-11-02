package elementos.personajes;

import java.awt.Point;
import java.awt.Rectangle;

import elementos.Sprite;
import fabricas.FabricaSprites;
import ventanas.ConstantesGlobales;
import visitors.Visitante;
import visitors.VisitorMarioDefault;

public class MarioDefault implements EstadoMario {
	
	protected ContextoMario contexto;
	
	public void establecerContexto(ContextoMario contexto) {
		this.contexto = contexto;
	}
	
	public ContextoMario obtenerContexto() {
		return this.contexto;
	}
	
	public void actualizarHitboxYPosicion(FabricaSprites fabricaSprites) {
		int nuevaPosicionX = this.obtenerContexto().obtenerPosicionLogica().x;
		int nuevaPosicionY = this.obtenerContexto().obtenerPosicionLogica().y + (this.obtenerContexto().obtenerHitbox().height - obtenerSpriteInicial(fabricaSprites).obtenerAltoImagen());
		Rectangle nuevaHitbox = new Rectangle(nuevaPosicionX, nuevaPosicionY, obtenerSpriteInicial(fabricaSprites).obtenerAnchoImagen(), obtenerSpriteInicial(fabricaSprites).obtenerAltoImagen());
		Point nuevaPosicion = new Point(nuevaHitbox.getLocation());
		this.obtenerContexto().establecerPosicion(nuevaPosicion);
		this.obtenerContexto().setHitbox(nuevaHitbox);
	}
	
	@Override
    public void aceptarVisitante(Visitante visitante) {
        visitante.visitarMarioDefault(this);
    }

	@Override
	public Visitante obtenerVisitante() {
		return new VisitorMarioDefault(this, this.contexto.obtenerNivel().obtenerPartida().obtenerGeneradorDeSonidos());
	}
	
	public void actualizarSprite(FabricaSprites fabricaSprites) {
		Sprite aRetornar = null;
		if (bajoElNivelDelPiso()){
			aRetornar = fabricaSprites.obtenerMarioDefaultCayendo();
		} else if (mirandoAlFrente() && enElAire()) {
			aRetornar = fabricaSprites.obtenerMarioDefaultFrontalSaltando();
		} else if (!mirandoAlFrente() && enElAire()) {
			aRetornar = fabricaSprites.obtenerMarioDefaultReversoSaltando();
		} else if (avanzando()) {
			aRetornar = fabricaSprites.obtenerMarioDefaultFrontalCaminando();
		} else if (retrocediendo()){
			aRetornar = fabricaSprites.obtenerMarioDefaultReversoCaminando();
		} else if (mirandoAlFrente() && !avanzando()){
			aRetornar = fabricaSprites.obtenerMarioDefaultFrontalQuieto();
		} else if (!mirandoAlFrente() && !retrocediendo()){
			aRetornar = fabricaSprites.obtenerMarioDefaultReversoQuieto();
		} else {
			aRetornar = obtenerSpriteInicial(fabricaSprites);
		}
		contexto.establecerSprite(aRetornar);
	}
	
	public Sprite obtenerSpriteInicial(FabricaSprites fabricaSprites) {
		return fabricaSprites.obtenerMarioDefaultFrontalQuieto();
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

	public void realizarAccionEspecial() {		
	}
	
	public void actualizarTiempo() {
	}
	
}