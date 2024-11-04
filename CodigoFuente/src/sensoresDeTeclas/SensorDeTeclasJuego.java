package sensoresDeTeclas;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class SensorDeTeclasJuego extends JFrame implements KeyListener{
	
	private boolean aPresionada;
	
	private boolean dPresionada;
	
	private boolean wPresionada;
	
	private boolean wAccionada;
	
	private boolean spacePresionada;
	
	private boolean spaceAccionado;
	
	public SensorDeTeclasJuego() {
		this.aPresionada = false;
		this.dPresionada = false;
		this.wPresionada = false;
		this.wAccionada = false;
		this.spacePresionada = false;
		this.spaceAccionado = false;
	}
	
	public void establecerWAccionada(boolean accionada) {
		this.wAccionada = accionada;
	}
	
	public void establecerSpaceAccionada(boolean accionada) {
		this.spaceAccionado = accionada;
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
	
	public boolean obtenerWAccionada() {
		return wAccionada;
	}

	public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode ==  KeyEvent.VK_A) {
        	this.aPresionada = true;
        } else if (keyCode ==  KeyEvent.VK_D) {
        	this.dPresionada = true;
        } else if (keyCode ==  KeyEvent.VK_W) {
        	this.wPresionada = true;
        } else if (keyCode ==  KeyEvent.VK_SPACE) {
        	this.spacePresionada = true;
        }
    }

    public void keyReleased(KeyEvent e) {
    	int keyCode = e.getKeyCode();
        if (keyCode ==  KeyEvent.VK_A) {
        	this.aPresionada = false;
        } else if (keyCode ==  KeyEvent.VK_D) {
            dPresionada = false;
        } else if (keyCode ==  KeyEvent.VK_W) {
        	this.wAccionada = false;
        	this.wPresionada = false;
        } else if (keyCode ==  KeyEvent.VK_SPACE) {
        	this.spaceAccionado = false;
        	this.spacePresionada = false;
        }
    }

    public void keyTyped(KeyEvent e) {
    }

}
