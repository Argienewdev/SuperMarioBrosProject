package elementos.personajes;

import visitors.Visitante;
import visitors.VisitorSuperMario;

public class SuperMario extends MarioDefault {
	
	@Override
    public void aceptarVisitante(Visitante visitante) {
        visitante.visitar(this);
    }
	@Override
	public Visitante getVisitor() {
		return new VisitorSuperMario(this);
	}
}