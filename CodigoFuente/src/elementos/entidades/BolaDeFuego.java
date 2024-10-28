package elementos.entidades;

import java.awt.Point;
import elementos.Sprite;
import fabricas.FabricaSprites;
import observers.ObserverGrafico;
import visitors.Visitante;

public class BolaDeFuego extends NoJugable {
	
	protected Jugable miJugador;
	
	public BolaDeFuego(Sprite sprite, Point posicion, Visitante visitor,
					ObserverGrafico observerGrafico,Jugable jugador) {
		super(sprite, posicion, visitor, observerGrafico);
		this.miJugador = jugador;
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
	
	public void eliminarEntidadGrafica(FabricaSprites fabricaSprites) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void moverDerecha() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void moverIzquierda() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void invertirDireccion() {
		// TODO Auto-generated method stub
		
	}
	
}
