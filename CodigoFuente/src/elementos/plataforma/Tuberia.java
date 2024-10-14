package elementos.plataforma;

import java.util.Vector;

import elementos.enemigos.PiranhaPlant;
import fabricas.Sprite;
import visitors.Visitante;

public class Tuberia extends BloqueSolido{
    //Atributos de instancia
    protected PiranhaPlant planta;

    //Constructor
    public Tuberia (Sprite sprite, Vector<Integer> pos, PiranhaPlant planta) {
        super(sprite,pos);
        this.planta = planta;
    }

    //Operaciones
    public void aceptarVisitante(Visitante visitante) {
        visitante.visitarTuberia(this);
    }

}