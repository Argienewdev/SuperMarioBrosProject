package visitors;

import elementos.ElementoDeJuego;
import elementos.entidades.Entidad;

public class DetectorDireccionColision {
	
	protected Entidad miEntidad;
	
	public DetectorDireccionColision(Entidad miEntidad) {
		this.miEntidad=miEntidad;	
	}
	
	public boolean choquePorDerecha(ElementoDeJuego elemento) {
		boolean parte1 = miEntidad.obtenerHitbox().x + miEntidad.obtenerHitbox().width > elemento.obtenerHitbox().x;
		boolean parte2 = !(miEntidad.getPosicion().x + miEntidad.obtenerAncho() > elemento.getPosicion().x);
		return parte1 && parte2;
	}
	
	public boolean choquePorIzquierda(ElementoDeJuego elemento) {
		boolean parte1 = miEntidad.obtenerHitbox().x < elemento.obtenerHitbox().x + elemento.obtenerHitbox().width;
		boolean parte2 = !(miEntidad.getPosicion().x < elemento.getPosicion().x + elemento.obtenerAncho());
		return parte1 && parte2;
	}
	
	public boolean choquePorArriba(ElementoDeJuego elemento) {
		boolean parte1 = miEntidad.obtenerHitbox().y + miEntidad.obtenerHitbox().height > elemento.obtenerHitbox().y;
		boolean parte2 = !(miEntidad.getPosicion().y + miEntidad.obtenerAlto() > elemento.getPosicion().y);
		boolean parte3 = miEntidad.getVelocidadDireccional().y > 0;
		return parte1 && parte2 && parte3;
	}
	
	public boolean choquePorAbajo(ElementoDeJuego elemento) {
		boolean parte1 = miEntidad.obtenerHitbox().y < elemento.obtenerHitbox().y + elemento.obtenerHitbox().height;
		boolean parte2 = !(miEntidad.getPosicion().y < elemento.getPosicion().y + elemento.obtenerAlto());
		boolean parte3 = miEntidad.getVelocidadDireccional().y < 0;
		return parte1 && parte2 && parte3;
	}
}
