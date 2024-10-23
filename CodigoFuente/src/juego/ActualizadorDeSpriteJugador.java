
package juego;

import java.awt.Point;

import elementos.Sprite;
import fabricas.FabricaSprites;
import fabricas.FabricaSpritesModoOriginal;

public class ActualizadorDeSpriteJugador {
	
	private FabricaSprites fabricaSprites;
	
	public ActualizadorDeSpriteJugador(FabricaSprites fabricaSprites) {
		this.fabricaSprites = fabricaSprites;
	}
	
	public Sprite actualizar(Point velocidad) {
		Sprite aRetornar = null;
		int velocidadHorizontal = velocidad.x;
		int velocidadVertical = velocidad.y;
		if(enElAire(velocidadVertical) && avanzando(velocidadHorizontal)) {
			aRetornar = fabricaSprites.getMarioDefaultFrontalSaltando();
		} else if(enElAire(velocidadVertical)) {
			aRetornar = fabricaSprites.getMarioDefaultReversoSaltando();
		} else if(avanzando(velocidadHorizontal)) {
			aRetornar = fabricaSprites.getMarioDefaultFrontalCaminandoPrimeraTransicion();
		} else if(retrocediendo(velocidadHorizontal)){
			aRetornar = fabricaSprites.getMarioDefaultReversoCaminandoPrimeraTransicion();
		} else {
			aRetornar = fabricaSprites.getMarioDefaultFrontalQuieto();
		}
		return aRetornar;
	}
	
	public Sprite obtenerSpriteInicial() {
		return fabricaSprites.getMarioDefaultFrontalQuieto();
	}
	
	private boolean enElAire(int velocidadVertical) {
		return velocidadVertical != 0;
	}
	
	private boolean avanzando(int velocidadHorizontal) {
		return velocidadHorizontal > 0;
	}
	
	private boolean retrocediendo(int velocidadHorizontal) {
		return velocidadHorizontal < 0;
	}
	
}
