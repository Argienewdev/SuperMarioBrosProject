package elementos.personajes;

import java.awt.Point;
import java.util.Vector;

import elementos.Sprite;
import elementos.entidades.Jugable;
import visitors.Visitante;

public class ContextoMario extends Jugable {
	//TODO por que hay 2 contexto mario
	
	private EstadoMario estadoMario;
	
	public ContextoMario(Sprite sprite, Point posicion, Visitante visitor, int vidas, EstadoMario estadoMario) {
		//super a Jugable???
		super(sprite, posicion, visitor, vidas);
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
