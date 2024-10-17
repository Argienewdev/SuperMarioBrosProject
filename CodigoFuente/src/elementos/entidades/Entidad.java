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

    
    // Metodos
    public void setDireccion(Vector<Integer> direccion) {
        this.direccion = direccion;
    }
    
    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }
    
    public void setNivel (Nivel nivel) {
    	miNivel = nivel;
    }
    
    public Vector<Integer> getDireccion() {
        return direccion;
    }
    
    public int getVelocidad() {
        return velocidad;
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
