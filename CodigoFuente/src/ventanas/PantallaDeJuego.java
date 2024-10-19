package ventanas;

import java.awt.Dimension;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import elementos.entidades.Jugable;
import sensoresDeTeclas.SensorDeTeclasJuego;

public class PantallaDeJuego extends JPanel {
	
	private Dimension size;
	
	private Jugable marioJugable;
	
	private JLabel marioLabel;
	
	private JLabel fondo;
	
	private SensorDeTeclasJuego sensorDeTeclasJuego;
	
	private int posicionPreviaDeMario;
	
	public PantallaDeJuego(SensorDeTeclasJuego sensorDeTeclasJuego) {
		setVisible(true);
		fondo= new JLabel();
		configurarVentana();
	    this.sensorDeTeclasJuego = sensorDeTeclasJuego;
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
		/**
		 ImageIcon fondoImagen = new ImageIcon("src/imagenes/fondoPantallaJuego.png");
		 fondo = new JLabel(fondoImagen);
		 fondo.setPreferredSize(size);
		 fondo.setMaximumSize(size);
		 fondo.setMinimumSize(size);
		 fondo.setBounds(-100, -30, size.height, size.height);
		 add(fondo);
		 **/
		ImageIcon fondoImagen = new ImageIcon("src/imagenes/fondoPantallaJuego.png");
	    
	    fondo = new JLabel(fondoImagen);
	    
	    // El tamaño del JLabel es el del panel, pero la imagen de fondo se mantiene en 4000x760
	    fondo.setBounds(0, 0, 4000, size.height); // El borde izquierdo está en 0, pero la imagen tiene 4000 de ancho
	    
	    // Añades el JLabel al panel y lo mantienes alineado al borde izquierdo
	    add(fondo);
	    
	    // Forzar tamaño del panel a 960x760 para que solo se vea la parte izquierda del fondo
	    setPreferredSize(new Dimension(size.height, size.width));
	    setLayout(null); // Usamos layout nulo para controlar el posicionamiento exacto
	}
	
	public void registrarJugable(Jugable jugable) {
		marioJugable = jugable;
		posicionPreviaDeMario = marioJugable.getPosicion().x;
		ImageIcon marioIcono = new ImageIcon(marioJugable.getSprite().getRutaImagen());
		marioLabel = new JLabel(marioIcono);
		marioLabel.setBounds(marioJugable.getPosicion().x, marioJugable.getPosicion().y, marioIcono.getIconWidth(), marioIcono.getIconHeight());
		marioLabel.setVisible(true);
		add(marioLabel);
		establecerFondo();
	}
	
	public int moverADerecha() {
		int toRet = 0;
		if(sensorDeTeclasJuego.obtenerDPresionada()) {
			toRet = 10;
		}
		return toRet;
	}
	
	public void refrescar(){
		if(marioJugable.getPosicion().x < 300) {
			marioLabel.setLocation(marioJugable.getPosicion());
		}else if(marioJugable.getPosicion().x >= 300) {
			if(sensorDeTeclasJuego.obtenerAPresionada()) {
				marioLabel.setLocation(marioLabel.getLocation().x - 10, marioJugable.getPosicion().y);
			}else if(marioJugable.getPosicion().x >= 300 && marioLabel.getLocation().x >= 300){
				marioLabel.setLocation(marioLabel.getLocation().x, marioJugable.getPosicion().y);
				fondo.setLocation(fondo.getLocation().x - moverADerecha(), fondo.getLocation().y);
			}else if(sensorDeTeclasJuego.obtenerDPresionada()){
				marioLabel.setLocation(marioLabel.getLocation().x + 10, marioJugable.getPosicion().y);
			}
		}
		repaint();
	}
}
