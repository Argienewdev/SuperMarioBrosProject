package observers;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import elementos.ElementoDeJuego;

@SuppressWarnings("serial")
public class ObserverGrafico extends JLabel implements Observer {
	
	private ElementoDeJuego entidad_observada;
	
	public ObserverGrafico(ElementoDeJuego entidad_observada) {
		super();
		this.entidad_observada = entidad_observada;
	}
	
	public void actualizar() {
		actualizarImagen();
		actualizarPosicionTamanio();
	}
	
	public ElementoDeJuego getEntidadObservada() {
		return this.entidad_observada;
	}
	
	protected void actualizarImagen() {
		String ruta_imagen = entidad_observada.obtenerSprite().obtenerRutaImagen();
		ImageIcon icono = new ImageIcon(ruta_imagen);
		setIcon(icono);
	}
	
	protected void actualizarPosicionTamanio() {
		int x = entidad_observada.obtenerPosicion().x;
		int y = entidad_observada.obtenerPosicion().y;
		int ancho = this.getIcon().getIconWidth();
		int alto = this.getIcon().getIconHeight();
		setBounds(x, y, ancho, alto);
	}
}
