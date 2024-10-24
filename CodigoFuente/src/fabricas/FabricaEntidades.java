package fabricas;
import java.awt.Point;
import java.util.Vector;

import elementos.*;
import observers.ObserverGrafico;

import visitors.Visitante;


import elementos.enemigos.*;
import elementos.personajes.ContextoMario;
import elementos.personajes.MarioDefault;
import elementos.personajes.MarioFuego;
import elementos.personajes.MarioInvulnerable;
import elementos.personajes.EstadoMario;
import elementos.personajes.SuperMario;
import elementos.plataformas.BloqueSolido;
import elementos.powerUps.*;

public class FabricaEntidades {
    
    protected FabricaSprites fabricaSprites;

    public FabricaEntidades(FabricaSprites fabricaSprites) {
        this.fabricaSprites = fabricaSprites;
    }
    
    @SuppressWarnings("exports")
	public Spiny getSpiny(Point posicion, Visitante visitor, 
						Point velocidadDireccional,ObserverGrafico observer) {
        Sprite sprite = fabricaSprites.getSpinyReversoQuieto();
        return new Spiny(sprite, posicion, visitor, velocidadDireccional,observer);
    }
    
    @SuppressWarnings("exports")
	public ContextoKoopaTroopa getContextoKoopaTroopa(Point posicion, Visitante visitor, 
													  Point velocidadDireccional, 
													  ObserverGrafico observerGrafico) {
    	Sprite sprite = fabricaSprites.getKoopaTroopaDefaultReversoCaminando();
    	KoopaDefault estadoInicial= new KoopaDefault();
    	posicion.move(posicion.x, posicion.y - 25);
    	return new  ContextoKoopaTroopa(sprite, posicion, visitor, velocidadDireccional, observerGrafico, estadoInicial);
    }
       
	@SuppressWarnings("exports")
	public PiranhaPlant getPiranhaPlant(Point posicion, Visitante visitor, 
										Point velocidadDireccional, 
										ObserverGrafico observer) {
        Sprite sprite = fabricaSprites.getPiranhaPlantCerrada();
        return new PiranhaPlant(sprite,posicion, visitor, velocidadDireccional, observer);
    }
    
    @SuppressWarnings("exports")
	public Lakitu getLakitu(Point posicion, Visitante visitor, 
							Point velocidadDireccional, 
							ObserverGrafico observer) {
        Sprite sprite = fabricaSprites.getLakituDentroDeLaNube();
        return new Lakitu(sprite,posicion,visitor,velocidadDireccional, observer);
    }
    
    @SuppressWarnings("exports")
	public BuzzyBeetle getBuzzyBeetle(Point posicion, Visitante visitor, 
									  Point velocidadDireccional, 
									  ObserverGrafico observer) {
        Sprite sprite = fabricaSprites.getBuzzyBeetleReversoQuieto();
        return new BuzzyBeetle(sprite,posicion,visitor,velocidadDireccional,observer);
    }
    
    @SuppressWarnings("exports")
	public Goomba getGoomba(Point posicion, Visitante visitor, 
							Point velocidadDireccional, 
							ObserverGrafico observer){
        Sprite sprite = fabricaSprites.getGoombaCaminandoPrimeraTransicion();
        return new Goomba(sprite, posicion, visitor, velocidadDireccional, observer);
    }
   
    @SuppressWarnings("exports")
	public Estrella getEstrella(Point posicion, Visitante visitor, 
								Point velocidadDireccional, 
								ObserverGrafico observer) {
        Sprite sprite = fabricaSprites.getEstrellaEncendida();
        return new Estrella(sprite, posicion, visitor, velocidadDireccional, observer);
    } 
    
    @SuppressWarnings("exports")
	public ChampinionVerde getChampinionVerde(Point posicion, Visitante visitor, 
											  Point velocidadDireccional,
											  ObserverGrafico observer) {
        Sprite sprite = fabricaSprites.getChampinionVerde();
        return new ChampinionVerde(sprite, posicion, visitor, velocidadDireccional, observer);
    }
    
    @SuppressWarnings("exports")
	public SuperChampinion getSuperChampinion(Point posicion, Visitante visitor,
											  Point velocidadDireccional, 
											  ObserverGrafico observer) {
        Sprite sprite = fabricaSprites.getSuperChampinionQuieto();
        return new SuperChampinion(sprite, posicion, visitor, velocidadDireccional, observer);
    }
    
    @SuppressWarnings("exports")
	public FlorDeFuego getFlorDeFuego(Point posicion, Visitante visitor,
									  Point velocidadDireccional,
									  ObserverGrafico observer) {
        Sprite sprite = fabricaSprites.getFlorDeFuegoPrimeraTransicion();
        return new FlorDeFuego(sprite, posicion, visitor, velocidadDireccional, observer);
    }
    
    @SuppressWarnings("exports")
	public Monedas getMonedas(Point posicion, Visitante visitor,
							  Point velocidadDireccional,
							  ObserverGrafico observer, int cantidad, 
							  boolean estaDentroDeBloqueDePreguntas,
							  boolean estaEnElNivel) {
        Sprite sprite = fabricaSprites.getMonedaEncendida();
        return new Monedas(sprite, posicion, visitor, velocidadDireccional, observer, cantidad, estaDentroDeBloqueDePreguntas, estaEnElNivel);
    }
    
    @SuppressWarnings("exports")
    public ContextoMario getContextoMario(Point posicion, 
										  Visitante visitor, 
										  ObserverGrafico observerGrafico, int vidas) {
    	Sprite sprite = fabricaSprites.getMarioDefaultFrontalQuieto();
    	MarioDefault estadoInicial = new MarioDefault();
    	return new ContextoMario(sprite, posicion, visitor, vidas, estadoInicial);
    } 
    
    //TODO getFireball
    
}
