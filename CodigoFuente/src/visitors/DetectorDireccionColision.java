package visitors;


import elementos.ElementoDeJuego;
import elementos.entidades.Entidad;

public class DetectorDireccionColision {
	
	public void verificarColision(ElementoDeJuego elementoDeJuego, Entidad entidad) {
		if(choquePorDerecha(elementoDeJuego, entidad)) {
	    	entidad.retrotraerMovimientoHorizontal(elementoDeJuego.obtenerHitbox().x - entidad.obtenerAncho());
		}else if(choquePorIzquierda(elementoDeJuego, entidad)) {
	    	entidad.retrotraerMovimientoHorizontal(elementoDeJuego.obtenerHitbox().x + entidad.obtenerAncho());
		}else if(choquePorArriba(elementoDeJuego, entidad)) {
			entidad.setColisionAbajo(true);
			entidad.retrotraerMovimientoVertical(elementoDeJuego.obtenerHitbox().y - entidad.obtenerAlto());
		}else if(choquePorAbajo(elementoDeJuego, entidad)){
			entidad.setColisionArriba(true);
			entidad.retrotraerMovimientoVertical(elementoDeJuego.obtenerHitbox().y + elementoDeJuego.obtenerAlto()); 
		}
	}
	
	public boolean choquePorDerecha(ElementoDeJuego elementoDeJuego, Entidad entidad) {
		boolean hitboxSuperaPosicionDeElemento = entidad.obtenerHitbox().x + entidad.obtenerHitbox().width > elementoDeJuego.obtenerHitbox().x;
		boolean posicionTodaviaNoActualizada = !(entidad.getPosicion().x + entidad.obtenerAncho() > elementoDeJuego.getPosicion().x);
		return hitboxSuperaPosicionDeElemento && posicionTodaviaNoActualizada;
	}
	
	public boolean verficiarImpactoLateralEntreEnemigoYMario(Entidad mario, Entidad enemigo) {
		boolean enemigoImpactaPorDerecha= enemigo.obtenerHitbox().x < mario.obtenerHitbox().x + mario.obtenerHitbox().width;
		boolean enemigoImpactaPorIzquierda = enemigo.obtenerHitbox().x + enemigo.obtenerHitbox().width > mario.obtenerHitbox().x;
		boolean marioNoGolpeoPorArriba = !choquePorArriba(enemigo, mario);
		return ((enemigoImpactaPorIzquierda) || (enemigoImpactaPorDerecha)) && marioNoGolpeoPorArriba;
	}
	
	public boolean choquePorIzquierda(ElementoDeJuego elementoDeJuego, Entidad entidad) {
		boolean hitboxSuperaPosicionDeElemento = entidad.obtenerHitbox().x < elementoDeJuego.obtenerHitbox().x + elementoDeJuego.obtenerAncho();
		boolean posicionTodaviaNoActualizada = !(entidad.getPosicion().x < elementoDeJuego.getPosicion().x + elementoDeJuego.obtenerAncho());
		return hitboxSuperaPosicionDeElemento && posicionTodaviaNoActualizada;
	}
	
	public boolean choquePorArriba(ElementoDeJuego elementoDeJuego, Entidad entidad) {
		boolean hitboxSuperaPosicionDeElemento = entidad.obtenerHitbox().y + entidad.obtenerAlto() > elementoDeJuego.obtenerHitbox().y;
		boolean posicionTodaviaNoActualizada = !(entidad.getPosicion().y + entidad.obtenerAlto() > elementoDeJuego.getPosicion().y);
		boolean cayendo = entidad.getVelocidadDireccional().y > 0;
		return hitboxSuperaPosicionDeElemento && posicionTodaviaNoActualizada && cayendo;
	}
	
	public boolean choquePorAbajo(ElementoDeJuego elementoDeJuego, Entidad entidad) {
		boolean hitboxSuperaPosicionDeElemento = entidad.obtenerHitbox().y < elementoDeJuego.obtenerHitbox().y + elementoDeJuego.obtenerAlto();
		boolean posicionTodaviaNoActualizada = !(entidad.getPosicion().y < elementoDeJuego.getPosicion().y + elementoDeJuego.obtenerAlto());
		boolean subiendo = entidad.getVelocidadDireccional().y < 0;
		return hitboxSuperaPosicionDeElemento && posicionTodaviaNoActualizada && subiendo;
	}
	
}
