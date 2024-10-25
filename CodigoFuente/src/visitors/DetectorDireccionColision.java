package visitors;


import elementos.ElementoDeJuego;
import elementos.entidades.Entidad;

public class DetectorDireccionColision {
	
	
	public DetectorDireccionColision() {
	}
	
	public void verificarColision(ElementoDeJuego elementoDeJuego, Entidad entidad) {
		if (choquePorDerecha(elementoDeJuego, entidad) || choquePorIzquierda(elementoDeJuego, entidad)) {
	    	entidad.retrotraerMovimientoHorizontal();
		}
		if(choquePorArriba(elementoDeJuego, entidad)) {
			entidad.setColisionAbajo(true);
			entidad.retrotraerMovimientoVertical(elementoDeJuego.obtenerHitbox().y - entidad.obtenerHitbox().height);
		}
		if(choquePorAbajo(elementoDeJuego, entidad)){
			entidad.setColisionArriba(true);
			entidad.retrotraerMovimientoVertical(elementoDeJuego.obtenerHitbox().y + entidad.obtenerHitbox().height); 
		}
	}
	
	public void verificarColisionEntreEntidades(Entidad entidad1, Entidad entidad2) {
		if (choquePorDerecha(entidad1, entidad2) || choquePorIzquierda(entidad1, entidad2)) {
			entidad2.retrotraerMovimientoHorizontal();
		}
		if(choquePorArriba(entidad1, entidad2)) {
			entidad2.setColisionAbajo(true);
			entidad2.retrotraerMovimientoVertical(entidad1.obtenerHitbox().y - entidad2.obtenerHitbox().height);
		}
		if(choquePorAbajo(entidad1, entidad2)){
			entidad2.setColisionArriba(true);
			entidad2.retrotraerMovimientoVertical(entidad1.obtenerHitbox().y + entidad2.obtenerHitbox().height); 
		}
	}
	
	public boolean choquePorDerecha(ElementoDeJuego elementoDeJuego, Entidad entidad) {
		boolean parte1 = entidad.obtenerHitbox().x + entidad.obtenerHitbox().width > elementoDeJuego.obtenerHitbox().x;
		boolean parte2 = !(entidad.getPosicion().x + entidad.obtenerAncho() > elementoDeJuego.getPosicion().x);
		return parte1 && parte2;
	}
	
	public boolean choquePorIzquierda(ElementoDeJuego elementoDeJuego, Entidad entidad) {
		boolean parte1 = entidad.obtenerHitbox().x < elementoDeJuego.obtenerHitbox().x + elementoDeJuego.obtenerHitbox().width;
		boolean parte2 = !(entidad.getPosicion().x < elementoDeJuego.getPosicion().x + elementoDeJuego.obtenerAncho());
		return parte1 && parte2;
	}
	
	public boolean choquePorArriba(ElementoDeJuego elementoDeJuego, Entidad entidad) {
		boolean parte1 = entidad.obtenerHitbox().y + entidad.obtenerHitbox().height > elementoDeJuego.obtenerHitbox().y;
		boolean parte2 = !(entidad.getPosicion().y + entidad.obtenerAlto() > elementoDeJuego.getPosicion().y);
		boolean parte3 = entidad.getVelocidadDireccional().y > 0;
		return parte1 && parte2 && parte3;
	}
	
	public boolean choquePorAbajo(ElementoDeJuego elementoDeJuego, Entidad entidad) {
		boolean parte1 = entidad.obtenerHitbox().y < elementoDeJuego.obtenerHitbox().y + elementoDeJuego.obtenerHitbox().height;
		boolean parte2 = !(entidad.getPosicion().y < elementoDeJuego.getPosicion().y + elementoDeJuego.obtenerAlto());
		boolean parte3 = entidad.getVelocidadDireccional().y < 0;
		return parte1 && parte2 && parte3;
	}
}
