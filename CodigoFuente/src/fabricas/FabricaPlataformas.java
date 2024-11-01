
package fabricas;
import java.awt.Point;
import java.util.Random;
import elementos.enemigos.PiranhaPlant;
import elementos.plataformas.*;
import elementos.powerUps.*;
import juego.Nivel;
import elementos.Sprite;
import observers.ObserverGrafico;
import ventanas.ConstantesGlobales;
import ventanas.ControladorVistas;
import ventanas.PantallaDeJuego;
import visitors.Visitante;
import visitors.VisitorBandera;
import visitors.VisitorBloqueDePregunta;
import visitors.VisitorBloqueSolido;
import visitors.VisitorChampinionVerde;
import visitors.VisitorEstrella;
import visitors.VisitorFlorDeFuego;
import visitors.VisitorLadrillo;
import visitors.VisitorMonedas;
import visitors.VisitorPiranhaPlant;
import visitors.VisitorPiso;
import visitors.VisitorPrincesa;
import visitors.VisitorSuperChampinion;
import visitors.VisitorTuberia;
import visitors.VisitorVacio;

public class FabricaPlataformas {

	protected FabricaSprites fabricaSprites;
	
	protected FabricaEntidades fabricaEntidades;
	
    protected PantallaDeJuego pantallaDeJuego;
	
	public FabricaPlataformas(FabricaSprites fabricaSprites,FabricaEntidades fabricaEntidades,PantallaDeJuego pantallaDeJuego) {
		this.fabricaSprites = fabricaSprites;
		this.fabricaEntidades = fabricaEntidades;
		this.pantallaDeJuego = pantallaDeJuego;
	}
	
	@SuppressWarnings("exports")
	public Vacio obtenerVacio(Point posicion) {
		Sprite spriteVacio = this.fabricaSprites.obtenerVacio();
		Vacio vacioADevolver = new Vacio(spriteVacio, posicion, null, null);
		Visitante visitor = new VisitorVacio(vacioADevolver);
		vacioADevolver.establecerVisitor(visitor);
		ObserverGrafico observerGraficoLadrillo = new ObserverGrafico(vacioADevolver);	   
		vacioADevolver.establecerObserverGrafico(observerGraficoLadrillo);
		this.pantallaDeJuego.agregarLabel(vacioADevolver.obtenerObserverGrafico());
		return vacioADevolver;
	}
	
	@SuppressWarnings("exports")
	public Ladrillo obtenerLadrillo(Point posicion) {
		Sprite spriteLadrillo = this.fabricaSprites.obtenerLadrillo();
		Ladrillo ladrilloADevolver = new Ladrillo(spriteLadrillo, posicion, null, null);
		Visitante visitor = new VisitorLadrillo(ladrilloADevolver);
		ladrilloADevolver.establecerVisitor(visitor);
        ObserverGrafico observerGraficoLadrillo = new ObserverGrafico(ladrilloADevolver);	   
        ladrilloADevolver.establecerObserverGrafico(observerGraficoLadrillo);
        this.pantallaDeJuego.agregarLabel(ladrilloADevolver.obtenerObserverGrafico());
        return ladrilloADevolver;
	}
	
