package ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;

import fuentes.Fuentes;

@SuppressWarnings("serial")
public class Interfaz extends JPanel{

private JLabel vidasLabel;
private JLabel puntajeLabel;
private JLabel tiempoLabel;
private Fuentes tipoFuentes;


	public Interfaz(){
		setPreferredSize(new Dimension(ConstantesGlobales.VENTANA_ANCHO, ConstantesGlobales.PANEL_ALTO));
		setLayout(new BorderLayout());
		vidasLabel= new JLabel("Vidas: 3");
		puntajeLabel= new JLabel("Puntaje 0");
		tiempoLabel= new JLabel("Tiempo: 300:00");
		    
		setOpaque(false);
		setBackground(new Color(0, 0, 0, 0));
		configurarFuente();
		crearPaneles();
	
	}
	
	protected void crearPaneles(){
		JPanel panelNorte = new JPanel(new BorderLayout());
	    JPanel panelOeste = new JPanel();
	    JPanel panelCentro = new JPanel();
	    JPanel panelEste = new JPanel();
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
	    panelNorte.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
	    add(panelNorte, BorderLayout.NORTH);
	}
	
	public void actualizarTiempo(){
	    String tiempoTexto = tiempoLabel.getText().substring(8);
	    
	    String[] tiempoPartes = tiempoTexto.split(":");
	    int segundos = Integer.parseInt(tiempoPartes[0]);
	    int miliSegundos = Integer.parseInt(tiempoPartes[1]);
	    
	    if (miliSegundos == 0) {
	        if (segundos > 0) {
	            segundos--;
	            miliSegundos = 59;
	        }
	    } else {
	        miliSegundos--;
	    }
	    
	    String nuevoTiempoTexto = String.format("Tiempo: %02d:%02d", segundos, miliSegundos);
	    tiempoLabel.setText(nuevoTiempoTexto);
	}
	
	public void actualizarVidas(int vidas){
		vidasLabel.setText("Vidas: " + vidas);
	}
	
	public void configurarFuente() {
		tipoFuentes= new Fuentes();
		vidasLabel.setFont(tipoFuentes.fuente(tipoFuentes.pxl, 0, ConstantesGlobales.PANEL_ANCHO / 50));
		puntajeLabel.setFont(tipoFuentes.fuente(tipoFuentes.pxl, 0, ConstantesGlobales.PANEL_ANCHO / 50));
		tiempoLabel.setFont(tipoFuentes.fuente(tipoFuentes.pxl, 0, ConstantesGlobales.PANEL_ANCHO / 50));
		vidasLabel.setForeground(Color.WHITE);
		puntajeLabel.setForeground(Color.WHITE);
		tiempoLabel.setForeground(Color.WHITE);
	}
	
	public void actualizarPuntaje(int puntaje) {
		puntajeLabel.setText("Puntaje " + puntaje);
	}
}
