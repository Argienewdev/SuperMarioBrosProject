package juego;

import java.awt.Point;
import java.awt.Rectangle;

import elementos.ElementoDeJuego;
import elementos.entidades.Entidad;
import elementos.entidades.Jugable;
import elementos.plataformas.Plataforma;
import sensoresDeTeclas.SensorDeTeclasJuego;
import ventanas.ConstantesGlobales;

public class ControladorMovimiento {
	
	private Jugable personajeJugable;
	
	private SensorDeTeclasJuego sensorDeTeclasJuego;
	
	private Nivel nivel;
	
	@SuppressWarnings("exports")
	public ControladorMovimiento(Jugable marioJugable, SensorDeTeclasJuego sensorDeTeclasJuego, Nivel nivel) {
		this.sensorDeTeclasJuego = sensorDeTeclasJuego;
		this.personajeJugable = marioJugable; 
		this.personajeJugable.establecerVelocidadDireccional(new Point(0,0));
		this.nivel = nivel;
	}
	
	public void actualizarNivel(Nivel nivel) {
		this.nivel = nivel;
	}
	
	public void actualizarPosicion() {
		this.determinarAccion();
	    this.cambiarYVerificarPosicionHitboxDelJugador();
		reiniciarVelocidadHorizontal();
	}
	
	private void reiniciarVelocidadHorizontal() {
		this.cambiarVelocidadHorizontal(0);
	}

	private void determinarAccion() {
		this.personajeJugable.establecerAvanzando(false);
		this.personajeJugable.establecerRetrocediendo(false);
	    if (deteccionSalto() && personajeJugable.obtenerColisionAbajo()) {
	    	this.iniciarSalto();
	    } 
		
	    if (deteccionMovimientoAIzquierda()) {
	    	this.realizarMovimientoALaIzquierda();
	    }
	    
	    if (deteccionMovimientoADerecha()) {
	    	this.realizarMovimientoALaDerecha();
	    }
	    
	    if (deteccionAccionEspecial()) {
	    	this.realizarAccionEspecial();
	    }
	    personajeJugable.aplicarGravedad();
	}

	private boolean deteccionSalto() {
		boolean retornar = false;
		if (sensorDeTeclasJuego.obtenerWPresionada()) {
			retornar = !sensorDeTeclasJuego.obtenerWAccionada();
			sensorDeTeclasJuego.establecerWAccionada(true);
		}
		return retornar;
	}
	
	private boolean deteccionMovimientoADerecha() {
		return sensorDeTeclasJuego.obtenerDPresionada() && !sensorDeTeclasJuego.obtenerAPresionada();
	}
	
	private boolean deteccionMovimientoAIzquierda() {
		return sensorDeTeclasJuego.obtenerAPresionada() && !sensorDeTeclasJuego.obtenerDPresionada();
	}
	
	private boolean deteccionAccionEspecial() {
		boolean retornar = false;
		if (sensorDeTeclasJuego.obtenerSpacePresionada()) {
			retornar = !sensorDeTeclasJuego.obtenerSpaceAccionada();
			sensorDeTeclasJuego.establecerSpaceAccionada(true);
		}
		return retornar;
	}

	private void realizarMovimientoALaDerecha() {
		cambiarVelocidadHorizontal(ConstantesGlobales.VELOCIDAD_MOVIMIENTO_HORIZONTAL);
		personajeJugable.establecerMirandoAlFrente(true);
		personajeJugable.establecerAvanzando(true);
	}
	
	private void realizarMovimientoALaIzquierda() {
		cambiarVelocidadHorizontal(-ConstantesGlobales.VELOCIDAD_MOVIMIENTO_HORIZONTAL);
		personajeJugable.establecerMirandoAlFrente(false);
		personajeJugable.establecerRetrocediendo(true);
	}
	
	private void iniciarSalto() {
		cambiarVelocidadVertical(ConstantesGlobales.FUERZA_SALTO);
		personajeJugable.establecerColisionAbajo(false);
	}
	
	private void realizarAccionEspecial() {
		personajeJugable.realizarAccionEspecial();
	}
	
	private void cambiarVelocidadHorizontal(int velocidadX) {
		Point nuevaVelocidad = new Point(velocidadX,personajeJugable.obtenerVelocidadDireccional().y);
		personajeJugable.establecerVelocidadDireccional(nuevaVelocidad);
	}
	
