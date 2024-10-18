package ventanas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import fuentes.Fuentes;

public class PantallaInicial extends JPanel {
	
	
	protected JLabel fondo;
	protected JLabel modo1;
	protected JLabel modo2;
	protected JLabel ranking;
	
	protected Dimension size = new Dimension(DimensionesConstantes.PANEL_ANCHO, DimensionesConstantes.PANEL_ALTO);
	Fuentes tipoFuentes;
	
	public PantallaInicial(){
		fondo = new JLabel();
		modo1 = new JLabel("MODO DE JUEGO 1");
		modo2 = new JLabel("MODO DE JUEGO 2"); 
		ranking= new JLabel("RANKING");
		configurarFuente();
		configurarVentana();
		ajustarDisposicion();
	}
	
	protected void ajustarDisposicion(){
		modo1.setBounds((size.width - modo1.getPreferredSize().width) / 2, (size.height / 2) - 30, modo1.getPreferredSize().width, modo1.getPreferredSize().height);
        modo2.setBounds((size.width - modo2.getPreferredSize().width) / 2, (size.height / 2) + 30, modo2.getPreferredSize().width, modo2.getPreferredSize().height);
        ranking.setBounds((size.width - ranking.getPreferredSize().width) / 2, (size.height / 2) + 90, ranking.getPreferredSize().width, ranking.getPreferredSize().height);
        fondo.add(modo1);
        fondo.add(modo2);
        fondo.add(ranking);
		}
	
	public void configurarFuente() {
		tipoFuentes= new Fuentes();
	    modo1.setFont(tipoFuentes.fuente(tipoFuentes.pxl, 0, 30));
	    modo2.setFont(tipoFuentes.fuente(tipoFuentes.pxl, 0, 30));
	    ranking.setFont(tipoFuentes.fuente(tipoFuentes.pxl, 0, 30));
	    modo1.setForeground(Color.white);
	    modo2.setForeground(Color.white);
	    ranking.setForeground(Color.white);
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
		 
		 ImageIcon iconoCartel = new ImageIcon(getClass().getResource("/imagenes/cartelSuperMarioBros.png"));
		 Image imagenCartel= iconoCartel.getImage();
		 Image imagenCartelEscalada= imagenCartel.getScaledInstance(400, 200, Image.SCALE_SMOOTH);
		 JLabel cartelLabel= new JLabel(new ImageIcon(imagenCartelEscalada));
		 cartelLabel.setBounds((size.width - 400) / 2, 50, 400, 300); 
		 
		 fondo = new JLabel(new ImageIcon(imagenEscalada));
		 fondo.setPreferredSize(size);
		 fondo.setMaximumSize(size);
		 fondo.setMinimumSize(size);
		 fondo.setBounds(0, 0, size.width, size.height);
		 add(fondo);
		 fondo.add(cartelLabel);
	}
}
