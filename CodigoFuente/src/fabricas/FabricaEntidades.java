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
import generadores.GeneradorSonidos;

public class FabricaEntidades {
    
    protected FabricaSprites fabricaSprites;
    
    protected PantallaDeJuego pantallaDeJuego;
    
    protected GeneradorSonidos generadorSonidos;

	protected static final int VELOCIDAD_HORIZONTAL_POWER_UPS_MOVILES = 2;
    
    public FabricaEntidades(FabricaSprites fabricaSprites,PantallaDeJuego pantallaDeJuego, FabricaSonidos fabricaSonidos, GeneradorSonidos generadorSonidos) {
    	this.generadorSonidos = generadorSonidos;
        this.fabricaSprites = fabricaSprites;
        this.pantallaDeJuego = pantallaDeJuego;
    }
    
    @SuppressWarnings("exports")
	public Spiny obtenerSpiny(Point posicion) {
    	Sprite sprite = fabricaSprites.obtenerSpinyCayendo();
        Spiny spinyADevolver= new Spiny(sprite, posicion, null, null);
        Visitante visitorSpiny = new VisitorSpiny(spinyADevolver, this.generadorSonidos);
        spinyADevolver.establecerVisitante(visitorSpiny);
        ObserverGrafico observerGraficoSpiny = new ObserverGrafico(spinyADevolver);
        spinyADevolver.establecerObserverGrafico(observerGraficoSpiny);
        this.pantallaDeJuego.agregarLabelAAgregar(observerGraficoSpiny);
        return spinyADevolver;
    }
    
    @SuppressWarnings("exports")
	public ContextoKoopaTroopa obtenerContextoKoopaTroopa(Point posicion) {
    	Sprite sprite = fabricaSprites.obtenerKoopaTroopaDefaultReversoCaminando();
    	KoopaDefault estadoInicial =  new KoopaDefault();
        ContextoKoopaTroopa koopaADevolver = new ContextoKoopaTroopa(sprite, posicion, null, null, estadoInicial);
        Visitante visitorContextoKoopaTroopa = new VisitorContextoKoopaTroopa(koopaADevolver, this.generadorSonidos);
        koopaADevolver.establecerVisitante(visitorContextoKoopaTroopa);
        ObserverGrafico observerGraficoKoopa = new ObserverGrafico(koopaADevolver);
        koopaADevolver.establecerObserverGrafico(observerGraficoKoopa);
        this.pantallaDeJuego.agregarLabel(koopaADevolver.obtenerObserverGrafico());
    	return koopaADevolver;
    }
       
	@SuppressWarnings("exports")
	public PiranhaPlant obtenerPiranhaPlant(Point posicion, Sprite spriteTuberia) {
        Sprite sprite = fabricaSprites.obtenerPiranhaPlant();
        int posicionXConsiderandoSprite = posicion.x + ((spriteTuberia.obtenerAnchoImagen() / 2) - (sprite.obtenerAnchoImagen() / 2));
        posicion = new Point(posicionXConsiderandoSprite, posicion.y);
        PiranhaPlant piranhaADevolver = new PiranhaPlant(sprite, posicion, null, null);
        Visitante visitorPiranha = new VisitorPiranhaPlant(piranhaADevolver, this.generadorSonidos);
        piranhaADevolver.establecerVisitante(visitorPiranha);
		ObserverGrafico observerGraficoPiranha = new ObserverGrafico(piranhaADevolver);
		piranhaADevolver.establecerObserverGrafico(observerGraficoPiranha);
		this.pantallaDeJuego.agregarLabel(piranhaADevolver.obtenerObserverGrafico());
        return piranhaADevolver;
    }
    
