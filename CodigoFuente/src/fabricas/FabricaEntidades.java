package fabricas;
import java.util.Vector;

import elementos.*;
import juego.Silueta;
import observers.ObserverGrafico;
import visitors.Visitante;

import java.util.Vector;

import elementos.enemigos.*;
import elementos.entidades.*;
import elementos.plataformas.*;
import elementos.powerUps.*;
import juego.Silueta;

public class FabricaEntidades {
    
    protected FabricaSprites fabricaSprites;

    public FabricaEntidades(FabricaSprites fabricaSprites) {
        this.fabricaSprites = fabricaSprites;
    }
    
    @SuppressWarnings("exports")
	public Spiny getSpiny(Vector<Integer>posicion,Visitante visitor, Vector<Integer> direccion, int velocidad,ObserverGrafico observer) {
        Sprite sprite = fabricaSprites.getSpinyReversoQuieto();
        return new Spiny (sprite, posicion, visitor, velocidad, direccion,observer);
    }
    
    @SuppressWarnings("exports")
	public ContextoKoopaTroopa getKoopaTroopa(Vector<Integer>posicion,Visitante visitor, Vector<Integer> direccion, int velocidad,ObserverGrafico observer) {
        Sprite sprite = fabricaSprites.getSpinyReversoQuieto();
        KoopaState estadoIncial= new KoopaDefault();
        return new ContextoKoopaTroopa (sprite, posicion, visitor, velocidad, direccion,observer,estadoIncial);
    }
   
	@SuppressWarnings("exports")
	public PiranhaPlant getPiranhaPlant(Vector<Integer>posicion,Visitante visitor, Vector<Integer> direccion, int velocidad, ObserverGrafico observer) {
        Sprite sprite = fabricaSprites.getPiranhaPlantCerrada();
        return new PiranhaPlant(sprite,posicion, visitor, velocidad, direccion, observer);
    }
    
    @SuppressWarnings("exports")
	public Lakitu getLakitu(Vector<Integer>posicion,Visitante visitor, Vector<Integer> direccion, int velocidad, ObserverGrafico observer) {
        Sprite sprite = fabricaSprites.getLakituReversoDentroDeLaNube();
        return new Lakitu (sprite,posicion,visitor,velocidad,direccion, observer);
    }
    
    @SuppressWarnings("exports")
	public BuzzyBeetle getBuzzyBeetle(Vector<Integer>posicion,Visitante visitor, Vector<Integer> direccion, int velocidad, ObserverGrafico observer) {
        Sprite sprite = fabricaSprites.getBuzzyBeetleReversoQuieto();
        return new BuzzyBeetle (sprite,posicion,visitor,velocidad,direccion,observer);
    }
    
    @SuppressWarnings("exports")
	public Goomba getGoomba(Vector<Integer>posicion,Visitante visitor, Vector<Integer> direccion, int velocidad, ObserverGrafico observer){
        Sprite sprite = fabricaSprites.getGoombaQuieto();
        return new Goomba (sprite, posicion, visitor, velocidad, direccion, observer);
    }
   
    @SuppressWarnings("exports")
	public Estrella getEstrella(Vector<Integer>posicion,Visitante visitor, Vector<Integer> direccion, int velocidad, ObserverGrafico observer) {
        Sprite sprite = fabricaSprites.getEstrellaEncendida();
        return new Estrella (sprite, posicion, visitor, velocidad, direccion, observer);
    } 
    
    @SuppressWarnings("exports")
	public ChampinionVerde getChampinionVerde(Vector<Integer>posicion,Visitante visitor, ObserverGrafico observer) {
        Sprite sprite = fabricaSprites.getChampinionVerde();
        return new ChampinionVerde (sprite, posicion, visitor, observer);
    }
    
    @SuppressWarnings("exports")
	public SuperChampinion getSuperChampinion(Vector<Integer>posicion,Visitante visitor, Vector<Integer> direccion, int velocidad, ObserverGrafico observer) {
        Sprite sprite = fabricaSprites.getSuperChampinion();
        return new SuperChampinion (sprite, posicion, visitor, velocidad, direccion, observer);
    }
    
    @SuppressWarnings("exports")
	public FlorDeFuego getFlorDeFuego(Vector<Integer>posicion,Visitante visitor, ObserverGrafico observer) {
        Sprite sprite = fabricaSprites.getFlorDeFuegoPrimeraTransicion();
        return new FlorDeFuego (sprite,posicion,visitor, observer);
    }
    
    @SuppressWarnings("exports")
	public Monedas getMonedas(Vector<Integer>posicion,Visitante visitor, int cantidad,ObserverGrafico observer ) {
        Sprite sprite = fabricaSprites.getMonedaEncendida();
        return new Monedas (sprite,posicion,visitor,observer, cantidad);
    }

}