	private void cambiarVelocidadVertical(int velocidadY) {
		Point nuevaVelocidad = new Point(personajeJugable.obtenerVelocidadDireccional().x,velocidadY);
		personajeJugable.establecerVelocidadDireccional(nuevaVelocidad);
	}

	private void cambiarYVerificarPosicionHitboxDelJugador() {
		personajeJugable.establecerColisionAbajo(false);
		cambiarPosicionHitboxDelJugadorX();
		verificarColisiones(personajeJugable);
		cambiarPosicionHitboxDelJugadorY();
		verificarColisiones(personajeJugable);
	}
	
	public void verificarColisiones(Jugable entidad) {
		if (!this.nivel.fueCompletado()) {
			boolean marioChocoBordeIzquierdo = personajeJugable.obtenerPosicionGrafica().x < 0;
			boolean marioChocoBordeDerecho = personajeJugable.obtenerPosicionGrafica().x + personajeJugable.obtenerHitbox().width > ConstantesGlobales.PANEL_ANCHO;
			if (marioChocoBordeIzquierdo) {
				int nuevaPosicionLogicaX = this.personajeJugable.obtenerPosicionLogica().x - this.personajeJugable.obtenerPosicionGrafica().x;
				Point nuevaPosicionLogica = new Point(nuevaPosicionLogicaX, this.personajeJugable.obtenerPosicionLogica().y);
				this.personajeJugable.establecerPosicionLogica(nuevaPosicionLogica);
				this.personajeJugable.establecerPosicionGrafica(new Point(0, this.personajeJugable.obtenerPosicionLogica().y));
				this.personajeJugable.moverHitbox(new Point(nuevaPosicionLogicaX, this.personajeJugable.obtenerHitbox().y));
			} else if (marioChocoBordeDerecho) {
				int desplazamientoLogicoX = ConstantesGlobales.PANEL_ANCHO - (ConstantesGlobales.PANEL_ANCHO + personajeJugable.obtenerAncho());
				int nuevaPosicionLogicaX = this.personajeJugable.obtenerPosicionLogica().x + desplazamientoLogicoX;
				Point nuevaPosicionLogica = new Point(nuevaPosicionLogicaX, this.personajeJugable.obtenerPosicionLogica().y);
				this.personajeJugable.establecerPosicionLogica(nuevaPosicionLogica);
				this.personajeJugable.establecerPosicionGrafica(new Point(0, this.personajeJugable.obtenerPosicionLogica().y));
				this.personajeJugable.moverHitbox(new Point(nuevaPosicionLogicaX, this.personajeJugable.obtenerHitbox().y));
			}
			verificarColisionConPlataformas(entidad);
			verificarColisionConEntidades(entidad);
			System.out.println(cont);
			entidad.establecerPosicion(entidad.obtenerHitbox().getLocation());
			
		} else {
	    	this.nivel.obtenerPartida().cambiarNivel();
		}
	}
	
	private void verificarColisionConEntidades(Jugable jugador) {
		for (Entidad entidad : this.nivel.obtenerEntidades()) {
	        if (entidad != null && jugador.huboColision(entidad)) {
	        	entidad.aceptarVisitante(jugador.obtenerVisitante());
	            jugador.aceptarVisitante(entidad.obtenerVisitante());
	        }
	    }
		
	}

	private void verificarColisionConPlataformas(Jugable entidad) {
	    for (ElementoDeJuego elemento : this.nivel.obtenerPlataformasAdyacentes(entidad)) {
	    	if (elemento != null && entidad.huboColision(elemento)) {
	            elemento.aceptarVisitante(entidad.obtenerVisitante());
	            entidad.aceptarVisitante(elemento.obtenerVisitante());
	        }
	    }
	    
	}
	
	private void cambiarPosicionHitboxDelJugadorX() {
		int nuevaPosicionX = personajeJugable.obtenerHitbox().x + personajeJugable.obtenerVelocidadDireccional().x;
		Point nuevaPosicion = new Point(nuevaPosicionX, personajeJugable.obtenerPosicionLogica().y);
		personajeJugable.moverHitbox(nuevaPosicion);
	}
	
	private void cambiarPosicionHitboxDelJugadorY() {
		int nuevaPosicionY = personajeJugable.obtenerHitbox().y + personajeJugable.obtenerVelocidadDireccional().y;
		Point nuevaPosicion = new Point(personajeJugable.obtenerPosicionLogica().x, nuevaPosicionY);
		personajeJugable.moverHitbox(nuevaPosicion);
	}
}
