package juego;

import java.awt.Point;

import elementos.ElementoDeJuego;
import elementos.entidades.Entidad;
import elementos.entidades.Jugable;
import sensoresDeTeclas.SensorDeTeclasJuego;
import ventanas.DimensionesConstantes;

public class ControladorMovimiento {
	private static final int VELOCIDAD_MOVIMIENTO_HORIZONTAL = 50;
	
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
	
	public void actualizarPosicion() {
		determinarDireccion();
        reiniciarVelocidadHorizontal();
	}
	
	private void moveMarioDerecha() {
		this.velocidadHorizontal = VELOCIDAD_MOVIMIENTO_HORIZONTAL;
		marioJugable.setAvanzando(true);
		aplicarVelocidad();
	}
	
	private void moveMarioIzquierda() {
		this.velocidadHorizontal = -VELOCIDAD_MOVIMIENTO_HORIZONTAL;
		marioJugable.setRetrocediendo(true);
		aplicarVelocidad();
	}
	
	private void cambiarYVerificarPosicionHitboxDeMario() {
		cambiarPosicionHitboxDeMarioX();
		verificarColisiones(marioJugable);
		cambiarPosicionHitboxDeMarioY();
		verificarColisiones(marioJugable);
	}
	
	private void cambiarPosicionHitboxDeMarioX() {
		int nuevaPosicionX = marioJugable.obtenerHitbox().x + marioJugable.getVelocidadDireccional().x;
		Point nuevaPosicion = new Point(nuevaPosicionX, marioJugable.getPosicion().y);
		marioJugable.moverHitbox(nuevaPosicion);
	}
	
	private void cambiarPosicionHitboxDeMarioY() {
		int nuevaPosicionY = marioJugable.obtenerHitbox().y + marioJugable.getVelocidadDireccional().y;
		Point nuevaPosicion = new Point(marioJugable.getPosicion().x, nuevaPosicionY);
		marioJugable.moverHitbox(nuevaPosicion);
	}
	
	private void iniciarSalto() {
		velocidadVertical = FUERZA_SALTO;
		marioJugable.setEnElAire(true);
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
		this.marioJugable.setAvanzando(false);
		this.marioJugable.setRetrocediendo(false);
		if(marioJugable.getColisionArriba()) {
			reiniciarVelocidadVertical();
			marioJugable.setColisionArriba(false);
		}else if (!marioJugable.getColisionAbajo()) {
	        aplicarGravedadSalto();
	    } else if (sensorDeTeclasJuego.obtenerWPresionada()) {
	        iniciarSalto();
	    } else {
	        reiniciarVelocidadVertical();
	    }
	    if (movimientoAIzquierda()) {
	    	moveMarioIzquierda();
	    }
	    if (movimientoADerecha()) {
	    	moveMarioDerecha();
	    }
	    marioJugable.setColisionAbajo(false);
	    cambiarYVerificarPosicionHitboxDeMario();
	}
	
	public void verificarColisiones(Jugable entidad) {
		boolean huboColision = false;
		if(marioJugable.obtenerHitbox().x < 0 || marioJugable.obtenerHitbox().x + marioJugable.obtenerHitbox().width > DimensionesConstantes.PANEL_ANCHO) {
			huboColision = true;
			marioJugable.retrotraerMovimientoHorizontal();
		} else {
			for(ElementoDeJuego elemento : this.nivel.getElementosDeJuego()) {
		        if(entidad.huboColision(elemento)) {
		        	huboColision = true;
		            entidad.aceptarVisitante(elemento.getVisitor());
		            elemento.aceptarVisitante(entidad.getVisitor());
		        }
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