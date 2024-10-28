package fabricas;
import java.awt.Point;
import java.util.Random;
import elementos.enemigos.PiranhaPlant;
import elementos.plataformas.*;
import elementos.powerUps.*;
import juego.Nivel;
import elementos.Sprite;
import observers.ObserverGrafico;
import ventanas.ControladorVistas;
import ventanas.PantallaDeJuego;
import visitors.Visitante;
import visitors.VisitorBandera;
import visitors.VisitorBloqueDePregunta;
import visitors.VisitorBloqueSolido;
import visitors.VisitorLadrillo;
import visitors.VisitorPiso;
import visitors.VisitorPrincesa;
import visitors.VisitorTuberia;

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
	public Ladrillo getLadrillo(Point posicion) {
		Sprite spriteLadrillo = this.fabricaSprites.getLadrillo();
		Ladrillo ladrilloADevolver = new Ladrillo(spriteLadrillo, posicion, null, null);
		Visitante visitor = new VisitorLadrillo(ladrilloADevolver);
		ladrilloADevolver.setVisitor(visitor);
        ObserverGrafico observerGraficoLadrillo = new ObserverGrafico(ladrilloADevolver);	   
        ladrilloADevolver.setObserverGrafico(observerGraficoLadrillo);
        this.pantallaDeJuego.agregarLabel(ladrilloADevolver.getObserverGrafico());
        return ladrilloADevolver;
	}
	
	@SuppressWarnings("exports")
	public Tuberia getTuberiaVacia(Point posicion, int altura) {
		Sprite spriteTuberia = this.fabricaSprites.getTuberia(altura);
		int ancho = 100;
		int alturaEscalada = altura * 50;
		PiranhaPlant piranhaPlant = null;
		Tuberia tuberiaADevolver = new Tuberia(spriteTuberia, posicion, null, null, piranhaPlant, alturaEscalada, ancho);
        Visitante visitor = new VisitorTuberia(tuberiaADevolver);
        tuberiaADevolver.setVisitor(visitor);
		ObserverGrafico observerGraficoTuberia = new ObserverGrafico(tuberiaADevolver);
		tuberiaADevolver.setObserverGrafico(observerGraficoTuberia);
        this.pantallaDeJuego.agregarLabel(tuberiaADevolver.getObserverGrafico());
		return tuberiaADevolver;
	}
	
	
	@SuppressWarnings("exports")
	public Tuberia getTuberiaConPiranhaPlant(Point posicion, int altura){
		Sprite spriteTuberia = this.fabricaSprites.getTuberia(altura);
		int ancho = 100;
		int alturaEscalada=altura*50;
		PiranhaPlant piranhaPlant = this.fabricaEntidades.getPiranhaPlant(posicion);
		Tuberia tuberiaADevolver = new Tuberia(spriteTuberia, posicion, null, null, piranhaPlant, alturaEscalada, ancho);
        Visitante visitorTuberia = new VisitorTuberia(tuberiaADevolver);
        tuberiaADevolver.setVisitor(visitorTuberia);
		ObserverGrafico observerGraficoTuberia = new ObserverGrafico(tuberiaADevolver);
		tuberiaADevolver.setObserverGrafico(observerGraficoTuberia);
        this.pantallaDeJuego.agregarLabel(tuberiaADevolver.getObserverGrafico());
		return tuberiaADevolver;
	}
	
	@SuppressWarnings("exports")
	public Bandera getBandera(Point posicion,ControladorVistas controladorVistas) {
		Sprite spriteBandera = this.fabricaSprites.getBandera();
		Bandera banderaADevolver = new Bandera(spriteBandera, posicion, null, null);
		Visitante visitor = new VisitorBandera(controladorVistas,banderaADevolver);
		banderaADevolver.setVisitor(visitor);
		ObserverGrafico observerGraficoBandera = new ObserverGrafico(banderaADevolver);
        banderaADevolver.setObserverGrafico(observerGraficoBandera);
        this.pantallaDeJuego.agregarLabel(banderaADevolver.getObserverGrafico());
        return banderaADevolver;
	}
	
	@SuppressWarnings("exports")
	public PrincesaPeach getPrincesaPeach(Point posicion,ControladorVistas controladorVistas) {
		Sprite spritePrincesaPeach = this.fabricaSprites.getPrincesaPeach();
		PrincesaPeach princesaPeachADevolver = new PrincesaPeach(spritePrincesaPeach, posicion, null, null);
		Visitante visitor = new VisitorPrincesa(controladorVistas,princesaPeachADevolver);
		princesaPeachADevolver.setVisitor(visitor);
		ObserverGrafico observerGraficoPrincesaPeach = new ObserverGrafico(princesaPeachADevolver);
        princesaPeachADevolver.setObserverGrafico(observerGraficoPrincesaPeach);
        this.pantallaDeJuego.agregarLabel(princesaPeachADevolver.getObserverGrafico());
		return princesaPeachADevolver;
	}
	
	@SuppressWarnings("exports")
	public BloqueDePregunta getBloqueDePregunta(Point posicion, Nivel nivel, PantallaDeJuego pantallaDeJuego){
		Sprite spriteBloqueDePregunta = this.fabricaSprites.getBloqueDePreguntaEncendido();
		BloqueDePregunta bloqueDePreguntaADevolver = new BloqueDePregunta(spriteBloqueDePregunta, posicion, null, null, null);
		Visitante visitor = new VisitorBloqueDePregunta(bloqueDePreguntaADevolver);
		bloqueDePreguntaADevolver.setVisitor(visitor);
		ObserverGrafico observerGraficoBloqueDePregunta = new ObserverGrafico(bloqueDePreguntaADevolver);	  
		bloqueDePreguntaADevolver.setObserverGrafico(observerGraficoBloqueDePregunta);
		Random random = new Random();
		int identificadorPowerUp = random.nextInt(8) + 1; // Genera un número entre 1 (inclusive) y 8 (inclusive)
		//int identificadorPowerUp = 1;
		
		switch(identificadorPowerUp) {
			case 2,4,6,8: {
				Monedas monedasDentroBloqueDePregunta = this.fabricaEntidades.getMonedas(posicion, identificadorPowerUp, true);
				nivel.addPowerUp(monedasDentroBloqueDePregunta);
				pantallaDeJuego.agregarLabel(monedasDentroBloqueDePregunta.getObserverGrafico());
				bloqueDePreguntaADevolver.setPowerUp(monedasDentroBloqueDePregunta);
				monedasDentroBloqueDePregunta.setBloquePregunta(bloqueDePreguntaADevolver);
				break;
			}
			case 1: {
				Estrella estrella = this.fabricaEntidades.getEstrella(posicion);
				nivel.addPowerUp(estrella);
		        pantallaDeJuego.agregarLabel(estrella.getObserverGrafico());
		        bloqueDePreguntaADevolver.setPowerUp(estrella);
		        estrella.setBloquePregunta(bloqueDePreguntaADevolver);
		        break;
			}
			case 3: {
				ChampinionVerde champinionVerde = this.fabricaEntidades.getChampinionVerde(posicion);
		        nivel.addPowerUp(champinionVerde);
		        pantallaDeJuego.agregarLabel(champinionVerde.getObserverGrafico());
		        bloqueDePreguntaADevolver.setPowerUp(champinionVerde);
		        champinionVerde.setBloquePregunta(bloqueDePreguntaADevolver);
		        break;
			}
			case 5: {
				FlorDeFuego florDeFuego = this.fabricaEntidades.getFlorDeFuego(posicion,fabricaEntidades);
		        nivel.addPowerUp(florDeFuego);
		        pantallaDeJuego.agregarLabel(florDeFuego.getObserverGrafico());
		        bloqueDePreguntaADevolver.setPowerUp(florDeFuego);
		        florDeFuego.setBloquePregunta(bloqueDePreguntaADevolver);
		        break;
			}
			case 7: {
				SuperChampinion superChampinion = this.fabricaEntidades.getSuperChampinion(posicion);
		        nivel.addPowerUp(superChampinion);
		        pantallaDeJuego.agregarLabel(superChampinion.getObserverGrafico());
		        bloqueDePreguntaADevolver.setPowerUp(superChampinion);
		        superChampinion.setBloquePregunta(bloqueDePreguntaADevolver);
		        break;
			}
		}
        this.pantallaDeJuego.agregarLabel(bloqueDePreguntaADevolver.getObserverGrafico());
		return bloqueDePreguntaADevolver;
	}
	
	// TODO IMPLEMENTAR
    @SuppressWarnings("exports")
	public BloqueSolido getBloqueSolido(Point posicion) {
    	Sprite spriteBloqueSolido = this.fabricaSprites.getBloqueSolido();
    	BloqueSolido bloqueSolidoADevolver = new BloqueSolido(spriteBloqueSolido, posicion, null, null);
    	Visitante visitorBloqueSolido = new VisitorBloqueSolido(bloqueSolidoADevolver);
    	bloqueSolidoADevolver.setVisitor(visitorBloqueSolido);
    	ObserverGrafico observerGraficoBloqueSolido = new ObserverGrafico(bloqueSolidoADevolver);
    	bloqueSolidoADevolver.setObserverGrafico(observerGraficoBloqueSolido);
    	this.pantallaDeJuego.agregarLabel(bloqueSolidoADevolver.getObserverGrafico());
    	return bloqueSolidoADevolver;
    }
    
    @SuppressWarnings("exports")
	public Piso getPiso(Point posicion) {
    	Sprite spritePiso = this.fabricaSprites.getPiso();
    	Piso pisoADevolver = new Piso(spritePiso, posicion, null, null);
    	Visitante visitorPiso = new VisitorPiso(pisoADevolver);
    	pisoADevolver.setVisitor(visitorPiso);
    	ObserverGrafico observerGraficoBloqueSolido = new ObserverGrafico(pisoADevolver);
    	pisoADevolver.setObserverGrafico(observerGraficoBloqueSolido);
    	this.pantallaDeJuego.agregarLabel(pisoADevolver.getObserverGrafico());
    	return pisoADevolver;
    }
	
}
