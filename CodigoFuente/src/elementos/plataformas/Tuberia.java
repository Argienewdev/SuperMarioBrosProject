package elementos.plataformas;

import java.util.Vector;

import elementos.enemigos.PiranhaPlant;
import fabricas.Sprite;
import visitors.Visitante;

public class Tuberia extends BloqueSolido{
    //Atributos de instancia
    protected PiranhaPlant planta;

    //Constructor
    public Tuberia (Sprite sprite, Vector<Integer> pos,Visitante visitor, PiranhaPlant planta) {
        super(sprite,pos,visitor);
        this.planta = planta;
    }

    //Operaciones
    public void aceptarVisitante(Visitante visitante) {
        visitante.visitarTuberia(this);
    }

}