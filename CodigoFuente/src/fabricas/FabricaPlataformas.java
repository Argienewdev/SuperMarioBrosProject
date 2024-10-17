package fabricas;
import java.util.Vector;

import elementos.*;
import elementos.plataformas.*;
import elementos.powerUps.Monedas;
import visitors.Visitante;

public class FabricaPlataformas {

	protected FabricaSprites fabricaSprites;
	
	public FabricaPlataformas(FabricaSprites fabricaSprites) {
		this.fabricaSprites = fabricaSprites;
	}
	
	public Ladrillo getLadrillo(Vector<Integer> posicion, Visitante visitor, int cantidadMonedas) {
		Sprite spriteLadrillo = fabricaSprites.getLadrillo();
		//Tengo que crear una Coleccion de mondeas con la cantidad pasada por parametro
		
		Ladrillo ladrilloADevolver = new Ladrillo(spriteLadrillo, posicion, visitor, cantidadMonedas);
		return ladrilloADevolver;
	}
	public Vacio getVacio(Vector<Integer> posicion, Visitante visitor) {
		Sprite spriteVacio = fabricaSprites.getVacio();
		Vacio vacioADevolver = new Vacio(spriteVacio, posicion, visitor);
		return vacioADevolver;
	}
	public Bandera getBandera(Vector<Integer> posicion, Visitante visitor) {
		Sprite spriteBandera = fabricaSprites.getBandera();
		Bandera banderaADevolver = new Bandera(spriteBandera, posicion, visitor);
		return banderaADevolver;
	}
	public PrincesaPeach getPrincesaPeach(Vector<Integer> posicion, Visitante visitor) {
		Sprite spritePrincesaPeach = fabricaSprites.getPrincesaPeach();
		PrincesaPeach princesaPeachADevolver = new PrincesaPeach(spritePrincesaPeach, posicion, visitor);
		return princesaPeachADevolver;
	}
	

>>>>>>> 154755ff046504fb6667aad0653081a42363ebe9
}
