package ventanas;

import javax.swing.*;

import elementos.Sprite;
import fuentes.Fuentes;

import java.awt.*;

public class PantallaEntreNiveles extends JPanel {
    
    private JLabel vidasLabel;
    private JLabel puntajeLabel;
    private JLabel tiempoLabel;
    private JLabel iconoLabel;
    private JLabel numeroLabel;
    private Sprite marioSprite;
    private Fuentes tipoFuentes;
    
    public PantallaEntreNiveles(Sprite marioSprite) {
        setLayout(new BorderLayout());
        setBackground(Color.BLACK);
        this.tipoFuentes= new Fuentes();
        
        // Configurar los JLabel
        this.marioSprite = marioSprite;
        this.vidasLabel = new JLabel("Vidas");
        this.puntajeLabel = new JLabel("Puntaje");
        this.tiempoLabel = new JLabel("Tiempo");
        this.iconoLabel = new JLabel(new ImageIcon(marioSprite.getRutaImagen()));
        this.numeroLabel = new JLabel("x3");
        configurarFuentes();
        crearPaneles();
        
        // Establecer color de texto
        vidasLabel.setForeground(Color.WHITE);
        puntajeLabel.setForeground(Color.WHITE);
        tiempoLabel.setForeground(Color.WHITE);
        numeroLabel.setForeground(Color.WHITE);
    }
    
    protected void crearPaneles(){
    	JPanel panelNorte = new JPanel(new BorderLayout());
        JPanel panelOeste = new JPanel();
        JPanel panelCentro = new JPanel();
        JPanel panelEste = new JPanel();
        JPanel panelSur = new JPanel();

        panelSur.setOpaque(false);
        panelSur.setBackground(new Color(0,0,0,0));
        panelEste.setOpaque(false);
        panelEste.setBackground(new Color(0, 0, 0, 0));
        panelOeste.setOpaque(false); 
        panelOeste.setBackground(new Color(0, 0, 0, 0));
        panelOeste.add(vidasLabel);
        panelNorte.setOpaque(false); 
        panelNorte.setBackground(new Color(0, 0, 0, 0));
        panelCentro.setOpaque(false); 
        panelCentro.setBackground(new Color(0, 0, 0, 0));
        panelCentro.add(tiempoLabel);
        panelEste.add(puntajeLabel);
        panelNorte.add(panelOeste, BorderLayout.WEST);
        panelNorte.add(panelCentro, BorderLayout.CENTER);
        panelNorte.add(panelEste, BorderLayout.EAST);

        // Usar BoxLayout para crear espacio vacío arriba del panelSur
        Box box = Box.createVerticalBox();
        box.add(Box.createVerticalStrut(300)); // Ajusta la altura del espacio vacío según sea necesario
        box.add(panelSur);
        
        panelSur.add(iconoLabel);
        panelSur.add(numeroLabel);

        add(panelNorte, BorderLayout.NORTH);
        add(box, BorderLayout.CENTER);
	}
    
    protected void configurarFuentes(){
		vidasLabel.setFont(tipoFuentes.fuente(tipoFuentes.pxl, 0, DimensionesConstantes.PANEL_ANCHO / 50));
		puntajeLabel.setFont(tipoFuentes.fuente(tipoFuentes.pxl, 0, DimensionesConstantes.PANEL_ANCHO / 50));
		tiempoLabel.setFont(tipoFuentes.fuente(tipoFuentes.pxl, 0, DimensionesConstantes.PANEL_ANCHO / 50));
		numeroLabel.setFont(tipoFuentes.fuente(tipoFuentes.pxl, 0, DimensionesConstantes.PANEL_ANCHO / 50));
		
		vidasLabel.setForeground(Color.WHITE);
		puntajeLabel.setForeground(Color.WHITE);
		tiempoLabel.setForeground(Color.WHITE);
    }
    
    public void setIcono(ImageIcon icono) {
        iconoLabel.setIcon(icono);
    }

  
}
