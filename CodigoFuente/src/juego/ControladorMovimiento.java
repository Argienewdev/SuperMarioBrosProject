
package juego;

import java.awt.Point;

import elementos.entidades.Jugable;
import sensoresDeTeclas.SensorDeTeclasJuego;

public class ControladorMovimiento {
	private static final int VELOCIDAD_MOVIMIENTO_HORIZONTAL = 20;
	
	private static final int FUERZA_SALTO = -30;
	
	private static final int GRAVEDAD = 3;
	
	private boolean saltando;
	
	private int velocidadHorizontal;
	
	private int velocidadVertical;
	
	private Point posicion;
	
	private Point velocidad;
	
	private ActualizadorDePosicionDeJugador actualizadorDePosicionDeJugador;
	
	private Jugable marioJugable;
	
	private SensorDeTeclasJuego sensorDeTeclasJuego;
	
	public ControladorMovimiento(Jugable marioJugable, SensorDeTeclasJuego sensorDeTeclasJuego) {
		this.sensorDeTeclasJuego = sensorDeTeclasJuego;
		this.marioJugable = marioJugable; 
		velocidadHorizontal = 0;
		velocidadVertical = 0;
		posicion = new Point(marioJugable.getPosicion().x, marioJugable.getPosicion().y);
		velocidad = new Point(0, 0);
		saltando = false;
		actualizadorDePosicionDeJugador = new ActualizadorDePosicionDeJugador(posicion, null);
	}
	
	public Point actualizarVelocidad() {
		determinarDireccion();
		return velocidad;
	}
	
	public Point actualizarPosicion() {
		posicion = actualizadorDePosicionDeJugador.actualizar(velocidad);
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
		if(actualizadorDePosicionDeJugador.marioEnElPiso()) {
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
