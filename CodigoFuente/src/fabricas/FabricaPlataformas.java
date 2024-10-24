package fabricas;
import java.awt.Point;
import java.util.Random;

import elementos.enemigos.PiranhaPlant;
import elementos.plataformas.*;
import elementos.powerUps.*;
import juego.Nivel;
import elementos.Sprite;
import observers.ObserverGrafico;
import visitors.Visitante;
import visitors.VisitorChampinionVerde;
import visitors.VisitorEstrella;
import visitors.VisitorFlorDeFuego;
import visitors.VisitorMonedas;
import visitors.VisitorSuperChampinion;

public class FabricaPlataformas {

	protected FabricaSprites fabricaSprites;
	
	protected FabricaEntidades fabricaEntidades;
	
	public FabricaPlataformas(FabricaSprites fabricaSprites,FabricaEntidades fabricaEntidades) {
		this.fabricaSprites = fabricaSprites;
		this.fabricaEntidades = fabricaEntidades;
	}
	
	@SuppressWarnings("exports")
	public Ladrillo getLadrillo(Point posicion, Visitante visitor) {
		Sprite spriteLadrillo = this.fabricaSprites.getLadrillo();
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
	public Tuberia getTuberiaVacia(Point posicion, Visitante visitor, int altura, int ancho) {
		Sprite spriteTuberia = this.fabricaSprites.getTuberia(altura);
		PiranhaPlant piranhaPlant = null;
		Tuberia tuberiaADevolver = new Tuberia(spriteTuberia, posicion, visitor, piranhaPlant, altura, ancho);
		return tuberiaADevolver;
	}
	
	
	@SuppressWarnings("exports")
	public Tuberia getTuberiaConPiranhaPlant(Point posicion, Visitante visitor, int altura, int ancho) {
		Sprite spriteTuberia = this.fabricaSprites.getTuberia(altura);
		Point direccionPiranhaPlant = new Point(0,1);
		PiranhaPlant piranhaPlant = this.fabricaEntidades.getPiranhaPlant(posicion, visitor, direccionPiranhaPlant, null);
		Tuberia tuberiaADevolver = new Tuberia(spriteTuberia, posicion, visitor, piranhaPlant, altura, ancho);
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
	public BloqueDePregunta getBloqueDePregunta(Point posicion, Visitante visitor, Nivel nivel){
		Sprite spriteBloqueDePregunta = this.fabricaSprites.getBloqueDePreguntaEncendido();
		BloqueDePregunta bloqueDePreguntaADevolver = null;
		Random random = new Random();
		int identificadorPowerUp = random.nextInt(8) + 1; // Genera un número entre 1 (inclusive) y 8 (inclusive)
		
		switch(identificadorPowerUp) {
			case 2,4,6,8: {
				Point velocidadDireccional = new Point(0,0);
				Monedas monedasDentroBloqueDePregunta = this.fabricaEntidades.getMonedas(posicion, null, velocidadDireccional, null, identificadorPowerUp, true, false);
				Visitante visitorMonedas = new VisitorMonedas(monedasDentroBloqueDePregunta);
				monedasDentroBloqueDePregunta.setVisitor(visitorMonedas);
		        ObserverGrafico observerGraficoMonedas = new ObserverGrafico(monedasDentroBloqueDePregunta);
		        monedasDentroBloqueDePregunta.setObserverGrafico(observerGraficoMonedas);
				nivel.addPowerUp(monedasDentroBloqueDePregunta);
				bloqueDePreguntaADevolver = new BloqueDePregunta(spriteBloqueDePregunta, posicion, visitor, monedasDentroBloqueDePregunta);
				break;
			}
			case 1: {
				Point velocidadDireccional = new Point(0,1);
				Estrella powerUp = this.fabricaEntidades.getEstrella(posicion, null, velocidadDireccional, null);
				Visitante visitorEstrella = new VisitorEstrella(powerUp);
				powerUp.setVisitor(visitorEstrella);
		        ObserverGrafico observerGraficoEstrella = new ObserverGrafico(powerUp);
		        powerUp.setObserverGrafico(observerGraficoEstrella);
		        bloqueDePreguntaADevolver = new BloqueDePregunta(spriteBloqueDePregunta, posicion, visitor, powerUp);
		        break;
			}
			case 3: {
				Point velocidadDireccional = new Point(0,1);
				ChampinionVerde powerUp = this.fabricaEntidades.getChampinionVerde(posicion, null, velocidadDireccional, null);
				Visitante visitorChampinionVerde = new VisitorChampinionVerde(powerUp);
				powerUp.setVisitor(visitorChampinionVerde);
		        ObserverGrafico observerGraficoChampinionVerde = new ObserverGrafico(powerUp);
		        powerUp.setObserverGrafico(observerGraficoChampinionVerde);
		        bloqueDePreguntaADevolver = new BloqueDePregunta(spriteBloqueDePregunta, posicion, visitor, powerUp);
		        break;
			}
			case 5: {
				Point velocidadDireccional = new Point(0,1);
				FlorDeFuego powerUp = this.fabricaEntidades.getFlorDeFuego(posicion, null, velocidadDireccional, null);
				Visitante visitorFlorDeFuego = new VisitorFlorDeFuego(powerUp);
				powerUp.setVisitor(visitorFlorDeFuego);
		        ObserverGrafico observerGraficoFlorDeFuego = new ObserverGrafico(powerUp);
		        powerUp.setObserverGrafico(observerGraficoFlorDeFuego);
		        bloqueDePreguntaADevolver = new BloqueDePregunta(spriteBloqueDePregunta, posicion, visitor, powerUp);
		        break;
			}
			case 7: {
				Point velocidadDireccional = new Point(0,1);
				SuperChampinion powerUp = this.fabricaEntidades.getSuperChampinion(posicion, null, velocidadDireccional, null);
				Visitante visitorSuperChampinion = new VisitorSuperChampinion(powerUp);
				powerUp.setVisitor(visitorSuperChampinion);
		        ObserverGrafico observerGraficoSuperChampinion = new ObserverGrafico(powerUp);
		        powerUp.setObserverGrafico(observerGraficoSuperChampinion);
		        nivel.addPowerUp(powerUp);
		        bloqueDePreguntaADevolver = new BloqueDePregunta(spriteBloqueDePregunta, posicion, visitor, powerUp);
		        break;
			}
		}
		
		return bloqueDePreguntaADevolver;
	}
	
	// TODO IMPLEMENTAR
    @SuppressWarnings("exports")
	public BloqueSolido getBloqueSolido(Point posicion, Visitante visitor) {
    	Sprite spriteBloqueSolido = this.fabricaSprites.getBloqueSolido();
		Ladrillo bloqueSolidoADevolver = new Ladrillo(spriteBloqueSolido, posicion, visitor);
		return bloqueSolidoADevolver;
    }
    
    public Piso getPiso(Point posicion, Visitante visitor) {
    	Sprite spritePiso = this.fabricaSprites.getPiso();
    	Piso pisoADevolver = new Piso(spritePiso, posicion, visitor);
    	return pisoADevolver;
    }
	
}
