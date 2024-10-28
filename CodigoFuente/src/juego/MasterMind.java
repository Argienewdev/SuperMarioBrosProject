
package juego;

import java.awt.Point;
import elementos.ElementoDeJuego;
import elementos.enemigos.Enemigo;
import elementos.entidades.NoJugable;
import elementos.plataformas.Plataforma;
import elementos.powerUps.PowerUp;
import fabricas.FabricaSprites;
import ventanas.DimensionesConstantes;

public class MasterMind {
	
	protected FabricaSprites fabricaSprites;
	
	protected Nivel nivel;
	
	private static final int GRAVEDAD = 3;
	
	private static final int VELOCIDAD_MAXIMA_DE_CAIDA = 15;
	
	private boolean hayNoJugableParaRemover;
			
	private NoJugable noJugableARemover;
	
	public MasterMind(FabricaSprites fabricaSprites, Nivel nivel) {
		this.fabricaSprites = fabricaSprites;
		this.nivel = nivel;
		this.hayNoJugableParaRemover = false;
		this.noJugableARemover = null;
	}

	public void actualizar() {
		actualizarPosicionesEnemigos();
		actualizarPosicionesPowerUps();
		actualizarSpritesEnemigos();
		actualizarSpritesPowerUps();
		actualizarSpritesPlataformas();
		actualizarLabelsEnemigos();
		actualizarLabelsPowerUps();
		actualizarLabelsPlataformas();
		this.nivel.removerEntidadesAEliminar();
		if(hayNoJugableParaRemover) {
			noJugableARemover.incrementarContadorTicks();
			if(noJugableARemover.getContadorTicks() > noJugableARemover.obtenerTicksAnimacion()) {
				noJugableARemover.eliminarDelNivel();
				noJugableARemover = null;
				hayNoJugableParaRemover = false;
			}
		}
	}
	
	public void cambiarNivel(Nivel nivel) {
		this.nivel = nivel;
	}

	private void actualizarPosicionesEnemigos() {
		for(Enemigo enemigo : this.nivel.getEnemigos()) {
			moverEnemigo(enemigo);
		}
	}
	
	//TODO rudimentario, mejorar expresiones
	private void moverEnemigo(Enemigo enemigo) {
		//No los mueve hasta que esten cerca de entrar a la pantalla
		if(enemigo.getPosicion().x < (DimensionesConstantes.PANEL_ANCHO + 100) && enemigo.getVelocidadDireccional().x == 0) {
			enemigo.moverIzquierda();
		}
		aplicarGravedad(enemigo);
		cambiarYVerificarPosicionHitboxDeNoJugable(enemigo);
	}
	
	private void cambiarYVerificarPosicionHitboxDePowerUp(NoJugable noJugable) {
		cambiarPosicionXHitboxDeNoJugable(noJugable);
		verificarColisionesPowerUps(noJugable);
		cambiarPosicionYHitboxDeNoJugable(noJugable);
		verificarColisionesPowerUps(noJugable);
	}
	
	private void cambiarYVerificarPosicionHitboxDeNoJugable(NoJugable noJugable) {
		cambiarPosicionXHitboxDeNoJugable(noJugable);
		verificarColisionesEnemigos(noJugable);
		cambiarPosicionYHitboxDeNoJugable(noJugable);
		verificarColisionesEnemigos(noJugable);
	}
	
	private void cambiarPosicionXHitboxDeNoJugable(NoJugable noJugable) {
		int nuevaPosicionX = noJugable.obtenerHitbox().x + noJugable.getVelocidadDireccional().x;
		Point nuevaPosicion = new Point(nuevaPosicionX, noJugable.obtenerHitbox().y);
		noJugable.moverHitbox(nuevaPosicion);
	}
	
	private void cambiarPosicionYHitboxDeNoJugable(NoJugable noJugable) {
		int nuevaPosicionY = noJugable.obtenerHitbox().y + noJugable.getVelocidadDireccional().y;
		Point nuevaPosicion = new Point(noJugable.obtenerHitbox().x, nuevaPosicionY);
		noJugable.moverHitbox(nuevaPosicion);
	}
	
