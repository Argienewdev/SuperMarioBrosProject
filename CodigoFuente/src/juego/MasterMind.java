
package juego;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collection;

import elementos.ElementoDeJuego;
import elementos.enemigos.Enemigo;
import elementos.entidades.Jugable;
import elementos.entidades.NoJugable;
import elementos.powerUps.PowerUp;
import fabricas.FabricaSprites;
import observers.ObserverEntidades;
import ventanas.DimensionesConstantes;

public class MasterMind {
	
	protected Collection<Enemigo> enemigos;
		
	protected Collection<PowerUp> powerUps;
	
	protected FabricaSprites fabricaSprites;
	
	protected Nivel nivel;
		
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
	}

	private void actualizarPosicionesEnemigos() {
		for(Enemigo enemigo : this.enemigos) {
			moverEnemigo(enemigo);
		}
	}
	
	private void moverEnemigo(Enemigo enemigo) {
		cambiarYVerificarPosicionHitboxDeEnemigo(enemigo);
	}
	
	private void cambiarYVerificarPosicionHitboxDeEnemigo(Enemigo enemigo) {
		cambiarPosicionHitboxDeEnemigoX(enemigo);
		verificarColisiones(enemigo);
		cambiarPosicionHitboxDeEnemigoY(enemigo);
		verificarColisiones(enemigo);
	}
	
	private void actualizarPosicionesPowerUps() {
		for(PowerUp powerUp : this.powerUps) {
			powerUp.setPosicion(new Point(powerUp.getPosicion().x+1,powerUp.getPosicion().y));
			powerUp.setVelocidadDireccional(new Point(1,0));
		}
		
	}
	
	private void cambiarPosicionHitboxDeEnemigoX(Enemigo enemigo) {
		int nuevaPosicionX = enemigo.obtenerHitbox().x + enemigo.getVelocidadDireccional().x;
		Point nuevaPosicion = new Point(nuevaPosicionX, enemigo.getPosicion().y);
		enemigo.moverHitbox(nuevaPosicion);
	}
	
	private void cambiarPosicionHitboxDeEnemigoY(Enemigo enemigo) {
		int nuevaPosicionY = enemigo.obtenerHitbox().y + enemigo.getVelocidadDireccional().y;
		Point nuevaPosicion = new Point(enemigo.getPosicion().x, nuevaPosicionY);
		enemigo.moverHitbox(nuevaPosicion);
	}
	
	private void verificarColisiones(NoJugable noJugable) {
		boolean huboColision = false;
		if(noJugable.obtenerHitbox().x + noJugable.obtenerHitbox().width < 0) {
			huboColision = true;
			noJugable.eliminarDelNivel();
		} else {
			for(ElementoDeJuego elemento : this.nivel.getElementosDeJuego()) {
		        if(noJugable.huboColision(elemento) && noJugable != elemento) {
		        	huboColision = true;
		        	noJugable.aceptarVisitante(elemento.getVisitor());
		            elemento.aceptarVisitante(noJugable.getVisitor());
		        }
		    }
		}
	    if(!huboColision) {
	    	noJugable.setPosicion(noJugable.obtenerHitbox().getLocation());
	    } else {
	    	invertirVelocidadDireccional(noJugable);
	    }
	}
	
	private void invertirVelocidadDireccional(NoJugable noJugable) {
		Point velocidadDireccionalActual = noJugable.getVelocidadDireccional();
		noJugable.setVelocidadDireccional(new Point(-velocidadDireccionalActual.x,velocidadDireccionalActual.y));
	}
	
	private void actualizarSpritesEnemigos() {
		for(Enemigo enemigo : this.enemigos) {
			enemigo.actualizarSprite(this.fabricaSprites);
		}
	}	
	
	private void actualizarSpritesPowerUps() {
		for(PowerUp powerUp : this.powerUps) {
			powerUp.actualizarSprite(this.fabricaSprites);
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
	
}
