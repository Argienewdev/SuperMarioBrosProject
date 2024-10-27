package ventanas;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.KeyStroke;
import fuentes.Fuentes;

public class PantallaFinal extends JPanel {

    private static final long serialVersionUID = 1L;

    private Fuentes tipoFuentes;

    private ControladorVistas controladorVistas;

    private JLabel fondo;

    private JButton botonVolver;
    private JButton botonCerrar;
    private int botonSeleccionado = 0; // 0 para botonVolver, 1 para botonCerrar

    protected Dimension size = new Dimension(DimensionesConstantes.PANEL_ANCHO, DimensionesConstantes.PANEL_ALTO);

    public PantallaFinal(ControladorVistas controladorVistas) {
        this.controladorVistas = controladorVistas;
        setLayout(new BorderLayout());
        setPreferredSize(size);
        tipoFuentes = new Fuentes();
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(size);
        establecerFondo(layeredPane);
        mensajeFinal(layeredPane);
        crearPanelBotones();
        configurarBindings();
        layeredPane.add(crearPanelBotones(), Integer.valueOf(1)); // Añadir el panel de botones al layeredPane
        add(layeredPane, BorderLayout.CENTER);
    }

    private void establecerFondo(JLayeredPane layeredPane) {
        fondo = new JLabel(new ImageIcon("src/imagenes/fondoJuegoCielo.png"));
        fondo.setBounds(0, 0, size.width, size.height);
        layeredPane.add(fondo, Integer.valueOf(0)); 
    }
    
    private void mensajeFinal(JLayeredPane layeredPane) {
        JLabel mensajeFinal = new JLabel("¡Fin de la Partida!");
        mensajeFinal.setFont(tipoFuentes.fuente(tipoFuentes.pxl, 0, DimensionesConstantes.PANEL_ANCHO / 30));
        mensajeFinal.setHorizontalAlignment(SwingConstants.CENTER); 
        mensajeFinal.setBounds(0, size.height / 4, size.width, 50); 
        layeredPane.add(mensajeFinal, Integer.valueOf(1)); 
    }

    private JPanel crearPanelBotones() {
        botonVolver = new JButton("Volver a la Pantalla Inicial");
        botonCerrar = new JButton("Cerrar Juego");
        //Por alguna razon se crean invisibles (Pero funcionan)
        botonVolver.setFont(tipoFuentes.fuente(tipoFuentes.pxl, 0, DimensionesConstantes.PANEL_ANCHO / 30));
        botonCerrar.setFont(tipoFuentes.fuente(tipoFuentes.pxl, 0, DimensionesConstantes.PANEL_ANCHO / 30));
        
        botonVolver.addActionListener(e -> controladorVistas.mostrarPantallaInicial());
        botonCerrar.addActionListener(e -> System.exit(0));

        JPanel panelBotones = new JPanel(); 
        panelBotones.add(botonVolver);
        panelBotones.add(botonCerrar);
        panelBotones.setLayout(new BorderLayout()); 

        return panelBotones;
    }
    
    private void configurarBindings() {
        InputMap inputMap = getInputMap(WHEN_IN_FOCUSED_WINDOW);
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_W, 0), "navegarArriba");
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_S, 0), "navegarAbajo");
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "seleccionarBoton");

        getActionMap().put("navegarArriba", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                botonSeleccionado = (botonSeleccionado == 0) ? 1 : 0; // Alternar selección
                actualizarBotones();
            }
        });

        getActionMap().put("navegarAbajo", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                botonSeleccionado = (botonSeleccionado == 1) ? 0 : 1; // Alternar selección
                actualizarBotones();
            }
        });

        getActionMap().put("seleccionarBoton", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (botonSeleccionado == 0) {
                    controladorVistas.mostrarPantallaInicial();
                } else {
                    System.exit(0);
                }
            }
        });
    }

    private void actualizarBotones() {
        botonVolver.setSelected(botonSeleccionado == 0);
        botonCerrar.setSelected(botonSeleccionado == 1);
        botonVolver.requestFocusInWindow(); // Para resaltar el botón seleccionado
    }
}
