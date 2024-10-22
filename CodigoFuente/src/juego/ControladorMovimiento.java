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
		cambiarPosicionLogicaDeMario();
        verificarColisiones(this.marioJugable);
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
	
	private void cambiarPosicionLogicaDeMario() {
		int nuevaPosicionX = marioJugable.obtenerHitbox().x + marioJugable.getVelocidadDireccional().x;
		int nuevaPosicionY = marioJugable.obtenerHitbox().y + marioJugable.getVelocidadDireccional().y;
		Point nuevaPosicion = new Point(nuevaPosicionX, nuevaPosicionY);
		marioJugable.moverHitbox(nuevaPosicion);
	}
	
	private void iniciarSalto() {
		saltando = true;
		velocidadVertical = FUERZA_SALTO;
		aplicarVelocidad();
	}
	
	private void aplicarGravedadSalto() {
		if(velocidadVertical >= FUERZA_SALTO && !marioJugable.getColisionAbajo()){
			velocidadVertical += GRAVEDAD;
			aplicarVelocidad();
		}else if(!marioJugable.getColisionAbajo()){
			aplicarVelocidad();
		}
	}
	
	private void determinarDireccion() {
		if(marioJugable.getColisionAbajo() && sensorDeTeclasJuego.obtenerWPresionada()) {
			iniciarSalto();
			marioJugable.setColisionAbajo(false);
		}else{
			aplicarGravedadSalto();
		}
		// Movimiento horizontal
        if (movimientoADerecha()) {
            moveMarioDerecha();
        } else if (movimientoAIzquierda()) {
            moveMarioIzquierda();
        }
    }
	
	public void verificarColisiones(Jugable entidad) {
	    for (ElementoDeJuego elemento : this.nivel.getElementosDeJuego()) {
	        if (entidad.huboColision(elemento)) {
	            System.out.println("Detecté colisión con: " + elemento.getClass().getSimpleName());
	            entidad.aceptarVisitante(elemento.getVisitor());
	            elemento.aceptarVisitante(entidad.getVisitor());
	        }else {
	        	entidad.setPosicion(entidad.obtenerHitbox().getLocation());
	        }
	    }
	}
	
	private void aplicarVelocidad() {
		Point nuevaVelocidad = new Point(velocidadHorizontal, velocidadVertical);
		marioJugable.setVelocidadDireccional(nuevaVelocidad);
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