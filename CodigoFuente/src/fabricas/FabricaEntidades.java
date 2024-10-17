package fabricas;
import java.util.Vector;

import elementos.*;
import juego.Silueta;
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

    public Spiny getSpiny(Vector<Integer>posicion,Visitante visitor, Vector<Integer> direccion, int velocidad) {
        Sprite sprite = fabricaSprites.getSpiny();
        return new Spiny (sprite, posicion, visitor, velocidad, direccion);
    }
    public PiranhaPlant getPiranhaPlant(Vector<Integer>posicion,Visitante visitor, Vector<Integer> direccion, int velocidad, Tuberia tub) {
        Sprite sprite = fabricaSprites.getPiranhaPlant();
        return new PiranhaPlant(sprite,posicion,visitor,direccion,velocidad,tub);
    }
    public Lakitu getLakitu(Vector<Integer>posicion,Visitante visitor, Vector<Integer> direccion, int velocidad) {
        Sprite sprite = fabricaSprites.getLakitu();
        return new Lakitu (sprite,posicion,visitor,direccion,velocidad);
    }
    public BuzzyBeetle getBuzzyBeetle(Vector<Integer>posicion,Visitante visitor, Vector<Integer> direccion, int velocidad) {
        Sprite sprite = fabricaSprites.getBuzzyBeetle();
        return new BuzzyBeetle (sprite,posicion,visitor,direccion,velocidad);
    }
    public Goomba getGoomba(Vector<Integer>posicion,Visitante visitor, Vector<Integer> direccion, int velocidad){
        Sprite sprite = fabricaSprites.getGoomba();
        return new Goomba (sprite,posicion,visitor,direccion,velocidad);
    }
    public Bowser getBowser(Vector<Integer>posicion,Visitante visitor, Vector<Integer> direccion, int velocidad) {
        Sprite sprite = fabricaSprites.getBowser();
        return new Bowser (sprite,posicion,visitor,direccion,velocidad);
    }
    public Estrella getEstrella(Vector<Integer>posicion,Visitante visitor, Vector<Integer> direccion, int velocidad) {
        Sprite sprite = fabricaSprites.getEstrella();
        return new Estrella (sprite,posicion,visitor,direccion,velocidad);
    }
    public ChampinionVerde getChampinionVerde(Vector<Integer>posicion,Visitante visitor) {
        Sprite sprite = fabricaSprites.getChampinionVerde();
        return new ChampinionVerde (sprite,posicion,visitor);
    }
    public SuperChampinion getSuperChampinion(Vector<Integer>posicion,Visitante visitor, Vector<Integer> direccion, int velocidad) {
        Sprite sprite = fabricaSprites.getSuperChampinion();
        return new SuperChampinion (sprite,posicion,visitor,direccion,velocidad);
    }
    public FlorDeFuego getFlorDeFuego(Vector<Integer>posicion,Visitante visitor) {
        Sprite sprite = fabricaSprites.getFlorDeFuego();
        return new FlorDeFuego (sprite,posicion,visitor);
    }
    public Monedas getMonedas(Vector<Integer>posicion,Visitante visitor, int cantidad) {
        Sprite sprite = fabricaSprites.getMonedas();
        return new Monedas (sprite,posicion,visitor,cantidad);
    }

}
