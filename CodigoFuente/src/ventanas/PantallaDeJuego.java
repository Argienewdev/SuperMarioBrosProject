package ventanas;

import java.awt.Dimension;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PantallaDeJuego extends JPanel {
	
	private Dimension size;
	
	private JLabel mario;
	
	private JLabel fondo;
	
	public PantallaDeJuego() {
		setVisible(true);
		fondo= new JLabel();
		configurarVentana();
	    
	}
	
	protected void configurarVentana(){
		setVisible(true);
		setLayout(null);
		size = new Dimension(2200, DimensionesConstantes.PANEL_ALTO);
		setPreferredSize(size);
		setMaximumSize(size);
		setMinimumSize(size);
		establecerFondo();
	}
	
	protected void establecerFondo(){
		 ImageIcon fondoImagen = new ImageIcon(getClass().getResource("/imagenes/fondoJuegoCielo.png"));
		 Image imagen = fondoImagen.getImage();
		 fondo = new JLabel(new ImageIcon(imagen));
		 fondo.setPreferredSize(size);
		 fondo.setMaximumSize(size);
		 fondo.setMinimumSize(size);
		 fondo.setBounds(0, 0, size.width, size.height);
		 add(fondo);
	}
	
	public void correr(){
		int x = fondo.getX();
	    int y = fondo.getY();
	    x -= 10;
	    // Si el fondo se ha desplazado completamente fuera del panel, reiniciar la posición
	    if (x <= -size.width/2) {
	        x = 0;
	    }
	    fondo.setLocation(x, y);
	}
}
