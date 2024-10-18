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
import elementos.powerUps.*;

public class FabricaEntidades {
    
    protected FabricaSprites fabricaSprites;

    public FabricaEntidades(FabricaSprites fabricaSprites) {
        this.fabricaSprites = fabricaSprites;
    }
    
    @SuppressWarnings("exports")
	public Spiny getSpiny(Point posicion, Visitante visitor, Point direccion, 
						  int velocidad,ObserverGrafico observer) {
        Sprite sprite = fabricaSprites.getSpinyReversoQuieto();
        return new Spiny(sprite, posicion, visitor, velocidad, direccion,observer);
    }
    
    @SuppressWarnings("exports")
	public ContextoKoopaTroopa getContextoKoopaTroopa(Point posicion, Visitante visitor, 
													  int velocidad, Point direccion, 
													  ObserverGrafico observerGrafico) {
    	Sprite sprite = fabricaSprites.getKoopaTroopaDefaultReversoQuieto();
    	KoopaDefault estadoInicial= new KoopaDefault();
    	return new  ContextoKoopaTroopa(sprite, posicion, visitor, velocidad, direccion, observerGrafico, estadoInicial);
    }
       
	@SuppressWarnings("exports")
	public PiranhaPlant getPiranhaPlant(Point posicion, Visitante visitor, 
										Point direccion, int velocidad, 
										ObserverGrafico observer) {
        Sprite sprite = fabricaSprites.getPiranhaPlantCerrada();
        return new PiranhaPlant(sprite,posicion, visitor, velocidad, direccion, observer);
    }
    
    @SuppressWarnings("exports")
	public Lakitu getLakitu(Point posicion, Visitante visitor, 
							Point direccion, int velocidad, 
							ObserverGrafico observer) {
        Sprite sprite = fabricaSprites.getLakituReversoDentroDeLaNube();
        return new Lakitu(sprite,posicion,visitor,velocidad,direccion, observer);
    }
    
    @SuppressWarnings("exports")
	public BuzzyBeetle getBuzzyBeetle(Point posicion, Visitante visitor, 
									  Point direccion, int velocidad, 
									  ObserverGrafico observer) {
        Sprite sprite = fabricaSprites.getBuzzyBeetleReversoQuieto();
        return new BuzzyBeetle(sprite,posicion,visitor,velocidad,direccion,observer);
    }
    
    @SuppressWarnings("exports")
	public Goomba getGoomba(Point posicion, Visitante visitor, 
							Point direccion, int velocidad, 
							ObserverGrafico observer){
        Sprite sprite = fabricaSprites.getGoombaQuieto();
        return new Goomba(sprite, posicion, visitor, velocidad, direccion, observer);
    }
   
    @SuppressWarnings("exports")
	public Estrella getEstrella(Point posicion, Visitante visitor, 
								Point direccion, int velocidad, 
								ObserverGrafico observer) {
        Sprite sprite = fabricaSprites.getEstrellaEncendida();
        return new Estrella(sprite, posicion, visitor, velocidad, direccion, observer);
    } 
    
    @SuppressWarnings("exports")
	public ChampinionVerde getChampinionVerde(Point posicion, Visitante visitor,
											  ObserverGrafico observer) {
        Sprite sprite = fabricaSprites.getChampinionVerde();
        return new ChampinionVerde(sprite, posicion, visitor, observer);
    }
    
    @SuppressWarnings("exports")
	public SuperChampinion getSuperChampinion(Point posicion, Visitante visitor, 
											  Point direccion, int velocidad, 
											  ObserverGrafico observer) {
        Sprite sprite = fabricaSprites.getSuperChampinion();
        return new SuperChampinion(sprite, posicion, visitor, velocidad, direccion, observer);
    }
    
    @SuppressWarnings("exports")
	public FlorDeFuego getFlorDeFuego(Point posicion, Visitante visitor,
									  ObserverGrafico observer) {
        Sprite sprite = fabricaSprites.getFlorDeFuegoPrimeraTransicion();
        return new FlorDeFuego(sprite,posicion,visitor, observer);
    }
    
    @SuppressWarnings("exports")
	public Monedas getMonedas(Point posicion, Visitante visitor,
							  int cantidad, ObserverGrafico observer ) {
        Sprite sprite = fabricaSprites.getMonedaEncendida();
        return new Monedas(sprite,posicion,visitor,observer, cantidad);
    }
    
    @SuppressWarnings("exports")
    public ContextoMario getContextoMario(Point posicion, 
										  Visitante visitor, int velocidad, 
										  Point direccion, 
										  ObserverGrafico observerGrafico, int vidas, 
										  MarioDefault estado) {
    	Sprite sprite = fabricaSprites.getMarioDefaultFrontalQuieto();
    	MarioDefault estadoInicial = new MarioDefault();
    	return new ContextoMario(sprite, posicion, visitor, vidas, estadoInicial);
    } 
    
    //TODO getFireball
    
}
