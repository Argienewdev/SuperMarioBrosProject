package elementos.personajes;

import java.awt.Point;
import java.awt.Rectangle;

import elementos.Sprite;
import fabricas.FabricaSprites;
import ventanas.ConstantesGlobales;
import visitors.Visitante;
import visitors.VisitorMarioInvulnerable;

public class MarioInvulnerable  extends MarioDefault {

	protected int duracion;
	
	private EstadoMario estadoPrevio;
	
	public MarioInvulnerable (EstadoMario estadoPrevio) {
		this.estadoPrevio = estadoPrevio;
		this.duracion = 600;
	}
	
	@Override
    public void aceptarVisitante(Visitante visitante) {
        visitante.visitarMarioInvulnerable(this);
    }
	
	public void actualizarHitboxYPosicion(FabricaSprites fabricaSprites) {
		Rectangle nuevaHitbox = new Rectangle(this.obtenerContexto().obtenerPosicionLogica().x, this.obtenerContexto().obtenerPosicionLogica().y + (this.obtenerContexto().obtenerSprite().obtenerAltoImagen() - obtenerSpriteInicial(fabricaSprites).obtenerAltoImagen()), obtenerSpriteInicial(fabricaSprites).obtenerAnchoImagen(), obtenerSpriteInicial(fabricaSprites).obtenerAltoImagen());
		Point nuevaPosicion = new Point(nuevaHitbox.getLocation());
		this.obtenerContexto().establecerPosicion(nuevaPosicion);
		this.obtenerContexto().setHitbox(nuevaHitbox);
	}
	
	@Override
	public Visitante obtenerVisitante() {
		 return new VisitorMarioInvulnerable(this, this.contexto.obtenerNivel().obtenerPartida().obtenerGeneradorDeSonidos());
	}
	
	public void actualizarSprite(FabricaSprites fabricaSprites) {
		//TODO esta llamada no va aca
		actualizarTiempo();
		Sprite aRetornar = null;
		try {
			if (bajoElNivelDelPiso()){
				aRetornar = fabricaSprites.obtenerMarioInvulnerableCayendo();
			} else if (mirandoAlFrente() && enElAire()) {
				aRetornar = fabricaSprites.obtenerMarioInvulnerableFrontalSaltando();
			} else if (!mirandoAlFrente() && enElAire()) {
				aRetornar = fabricaSprites.obtenerMarioInvulnerableReversoSaltando();
			} else if (avanzando()) {
				aRetornar = fabricaSprites.obtenerMarioInvulnerableFrontalCaminando();
			} else if (retrocediendo()){
				aRetornar = fabricaSprites.obtenerMarioInvulnerableReversoCaminando();
			} else if (mirandoAlFrente() && !avanzando()){
				aRetornar = fabricaSprites.obtenerMarioInvulnerableFrontalQuieto();
			} else if (!mirandoAlFrente() && !retrocediendo()){
				aRetornar = fabricaSprites.obtenerMarioInvulnerableReversoQuieto();
			} else {
				aRetornar = obtenerSpriteInicial(fabricaSprites);
			}
			contexto.establecerSprite(aRetornar);
		}catch(NullPointerException e) {
			e.printStackTrace();
		}
	}
	
	public Sprite obtenerSpriteInicial(FabricaSprites fabricaSprites) {
		return fabricaSprites.obtenerMarioInvulnerableFrontalQuieto();
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
	
	public void actualizarTiempo () {
		duracion--;
		if (duracion <= 0)
			contexto.cambiarEstado(estadoPrevio);
	}
}
