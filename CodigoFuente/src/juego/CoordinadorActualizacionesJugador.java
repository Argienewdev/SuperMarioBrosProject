
package juego;

import elementos.entidades.Jugable;
import elementos.personajes.ContextoMario;
import fabricas.FabricaSprites;
import sensoresDeTeclas.SensorDeTeclasJuego;

public class CoordinadorActualizacionesJugador {
	
	private ControladorMovimiento controladorMovimiento;
	
	private Jugable marioJugable;
	
	private FabricaSprites fabricaSprites;
	
	@SuppressWarnings("exports")
	public CoordinadorActualizacionesJugador(SensorDeTeclasJuego sensorDeTeclasJuego, ContextoMario marioJugable, FabricaSprites fabricaSprites, Nivel nivel) {
		this.fabricaSprites = fabricaSprites;
		this.marioJugable = marioJugable;
		this.controladorMovimiento = new ControladorMovimiento(this.marioJugable, sensorDeTeclasJuego, nivel);
	}
	
	public void actualizar() {
		this.actualizarPosicion();
		marioJugable.actualizarSprite(fabricaSprites);
		this.actualizarObserverMario();
	}
	
	private void actualizarPosicion() {
		this.controladorMovimiento.actualizarPosicion();
	}
	
	private void actualizarObserverMario() {
		this.marioJugable.obtenerObserverGrafico().actualizar();
	}
	
	public ControladorMovimiento obtenerControladorDeMovimiento() {
		return this.controladorMovimiento;
	}

}