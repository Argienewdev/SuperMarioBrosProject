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
		this.nivel = nivel;
		this.gestorDeColisiones = gestorDeColisiones;
	}
	
	public Point actualizarPosicion() {
		determinarDireccion();
//		cambiarPosicionHitboxDeMario();
//      verificarColisiones(this.marioJugable);
        Point velocidadARetornar = marioJugable.getVelocidadDireccional();
        reiniciarVelocidadHorizontal();
        return velocidadARetornar;
	}
	
	private void moveMarioDerecha() {
		this.velocidadHorizontal = VELOCIDAD_MOVIMIENTO_HORIZONTAL;
		aplicarVelocidad();
	}
	
	private void moveMarioIzquierda() {
		this.velocidadHorizontal = -VELOCIDAD_MOVIMIENTO_HORIZONTAL;
		aplicarVelocidad();
	}
	
	private void cambiarPosicionHitboxDeMario() {
		int nuevaPosicionX = marioJugable.obtenerHitbox().x + marioJugable.getVelocidadDireccional().x;
		Point nuevaPosicion = new Point(nuevaPosicionX, marioJugable.getPosicion().y);
		marioJugable.moverHitbox(nuevaPosicion);
	    verificarColisiones(marioJugable);
		int nuevaPosicionY = marioJugable.obtenerHitbox().y + marioJugable.getVelocidadDireccional().y;
		nuevaPosicion.move(marioJugable.getPosicion().x, nuevaPosicionY);
		marioJugable.moverHitbox(nuevaPosicion);
		verificarColisiones(marioJugable);
	}
	
	private void iniciarSalto() {
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
	    if (!marioJugable.getColisionAbajo()) {
	        aplicarGravedadSalto();
	    } else if (sensorDeTeclasJuego.obtenerWPresionada()) {
	        iniciarSalto();
	        marioJugable.setColisionAbajo(false);
	    } else {
	        reiniciarVelocidadVertical();
	    }

	    //TODO si reinicio las colisiones con el piso, no puedo chocar hacia adelante pero si hacia atras
	    if (movimientoAIzquierda()) {
	    	marioJugable.setColisionAbajo(false);
	    	moveMarioIzquierda();
	    }
	    if (movimientoADerecha()) {
	    	marioJugable.setColisionAbajo(false);
	    	moveMarioDerecha();
	    }
	    cambiarPosicionHitboxDeMario();
//	    verificarColisiones(marioJugable);
	}
	
	public void verificarColisiones(Jugable entidad) {
		boolean huboColision = false;
	    for (ElementoDeJuego elemento : this.nivel.getElementosDeJuego()) {
	        if (entidad.huboColision(elemento)) {
	        	huboColision = true;
	            entidad.aceptarVisitante(elemento.getVisitor());
	            elemento.aceptarVisitante(entidad.getVisitor());
	        }
	    }
	    if(!huboColision) {
	    	entidad.setPosicion(entidad.obtenerHitbox().getLocation());
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