	@SuppressWarnings("exports")
	public Tuberia obtenerTuberiaVacia(Point posicion, int altura) {
		Sprite spriteTuberia = this.fabricaSprites.obtenerTuberia(altura);
		int ancho = 100;
		int alturaEscalada = altura * 50;
		Tuberia tuberiaADevolver = new Tuberia(spriteTuberia, posicion, null, null, alturaEscalada, ancho);
        Visitante visitor = new VisitorTuberia(tuberiaADevolver);
        tuberiaADevolver.establecerVisitor(visitor);
		ObserverGrafico observerGraficoTuberia = new ObserverGrafico(tuberiaADevolver);
		tuberiaADevolver.establecerObserverGrafico(observerGraficoTuberia);
        this.pantallaDeJuego.agregarLabel(tuberiaADevolver.obtenerObserverGrafico());
		return tuberiaADevolver;
	}
	
	
	@SuppressWarnings("exports")
	public Tuberia obtenerTuberiaConPiranhaPlant(Point posicion, Nivel nivel, int altura){
		Sprite spriteTuberia = this.fabricaSprites.obtenerTuberia(altura);
		int ancho = spriteTuberia.obtenerAnchoImagen();
  		int alturaEscalada = altura * 50;
  		PiranhaPlant piranhaPlant= null;
		Tuberia tuberiaADevolver = new Tuberia(spriteTuberia, posicion, null, null, alturaEscalada, ancho);
        Visitante visitorTuberia = new VisitorTuberia(tuberiaADevolver);
        tuberiaADevolver.establecerVisitor(visitorTuberia);
		ObserverGrafico observerGraficoTuberia = new ObserverGrafico(tuberiaADevolver);
		tuberiaADevolver.establecerObserverGrafico(observerGraficoTuberia);
        this.pantallaDeJuego.agregarLabel(tuberiaADevolver.obtenerObserverGrafico());
        int posicionPiranhaX = posicion.x;
        int posicionPiranhaY = posicion.y - spriteTuberia.obtenerAltoImagen() + 150;
       	Point posicionPiranha = new Point(posicionPiranhaX, posicionPiranhaY);
       	piranhaPlant = this.fabricaEntidades.obtenerPiranhaPlant(posicionPiranha, spriteTuberia);
       	nivel.agregarEnemigo(piranhaPlant);
		return tuberiaADevolver;
	}
	
	@SuppressWarnings("exports")
	public Bandera obtenerBandera(Point posicion,ControladorVistas controladorVistas) {
		Sprite spriteBandera = this.fabricaSprites.obtenerBandera();
		Bandera banderaADevolver = new Bandera(spriteBandera, posicion, null, null);
		Visitante visitor = new VisitorBandera(controladorVistas,banderaADevolver);
		banderaADevolver.establecerVisitor(visitor);
		ObserverGrafico observerGraficoBandera = new ObserverGrafico(banderaADevolver);
        banderaADevolver.establecerObserverGrafico(observerGraficoBandera);
        this.pantallaDeJuego.agregarLabel(banderaADevolver.obtenerObserverGrafico());
        return banderaADevolver;
	}
	
	@SuppressWarnings("exports")
	public PrincesaPeach obtenerPrincesaPeach(Point posicion,ControladorVistas controladorVistas) {
		Sprite spritePrincesaPeach = this.fabricaSprites.obtenerPrincesaPeach();
		PrincesaPeach princesaPeachADevolver = new PrincesaPeach(spritePrincesaPeach, posicion, null, null);
		Visitante visitor = new VisitorPrincesa(controladorVistas,princesaPeachADevolver);
		princesaPeachADevolver.establecerVisitor(visitor);
		ObserverGrafico observerGraficoPrincesaPeach = new ObserverGrafico(princesaPeachADevolver);
        princesaPeachADevolver.establecerObserverGrafico(observerGraficoPrincesaPeach);
        this.pantallaDeJuego.agregarLabel(princesaPeachADevolver.obtenerObserverGrafico());
		return princesaPeachADevolver;
	}
	
