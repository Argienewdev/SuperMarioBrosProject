package fabricas;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Sprite {
    protected Image imagen;
    protected int posX;
    protected int posY;
    
    public Sprite(String rutaImagen) {
        cargarImagen(rutaImagen);
        posX = 0;
        posY = 0;
    }

    
    public void cargarImagen(String rutaImagen) {
        try {
            imagen = ImageIO.read(new File(rutaImagen));
        } catch (IOException e) {
            System.err.println("Error al cargar la imagen: " + e.getMessage());
        }
    }

   
    public void dibujarEnPantalla(Graphics g) {
        if (imagen != null) {
            g.drawImage(imagen, posX, posY, null);
        }
    }

    public void setPosicion(int x, int y) {
        posX = x;
        posY = y;
    }

    public int getX() {
        return posX;
    }

    public int getY() {
        return posY;
    }

}
