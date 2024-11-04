package elementos.personajes;

import java.awt.Point;
import java.awt.Rectangle;

import elementos.Sprite;
import fabricas.FabricaSprites;
import generadores.GeneradorSonidos;
import juego.ConstantesGlobales;
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
	
	@Override
	public Sprite obtenerSpriteInicial(FabricaSprites fabricaSprites) {
		return fabricaSprites.obtenerMarioInvulnerableFrontalQuieto();
	}
	
	@Override
	public Visitante obtenerVisitante() {
		return new VisitorMarioInvulnerable(this, this.contexto.obtenerNivel().obtenerPartida().obtenerGeneradorSonidos());
	}
	
	public void reiniciarDuracion() {
		this.duracion = DURACION_INVULNERABLE;
	}
	
    @Override
    public void aceptarVisitante(Visitante visitante) {
        visitante.visitarMarioInvulnerable(this);
    }
	
	@Override
	public void actualizarHitboxYPosicion(FabricaSprites fabricaSprites) {
		Rectangle nuevaHitbox = new Rectangle(this.obtenerContexto().obtenerPosicionLogica().x, this.obtenerContexto().obtenerPosicionLogica().y + (this.obtenerContexto().obtenerSprite().obtenerAltoImagen() - obtenerSpriteInicial(fabricaSprites).obtenerAltoImagen()), obtenerSpriteInicial(fabricaSprites).obtenerAnchoImagen(), obtenerSpriteInicial(fabricaSprites).obtenerAltoImagen());
		Point nuevaPosicion = new Point(nuevaHitbox.getLocation());
		this.obtenerContexto().establecerPosicion(nuevaPosicion);
		this.obtenerContexto().establecerHitbox(nuevaHitbox);
	}
	
	@Override
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
	
	@Override
	public void actualizarTiempo () {
		duracion--;
		if (duracion ==  0) {
			contexto.cambiarEstado(estadoPrevio);
			generadorSonidos.detenerMusicaInvulnerable();
			generadorSonidos.marioPequenioDeNuevo();
			if (!this.contexto.obtenerNivel().obtenerBanderaAccionada()) {
				generadorSonidos.reproducirMusicaFondo();
			}
		}
	}
	
	@Override
	public void reiniciarEstado() {
		this.contexto.generadorSonidos.marioPequenioDeNuevo();
		this.contexto.cambiarEstado(new MarioDefault());
	}
}
