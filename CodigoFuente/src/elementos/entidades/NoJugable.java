package elementos.entidades;

import java.awt.Point;
import java.awt.Rectangle;

import elementos.Sprite;
import fabricas.FabricaSprites;
import observers.ObserverGrafico;
import visitors.Visitante;

public abstract class NoJugable extends Entidad {
	
	protected boolean removido;
	
	protected static final int TICKS_HASTA_ELIMINAR_CADAVER = 2;
	
	public NoJugable(Sprite sprite, Point posicion, Visitante visitor, 
					 Point velocidadDireccional, ObserverGrafico observerGrafico) {
		super(sprite, posicion, visitor, velocidadDireccional, observerGrafico);
		this.colisionAbajo = true;
		this.removido = false;
	}

	public abstract void aceptarVisitante(Visitante visitante);
	
	public abstract void actualizarSprite(FabricaSprites fabricaSprites);
	
    public abstract void eliminarEntidadGraficamente(FabricaSprites fabricaSprites);

	public void eliminarDelNivel() {
		this.miNivel.addEntidadesAEliminar(this);
		//this.removido = true;
	}
	
	public boolean fueRemovido() {
		return this.removido;
	}
	
	public void setRemovido(boolean removido) {
		this.removido = removido;
	}
	
	public int obtenerTicksHastaEliminarCadaver() {
		return TICKS_HASTA_ELIMINAR_CADAVER;
	}
	
	@Override
	public void retrotraerMovimientoHorizontal() {
        this.moverHitbox(this.posicion);
        this.setVelocidadDireccional(new Point(-this.getVelocidadDireccional().x, getVelocidadDireccional().y));
	}
}
