package juego;

import java.awt.Point;
import elementos.ElementoDeJuego;
import elementos.entidades.Jugable;
import sensoresDeTeclas.SensorDeTeclasJuego;
import ventanas.DimensionesConstantes;

public class ControladorMovimiento {
	private static final int VELOCIDAD_MOVIMIENTO_HORIZONTAL = 10;
	
	private static final int FUERZA_SALTO = -24;
	
	private static final int VELOCIDAD_MAXIMA_DE_CAIDA = 25;
	
	private static final int GRAVEDAD = 2;
	
	private int velocidadHorizontal;
	
	private int velocidadVertical;
	
	private Jugable marioJugable;
	
	private SensorDeTeclasJuego sensorDeTeclasJuego;
	
	private Nivel nivel;
	
	@SuppressWarnings("exports")
	public ControladorMovimiento(Jugable marioJugable, SensorDeTeclasJuego sensorDeTeclasJuego, Nivel nivel) {
		this.sensorDeTeclasJuego = sensorDeTeclasJuego;
		this.marioJugable = marioJugable; 
		this.marioJugable.setVelocidadDireccional(new Point(0,0));
		this.velocidadHorizontal = 0;
		this.velocidadVertical = 0;
		this.nivel = nivel;
	}
	
	public void actualizarNivel(Nivel nivel) {
		this.nivel = nivel;
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
		if(velocidadVertical < VELOCIDAD_MAXIMA_DE_CAIDA && !marioJugable.getColisionAbajo()){
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
		if(!this.nivel.fueCompletado()) {
			boolean huboColision = false;
			if(marioJugable.obtenerHitbox().x < 0 || marioJugable.obtenerHitbox().x + marioJugable.obtenerHitbox().width > DimensionesConstantes.PANEL_ANCHO) {
				huboColision = true;
				marioJugable.retrotraerMovimientoHorizontal();
			} else {
				for (ElementoDeJuego elemento : this.nivel.getElementosDeJuego()) {
				    if (entidad.huboColision(elemento)) {
				        huboColision = true;
				        elemento.aceptarVisitante(entidad.getVisitor());
				        entidad.aceptarVisitante(elemento.getVisitor());
				    }
				}

			}
		    if(!huboColision) {
		    	entidad.setPosicion(entidad.obtenerHitbox().getLocation());
		    }
		} else {
	    	this.nivel.obtenerPartida().cambiarNivel();
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