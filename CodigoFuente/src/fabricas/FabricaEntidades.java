package fabricas;
import java.awt.Point;
import elementos.*;
import observers.ObserverGrafico;
import ventanas.PantallaDeJuego;
import visitors.Visitante;
import visitors.VisitorBolaDeFuego;
import visitors.VisitorBuzzyBeetle;
import visitors.VisitorChampinionVerde;
import visitors.VisitorContextoKoopaTroopa;
import visitors.VisitorContextoMario;
import visitors.VisitorEstrella;
import visitors.VisitorFlorDeFuego;
import visitors.VisitorGoomba;
import visitors.VisitorLakitu;
import visitors.VisitorMonedas;
import visitors.VisitorPiranhaPlant;
import visitors.VisitorSpiny;
import visitors.VisitorSuperChampinion;
import elementos.enemigos.*;
import elementos.entidades.BolaDeFuego;
import elementos.entidades.Jugable;
import elementos.personajes.ContextoMario;
import elementos.personajes.MarioDefault;
import elementos.powerUps.*;

public class FabricaEntidades {
    
    protected FabricaSprites fabricaSprites;
    
    protected PantallaDeJuego pantallaDeJuego;

	protected static final int VELOCIDAD_HORIZONTAL_POWER_UPS_MOVILES = 2;
    
    public FabricaEntidades(FabricaSprites fabricaSprites,PantallaDeJuego pantallaDeJuego) {
        this.fabricaSprites = fabricaSprites;
        this.pantallaDeJuego = pantallaDeJuego;
    }
    
    @SuppressWarnings("exports")
	public Spiny getSpiny(Point posicion) {
    	Sprite sprite = fabricaSprites.getSpinyCayendo();
        Spiny spinyADevolver= new Spiny(sprite, posicion, null, null);
        Visitante visitorSpiny = new VisitorSpiny(spinyADevolver);
        spinyADevolver.establecerVisitor(visitorSpiny);
        ObserverGrafico observerGraficoSpiny = new ObserverGrafico(spinyADevolver);
        spinyADevolver.establecerObserverGrafico(observerGraficoSpiny);
        this.pantallaDeJuego.agregarLabel(spinyADevolver.obtenerObserverGrafico());
        return spinyADevolver;
    }
    
    @SuppressWarnings("exports")
	public ContextoKoopaTroopa getContextoKoopaTroopa(Point posicion) {
    	Sprite sprite = fabricaSprites.getKoopaTroopaDefaultReversoCaminando();
    	KoopaDefault estadoInicial= new KoopaDefault();
        ContextoKoopaTroopa koopaADevolver = new ContextoKoopaTroopa(sprite, posicion, null, null, estadoInicial);
        Visitante visitorContextoKoopaTroopa = new VisitorContextoKoopaTroopa(koopaADevolver);
        koopaADevolver.establecerVisitor(visitorContextoKoopaTroopa);
        ObserverGrafico observerGraficoKoopa = new ObserverGrafico(koopaADevolver);
        koopaADevolver.establecerObserverGrafico(observerGraficoKoopa);
        this.pantallaDeJuego.agregarLabel(koopaADevolver.obtenerObserverGrafico());
    	return koopaADevolver;
    }
       
	@SuppressWarnings("exports")
	public PiranhaPlant getPiranhaPlant(Point posicion) {
        Sprite sprite = fabricaSprites.getPiranhaPlant();
        PiranhaPlant piranhaADevolver=new PiranhaPlant(sprite,posicion, null, null);
        Visitante visitorPiranha = new VisitorPiranhaPlant(piranhaADevolver);
        piranhaADevolver.establecerVisitor(visitorPiranha);
		ObserverGrafico observerGraficoPiranha = new ObserverGrafico(piranhaADevolver);
		piranhaADevolver.establecerObserverGrafico(observerGraficoPiranha);
		this.pantallaDeJuego.agregarLabel(piranhaADevolver.obtenerObserverGrafico());
        return piranhaADevolver;
    }
    
