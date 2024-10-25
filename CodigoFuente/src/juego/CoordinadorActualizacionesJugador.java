
package juego;

import elementos.personajes.ContextoMario;
import fabricas.FabricaSprites;
import sensoresDeTeclas.SensorDeTeclasJuego;

public class CoordinadorActualizacionesJugador {
	
	private ControladorMovimiento controladorMovimiento;
	
	private ContextoMario marioJugable;
	
	private FabricaSprites fabricaSprites;
	
	@SuppressWarnings("exports")
	public CoordinadorActualizacionesJugador(SensorDeTeclasJuego sensorDeTeclasJuego, ContextoMario marioJugable, FabricaSprites fabricaSprites, Nivel nivel) {
		this.fabricaSprites = fabricaSprites;
		this.marioJugable = marioJugable;
		this.controladorMovimiento = new ControladorMovimiento(this.marioJugable, sensorDeTeclasJuego, nivel);
	}
	
	public void actualizar() {
		actualizarPosicion();
		marioJugable.actualizarSprite(fabricaSprites);
		actualizarObserverMario();
	}
	
	private void actualizarPosicion() {
		this.controladorMovimiento.actualizarPosicion();
	}
	
	private void actualizarObserverMario() {
		this.marioJugable.getObserverGrafico().actualizar();
	}

}