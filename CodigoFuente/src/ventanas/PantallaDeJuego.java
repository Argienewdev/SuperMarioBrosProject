package ventanas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import elementos.entidades.Jugable;
import observers.ObserverGrafico;
import sensoresDeTeclas.SensorDeTeclasJuego;

public class PantallaDeJuego extends JPanel {

    private ArrayList<JLabel> labelsElementoDeJuego;
    private Dimension size;
    private Jugable marioJugable;
    private JLabel marioLabel;
    private JLabel fondo;
    private SensorDeTeclasJuego sensorDeTeclasJuego;
    private ObserverGrafico observerGrafico;

    private static final int MITAD_PANTALLA = DimensionesConstantes.PANEL_ANCHO / 2;
    private int desplazamientoFondo = 0;

    public PantallaDeJuego(SensorDeTeclasJuego sensorDeTeclasJuego) {
        this.fondo = new JLabel();
        configurarVentana();
        this.sensorDeTeclasJuego = sensorDeTeclasJuego;
        this.labelsElementoDeJuego = new ArrayList<>();
    }

    protected void configurarVentana() {
        setVisible(true);
        setLayout(null);
        this.size = new Dimension(DimensionesConstantes.PANEL_ANCHO, DimensionesConstantes.PANEL_ALTO);
        setPreferredSize(size);
        setMaximumSize(size);
        setMinimumSize(size);
    }

    protected void establecerFondo() {
        ImageIcon fondoImagen = new ImageIcon("src/imagenes/fondoPantallaJuego.png");
        fondo = new JLabel(fondoImagen);
        fondo.setBounds(0, 0, fondoImagen.getIconWidth(), fondoImagen.getIconHeight());
        add(fondo);
    }

    public void registrarJugable(Jugable jugable) {
        marioJugable = jugable;
        ImageIcon marioIcono = new ImageIcon(marioJugable.getSprite().getRutaImagen());
        marioLabel = new JLabel(marioIcono);
        Point aux = marioJugable.getPosicion();
        marioLabel.setBounds(aux.x, aux.y, marioIcono.getIconWidth(), marioIcono.getIconHeight());
        agregarLabel(marioLabel);
        mostrarLabels();
        establecerFondo();
        revalidate();
        repaint();
    }

    public void agregarLabel(JLabel labelElementoDeJuego) {
        labelsElementoDeJuego.add(labelElementoDeJuego);
    }

    public void mostrarLabels() {
        for (JLabel label : labelsElementoDeJuego) {
            add(label);
            label.setVisible(true);
            revalidate();
            repaint();
        }
    }

    public void refrescar() {
        Point posicionMario = marioJugable.getPosicion();
        /*
        // Si Mario llega a la mitad de la pantalla, desplazamos el fondo y los labels
        if (posicionMario.x >= MITAD_PANTALLA && desplazamientoFondo > -fondo.getWidth() + DimensionesConstantes.PANEL_ANCHO) {
            int desplazamiento = posicionMario.x - MITAD_PANTALLA;
            moverFondoYLabels(desplazamiento);
            posicionMario.x = MITAD_PANTALLA; // Mario se queda en la mitad
        }

        // Limitar Mario al borde derecho si el fondo ya no puede desplazarse más
        if (posicionMario.x + marioLabel.getWidth() > DimensionesConstantes.PANEL_ANCHO) {
            posicionMario.x = DimensionesConstantes.PANEL_ANCHO - marioLabel.getWidth();
        }
         */
        marioLabel.setLocation(posicionMario);
        repaint();
    }


    private void moverFondoYLabels(int desplazamiento) {
        desplazamientoFondo -= desplazamiento;
        fondo.setLocation(desplazamientoFondo, fondo.getY());

        // Mueve todos los labels en sincronía con el fondo
        for (JLabel label : labelsElementoDeJuego) {
            Point posicionActual = label.getLocation();
            label.setLocation(posicionActual.x - desplazamiento, posicionActual.y);
        }
    }
}