    @SuppressWarnings("exports")
	public Lakitu obtenerLakitu(Point posicion, FabricaEntidades fabricaEntidades) {
        Sprite sprite = fabricaSprites.obtenerLakituReversoFueraDeLaNube();
        Lakitu lakituADevolver= new Lakitu(sprite, posicion, null, null, fabricaEntidades);
        Visitante visitorLakitu = new VisitorLakitu(lakituADevolver, this.generadorSonidos);
        lakituADevolver.establecerVisitante(visitorLakitu);
        ObserverGrafico observerGraficoLakitu = new ObserverGrafico(lakituADevolver);
        lakituADevolver.establecerObserverGrafico(observerGraficoLakitu);
        lakituADevolver.establecerDebeMantenerseSiempreEnPantalla(true);
        this.pantallaDeJuego.agregarLabel(lakituADevolver.obtenerObserverGrafico());
        return lakituADevolver;
    }
    
    @SuppressWarnings("exports")
	public BuzzyBeetle obtenerBuzzyBeetle(Point posicion) {
    	Sprite sprite = fabricaSprites.obtenerBuzzyBeetleReversoCaminando();
        BuzzyBeetle buzzyADevolver= new BuzzyBeetle(sprite, posicion, null, null);
        Visitante visitorBuzzy = new VisitorBuzzyBeetle(buzzyADevolver, this.generadorSonidos);
        buzzyADevolver.establecerVisitante(visitorBuzzy);
        ObserverGrafico observerGraficoBuzzy = new ObserverGrafico(buzzyADevolver);
        buzzyADevolver.establecerObserverGrafico(observerGraficoBuzzy);
        this.pantallaDeJuego.agregarLabel(buzzyADevolver.obtenerObserverGrafico());
        return buzzyADevolver;
    }
    
    @SuppressWarnings("exports")
	public Goomba obtenerGoomba(Point posicion){
        Sprite sprite = fabricaSprites.obtenerGoombaReversoCaminando();
        Goomba goombaADevolver = new Goomba(sprite, posicion, null, null);
        Visitante visitorGoomba = new VisitorGoomba(goombaADevolver, this.generadorSonidos);
        goombaADevolver.establecerVisitante(visitorGoomba);
        ObserverGrafico observerGraficoGoomba = new ObserverGrafico(goombaADevolver);
        goombaADevolver.establecerObserverGrafico(observerGraficoGoomba);
        this.pantallaDeJuego.agregarLabel(goombaADevolver.obtenerObserverGrafico());
        return goombaADevolver;
    }
   
    @SuppressWarnings("exports")
	public Estrella obtenerEstrella(Point posicion) {
        Sprite sprite = fabricaSprites.obtenerSpriteInvisible();
        Estrella estrellaADevolver=new Estrella(sprite, posicion, null, null);
		Visitante visitorEstrella = new VisitorEstrella(estrellaADevolver, this.generadorSonidos);
		estrellaADevolver.establecerVisitante(visitorEstrella);
        ObserverGrafico observerGraficoEstrella = new ObserverGrafico(estrellaADevolver);
        estrellaADevolver.establecerObserverGrafico(observerGraficoEstrella);
        pantallaDeJuego.agregarLabel(estrellaADevolver.obtenerObserverGrafico());
        return estrellaADevolver;
    } 
    
    @SuppressWarnings("exports")
	public ChampinionVerde obtenerChampinionVerde(Point posicion) {
        Sprite sprite = fabricaSprites.obtenerSpriteInvisible();
        ChampinionVerde champinionVerdeADevolver = new ChampinionVerde(sprite, posicion, null, null);
		Visitante visitorChampinionVerde = new VisitorChampinionVerde(champinionVerdeADevolver, this.generadorSonidos);
		champinionVerdeADevolver.establecerVisitante(visitorChampinionVerde);
        ObserverGrafico observerGraficoChampinionVerde = new ObserverGrafico(champinionVerdeADevolver);
        champinionVerdeADevolver.establecerObserverGrafico(observerGraficoChampinionVerde);
        pantallaDeJuego.agregarLabel(champinionVerdeADevolver.obtenerObserverGrafico());
        return champinionVerdeADevolver;
    }
    
