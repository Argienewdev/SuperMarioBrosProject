package elementos;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Silueta {
    
	protected String rutaImagen;
	
	public Silueta(String rutaImagen) {
		this.rutaImagen = rutaImagen;
	}
	
	public String getRutaSilueta() {
		return this.rutaImagen;
	}
	
	public void setRutaSilueta(String rutaImagen) {
		this.rutaImagen = rutaImagen;
	}
	
	public int obtenerAncho() {
		int ancho = 0;
		
		try {
            BufferedImage imagen = ImageIO.read(new File(getRutaSilueta()));
            ancho = imagen.getWidth();
        } catch (IOException exception) {
            System.out.println("Error al cargar la imagen: " + exception.getMessage());
        }
		
		return ancho;
	}
	
	public int obtenerAlto() {
		int alto = 0;
		
		try {
            BufferedImage imagen = ImageIO.read(new File(getRutaSilueta()));
            alto = imagen.getHeight();
        } catch (IOException exception) {
            System.out.println("Error al cargar la imagen: " + exception.getMessage());
        }
		
		return alto;
	}
   
}
