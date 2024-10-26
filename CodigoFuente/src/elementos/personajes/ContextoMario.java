package elementos.personajes;

import java.awt.Point;
import java.awt.Rectangle;

import elementos.Sprite;
import elementos.entidades.Jugable;
import fabricas.FabricaSprites;
import visitors.Visitante;

public class ContextoMario extends Jugable {

	private EstadoMario estadoMario;
	
	private boolean cambiarEstado;
	
	public ContextoMario(Sprite sprite, Point posicion,
						 Visitante visitor, int vidas, MarioDefault estadoMario) {
		super(sprite, posicion, visitor);
		this.estadoMario = estadoMario;
		this.cambiarEstado = false;
		estadoMario.setContext(this);
	}
	
	public void cambiarEstado(EstadoMario estadoMario) {
		this.estadoMario = estadoMario;
		estadoMario.setContext(this);
		this.cambiarEstado = true;
	}
	
	public void setHitbox(Rectangle hitbox) {
		this.hitbox = hitbox;
	}
	
	public void actualizarSprite(FabricaSprites fabricaSprites) {
		if(cambiarEstado) {
			estadoMario.actualizarHitboxYPosicion(fabricaSprites);
			this.cambiarEstado = false;
		}
		estadoMario.actualizarSprite(fabricaSprites);
	}
	
	public EstadoMario getEstado() {
		return estadoMario;
	}
	@Override
	public void aceptarVisitante(Visitante visitante) {
		visitante.visitarContextoMario(this);
	}

	@Override
	public void realizarAccionEspecial() {
		estadoMario.realizarAccionEspecial();
	}
}
