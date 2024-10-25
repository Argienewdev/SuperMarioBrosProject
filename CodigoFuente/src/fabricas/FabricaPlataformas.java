package fabricas;
import java.awt.Point;
import java.util.Random;
import elementos.enemigos.PiranhaPlant;
import elementos.plataformas.*;
import elementos.powerUps.*;
import juego.Nivel;
import elementos.Sprite;
import observers.ObserverGrafico;
import ventanas.PantallaDeJuego;
import visitors.Visitante;
import visitors.VisitorChampinionVerde;
import visitors.VisitorEstrella;
import visitors.VisitorFlorDeFuego;
import visitors.VisitorMonedas;
import visitors.VisitorSuperChampinion;

public class FabricaPlataformas {

	protected static final int VELOCIDAD_HORIZONTAL_POWER_UPS_MOVILES = 2;
	
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
	public BloqueDePregunta getBloqueDePregunta(Point posicion, Visitante visitor, Nivel nivel, PantallaDeJuego pantallaDeJuego){
		Sprite spriteBloqueDePregunta = this.fabricaSprites.getBloqueDePreguntaEncendido();
		BloqueDePregunta bloqueDePreguntaADevolver = null;
		Random random = new Random();
		//int identificadorPowerUp = random.nextInt(8) + 1; // Genera un número entre 1 (inclusive) y 8 (inclusive)
		int identificadorPowerUp = 5;
		
		switch(identificadorPowerUp) {
			case 2,4,6,8: {
				Point velocidadDireccional = new Point(0,0);
				Monedas monedasDentroBloqueDePregunta = this.fabricaEntidades.getMonedas(posicion, null, velocidadDireccional, null, identificadorPowerUp, true);
				Visitante visitorMonedas = new VisitorMonedas(monedasDentroBloqueDePregunta);
				monedasDentroBloqueDePregunta.setVisitor(visitorMonedas);
		        ObserverGrafico observerGraficoMonedas = new ObserverGrafico(monedasDentroBloqueDePregunta);
		        monedasDentroBloqueDePregunta.setObserverGrafico(observerGraficoMonedas);
		        monedasDentroBloqueDePregunta.setNivel(nivel);
				nivel.addPowerUp(monedasDentroBloqueDePregunta);
				pantallaDeJuego.agregarLabel(observerGraficoMonedas);
				bloqueDePreguntaADevolver = new BloqueDePregunta(spriteBloqueDePregunta, posicion, visitor, monedasDentroBloqueDePregunta);
				monedasDentroBloqueDePregunta.setBloquePregunta(bloqueDePreguntaADevolver);
				break;
			}
			case 1: {
				Point velocidadDireccional = new Point(VELOCIDAD_HORIZONTAL_POWER_UPS_MOVILES,0);
				Estrella estrella = this.fabricaEntidades.getEstrella(posicion, null, velocidadDireccional, null);
				Visitante visitorEstrella = new VisitorEstrella(estrella);
				estrella.setVisitor(visitorEstrella);
		        ObserverGrafico observerGraficoEstrella = new ObserverGrafico(estrella);
		        estrella.setObserverGrafico(observerGraficoEstrella);
		        estrella.setNivel(nivel);
		        nivel.addPowerUp(estrella);
		        pantallaDeJuego.agregarLabel(observerGraficoEstrella);
		        bloqueDePreguntaADevolver = new BloqueDePregunta(spriteBloqueDePregunta, posicion, visitor, estrella);
		        estrella.setBloquePregunta(bloqueDePreguntaADevolver);
		        break;
			}
			case 3: {
				Point velocidadDireccional = new Point(VELOCIDAD_HORIZONTAL_POWER_UPS_MOVILES,0);
				ChampinionVerde champinionVerde = this.fabricaEntidades.getChampinionVerde(posicion, null, velocidadDireccional, null);
				Visitante visitorChampinionVerde = new VisitorChampinionVerde(champinionVerde);
				champinionVerde.setVisitor(visitorChampinionVerde);
		        ObserverGrafico observerGraficoChampinionVerde = new ObserverGrafico(champinionVerde);
		        champinionVerde.setObserverGrafico(observerGraficoChampinionVerde);
		        champinionVerde.setNivel(nivel);
		        nivel.addPowerUp(champinionVerde);
		        pantallaDeJuego.agregarLabel(observerGraficoChampinionVerde);
		        bloqueDePreguntaADevolver = new BloqueDePregunta(spriteBloqueDePregunta, posicion, visitor, champinionVerde);
		        champinionVerde.setBloquePregunta(bloqueDePreguntaADevolver);
		        break;
			}
			case 5: {
				Point velocidadDireccional = new Point(VELOCIDAD_HORIZONTAL_POWER_UPS_MOVILES,0);
				FlorDeFuego florDeFuego = this.fabricaEntidades.getFlorDeFuego(posicion, null, velocidadDireccional, null);
				Visitante visitorFlorDeFuego = new VisitorFlorDeFuego(florDeFuego);
				florDeFuego.setVisitor(visitorFlorDeFuego);
		        ObserverGrafico observerGraficoFlorDeFuego = new ObserverGrafico(florDeFuego);
		        florDeFuego.setObserverGrafico(observerGraficoFlorDeFuego);
		        florDeFuego.setNivel(nivel);
		        nivel.addPowerUp(florDeFuego);
		        pantallaDeJuego.agregarLabel(observerGraficoFlorDeFuego);
		        bloqueDePreguntaADevolver = new BloqueDePregunta(spriteBloqueDePregunta, posicion, visitor, florDeFuego);
		        florDeFuego.setBloquePregunta(bloqueDePreguntaADevolver);
		        break;
			}
			case 7: {
				Point velocidadDireccional = new Point(VELOCIDAD_HORIZONTAL_POWER_UPS_MOVILES,0);
				SuperChampinion superChampinion = this.fabricaEntidades.getSuperChampinion(posicion, null, velocidadDireccional, null);
				Visitante visitorSuperChampinion = new VisitorSuperChampinion(superChampinion);
				superChampinion.setVisitor(visitorSuperChampinion);
		        ObserverGrafico observerGraficoSuperChampinion = new ObserverGrafico(superChampinion);
		        superChampinion.setObserverGrafico(observerGraficoSuperChampinion);
		        superChampinion.setNivel(nivel);
		        nivel.addPowerUp(superChampinion);
		        pantallaDeJuego.agregarLabel(observerGraficoSuperChampinion);
		        bloqueDePreguntaADevolver = new BloqueDePregunta(spriteBloqueDePregunta, posicion, visitor, superChampinion);
		        superChampinion.setBloquePregunta(bloqueDePreguntaADevolver);
		        break;
			}
		}
		
		return bloqueDePreguntaADevolver;
	}
	
	// TODO IMPLEMENTAR
    @SuppressWarnings("exports")
	public BloqueSolido getBloqueSolido(Point posicion, Visitante visitor) {
    	Sprite spriteBloqueSolido = this.fabricaSprites.getBloqueSolido();
    	BloqueSolido bloqueSolidoADevolver = new BloqueSolido(spriteBloqueSolido, posicion, visitor);
		return bloqueSolidoADevolver;
    }
    
    @SuppressWarnings("exports")
	public Piso getPiso(Point posicion, Visitante visitor) {
    	Sprite spritePiso = this.fabricaSprites.getPiso();
    	Piso pisoADevolver = new Piso(spritePiso, posicion, visitor);
    	return pisoADevolver;
    }
	
}
