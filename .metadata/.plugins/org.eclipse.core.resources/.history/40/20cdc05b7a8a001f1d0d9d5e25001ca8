package elementos.entidades;

import java.util.Vector;

import elementos.ElementosDeJuego;
import observers.ObserverGrafico;

public class Entidad extends ElementosDeJuego{

    protected Vector<Integer> direccion;
    protected int velocidad;
    protected ObserverGrafico suscriptor;

    
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
    	//notificar a pantalla ...
    }
    public void moverAIzquierda (Vector<Integer> dir) {
    	setDireccion(dir);
    	//notificar a pantalla
    }
}