    @SuppressWarnings("exports")
	public Lakitu getLakitu(Point posicion, FabricaEntidades fabricaEntidades) {
        Sprite sprite = fabricaSprites.getLakituReversoFueraDeLaNube();
        Lakitu lakituADevolver= new Lakitu(sprite, posicion, null, null, fabricaEntidades);
        Visitante visitorLakitu = new VisitorLakitu(lakituADevolver);
        lakituADevolver.establecerVisitor(visitorLakitu);
        ObserverGrafico observerGraficoLakitu = new ObserverGrafico(lakituADevolver);
        lakituADevolver.establecerObserverGrafico(observerGraficoLakitu);
        lakituADevolver.establecerDebeMantenerseSiempreEnPantalla(true);
        this.pantallaDeJuego.agregarLabel(lakituADevolver.obtenerObserverGrafico());
        return lakituADevolver;
    }
    
    @SuppressWarnings("exports")
	public BuzzyBeetle getBuzzyBeetle(Point posicion) {
    	Sprite sprite = fabricaSprites.getBuzzyBeetleReversoCaminando();
        BuzzyBeetle buzzyADevolver= new BuzzyBeetle(sprite, posicion, null, null);
        Visitante visitorBuzzy = new VisitorBuzzyBeetle(buzzyADevolver);
        buzzyADevolver.establecerVisitor(visitorBuzzy);
        ObserverGrafico observerGraficoBuzzy = new ObserverGrafico(buzzyADevolver);
        buzzyADevolver.establecerObserverGrafico(observerGraficoBuzzy);
        this.pantallaDeJuego.agregarLabel(buzzyADevolver.obtenerObserverGrafico());
        return buzzyADevolver;
    }
    
    @SuppressWarnings("exports")
	public Goomba getGoomba(Point posicion){
        Sprite sprite = fabricaSprites.getGoombaReversoCaminando();
        Goomba goombaADevolver=new Goomba(sprite, posicion, null, null);
        Visitante visitorGoomba = new VisitorGoomba(goombaADevolver);
        goombaADevolver.establecerVisitor(visitorGoomba);
        ObserverGrafico observerGraficoGoomba = new ObserverGrafico(goombaADevolver);
        goombaADevolver.establecerObserverGrafico(observerGraficoGoomba);
        this.pantallaDeJuego.agregarLabel(goombaADevolver.obtenerObserverGrafico());
        return goombaADevolver;
    }
   
    @SuppressWarnings("exports")
	public Estrella getEstrella(Point posicion) {
        Sprite sprite = fabricaSprites.getSpriteInvisible();
        Estrella estrellaADevolver=new Estrella(sprite, posicion, null, null);
		Visitante visitorEstrella = new VisitorEstrella(estrellaADevolver);
		estrellaADevolver.establecerVisitor(visitorEstrella);
        ObserverGrafico observerGraficoEstrella = new ObserverGrafico(estrellaADevolver);
        estrellaADevolver.establecerObserverGrafico(observerGraficoEstrella);
        return estrellaADevolver;
    } 
    
    @SuppressWarnings("exports")
	public ChampinionVerde getChampinionVerde(Point posicion) {
        Sprite sprite = fabricaSprites.getSpriteInvisible();
        ChampinionVerde champinionVerdeADevolver = new ChampinionVerde(sprite, posicion, null, null);
		Visitante visitorChampinionVerde = new VisitorChampinionVerde(champinionVerdeADevolver);
		champinionVerdeADevolver.establecerVisitor(visitorChampinionVerde);
        ObserverGrafico observerGraficoChampinionVerde = new ObserverGrafico(champinionVerdeADevolver);
        champinionVerdeADevolver.establecerObserverGrafico(observerGraficoChampinionVerde);
        return champinionVerdeADevolver;
    }
    
