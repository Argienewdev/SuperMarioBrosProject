
package juego;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collection;
import elementos.ElementoDeJuego;
import elementos.enemigos.Enemigo;
import elementos.entidades.NoJugable;
import elementos.powerUps.PowerUp;
import fabricas.FabricaSprites;

public class MasterMind {
	
	protected Collection<Enemigo> enemigos;
		
	protected Collection<PowerUp> powerUps;
	
	protected FabricaSprites fabricaSprites;
	
	protected Nivel nivel;
	
	private static final int GRAVEDAD = 3;
	
	private static final int VELOCIDAD_MAXIMA_DE_CAIDA = 15;
			
	public MasterMind(FabricaSprites fabricaSprites, Nivel nivel) {
		this.fabricaSprites = fabricaSprites;
		this.nivel = nivel;
		crearColeccionDeEnemigos();
		crearColeccionDePowerUps();
	}

	public void crearColeccionDeEnemigos() {
		this.enemigos = new ArrayList<Enemigo>();
		for(Enemigo enemigo : this.nivel.getEnemigos()) {
			this.enemigos.add(enemigo);
		}
	}
	
	public void crearColeccionDePowerUps() {
		this.powerUps = new ArrayList<PowerUp>();
		for(PowerUp powerUp : this.nivel.getPowerUps()) {
			this.powerUps.add(powerUp);
		}
	}
	
	public void actualizar() {
		actualizarPosicionesEnemigos();
		actualizarPosicionesPowerUps();
		actualizarSpritesEnemigos();
		actualizarSpritesPowerUps();
		actualizarLabelsEnemigos();
		actualizarLabelsPowerUps();
		this.nivel.removerEntidadesAEliminar();
	}

	private void actualizarPosicionesEnemigos() {
		for(Enemigo enemigo : this.nivel.getEnemigos()) {
			moverEnemigo(enemigo);
		}
	}
	
	private void moverEnemigo(Enemigo enemigo) {
		cambiarYVerificarPosicionHitboxDeNoJugable(enemigo);
	}
	
	private void cambiarYVerificarPosicionHitboxDeNoJugable(NoJugable noJugable) {
		cambiarPosicionXHitboxDeNoJugable(noJugable);
		verificarColisiones(noJugable);
		cambiarPosicionYHitboxDeNoJugable(noJugable);
		verificarColisiones(noJugable);
	}
	
	private void cambiarPosicionXHitboxDeNoJugable(NoJugable noJugable) {
		int nuevaPosicionX = noJugable.obtenerHitbox().x + noJugable.getVelocidadDireccional().x;
		Point nuevaPosicion = new Point(nuevaPosicionX, noJugable.getPosicion().y);
		noJugable.moverHitbox(nuevaPosicion);
	}
	
	private void cambiarPosicionYHitboxDeNoJugable(NoJugable noJugable) {
		int nuevaPosicionY = noJugable.obtenerHitbox().y + noJugable.getVelocidadDireccional().y;
		Point nuevaPosicion = new Point(noJugable.getPosicion().x, nuevaPosicionY);
		noJugable.moverHitbox(nuevaPosicion);
	}
	
	private void verificarColisiones(NoJugable noJugable) {
		boolean huboColision = false;
		if((noJugable.obtenerHitbox().x + noJugable.obtenerHitbox().width < 0) || noJugable.obtenerHitbox().y < 0) {
			huboColision = true;
			noJugable.eliminarDelNivel();
		} else {
			for(ElementoDeJuego elemento : this.nivel.getElementosDeJuego()) {
		        if(noJugable.huboColision(elemento) && noJugable != elemento) {
		        	huboColision = true;
		            elemento.aceptarVisitante(noJugable.getVisitor());
		            noJugable.aceptarVisitante(elemento.getVisitor());
		        }
		    }
			//TODO no me gusta esto pero como mario no es parte de los elementos de juego en el nivel tuve que hacerlo
			if(noJugable.huboColision(nivel.getMario())) {
	        	nivel.getMario().aceptarVisitante(noJugable.getVisitor());
	            noJugable.aceptarVisitante(nivel.getMario().getVisitor());
			}
		}
	    if(!huboColision) {
	    	noJugable.setPosicion(noJugable.obtenerHitbox().getLocation());
	    }
	}
	
	private void actualizarPosicionesPowerUps() {
		for(PowerUp powerUp : this.nivel.getPowerUps()) {
			moverPowerUp(powerUp);
		}
	}
	
	private void moverPowerUp(PowerUp powerUp) {
		if(!powerUp.estaDentroDeBloqueDePreguntas() && powerUp.getContadorTicks() == 0) {
			sacarPowerUpDeBloqueDePreguntas(powerUp);
			powerUp.incrementarContadorTicks();
		} else if(!powerUp.estaDentroDeBloqueDePreguntas() && powerUp.getContadorTicks() > powerUp.getTicksHastaSalirDelBloque()) {
			aplicarGravedad(powerUp);
			cambiarYVerificarPosicionHitboxDeNoJugable(powerUp);
		} else if(powerUp.getContadorTicks() >= 1) {
			powerUp.incrementarContadorTicks();
		}
	}
	
	private void sacarPowerUpDeBloqueDePreguntas(PowerUp powerUp) {
		powerUp.setPosicion(new Point(powerUp.getPosicion().x, powerUp.getPosicion().y - powerUp.obtenerAlto()));
		powerUp.moverHitbox(powerUp.getPosicion());
		powerUp.actualizarSprite(this.fabricaSprites);
	}
	
	private void actualizarSpritesEnemigos() {
		for(Enemigo enemigo : this.nivel.getEnemigos()) {
			enemigo.actualizarVisual(this.fabricaSprites);
		}
	}	
	
	private void actualizarSpritesPowerUps() {
		for(PowerUp powerUp : this.nivel.getPowerUps()) {
			powerUp.actualizarVisual(this.fabricaSprites);
		}
	}
	
	private void actualizarLabelsEnemigos() {
		for(Enemigo enemigo : this.enemigos) {
			enemigo.getObserverGrafico().actualizar();
		}
	}
	
	private void actualizarLabelsPowerUps() {
		for(PowerUp powerUp : this.powerUps) {
			powerUp.getObserverGrafico().actualizar();
		}
	}
	
	private void aplicarGravedad(NoJugable noJugable) {
		if(noJugable.getVelocidadDireccional().y < VELOCIDAD_MAXIMA_DE_CAIDA){
			noJugable.setVelocidadDireccional(new Point(noJugable.getVelocidadDireccional().x, noJugable.getVelocidadDireccional().y + GRAVEDAD));
		}
	}
	
}
