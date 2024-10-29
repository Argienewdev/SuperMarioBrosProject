package ventanas;

import javax.swing.*;
import fuentes.Fuentes;
import ranking.Jugador;

import java.awt.*;

public class PantallaIngresoNombre extends JPanel {

    private static final long serialVersionUID = 1L;

    private Fuentes tipoFuentes;
    private JLabel fondo;
    private Dimension size = new Dimension(ConstantesGlobales.PANEL_ANCHO, ConstantesGlobales.PANEL_ALTO);
    private JTextField campoNombre;
    private JButton botonConfirmar;
    private ControladorVistas controlador;
    private Jugador jugador;

    public PantallaIngresoNombre(ControladorVistas controlador) {
        this.controlador = controlador;
        tipoFuentes = new Fuentes();
        setLayout(new BorderLayout());  
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(size);
        layeredPane.setLayout(null); 

        establecerFondo(layeredPane);
        establecerContenido(layeredPane);
        add(layeredPane, BorderLayout.CENTER); 
    }
    
    public void establecerJugador(Jugador jugador) {
    	this.jugador = jugador;
    }

    public void guardarNombre(String nombreJugador) {
        jugador.establecerNombre(nombreJugador);
    }

    public String obtenerNombreJugador() {
        return jugador.obtenerNombre();
    }

    public void solicitarFocoCampoTexto() {
        campoNombre.requestFocusInWindow();
    }

    private void establecerFondo(JLayeredPane layeredPane) {
        fondo = new JLabel(new ImageIcon("src/imagenes/fondoJuegoCielo.png"));
        fondo.setBounds(0, 0, size.width, size.height);
        layeredPane.add(fondo, Integer.valueOf(0)); 
    }

    private void establecerContenido(JLayeredPane layeredPane) {
        JPanel panelContenido = new JPanel();
        panelContenido.setLayout(new BoxLayout(panelContenido, BoxLayout.Y_AXIS));
        panelContenido.setOpaque(false);  

        int panelWidth = 300;
        int panelHeight = 200;
        panelContenido.setBounds((size.width - panelWidth) / 2, (size.height - panelHeight) / 2, panelWidth, panelHeight);

        establecerTitulo(panelContenido);
        ajustarCampoNombre(panelContenido);
        configurarBotonConfirmar(panelContenido);

        layeredPane.add(panelContenido, Integer.valueOf(1)); 
    }

    private void establecerTitulo(JPanel panelContenido) {
        JLabel etiqueta = new JLabel("Ingresa tu nombre:");
        etiqueta.setFont(tipoFuentes.fuente(tipoFuentes.pxl, 0, ConstantesGlobales.PANEL_ANCHO / 80));
        etiqueta.setAlignmentX(Component.CENTER_ALIGNMENT);
        etiqueta.setForeground(Color.WHITE);  
        panelContenido.add(etiqueta);
        panelContenido.add(Box.createRigidArea(new Dimension(0, 20))); 
    }

    private void ajustarCampoNombre(JPanel panelContenido) {
        campoNombre = new JTextField(15);
        campoNombre.setMaximumSize(new Dimension(200, 30)); 
        campoNombre.setAlignmentX(Component.CENTER_ALIGNMENT);
        campoNombre.requestFocusInWindow();
        panelContenido.add(campoNombre);
        panelContenido.add(Box.createRigidArea(new Dimension(0, 20))); 
    }

    private void configurarBotonConfirmar(JPanel panelContenido) {
        botonConfirmar = new JButton("Confirmar");
        botonConfirmar.setAlignmentX(Component.CENTER_ALIGNMENT);
        botonConfirmar.setFont(tipoFuentes.fuente(tipoFuentes.pxl, 0, ConstantesGlobales.PANEL_ANCHO / 50));
        botonConfirmar.addActionListener(e -> {
            String nombre = campoNombre.getText().trim();
            if (!nombre.isEmpty()) {
                guardarNombre(nombre);
                controlador.mostrarPantallaFinal();
            } else {
                JOptionPane.showMessageDialog(PantallaIngresoNombre.this, "Por favor, ingresa un nombre.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        panelContenido.add(botonConfirmar);
    }
}
