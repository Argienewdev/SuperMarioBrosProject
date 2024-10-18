package observers;

import javax.swing.JLabel;

import juego.EntidadLogica;

public class ObserverGrafico extends JLabel implements Observer{
	
	//TODO esta clase debe actualizar los sprites segun el estado de las entidades
	
	private EntidadLogica entidad_observada;
	
	protected ObserverGrafico(EntidadLogica entidad_observada) {
		super();
		this.entidad_observada = entidad_observada;
	}
	
	public void actualizar() {
		actualizar_imagen();
		actualizar_posicion_tamano();
	}
	
	protected void actualizar_imagen() {
		//TODO cambiar SPRITE
//		String ruta_imagen = entidad_observada.get_sprite().get_ruta_imagen();
//		Sprite icono = new ImageIcon(getClass().getClassLoader().getResource(ruta_imagen));
//		setIcon(icono);
	}
	
	protected void actualizar_posicion_tamano() {
		int x = entidad_observada.getPosicion().x;
		int y = entidad_observada.getPosicion().y;
		int ancho = this.getIcon().getIconWidth();
		int alto = this.getIcon().getIconHeight();
		setBounds(x, y, ancho, alto);
	}
}
