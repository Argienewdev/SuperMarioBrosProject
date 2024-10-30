
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
	
	private boolean hayNoJugableParaRemover;
			
	private Entidad entidadARemover;
	
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
		boolean esVisibleEnLaPantalla = enemigo.obtenerPosicion().x + enemigo.obtenerAncho() <= (ConstantesGlobales.PANEL_ANCHO + 75)
										&& enemigo.obtenerPosicion().x + enemigo.obtenerAncho() >= -100;
		boolean chocoBordeIzquierdo = enemigo.obtenerPosicion().x <= 0; 
		boolean chocoBordeDerecho = enemigo.obtenerPosicion().x + enemigo.obtenerAncho() >= ConstantesGlobales.PANEL_ANCHO;									
		if (esVisibleEnLaPantalla) {
			if (enemigo.obtenerDebeMantenerseSiempreEnPantalla()) {
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
		if((entidad.obtenerHitbox().x + entidad.obtenerHitbox().width < -100) || entidad.obtenerHitbox().y < 0) {
			entidad.establecerRemovido(true);
		} else {
			for(ElementoDeJuego elemento : this.nivel.getElementosDeJuego()) {
		        if(entidad.huboColision(elemento) && entidad != elemento) {
		            elemento.aceptarVisitante(entidad.obtenerVisitante());
		            entidad.aceptarVisitante(elemento.obtenerVisitante());
		        }
		    }
		}
		entidad.establecerPosicion(entidad.obtenerHitbox().getLocation());
	}
	
	private void actualizarPosicionesEnemigos() {
		for(Enemigo enemigo : this.nivel.getEnemigos()) {
			moverEnemigo(enemigo);
		}
	}
	
	private void actualizarPosicionesPowerUps() {
		for(PowerUp powerUp : this.nivel.getPowerUps()) {
			moverPowerUp(powerUp);
		}
	}
	
	private void actualizarPosicionesBolasDeFuego() {
		for(BolaDeFuego bola : this.nivel.getBolasDeFuego()) {
			moverBolaDeFuego(bola);
		}
	}
	
	private void moverPowerUp(PowerUp powerUp) {
		boolean ticksEnCero = powerUp.getContadorTicks() == 0;
		boolean ticksAlcanzaronMarca = powerUp.getContadorTicks() == powerUp.getTicksHastaSalirDelBloque();
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
		powerUp.establecerPosicion(new Point(powerUp.obtenerPosicion().x, powerUp.getBloquePregunta().obtenerPosicion().y - powerUp.obtenerAlto()));
		powerUp.moverHitbox(powerUp.obtenerPosicion());
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
	
	private void actualizarSpritesBolasDeFuego() {
		for(BolaDeFuego bola : this.nivel.getBolasDeFuego()) {
			bola.actualizarSprite(this.fabricaSprites);
		}
	}
	
	private void actualizarLabelsEnemigos() {
		for(Enemigo enemigo : this.nivel.getEnemigos()) {
			enemigo.obtenerObserverGrafico().actualizar();
		}
	}
	
	private void actualizarLabelsPowerUps() {
		for(PowerUp powerUp : this.nivel.getPowerUps()) {
			powerUp.obtenerObserverGrafico().actualizar();
		}
	}
	
	private void actualizarLabelsPlataformas() {
		for(Plataforma plataforma: this.nivel.getPlataformasAfectables()){
			plataforma.obtenerObserverGrafico().actualizar();
		}
	}
	
	private void actualizarLabelsBolasDeFuego() {
		for(BolaDeFuego bola : this.nivel.getBolasDeFuego()){
			bola.obtenerObserverGrafico().actualizar();
		}
	}
	
}

