
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
import ventanas.DimensionesConstantes;

public class MasterMind {
	
	protected FabricaSprites fabricaSprites;
	
	protected Nivel nivel;
	
	private static final int GRAVEDAD = 3;
	
	private static final int VELOCIDAD_MAXIMA_DE_CAIDA = 15;
	
	private boolean hayNoJugableParaRemover;
			
	private Entidad entidadARemover;
	
	public MasterMind(FabricaSprites fabricaSprites, Nivel nivel) {
		this.fabricaSprites = fabricaSprites;
		this.nivel = nivel;
		this.hayNoJugableParaRemover = false;
		this.entidadARemover = null;
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
		if(hayNoJugableParaRemover) {
			entidadARemover.incrementarContadorTicks();
			if(entidadARemover.getContadorTicks() > entidadARemover.obtenerTicksAnimacion()) {
				entidadARemover.eliminarDelNivel();
				entidadARemover = null;
				hayNoJugableParaRemover = false;
			}
		}
	}
	
	public void cambiarNivel(Nivel nivel) {
		this.nivel = nivel;
	}
	
	private void moverEnemigo(Enemigo enemigo) {
		if(enemigo.getPosicion().x < (DimensionesConstantes.PANEL_ANCHO + 100) && enemigo.getVelocidadDireccional().x == 0) {
			enemigo.moverIzquierda();
		}
		aplicarGravedad(enemigo);
		cambiarYVerificarPosicionHitboxDeEntidad(enemigo);
	}
	private void cambiarYVerificarPosicionHitboxDeEntidad(Entidad entidad) {
		cambiarPosicionXHitboxDeEntidad(entidad);
		verificarColisionesEntidades(entidad);
		cambiarPosicionYHitboxDeEntidad(entidad);
		verificarColisionesEntidades(entidad);
	}
	
	private void cambiarPosicionXHitboxDeEntidad(Entidad entidad) {
		int nuevaPosicionX = entidad.obtenerHitbox().x + entidad.getVelocidadDireccional().x;
		Point nuevaPosicion = new Point(nuevaPosicionX, entidad.obtenerHitbox().y);
		entidad.moverHitbox(nuevaPosicion);
	}
	
	private void cambiarPosicionYHitboxDeEntidad(Entidad entidad) {
		int nuevaPosicionY = entidad.obtenerHitbox().y + entidad.getVelocidadDireccional().y;
		Point nuevaPosicion = new Point(entidad.obtenerHitbox().x, nuevaPosicionY);
		entidad.moverHitbox(nuevaPosicion);
	}
	
	private void verificarColisionesEntidades(Entidad entidad) {
		if((entidad.obtenerHitbox().x + entidad.obtenerHitbox().width < 0) || entidad.obtenerHitbox().y < 0) {
			entidad.eliminarDelNivel();
		} else {
			for(ElementoDeJuego elemento : this.nivel.getElementosDeJuego()) {
		        if(entidad.huboColision(elemento) && entidad != elemento) {
		            elemento.aceptarVisitante(entidad.getVisitor());
		            entidad.aceptarVisitante(elemento.getVisitor());
		        }
		    }
			if(entidad.getRemovido()) {
				hayNoJugableParaRemover = true;
				entidadARemover = entidad;
			}
		}
		entidad.setPosicion(entidad.obtenerHitbox().getLocation());
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
			if(powerUp.getVelocidadDireccional().x == 0) {
				powerUp.moverDerecha();
			}
			aplicarGravedad(powerUp);
			cambiarYVerificarPosicionHitboxDeEntidad(powerUp);
		} else if(!ticksEnCero && !ticksAlcanzaronMarca) {
			powerUp.incrementarContadorTicks();
		}
	}
	
	private void moverBolaDeFuego(BolaDeFuego bolaFuego) {
		aplicarGravedad(bolaFuego);
		cambiarYVerificarPosicionHitboxDeEntidad(bolaFuego);
	}
	
	private void sacarPowerUpDeBloqueDePreguntas(PowerUp powerUp) {
		powerUp.setPosicion(new Point(powerUp.getPosicion().x, powerUp.getBloquePregunta().getPosicion().y - powerUp.obtenerAlto()));
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
	
	private void actualizarSpritesBolasDeFuego() {
		for(BolaDeFuego bola : this.nivel.getBolasDeFuego()) {
			bola.actualizarSprite(this.fabricaSprites);
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
	
	private void actualizarLabelsBolasDeFuego() {
		for(BolaDeFuego bola : this.nivel.getBolasDeFuego()){
			bola.getObserverGrafico().actualizar();
		}
	}
	
	private void aplicarGravedad(NoJugable noJugable) {
		if(noJugable.getVelocidadDireccional().y < VELOCIDAD_MAXIMA_DE_CAIDA){
			noJugable.setVelocidadDireccional(new Point(noJugable.getVelocidadDireccional().x, noJugable.getVelocidadDireccional().y + GRAVEDAD));
		}
	}
	
}

