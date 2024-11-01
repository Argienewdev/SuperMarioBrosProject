package observers;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import elementos.ElementoDeJuego;

@SuppressWarnings("serial")
public class ObserverGrafico extends JLabel implements Observer {
	
	private ElementoDeJuego entidad_observada;
	
	private boolean removido;
	
	public ObserverGrafico(ElementoDeJuego entidad_observada) {
		super();
		this.entidad_observada = entidad_observada;
		this.removido = false;
	}
	
	public void actualizar() {
		actualizarImagen();
		actualizarPosicionTamanio();
	}
	
	public ElementoDeJuego obtenerEntidadObservada() {
		return this.entidad_observada;
	}
	
	protected void actualizarImagen() {
		String ruta_imagen = entidad_observada.obtenerSprite().obtenerRutaImagen();
		ImageIcon icono = new ImageIcon(ruta_imagen);
		setIcon(icono);
	}
	
	protected void actualizarPosicionTamanio() {
		int x = entidad_observada.obtenerPosicionGrafica().x;
		int y = entidad_observada.obtenerPosicionGrafica().y;
		int ancho = this.getIcon().getIconWidth();
		int alto = this.getIcon().getIconHeight();
		setBounds(x, y, ancho, alto);
	}
	
	public void establecerRemovido(boolean removido) {
		this.removido = removido;
	}
	
	public boolean obtenerRemovido() {
		return this.removido;
	}
	
}
