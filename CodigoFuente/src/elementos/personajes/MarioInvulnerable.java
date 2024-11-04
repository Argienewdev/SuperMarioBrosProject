package elementos.personajes;

import java.awt.Point;
import java.awt.Rectangle;

import elementos.Sprite;
import fabricas.FabricaSprites;
import generadores.GeneradorSonidos;
import ventanas.ConstantesGlobales;
import visitors.DetectorDireccionColision;
import visitors.Visitante;
import visitors.VisitorMarioInvulnerable;

public class MarioInvulnerable extends MarioDefault {

	protected static final int DURACION_INVULNERABLE = 300;
		
	protected int duracion;
	
	private EstadoMario estadoPrevio;
	
	protected GeneradorSonidos generadorSonidos;
	
	protected DetectorDireccionColision detectorDireccionColision;
	
	public MarioInvulnerable (EstadoMario estadoPrevio, GeneradorSonidos generadorSonidos) {
		this.generadorSonidos = generadorSonidos;
		this.estadoPrevio = estadoPrevio;
		this.duracion = DURACION_INVULNERABLE;
		this.detectorDireccionColision = new DetectorDireccionColision();
	}
	
	public Sprite obtenerSpriteInicial(FabricaSprites fabricaSprites) {
		return fabricaSprites.obtenerMarioInvulnerableFrontalQuieto();
	}
	
	public Visitante obtenerVisitante() {
		return new VisitorMarioInvulnerable(this, this.contexto.obtenerNivel().obtenerPartida().obtenerGeneradorSonidos());
	}
	
	public void reiniciarDuracion() {
		this.duracion = DURACION_INVULNERABLE;
	}
	
    public void aceptarVisitante(Visitante visitante) {
        visitante.visitarMarioInvulnerable(this);
    }
	
	public void actualizarHitboxYPosicion(FabricaSprites fabricaSprites) {
		Rectangle nuevaHitbox = new Rectangle(this.obtenerContexto().obtenerPosicionLogica().x, this.obtenerContexto().obtenerPosicionLogica().y + (this.obtenerContexto().obtenerSprite().obtenerAltoImagen() - obtenerSpriteInicial(fabricaSprites).obtenerAltoImagen()), obtenerSpriteInicial(fabricaSprites).obtenerAnchoImagen(), obtenerSpriteInicial(fabricaSprites).obtenerAltoImagen());
		Point nuevaPosicion = new Point(nuevaHitbox.getLocation());
		this.obtenerContexto().establecerPosicion(nuevaPosicion);
		this.obtenerContexto().establecerHitbox(nuevaHitbox);
	}
	
	public void actualizarSprite(FabricaSprites fabricaSprites) {
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
		if (duracion ==  0) {
			contexto.cambiarEstado(estadoPrevio);
			generadorSonidos.reproducirMusicaFondo();
			generadorSonidos.detenerMusicaInvencible();
			generadorSonidos.marioPequenioDeNuevo();
		}
	}
}
