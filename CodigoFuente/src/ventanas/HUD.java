package ventanas;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class HUD extends JPanel{
	
	private JLabel vidasLabel;
	private JLabel puntajeLabel;
	private JLabel tiempoLabel;
	
	public HUD(){
		setPreferredSize(new Dimension(DimensionesConstantes.VENTANA_ANCHO, DimensionesConstantes.PANEL_ALTO));
		setLayout(new BorderLayout());	
		vidasLabel= new JLabel("Vidas: 3");
		puntajeLabel= new JLabel("Puntaje 0");
		tiempoLabel= new JLabel("Tiempo: 00:00");
		crearPaneles();
	}
	
	protected void crearPaneles(){
		JPanel panelNorte = new JPanel(new BorderLayout());
        JPanel panelOeste = new JPanel();
        JPanel panelCentro = new JPanel();
        JPanel panelEste = new JPanel();
        panelOeste.add(vidasLabel);
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
