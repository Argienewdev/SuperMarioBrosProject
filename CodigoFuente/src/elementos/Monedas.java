package elementos;

import java.util.Vector;

import fabricas.Sprite;
import visitors.Visitante;

public class Monedas extends PowerUp{

	protected int cantidad;
	
	public Monedas(Sprite sprite, Vector<Integer> posicion, Visitante visitor, int cantidad) {
		super(sprite, posicion, visitor, new Vector<Integer>(0,0), 0, 5);
		//El vector es la direccion, que en el caso de la mondeda es nulo, el siguiente parametro es la veolcidad, la cual es 0
		this.cantidad=cantidad;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void decrementarCantidad() {
		cantidad--;
	}
}
