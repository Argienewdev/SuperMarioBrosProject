package juego;

import java.awt.Point;
import elementos.ElementoDeJuego;
import elementos.entidades.Jugable;
import sensoresDeTeclas.SensorDeTeclasJuego;
import ventanas.DimensionesConstantes;

public class ControladorMovimiento {
	private static final int VELOCIDAD_MOVIMIENTO_HORIZONTAL = 10;
	
	private static final int FUERZA_SALTO = -24;
	
	private static final int VELOCIDAD_MAXIMA_DE_CAIDA = 24;
	
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
		determinarAccion();
	    cambiarYVerificarPosicionHitboxDeMario();
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
	
	private void accionEspecial() {
		marioJugable.realizarAccionEspecial();
		
	}
	
	private void determinarAccion() {
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
	    if (realizarAccionEspecial()) {
	    	accionEspecial();
	    }
	    marioJugable.setColisionAbajo(false);
	}

	public void verificarColisiones(Jugable entidad) {
		
		if(!this.nivel.fueCompletado()) {
			boolean huboColision = false;
			if(marioJugable.obtenerHitbox().x < 0 || marioJugable.obtenerHitbox().x + marioJugable.obtenerHitbox().width > DimensionesConstantes.PANEL_ANCHO) {
				huboColision = true;
				this.marioJugable.retrotraerMovimientoHorizontal();
			} else if(marioJugable.obtenerHitbox().y > DimensionesConstantes.PANEL_ALTO){
		        huboColision = true;
		        marioJugable.perderVida();
		        //TODO El nivel se debe reiniciar pero si lo llamamos aca,
		        //y mario esta en otro modo con una hitbox mas grande, el nivel lo posiciona
		        //en la posicion inicial y traspasa el piso
			}else {
				for (ElementoDeJuego elemento : this.nivel.getElementosDeJuego()){
				    if (entidad.huboColision(elemento) && !elemento.getRemovido()) {
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
	
	private boolean realizarAccionEspecial() {
		return sensorDeTeclasJuego.obtenerSpacePresionada() ;
	}
}
