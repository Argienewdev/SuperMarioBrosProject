package elementos.entidades;

import java.util.Vector;
import elementos.ElementoDeJuego;
import elementos.Sprite;
import juego.Nivel;
import observers.ObserverGrafico;
import visitors.Visitante;

public abstract class Entidad extends ElementoDeJuego {
	
	protected Vector<Integer> direccion;
    
    protected int velocidad;
    
    protected ObserverGrafico observerGrafico;
    
    protected Nivel miNivel;

    public Entidad(Sprite sprite, Vector<Integer> posicion, Visitante visitor) {
		super(sprite, posicion, visitor);
	}

    public void setDireccion(Vector<Integer> direccion) {
        this.direccion = direccion;
    }
    
    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }
    
    public void setNivel (Nivel nivel) {
    	this.miNivel = nivel;
    }
    
    public Vector<Integer> getDireccion() {
        return this.direccion;
    }
    
    public int getVelocidad() {
        return this.velocidad;
    }
    
    public Nivel getNivel() {
    	return miNivel;
    }
    
    public void moverADerecha (Vector<Integer> dir) {
    	setDireccion(dir);
    }
    
    public void moverAIzquierda (Vector<Integer> dir) {
    	setDireccion(dir);
    }
    
	public abstract void aceptarVisitante(Visitante visitante);
	
}
