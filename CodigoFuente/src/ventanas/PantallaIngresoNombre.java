package ventanas;

import javax.swing.*;
import java.awt.*;

public class PantallaIngresoNombre extends JPanel {

    private static final long serialVersionUID = 1L;

    private JTextField campoNombre;
    
    private JButton botonConfirmar;
    
    private ControladorVistas controlador;
    
    private String nombreJugador;

    public PantallaIngresoNombre(ControladorVistas controlador) {
        this.controlador = controlador;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel etiqueta = new JLabel("Ingresa tu nombre:");
        etiqueta.setFont(new Font("Arial", Font.PLAIN, 18));
        etiqueta.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(etiqueta);

        campoNombre = new JTextField(15);
        campoNombre.setMaximumSize(campoNombre.getPreferredSize());
        campoNombre.setAlignmentX(Component.CENTER_ALIGNMENT);
        campoNombre.setEnabled(true);
        campoNombre.setEditable(true);
        campoNombre.requestFocusInWindow();
        add(campoNombre);
        

        botonConfirmar = new JButton("Confirmar");
        botonConfirmar.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(botonConfirmar);

        botonConfirmar.addActionListener(e -> {
            String nombre = campoNombre.getText().trim();
            if (!nombre.isEmpty()) {
            	guardarNombre(nombre);
                controlador.accionarInicioJuego(controlador.obtenerModo());
            } else {
                JOptionPane.showMessageDialog(PantallaIngresoNombre.this, "Por favor, ingresa un nombre.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
    }
    
    public void guardarNombre (String nombreJugador) {
    	this.nombreJugador = nombreJugador;
    }
    
    public String obtenerNombreJugador() {
    	return nombreJugador;
    }
    
    public void solicitarFocoCampoTexto() {
        campoNombre.requestFocusInWindow();
    }
}
