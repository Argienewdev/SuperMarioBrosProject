package juego;

import java.awt.Point;

import elementos.ElementoDeJuego;
import elementos.entidades.Entidad;
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
	
	private Jugable marioJugable;
	
	private SensorDeTeclasJuego sensorDeTeclasJuego;
	
	private Nivel nivel;
	
	private GestorDeColisiones gestorDeColisiones;
	
	public ControladorMovimiento(Jugable marioJugable, SensorDeTeclasJuego sensorDeTeclasJuego, Nivel nivel, GestorDeColisiones gestorDeColisiones) {
		this.sensorDeTeclasJuego = sensorDeTeclasJuego;
		this.marioJugable = marioJugable; 
		this.marioJugable.setVelocidadDireccional(new Point(0,0));
		velocidadHorizontal = 0;
		velocidadVertical = 0;
		posicion = new Point(marioJugable.getPosicion().x, marioJugable.getPosicion().y);
		saltando = false;
		this.nivel = nivel;
		this.gestorDeColisiones = gestorDeColisiones;
	}
	
	public Point actualizarVelocidad() {
		determinarDireccion();
		return marioJugable.getVelocidadDireccional();
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
		cambiarPosicionLogicaDeMario();
	}
	
	private void cambiarPosicionLogicaDeMario() {
		int nuevaPosicionX = posicion.x + this.marioJugable.getVelocidadDireccional().x;
		int nuevaPosicionY = posicion.y + this.marioJugable.getVelocidadDireccional().y;
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
			verificarColisiones(this.marioJugable);
		}else if(saltando) {
			aplicarGravedadSalto();
			verificarColisiones(this.marioJugable);
		}
		// Movimiento horizontal
        if (movimientoADerecha() && !marioJugable.getColisionADerecha()) {
            marioJugable.setColisionAIzquierda(false);
            moveMarioDerecha();
        } else if (movimientoAIzquierda() && !marioJugable.getColisionAIzquierda()) {
            marioJugable.setColisionADerecha(false);
            moveMarioIzquierda();
        } else {
            velocidadHorizontal = 0; // Detener movimiento si no hay entrada
        }

        aplicarVelocidad();
        verificarColisiones(this.marioJugable);
    }
	
	public void verificarColisiones(Jugable entidad) {
	    boolean colisionDetectada = false;
	    for (ElementoDeJuego elemento : this.nivel.getElementosDeJuego()) {
	        if (entidad.huboColision(elemento)) {
	            System.out.println("Detecté colisión con: " + elemento.getClass().getSimpleName());
	            entidad.aceptarVisitante(elemento.getVisitor());
	            elemento.aceptarVisitante(entidad.getVisitor());
	            colisionDetectada = true;
	        }
	    }
	    if (!colisionDetectada) {
	        entidad.setColisionADerecha(false);
	        entidad.setColisionAIzquierda(false);
	    }
	}
	
	private void aplicarVelocidad() {
		this.marioJugable.getVelocidadDireccional().move(velocidadHorizontal, velocidadVertical);
		marioJugable.setVelocidadDireccional(this.marioJugable.getVelocidadDireccional());
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