package ventanas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.io.IOException;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import fuentes.Fuentes;

public class PantallaInicial extends JPanel {
	
	
	protected JLabel fondo;
	protected JLabel modo1;
	protected JLabel modo2;
	protected Dimension size = new Dimension(DimensionesConstantes.PANEL_ANCHO, DimensionesConstantes.PANEL_ALTO);
	Fuentes tipoFuentes;
	
	public PantallaInicial(){
		fondo = new JLabel();
		modo1 = new JLabel("modo de juego 1");
		modo2 = new JLabel("modo de juego 2"); 
		configurarFuente();
		configurarVentana();
		ajustarDisposicion();
	}
	
	protected void ajustarDisposicion(){
		
		}
	
	public void configurarFuente() {
		tipoFuentes= new Fuentes();
	    modo1.setFont(tipoFuentes.fuente(tipoFuentes.pxl, 0, 40));
	    modo2.setFont(tipoFuentes.fuente(tipoFuentes.pxl, 0, 40));
	}
	
	protected void configurarVentana(){
		new JPanel();
		setLayout(null);
		setPreferredSize(size);
		setMaximumSize(size);
		setMinimumSize(size);
		setBounds(0, 0, size.width * 2, size.height);
		establecerFondo();
	}
	
	protected void establecerFondo(){
		 ImageIcon fondoImagen = new ImageIcon(getClass().getResource("/imagenes/fondoJuegoCielo.png"));
		 Image imagen = fondoImagen.getImage();
		 Image imagenEscalada = imagen.getScaledInstance(DimensionesConstantes.PANEL_ANCHO, DimensionesConstantes.PANEL_ALTO, Image.SCALE_SMOOTH);
		 fondo = new JLabel(new ImageIcon(imagenEscalada));
		 fondo.setPreferredSize(size);
		 fondo.setMaximumSize(size);
		 fondo.setMinimumSize(size);
		 fondo.setBounds(0, 0, size.width * 2, size.height);
		 add(fondo);
	}
}
