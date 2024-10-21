package observers;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import elementos.ElementoDeJuego;
import elementos.entidades.Entidad;;

@SuppressWarnings("serial")
public class ObserverGrafico extends JLabel implements Observer {
	
	private ElementoDeJuego entidad_observada;
	
	@SuppressWarnings("exports")
	public ObserverGrafico(ElementoDeJuego entidad_observada) {
		super();
		this.entidad_observada = entidad_observada;
	}
	
	public void actualizar() {
		actualizar_imagen();
		actualizar_posicion_tamanio();
	}
	
	protected void actualizar_imagen() {
		String ruta_imagen = entidad_observada.getSprite().getRutaImagen();
		ImageIcon icono = new ImageIcon(ruta_imagen);
		setIcon(icono);
	}
	
	protected void actualizar_posicion_tamanio() {
		int x = entidad_observada.getPosicion().x;
		int y = entidad_observada.getPosicion().y;
		int ancho = this.getIcon().getIconWidth();
		int alto = this.getIcon().getIconHeight();
		setBounds(x, y, ancho, alto);
	}
	
}
