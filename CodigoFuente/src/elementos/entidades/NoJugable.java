package elementos.entidades;

import java.awt.Point;

import elementos.Sprite;
import fabricas.FabricaSprites;
import observers.ObserverGrafico;
import visitors.Visitante;

public abstract class NoJugable extends Entidad {
	
	protected int ticksAnimacion;
	
	@SuppressWarnings("exports")
	public NoJugable(Sprite sprite, Point posicion, Visitante visitor, ObserverGrafico observerGrafico) {
		super(sprite, posicion, visitor, observerGrafico);
		this.colisionAbajo = true;
		this.ticksAnimacion = 60;
	}

	public abstract void aceptarVisitante(Visitante visitante);
	
	public abstract void actualizarSprite(FabricaSprites fabricaSprites);
	
    public abstract void eliminarEntidadGraficaYLogicamente(FabricaSprites fabricaSprites);

	public void eliminarDelNivel() {
		this.miNivel.addEntidadesAEliminar(this);
		this.removido = true;
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
	
}
