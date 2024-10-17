package elementos.personaje;

import java.util.Vector;

import elementos.entidades.Jugable;
import fabricas.Sprite;
import visitors.Visitante;

public class ContextoMario extends Jugable {

	private EstadoMario estadoMario;
	
	public ContextoMario(Sprite sprite, Vector<Integer> posicion, Vector<Integer> direccion,
			int velocidad, int vidas, EstadoMario estadoMario) {
		this.sprite = sprite;
		this.posicion = posicion;
		this.direccion = direccion;
		this.estadoMario=estadoMario;
	}
	
	public void cambiarEstado(EstadoMario estadoMario) {
		this.estadoMario=estadoMario;
	}
	
	

}
