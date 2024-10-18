package juego;
import java.awt.Point;

import elementos.Sprite;
import visitors.Visitante;

public interface EntidadLogica {
	
	public Sprite getSprite();
	
	public Point getPosicion();
	
	public Visitante getVisitor();
}