	@SuppressWarnings("exports")
	public BloqueDePregunta obtenerBloqueDePregunta(Point posicion, Nivel nivel, PantallaDeJuego pantallaDeJuego){
		Sprite spriteBloqueDePregunta = this.fabricaSprites.obtenerBloqueDePreguntaEncendido();
		BloqueDePregunta bloqueDePreguntaADevolver = new BloqueDePregunta(spriteBloqueDePregunta, posicion, null, null, null);
		Visitante visitor = new VisitorBloqueDePregunta(bloqueDePreguntaADevolver);
		bloqueDePreguntaADevolver.establecerVisitor(visitor);
		ObserverGrafico observerGraficoBloqueDePregunta = new ObserverGrafico(bloqueDePreguntaADevolver);	  
		bloqueDePreguntaADevolver.establecerObserverGrafico(observerGraficoBloqueDePregunta);
		Random random = new Random();
		//int identificadorPowerUp = random.nextInt(8) + 1; // Genera un número entre 1 (inclusive) y 8 (inclusive)

		int identificadorPowerUp= 5;
		switch(identificadorPowerUp) {
			case 2,4,6,8: {
				for(int contador = 1; contador <= identificadorPowerUp; contador++) {
					Moneda monedas = this.fabricaEntidades.obtenerMonedas(posicion, true);
					nivel.agregarPowerUp(monedas);
					bloqueDePreguntaADevolver.agregarPowerUp(monedas);
					monedas.establecerBloquePregunta(bloqueDePreguntaADevolver);
				}
				break;
			}
			case 1: {
				Estrella estrella = this.fabricaEntidades.obtenerEstrella(posicion);
				nivel.agregarPowerUp(estrella);
		        bloqueDePreguntaADevolver.agregarPowerUp(estrella);
		        estrella.establecerBloquePregunta(bloqueDePreguntaADevolver);
		        break;
			}
			case 3: {
				ChampinionVerde champinionVerde = this.fabricaEntidades.obtenerChampinionVerde(posicion);
		        nivel.agregarPowerUp(champinionVerde);
		        bloqueDePreguntaADevolver.agregarPowerUp(champinionVerde);
		        champinionVerde.establecerBloquePregunta(bloqueDePreguntaADevolver);
		        break;
			}
			case 5: {
				FlorDeFuego florDeFuego = this.fabricaEntidades.obtenerFlorDeFuego(posicion,fabricaEntidades);
		        nivel.agregarPowerUp(florDeFuego);
		        bloqueDePreguntaADevolver.agregarPowerUp(florDeFuego);
		        florDeFuego.establecerBloquePregunta(bloqueDePreguntaADevolver);
		        break;
			}
			case 7: {
				SuperChampinion superChampinion = this.fabricaEntidades.obtenerSuperChampinion(posicion);
		        nivel.agregarPowerUp(superChampinion);
		        bloqueDePreguntaADevolver.agregarPowerUp(superChampinion);
		        superChampinion.establecerBloquePregunta(bloqueDePreguntaADevolver);
		        break;
			}
		}
        this.pantallaDeJuego.agregarLabel(bloqueDePreguntaADevolver.obtenerObserverGrafico());
		return bloqueDePreguntaADevolver;
	}
	
    @SuppressWarnings("exports")
	public BloqueSolido obtenerBloqueSolido(Point posicion) {
    	Sprite spriteBloqueSolido = this.fabricaSprites.obtenerBloqueSolido();
    	BloqueSolido bloqueSolidoADevolver = new BloqueSolido(spriteBloqueSolido, posicion, null, null);
    	Visitante visitorBloqueSolido = new VisitorBloqueSolido(bloqueSolidoADevolver);
    	bloqueSolidoADevolver.establecerVisitor(visitorBloqueSolido);
    	ObserverGrafico observerGraficoBloqueSolido = new ObserverGrafico(bloqueSolidoADevolver);
    	bloqueSolidoADevolver.establecerObserverGrafico(observerGraficoBloqueSolido);
    	this.pantallaDeJuego.agregarLabel(bloqueSolidoADevolver.obtenerObserverGrafico());
    	return bloqueSolidoADevolver;
    }
    
    @SuppressWarnings("exports")
	public Piso obtenerPiso(Point posicion) {
    	Sprite spritePiso = this.fabricaSprites.obtenerPiso();
    	Piso pisoADevolver = new Piso(spritePiso, posicion, null, null);
    	Visitante visitorPiso = new VisitorPiso(pisoADevolver);
    	pisoADevolver.establecerVisitor(visitorPiso);
    	ObserverGrafico observerGraficoBloqueSolido = new ObserverGrafico(pisoADevolver);
    	pisoADevolver.establecerObserverGrafico(observerGraficoBloqueSolido);
    	this.pantallaDeJuego.agregarLabel(pisoADevolver.obtenerObserverGrafico());
    	return pisoADevolver;
    }
}
