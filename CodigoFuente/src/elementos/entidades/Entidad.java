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
    
    protected Nivel miNivel;
    
    protected Rectangle hitbox;

    public Entidad(Sprite sprite, Point posicion, Visitante visitor) {
		super(sprite, posicion, visitor);
	}

    public void setVelocidadDireccional(Point velocidadDireccional) {
        this.velocidadDireccional = velocidadDireccional;
    }
    
    public void setNivel (Nivel nivel) {
    	this.miNivel = nivel;
    }
    
    
    public Point getVelocidadDireccional() {
        return this.velocidadDireccional;
    }
    
    public Nivel getNivel() {
    	return miNivel;
    }
    
    public void moverADerecha (Point dir) {
    	setVelocidadDireccional(dir);
    }
    
    public void moverAIzquierda (Point dir) {
    	setVelocidadDireccional(dir);
    }
    
	public abstract void aceptarVisitante(Visitante visitante);
	
}
