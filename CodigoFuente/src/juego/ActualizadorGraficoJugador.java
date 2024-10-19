
package juego;

import java.awt.Point;

import elementos.Sprite;
import fabricas.FabricaSprites;
import fabricas.FabricaSpritesModoOriginal;

public class ActualizadorGraficoJugador {
	
	private FabricaSprites fabricaSprites;
	
	public ActualizadorGraficoJugador() {
		//TODO quien crea las fabricas?
		fabricaSprites = new FabricaSpritesModoOriginal("src\\imagenes");
	}
	
	public Sprite actualizar(Sprite posicionPrevia, Point velocidad) {
		Sprite aRetornar;
		int velocidadHorizontal = velocidad.x;
		int velocidadVertical = velocidad.y;
		if(enElAire(velocidadVertical) && avanzando(velocidadHorizontal)) {
			aRetornar = fabricaSprites.getMarioDefaultFrontalSaltando();
		}else if(enElAire(velocidadVertical)) {
			aRetornar = fabricaSprites.getMarioDefaultReversoSaltando();
		}else if(avanzando(velocidadHorizontal)) {
			aRetornar = fabricaSprites.getMarioDefaultFrontalCaminandoPrimeraTransicion();
		}else {
			aRetornar = fabricaSprites.getMarioDefaultReversoCaminandoPrimeraTransicion();
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
