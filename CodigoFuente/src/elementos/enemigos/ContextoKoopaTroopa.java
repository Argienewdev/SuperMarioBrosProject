package elementos.enemigos;

import java.util.Vector;

import fabricas.Sprite;
import visitors.Visitante;

public class ContextoKoopaTroopa extends Enemigo {
	protected EstadoKoopa estado;

    public ContextoKoopaTroopa (Sprite sprite,Vector<Integer> posicion, Visitante visitor, Vector<Integer> direccion,
			int velocidad, EstadoKoopa estado) {
    	super(sprite, posicion,visitor, direccion,velocidad,90,-45);
    	this.estado=estado;
    }

    //Operaciones
    public void cambiarEstado (EstadoKoopa estado) {
        this.estado = estado;
    }
    
    public void aceptarVisitante(Visitante visitante) {
        estado.aceptarVisitante(this);
    }
    
}
