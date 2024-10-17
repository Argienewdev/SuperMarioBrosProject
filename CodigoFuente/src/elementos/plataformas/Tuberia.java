package elementos.plataformas;

import java.util.Vector;

import elementos.Sprite;
import elementos.enemigos.PiranhaPlant;
import visitors.Visitante;

public class Tuberia extends BloqueSolido{
    //Atributos de instancia
    protected PiranhaPlant miPiranhaPlant;
    protected int altura;

    //Constructor
    public Tuberia (Sprite sprite, Vector<Integer> pos,Visitante visitor, PiranhaPlant miPiranhaPlant, int altura) {
        super(sprite,pos,visitor);
        this.miPiranhaPlant = miPiranhaPlant;
        this.altura=altura;
    }

    //Operaciones
    public void aceptarVisitante(Visitante visitante) {
        visitante.visitarTuberia(this);
    }

}