package elementos.entidades;

import java.awt.Point;
import java.awt.Rectangle;
import elementos.ElementoDeJuego;
import elementos.Sprite;
import juego.Nivel;
import observers.ObserverGrafico;
import visitors.Visitante;

public abstract class Entidad extends ElementoDeJuego {
    
    protected Point velocidadDireccional;
    
    protected ObserverGrafico observerGrafico;
    
    public Entidad(Sprite sprite, Point posicion, Visitante visitor) {
		super(sprite, posicion, visitor);
	}

    public void setVelocidadDireccional(Point velocidadDireccional) {
        this.velocidadDireccional = velocidadDireccional;
    }
    
    
    public Point getVelocidadDireccional() {
        return this.velocidadDireccional;
    }
    
    
    public void moverADerecha (Point dir) {
    	setVelocidadDireccional(dir);
    }
    
    public void moverAIzquierda (Point dir) {
    	setVelocidadDireccional(dir);
    }
    
    public void establecerPosicion (Point pos) {
    	this.posicion = pos;
    }
    
    public void setObserverGrafico(ObserverGrafico observerGrafico) {
    	this.observerGrafico = observerGrafico;
    }
    
	public abstract void aceptarVisitante(Visitante visitante);
	
}
