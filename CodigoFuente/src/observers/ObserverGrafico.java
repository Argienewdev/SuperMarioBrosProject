package observers;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import elementos.Sprite;
import elementos.entidades.Entidad;;

public class ObserverGrafico extends JLabel implements Observer {
	
	private Entidad entidad_observada;
	
	//TODO por que no puede conocer a todas las entidades?
	public ObserverGrafico(Entidad entidad_observada) {
		super();
		this.entidad_observada = entidad_observada;
	}
	
	public void actualizar() {
		actualizar_imagen();
		actualizar_posicion_tamano();
	}
	
	protected void actualizar_imagen() {
		String ruta_imagen = entidad_observada.getSprite().getRutaImagen();
		ImageIcon icono = new ImageIcon(ruta_imagen);
		setIcon(icono);
	}
	
	protected void actualizar_posicion_tamano() {
		int x = entidad_observada.getPosicion().x;
		int y = entidad_observada.getPosicion().y;
		int ancho = this.getIcon().getIconWidth();
		int alto = this.getIcon().getIconHeight();
		setBounds(x, y, ancho, alto);
	}
	
}
