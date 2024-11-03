package ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;

import fuentes.Fuentes;

@SuppressWarnings("serial")
public class InterfazJuego extends JPanel{

	private JLabel vidasLabel;
	
	private JLabel puntajeLabel;
	
	private JLabel tiempoLabel;
	
	private JLabel nivelLabel;
	
	private Fuentes tipoFuentes;
	
	private boolean tiempoEnCero;

	private boolean tiempoDetenido;
	
	public InterfazJuego(){
		this.setPreferredSize(new Dimension(ConstantesGlobales.VENTANA_ANCHO, ConstantesGlobales.PANEL_ALTO));
		this.setLayout(new BorderLayout());
		this.vidasLabel =  new JLabel("Vidas: 3");
		this.puntajeLabel =  new JLabel("Puntaje 0");
		this.tiempoLabel =  new JLabel("Tiempo: 300:00");
		this.tiempoEnCero = false;
		this.nivelLabel = new JLabel("Nivel: 1");
		this.tiempoDetenido = false;
		this.setOpaque(false);
		this.setBackground(new Color(0, 0, 0, 0));
		this.configurarFuente();
		this.crearPaneles();
	}
	
	protected void crearPaneles(){
		JPanel panelNorte = new JPanel(new BorderLayout());
	    JPanel panelOeste = new JPanel();
	    JPanel panelCentro = new JPanel();
	    JPanel panelEste = new JPanel();
	    JPanel panelCentroI = new JPanel();
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
	    panelCentroI.setOpaque(false);
	    panelCentroI.setBackground(new Color(0, 0, 0, 0));
	    panelCentroI.add(nivelLabel);
	    panelEste.add(puntajeLabel);
	    panelNorte.add(panelOeste, BorderLayout.WEST);
	    panelNorte.add(panelCentro, BorderLayout.CENTER);
	    panelNorte.add(panelEste, BorderLayout.EAST);
	    panelNorte.add(panelCentroI, BorderLayout.NORTH);
	    panelNorte.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
	    this.add(panelNorte, BorderLayout.NORTH);
	}
	
	public void actualizarTiempo() {
	    if (!tiempoDetenido) {
	    	String tiempoTexto = tiempoLabel.getText().substring(8);
		    String[] tiempoPartes = tiempoTexto.split(":");
		    int segundos = Integer.parseInt(tiempoPartes[0]);
		    int miliSegundos = Integer.parseInt(tiempoPartes[1]);
		    if(segundos==0 && miliSegundos==0) {
		    	this.tiempoEnCero=true;
		    }else if (miliSegundos ==  0) {
		        if (segundos > 0) {
		            segundos--;
		            miliSegundos = 59;
		        }
		    } else {
		        miliSegundos--;
		    }	    
		    String nuevoTiempoTexto = String.format("Tiempo: %02d:%02d", segundos, miliSegundos);
		    this.tiempoLabel.setText(nuevoTiempoTexto);
	    }
	}
	
	public void actualizarVidas(int vidas){
		this.vidasLabel.setText("Vidas: " + vidas);
	}
	
	public void configurarFuente() {
		this.tipoFuentes =  new Fuentes();
		this.vidasLabel.setFont(tipoFuentes.fuente(tipoFuentes.pxl, 0, ConstantesGlobales.PANEL_ANCHO / 50));
		this.puntajeLabel.setFont(tipoFuentes.fuente(tipoFuentes.pxl, 0, ConstantesGlobales.PANEL_ANCHO / 50));
		this.tiempoLabel.setFont(tipoFuentes.fuente(tipoFuentes.pxl, 0, ConstantesGlobales.PANEL_ANCHO / 50));
		this.nivelLabel.setFont(tipoFuentes.fuente(tipoFuentes.pxl, 0, ConstantesGlobales.PANEL_ALTO / 55));
		this.vidasLabel.setForeground(Color.WHITE);
		this.puntajeLabel.setForeground(Color.WHITE);
		this.tiempoLabel.setForeground(Color.WHITE);
		this.nivelLabel.setForeground(Color.WHITE);
	}
	
	public void actualizarPuntaje(int puntaje) {
		this.puntajeLabel.setText("Puntaje " + puntaje);
	}
	
	public void actualizarNivel (int nivel) {
		this.nivelLabel.setText("Nivel " + nivel);
	}
	
	public boolean obtenerTiempoEnCero() {
		return this.tiempoEnCero;
	}
	
	public void detenerTiempo() {
		this.tiempoDetenido = true;
	}
	
}
