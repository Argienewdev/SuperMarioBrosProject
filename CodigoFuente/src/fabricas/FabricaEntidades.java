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
import elementos.personajes.MarioState;
import elementos.personajes.SuperMario;
import elementos.powerUps.*;

public class FabricaEntidades {
    
    protected FabricaSprites fabricaSprites;

    public FabricaEntidades(FabricaSprites fabricaSprites) {
        this.fabricaSprites = fabricaSprites;
    }
    
    @SuppressWarnings("exports")
	public Spiny getSpiny(Vector<Integer>posicion,Visitante visitor, Vector<Integer> direccion,
						  int velocidad, ObserverGrafico observer) {
        Sprite sprite = fabricaSprites.getSpinyReversoQuieto();
        return new Spiny (sprite, posicion, visitor, velocidad, direccion,observer);
    }
    
    @SuppressWarnings("exports")
	public ContextoKoopaTroopa getContextoKoopaTroopa(Vector<Integer> posicion,Visitante visitor, 
													  int velocidad, Vector<Integer> direccion, 
													  ObserverGrafico observerGrafico) {
    	Sprite sprite= fabricaSprites.getKoopaTroopaDefaultReversoQuieto();
    	KoopaDefault estadoInicial= new KoopaDefault();
    	return new  ContextoKoopaTroopa(sprite, posicion, visitor, velocidad, direccion, observerGrafico, estadoInicial);
    }
       
	@SuppressWarnings("exports")
	public PiranhaPlant getPiranhaPlant(Vector<Integer>posicion, Visitante visitor, 
										Vector<Integer> direccion, int velocidad, 
										ObserverGrafico observer) {
        Sprite sprite = fabricaSprites.getPiranhaPlantCerrada();
        return new PiranhaPlant(sprite,posicion, visitor, velocidad, direccion, observer);
    }
    
    @SuppressWarnings("exports")
	public Lakitu getLakitu(Vector<Integer>posicion, Visitante visitor, Vector<Integer> direccion, 
							int velocidad, ObserverGrafico observer) {
        Sprite sprite = fabricaSprites.getLakituReversoDentroDeLaNube();
        return new Lakitu (sprite,posicion,visitor,velocidad,direccion, observer);
    }
    
    @SuppressWarnings("exports")
	public BuzzyBeetle getBuzzyBeetle(Vector<Integer>posicion, Visitante visitor, 
									  Vector<Integer> direccion, int velocidad, 
									  ObserverGrafico observer) {
        Sprite sprite = fabricaSprites.getBuzzyBeetleReversoQuieto();
        return new BuzzyBeetle (sprite,posicion,visitor,velocidad,direccion,observer);
    }
    
    @SuppressWarnings("exports")
	public Goomba getGoomba(Vector<Integer>posicion, Visitante visitor, Vector<Integer> direccion, 
							int velocidad, ObserverGrafico observer){
        Sprite sprite = fabricaSprites.getGoombaQuieto();
        return new Goomba (sprite, posicion, visitor, velocidad, direccion, observer);
    }
   
    @SuppressWarnings("exports")
	public Estrella getEstrella(Vector<Integer>posicion, Visitante visitor, 
							 	Vector<Integer> direccion, int velocidad, 
							 	ObserverGrafico observer) {
        Sprite sprite = fabricaSprites.getEstrellaEncendida();
        return new Estrella (sprite, posicion, visitor, velocidad, direccion, observer);
    } 
    
    @SuppressWarnings("exports")
	public ChampinionVerde getChampinionVerde(Vector<Integer>posicion, Visitante visitor, 
											  ObserverGrafico observer) {
        Sprite sprite = fabricaSprites.getChampinionVerde();
        return new ChampinionVerde (sprite, posicion, visitor, observer);
    }
    
    @SuppressWarnings("exports")
	public SuperChampinion getSuperChampinion(Vector<Integer>posicion, Visitante visitor, 
											  Vector<Integer> direccion, int velocidad, 
											  ObserverGrafico observer) {
        Sprite sprite = fabricaSprites.getSuperChampinion();
        return new SuperChampinion (sprite, posicion, visitor, velocidad, direccion, observer);
    }
    
    @SuppressWarnings("exports")
	public FlorDeFuego getFlorDeFuego(Vector<Integer>posicion, Visitante visitor, 
									  ObserverGrafico observer) {
        Sprite sprite = fabricaSprites.getFlorDeFuegoPrimeraTransicion();
        return new FlorDeFuego (sprite,posicion,visitor, observer);
    }
    
    @SuppressWarnings("exports")
	public Moneda getMoneda(Vector<Integer>posicion, Visitante visitor, int cantidad,
							  ObserverGrafico observer ) {
        Sprite sprite = fabricaSprites.getMonedaEncendida();
        return new Moneda (sprite,posicion,visitor,observer, cantidad);
    }
    
    @SuppressWarnings("exports")
	public ContextoMario getContextoMario(Sprite sprite, Vector<Integer> posicion, 
    									  Visitante visitor, int velocidad, 
    									  Vector<Integer> direccion, 
			 							  ObserverGrafico observerGrafico, int vidas, 
			 							  MarioState estado) {
    	return new ContextoMario(sprite, posicion, visitor, velocidad, direccion, observerGrafico, vidas, estado);
    }
    
    @SuppressWarnings("exports")
	public MarioDefault getMarioDefault(ContextoMario contexto) {
    	return new MarioDefault(contexto);
    }
    
