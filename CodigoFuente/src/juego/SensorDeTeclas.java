package juego;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class SensorDeTeclas extends JFrame implements KeyListener{
	private boolean Apresionada;
	private boolean Dpresionada;
	private boolean salto;
	
	public SensorDeTeclas() {
		Apresionada = false;
		Dpresionada = false;
		salto = false;
	}

	@Override
	public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_A) {
    		Apresionada = true;
        }else if (keyCode == KeyEvent.VK_D) {
    		Dpresionada = true;
        }else if (keyCode == KeyEvent.VK_W) {
        	salto = true;
        }
    }

    // Invoked when a key is released
    @Override
    public void keyReleased(KeyEvent e) {
    	int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_A) {
            Apresionada = false;
        } else if (keyCode == KeyEvent.VK_D) {
            Dpresionada = false;
        }else if (keyCode == KeyEvent.VK_W) {
        	salto = false;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

	public boolean obtenerApresionada() {
		return Apresionada;
	}

	public boolean obtenerDpresionada() {
		return Dpresionada;
	}
	
	public boolean obtenerSalto() {
		return salto;
	}
}
