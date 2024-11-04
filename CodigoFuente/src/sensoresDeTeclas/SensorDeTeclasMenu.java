package sensoresDeTeclas;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class SensorDeTeclasMenu implements KeyListener{
	
	private boolean SPresionado;
	
	private boolean WPresionado;
	
	private boolean enterPresionado;

	private boolean WAccionado;

	private boolean SAccionado;
	
	private boolean enterAccionado;
	
	public SensorDeTeclasMenu() {
		SPresionado = false;
		WPresionado = false;
		enterPresionado = false;
		WAccionado = false;
		SAccionado = false;
		enterAccionado = false;
	}
	
	public boolean obtenerSPresionado() {
		return SPresionado;
	}
	
	public boolean obtenerWPresionado() {
		return WPresionado;
	}
	
	public boolean obtenerWAccionada() {
		return WAccionado;
	}
	
	public boolean obtenerSAccionada() {
		return SAccionado;
	}
	
	public boolean obtenerEnterPresionado() {
		return enterPresionado;
	}
	
	public boolean obtenerEnterAccionada() {
		return enterAccionado;
	}

	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		if (keyCode ==  KeyEvent.VK_ENTER) {
			enterPresionado = true;
		} else if (keyCode ==  KeyEvent.VK_S) {
			SPresionado = true;
		} else if (keyCode ==  KeyEvent.VK_W) {
			WPresionado = true;
		}
    }

    public void keyReleased(KeyEvent e) {
    	int keyCode = e.getKeyCode();
    	if (keyCode ==  KeyEvent.VK_ENTER) {
    		enterPresionado = false;
    		enterAccionado = false;
    	} else if (keyCode ==  KeyEvent.VK_S) {
    		SPresionado = false;
    		SAccionado = false;
    	} else if (keyCode ==  KeyEvent.VK_W) {
    		WPresionado = false;
    		WAccionado = false;
    	}
    }

    public void keyTyped(KeyEvent e) {
    }
    
    public void accionarW() {
    	WAccionado = true;
    }
    
    public void accionarS() {
    	SAccionado = true;
    }
    
    public void accionarEnter() {
    	enterAccionado = true;
    }
    
}
