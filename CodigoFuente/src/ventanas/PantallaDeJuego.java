package ventanas;

import java.awt.Dimension;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import elementos.entidades.Jugable;

public class PantallaDeJuego extends JPanel {
	
	private Dimension size;
	
	private Jugable marioJugable;
	
	private JLabel marioLabel;
	
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
	
	public void registrarJugable(Jugable jugable) {
		marioJugable = jugable;
		ImageIcon marioIcono = new ImageIcon(marioJugable.getSprite().getRutaImagen());
		marioLabel = new JLabel(marioIcono);
		marioLabel.setBounds(marioJugable.getPosicion().x, marioJugable.getPosicion().y, marioIcono.getIconWidth(), marioIcono.getIconHeight());
		marioLabel.setVisible(true);
		add(marioLabel);
		establecerFondo();
	}
	
	public void refrescar(){
		marioLabel.setLocation(marioJugable.getPosicion());
		repaint();
	}
}
