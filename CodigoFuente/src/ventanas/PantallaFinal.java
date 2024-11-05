package ventanas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;

import fuentes.Fuente;
import juego.ConstantesGlobales;
import sensoresDeTeclas.SensorDeTeclasMenu;

public class PantallaFinal extends Pantalla {
    
    private static final long serialVersionUID = 893955111831369738L;

    protected JButton botonVolver;
    
    private JLabel puntajeLabel;
    
    private JLayeredPane panelCapas;
    
    protected SensorDeTeclasMenu sensorDeTeclasMenu;
    
    protected ArregloDeBotones arregloDeBotones;
    
    protected Dimension tamanioPanel;
    
    protected ControladorVistas controlador;
    
    protected Fuente tipoFuentes;
    
    protected boolean enFoco;
    
    public PantallaFinal (ControladorVistas controlador, SensorDeTeclasMenu sensor) {
    	this.tamanioPanel = new Dimension(ConstantesGlobales.PANEL_ANCHO, ConstantesGlobales.PANEL_ALTO);
        this.controlador = controlador;
        this.sensorDeTeclasMenu = sensor;
        this.enFoco = false;
        setLayout(null);
        setPreferredSize(tamanioPanel);
        
        panelCapas = new JLayeredPane();
        panelCapas.setLayout(null);
        panelCapas.setBounds(0, 0, tamanioPanel.width, tamanioPanel.height);
        botonVolver = new JButton("Volver al menu");

        configurarFuente();
        establecerFondo();
        establecerMensaje();
        configurarBotones();
        
        add(panelCapas);
        configurarMapasTeclado();
    }
    
    private void configurarFuente() {
    	tipoFuentes = new Fuente();
    	botonVolver.setFont(tipoFuentes.fuente(tipoFuentes.nombreFuente(), 0, ConstantesGlobales.PANEL_ANCHO / 40));
    }
    
        
    private void establecerFondo() {
       JLabel fondo = new JLabel();
       fondo.setBackground(Color.BLACK);
       fondo.setOpaque(true);
       fondo.setBounds(0, 0, tamanioPanel.width, tamanioPanel.height);
       panelCapas.add(fondo, Integer.valueOf(0));
    }
    
    private void establecerMensaje() {
        JLabel titulo = new JLabel("¡Fin de la partida!");
        titulo.setFont(tipoFuentes.fuente(tipoFuentes.nombreFuente(), 0, ConstantesGlobales.PANEL_ANCHO / 30));
        titulo.setForeground(Color.WHITE);
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        int posicionTituloY = tamanioPanel.height / 6;
        titulo.setBounds(0, posicionTituloY, tamanioPanel.width, 50);
        panelCapas.add(titulo, Integer.valueOf(1));
    }

    private void configurarBotones() {
        int alturaPantalla = tamanioPanel.height;
        int posicionPrimerBotonY = (2 * alturaPantalla / 3) + 50; 
        
        botonVolver.setBounds(
            (tamanioPanel.width - botonVolver.getPreferredSize().width) / 2, 
            posicionPrimerBotonY,
            botonVolver.getPreferredSize().width + 20, 
            botonVolver.getPreferredSize().height
        );
        
        botonVolver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                realizarAccionVolver();
            }
        });

        botonVolver.setBorderPainted(false);       
        botonVolver.setContentAreaFilled(false);    
        botonVolver.setFocusPainted(false);        
        botonVolver.setOpaque(false);               
        botonVolver.setForeground(Color.LIGHT_GRAY);
        

        add(botonVolver);
    }
    
    private void realizarAccionVolver() {
    	controlador.dePantallaFinalAPantallaInicial();
    }
    
    @SuppressWarnings("serial")
	private void configurarMapasTeclado() {
        InputMap inputMap = getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap actionMap = getActionMap();

        inputMap.put(KeyStroke.getKeyStroke("ENTER"), "volver");
        actionMap.put("volver", new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                realizarAccionVolver();
            }
        });
    }
    
    public void puntajeJugador(int puntaje) {
    	puntajeLabel = new JLabel("Puntaje: " + puntaje, SwingConstants.CENTER);
    	puntajeLabel.setFont(tipoFuentes.fuente(tipoFuentes.nombreFuente(), 0, ConstantesGlobales.PANEL_ANCHO / 30));
    	puntajeLabel.setForeground(Color.WHITE);
    	puntajeLabel.setHorizontalAlignment(SwingConstants.CENTER);
    	
    	int posicionPuntajeY = tamanioPanel.height / 3;
    	puntajeLabel.setBounds(0, posicionPuntajeY, tamanioPanel.width, 50);
    	panelCapas.add(puntajeLabel, Integer.valueOf(1)); 
    }
    
    public void refrescar() {
    }
    
    public void establecerEnFoco (boolean foco) {
    	this.enFoco = foco;
    }
   
}
