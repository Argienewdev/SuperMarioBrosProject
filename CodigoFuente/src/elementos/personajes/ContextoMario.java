package elementos.personajes;

import java.awt.Point;
import elementos.Sprite;
import elementos.entidades.Jugable;
import visitors.Visitante;

public class ContextoMario extends Jugable {

	private EstadoMario estadoMario;
		
	public ContextoMario(Sprite sprite, Point posicion,
						 Visitante visitor, int vidas, MarioDefault estadoMario) {
		super(sprite, posicion, visitor);
		this.estadoMario = estadoMario;
		estadoMario.setContext(this);
	}
	
	public void cambiarEstado(EstadoMario estadoMario) {
		this.estadoMario = estadoMario;
		estadoMario.setContext(this);
	}
	
	public EstadoMario getEstado() {
		return estadoMario;
	}
	@Override
	public void aceptarVisitante(Visitante visitante) {
		visitante.visitar(this);
	}
	
}
