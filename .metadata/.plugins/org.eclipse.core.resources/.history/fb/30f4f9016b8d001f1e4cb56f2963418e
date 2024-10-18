package fabricas;
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
	public Spiny getSpiny(Vector<Integer> posicion, Visitante visitor, Vector<Integer> direccion, 
						  int velocidad,ObserverGrafico observer) {
        Sprite sprite = fabricaSprites.getSpinyReversoQuieto();
        return new Spiny(sprite, posicion, visitor, velocidad, direccion,observer);
    }
    
    @SuppressWarnings("exports")
	public ContextoKoopaTroopa getContextoKoopaTroopa(Vector<Integer> posicion, Visitante visitor, 
													  int velocidad, Vector<Integer> direccion, 
													  ObserverGrafico observerGrafico) {
    	Sprite sprite = fabricaSprites.getKoopaTroopaDefaultReversoQuieto();
    	KoopaDefault estadoInicial= new KoopaDefault();
    	return new  ContextoKoopaTroopa(sprite, posicion, visitor, velocidad, direccion, observerGrafico, estadoInicial);
    }
       
	@SuppressWarnings("exports")
	public PiranhaPlant getPiranhaPlant(Vector<Integer> posicion, Visitante visitor, 
										Vector<Integer> direccion, int velocidad, 
										ObserverGrafico observer) {
        Sprite sprite = fabricaSprites.getPiranhaPlantCerrada();
        return new PiranhaPlant(sprite,posicion, visitor, velocidad, direccion, observer);
    }
    
    @SuppressWarnings("exports")
	public Lakitu getLakitu(Vector<Integer>posicion, Visitante visitor, 
							Vector<Integer> direccion, int velocidad, 
							ObserverGrafico observer) {
        Sprite sprite = fabricaSprites.getLakituReversoDentroDeLaNube();
        return new Lakitu(sprite,posicion,visitor,velocidad,direccion, observer);
    }
    
    @SuppressWarnings("exports")
	public BuzzyBeetle getBuzzyBeetle(Vector<Integer> posicion, Visitante visitor, 
									  Vector<Integer> direccion, int velocidad, 
									  ObserverGrafico observer) {
        Sprite sprite = fabricaSprites.getBuzzyBeetleReversoQuieto();
        return new BuzzyBeetle(sprite,posicion,visitor,velocidad,direccion,observer);
    }
    
    @SuppressWarnings("exports")
	public Goomba getGoomba(Vector<Integer> posicion, Visitante visitor, 
							Vector<Integer> direccion, int velocidad, 
							ObserverGrafico observer){
        Sprite sprite = fabricaSprites.getGoombaQuieto();
        return new Goomba(sprite, posicion, visitor, velocidad, direccion, observer);
    }
   
    @SuppressWarnings("exports")
	public Estrella getEstrella(Vector<Integer> posicion, Visitante visitor, 
								Vector<Integer> direccion, int velocidad, 
								ObserverGrafico observer) {
        Sprite sprite = fabricaSprites.getEstrellaEncendida();
        return new Estrella(sprite, posicion, visitor, velocidad, direccion, observer);
    } 
    
    @SuppressWarnings("exports")
	public ChampinionVerde getChampinionVerde(Vector<Integer> posicion, Visitante visitor, 
											  ObserverGrafico observer) {
        Sprite sprite = fabricaSprites.getChampinionVerde();
        return new ChampinionVerde(sprite, posicion, visitor, observer);
    }
    
    @SuppressWarnings("exports")
	public SuperChampinion getSuperChampinion(Vector<Integer> posicion, Visitante visitor, 
											  Vector<Integer> direccion, int velocidad, 
											  ObserverGrafico observer) {
        Sprite sprite = fabricaSprites.getSuperChampinion();
        return new SuperChampinion(sprite, posicion, visitor, velocidad, direccion, observer);
    }
    
    @SuppressWarnings("exports")
	public FlorDeFuego getFlorDeFuego(Vector<Integer> posicion, Visitante visitor, 
									  ObserverGrafico observer) {
        Sprite sprite = fabricaSprites.getFlorDeFuegoPrimeraTransicion();
        return new FlorDeFuego(sprite,posicion,visitor, observer);
    }
    
    @SuppressWarnings("exports")
	public Monedas getMonedas(Vector<Integer> posicion, Visitante visitor, 
							  int cantidad, ObserverGrafico observer ) {
        Sprite sprite = fabricaSprites.getMonedaEncendida();
        return new Monedas(sprite,posicion,visitor,observer, cantidad);
    }
    
    @SuppressWarnings("exports")
    public ContextoMario getContextoMario(Vector<Integer> posicion, 
										  Visitante visitor, int velocidad, 
										  Vector<Integer> direccion, 
										  ObserverGrafico observerGrafico, int vidas, 
										  MarioDefault estado) {
    	Sprite sprite = fabricaSprites.getMarioDefaultFrontalQuieto();
    	MarioDefault estadoInicial = new MarioDefault();
    	return new ContextoMario(sprite, posicion, visitor, vidas, estadoInicial);
    } 
    
}
