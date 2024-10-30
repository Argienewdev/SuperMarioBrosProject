
package juego;

import java.awt.Point;
import elementos.ElementoDeJuego;
import elementos.enemigos.Enemigo;
import elementos.entidades.BolaDeFuego;
import elementos.entidades.Entidad;
import elementos.entidades.NoJugable;
import elementos.plataformas.Plataforma;
import elementos.powerUps.PowerUp;
import fabricas.FabricaSprites;
import ventanas.ConstantesGlobales;

public class MasterMind {
	
	protected FabricaSprites fabricaSprites;
	
	protected Nivel nivel;
	
	public MasterMind(FabricaSprites fabricaSprites, Nivel nivel) {
		this.fabricaSprites = fabricaSprites;
		this.nivel = nivel;
	}

	public void actualizar() {
		actualizarPosicionesEnemigos();
		actualizarPosicionesPowerUps();
		actualizarPosicionesBolasDeFuego();
		actualizarSpritesEnemigos();
		actualizarSpritesPowerUps();
		actualizarSpritesPlataformas();
		actualizarSpritesBolasDeFuego();
		actualizarLabelsEnemigos();
		actualizarLabelsPowerUps();
		actualizarLabelsPlataformas();
		actualizarLabelsBolasDeFuego();
		this.nivel.removerEntidadesAEliminar();
		this.nivel.agregarBolaDeFuegoAAgregar();
		this.nivel.agregarSpinysAAgregar();
	}
	
	public void cambiarNivel(Nivel nivel) {
		this.nivel = nivel;
	}
	
	private void moverEnemigo(Enemigo enemigo) {
		boolean esVisibleEnLaPantalla = enemigo.obtenerPosicion().x <= (ConstantesGlobales.PANEL_ANCHO + 75)
										&& enemigo.obtenerPosicion().x >= 0;
		if (esVisibleEnLaPantalla) {
			if (enemigo.obtenerDebeMantenerseSiempreEnPantalla()) {
				boolean chocoBordeIzquierdo = enemigo.obtenerHitbox().x <= 0; 
				boolean chocoBordeDerecho = enemigo.obtenerHitbox().x + enemigo.obtenerAncho() >= ConstantesGlobales.PANEL_ANCHO;
				if (chocoBordeIzquierdo || chocoBordeDerecho) {
					enemigo.invertirDireccion();
				}
			}
			enemigo.mover();
			enemigo.aplicarGravedad();
		}
		cambiarYVerificarPosicionHitboxDeEntidad(enemigo);
	}
	
	private void cambiarYVerificarPosicionHitboxDeEntidad(Entidad entidad) {
		cambiarPosicionXHitboxDeEntidad(entidad);
		verificarColisionesEntidades(entidad);
		cambiarPosicionYHitboxDeEntidad(entidad);
		verificarColisionesEntidades(entidad);
	}
	
	private void cambiarPosicionXHitboxDeEntidad(Entidad entidad) {
		int nuevaPosicionX = entidad.obtenerHitbox().x + entidad.obtenerVelocidadDireccional().x;
		Point nuevaPosicion = new Point(nuevaPosicionX, entidad.obtenerHitbox().y);
		entidad.moverHitbox(nuevaPosicion);
	}
	
	private void cambiarPosicionYHitboxDeEntidad(Entidad entidad) {
		int nuevaPosicionY = entidad.obtenerHitbox().y + entidad.obtenerVelocidadDireccional().y;
		Point nuevaPosicion = new Point(entidad.obtenerHitbox().x, nuevaPosicionY);
		entidad.moverHitbox(nuevaPosicion);
	}
	
	private void verificarColisionesEntidades(Entidad entidad) {
		if((entidad.obtenerHitbox().x + entidad.obtenerHitbox().width < 0) || entidad.obtenerHitbox().y < 0) {
			entidad.establecerRemovido(true);
		} else {
			for(ElementoDeJuego elemento : this.nivel.obtenerElementosDeJuego()) {
		        if(entidad.huboColision(elemento) && entidad != elemento) {
		            elemento.aceptarVisitante(entidad.obtenerVisitante());
		            entidad.aceptarVisitante(elemento.obtenerVisitante());
		        }
		    }
		}
		entidad.establecerPosicion(entidad.obtenerHitbox().getLocation());
	}
	
