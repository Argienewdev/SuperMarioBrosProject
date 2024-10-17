package juego;
import java.util.Vector;

import elementos.Sprite;
import visitors.Visitante;

public interface EntidadLogica {
	
	public Sprite getSprite();
	
	public Vector<Integer> getPosicion();
	
	public Visitante getVisitor();
	
	public Vector<Integer> getDireccion();
	
	public int getVelocidad();
}
