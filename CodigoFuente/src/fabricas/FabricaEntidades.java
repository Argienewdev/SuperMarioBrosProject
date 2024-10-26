package fabricas;
import java.awt.Point;
import elementos.*;
import observers.ObserverGrafico;
import visitors.Visitante;
import visitors.VisitorBolaDeFuego;
import visitors.VisitorBuzzyBeetle;
import visitors.VisitorChampinionVerde;
import visitors.VisitorContextoKoopaTroopa;
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

	protected static final int VELOCIDAD_HORIZONTAL_ENEMIGOS = -2;
	
	protected static final int VELOCIDAD_HORIZONTAL_POWER_UPS_MOVILES = 2;
    
    public FabricaEntidades(FabricaSprites fabricaSprites) {
        this.fabricaSprites = fabricaSprites;
    }
    
    @SuppressWarnings("exports")
	public Spiny getSpiny(Point posicion) {
    	Sprite sprite = fabricaSprites.getSpinyReversoQuieto();
    	Point velocidadDireccional = new Point(VELOCIDAD_HORIZONTAL_ENEMIGOS, 0);
        Spiny spinyADevolver= new Spiny(sprite, posicion, null, velocidadDireccional,null);
        Visitante visitorSpiny = new VisitorSpiny(spinyADevolver);
        spinyADevolver.setVisitor(visitorSpiny);
        ObserverGrafico observerGraficoSpiny = new ObserverGrafico(spinyADevolver);
        spinyADevolver.setObserverGrafico(observerGraficoSpiny);
       	return spinyADevolver;
    }
    
    @SuppressWarnings("exports")
	public ContextoKoopaTroopa getContextoKoopaTroopa(Point posicion) {
    	Sprite sprite = fabricaSprites.getKoopaTroopaDefaultReversoCaminando();
    	KoopaDefault estadoInicial= new KoopaDefault();
        Point velocidadDireccional = new Point(VELOCIDAD_HORIZONTAL_ENEMIGOS, 0);
        ContextoKoopaTroopa koopaADevolver = new  ContextoKoopaTroopa(sprite, posicion, null, velocidadDireccional, null, estadoInicial);
        Visitante visitorContextoKoopaTroopa = new VisitorContextoKoopaTroopa(koopaADevolver);
        koopaADevolver.setVisitor(visitorContextoKoopaTroopa);
        ObserverGrafico observerGraficoKoopa = new ObserverGrafico(koopaADevolver);
        koopaADevolver.setObserverGrafico(observerGraficoKoopa);
    	posicion.move(posicion.x, posicion.y - 25);
    	return koopaADevolver;
    }
       
	@SuppressWarnings("exports")
	public PiranhaPlant getPiranhaPlant(Point posicion) {
        Sprite sprite = fabricaSprites.getPiranhaPlantCerrada();
        Point direccionPiranhaPlant = new Point(0,1);
        PiranhaPlant piranhaADevolver=new PiranhaPlant(sprite,posicion, null, direccionPiranhaPlant, null);
        Visitante visitorPiranha = new VisitorPiranhaPlant(piranhaADevolver);
        piranhaADevolver.setVisitor(visitorPiranha);
		ObserverGrafico observerGraficoPiranha = new ObserverGrafico(piranhaADevolver);
		piranhaADevolver.setObserverGrafico(observerGraficoPiranha);
        return piranhaADevolver;
    }
    
    @SuppressWarnings("exports")
	public Lakitu getLakitu(Point posicion) {
        Sprite sprite = fabricaSprites.getLakituDentroDeLaNube();
        Point velocidadDireccional= new Point(VELOCIDAD_HORIZONTAL_ENEMIGOS,0);	 
        Lakitu lakituADevolver= new Lakitu(sprite, posicion, null, velocidadDireccional, null);
        Visitante visitorLakitu = new VisitorLakitu(lakituADevolver);
        lakituADevolver.setVisitor(visitorLakitu);
        ObserverGrafico observerGraficoLakitu = new ObserverGrafico(lakituADevolver);
        lakituADevolver.setObserverGrafico(observerGraficoLakitu);
        return lakituADevolver;
    }
    
    @SuppressWarnings("exports")
	public BuzzyBeetle getBuzzyBeetle(Point posicion) {
    	Sprite sprite = fabricaSprites.getBuzzyBeetleReversoQuieto();
        Point velocidadDireccional = new Point(VELOCIDAD_HORIZONTAL_ENEMIGOS, 0);
        BuzzyBeetle buzzyADevolver= new BuzzyBeetle(sprite,posicion,null,velocidadDireccional,null);
        Visitante visitorBuzzy = new VisitorBuzzyBeetle(buzzyADevolver);
        buzzyADevolver.setVisitor(visitorBuzzy);
        ObserverGrafico observerGraficoBuzzy = new ObserverGrafico(buzzyADevolver);
        buzzyADevolver.setObserverGrafico(observerGraficoBuzzy);
        return buzzyADevolver;
    }
    
    @SuppressWarnings("exports")
	public Goomba getGoomba(Point posicion){
        Sprite sprite = fabricaSprites.getGoombaCaminandoPrimeraTransicion();
        Point velocidadDireccional = new Point(VELOCIDAD_HORIZONTAL_ENEMIGOS, 0);
        Goomba goombaADevolver=new Goomba(sprite, posicion, null, velocidadDireccional, null);
        Visitante visitorGoomba = new VisitorGoomba(goombaADevolver);
        goombaADevolver.setVisitor(visitorGoomba);
        ObserverGrafico observerGraficoGoomba = new ObserverGrafico(goombaADevolver);
        goombaADevolver.setObserverGrafico(observerGraficoGoomba);
        return goombaADevolver;
    }
   
    @SuppressWarnings("exports")
	public Estrella getEstrella(Point posicion) {
    	Point velocidadDireccional = new Point(VELOCIDAD_HORIZONTAL_POWER_UPS_MOVILES,0);
        Sprite sprite = fabricaSprites.getSpriteInvisible();
        Estrella estrellaADevolver=new Estrella(sprite, posicion, null, velocidadDireccional, null);
		Visitante visitorEstrella = new VisitorEstrella(estrellaADevolver);
		estrellaADevolver.setVisitor(visitorEstrella);
        ObserverGrafico observerGraficoEstrella = new ObserverGrafico(estrellaADevolver);
        estrellaADevolver.setObserverGrafico(observerGraficoEstrella);
        return estrellaADevolver;
    } 
    
    @SuppressWarnings("exports")
	public ChampinionVerde getChampinionVerde(Point posicion) {
        Sprite sprite = fabricaSprites.getSpriteInvisible();
        Point velocidadDireccional = new Point(VELOCIDAD_HORIZONTAL_POWER_UPS_MOVILES,0);
        ChampinionVerde champinionVerdeADevolver=new ChampinionVerde(sprite, posicion, null, velocidadDireccional, null);
		Visitante visitorChampinionVerde = new VisitorChampinionVerde(champinionVerdeADevolver);
		champinionVerdeADevolver.setVisitor(visitorChampinionVerde);
        ObserverGrafico observerGraficoChampinionVerde = new ObserverGrafico(champinionVerdeADevolver);
        champinionVerdeADevolver.setObserverGrafico(observerGraficoChampinionVerde);
        return champinionVerdeADevolver;
    }
    
    @SuppressWarnings("exports")
	public SuperChampinion getSuperChampinion(Point posicion) {
        Sprite sprite = fabricaSprites.getSpriteInvisible();
		Point velocidadDireccional = new Point(VELOCIDAD_HORIZONTAL_POWER_UPS_MOVILES,0);
		SuperChampinion superChampionADevolver=new SuperChampinion(sprite, posicion, null, velocidadDireccional, null);
		Visitante visitorSuperChampinion = new VisitorSuperChampinion(superChampionADevolver);
		superChampionADevolver.setVisitor(visitorSuperChampinion);
        ObserverGrafico observerGraficoSuperChampinion = new ObserverGrafico(superChampionADevolver);
        superChampionADevolver.setObserverGrafico(observerGraficoSuperChampinion);
        return superChampionADevolver;
    }
    
    @SuppressWarnings("exports")
	public FlorDeFuego getFlorDeFuego(Point posicion,FabricaEntidades fabricaEntidades) {
        Sprite sprite = fabricaSprites.getSpriteInvisible();
        Point velocidadDireccional = new Point(0,0);
        FlorDeFuego florDeFuegoADevolver= new FlorDeFuego(sprite, posicion, null, velocidadDireccional, null);
		Visitante visitorFlorDeFuego = new VisitorFlorDeFuego(florDeFuegoADevolver,fabricaEntidades);
		florDeFuegoADevolver.setVisitor(visitorFlorDeFuego);
        ObserverGrafico observerGraficoFlorDeFuego = new ObserverGrafico(florDeFuegoADevolver);
        florDeFuegoADevolver.setObserverGrafico(observerGraficoFlorDeFuego);
        return florDeFuegoADevolver;
    }
    
    @SuppressWarnings("exports")
	public Monedas getMonedas(Point posicion,int cantidad, 
							  boolean estaDentroDeBloqueDePreguntas) {
        Sprite sprite = fabricaSprites.getMonedaEncendida();
        Point velocidadDireccional = new Point(0,0);
		Monedas monedasADevolver = new Monedas(sprite, posicion, null, velocidadDireccional, null, cantidad, true);
		Visitante visitorMonedas = new VisitorMonedas(monedasADevolver);
		monedasADevolver.setVisitor(visitorMonedas);
        ObserverGrafico observerGraficoMonedas = new ObserverGrafico(monedasADevolver);
        monedasADevolver.setObserverGrafico(observerGraficoMonedas);
        return monedasADevolver;
    }
    
    @SuppressWarnings("exports")
    public ContextoMario getContextoMario(Point posicion, 
										  Visitante visitor, 
										  ObserverGrafico observerGrafico, int vidas) {
    	Sprite sprite = fabricaSprites.getMarioDefaultFrontalQuieto();
    	MarioDefault estadoInicial = new MarioDefault();
    	return new ContextoMario(sprite, posicion, visitor, vidas, estadoInicial);
    } 
    
    public BolaDeFuego getBolaDeFuego(Point posicion,Jugable jugador) {
    		Sprite sprite = fabricaSprites.getBolaDeFuego();
    		Point velocidadDireccional = new Point(1,0);
    		BolaDeFuego bolaDeFuegoADevolver= new BolaDeFuego(sprite, posicion,null,velocidadDireccional,null,jugador);
    		Visitante visitor=new VisitorBolaDeFuego(bolaDeFuegoADevolver);
    		bolaDeFuegoADevolver.setVisitor(visitor);
    		ObserverGrafico observer = new ObserverGrafico(bolaDeFuegoADevolver);
    		bolaDeFuegoADevolver.setObserverGrafico(observer);
    return bolaDeFuegoADevolver;
} 
    
}
