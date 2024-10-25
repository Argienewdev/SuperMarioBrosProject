package elementos.entidades;

import java.awt.Point;
import elementos.ElementoDeJuego;
import elementos.Sprite;
import observers.ObserverGrafico;
import visitors.Visitante;

public abstract class Entidad extends ElementoDeJuego {
    
    protected Point velocidadDireccional;
    
    protected ObserverGrafico observerGrafico;
    
	protected boolean colisionAbajo;
	
	protected boolean colisionArriba;
    
    public Entidad(Sprite sprite, Point posicion, Visitante visitor) {
		super(sprite, posicion, visitor);
		this.colisionAbajo = true;
		this.colisionArriba = false;
	}

    public void setVelocidadDireccional(Point velocidadDireccional) {
        this.velocidadDireccional = velocidadDireccional;
    }
    
    public Point getVelocidadDireccional() {
        return this.velocidadDireccional;
    }
    
    public void moverADerecha(Point dir) {
    	setVelocidadDireccional(dir);
    }
    
    public void moverAIzquierda(Point dir) {
    	setVelocidadDireccional(dir);
    }
    
    public void establecerPosicion(Point pos) {
    	this.posicion = pos;
    }
    
    public void setColisionAbajo(boolean colisionAbajo) {
		this.colisionAbajo = colisionAbajo;
	}
    
    public void setColisionArriba(boolean colisionArriba) {
    	this.colisionArriba = colisionArriba;
    }
    
    public void retrotraerMovimientoHorizontal() {
        this.moverHitbox(this.posicion);
        this.setVelocidadDireccional(new Point(0, getVelocidadDireccional().y));
	}
	
	public void retrotraerMovimientoVertical(int posY) {
		Point nuevaPosicion = new Point(this.obtenerHitbox().x, posY);
		this.moverHitbox(this.posicion);
		this.setPosicion(nuevaPosicion);
		this.setVelocidadDireccional(new Point(getVelocidadDireccional().x, 0));
	}
    
	public boolean getColisionAbajo() {
		return this.colisionAbajo;
	}
	
	public void setColisionAbajo(Boolean colisionAbajo) {
		this.colisionAbajo = colisionAbajo;
	}
	
	public abstract void aceptarVisitante(Visitante visitante);
	
}
