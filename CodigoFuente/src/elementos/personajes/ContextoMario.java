package elementos.personajes;

import java.awt.Point;

import elementos.Sprite;
import elementos.entidades.Jugable;
import fabricas.FabricaSprites;
import generadores.GeneradorSonidos;
import observers.ObserverGrafico;
import visitors.Visitante;

public class ContextoMario extends Jugable {

	private EstadoMario estadoMario;
	
	private boolean cambiarEstado;
	
	protected GeneradorSonidos generadorSonidos;
		
	@SuppressWarnings("exports")
	public ContextoMario(Sprite sprite, Point posicion, Visitante visitor, ObserverGrafico observerGrafico,
						 int vidas, MarioDefault estadoMario, GeneradorSonidos generadorSonidos) {
		super(sprite, posicion, visitor, observerGrafico);
		this.generadorSonidos= generadorSonidos;
		this.estadoMario = estadoMario;
		this.cambiarEstado = false;
		this.estadoMario.establecerContexto(this);
	}
	
	public void cambiarEstado(EstadoMario estadoMario) {
		this.estadoMario = estadoMario;
		estadoMario.establecerContexto(this);
		this.cambiarEstado = true;
	}

	public void actualizarSprite(FabricaSprites fabricaSprites) {
		if (cambiarEstado) {
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
	
	public void aceptarVisitante(Visitante visitante) {
		visitante.visitarContextoMario(this);
	}

	public void realizarAccionEspecial() {
		estadoMario.realizarAccionEspecial();
	}
	
}
