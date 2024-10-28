package elementos.personajes;

import visitors.Visitante;
import visitors.VisitorMarioRecuperacion;

public class MarioRecuperacion extends MarioDefault {
	
	private int tiempoEnRecuperacion = 3000;
	
	public MarioRecuperacion () {
		
	}
	
	public void actualizarTiempo (int tiempoDelta) {
		tiempoEnRecuperacion--;
		if (tiempoEnRecuperacion <= 0)
			contexto.cambiarEstado(new MarioDefault());
	}
	
	 public void aceptarVisitante(Visitante visitante) {
	        visitante.visitarMarioRecuperacion(this);
	    }
		
		@Override
		public Visitante getVisitor() {
			 return new VisitorMarioRecuperacion(this);
		}

}
