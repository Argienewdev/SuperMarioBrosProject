package sensoresDeTeclas;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class SensorDeTeclasJuego extends JFrame implements KeyListener{
	
	private boolean aPresionada;
	
	private boolean dPresionada;
	
	private boolean wPresionada;
	
	private boolean spacePresionada;
	
	private boolean spaceAccionado;
	
	public SensorDeTeclasJuego() {
		aPresionada = false;
		dPresionada = false;
		wPresionada = false;
		spacePresionada = false;
		spaceAccionado = false;
	}

	@Override
	public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_A) {
    		aPresionada = true;
        }else if (keyCode == KeyEvent.VK_D) {
    		dPresionada = true;
        }else if (keyCode == KeyEvent.VK_W) {
        	wPresionada = true;
        }else if (keyCode == KeyEvent.VK_SPACE) {
        	spacePresionada = true;
        }
    }

    // Invoked when a key is released
    @Override
    public void keyReleased(KeyEvent e) {
    	int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_A) {
            aPresionada = false;
        } else if (keyCode == KeyEvent.VK_D) {
            dPresionada = false;
        }else if (keyCode == KeyEvent.VK_W) {
        	wPresionada = false;
        }else if (keyCode == KeyEvent.VK_SPACE) {
        	spaceAccionado = false;
        	spacePresionada = false;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

	public boolean obtenerAPresionada() {
		return aPresionada;
	}

	public boolean obtenerDPresionada() {
		return dPresionada;
	}
	
	public boolean obtenerWPresionada() {
		return wPresionada;
	}
	
	public boolean obtenerSpacePresionada() {
		return spacePresionada;
	}
	
	public boolean obtenerSpaceAccionada() {
		return spaceAccionado;
	}
	
	public void establecerSpaceAccionada(boolean accionada) {
		this.spaceAccionado = accionada;
	}
}
