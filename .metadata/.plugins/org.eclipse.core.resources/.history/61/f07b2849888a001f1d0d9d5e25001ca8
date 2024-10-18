package elementos.enemigos;

import fabricas.Sprite;
import visitors.Visitante;

public class ContextoKoopaTroopa extends Enemigo {
	protected KoopaState estado;

    public ContextoKoopaTroopa (Sprite sprite, KoopaState estado) {
        this.sprite = sprite;
        this.estado = estado;
        killPoints = 90;
        deathPoints = 45;
    }

    //Operaciones
    public void cambiarEstado (KoopaState estado) {
        this.estado = estado;
    }

    public void aceptarVisitante(Visitante visitante) {
        estado.aceptarVisitante(this);
    }
}
