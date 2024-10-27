package ventanas;

import javax.swing.*;

import elementos.Sprite;
import fuentes.Fuentes;

import java.awt.*;

@SuppressWarnings("serial")
public class PantallaEntreNiveles extends JPanel {
    
    private JLabel puntajeLabel;
    private JLabel iconoLabel;
<<<<<<< HEAD
    private JLabel numeroLabel;
=======
    private JLabel vidasLabel;
>>>>>>> 70d0d9df42d5b0e3cf7c574be059b72cf3520273
    private Sprite marioSprite;
    private Fuentes tipoFuentes;
    
    public PantallaEntreNiveles(Sprite marioSprite) {
        setLayout(new BorderLayout());
        setBackground(Color.BLACK);
        this.tipoFuentes= new Fuentes();
        
        // Configurar los JLabel
        this.marioSprite = marioSprite;
<<<<<<< HEAD
        this.puntajeLabel = new JLabel("Puntaje");
=======
        this.puntajeLabel = new JLabel("Puntaje 0");
>>>>>>> 70d0d9df42d5b0e3cf7c574be059b72cf3520273
        this.iconoLabel = new JLabel(new ImageIcon(marioSprite.getRutaImagen()));
        this.vidasLabel = new JLabel("x3");
        configurarFuentes();
        crearPaneles();
        
        puntajeLabel.setForeground(Color.WHITE);
<<<<<<< HEAD
        numeroLabel.setForeground(Color.WHITE);
=======
        vidasLabel.setForeground(Color.WHITE);
>>>>>>> 70d0d9df42d5b0e3cf7c574be059b72cf3520273
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
        panelNorte.setOpaque(false); 
        panelNorte.setBackground(new Color(0, 0, 0, 0));
        panelCentro.setOpaque(false); 
        panelCentro.setBackground(new Color(0, 0, 0, 0));
        panelEste.add(puntajeLabel);
        panelNorte.add(panelOeste, BorderLayout.WEST);
        panelNorte.add(panelCentro, BorderLayout.CENTER);
        panelNorte.add(panelEste, BorderLayout.EAST);

        Box box = Box.createVerticalBox();
        box.add(Box.createVerticalStrut(300));
        box.add(panelSur);
        
        panelSur.add(iconoLabel);
        panelSur.add(vidasLabel);

        add(panelNorte, BorderLayout.NORTH);
        add(box, BorderLayout.CENTER);
	}
    
    protected void configurarFuentes(){
		puntajeLabel.setFont(tipoFuentes.fuente(tipoFuentes.pxl, 0, DimensionesConstantes.PANEL_ANCHO / 50));
<<<<<<< HEAD
		numeroLabel.setFont(tipoFuentes.fuente(tipoFuentes.pxl, 0, DimensionesConstantes.PANEL_ANCHO / 50));
		
		puntajeLabel.setForeground(Color.WHITE);
=======
		vidasLabel.setFont(tipoFuentes.fuente(tipoFuentes.pxl, 0, DimensionesConstantes.PANEL_ANCHO / 50));
		
		puntajeLabel.setForeground(Color.WHITE);
    }
    
    public void actualizarVidas(int vidas){
		vidasLabel.setText("x" + vidas);
    }
    
    public void actualizarPuntaje(int puntaje){
    	puntajeLabel.setText("Puntaje " + puntaje);
>>>>>>> 70d0d9df42d5b0e3cf7c574be059b72cf3520273
    }
    
    public void actualizarVidas(int vidas){
		numeroLabel.setText("x" + vidas);
	}
    
    @SuppressWarnings("exports")
	public void setIcono(ImageIcon icono) {
        iconoLabel.setIcon(icono);
    }

  
}
