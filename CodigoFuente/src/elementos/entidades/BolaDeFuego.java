package elementos.entidades;

import java.awt.Point;
import elementos.Sprite;
import fabricas.FabricaSprites;
import observers.ObserverGrafico;
import visitors.Visitante;

public class BolaDeFuego extends NoJugable {
	
	protected Jugable miJugador;
	
	public BolaDeFuego(Sprite sprite, Point posicion, Visitante visitor, Point velocidadDireccional,
					ObserverGrafico observerGrafico,Jugable jugador) {
		super(sprite, posicion, visitor, observerGrafico);
		this.velocidadDireccional = velocidadDireccional;
		this.miJugador = jugador;
	}
	
	// Metodos
	@Override
	public void aceptarVisitante (Visitante visitante) {
		visitante.visitarBolaDeFuego(this);
	}

	@Override
	public void actualizarSprite(FabricaSprites fabricaSprites) {
		if(this.obtenerRemovido()) {
			this.eliminarEntidadGrafica(fabricaSprites);
			this.eliminarDelNivel();
		}
	}

	public Jugable obtenerJugador() {
		return miJugador;
	}

	
	@Override
	public void mover() {
	}

	@Override
	public void invertirDireccion() {
	}

	@Override
	public void eliminarEntidadGrafica(FabricaSprites fabricaSprites) {
		this.establecerSprite(fabricaSprites.obtenerSpriteInvisible());
		this.obtenerNivel().addEntidadesAEliminar(this);
	}	
}
