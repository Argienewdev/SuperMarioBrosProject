package elementos.personajes;

import java.awt.Point;
import java.awt.Rectangle;

import elementos.Sprite;
import elementos.entidades.BolaDeFuego;
import fabricas.FabricaEntidades;
import fabricas.FabricaSprites;
import ventanas.ConstantesGlobales;
import visitors.Visitante;
import visitors.VisitorMarioFuego;

public class MarioFuego extends MarioDefault {
	
	protected FabricaEntidades fabricaEntidades;
	
	
	public MarioFuego(FabricaEntidades fabricaEntidades) {
		this.fabricaEntidades = fabricaEntidades;
	}
	
	@Override
    public void aceptarVisitante(Visitante visitante) {
        visitante.visitarMarioFuego(this);
    }
	
	@Override
	public Visitante obtenerVisitante() {
		return new VisitorMarioFuego(this);
	}
	
	public void actualizarHitboxYPosicion(FabricaSprites fabricaSprites) {
		Rectangle nuevaHitbox = new Rectangle(this.obtenerContexto().obtenerPosicionLogica().x, this.obtenerContexto().obtenerPosicionLogica().y + (this.obtenerContexto().obtenerSprite().obtenerAltoImagen() - obtenerSpriteInicial(fabricaSprites).obtenerAltoImagen()), obtenerSpriteInicial(fabricaSprites).obtenerAnchoImagen(), obtenerSpriteInicial(fabricaSprites).obtenerAltoImagen());
		Point nuevaPosicion = new Point(nuevaHitbox.getLocation());
		this.obtenerContexto().establecerPosicion(nuevaPosicion);
		this.obtenerContexto().setHitbox(nuevaHitbox);
	}
	
	public void actualizarSprite(FabricaSprites fabricaSprites) {
		Sprite aRetornar = null;
		if (bajoElNivelDelPiso()){
			aRetornar = fabricaSprites.obtenerMarioFuegoCayendo();
		} else if (mirandoAlFrente() && enElAire()) {
			aRetornar = fabricaSprites.obtenerMarioFuegoFrontalSaltando();
		} else if (!mirandoAlFrente() && enElAire()){
			aRetornar = fabricaSprites.obtenerMarioFuegoReversoSaltando();
		} else if (avanzando()) {
			aRetornar = fabricaSprites.obtenerMarioFuegoFrontalCaminando();
		} else if (retrocediendo()){
			aRetornar = fabricaSprites.obtenerMarioFuegoReversoCaminando();
		} else if (mirandoAlFrente() && !avanzando()){
			aRetornar = fabricaSprites.obtenerMarioFuegoFrontalQuieto();
		} else if (!mirandoAlFrente() && !retrocediendo()){
			aRetornar = fabricaSprites.obtenerMarioFuegoReversoQuieto();
		} else {
			aRetornar = obtenerSpriteInicial(fabricaSprites);
		}
		contexto.establecerSprite(aRetornar);
	}
	
	public Sprite obtenerSpriteInicial(FabricaSprites fabricaSprites) {
		this.contexto.establecerMirandoAlFrente(true);
		return fabricaSprites.obtenerMarioFuegoFrontalQuieto();
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
	
	public void realizarAccionEspecial() {	
		lanzarBolaDeFuego();
	}
	
	private boolean mirandoAlFrente() {
		return contexto.obtenerMirandoAlFrente();
	}
	
	private boolean bajoElNivelDelPiso() {
		return contexto.obtenerPosicionLogica().y > (ConstantesGlobales.NIVEL_PISO);
	}

	private void lanzarBolaDeFuego() {
		int posGraficaX = obtenerContexto().obtenerPosicionGrafica().x;
		int posGraficaY = obtenerContexto().obtenerPosicionGrafica().y;
		
		int posLogicaX = obtenerContexto().obtenerPosicionLogica().x;
		int posLogicaY = obtenerContexto().obtenerPosicionLogica().y;
		
		Point posicionGraficaBolaDeFuego = new Point(posGraficaX,posGraficaY);
		Point posicionLogicaBolaDeFuego = new Point(posLogicaX,posLogicaY);
		
		Point velocidadDireccionalBolaDeFuego = new Point(0,0);
		
		if (this.obtenerContexto().obtenerMirandoAlFrente()) {
			velocidadDireccionalBolaDeFuego = new Point(15,0);
		} else {
			velocidadDireccionalBolaDeFuego = new Point(-15,0);
		}
		
		BolaDeFuego bolaDeFuego = fabricaEntidades.obtenerBolaDeFuego(posicionLogicaBolaDeFuego, velocidadDireccionalBolaDeFuego, contexto);
		
		bolaDeFuego.establecerPosicionGrafica(posicionGraficaBolaDeFuego);
		
		contexto.obtenerNivel().agregarBolaDeFuegoAAgregar(bolaDeFuego);
	}
	
}
