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
		this.marioJugable.establecerVelocidadDireccional(new Point(0,0));
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
	
	private void moverMarioDerecha() {
		this.velocidadHorizontal = ConstantesGlobales.VELOCIDAD_MOVIMIENTO_HORIZONTAL;
		marioJugable.establecerAvanzando(true);
		aplicarVelocidad();
	}
	
	private void moverMarioIzquierda() {
		this.velocidadHorizontal = -ConstantesGlobales.VELOCIDAD_MOVIMIENTO_HORIZONTAL;
		marioJugable.establecerRetrocediendo(true);
		aplicarVelocidad();
	}
	
	private void cambiarYVerificarPosicionHitboxDeMario() {
		cambiarPosicionHitboxDeMarioX();
		verificarColisiones(marioJugable);
		cambiarPosicionHitboxDeMarioY();
		verificarColisiones(marioJugable);
	}
	
	private void cambiarPosicionHitboxDeMarioX() {
		int nuevaPosicionX = marioJugable.obtenerHitbox().x + marioJugable.obtenerVelocidadDireccional().x;
		Point nuevaPosicion = new Point(nuevaPosicionX, marioJugable.obtenerPosicion().y);
		marioJugable.moverHitbox(nuevaPosicion);
	}
	
	private void cambiarPosicionHitboxDeMarioY() {
		int nuevaPosicionY = marioJugable.obtenerHitbox().y + marioJugable.obtenerVelocidadDireccional().y;
		Point nuevaPosicion = new Point(marioJugable.obtenerPosicion().x, nuevaPosicionY);
		marioJugable.moverHitbox(nuevaPosicion);
	}
	
	private void iniciarSalto() {
		velocidadVertical = ConstantesGlobales.FUERZA_SALTO;
		marioJugable.establecerEnElAire(true);
		aplicarVelocidad();
	}
	
	private void aplicarGravedadSalto() {
		if(velocidadVertical < ConstantesGlobales.VELOCIDAD_MAXIMA_DE_CAIDA && !marioJugable.obtenerColisionAbajo()){
			velocidadVertical += ConstantesGlobales.GRAVEDAD;
			aplicarVelocidad();
		}else if(!marioJugable.obtenerColisionAbajo()){
			aplicarVelocidad();
		}
	}
	
	private void accionEspecial() {
		marioJugable.realizarAccionEspecial();
		
	}
	
	private void determinarAccion() {
		this.marioJugable.establecerAvanzando(false);
		this.marioJugable.establecerRetrocediendo(false);
		
		if(marioJugable.obtenerColisionArriba()) {
			reiniciarVelocidadVertical();
			marioJugable.establecerColisionArriba(false);
		}else if (!marioJugable.obtenerColisionAbajo()) {
	        aplicarGravedadSalto();
	    } else if (sensorDeTeclasJuego.obtenerWPresionada()) {
	        iniciarSalto();
	    } else {
	        reiniciarVelocidadVertical();
	    }
		
	    if (movimientoAIzquierda()) {
	    	moverMarioIzquierda();
	    }
	    
	    if (movimientoADerecha()) {
	    	moverMarioDerecha();
	    }
	    
	    if (realizarAccionEspecial()) {
	    	accionEspecial();
	    }
	    marioJugable.establecerColisionAbajo(false);
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
				System.out.println(entidad.obtenerPosicion().x+"|"+entidad.obtenerPosicion().y);
				//TODO cuando la bola de fuego toca a algun enemigo, pedir la lista de elementos
				//de juego aca tira error porque esta siendo eliminado
				for(ElementoDeJuego elemento : this.nivel.obtenerElementosDeJuego()) {
				    if (entidad.huboColision(elemento)) {
				        elemento.aceptarVisitante(entidad.obtenerVisitante());
				        entidad.aceptarVisitante(elemento.obtenerVisitante());
				    }
				}
			}
			entidad.establecerPosicion(entidad.obtenerHitbox().getLocation());
		} else {
	    	this.nivel.obtenerPartida().cambiarNivel();
		}
	}
	
	private void aplicarVelocidad() {
		Point nuevaVelocidad = new Point(velocidadHorizontal, velocidadVertical);
		marioJugable.establecerVelocidadDireccional(nuevaVelocidad);
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
			sensorDeTeclasJuego.establecerSpaceAccionada(true);
		}
		return retornar;
	}
}
