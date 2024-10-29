package elementos.enemigos;

import java.awt.Point;
import java.awt.Rectangle;

import elementos.Sprite;
import fabricas.FabricaSprites;
import observers.ObserverGrafico;
import visitors.Visitante;

public class Spiny extends Enemigo {
	
	private static final int TICKS_PARA_ELIMINAR = 1;
	
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
		} else if(this.getAterrizo()) {
			if(!this.salioDelHuevo) {
				aterrizar(fabricaSprites);
			}else if(this.getVelocidadDireccional().x < 0) {
				this.setSprite(fabricaSprites.getSpinyReversoCaminando());
			} else if(this.getVelocidadDireccional().x > 0) {
				this.setSprite(fabricaSprites.getSpinyFrontalCaminando());
			}
		}
	}
	
	protected void eliminarEntidadGrafica(FabricaSprites fabricaSprites) {
		this.setSprite(fabricaSprites.getSpriteInvisible());
		this.eliminarDelNivel();
	}
	
	private void aterrizar(FabricaSprites fabricaSprites) {
		this.setSprite(fabricaSprites.getSpinyReversoCaminando());
		actualizarHitboxYPosicion(fabricaSprites);
		this.salioDelHuevo = true;
	}
	
	public void setAterrizo(Boolean aterrizo) {
		this.aterrizo = aterrizo;
	}
	
	public boolean getAterrizo() {
		return this.aterrizo;
	}
	
	public void actualizarHitboxYPosicion(FabricaSprites fabricaSprites) {
		int x = this.getPosicion().x;
		int y = this.getPosicion().y + (this.obtenerAlto() - this.getSprite().getAltoImagen());
		int ancho = this.getSprite().getAnchoImagen();
		int alto = this.getSprite().getAltoImagen();
		Rectangle nuevaHitbox = new Rectangle(x, y, ancho, alto);
		Point nuevaPosicion = new Point(nuevaHitbox.getLocation());
		this.setHitbox(nuevaHitbox);
		this.setPosicion(nuevaPosicion);
	}
	
}
