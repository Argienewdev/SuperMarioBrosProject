package elementos.entidades;

import java.awt.Point;
import java.awt.Rectangle;

import elementos.Sprite;
import fabricas.FabricaSprites;
import observers.ObserverGrafico;
import ventanas.ConstantesGlobales;
import visitors.Visitante;

public abstract class NoJugable extends Entidad {
	
	private static final int VELOCIDAD_MAXIMA_DE_CAIDA = 15;

	protected boolean debeMantenerseSiempreEnPantalla;
		
	@SuppressWarnings("exports")
	public NoJugable(Sprite sprite, Point posicion, Visitante visitor, ObserverGrafico observerGrafico) {
		super(sprite, posicion, visitor, observerGrafico);
		this.colisionAbajo = true;
		this.debeMantenerseSiempreEnPantalla = false;
	}

	public abstract void aceptarVisitante(Visitante visitante);
	
	public abstract void actualizarSprite(FabricaSprites fabricaSprites);
	
    protected abstract void eliminarEntidadGrafica(FabricaSprites fabricaSprites);

	public void eliminarDelNivel() {
		this.miNivel.addEntidadesAEliminar(this);
	}
	
	public int obtenerTicksAnimacion() {
		return this.ticksAnimacion;
	}

	public abstract void mover();
    
    public abstract void invertirDireccion();
    
    public void aplicarGravedad() {
		if(this.getVelocidadDireccional().y < VELOCIDAD_MAXIMA_DE_CAIDA){
			Point nuevaVelocidad = new Point(this.getVelocidadDireccional().x, this.getVelocidadDireccional().y + ConstantesGlobales.GRAVEDAD);
			this.setVelocidadDireccional(nuevaVelocidad);
		}
	}
	
	public void retrotraerMovimientoHorizontal(int posX) {
		Point nuevaPosicion = new Point(posX, this.obtenerHitbox().y);
        this.moverHitbox(nuevaPosicion);
		this.setPosicion(nuevaPosicion);
		this.invertirDireccion();
	}
	
	public void actualizarHitboxYPosicion(FabricaSprites fabricaSprites) {
		int nuevaPosX = this.getPosicion().x;
		int nuevaPosY = this.getPosicion().y + (this.obtenerAlto() - this.getSprite().getAltoImagen());
		int nuevoAncho = this.getSprite().getAnchoImagen();
		int nuevoAlto = this.getSprite().getAltoImagen();
		this.setHitbox(new Rectangle(nuevaPosX, nuevaPosY, nuevoAncho, nuevoAlto));
		this.setPosicion(this.obtenerHitbox().getLocation());
	}
	
	public boolean obtenerDebeMantenerseSiempreEnPantalla() {
		return this.debeMantenerseSiempreEnPantalla;
	}

	public void establecerDebeMantenerseSiempreEnPantalla(boolean debeMantenerseSiempreEnPantalla) {
		this.debeMantenerseSiempreEnPantalla = debeMantenerseSiempreEnPantalla;
	}
	
}
