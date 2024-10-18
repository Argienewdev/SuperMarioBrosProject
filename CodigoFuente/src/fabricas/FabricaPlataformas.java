package fabricas;
import java.awt.Point;
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
	public Ladrillo getLadrillo(Point posicion, Visitante visitor, int cantidadMonedas) {
		Sprite spriteLadrillo = this.fabricaSprites.getLadrillo();
		Visitante visitorMoneda = null;
		ObserverGrafico observerMoneda = null;
		Point direccion = new Point (0,0);
		Monedas monedasDentroLadrillo = this.fabricaEntidades.getMonedas(posicion, visitorMoneda,direccion, cantidadMonedas, observerMoneda);
		Ladrillo ladrilloADevolver = new Ladrillo(spriteLadrillo, posicion, visitor);
		return ladrilloADevolver;
	}
	
	@SuppressWarnings("exports")
	public Vacio getVacio(Point posicion, Visitante visitor) {
		Sprite spriteVacio = this.fabricaSprites.getVacio();
		Vacio vacioADevolver = new Vacio(spriteVacio, posicion, visitor);
		return vacioADevolver;
	}
	
	@SuppressWarnings("exports")
	public Plataforma getTuberiaVacia(Point posicion, Visitante visitor, int ancho, int altura) {
		Sprite spriteTuberia = this.fabricaSprites.getTuberia(altura);
		PiranhaPlant piranhaPlant = null;
		Tuberia tuberiaADevolver = new Tuberia(spriteTuberia, posicion, visitor, piranhaPlant,ancho, altura);
		return tuberiaADevolver;
	}
	
	
	@SuppressWarnings("exports")
	public Tuberia getTuberiaConPiranhaPlant(Point posicion, Visitante visitor, int altura) {
		Sprite spriteTuberia = this.fabricaSprites.getTuberia(altura);
		Point direccionPiranhaPlant = new Point(0,1);
		PiranhaPlant piranhaPlant = this.fabricaEntidades.getPiranhaPlant(posicion, visitor, direccionPiranhaPlant, 1, null);
		Tuberia tuberiaADevolver = new Tuberia(spriteTuberia, posicion, visitor, piranhaPlant, altura);
		return tuberiaADevolver;
	}
	
	@SuppressWarnings("exports")
	public Bandera getBandera(Point posicion, Visitante visitor) {
		Sprite spriteBandera = this.fabricaSprites.getBandera();
		Bandera banderaADevolver = new Bandera(spriteBandera, posicion, visitor);
		return banderaADevolver;
	}
	
	@SuppressWarnings("exports")
	public PrincesaPeach getPrincesaPeach(Point posicion, Visitante visitor) {
		Sprite spritePrincesaPeach = this.fabricaSprites.getPrincesaPeach();
		PrincesaPeach princesaPeachADevolver = new PrincesaPeach(spritePrincesaPeach, posicion, visitor);
		return princesaPeachADevolver;
	}
	
	@SuppressWarnings("exports")
	public BloqueDePregunta getBloqueDePreguntaConMonedas(Point posicion, Visitante visitor,int cantidadMonedas){
		Sprite spriteBloqueDePregunta = this.fabricaSprites.getBloqueDePreguntaEncendido();
		Visitante visitorMoneda = null;
		ObserverGrafico observerMoneda = null;
		Monedas monedasDentroBloqueDePregunta = this.fabricaEntidades.getMonedas(posicion, visitorMoneda, cantidadMonedas, observerMoneda);
		BloqueDePregunta bloqueDePreguntaADevolver = new BloqueDePregunta(spriteBloqueDePregunta, posicion, visitor, monedasDentroBloqueDePregunta);
		return bloqueDePreguntaADevolver;
	}
	
	@SuppressWarnings("exports")
	public BloqueDePregunta getBloqueDePreguntaSinMonedas(Point posicion, Visitante visitor,int identificadorPowerUp){
		Sprite spriteBloqueDePregunta = this.fabricaSprites.getBloqueDePreguntaEncendido();
		PowerUp powerUpDentroBloqueDePregunta = null;
		Visitante visitorPowerUp = null;
		int velocidad = 1;
		Point direccion = new Point(0,0);
		//La dirección  del power up debe ser contraria a la ubicación de Mario, por lo tanto no se inicializa acá
		ObserverGrafico observerPowerUp = null;
		
		switch(identificadorPowerUp) {
			case 21:{
				powerUpDentroBloqueDePregunta = this.fabricaEntidades.getEstrella(posicion, visitorPowerUp, direccion, velocidad, observerPowerUp);
			}
			case 22:{
				powerUpDentroBloqueDePregunta = this.fabricaEntidades.getChampinionVerde(posicion, visitorPowerUp, observerPowerUp);
			}
			case 23:{
				powerUpDentroBloqueDePregunta = this.fabricaEntidades.getFlorDeFuego(posicion, visitorPowerUp, observerPowerUp);
			}
			case 24:{
				powerUpDentroBloqueDePregunta = this.fabricaEntidades.getSuperChampinion(posicion, visitorPowerUp, direccion, velocidad, observerPowerUp);
			}
		}
		
		BloqueDePregunta bloqueDePreguntaADevolver = new BloqueDePregunta(spriteBloqueDePregunta, posicion, visitor, powerUpDentroBloqueDePregunta);
		
		return bloqueDePreguntaADevolver;
	}
	
}
