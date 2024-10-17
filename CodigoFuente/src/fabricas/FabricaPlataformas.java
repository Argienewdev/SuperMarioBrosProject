package fabricas;
import java.util.Vector;

import elementos.*;
import elementos.plataformas.Ladrillo;
import visitors.Visitante;

public class FabricaPlataformas {

	protected FabricaSprites fabricaSprites;
	
	public FabricaPlataformas(FabricaSprites fabricaSprites) {
		this.fabricaSprites = fabricaSprites;
	}
	
	public Ladrillo getLadrillo(Vector<Integer> posicion, Visitante visitor) {
		Sprite spriteLadrillo = fabricaSprites.getLadrillo();
		Ladrillo ladrilloADevolver = new Ladrillo(spriteLadrillo, posicion, visitor);
		return ladrilloADevolver;
	}
	
}
