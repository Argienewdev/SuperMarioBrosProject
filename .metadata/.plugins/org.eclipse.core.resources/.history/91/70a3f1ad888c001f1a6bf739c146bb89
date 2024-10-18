package elementos.entidades;

import java.util.Vector;
import elementos.ElementoDeJuego;
import fabricas.Sprite;
import observers.ObserverGrafico;
import visitors.Visitante;

public abstract class Entidad extends ElementoDeJuego {

	// Atributos
    protected Vector<Integer> direccion;
    
    protected int velocidad;
    
    protected ObserverGrafico observerGrafico;

    // Constructor
    public Entidad(Sprite sprite, Vector<Integer> posicion, Visitante visitor,
    				int velocidad, Vector<Integer> direccion, ObserverGrafico observerGrafico) {
    	super(sprite, posicion, visitor);
    	this.velocidad = velocidad;
    	this.direccion = direccion;
    	this.observerGrafico = observerGrafico;
    }
    
    // Metodos
    public void setDireccion(Vector<Integer> direccion) {
        this.direccion = direccion;
    }
    
    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }
    
    public Vector<Integer> getDireccion() {
        return direccion;
    }
    
    public int getVelocidad() {
        return velocidad;
    }
    
    public void moverADerecha (Vector<Integer> dir) {
    	setDireccion(dir);
    }
    
    public void moverAIzquierda (Vector<Integer> dir) {
    	setDireccion(dir);
    }
    
	public abstract void aceptarVisitante(Visitante visitante);
	
}
