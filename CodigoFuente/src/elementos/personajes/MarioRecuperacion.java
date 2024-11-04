package elementos.personajes;

import java.awt.Point;
import java.awt.Rectangle;

import elementos.Sprite;
import fabricas.FabricaSprites;
import juego.ConstantesGlobales;
import visitors.Visitante;
import visitors.VisitorMarioRecuperacion;

public class MarioRecuperacion extends MarioDefault {
	
	private int tiempoEnRecuperacion;
	
	public MarioRecuperacion () {
		this.tiempoEnRecuperacion = 180;
	}
	
	@Override
	public Sprite obtenerSpriteInicial(FabricaSprites fabricaSprites) {
		return fabricaSprites.obtenerMarioRecuperacionFrontalQuieto();
	}
	
	@Override
	public Visitante obtenerVisitante() {
		return new VisitorMarioRecuperacion(this, this.contexto.obtenerNivel().obtenerPartida().obtenerGeneradorSonidos());
	}
	
	@Override
	public void actualizarTiempo() {
		tiempoEnRecuperacion--;
		if (tiempoEnRecuperacion <=  0)
			contexto.reiniciarEstado();
	}
	
	@Override
	public void aceptarVisitante(Visitante visitante) {
	        visitante.visitarMarioRecuperacion(this);
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
		if (bajoElNivelDelPiso()){
			aRetornar = fabricaSprites.obtenerMarioRecuperacionCayendo();
		} else if (mirandoAlFrente() && enElAire()) {
			aRetornar = fabricaSprites.obtenerMarioRecuperacionFrontalSaltando();
		} else if (!mirandoAlFrente() && enElAire()) {
			aRetornar = fabricaSprites.obtenerMarioRecuperacionReversoSaltando();
		} else if (avanzando()) {
			aRetornar = fabricaSprites.obtenerMarioRecuperacionFrontalCaminando();
		} else if (retrocediendo()){
			aRetornar = fabricaSprites.obtenerMarioRecuperacionReversoCaminando();
		} else if (mirandoAlFrente() && !avanzando()){
			aRetornar = fabricaSprites.obtenerMarioRecuperacionFrontalQuieto();
		} else if (!mirandoAlFrente() && !retrocediendo()){
			aRetornar = fabricaSprites.obtenerMarioRecuperacionReversoQuieto();
		} else {
			aRetornar = obtenerSpriteInicial(fabricaSprites);
		}
		contexto.establecerSprite(aRetornar);
	}
	
}