	private void actualizarPosicionesEnemigos() {
		for(Enemigo enemigo : this.nivel.obtenerEnemigos()) {
			moverEnemigo(enemigo);
		}
	}
	
	private void actualizarPosicionesPowerUps() {
		for(PowerUp powerUp : this.nivel.obtenerPowerUps()) {
			moverPowerUp(powerUp);
		}
	}
	
	private void actualizarPosicionesBolasDeFuego() {
		for(BolaDeFuego bola : this.nivel.obtenerBolasDeFuego()) {
			moverBolaDeFuego(bola);
		}
	}
	
	private void moverPowerUp(PowerUp powerUp) {
		boolean ticksEnCero = powerUp.obtenerContadorTicks() == 0;
		boolean ticksAlcanzaronMarca = powerUp.obtenerContadorTicks() == powerUp.obtenerTicksHastaSalirDelBloque();
		if(!powerUp.estaDentroDeBloqueDePreguntas() && ticksEnCero) {
			sacarPowerUpDeBloqueDePreguntas(powerUp);
			powerUp.incrementarContadorTicks();
		} else if(!powerUp.estaDentroDeBloqueDePreguntas() && ticksAlcanzaronMarca && powerUp.esMovible()) {
			if(powerUp.obtenerVelocidadDireccional().x == 0) {
				powerUp.mover();
			}
			powerUp.aplicarGravedad();
			cambiarYVerificarPosicionHitboxDeEntidad(powerUp);
		} else if(!ticksEnCero && !ticksAlcanzaronMarca) {
			powerUp.incrementarContadorTicks();
		}
	}
	
	private void moverBolaDeFuego(BolaDeFuego bolaFuego) {
		bolaFuego.aplicarGravedad();
		cambiarYVerificarPosicionHitboxDeEntidad(bolaFuego);
	}
	
	private void sacarPowerUpDeBloqueDePreguntas(PowerUp powerUp) {
		powerUp.establecerPosicion(new Point(powerUp.obtenerPosicion().x, powerUp.obtenerBloquePregunta().obtenerPosicion().y - powerUp.obtenerAlto()));
		powerUp.moverHitbox(powerUp.obtenerPosicion());
		powerUp.actualizarSprite(this.fabricaSprites);
	}
	
	private void actualizarSpritesEnemigos() {
		for(Enemigo enemigo : this.nivel.obtenerEnemigos()) {
			enemigo.actualizarSprite(this.fabricaSprites);
		}
	}
	
	private void actualizarSpritesPlataformas() {
		for(Plataforma plataforma: this.nivel.obtenerPlataformasAfectables()){
			plataforma.actualizarSprite(this.fabricaSprites);
		}
	}
	
	private void actualizarSpritesPowerUps() {
		for(PowerUp powerUp : this.nivel.obtenerPowerUps()) {
			powerUp.actualizarSprite(this.fabricaSprites);
		}
	}
	
	private void actualizarSpritesBolasDeFuego() {
		for(BolaDeFuego bola : this.nivel.obtenerBolasDeFuego()) {
			bola.actualizarSprite(this.fabricaSprites);
		}
	}
	
	private void actualizarLabelsEnemigos() {
		for(Enemigo enemigo : this.nivel.obtenerEnemigos()) {
			enemigo.obtenerObserverGrafico().actualizar();
		}
	}
	
	private void actualizarLabelsPowerUps() {
		for(PowerUp powerUp : this.nivel.obtenerPowerUps()) {
			powerUp.obtenerObserverGrafico().actualizar();
		}
	}
	
	private void actualizarLabelsPlataformas() {
		for(Plataforma plataforma: this.nivel.obtenerPlataformasAfectables()){
			plataforma.obtenerObserverGrafico().actualizar();
		}
	}
	
	private void actualizarLabelsBolasDeFuego() {
		for(BolaDeFuego bola : this.nivel.obtenerBolasDeFuego()){
			bola.obtenerObserverGrafico().actualizar();
		}
	}
	
}

