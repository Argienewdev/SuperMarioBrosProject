package elementos.personajes;

import visitors.Visitante;
import visitors.VisitorMarioDefault;
import visitors.VisitorMarioInvulnerable;

public class MarioInvulnerable  extends MarioDefault {
	
	protected static final int DURACION = 10;
	
	@Override
    public void aceptarVisitante(Visitante visitante) {
        visitante.visitar(this);
    }
	@Override
	public Visitante getVisitor() {
		 return new VisitorMarioInvulnerable(this);
	}
}
