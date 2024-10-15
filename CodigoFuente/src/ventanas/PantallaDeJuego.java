package ventanas;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import imagenes.MarioSprites;
import juego.GameLoop;
import juego.MovimientoJugador;
import juego.SensorDeTeclas;

public class PantallaDeJuego {
	
	private JFrame frame;
	
	private Dimension size;
	
	private JPanel panel;
	
	private JLabel mario;
	
	private SensorDeTeclas sensorDeTeclas;
	
	private MovimientoJugador movimientoJugador;
	
	private MarioSprites marioSprites;
	
	public PantallaDeJuego(int width, int height, String title, GameLoop game) {
		size = new Dimension(width, height);
		frame = new JFrame(title);
		panel = new JPanel();
		marioSprites = new MarioSprites();
        mario = new JLabel(marioSprites.getMarioQuieto1());
        movimientoJugador = new MovimientoJugador(this);

		sensorDeTeclas = new SensorDeTeclas();
		
		frame.setPreferredSize(size);
	    frame.setMaximumSize(size);
	    frame.setMinimumSize(size);
	    
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setResizable(false);
	    frame.setLocationRelativeTo(null);
	    frame.setVisible(true);
	    
	    panel.setPreferredSize(size);
	    panel.setMaximumSize(size);
	    panel.setMinimumSize(size);
	    panel.setBackground(Color.gray);
	    
	    frame.addKeyListener(sensorDeTeclas);
	    
	    panel.setLayout(null);  // Esto habilita la libre posicion de componentes
	    mario.setBounds(movimientoJugador.obtenerPosicionInicialX(), movimientoJugador.obtenerPosicionInicialY(), marioSprites.getMarioQuieto1().getIconWidth(), marioSprites.getMarioQuieto1().getIconHeight());  // Position the Mario JPanel
	    panel.add(mario);

	    frame.add(panel);
	}
	
	public void render() {
		panel.repaint();
	}
	
	public void update() {
		//Actualiza la parte logica de la pantalla
		movimientoJugador.moveMario();
	}
	
	public void actualizarPosicionMario(int posX, int posY) {
		mario.setLocation(posX,posY);
	}
	
	public boolean teclaAPresionada() {
		boolean aRetornar = sensorDeTeclas.obtenerAPresionada();
		return aRetornar;
	}
	
	public boolean teclaDPresionada() {
		boolean aRetornar = sensorDeTeclas.obtenerDPresionada();
		return aRetornar;
	}
	
	public boolean teclaWPresionada() {
		boolean aRetornar = sensorDeTeclas.obtenerWPresionada();
		return aRetornar;
	}
	
	public boolean choqueBordeDerecho() {
		boolean aRetornar = movimientoJugador.obtenerPosX() >= size.width - mario.getWidth();
		return aRetornar;
	}
	
	public boolean choqueBordeIzquierdo() {
		boolean aRetornar = movimientoJugador.obtenerPosX() <= 0;
		return aRetornar;
	}
	
	public void cambiarSpriteMarioCaminando1() {
		mario.setIcon(marioSprites.getMarioCaminando1());
	}
	
	public void cambiarSpriteMarioCaminando2() {
		mario.setIcon(marioSprites.getMarioCaminando2());
	}
	
	public void cambiarSpriteMarioQuieto1() {
		mario.setIcon(marioSprites.getMarioQuieto1());
	}
	
	public void cambiarSpriteMarioQuieto2() {
		mario.setIcon(marioSprites.getMarioQuieto2());
	}
	
	public void cambiarSpriteMarioVolviendo1() {
		mario.setIcon(marioSprites.getMarioVolviendo1());
	}
	
	public void cambiarSpriteMarioVolviendo2() {
		mario.setIcon(marioSprites.getMarioVolviendo2());
	}
	
	public void cambiarSpriteMarioSaltando() {
		mario.setIcon(marioSprites.getMarioSaltando());
	}
	
	public void cambiarSpriteMarioSaltando2() {
		mario.setIcon(marioSprites.getMarioSaltando2());
	}
	
	public boolean marioHaciaAdelante() {
		return (mario.getIcon() == marioSprites.getMarioCaminando1() || mario.getIcon() == marioSprites.getMarioCaminando2() || mario.getIcon() == marioSprites.getMarioSaltando() || mario.getIcon() == marioSprites.getMarioQuieto1());
	}
	
	public boolean marioHaciaAtras() {
		return (mario.getIcon() == marioSprites.getMarioVolviendo1() || mario.getIcon() == marioSprites.getMarioVolviendo2() || mario.getIcon() == marioSprites.getMarioSaltando2() || mario.getIcon() == marioSprites.getMarioQuieto2());
	}
}
