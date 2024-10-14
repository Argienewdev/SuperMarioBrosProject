package elementos;

import java.util.Vector;

import fabricas.Sprite;
import visitors.Visitante;
import vista.Observer;
import juego.*;

public abstract class Entidad extends ElementoDeJuego implements EntidadLogica{
	
	protected Vector<Integer> direccion;
	protected int velocidad;
	protected Observer observer;
	
	
	public Entidad(Sprite sprite, Vector<Integer> posicion, Visitante visitor, Vector<Integer> direccion, int velocidad){
		super(sprite, posicion, visitor);
		this.direccion=direccion;
		this.velocidad=velocidad;
	}
	
	public void setDireccion(Vector<Integer> direccion) {
		this.direccion=direccion;
	}
	
	public void setVelocidad(int velocidad){
		this.velocidad=velocidad;
	}
	
	public void setObserver(Observer observer) {
		this.observer=observer;
	}
	
	public Vector<Integer> getDireccion(){
		return direccion;
	}
	
	public int getVelocidad(){
		return velocidad;
	}
	
		
	
}