    @SuppressWarnings("exports")
	public SuperChampinion getSuperChampinion(Point posicion) {
        Sprite sprite = fabricaSprites.getSpriteInvisible();
		SuperChampinion superChampionADevolver = new SuperChampinion(sprite, posicion, null, null);
		Visitante visitorSuperChampinion = new VisitorSuperChampinion(superChampionADevolver);
		superChampionADevolver.establecerVisitor(visitorSuperChampinion);
        ObserverGrafico observerGraficoSuperChampinion = new ObserverGrafico(superChampionADevolver);
        superChampionADevolver.establecerObserverGrafico(observerGraficoSuperChampinion);
        return superChampionADevolver;
        
    }
    
    @SuppressWarnings("exports")
	public FlorDeFuego getFlorDeFuego(Point posicion, FabricaEntidades fabricaEntidades) {
        Sprite sprite = fabricaSprites.getSpriteInvisible();
        FlorDeFuego florDeFuegoADevolver = new FlorDeFuego(sprite, posicion, null, null);
		Visitante visitorFlorDeFuego = new VisitorFlorDeFuego(florDeFuegoADevolver, fabricaEntidades);
		florDeFuegoADevolver.establecerVisitor(visitorFlorDeFuego);
        ObserverGrafico observerGraficoFlorDeFuego = new ObserverGrafico(florDeFuegoADevolver);
        florDeFuegoADevolver.establecerObserverGrafico(observerGraficoFlorDeFuego);
        return florDeFuegoADevolver;
    }
    
    @SuppressWarnings("exports")
	public Monedas getMonedas(Point posicion,int cantidad, 
							  boolean estaDentroDeBloqueDePreguntas) {
        Sprite sprite = fabricaSprites.getMonedaEncendida();
		Monedas monedasADevolver = new Monedas(sprite, posicion, null, null, cantidad, true);
		Visitante visitorMonedas = new VisitorMonedas(monedasADevolver);
		monedasADevolver.establecerVisitor(visitorMonedas);
        ObserverGrafico observerGraficoMonedas = new ObserverGrafico(monedasADevolver);
        monedasADevolver.establecerObserverGrafico(observerGraficoMonedas);
    	this.pantallaDeJuego.agregarLabel(monedasADevolver.obtenerObserverGrafico());
        return monedasADevolver;
    }
    
    @SuppressWarnings("exports")
    public ContextoMario getContextoMario(Point posicion) {
    	Sprite sprite = fabricaSprites.getMarioDefaultFrontalQuieto();
    	MarioDefault estadoInicial = new MarioDefault();
		ContextoMario marioADevolver = new ContextoMario(sprite, posicion, null, null, 3, estadoInicial);
		Visitante visitorContextoMario = new VisitorContextoMario(marioADevolver);
		marioADevolver.establecerVisitor(visitorContextoMario);
		ObserverGrafico observerGraficoMario = new ObserverGrafico(marioADevolver);
		marioADevolver.establecerObserverGrafico(observerGraficoMario);
    	return marioADevolver;
    } 
    
    public BolaDeFuego getBolaDeFuego(Point posicion,Point velocidadDireccional,Jugable jugador) {
    	Sprite sprite = fabricaSprites.getBolaDeFuego();
    	BolaDeFuego bolaDeFuegoADevolver = new BolaDeFuego(sprite, posicion, null,velocidadDireccional, null, jugador);
    	Visitante visitor = new VisitorBolaDeFuego(bolaDeFuegoADevolver);
    	bolaDeFuegoADevolver.establecerVisitor(visitor);
    	ObserverGrafico observer = new ObserverGrafico(bolaDeFuegoADevolver);
    	bolaDeFuegoADevolver.establecerObserverGrafico(observer);
        this.pantallaDeJuego.agregarLabel(bolaDeFuegoADevolver.obtenerObserverGrafico());
        return bolaDeFuegoADevolver;
    } 
    
}
