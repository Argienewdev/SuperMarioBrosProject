
package juego;

import java.awt.Point;

import elementos.entidades.Jugable;
import sensoresDeTeclas.SensorDeTeclasJuego;

public class ControladorMovimiento {
	private static final int VELOCIDAD_MOVIMIENTO_HORIZONTAL = 10;
	
	private static final int FUERZA_SALTO = -30;
	
	private static final int GRAVEDAD = 3;
	
	private boolean saltando;
	
	private int velocidadHorizontal;
	
	private int velocidadVertical;
	
	private Point posicion;
	
	private Point velocidad;
	
	private Jugable marioJugable;
	
	private SensorDeTeclasJuego sensorDeTeclasJuego;
	
	private Nivel nivel;
	
	private GestorDeColisiones gestorDeColisiones;
	
	public ControladorMovimiento(Jugable marioJugable, SensorDeTeclasJuego sensorDeTeclasJuego, Nivel nivel, GestorDeColisiones gestorDeColisiones) {
		this.sensorDeTeclasJuego = sensorDeTeclasJuego;
		this.marioJugable = marioJugable; 
		velocidadHorizontal = 0;
		velocidadVertical = 0;
		posicion = new Point(marioJugable.getPosicion().x, marioJugable.getPosicion().y);
		velocidad = new Point(0, 0);
		saltando = false;
		this.nivel = nivel;
		this.gestorDeColisiones = gestorDeColisiones;
	}
	
	public Point actualizarVelocidad() {
		determinarDireccion();
		return velocidad;
	}
	
	public Point actualizarPosicion() {
		actualizarPosicionMarioEnMatriz();
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
	
	private void actualizarPosicionMarioEnMatriz() {
		this.nivel.eliminarElementoDeJuegoDeLaMatriz(marioJugable);
		cambiarPosicionLogicaDeMario();
		this.nivel.agregarElementoDeJuegoALaMatriz(marioJugable);
	}
	
	private void cambiarPosicionLogicaDeMario() {
		int nuevaPosicionX = posicion.x + velocidad.x;
		int nuevaPosicionY = posicion.y + velocidad.y;
		posicion.move(nuevaPosicionX, nuevaPosicionY);
	}
	
	private void iniciarSalto() {
		saltando = true;
		velocidadVertical = FUERZA_SALTO;
		aplicarVelocidad();
	}
	
	private void aplicarGravedadSalto() {
		if(marioJugable.getPosicion().y >= 600) {
			reiniciarVelocidadVertical();
			saltando = false;
		}else if(velocidadVertical >= FUERZA_SALTO){
			velocidadVertical += GRAVEDAD;
			aplicarVelocidad();
		}else {
			aplicarVelocidad();
		}
	}
	
	private void determinarDireccion() {
		if(!saltando && sensorDeTeclasJuego.obtenerWPresionada()) {
			iniciarSalto();
			gestorDeColisiones.verificarColisiones(marioJugable);
		}else if(saltando) {
			aplicarGravedadSalto();
			gestorDeColisiones.verificarColisiones(marioJugable);
		}
		if(movimientoADerecha()) {
			moveMarioDerecha();
			gestorDeColisiones.verificarColisiones(marioJugable);
		}else if(movimientoAIzquierda()) {
			moveMarioIzquierda();
			gestorDeColisiones.verificarColisiones(marioJugable);
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
