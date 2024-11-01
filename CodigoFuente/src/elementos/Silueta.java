package elementos;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Silueta {
    
	protected String rutaImagen;
    private BufferedImage imagenCargada;  // Guarda la imagen cargada en memoria
    
	public Silueta(String rutaImagen) {
		this.rutaImagen = rutaImagen;
        cargarImagen();  // Carga la imagen en el constructor
	}
	
	public String obtenerRutaSilueta() {
		return this.rutaImagen;
	}
	
	public void establecerRutaSilueta(String rutaImagen) {
		this.rutaImagen = rutaImagen;
        cargarImagen();  // Recarga la imagen si la ruta cambia
	}
	
	// Carga la imagen desde la ruta proporcionada
	private void cargarImagen() {
		try {
            this.imagenCargada = ImageIO.read(new File(obtenerRutaSilueta()));
        } catch (IOException exception) {
        	System.err.println("El error está en Silueta.java");
            System.err.println("Error al cargar la imagen desde la ruta: " + obtenerRutaSilueta());
            System.err.println("Detalles del error: " + exception.getMessage());
            this.imagenCargada = null;  // Si hay error, se asegura de que sea null
        }
	}

	// Retorna el ancho de la imagen si fue cargada correctamente
	public int obtenerAncho() {
		if (imagenCargada !=  null) {
            return imagenCargada.getWidth();
        } else {
            System.err.println("Imagen no cargada.");
            return 0;
        }
	}
	
	// Retorna el alto de la imagen si fue cargada correctamente
	public int obtenerAlto() {
		if (imagenCargada !=  null) {
            return imagenCargada.getHeight();
        } else {
            System.err.println("Imagen no cargada.");
            return 0;
        }
	}
}
