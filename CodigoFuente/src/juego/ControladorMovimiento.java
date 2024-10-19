
package juego;

import java.awt.Point;

import sensoresDeTeclas.SensorDeTeclasJuego;

public class ControladorMovimiento {
	private static final int VELOCIDAD_MOVIMIENTO_HORIZONTAL = 20;
	
	private static final int FUERZA_SALTO = -30;
	
	private static final int GRAVEDAD = 3;
	
	private boolean saltando;
	
	private int velocidadHorizontal;
	
	private int velocidadVertical;
	
	private Point velocidad;
	
	private Jugador jugador;
	
	private SensorDeTeclasJuego sensorDeTeclasJuego;
	
	public ControladorMovimiento(Point posicion, SensorDeTeclasJuego sensorDeTeclasJuego) {
		//TODO Necesito recibir posicion y sprite como parametro
		this.sensorDeTeclasJuego = sensorDeTeclasJuego;
		//TODO ¿Como hago para que esta instancia de sensor este en FRAME?
		jugador = new Jugador(posicion); //TODO Aca paso la pos inicial como parametro
		velocidadHorizontal = 0;
		velocidadVertical = 0;
		velocidad = new Point(0, 0);
		saltando = false;
	}
	
	public Point actualizarVelocidad() {
		determinarDireccion();
		return velocidad;
	}
	
	public Point actualizarPosicion() {
		Point posicion = jugador.actualizar(velocidad);
		reiniciarVelocidadHorizontal();
		return posicion;
	}
	
	private void moveMarioDerecha() {
		this.velocidadHorizontal = VELOCIDAD_MOVIMIENTO_HORIZONTAL;
		aplicarVelocidad();
	}
	
	private void moveMarioIzquierda() {
		this.velocidadHorizontal = -VELOCIDAD_MOVIMIENTO_HORIZONTAL;
		aplicarVelocidad();
	}
	
	private void iniciarSalto() {
		saltando = true;
		velocidadVertical = FUERZA_SALTO;
		aplicarVelocidad();
	}
	
	private void aplicarGravedadSalto() {
		if(jugador.marioEnElPiso()) {
			reiniciarVelocidadVertical();
			saltando = false;
		}else {
			velocidadVertical += GRAVEDAD;
			aplicarVelocidad();
		}
	}
	
	private void determinarDireccion() {
		if(!saltando && sensorDeTeclasJuego.obtenerWPresionada()) {
			iniciarSalto();
		}else if(saltando) {
			aplicarGravedadSalto();
		}
		if(movimientoADerecha()) {
			moveMarioDerecha();
		}else if(movimientoAIzquierda()) {
			moveMarioIzquierda();
		}
	}
	
	private void aplicarVelocidad() {
		velocidad.move(velocidadHorizontal, velocidadVertical);
	}
	
	private void reiniciarVelocidadHorizontal() {
		velocidadHorizontal = 0;
		aplicarVelocidad();
	}
	
	private void reiniciarVelocidadVertical() {
		velocidadVertical = 0;
		aplicarVelocidad();
	}
	
	private boolean movimientoADerecha() {
		return sensorDeTeclasJuego.obtenerDPresionada() && !sensorDeTeclasJuego.obtenerAPresionada();
	}
	
	private boolean movimientoAIzquierda() {
		return sensorDeTeclasJuego.obtenerAPresionada() && !sensorDeTeclasJuego.obtenerDPresionada();
	}
}
