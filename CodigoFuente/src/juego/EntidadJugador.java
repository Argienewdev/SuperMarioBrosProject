package juego;

import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import elementos.Sprite;
import visitors.Visitante;

public class EntidadJugador implements EntidadLogica{
	//Probablemente esto se cambie
	private Point posicion;

	private Sprite sprite;
	
	private JLabel mario;
	
	private Visitante visitante;
	
	public EntidadJugador() { //Deberia recibir dos enteros para la posicion inicial y un sprite inicial
		posicion = new Point(0,0); //Esto debe ser inicializado en la posicion inicial de mario
		//mario = new JLabel(spriteInicial);
		//falta configurar el tamaño y demas del label en pantalla
	}
	
	public void actualizar(Point posicion, ImageIcon sprite) {
		mario.setIcon(sprite);
		mario.setLocation(posicion);
	}

	@Override
	public Sprite getSprite() {
		return sprite;
	}

	@Override
	public Point getPosicion() {
		return posicion;
	}

	@Override
	public Visitante getVisitor() {
		return visitante;
	}
}
