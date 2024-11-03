package elementos.entidades;

import java.awt.Point;
import java.awt.Rectangle;

import elementos.Sprite;
import fabricas.FabricaSprites;
import observers.ObserverGrafico;
import ventanas.ConstantesGlobales;
import visitors.Visitante;

public abstract class NoJugable extends Entidad {
			
	@SuppressWarnings("exports")
	public NoJugable(Sprite sprite, Point posicion, Visitante visitor, ObserverGrafico observerGrafico) {
		super(sprite, posicion, visitor, observerGrafico);
		this.colisionAbajo = true;
	}

	public abstract void aceptarVisitante(Visitante visitante);
	
	public abstract void actualizarSprite(FabricaSprites fabricaSprites);
	
    protected abstract void eliminarEntidadGrafica(FabricaSprites fabricaSprites);
	
	public int obtenerTicksAnimacion() {
		return this.ticksAnimacion;
	}

	public abstract void mover();
    
    public abstract void invertirDireccion();
	
	public void retrotraerMovimientoHorizontal(int posX) {
		Point nuevaPosicion = new Point(posX, this.obtenerHitbox().y);
        this.moverHitbox(nuevaPosicion);
		this.establecerPosicion(nuevaPosicion);
		this.invertirDireccion();
	}
	
	public void actualizarHitboxYPosicion(FabricaSprites fabricaSprites) {
		int nuevaPosX = this.obtenerPosicionLogica().x;
		int nuevaPosY = this.obtenerPosicionLogica().y + (this.obtenerAlto() - this.obtenerSprite().obtenerAltoImagen());
		int nuevoAncho = this.obtenerSprite().obtenerAnchoImagen();
		int nuevoAlto = this.obtenerSprite().obtenerAltoImagen();
		this.setHitbox(new Rectangle(nuevaPosX, nuevaPosY, nuevoAncho, nuevoAlto));
		this.establecerPosicion(this.obtenerHitbox().getLocation());
	}
	
}
