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
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;

import fuentes.Fuentes;
import sensoresDeTeclas.SensorDeTeclasMenu;

public class PantallaFinal extends JPanel {
    
    private static final long serialVersionUID = 893955111831369738L;

    protected JButton botonVolver;
    
    protected JButton botonCerrar;
    
    private JLabel puntajeLabel;
    
    private JLayeredPane panelCapas;
    
    protected SensorDeTeclasMenu sensor;
    
    protected ArregloDeBotones arregloDeBotones;
    
    protected Dimension size = new Dimension(ConstantesGlobales.PANEL_ANCHO, ConstantesGlobales.PANEL_ALTO);
    
    protected ControladorVistas controlador;
    
    protected Fuentes tipoFuentes;
    
    protected boolean enFoco;
    
    @SuppressWarnings("exports")
    public PantallaFinal (ControladorVistas controlador, SensorDeTeclasMenu sensor) {
        this.controlador = controlador;
        this.sensor = sensor;
        this.enFoco = false;
        setLayout(null);
        setPreferredSize(size);
        panelCapas = new JLayeredPane();
        panelCapas.setLayout(null);
        panelCapas.setBounds(0, 0, size.width, size.height);

        // Reemplazar JLabel por JButton
        botonVolver = new JButton("Pantalla inicial");
        botonCerrar = new JButton("Cerrar juego");

        configurarFuente();
        establecerFondo();
        establecerMensaje();
        configurarBotones();
        
        add(panelCapas);
        configurarMapasTeclado();
    }
    
    private void realizarAccionVolver() {
        controlador.dePantallaFinalAPantallaInicial();
    }
    
    private void realizarAccionCerrar() {
        System.exit(0);
    }
    
    private void establecerFondo() {
       JLabel fondo = new JLabel();
       fondo.setBackground(Color.BLACK);
       fondo.setOpaque(true);
       fondo.setBounds(0, 0, size.width, size.height);
       panelCapas.add(fondo, Integer.valueOf(0));
    }
    
    
    private void configurarFuente() {
        tipoFuentes = new Fuentes();
        botonVolver.setFont(tipoFuentes.fuente(tipoFuentes.pxl, 0, ConstantesGlobales.PANEL_ANCHO / 40));
        botonCerrar.setFont(tipoFuentes.fuente(tipoFuentes.pxl, 0, ConstantesGlobales.PANEL_ANCHO / 40));
    }
    
    private void establecerMensaje() {
        JLabel titulo = new JLabel("¡Fin de la partida!");
        titulo.setFont(tipoFuentes.fuente(tipoFuentes.pxl, 0, ConstantesGlobales.PANEL_ANCHO / 30));
        titulo.setForeground(Color.WHITE);
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        int posicionTituloY = size.height / 6;
        titulo.setBounds(0, posicionTituloY, size.width, 50);
        panelCapas.add(titulo, Integer.valueOf(1));
    }

    public void puntajeJugador(int puntaje) {
        puntajeLabel = new JLabel("Puntaje: " + puntaje, SwingConstants.CENTER);
        puntajeLabel.setFont(tipoFuentes.fuente(tipoFuentes.pxl, 0, ConstantesGlobales.PANEL_ANCHO / 30));
        puntajeLabel.setForeground(Color.WHITE);
        puntajeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        
        int posicionPuntajeY = size.height / 3;
        puntajeLabel.setBounds(0, posicionPuntajeY, size.width, 50);
        panelCapas.add(puntajeLabel, Integer.valueOf(1)); 
    }

    private void configurarBotones() {
        int alturaPantalla = size.height;
        int espaciadoBotones = 60; 
        int posicionPrimerBotonY = (2 * alturaPantalla / 3) + 50; 
        
        botonVolver.setBounds(
            (size.width - botonVolver.getPreferredSize().width) / 2, 
            posicionPrimerBotonY,
            botonVolver.getPreferredSize().width + 20, 
            botonVolver.getPreferredSize().height
        );
        
        botonCerrar.setBounds(
            (size.width - botonCerrar.getPreferredSize().width) / 2, 
            posicionPrimerBotonY + espaciadoBotones,
            botonCerrar.getPreferredSize().width + 20, 
            botonCerrar.getPreferredSize().height
        );
        
        botonVolver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                realizarAccionVolver();
            }
        });

        botonCerrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                realizarAccionCerrar();
            }
        });
        
        botonVolver.setBorderPainted(false);       
        botonVolver.setContentAreaFilled(false);    
        botonVolver.setFocusPainted(false);        
        botonVolver.setOpaque(false);               
        botonVolver.setForeground(Color.WHITE);
        
        botonCerrar.setBorderPainted(false);       
        botonCerrar.setContentAreaFilled(false);    
        botonCerrar.setFocusPainted(false);        
        botonCerrar.setOpaque(false);               
        botonCerrar.setForeground(Color.WHITE);

        add(botonVolver);
        add(botonCerrar);
    }
    
    private void configurarMapasTeclado() {
        InputMap inputMap = getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap actionMap = getActionMap();

        inputMap.put(KeyStroke.getKeyStroke("ENTER"), "volver");
        actionMap.put("volver", new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                realizarAccionVolver();
            }
        });

        inputMap.put(KeyStroke.getKeyStroke("ESCAPE"), "cerrar");
        actionMap.put("cerrar", new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                realizarAccionCerrar();
            }
        });
    }
    
    public void establecerEnFoco (boolean foco) {
    	this.enFoco = foco;
    }
}
