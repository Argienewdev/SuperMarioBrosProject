package elementos.enemigos;

import java.awt.Point;
import java.awt.Rectangle;

import elementos.Sprite;
import fabricas.FabricaSprites;
import observers.ObserverGrafico;
import visitors.Visitante;

public class Spiny extends Enemigo {
	
	private static final int TICKS_PARA_ELIMINAR = 10;
	
	private boolean aterrizo;
	
	private boolean salioDelHuevo;
	
    public Spiny(Sprite sprite, Point posicion, Visitante visitor, ObserverGrafico observerGrafico) {
    	super(sprite, posicion, visitor, observerGrafico);
    	this.puntosOtorgadosPorEliminacion = 60;
    	this.puntosSustraidosPorMuerteCausada = 30;
    	this.ticksAnimacion = TICKS_PARA_ELIMINAR;
    	this.aterrizo = false;
    	this.salioDelHuevo = false;
    }

    @Override
    public void aceptarVisitante(Visitante visitante) {
        visitante.visitarSpiny(this);
    }

	@Override
	public void actualizarSprite(FabricaSprites fabricaSprites) {
		if(this.removido) {
			eliminarEntidadGrafica(fabricaSprites);
		} else if(this.obtenerAterrizo()) {
			if(!this.salioDelHuevo) {
				aterrizar(fabricaSprites);
			}else if(this.obtenerVelocidadDireccional().x < 0) {
				this.establecerSprite(fabricaSprites.getSpinyReversoCaminando());
			} else if(this.obtenerVelocidadDireccional().x > 0) {
				this.establecerSprite(fabricaSprites.getSpinyFrontalCaminando());
			}
		}
	}
	
	private void aterrizar(FabricaSprites fabricaSprites) {
		this.establecerSprite(fabricaSprites.getSpinyReversoCaminando());
		actualizarHitboxYPosicion(fabricaSprites);
		this.salioDelHuevo = true;
	}
	
	public void establecerAterrizo(Boolean aterrizo) {
		this.aterrizo = aterrizo;
	}
	
	public boolean obtenerAterrizo() {
		return this.aterrizo;
	}
	
	public void actualizarHitboxYPosicion(FabricaSprites fabricaSprites) {
		int x = this.obtenerPosicion().x;
		int y = this.obtenerPosicion().y + (this.obtenerAlto() - this.obtenerSprite().establecerAltoImagen());
		int ancho = this.obtenerSprite().obtenerAnchoImagen();
		int alto = this.obtenerSprite().establecerAltoImagen();
		Rectangle nuevaHitbox = new Rectangle(x, y, ancho, alto);
		Point nuevaPosicion = new Point(nuevaHitbox.getLocation());
		this.setHitbox(nuevaHitbox);
		this.establecerPosicion(nuevaPosicion);
	}
	
	@Override
	protected Sprite obtenerSpriteDeMuerte(FabricaSprites fabricaSprites) {
		return fabricaSprites.getSpinyMuerto();
	}
}
