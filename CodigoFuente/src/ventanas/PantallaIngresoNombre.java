package ventanas;

import javax.swing.*;
import javax.swing.text.AbstractDocument;

import fuentes.Fuentes;
import juego.Partida;
import ranking.Jugador;
import ranking.LimitadorDeCaracteres;
import ranking.Ranking;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class PantallaIngresoNombre extends Pantalla {
    private static final long serialVersionUID = 1L;
    private Fuentes tipoFuentes;
    private JLabel fondo;
    private Dimension size = new Dimension(ConstantesGlobales.PANEL_ANCHO, ConstantesGlobales.PANEL_ALTO);
    private JTextField campoNombre;
    private JButton botonConfirmar;
    private ControladorVistas controlador;
    private String modo;

    public PantallaIngresoNombre(ControladorVistas controlador, String modo) {
        this.modo = modo;
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
    
    public void solicitarFocoCampoTexto() {
        campoNombre.requestFocusInWindow();
    }

    private void establecerFondo(JLayeredPane layeredPane) {
        if (this.modo.equals("Modo original")) {
            fondo = new JLabel(new ImageIcon("src/imagenes/fondos/fondoModoOriginal/fondoPantallaNombre.png"));
        } else if (this.modo.equals("Modo alternativo")) {
            fondo = new JLabel(new ImageIcon("src/imagenes/fondos/fondoModoAlternativo/fondoPantallaNombre.png"));
        }
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
        etiqueta.setFont(tipoFuentes.fuente(tipoFuentes.pxl, 0, ConstantesGlobales.PANEL_ANCHO / 75));
        etiqueta.setAlignmentX(Component.CENTER_ALIGNMENT);
        etiqueta.setForeground(Color.WHITE);  
        panelContenido.add(etiqueta);
        panelContenido.add(Box.createRigidArea(new Dimension(10, 30))); 
    }

    private void ajustarCampoNombre(JPanel panelContenido) {
        campoNombre = new JTextField(15);
        campoNombre.setMaximumSize(new Dimension(300, 30)); 
        campoNombre.setAlignmentX(Component.CENTER_ALIGNMENT);
        campoNombre.setHorizontalAlignment(JTextField.CENTER);
        campoNombre.setFocusable(true);
        campoNombre.setBorder(null);
        campoNombre.setOpaque(false);
        campoNombre.setFont(tipoFuentes.fuente(tipoFuentes.pxl, 0, ConstantesGlobales.PANEL_ANCHO / 75));
        ((AbstractDocument) campoNombre.getDocument()).setDocumentFilter(new LimitadorDeCaracteres(4));
        panelContenido.add(campoNombre);
        panelContenido.add(Box.createRigidArea(new Dimension(0, 20))); 
    }

    private void configurarBotonConfirmar(JPanel panelContenido) {
        botonConfirmar = new JButton("Confirmar");
        botonConfirmar.setAlignmentX(Component.CENTER_ALIGNMENT);
        botonConfirmar.setFont(tipoFuentes.fuente(tipoFuentes.pxl, 0, ConstantesGlobales.PANEL_ANCHO / 45));
        botonConfirmar.setFocusPainted(false);
        botonConfirmar.setContentAreaFilled(false);
        botonConfirmar.setBorderPainted(false);

        botonConfirmar.addActionListener(e -> confirmarNombre());
        botonConfirmar.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
                      .put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "confirmar");
        botonConfirmar.getActionMap().put("confirmar", new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                confirmarNombre();
            }
        });

        panelContenido.add(botonConfirmar);
    }

    private void confirmarNombre() {
        String nombre = campoNombre.getText().trim();
        if (!nombre.isEmpty()) {
            if (procesarJugador(nombre)) {
                controlador.obtenerRanking().guardarEstado();
                controlador.accionarPantallaFinal();
            }
        } else {
            JOptionPane.showMessageDialog(this, 
                "Por favor, ingresa un nombre.", "Error", 
                JOptionPane.ERROR_MESSAGE);
        }
    }
    

    private boolean procesarJugador(String nombre) {
    	boolean toRet = false;
        try {
            Ranking ranking = controlador.obtenerRanking();
            Partida partida = controlador.obtenerJuego().obtenerPartida();
            int puntajeActual = partida.obtenerJugable().obtenerPuntos();
            Jugador jugadorExistente = ranking.obtenerJugador(nombre);

            if (jugadorExistente == null) {
                Jugador nuevoJugador = new Jugador();
                nuevoJugador.establecerNombre(nombre);
                nuevoJugador.actualizarPuntos(puntajeActual);
                ranking.agregarJugador(nuevoJugador);
            } else 
                if (puntajeActual > jugadorExistente.obtenerPuntaje()) {
                    jugadorExistente.actualizarPuntos(puntajeActual);
            }
            toRet = true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, 
                "Por favor ingresa un nombre: " + e.getMessage(), 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
        }
        return toRet;
    }
    
    public void refrescar() {
    }
    
    public JTextField obtenerCampoNombre() {
        return campoNombre;
    }
    
    public boolean esRefrescable() {
    	return false;
    }
}
