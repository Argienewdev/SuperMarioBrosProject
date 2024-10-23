package elementos.personajes;

import visitors.Visitante;
import visitors.VisitorMarioFuego;

public class MarioFuego extends SuperMario {
	
	@Override
    public void aceptarVisitante(Visitante visitante) {
        visitante.visitar(this);
    }
	@Override
	public Visitante getVisitor() {
		return new VisitorMarioFuego(this);
	}
}
