package ventanas;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import imagenes.MarioSprites;
import juego.GameLoop;
import juego.SensorDeTeclas;

public class Ventana {
	private JFrame frame;
	
	private Dimension size;
	
	private JPanel panel;
	
	private JLabel mario;
	
	private int posX = 50;
	
	private int posY = 400;
	
	private SensorDeTeclas sensorDeTeclas;
	
	private int ticksTotal;
	
	private int velHorizontal;
	
	private int velVertical;
	
	private boolean saltando;
	
	private static final int fuerzaSalto = -30;
	
	private static final int gravedad = 3;
	
	private MarioSprites marioSprites;
	
	public Ventana(int width, int height, String title, GameLoop game) {
		size = new Dimension(width, height);
		frame = new JFrame(title);
		panel = new JPanel();
		marioSprites = new MarioSprites();
        mario = new JLabel(marioSprites.getMarioQuieto1());
        velHorizontal = 0;
        velVertical = 0;
        saltando = false;

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
	    panel.setBackground(Color.cyan);
	    
	    // Important: Add KeyListener to frame
	    frame.addKeyListener(sensorDeTeclas);  // Fix: Add the key listener to the frame
	    
	    panel.setLayout(null);  // Important: This allows free positioning of components
	    mario.setBounds(posX, posY, marioSprites.getMarioQuieto1().getIconWidth(), marioSprites.getMarioQuieto1().getIconHeight());  // Position the Mario JPanel
	    panel.add(mario);  // Add Mario to the panel

	    frame.add(panel);  // Add the panel to the frame
	}
	
	public void render() {
		panel.repaint();
	}
	
	public void moveMario() {
		if(ticksTotal == 1000) {
			ticksTotal = 0;
		}//sirve de algo? no quiero que los ticks se vayan al carajo cuando jugas por mucho tiempo
		if(sensorDeTeclas.obtenerSalto() && !saltando) {
			moveMarioSalto();
		}else if(sensorDeTeclas.obtenerDpresionada() && !saltando && !sensorDeTeclas.obtenerApresionada() && posX < size.width - mario.getWidth()) {
			moveMarioDerecha();
		}	
		else if(sensorDeTeclas.obtenerApresionada() && !saltando && !sensorDeTeclas.obtenerDpresionada() && posX > 0) {
			moveMarioIzquierda();
		}else {
			if((mario.getIcon() == marioSprites.getMarioCaminando1() || mario.getIcon() == marioSprites.getMarioCaminando2() || mario.getIcon() == marioSprites.getMarioSaltando()) && !saltando) {
				mario.setIcon(marioSprites.getMarioQuieto1());
			}else if((mario.getIcon() == marioSprites.getMarioVolviendo1() || mario.getIcon() == marioSprites.getMarioVolviendo2() || mario.getIcon() == marioSprites.getMarioSaltando2()) && !saltando) {
				mario.setIcon(marioSprites.getMarioQuieto2());
			}
			if(!saltando)
				velHorizontal = 0;
		}
		if(velVertical < 40)
			velVertical += gravedad;
		if(posY < 400 && saltando) {
			posY += velVertical;
			if((velHorizontal > 0 && posX < size.width - mario.getWidth()) || (velHorizontal < 0 && posX > 0) ) 
				posX += velHorizontal;
		}else if(saltando){
			saltando = false;
			velHorizontal = 0;
			if(mario.getIcon() == marioSprites.getMarioSaltando()) {
				mario.setIcon(marioSprites.getMarioQuieto1());
			}else if(mario.getIcon() == marioSprites.getMarioSaltando2()) {
				mario.setIcon(marioSprites.getMarioQuieto2());
			}
		}
		mario.setLocation(posX, posY);
	}
	
	public void moveMarioDerecha() {
		velHorizontal = 10;
		posX += velHorizontal;
		ticksTotal++;
		if(ticksTotal % 10 == 0) {
			mario.setIcon(marioSprites.getMarioCaminando1());
		}else if(ticksTotal % 5 == 0){					
			mario.setIcon(marioSprites.getMarioCaminando2());					
		}
	}
	public void moveMarioIzquierda() {
		velHorizontal = -10;
		posX += velHorizontal;
		ticksTotal++;
		if(ticksTotal % 10 == 0) {
			mario.setIcon(marioSprites.getMarioVolviendo1());
		}else if(ticksTotal % 5 == 0){
			mario.setIcon(marioSprites.getMarioVolviendo2());
		}
	}
	public void moveMarioSalto() {
		if(sensorDeTeclas.obtenerDpresionada()){
			velHorizontal = 10;
		}else if(sensorDeTeclas.obtenerApresionada()){
			velHorizontal = -10;
		}
		velVertical = fuerzaSalto;
		posY += velVertical;
		saltando = true;
		ticksTotal++;
		if(sensorDeTeclas.obtenerDpresionada() || (mario.getIcon() == marioSprites.getMarioQuieto1() && !sensorDeTeclas.obtenerApresionada())) {
			mario.setIcon(marioSprites.getMarioSaltando());
		}else if(sensorDeTeclas.obtenerApresionada() || (mario.getIcon() == marioSprites.getMarioQuieto2() && !sensorDeTeclas.obtenerApresionada())) {
			mario.setIcon(marioSprites.getMarioSaltando2());
		}
	}
}
