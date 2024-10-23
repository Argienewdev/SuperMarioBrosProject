package ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Interfaz extends JPanel{
	
	private JLabel vidasLabel;
	private JLabel puntajeLabel;
	private JLabel tiempoLabel;
	
	public Interfaz(){
		setPreferredSize(new Dimension(DimensionesConstantes.VENTANA_ANCHO, DimensionesConstantes.PANEL_ALTO));
		setLayout(new BorderLayout());	
		vidasLabel= new JLabel("Vidas: 3");
		puntajeLabel= new JLabel("Puntaje 0");
		tiempoLabel= new JLabel("Tiempo: 00:00");
        setOpaque(false); // Hace que el panel sea no opaco (transparente)
        setBackground(new Color(0, 0, 0, 0));
		crearPaneles();
	}
	
	protected void crearPaneles(){
		JPanel panelNorte = new JPanel(new BorderLayout());
        JPanel panelOeste = new JPanel();
        JPanel panelCentro = new JPanel();
        JPanel panelEste = new JPanel();
        panelEste.setOpaque(false); // Hace que el panel sea no opaco (transparente)
        panelEste.setBackground(new Color(0, 0, 0, 0));
        panelOeste.setOpaque(false); // Hace que el panel sea no opaco (transparente)
        panelOeste.setBackground(new Color(0, 0, 0, 0));
        panelOeste.add(vidasLabel);
        panelNorte.setOpaque(false); // Hace que el panel sea no opaco (transparente)
        panelNorte.setBackground(new Color(0, 0, 0, 0));
        panelCentro.setOpaque(false); // Hace que el panel sea no opaco (transparente)
        panelCentro.setBackground(new Color(0, 0, 0, 0));
        panelCentro.add(tiempoLabel);
        panelEste.add(puntajeLabel);
        panelNorte.add(panelOeste, BorderLayout.WEST);
        panelNorte.add(panelCentro, BorderLayout.CENTER);
        panelNorte.add(panelEste, BorderLayout.EAST);
        add(panelNorte, BorderLayout.NORTH);
	}
	
	public void actualizarTiempo(){
	}
	
	public void actualizarVidas(){
		
	}
	
	public void actualizarPuntaje() {
		//puntaje= jugador.getPuntos();
	}
}
