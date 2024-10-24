package elementos;

import javax.swing.ImageIcon;

public class Sprite {
	
	protected String rutaImagen;
	
	public Sprite(String rutaImagen) {
		this.rutaImagen = rutaImagen;
	}
	
	public String getRutaImagen() {
		return this.rutaImagen;
	}
	
	public void setRutaImagen(String rutaImagen) {
		this.rutaImagen = rutaImagen;
	}
	
	public int getAnchoImagen() {
		ImageIcon imagen = new ImageIcon(this.getRutaImagen());
		return imagen.getIconWidth();
	}
	
	public int getAltoImagen() {
		ImageIcon imagen = new ImageIcon(this.getRutaImagen());
		return imagen.getIconHeight();
	}
	
	public boolean equals(Sprite sprite) {
		return this.getRutaImagen().equals(sprite.getRutaImagen());
	}

}
