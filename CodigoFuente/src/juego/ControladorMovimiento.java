package juego;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import elementos.ElementoDeJuego;
import elementos.entidades.Entidad;
import elementos.entidades.Jugable;
import sensoresDeTeclas.SensorDeTeclasJuego;
import ventanas.ConstantesGlobales;

public class ControladorMovimiento {
	
	private Jugable personajeJugable;
	
	private SensorDeTeclasJuego sensorDeTeclasJuego;
	
	protected boolean movimientoPersonajeActivo;
	
	private Nivel nivel;
	
	@SuppressWarnings("exports")
	public ControladorMovimiento(Jugable marioJugable, SensorDeTeclasJuego sensorDeTeclasJuego, Nivel nivel) {
		this.sensorDeTeclasJuego = sensorDeTeclasJuego;
		this.personajeJugable = marioJugable; 
		this.personajeJugable.establecerVelocidadDireccional(new Point(0,0));
		this.nivel = nivel;
		this.movimientoPersonajeActivo=false;
	}
	
	public void actualizarNivel(Nivel nivel) {
		this.nivel = nivel;
	}
	
	public void actualizarPosicion() {
		this.reiniciarVelocidadHorizontal();
		if(movimientoPersonajeActivo) {
			this.determinarAccion();
		}
		personajeJugable.aplicarGravedad();
		this.cambiarYVerificarPosicionHitboxDelJugador();
	}
	
	private void reiniciarVelocidadHorizontal() {
		this.cambiarVelocidadHorizontal(0);
		this.personajeJugable.establecerAvanzando(false);
		this.personajeJugable.establecerRetrocediendo(false);
		
	}
	
	private void determinarAccion() {
		if (this.deteccionSalto() && personajeJugable.obtenerColisionAbajo()) {
			this.iniciarSalto();
		} 
		
		if (this.deteccionMovimientoAIzquierda()) {
			this.realizarMovimientoALaIzquierda();
		}
		
		if (this.deteccionMovimientoADerecha()) {
			this.realizarMovimientoALaDerecha();
		}
		
		if (this.deteccionAccionEspecial()) {
			this.realizarAccionEspecial();
		}
	}
	
	private void cambiarYVerificarPosicionHitboxDelJugador() {
		personajeJugable.establecerColisionAbajo(false);
		this.cambiarPosicionHitboxDelJugadorX();
		this.verificarColisiones(personajeJugable);
		this.cambiarPosicionHitboxDelJugadorY();
		this.verificarColisiones(personajeJugable);
	}
	
	public void desactivarMovimientoPersonaje() {
		this.movimientoPersonajeActivo = false;
	}
	
	public void activarMovimientoPersonaje() {
		this.movimientoPersonajeActivo = true;
	}