	private void verificarColisionesEnemigos(NoJugable noJugable) {
		if((noJugable.obtenerHitbox().x + noJugable.obtenerHitbox().width < 0) || noJugable.obtenerHitbox().y < 0) {
			noJugable.eliminarDelNivel();
		} else {
			for(ElementoDeJuego elemento : this.nivel.getElementosDeJuego()) {
		        if(noJugable.huboColision(elemento) && noJugable != elemento) {
		            elemento.aceptarVisitante(noJugable.getVisitor());
		            noJugable.aceptarVisitante(elemento.getVisitor());
		        }
		    }
			if(noJugable.getRemovido()) {
				hayNoJugableParaRemover = true;
				noJugableARemover = noJugable;
			}
		}
		noJugable.setPosicion(noJugable.obtenerHitbox().getLocation());
	}
	
	private void verificarColisionesPowerUps(NoJugable noJugable) {
		if((noJugable.obtenerHitbox().x + noJugable.obtenerHitbox().width < 0) || noJugable.obtenerHitbox().y < 0) {
			noJugable.eliminarDelNivel();
		} else {
			for(ElementoDeJuego elemento : this.nivel.getElementosDeJuego()) {
				if(noJugable.huboColision(elemento) && noJugable != elemento) {
					elemento.aceptarVisitante(noJugable.getVisitor());
					noJugable.aceptarVisitante(elemento.getVisitor());
				}
				if(noJugable.getRemovido()) {
					hayNoJugableParaRemover = true;
					noJugableARemover = noJugable;
				}
			}
		}
		noJugable.setPosicion(noJugable.obtenerHitbox().getLocation());
	}
	
	private void actualizarPosicionesPowerUps() {
		for(PowerUp powerUp : this.nivel.getPowerUps()) {
			moverPowerUp(powerUp);
		}
	}
	
	private void moverPowerUp(PowerUp powerUp) {
		boolean ticksEnCero = powerUp.getContadorTicks() == 0;
		boolean ticksAlcanzaronMarca = powerUp.getContadorTicks() == powerUp.getTicksHastaSalirDelBloque();
		if(!powerUp.estaDentroDeBloqueDePreguntas() && ticksEnCero) {
			sacarPowerUpDeBloqueDePreguntas(powerUp);
			powerUp.incrementarContadorTicks();
		} else if(!powerUp.estaDentroDeBloqueDePreguntas() && ticksAlcanzaronMarca && powerUp.esMovible()) {
			if(powerUp.getVelocidadDireccional().x == 0) {
				powerUp.moverDerecha();
			}
			aplicarGravedad(powerUp);
			cambiarYVerificarPosicionHitboxDePowerUp(powerUp);
		} else if(!ticksEnCero && !ticksAlcanzaronMarca) {
			powerUp.incrementarContadorTicks();
		}
	}
	
	private void sacarPowerUpDeBloqueDePreguntas(PowerUp powerUp) {
		powerUp.setPosicion(new Point(powerUp.getPosicion().x, powerUp.getBloquePregunta().getPosicion().y - powerUp.getBloquePregunta().obtenerAlto()));
		powerUp.moverHitbox(powerUp.getPosicion());
		powerUp.actualizarSprite(this.fabricaSprites);
	}
	
	private void actualizarSpritesEnemigos() {
		for(Enemigo enemigo : this.nivel.getEnemigos()) {
			enemigo.actualizarSprite(this.fabricaSprites);
		}
	}
	
	private void actualizarSpritesPlataformas() {
		for(Plataforma plataforma: this.nivel.getPlataformasAfectables()){
			plataforma.actualizarSprite(this.fabricaSprites);
		}
	}
	
	private void actualizarSpritesPowerUps() {
		for(PowerUp powerUp : this.nivel.getPowerUps()) {
			powerUp.actualizarSprite(this.fabricaSprites);
		}
	}
	
	private void actualizarLabelsEnemigos() {
		for(Enemigo enemigo : this.nivel.getEnemigos()) {
			enemigo.getObserverGrafico().actualizar();
		}
	}
	
	private void actualizarLabelsPowerUps() {
		for(PowerUp powerUp : this.nivel.getPowerUps()) {
			powerUp.getObserverGrafico().actualizar();
		}
	}
	
	private void actualizarLabelsPlataformas() {
		for(Plataforma plataforma: this.nivel.getPlataformasAfectables()){
			plataforma.getObserverGrafico().actualizar();
		}
	}
	
	private void aplicarGravedad(NoJugable noJugable) {
		if(noJugable.getVelocidadDireccional().y < VELOCIDAD_MAXIMA_DE_CAIDA){
			noJugable.setVelocidadDireccional(new Point(noJugable.getVelocidadDireccional().x, noJugable.getVelocidadDireccional().y + GRAVEDAD));
		}
	}
	
}
