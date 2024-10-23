
package juego;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collection;

import elementos.enemigos.Enemigo;
import elementos.entidades.NoJugable;
import elementos.powerUps.PowerUp;
import fabricas.FabricaSprites;
import observers.ObserverEntidades;

public class MasterMind {
	
	protected Collection<NoJugable> entidadesNoJugables;
	
	protected ControladorMovimientoEntidadesNoJugables controladorMovimientoEntidadesNoJugables;
	
	protected FabricaSprites fabricaSprites;
	
	protected Nivel nivel;
		
	public MasterMind(FabricaSprites fabricaSprites, Nivel nivel) {
		this.controladorMovimientoEntidadesNoJugables = new ControladorMovimientoEntidadesNoJugables();
		this.fabricaSprites = fabricaSprites;
		this.nivel = nivel;
		crearColeccionDeEntidades();
	}

	public void crearColeccionDeEntidades() {
		this.entidadesNoJugables = new ArrayList<NoJugable>();
		for(Enemigo enemigo : this.nivel.getEnemigos()) {
			this.entidadesNoJugables.add(enemigo);
		}
		for(PowerUp powerUp : this.nivel.getPowerUps()) {
			this.entidadesNoJugables.add(powerUp);
		}
	}
	
	public void actualizar() {
		actualizarPosiciones();
		actualizarSprites();
		actualizarLabels();
	}
	
	public void actualizarPosiciones() {
		this.controladorMovimientoEntidadesNoJugables.actualizarPosicion(this.entidadesNoJugables);
	}
	
	public void actualizarSprites() {
		for(NoJugable entidadNoJugable : this.entidadesNoJugables) {
			entidadNoJugable.actualizarSprite(this.fabricaSprites);
		}
	}	
	
	public void actualizarLabels() {
		for(NoJugable entidadNoJugable : this.entidadesNoJugables) {
			entidadNoJugable.getObserverGrafico().actualizar();
		}
	}
	
}
