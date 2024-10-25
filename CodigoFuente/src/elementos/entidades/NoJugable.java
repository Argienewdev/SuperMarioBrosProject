package elementos.entidades;

import java.awt.Point;

import elementos.Sprite;
import fabricas.FabricaSprites;
import observers.ObserverGrafico;
import visitors.Visitante;

public abstract class NoJugable extends Entidad {
	
	public NoJugable(Sprite sprite, Point posicion, Visitante visitor, 
					 Point velocidadDireccional, ObserverGrafico observerGrafico) {
		super(sprite, posicion, visitor);
		this.velocidadDireccional = velocidadDireccional;
		this.observerGrafico = observerGrafico;
		this.colisionAbajo = true;
	}

	public abstract void aceptarVisitante(Visitante visitante);
	
	public abstract void actualizarSprite(FabricaSprites fabricaSprites);
	
	public abstract void eliminarDelNivel();
	
	@Override
	public void retrotraerMovimientoHorizontal() {
        this.moverHitbox(this.posicion);
        this.setVelocidadDireccional(new Point(-this.getVelocidadDireccional().x, getVelocidadDireccional().y));
	}
}
