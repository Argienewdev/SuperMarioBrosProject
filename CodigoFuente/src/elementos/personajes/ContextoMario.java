package elementos.personajes;

import java.awt.Point;

import elementos.Sprite;
import elementos.entidades.Jugable;
import fabricas.FabricaSprites;
import observers.ObserverGrafico;
import visitors.Visitante;

public class ContextoMario extends Jugable {

	private EstadoMario estadoMario;
	
	private boolean cambiarEstado;
	
	public ContextoMario(Sprite sprite, Point posicion, Visitante visitor, ObserverGrafico observerGrafico,
						 int vidas, MarioDefault estadoMario) {
		super(sprite, posicion, visitor, observerGrafico);
		this.estadoMario = estadoMario;
		this.cambiarEstado = false;
		estadoMario.establecerContexto(this);
	}
	
	public void cambiarEstado(EstadoMario estadoMario) {
		this.estadoMario = estadoMario;
		estadoMario.establecerContexto(this);
		this.cambiarEstado = true;
	}

	public void actualizarSprite(FabricaSprites fabricaSprites) {
		if(cambiarEstado) {
			estadoMario.actualizarHitboxYPosicion(fabricaSprites);
			this.cambiarEstado = false;
		}
		estadoMario.actualizarSprite(fabricaSprites);
	}
	
	public EstadoMario obtenerEstado() {
		return estadoMario;
	}
	
	public void reiniciarEstado() {
        this.cambiarEstado(new MarioDefault());
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
