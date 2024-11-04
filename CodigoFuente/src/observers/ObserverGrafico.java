package observers;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import elementos.ElementoDeJuego;
import ventanas.ConstantesGlobales;

@SuppressWarnings("serial")
public class ObserverGrafico extends JLabel implements Observer {
	
	private ElementoDeJuego entidad_observada;
	
	private boolean removido;
	
	public ObserverGrafico(ElementoDeJuego entidad_observada) {
		super();
		this.entidad_observada = entidad_observada;
		this.removido = false;
	}
	
	public ElementoDeJuego obtenerEntidadObservada() {
		return this.entidad_observada;
	}
	
	public void establecerRemovido(boolean removido) {
		this.removido = removido;
	}
	
	public boolean obtenerRemovido() {
		return this.removido;
	}
	
	public void actualizar() {
		actualizarImagen();
		actualizarPosicionTamanio();
		if(this.entidad_observada.obtenerPosicionGrafica().x <  ConstantesGlobales.PANEL_ANCHO
		&& this.entidad_observada.obtenerPosicionGrafica().x + this.entidad_observada.obtenerAncho() > 0) {
			this.entidad_observada.establecerVisibleEnPantalla(true);
		} else {
			this.entidad_observada.establecerVisibleEnPantalla(false);
		}
			
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
	
}
