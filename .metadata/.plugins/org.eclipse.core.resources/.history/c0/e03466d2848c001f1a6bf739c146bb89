package fabricas;

import juego.Silueta;

public class FabricaSilueta {

	protected FabricaSprites fabricaSprites;
	
	public FabricaSilueta(FabricaSprites fabricaSprites) {
		this.fabricaSprites=fabricaSprites;
	}
	
	public Silueta getSilueta(int numNivel) {
		Sprite spriteSilueta = fabricaSprites.getSilueta(numNivel);
		Silueta silueta = new Silueta(spriteSilueta);
		return silueta;
	}
	
}
