package juego;

import java.awt.Point;
import elementos.ElementoDeJuego;
import elementos.entidades.Entidad;
import elementos.entidades.Jugable;
import sensoresDeTeclas.SensorDeTeclasJuego;
import ventanas.ConstantesGlobales;

public class ControladorMovimiento {
	
	private Jugable jugable;
	
	private SensorDeTeclasJuego sensorDeTeclasJuego;
	
	protected boolean movimientoPersonajeActivo;
	
	private Nivel nivel;
	
	public ControladorMovimiento(Jugable jugable, SensorDeTeclasJuego sensorDeTeclasJuego, Nivel nivel) {
		this.sensorDeTeclasJuego = sensorDeTeclasJuego;
		this.jugable = jugable; 
		this.jugable.establecerVelocidadDireccional(new Point(0,0));
		this.nivel = nivel;
		this.movimientoPersonajeActivo = false;
	}
	
	public void actualizarNivel(Nivel nivel) {
		this.nivel = nivel;
	}
	
	public void actualizarPosicion() {
		this.reiniciarVelocidadHorizontal();
		if (movimientoPersonajeActivo) {
			this.determinarAccion();
		}
		jugable.aplicarGravedad();
		this.cambiarYVerificarPosicionHitboxDelJugador();
	}
	
	private void reiniciarVelocidadHorizontal() {
		this.cambiarVelocidadHorizontal(0);
		this.jugable.establecerAvanzando(false);
		this.jugable.establecerRetrocediendo(false);
	}
	
	private void determinarAccion() {
		if (this.deteccionSalto() && jugable.obtenerColisionAbajo()) {
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
		jugable.establecerColisionAbajo(false);
		this.cambiarPosicionXDeLaHitboxDelJugador();
		this.verificarColisiones(jugable);
		this.cambiarPosicionYDeLaHitboxDelJugador();
		this.verificarColisiones(jugable);
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
		boolean marioChocoBordeIzquierdo = jugable.obtenerPosicionGrafica().x < 0;
		boolean marioChocoBordeDerecho = jugable.obtenerPosicionGrafica().x + jugable.obtenerHitbox().width > ConstantesGlobales.PANEL_ANCHO;
		if (marioChocoBordeIzquierdo) {
			this.chocarBordeIzquierdo();
		} else if (marioChocoBordeDerecho) {
			this.chocarBordeDerecho();
		}
	}

	private void chocarBordeIzquierdo() {
		int nuevaPosicionLogicaX = this.jugable.obtenerPosicionLogica().x - this.jugable.obtenerPosicionGrafica().x;
		Point nuevaPosicionLogica = new Point(nuevaPosicionLogicaX, this.jugable.obtenerPosicionLogica().y);
		this.jugable.establecerPosicionLogica(nuevaPosicionLogica);
		this.jugable.establecerPosicionGrafica(new Point(0, this.jugable.obtenerPosicionLogica().y));
		this.jugable.moverHitbox(new Point(nuevaPosicionLogicaX, this.jugable.obtenerHitbox().y));
	}

	private void chocarBordeDerecho() {
		int desplazamientoLogicoX = ConstantesGlobales.PANEL_ANCHO - (ConstantesGlobales.PANEL_ANCHO + jugable.obtenerAncho());
		int nuevaPosicionLogicaX = this.jugable.obtenerPosicionLogica().x + desplazamientoLogicoX;
		Point nuevaPosicionLogica = new Point(nuevaPosicionLogicaX, this.jugable.obtenerPosicionLogica().y);
		this.jugable.establecerPosicionLogica(nuevaPosicionLogica);
		this.jugable.establecerPosicionGrafica(new Point(0, this.jugable.obtenerPosicionLogica().y));
		this.jugable.moverHitbox(new Point(nuevaPosicionLogicaX, this.jugable.obtenerHitbox().y));		
	}

	private void cambiarPosicionXDeLaHitboxDelJugador() {
		int nuevaPosicionX = jugable.obtenerHitbox().x + jugable.obtenerVelocidadDireccional().x;
		Point nuevaPosicion = new Point(nuevaPosicionX, jugable.obtenerPosicionLogica().y);
		jugable.moverHitbox(nuevaPosicion);
	}
	
	private void cambiarPosicionYDeLaHitboxDelJugador() {
		int nuevaPosicionY = jugable.obtenerHitbox().y + jugable.obtenerVelocidadDireccional().y;
		Point nuevaPosicion = new Point(jugable.obtenerPosicionLogica().x, nuevaPosicionY);
		jugable.moverHitbox(nuevaPosicion);
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
		jugable.establecerColisionAbajo(false);
		jugable.obtenerNivel().obtenerPartida().obtenerGeneradorSonidos().salto();
	}
	
	private void realizarMovimientoALaIzquierda() {
		this.cambiarVelocidadHorizontal(-ConstantesGlobales.VELOCIDAD_MOVIMIENTO_HORIZONTAL);
		jugable.establecerMirandoAlFrente(false);
		jugable.establecerRetrocediendo(true);
	}
	
	private void realizarMovimientoALaDerecha() {
		this.cambiarVelocidadHorizontal(ConstantesGlobales.VELOCIDAD_MOVIMIENTO_HORIZONTAL);
		jugable.establecerMirandoAlFrente(true);
		jugable.establecerAvanzando(true);
	}

	private void realizarAccionEspecial() {
		jugable.realizarAccionEspecial();
	}

	private void cambiarVelocidadHorizontal(int velocidadX) {
		int nuevaVelocidadX = velocidadX;
		int velocidadY = jugable.obtenerVelocidadDireccional().y;
		Point nuevaVelocidad = new Point(nuevaVelocidadX,velocidadY);
		jugable.establecerVelocidadDireccional(nuevaVelocidad);
	}
	
	private void cambiarVelocidadVertical(int velocidadY) {
		int nuevaVelocidadY = velocidadY;
		int velocidadX = jugable.obtenerVelocidadDireccional().x;
		Point nuevaVelocidad = new Point(velocidadX,nuevaVelocidadY);
		jugable.establecerVelocidadDireccional(nuevaVelocidad);
	}
}

