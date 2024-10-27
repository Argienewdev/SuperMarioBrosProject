package elementos.entidades;

import java.awt.Point;
import java.awt.Rectangle;

import elementos.Sprite;
import fabricas.FabricaSprites;
import observers.ObserverGrafico;
import visitors.Visitante;

public abstract class NoJugable extends Entidad {
	
	protected int ticksAnimacion;
	
	public NoJugable(Sprite sprite, Point posicion, Visitante visitor, 
					 Point velocidadDireccional, ObserverGrafico observerGrafico) {
		super(sprite, posicion, visitor, velocidadDireccional, observerGrafico);
		this.colisionAbajo = true;
		this.ticksAnimacion = 60;
	}

	public abstract void aceptarVisitante(Visitante visitante);
	
	public abstract void actualizarSprite(FabricaSprites fabricaSprites);
	
    public abstract void eliminarEntidadGraficamente(FabricaSprites fabricaSprites);

	public void eliminarDelNivel() {
		this.miNivel.addEntidadesAEliminar(this);
		this.removido = true;
	}
	
	public int obtenerTicksAnimacion() {
		return this.ticksAnimacion;
	}
	
	public void retrotraerMovimientoHorizontal(int posX) {
		Point nuevaPosicion = new Point(posX, this.obtenerHitbox().y);
        this.moverHitbox(nuevaPosicion);
		this.setPosicion(nuevaPosicion);
        this.setVelocidadDireccional(new Point(-this.getVelocidadDireccional().x, getVelocidadDireccional().y));
	}
	
}
