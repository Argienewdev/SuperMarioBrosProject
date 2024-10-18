package elementos.entidades;

import java.awt.Point;
import java.awt.Rectangle;
import elementos.ElementoDeJuego;
import elementos.Sprite;
import juego.Nivel;
import observers.ObserverGrafico;
import visitors.Visitante;

public abstract class Entidad extends ElementoDeJuego {
	
    protected int velocidad;
    
    protected Point direccion;
    
    protected ObserverGrafico observerGrafico;
    
    protected Nivel miNivel;
    
    protected Rectangle hitbox;

    public Entidad(Sprite sprite, Point posicion, Visitante visitor) {
		super(sprite, posicion, visitor);
	}

    public void setDireccion(Point direccion) {
        this.direccion = direccion;
    }
    
    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }
    
    public void setNivel (Nivel nivel) {
    	this.miNivel = nivel;
    }
    
    
    public Point getDireccion() {
        return this.direccion;
    }
    
    public int getVelocidad() {
        return this.velocidad;
    }
    
    public Nivel getNivel() {
    	return miNivel;
    }
    
    public void moverADerecha (Point dir) {
    	setDireccion(dir);
    }
    
    public void moverAIzquierda (Point dir) {
    	setDireccion(dir);
    }
    
    public void establecerPosicion (Point pos) {
    	posicion = pos;
    }
    
	public abstract void aceptarVisitante(Visitante visitante);
	
}
