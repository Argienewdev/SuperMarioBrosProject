package elementos.personaje;

import java.util.Vector;

import elementos.Sprite;
import elementos.entidades.Jugable;
import elementos.personajes.EstadoMario;
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

	@Override
	public void saltar(Vector<Integer> direccion) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void aceptarVisitante(Visitante visitante) {
		// TODO Auto-generated method stub
		
	}
	
	

}
