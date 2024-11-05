package fabricas;

import java.awt.Point;
import elementos.*;
import observers.ObserverGrafico;
import ventanas.PantallaDeJuego;
import visitors.*;
import elementos.enemigos.*;
import elementos.entidades.BolaDeFuego;
import elementos.entidades.Entidad;
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

    public FabricaEntidades(FabricaSprites fabricaSprites, PantallaDeJuego pantallaDeJuego, 
    						GeneradorSonidos generadorSonidos) {
        this.generadorSonidos = generadorSonidos;
        this.fabricaSprites = fabricaSprites;
        this.pantallaDeJuego = pantallaDeJuego;
    }

    @SuppressWarnings("exports")
	public Spiny obtenerSpiny(Point posicion) {
        Spiny spiny = new Spiny(this.fabricaSprites.obtenerSpinyCayendo(), posicion, null, null);
        this.configurarEntidad(spiny, new VisitorSpiny(spiny, this.generadorSonidos));
        return spiny;
    }

    @SuppressWarnings("exports")
	public ContextoKoopaTroopa obtenerContextoKoopaTroopa(Point posicion) {
        KoopaDefault estadoInicial = new KoopaDefault();
        ContextoKoopaTroopa contextoKoopaTroopa = new ContextoKoopaTroopa(this.fabricaSprites.obtenerKoopaTroopaDefaultReversoCaminando(), 
        																  posicion, null, null, estadoInicial);
        this.configurarEntidad(contextoKoopaTroopa, 
        					   new VisitorContextoKoopaTroopa(contextoKoopaTroopa, this.generadorSonidos));
        return contextoKoopaTroopa;
    }

    @SuppressWarnings("exports")
	public PiranhaPlant obtenerPiranhaPlant(Point posicion, Sprite spriteTuberia) {
        int ajusteX = (spriteTuberia.obtenerAnchoImagen() - this.fabricaSprites.obtenerPiranhaPlant().obtenerAnchoImagen()) / 2;
        posicion = new Point(posicion.x + ajusteX, posicion.y);
        PiranhaPlant piranhaPlant = new PiranhaPlant(this.fabricaSprites.obtenerPiranhaPlant(), posicion, null, null);
        this.configurarEntidad(piranhaPlant, new VisitorPiranhaPlant(piranhaPlant, this.generadorSonidos));
        return piranhaPlant;
    }

    @SuppressWarnings("exports")
	public Lakitu obtenerLakitu(Point posicion, FabricaEntidades fabricaEntidades) {
        Lakitu lakitu = new Lakitu(this.fabricaSprites.obtenerLakituReversoFueraDeLaNube(), 
        						   posicion, null, null, fabricaEntidades);
        lakitu.establecerDebeMantenerseSiempreEnPantalla(true);
        this.configurarEntidad(lakitu, new VisitorLakitu(lakitu, this.generadorSonidos));
        return lakitu;
    }

    @SuppressWarnings("exports")
	public BuzzyBeetle obtenerBuzzyBeetle(Point posicion) {
        BuzzyBeetle buzzyBeetle = new BuzzyBeetle(this.fabricaSprites.obtenerBuzzyBeetleReversoCaminando(), 
        										  posicion, null, null);
        this.configurarEntidad(buzzyBeetle, new VisitorBuzzyBeetle(buzzyBeetle, this.generadorSonidos));
        return buzzyBeetle;
    }

    @SuppressWarnings("exports")
	public Goomba obtenerGoomba(Point posicion) {
        Goomba goomba = new Goomba(this.fabricaSprites.obtenerGoombaReversoCaminando(), posicion, null, null);
        this.configurarEntidad(goomba, new VisitorGoomba(goomba, this.generadorSonidos));
        return goomba;
    }

    @SuppressWarnings("exports")
	public Estrella obtenerEstrella(Point posicion) {
        Estrella estrella = new Estrella(this.fabricaSprites.obtenerSpriteInvisible(), posicion, null, null);
        this.configurarEntidad(estrella, new VisitorEstrella(estrella, this.generadorSonidos));
        return estrella;
    }

    @SuppressWarnings("exports")
	public ChampinionVerde obtenerChampinionVerde(Point posicion) {
        ChampinionVerde champinionVerde = new ChampinionVerde(this.fabricaSprites.obtenerSpriteInvisible(), 
        													  posicion, null, null);
        this.configurarEntidad(champinionVerde, new VisitorChampinionVerde(champinionVerde, this.generadorSonidos));
        return champinionVerde;
    }

    @SuppressWarnings("exports")
	public SuperChampinion obtenerSuperChampinion(Point posicion) {
        SuperChampinion superChampinion = new SuperChampinion(this.fabricaSprites.obtenerSpriteInvisible(), 
        													  posicion, null, null);
        this.configurarEntidad(superChampinion, new VisitorSuperChampinion(superChampinion, this.generadorSonidos));
        return superChampinion;
    }

    @SuppressWarnings("exports")
	public FlorDeFuego obtenerFlorDeFuego(Point posicion, FabricaEntidades fabricaEntidades) {
        FlorDeFuego florDeFuego = new FlorDeFuego(this.fabricaSprites.obtenerSpriteInvisible(), 
        										  posicion, null, null);
        this.configurarEntidad(florDeFuego, 
        					   new VisitorFlorDeFuego(florDeFuego, fabricaEntidades, this.generadorSonidos));
        return florDeFuego;
    }

    @SuppressWarnings("exports")
	public Moneda obtenerMonedas(Point posicion, boolean estaDentroDeBloqueDePreguntas) {
        Sprite sprite = estaDentroDeBloqueDePreguntas ? this.fabricaSprites.obtenerSpriteInvisible() : this.fabricaSprites.obtenerMonedaEncendida();
        Moneda moneda = new Moneda(sprite, posicion, null, null, true);
        this.configurarEntidad(moneda, new VisitorMoneda(moneda, this.generadorSonidos));
        return moneda;
    }

    @SuppressWarnings("exports")
    public ContextoMario obtenerContextoMario(Point posicion) {
    	Sprite sprite = fabricaSprites.obtenerMarioDefaultFrontalQuieto();
    	MarioDefault estadoInicial = new MarioDefault();
		ContextoMario marioADevolver = new ContextoMario(sprite, posicion, null, null, 3, estadoInicial, generadorSonidos);
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
        this.pantallaDeJuego.agregarLabel(observer);
        return bolaDeFuegoADevolver;
    } 

    private void configurarEntidad(Entidad entidad, Visitante visitante) {
        entidad.establecerVisitante(visitante);
        ObserverGrafico observerGrafico = new ObserverGrafico(entidad);
        entidad.establecerObserverGrafico(observerGrafico);
        this.pantallaDeJuego.agregarLabel(observerGrafico);
    }
    
}
