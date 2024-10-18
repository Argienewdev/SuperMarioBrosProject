package sensoresDeTeclas;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class SensorDeTeclasMenu implements KeyListener{
	
	private boolean SPresionada;
	
	private boolean WPresionada;
	
	private boolean EnterPresionado;
	
	public SensorDeTeclasMenu() {
		SPresionada = false;
		WPresionada = false;
		EnterPresionado = false;
	}

	@Override
	public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_ENTER) {
    		EnterPresionado = true;
        }else if (keyCode == KeyEvent.VK_S) {
    		SPresionada = true;
        }else if (keyCode == KeyEvent.VK_W) {
        	WPresionada = true;
        }
    }

    // Invoked when a key is released
    @Override
    public void keyReleased(KeyEvent e) {
    	int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_ENTER) {
        	EnterPresionado = false;
        } else if (keyCode == KeyEvent.VK_S) {
        	SPresionada = false;
        }else if (keyCode == KeyEvent.VK_W) {
        	WPresionada = false;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

	public boolean obtenerSPresionada() {
		return SPresionada;
	}

	public boolean obtenerEnterPresionada() {
		return EnterPresionado;
	}
	
	public boolean obtenerWPresionada() {
		return WPresionada;
	}
}
