package fabricas;
import java.util.Vector;

import elementos.enemigos.PiranhaPlant;
import elementos.plataformas.*;
import elementos.powerUps.*;
import elementos.Sprite;
import observers.ObserverGrafico;
import visitors.Visitante;

public class FabricaPlataformas {

	protected FabricaSprites fabricaSprites;
	protected FabricaEntidades fabricaEntidades;
	
	public FabricaPlataformas(FabricaSprites fabricaSprites) {
		this.fabricaSprites = fabricaSprites;
	}
	
	@SuppressWarnings("exports")
	public Ladrillo getLadrillo(Vector<Integer> posicion, Visitante visitor, int cantidadMonedas) {
		Sprite spriteLadrillo = fabricaSprites.getLadrillo();
		Visitante visitorMoneda=null;
		ObserverGrafico observerMoneda=null;
		Monedas monedasDentroLadrillo= fabricaEntidades.getMonedas(posicion, visitorMoneda, cantidadMonedas,observerMoneda);
		Ladrillo ladrilloADevolver = new Ladrillo(spriteLadrillo, posicion, visitor, monedasDentroLadrillo);
		return ladrilloADevolver;
	}
	
	@SuppressWarnings("exports")
	public Vacio getVacio(Vector<Integer> posicion, Visitante visitor) {
		Sprite spriteVacio = fabricaSprites.getVacio();
		Vacio vacioADevolver = new Vacio(spriteVacio, posicion, visitor);
		return vacioADevolver;
	}
	
	@SuppressWarnings("exports")
	public Plataforma getTuberiaVacia(Vector<Integer> posicion, Visitante visitor, int altura) {
		Sprite spriteTuberia = fabricaSprites.getTuberia(altura);
		PiranhaPlant piranhaPlant=null;
		Tuberia tuberiaADevolver = new Tuberia(spriteTuberia, posicion, visitor, piranhaPlant,altura);
		return tuberiaADevolver;
	}
	
	@SuppressWarnings("exports")
	public Tuberia getTuberiaConPiranhaPlant(Vector<Integer> posicion, Visitante visitor, int altura) {
		Sprite spriteTuberia = fabricaSprites.getTuberia(altura);
		Vector<Integer> direccionPiranhaPlant=new Vector<Integer>(0,1);
		PiranhaPlant piranhaPlant= fabricaEntidades.getPiranhaPlant(posicion, visitor, direccionPiranhaPlant, 1, null);
		Tuberia tuberiaADevolver = new Tuberia(spriteTuberia, posicion, visitor,piranhaPlant,altura);
		return tuberiaADevolver;
	}
	
	@SuppressWarnings("exports")
	public Bandera getBandera(Vector<Integer> posicion, Visitante visitor) {
		Sprite spriteBandera = fabricaSprites.getBandera();
		Bandera banderaADevolver = new Bandera(spriteBandera, posicion, visitor);
		return banderaADevolver;
	}
	
	@SuppressWarnings("exports")
	public PrincesaPeach getPrincesaPeach(Vector<Integer> posicion, Visitante visitor) {
		Sprite spritePrincesaPeach = fabricaSprites.getPrincesaPeach();
		PrincesaPeach princesaPeachADevolver = new PrincesaPeach(spritePrincesaPeach, posicion, visitor);
		return princesaPeachADevolver;
	}
	
	@SuppressWarnings("exports")
	public BloqueDePregunta getBloqueDePreguntaConMonedas(Vector<Integer> posicion, Visitante visitor,int cantidadMonedas){
		Sprite spriteBloqueDePregunta = fabricaSprites.getBloqueDePreguntaEncendido();
		Visitante visitorMoneda=null;
		ObserverGrafico observerMoneda=null;
		Monedas monedasDentroBloqueDePregunta= fabricaEntidades.getMonedas(posicion, visitorMoneda, cantidadMonedas,observerMoneda);
		BloqueDePregunta bloqueDePreguntaADevolver = new BloqueDePregunta(spriteBloqueDePregunta, posicion, visitor, monedasDentroBloqueDePregunta);
		return bloqueDePreguntaADevolver;
	}
	
	@SuppressWarnings("exports")
	public BloqueDePregunta getBloqueDePreguntaSinMonedas(Vector<Integer> posicion, Visitante visitor,int identificadorPowerUp){
		Sprite spriteBloqueDePregunta = fabricaSprites.getBloqueDePreguntaEncendido();
		PowerUp powerUpDentroBloqueDePregunta=null;
		Visitante visitorPowerUp=null;
		int velocidad=1;
		Vector<Integer> direccion= new Vector<Integer>(0,0);
		//La dirección  del power up debe ser contraria a la ubicación de Mario, por lo tanto no se inicializa acá
		ObserverGrafico observerPowerUp=null;
		switch(identificadorPowerUp) {
			case 21:{
				powerUpDentroBloqueDePregunta= fabricaEntidades.getEstrella(posicion, visitorPowerUp,direccion,velocidad,observerPowerUp);
			}
			case 22:{
				powerUpDentroBloqueDePregunta= fabricaEntidades.getChampinionVerde(posicion, visitorPowerUp,observerPowerUp);
			}
			case 23:{
				powerUpDentroBloqueDePregunta= fabricaEntidades.getFlorDeFuego(posicion, visitorPowerUp,observerPowerUp);
			}
			case 24:{
				powerUpDentroBloqueDePregunta= fabricaEntidades.getSuperChampinion(posicion, visitorPowerUp,direccion,velocidad,observerPowerUp);
			}
		}
		
		BloqueDePregunta bloqueDePreguntaADevolver = new BloqueDePregunta(spriteBloqueDePregunta, posicion, visitor, powerUpDentroBloqueDePregunta);
		return bloqueDePreguntaADevolver;
	}
}
