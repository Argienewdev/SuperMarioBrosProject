package juego;

import java.awt.Point;
import java.awt.Rectangle;

import elementos.ElementoDeJuego;
import elementos.entidades.Jugable;
import sensoresDeTeclas.SensorDeTeclasJuego;
import ventanas.ConstantesGlobales;

public class ControladorMovimiento {
	
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
		this.velocidadHorizontal = ConstantesGlobales.VELOCIDAD_MOVIMIENTO_HORIZONTAL;
		marioJugable.setAvanzando(true);
		aplicarVelocidad();
	}
	
	private void moveMarioIzquierda() {
		this.velocidadHorizontal = -ConstantesGlobales.VELOCIDAD_MOVIMIENTO_HORIZONTAL;
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
		velocidadVertical = ConstantesGlobales.FUERZA_SALTO;
		marioJugable.setEnElAire(true);
		aplicarVelocidad();
	}
	
	private void aplicarGravedadSalto() {
		if(velocidadVertical < ConstantesGlobales.VELOCIDAD_MAXIMA_DE_CAIDA && !marioJugable.getColisionAbajo()){
			velocidadVertical += ConstantesGlobales.GRAVEDAD;
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
			boolean marioChocoBordeIzquierdo = marioJugable.obtenerHitbox().x < 0;
			boolean marioChocoBordeDerecho = marioJugable.obtenerHitbox().x + marioJugable.obtenerHitbox().width > ConstantesGlobales.PANEL_ANCHO;
			if(marioChocoBordeIzquierdo) {
				this.marioJugable.retrotraerMovimientoHorizontal(0);
			} else if(marioChocoBordeDerecho) {
				this.marioJugable.retrotraerMovimientoHorizontal(ConstantesGlobales.PANEL_ANCHO - + marioJugable.obtenerHitbox().width);
			} else {
				//TODO cuando la bola de fuego toca a algun enemigo, pedir la lista de elementos
				//de juego aca tira error porque esta siendo eliminado
				for(ElementoDeJuego elemento : this.nivel.getElementosDeJuego()) {
				    if (entidad.huboColision(elemento)) {
				        elemento.aceptarVisitante(entidad.getVisitor());
				        entidad.aceptarVisitante(elemento.getVisitor());
				    }
				}
			}
			entidad.setPosicion(entidad.obtenerHitbox().getLocation());
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
		boolean retornar = false;
		if(sensorDeTeclasJuego.obtenerSpacePresionada()) {
			retornar = !sensorDeTeclasJuego.obtenerSpaceAccionada();
			sensorDeTeclasJuego.setSpaceAccionada(true);
		}
		return retornar;
	}
}
