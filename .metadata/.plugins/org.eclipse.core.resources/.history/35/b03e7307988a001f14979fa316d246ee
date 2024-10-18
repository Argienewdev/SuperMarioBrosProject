package elementos;

import java.util.Vector;

import elementos.entidades.Jugable;
import elementos.personaje.EstadoMario;
import fabricas.Sprite;
import visitors.Visitante;

public class ContextoMario extends Jugable {

	private EstadoMario estadoMario;
	
	public ContextoMario(Sprite sprite, Vector<Integer> posicion, Visitante visitor, Vector<Integer> direccion,
			int velocidad, int vidas, EstadoMario estadoMario) {
		super(sprite, posicion, visitor, direccion, velocidad, vidas);
		this.estadoMario=estadoMario;
	}
	
	public void cambiarEstado(EstadoMario estadoMario) {
		this.estadoMario=estadoMario;
	}
	
	

}
