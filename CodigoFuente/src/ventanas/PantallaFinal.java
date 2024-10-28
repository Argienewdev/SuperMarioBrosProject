package ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import fuentes.Fuentes;

public class PantallaFinal extends JLayeredPane {

    private static final long serialVersionUID = 1L;
    private Fuentes tipoFuentes;
    private ControladorVistas controladorVistas;
    private Dimension size = new Dimension(DimensionesConstantes.PANEL_ANCHO, DimensionesConstantes.PANEL_ALTO);
    private JButton botonVolver;
    private JButton botonCerrar;
    private JPanel panelBotones;
    private JLabel puntajeLabel;

    public PantallaFinal(ControladorVistas controladorVistas) {
        this.controladorVistas = controladorVistas;
        tipoFuentes = new Fuentes();
        
        setPreferredSize(size);
        setLayout(new BorderLayout());
        setOpaque(true);
        setBackground(Color.BLACK);

        mensajeFinal();
        configurarBotones();
        asignarAccesosTeclado();
    }

    private void asignarAccesosTeclado() {
        getInputMap(WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("ENTER"), "volverInicio");
        getActionMap().put("volverInicio", new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                controladorVistas.mostrarPantallaInicial();
            }
        });

        // Asigna la tecla "Esc" al botón "Cerrar"
        getInputMap(WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("ESCAPE"), "cerrarJuego");
        getActionMap().put("cerrarJuego", new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                controladorVistas.cerrarJuego();
            }
        });
    }

    private void mensajeFinal() {
        JLabel mensajeFinal = new JLabel("¡Fin de la Partida!", SwingConstants.CENTER);
        mensajeFinal.setFont(tipoFuentes.fuente(tipoFuentes.pxl, 0, DimensionesConstantes.PANEL_ANCHO / 30));
        mensajeFinal.setForeground(Color.WHITE);
        add(mensajeFinal, BorderLayout.NORTH);
    }
    
    
    public void puntajeJugador(int puntaje) {
        puntajeLabel = new JLabel("Puntaje: " + puntaje, SwingConstants.CENTER);
        puntajeLabel.setFont(tipoFuentes.fuente(tipoFuentes.pxl, 0, DimensionesConstantes.PANEL_ANCHO / 30));
        puntajeLabel.setForeground(Color.WHITE);
        add(puntajeLabel, BorderLayout.CENTER);
    }
    
    private void configurarBotones() {
        botonVolver = new JButton("Volver a la Pantalla Inicial");
        botonVolver.setFocusable(false);
        botonVolver.addActionListener(e -> controladorVistas.mostrarPantallaInicial());

        botonCerrar = new JButton("Cerrar Juego");
        botonCerrar.setFocusable(false);
        botonCerrar.addActionListener(e -> controladorVistas.cerrarJuego());

        panelBotones = new JPanel();
        panelBotones.setBackground(Color.BLACK);
        panelBotones.add(botonVolver);
        panelBotones.add(botonCerrar);
        
        add(panelBotones, BorderLayout.SOUTH);
    }
}
