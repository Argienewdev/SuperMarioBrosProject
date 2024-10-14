package fabricas;

import java.util.Vector;

import elementos.enemigos.*;
import elementos.entidades.*;
import elementos.powerUp.*;
import juego.Silueta;
import elementos.plataforma.*;

public class FabricaEntidades {
    
    protected FabricaSprites fabricaSprites;


    public FabricaEntidades (FabricaSprites fabricaSprites) {
        this.fabricaSprites = fabricaSprites;
    }

  
    public Silueta getSilueta (int num_nivel) {
        Sprite sprite = fabricaSprites.getSilueta(num_nivel);
        return new Silueta (sprite);
    }
    public Spiny getSpiny (Vector<Integer> pos, Vector<Integer> dir, int velocidad) {
        Sprite sprite = fabricaSprites.getSpiny();
        return new Spiny (sprite,pos,dir,velocidad);
    }
    public PiranhaPlant getPiranhaPlant (Vector<Integer> pos, Vector<Integer> dir, int velocidad, Tuberia tub) {
        Sprite sprite = fabricaSprites.getPiranhaPlant();
        return new PiranhaPlant(sprite,pos,dir,velocidad,tub);
    }
    public Lakitu getLakitu (Vector<Integer> pos, Vector<Integer> dir, int velocidad) {
        Sprite sprite = fabricaSprites.getLakitu();
        return new Lakitu (sprite,pos,dir,velocidad);
    }
    public BuzzyBeetle getBuzzyBeetle (Vector<Integer> pos, Vector<Integer> dir, int velocidad) {
        Sprite sprite = fabricaSprites.getBuzzyBeetle();
        return new BuzzyBeetle (sprite,pos,dir,velocidad);
    }
    public Goomba getGoomba (Vector<Integer> pos, Vector<Integer> dir, int velocidad){
        Sprite sprite = fabricaSprites.getGoomba();
        return new Goomba (sprite,pos,dir,velocidad);
    }
    public Bowser getBowser (Vector<Integer> pos, Vector<Integer> dir, int velocidad) {
        Sprite sprite = fabricaSprites.getBowser();
        return new Bowser (sprite,pos,dir,velocidad);
    }
    public Estrella getEstrella (Vector<Integer> pos, Vector<Integer> dir, int velocidad) {
        Sprite sprite = fabricaSprites.getEstrella();
        return new Estrella (sprite,pos,dir,velocidad);
    }
    public ChampinionVerde getChampinionVerde (Vector<Integer> pos) {
        Sprite sprite = fabricaSprites.getChampinionVerde();
        return new ChampinionVerde (sprite,pos);
    }
    public SuperChampinion getSuperChampinion (Vector<Integer> pos, Vector<Integer> dir, int velocidad) {
        Sprite sprite = fabricaSprites.getSuperChampinion();
        return new SuperChampinion (sprite,pos,dir,velocidad);
    }
    public FlorDeFuego getFlorDeFuego (Vector<Integer> pos) {
        Sprite sprite = fabricaSprites.getFlorDeFuego();
        return new FlorDeFuego (sprite,pos);
    }
    public Moneda getMoneda (Vector<Integer> pos, int cantidad) {
        Sprite sprite = fabricaSprites.getMoneda();
        return new Moneda (sprite,pos,cantidad);
    }
    public ContextoMario ...
    public ContextoKoopa ...

}