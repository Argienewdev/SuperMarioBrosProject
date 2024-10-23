package juego;

import java.awt.Point;
import java.util.Collection;

import elementos.entidades.NoJugable;

public class ControladorMovimientoEntidadesNoJugables {
	
	public void actualizarPosicion(Collection<NoJugable> entidadesNoJugables) {
		for(NoJugable entidadNoJugable : entidadesNoJugables) {
			entidadNoJugable.setPosicion(new Point(entidadNoJugable.getPosicion().x-1,entidadNoJugable.getPosicion().y));
			entidadNoJugable.setVelocidadDireccional(new Point(-1,0));
		}
	}
	
}
