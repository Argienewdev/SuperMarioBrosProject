package elementos.entidades;

import java.awt.Point;
import java.awt.Rectangle;

import elementos.Sprite;
import fabricas.FabricaSprites;
import observers.ObserverGrafico;
import visitors.Visitante;

public abstract class NoJugable extends Entidad {
		
	@SuppressWarnings("exports")
	public NoJugable(Sprite sprite, Point posicion, Visitante visitor, ObserverGrafico observerGrafico) {
		super(sprite, posicion, visitor, observerGrafico);
		this.colisionAbajo = true;
	}

	public abstract void aceptarVisitante(Visitante visitante);
	
	public abstract void actualizarSprite(FabricaSprites fabricaSprites);
	
    public abstract void eliminarEntidadGrafica(FabricaSprites fabricaSprites);

	public void eliminarDelNivel() {
		this.miNivel.addEntidadesAEliminar(this);
		this.setRemovido(true);
	}
	
	public int obtenerTicksAnimacion() {
		return this.ticksAnimacion;
	}

    public abstract void moverDerecha();
    
    public abstract void moverIzquierda();
    
    public abstract void invertirDireccion();
	
	public void retrotraerMovimientoHorizontal(int posX) {
		Point nuevaPosicion = new Point(posX, this.obtenerHitbox().y);
        this.moverHitbox(nuevaPosicion);
		this.setPosicion(nuevaPosicion);
		this.invertirDireccion();
	}
	
	public void actualizarHitboxYPosicion(FabricaSprites fabricaSprites) {
		this.setHitbox(new Rectangle(this.getPosicion().x, this.getPosicion().y + this.getSprite().getAltoImagen(), this.getSprite().getAnchoImagen(), this.getSprite().getAltoImagen()));
		this.setPosicion(this.obtenerHitbox().getLocation());
	}
}