    @SuppressWarnings("exports")
	public SuperMario getSuperMario(ContextoMario contexto) {
    	return new SuperMario(contexto);
    }
    
    @SuppressWarnings("exports")
	public MarioInvulnerable getMarioInvulnerable(ContextoMario contexto) {
    	return new MarioInvulnerable(contexto);
    }
    
    @SuppressWarnings("exports")
	public MarioFuego getMarioFuego(ContextoMario contexto) {
    	return new MarioFuego(contexto);
    }
    
    public Moneda getMoneda(Sprite sprite, Vector<Integer> posicion, Visitante visitor, 
			   				  int velocidad, Vector<Integer> direccion, 
			   				  ObserverGrafico observerGrafico, int puntosOtorgados) {
    	return new Moneda(sprite, posicion, visitor, velocidad, direccion, observerGrafico, puntosOtorgados);
    }
    
    public Estrella getEstrella(Sprite sprite, Vector<Integer> posicion, Visitante visitor,
						   		int velocidad, Vector<Integer> direccion, 
						   		ObserverGrafico observerGrafico, int puntosOtorgados) {
    	return new Estrella(sprite, posicion, visitor, velocidad, direccion, observerGrafico, puntosOtorgados);
    }

    public ChampinionVerde getChampinionVerde(Sprite sprite, Vector<Integer> posicion, 
    										  Visitante visitor, int velocidad, 
    										  Vector<Integer> direccion, 
    										  ObserverGrafico observerGrafico, int puntosOtorgados) {
    	return new ChampinionVerde(sprite, posicion, visitor, velocidad, direccion, observerGrafico, puntosOtorgados);
    }
    
    public SuperChampinion getSuperChampinion(Sprite sprite, Vector<Integer> posicion, 
			  							      Visitante visitor, int velocidad, 
			  							      Vector<Integer> direccion, 
			  							      ObserverGrafico observerGrafico, int puntosOtorgados) {
    	return new SuperChampinion(sprite, posicion, visitor, velocidad, direccion, observerGrafico, puntosOtorgados);
    }
    
    public FlorDeFuego getFlorDeFuego(Sprite sprite, Vector<Integer> posicion, 
			  						  Visitante visitor, int velocidad, 
			  						  Vector<Integer> direccion, 
			  						  ObserverGrafico observerGrafico, int puntosOtorgados) {
    	return new FlorDeFuego(sprite, posicion, visitor, velocidad, direccion, observerGrafico, puntosOtorgados);
    }
    
    public Fireball getFireball(Sprite sprite, Vector<Integer> posicion, Visitante visitor, 
								int velocidad, Vector<Integer> direccion, 
								ObserverGrafico observerGrafico) {
    	return new Fireball(sprite, posicion, visitor, velocidad, direccion, observerGrafico);
    }
    
    public PiranhaPlant getPiranhaPlanta(Sprite sprite, Vector<Integer> posicion, Visitante visitor, 
										 int velocidad, Vector<Integer> direccion,
										 ObserverGrafico observerGrafico, Tuberia miTuberia) {
    	return new PiranhaPlant(sprite, posicion, visitor, velocidad, direccion, observerGrafico, miTuberia);
    }
    
    public Lakitu getLakitu(Sprite sprite, Vector<Integer> posicion, Visitante visitor, 
			  				int velocidad, Vector<Integer> direccion, ObserverGrafico observerGrafico) {
    	return new Lakitu(sprite, posicion, visitor, velocidad, direccion, observerGrafico);
    }
    
    public ContextoKoopaTroopa getContextoKoopaTroopa(Sprite sprite,Vector<Integer> posicion, 
    												  Visitante visitor, int velocidad, 
    												  Vector<Integer> direccion, 
    												  ObserverGrafico observerGrafico, 
    												  KoopaState estado) {
    	return new ContextoKoopaTroopa(sprite, posicion, visitor, velocidad, direccion, observerGrafico, estado);
    }
    
    public KoopaCaparazonEstatico getKoopaCaparazonEstatico(ContextoKoopaTroopa contexto) {
    	return new KoopaCaparazonEstatico(contexto);
    }
    
    public KoopaCaparazonMovil getKoopaCaparazonMovil(ContextoKoopaTroopa contexto) {
    	return new KoopaCaparazonMovil(contexto);
    }
    
    public KoopaDefault getKoopaDefault(ContextoKoopaTroopa contexto) {
    	return new KoopaDefault(contexto);
    }
    
    public Goomba getGoomba(Sprite sprite, Vector<Integer> posicion, Visitante visitor,
			  				int velocidad, Vector<Integer> direccion, 
			  				ObserverGrafico observerGrafico) {
    	return new Goomba(sprite, posicion, visitor, velocidad, direccion, observerGrafico);
    }
    
    public Spiny getSpiny(Sprite sprite, Vector<Integer> posicion, Visitante visitor,
						  int velocidad, Vector<Integer> direccion, 
						  ObserverGrafico observerGrafico) {
    	return new Spiny(sprite, posicion, visitor, velocidad, direccion, observerGrafico);
    }
    
    public BuzzyBeetle getBuzzyBeetle(Sprite sprite, Vector<Integer> posicion, Visitante visitor,
			  			  			  int velocidad, Vector<Integer> direccion, 
			  			  			  ObserverGrafico observerGrafico) {
    	return new BuzzyBeetle(sprite, posicion, visitor, velocidad, direccion, observerGrafico);
    }


}
