package elementos.entidades;

import java.awt.Point;
import java.awt.Rectangle;

import elementos.Sprite;
import fabricas.FabricaSprites;
import observers.ObserverGrafico;
import visitors.Visitante;

public abstract class NoJugable extends Entidad {
	
	protected boolean removido;
	
	protected static final int TICKS_HASTA_ELIMINAR_CADAVER = 120;
	
	public NoJugable(Sprite sprite, Point posicion, Visitante visitor, 
					 Point velocidadDireccional, ObserverGrafico observerGrafico) {
		super(sprite, posicion, visitor);
		this.velocidadDireccional = velocidadDireccional;
		this.observerGrafico = observerGrafico;
		this.colisionAbajo = true;
		this.removido = false;
	}

	public abstract void aceptarVisitante(Visitante visitante);
	
	public void actualizarVisual(FabricaSprites fabricaSprites) {
		if(this.removido) {		
			this.elminarEntidadGraficamente(fabricaSprites);
		}else {
			this.actualizarSprite(fabricaSprites);

		}
	}
	public abstract void  elminarEntidadGraficamente(FabricaSprites fabricaSprites);

	public abstract void actualizarSprite(FabricaSprites fabricaSprites);

	public void eliminarDelNivel() {
		this.miNivel.addEntidadesAEliminar(this);
		this.removido = true;
	}
	
	@Override
	public void retrotraerMovimientoHorizontal() {
        this.moverHitbox(this.posicion);
        this.setVelocidadDireccional(new Point(-this.getVelocidadDireccional().x, getVelocidadDireccional().y));
	}
}