    @SuppressWarnings("exports")
	public SuperChampinion obtenerSuperChampinion(Point posicion) {
        Sprite sprite = fabricaSprites.obtenerSpriteInvisible();
		SuperChampinion superChampionADevolver = new SuperChampinion(sprite, posicion, null, null);
		Visitante visitorSuperChampinion = new VisitorSuperChampinion(superChampionADevolver, this.generadorSonidos);
		superChampionADevolver.establecerVisitante(visitorSuperChampinion);
        ObserverGrafico observerGraficoSuperChampinion = new ObserverGrafico(superChampionADevolver);
        superChampionADevolver.establecerObserverGrafico(observerGraficoSuperChampinion);
        pantallaDeJuego.agregarLabel(superChampionADevolver.obtenerObserverGrafico());
        return superChampionADevolver;
    }
    
    @SuppressWarnings("exports")
	public FlorDeFuego obtenerFlorDeFuego(Point posicion, FabricaEntidades fabricaEntidades) {
        Sprite sprite = fabricaSprites.obtenerSpriteInvisible();
        FlorDeFuego florDeFuegoADevolver = new FlorDeFuego(sprite, posicion, null, null);
		Visitante visitorFlorDeFuego = new VisitorFlorDeFuego(florDeFuegoADevolver, fabricaEntidades, this.generadorSonidos);
		florDeFuegoADevolver.establecerVisitante(visitorFlorDeFuego);
        ObserverGrafico observerGraficoFlorDeFuego = new ObserverGrafico(florDeFuegoADevolver);
        florDeFuegoADevolver.establecerObserverGrafico(observerGraficoFlorDeFuego);
        pantallaDeJuego.agregarLabel(florDeFuegoADevolver.obtenerObserverGrafico());
        return florDeFuegoADevolver;
    }
    
    @SuppressWarnings("exports")
	public Moneda obtenerMonedas(Point posicion, 
							  boolean estaDentroDeBloqueDePreguntas) {
        Sprite sprite;
        if (!estaDentroDeBloqueDePreguntas) {
        	sprite = fabricaSprites.obtenerMonedaEncendida();
        } else {
        	sprite = fabricaSprites.obtenerSpriteInvisible();
        }
		Moneda monedasADevolver = new Moneda(sprite, posicion, null, null, true);
		Visitante visitorMonedas = new VisitorMonedas(monedasADevolver, this.generadorSonidos);
		monedasADevolver.establecerVisitante(visitorMonedas);
        ObserverGrafico observerGraficoMonedas = new ObserverGrafico(monedasADevolver);
        monedasADevolver.establecerObserverGrafico(observerGraficoMonedas);
        this.pantallaDeJuego.agregarLabel(monedasADevolver.obtenerObserverGrafico());
        return monedasADevolver;
    }
    
    @SuppressWarnings("exports")
    public ContextoMario obtenerContextoMario(Point posicion) {
    	Sprite sprite = fabricaSprites.obtenerMarioDefaultFrontalQuieto();
    	MarioDefault estadoInicial = new MarioDefault();
		ContextoMario marioADevolver = new ContextoMario(sprite, posicion, null, null, 3, estadoInicial);
		Visitante visitorContextoMario = new VisitorContextoMario(marioADevolver, this.generadorSonidos);
		marioADevolver.establecerVisitante(visitorContextoMario);
		ObserverGrafico observerGraficoMario = new ObserverGrafico(marioADevolver);
		marioADevolver.establecerObserverGrafico(observerGraficoMario);
    	return marioADevolver;
    } 
    
    @SuppressWarnings("exports")
	public BolaDeFuego obtenerBolaDeFuego(Point posicion, Point velocidadDireccional, Jugable jugador) {
    	Sprite sprite = fabricaSprites.obtenerBolaDeFuego();
    	BolaDeFuego bolaDeFuegoADevolver = new BolaDeFuego(sprite, posicion, null, velocidadDireccional, null, jugador);
    	Visitante visitor = new VisitorBolaDeFuego(bolaDeFuegoADevolver, this.generadorSonidos);
    	bolaDeFuegoADevolver.establecerVisitante(visitor);
    	ObserverGrafico observer = new ObserverGrafico(bolaDeFuegoADevolver);
    	bolaDeFuegoADevolver.establecerObserverGrafico(observer);
        this.pantallaDeJuego.agregarLabelAAgregar(observer);
        return bolaDeFuegoADevolver;
    } 
    
}
