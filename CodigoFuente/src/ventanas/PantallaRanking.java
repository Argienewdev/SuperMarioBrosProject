package ventanas;

import javax.swing.*;

import fuentes.Fuentes;
import ranking.Jugador;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class PantallaRanking extends JPanel {

    private Fuentes tipoFuentes;
    private List<JLabel> rankingLabel;
    private JLabel fondo;
    private Dimension size = new Dimension(DimensionesConstantes.PANEL_ANCHO, DimensionesConstantes.PANEL_ALTO);

    public PantallaRanking(List<Jugador> topJugadores) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        tipoFuentes = new Fuentes();
        rankingLabel = new ArrayList<>();
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(size);
        establecerFondo(layeredPane);
        establecerTitulo(layeredPane);
        agregarJugadores(layeredPane, topJugadores);
        add(layeredPane);
        revalidate();
        repaint();
    }

    private void agregarJugadores(JLayeredPane layeredPane, List<Jugador> topJugadores) {
        JPanel jugadoresPanel = new JPanel();
        jugadoresPanel.setLayout(new BoxLayout(jugadoresPanel, BoxLayout.Y_AXIS));
        jugadoresPanel.setOpaque(false);  // Para que el fondo sea visible
        for (Jugador jugador : topJugadores) {
            JLabel jugadorLabel = new JLabel(jugador.obtenerNombre() + " " + jugador.obtenerPuntaje());
            jugadorLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            rankingLabel.add(jugadorLabel);
            jugadoresPanel.add(jugadorLabel);
        }
        jugadoresPanel.setBounds(0, 100, size.width, size.height - 100);
        layeredPane.add(jugadoresPanel, Integer.valueOf(1)); // Añade en la capa superior
        configurarFuenteJugadores();
    }

    public void configurarFuenteJugadores() {
        for (JLabel top : rankingLabel) {
            top.setFont(tipoFuentes.fuente(tipoFuentes.pxl, 0, DimensionesConstantes.PANEL_ANCHO / 30));
            top.setForeground(Color.WHITE);
        }
    }
    

    private void establecerFondo(JLayeredPane layeredPane) {
        fondo = new JLabel(new ImageIcon("src/imagenes/fondoJuegoCielo.png"));
        fondo.setBounds(0, 0, size.width, size.height);
        layeredPane.add(fondo, Integer.valueOf(0));  // Añade en la capa de fondo
    }

    private void establecerTitulo(JLayeredPane layeredPane) {
        JLabel titulo = new JLabel("Ranking mejores 5 jugadores");
        titulo.setFont(tipoFuentes.fuente(tipoFuentes.pxl, 0, DimensionesConstantes.PANEL_ANCHO / 30));
        titulo.setForeground(Color.WHITE);
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        JPanel tituloPanel = new JPanel();
        tituloPanel.setOpaque(false); 
        tituloPanel.add(titulo);
        tituloPanel.setBounds(0, 10, size.width, 50);  
        layeredPane.add(tituloPanel, Integer.valueOf(1));
     }
}