	public void verificarColisiones(Jugable entidad) {
		
		if (!this.nivel.fueCompletado()) {
			this.chequearChoquesConBordes();
			this.verificarColisionConPlataformas(entidad);
			this.verificarColisionConEntidades(entidad);
			entidad.establecerPosicion(entidad.obtenerHitbox().getLocation());
		} else {
			nivel.obtenerPartida().cambiarNivel();
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
	
	private void verificarColisionConEntidades(Jugable jugador) {
		for (Entidad entidad : this.nivel.obtenerEntidadesVisiblesEnPantalla()) {
	        if (entidad != null && jugador.huboColision(entidad)) {
	        	entidad.aceptarVisitante(jugador.obtenerVisitante());
	            jugador.aceptarVisitante(entidad.obtenerVisitante());
	        }
	    }
		
	}

	private void chequearChoquesConBordes() {
		boolean marioChocoBordeIzquierdo = personajeJugable.obtenerPosicionGrafica().x < 0;
		boolean marioChocoBordeDerecho = personajeJugable.obtenerPosicionGrafica().x + personajeJugable.obtenerHitbox().width > ConstantesGlobales.PANEL_ANCHO;
		if (marioChocoBordeIzquierdo) {
			this.chocarBordeIzquierdo();
		} else if (marioChocoBordeDerecho) {
			this.chocarBordeDerecho();
		}
	}

	private void chocarBordeIzquierdo() {
		int nuevaPosicionLogicaX = this.personajeJugable.obtenerPosicionLogica().x - this.personajeJugable.obtenerPosicionGrafica().x;
		Point nuevaPosicionLogica = new Point(nuevaPosicionLogicaX, this.personajeJugable.obtenerPosicionLogica().y);
		this.personajeJugable.establecerPosicionLogica(nuevaPosicionLogica);
		this.personajeJugable.establecerPosicionGrafica(new Point(0, this.personajeJugable.obtenerPosicionLogica().y));
		this.personajeJugable.moverHitbox(new Point(nuevaPosicionLogicaX, this.personajeJugable.obtenerHitbox().y));
	}

	private void chocarBordeDerecho() {
		int desplazamientoLogicoX = ConstantesGlobales.PANEL_ANCHO - (ConstantesGlobales.PANEL_ANCHO + personajeJugable.obtenerAncho());
		int nuevaPosicionLogicaX = this.personajeJugable.obtenerPosicionLogica().x + desplazamientoLogicoX;
		Point nuevaPosicionLogica = new Point(nuevaPosicionLogicaX, this.personajeJugable.obtenerPosicionLogica().y);
		this.personajeJugable.establecerPosicionLogica(nuevaPosicionLogica);
		this.personajeJugable.establecerPosicionGrafica(new Point(0, this.personajeJugable.obtenerPosicionLogica().y));
		this.personajeJugable.moverHitbox(new Point(nuevaPosicionLogicaX, this.personajeJugable.obtenerHitbox().y));		
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

	private boolean deteccionSalto() {
		boolean retornar = false;
		if (sensorDeTeclasJuego.obtenerWPresionada()) {
			retornar = !sensorDeTeclasJuego.obtenerWAccionada();
			sensorDeTeclasJuego.establecerWAccionada(true);
		}
		return retornar;
	}
	
	private boolean deteccionMovimientoAIzquierda() {
		return sensorDeTeclasJuego.obtenerAPresionada() && !sensorDeTeclasJuego.obtenerDPresionada();
	}
	
	private boolean deteccionMovimientoADerecha() {
		return sensorDeTeclasJuego.obtenerDPresionada() && !sensorDeTeclasJuego.obtenerAPresionada();
	}
	
	private boolean deteccionAccionEspecial() {
		boolean retornar = false;
		if (sensorDeTeclasJuego.obtenerSpacePresionada()) {
			retornar = !sensorDeTeclasJuego.obtenerSpaceAccionada();
			sensorDeTeclasJuego.establecerSpaceAccionada(true);
		}
		return retornar;
	}
	
	private void iniciarSalto() {
		this.cambiarVelocidadVertical(ConstantesGlobales.FUERZA_SALTO);
		personajeJugable.establecerColisionAbajo(false);
		personajeJugable.obtenerNivel().obtenerPartida().obtenerGeneradorSonidos().salto();
	}
	
	private void realizarMovimientoALaIzquierda() {
		this.cambiarVelocidadHorizontal(-ConstantesGlobales.VELOCIDAD_MOVIMIENTO_HORIZONTAL);
		personajeJugable.establecerMirandoAlFrente(false);
		personajeJugable.establecerRetrocediendo(true);
	}
	
	private void realizarMovimientoALaDerecha() {
		this.cambiarVelocidadHorizontal(ConstantesGlobales.VELOCIDAD_MOVIMIENTO_HORIZONTAL);
		personajeJugable.establecerMirandoAlFrente(true);
		personajeJugable.establecerAvanzando(true);
	}

	private void realizarAccionEspecial() {
		personajeJugable.realizarAccionEspecial();
	}

	private void cambiarVelocidadHorizontal(int velocidadX) {
		int nuevaVelocidadX = velocidadX;
		int velocidadY = personajeJugable.obtenerVelocidadDireccional().y;
		Point nuevaVelocidad = new Point(nuevaVelocidadX,velocidadY);
		personajeJugable.establecerVelocidadDireccional(nuevaVelocidad);
	}
	
	private void cambiarVelocidadVertical(int velocidadY) {
		int nuevaVelocidadY = velocidadY;
		int velocidadX = personajeJugable.obtenerVelocidadDireccional().x;
		Point nuevaVelocidad = new Point(velocidadX,nuevaVelocidadY);
		personajeJugable.establecerVelocidadDireccional(nuevaVelocidad);
	}
}

