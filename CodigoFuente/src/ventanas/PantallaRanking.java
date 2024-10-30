package ventanas;

import javax.swing.*;
import fuentes.Fuentes;
import ranking.Jugador;
import sensoresDeTeclas.SensorDeTeclasMenu;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class PantallaRanking extends JPanel {

	private static final long serialVersionUID = 6769720571520373550L;
	
	private boolean enFoco;
	
	private Fuentes tipoFuentes;
    
	private List<JLabel> rankingLabel;
    
	private JLabel fondo;
    
	private Dimension size = new Dimension(ConstantesGlobales.PANEL_ANCHO, ConstantesGlobales.PANEL_ALTO);
    
	protected ControladorVistas controlador;
    
	protected SensorDeTeclasMenu sensor;
    
    @SuppressWarnings("exports")
	public PantallaRanking(List<Jugador> topJugadores, SensorDeTeclasMenu sensor,ControladorVistas controladorVistas) {
    	this.enFoco = false;
    	controlador = controladorVistas;
    	this.sensor = sensor;
        setLayout(null);
        setPreferredSize(size);
        this.tipoFuentes = new Fuentes();
        this.rankingLabel = new ArrayList<>();
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setLayout(null);
        layeredPane.setBounds(0, 0, size.width, size.height);
        establecerFondo(layeredPane);
        establecerTitulo(layeredPane);
        agregarJugadores(layeredPane, topJugadores);
        agregarBotonRegresar();
        add(layeredPane);
    }

    private void agregarJugadores(JLayeredPane layeredPane, List<Jugador> topJugadores) {
        JPanel jugadoresPanel = new JPanel();
        jugadoresPanel.setLayout(null);
        jugadoresPanel.setOpaque(false);
        
        int y = 0;
        int labelHeight = 60;
        int startY = 150;
        
        for (Jugador jugador : topJugadores) {
            JLabel jugadorLabel = new JLabel(jugador.obtenerNombre() + " " + jugador.obtenerPuntaje());
            jugadorLabel.setBounds(0, y, size.width, labelHeight);
            jugadorLabel.setHorizontalAlignment(SwingConstants.CENTER);
            rankingLabel.add(jugadorLabel);
            jugadoresPanel.add(jugadorLabel);
            y += labelHeight;
        }
        jugadoresPanel.setBounds(0, startY, size.width, size.height - startY);
        layeredPane.add(jugadoresPanel, Integer.valueOf(1));
        configurarFuenteJugadores();
    }
    
    private void agregarBotonRegresar(){
    	JLabel botonRegresar= new JLabel("Regresar");
    	botonRegresar.setBounds(570 , ConstantesGlobales.PANEL_ALTO/4, size.width, size.height - 100);
    	Font font = tipoFuentes.fuente(tipoFuentes.pxl, 0, ConstantesGlobales.PANEL_ANCHO / 30);
    	botonRegresar.setFont(font);
    	add(botonRegresar);
    }
    
    public void refrescar(){
    	if(sensor.obtenerEnterPresionado() && !sensor.obtenerEnterAccionada()){
    		sensor.accionarEnter();
    		controlador.dePantallaRankingAPantallaInicial();
    	}
    }

    public void configurarFuenteJugadores() {
        Font font = tipoFuentes.fuente(tipoFuentes.pxl, 0, ConstantesGlobales.PANEL_ANCHO / 30);
        for (JLabel top : rankingLabel) {
            top.setFont(font);
            top.setForeground(Color.WHITE);
        }
    }

    private void establecerFondo(JLayeredPane layeredPane) {
        fondo = new JLabel(new ImageIcon("src/imagenes/fondos/fondoModoOriginal/fondoPantallaNombre.png"));
        fondo.setBounds(0, 0, size.width, size.height);
        layeredPane.add(fondo, Integer.valueOf(0));
    }

    private void establecerTitulo(JLayeredPane layeredPane) {
        JLabel titulo = new JLabel("Ranking mejores 5 jugadores");
        titulo.setFont(tipoFuentes.fuente(tipoFuentes.pxl, 0, ConstantesGlobales.PANEL_ANCHO / 30));
        titulo.setForeground(Color.WHITE);
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        
        JPanel tituloPanel = new JPanel();
        tituloPanel.setLayout(null);
        tituloPanel.setOpaque(false);
        tituloPanel.setBounds(0, 30, size.width, 50);
        
        titulo.setBounds(0, 0, size.width, 50);
        tituloPanel.add(titulo);
        
        layeredPane.add(tituloPanel, Integer.valueOf(1));
    }
    
    public void establecerEnFoco(boolean condicion){
    	this.enFoco = condicion;
    }
    
    public boolean obtenerEnFoco(){
    	return this.enFoco;
    }
}