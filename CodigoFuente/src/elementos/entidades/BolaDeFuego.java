package elementos.entidades;

import java.awt.Point;
import elementos.Sprite;
import fabricas.FabricaSprites;
import observers.ObserverGrafico;
import visitors.Visitante;

public class BolaDeFuego extends NoJugable {
	
	protected Jugable miJugador;
	
	public BolaDeFuego(Sprite sprite, Point posicion, Visitante visitor,
					Point velocidadDireccional,
					ObserverGrafico observerGrafico,Jugable jugador) {
		super(sprite, posicion, visitor, velocidadDireccional, observerGrafico);
		this.miJugador=jugador;
	}
	
	// Metodos
	@Override
	public void aceptarVisitante (Visitante visitante) {
		visitante.visitarBolaDeFuego(this);
	}

	@Override
	public void actualizarSprite(FabricaSprites fabricaSprites) {
		// TODO Auto-generated method stub
		// Segun su velocidad direccional actualizar el sprite
	}

	public void eliminarDelNivel() {
		//TODO
	}

	public Jugable obtenerJugador() {
		return miJugador;
	}
	
	@Override
	public void elminarEntidadGraficamente(FabricaSprites fabricaSprites) {
		// TODO Auto-generated method stub
		
	}
	
}
