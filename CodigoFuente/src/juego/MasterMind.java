package juego;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import elementos.ElementoDeJuego;
import elementos.enemigos.Enemigo;
import elementos.entidades.BolaDeFuego;
import elementos.entidades.Entidad;
import elementos.plataformas.Plataforma;
import elementos.powerUps.PowerUp;
import fabricas.FabricaSprites;
import ventanas.ConstantesGlobales;

public class MasterMind {
	
	protected FabricaSprites fabricaSprites;
	
	protected Nivel nivel;
	
	protected boolean movimientoEnemigosActivo;
	
	public MasterMind(FabricaSprites fabricaSprites, Nivel nivel) {
		this.fabricaSprites = fabricaSprites;
		this.nivel = nivel;
		movimientoEnemigosActivo=false;
	}

	public void actualizar() {
		actualizarEnemigos();
		actualizarPowerUps();
		actualizarBolasDeFuego();
		actualizarPlataformas();
	}
	
	public void cambiarNivel(Nivel nivel) {
		this.nivel = nivel;
	}
	
	private void actualizarPlataformas() {
		for(Plataforma plataforma: this.nivel.obtenerPlataformasAfectables()){
			plataforma.actualizarSprite(this.fabricaSprites);
			plataforma.obtenerObserverGrafico().actualizar();
		}
	}

	private void actualizarEnemigos() {
		for(Enemigo enemigo : this.nivel.obtenerEnemigos()) {
			moverEnemigo(enemigo);
			enemigo.actualizarSprite(this.fabricaSprites);
			enemigo.obtenerObserverGrafico().actualizar();
		}
	}
	
	private void actualizarPowerUps() {
		for(PowerUp powerUp : this.nivel.obtenerPowerUps()) {
			moverPowerUp(powerUp);
			powerUp.actualizarSprite(this.fabricaSprites);
			powerUp.obtenerObserverGrafico().actualizar();
		}
	}
	
	private void actualizarBolasDeFuego() {
		for(BolaDeFuego bola : this.nivel.obtenerBolasDeFuego()) {
			moverBolaDeFuego(bola);
			bola.actualizarSprite(this.fabricaSprites);
			bola.obtenerObserverGrafico().actualizar();
		}
	}
	
	private void moverEnemigo(Enemigo enemigo) {
		
		boolean chocoBordeIzquierdo = enemigo.obtenerPosicionGrafica().x <=  0; 
		boolean chocoBordeDerecho = enemigo.obtenerPosicionGrafica().x + enemigo.obtenerAncho() >=  ConstantesGlobales.PANEL_ANCHO;									
		if (enemigo.obtenerVisibleEnPantalla()){
			if(!this.nivel.estaEntidadVisible(enemigo)) {
				this.nivel.agregarEntidadVisible(enemigo);
			}
			if (this.movimientoEnemigosActivo) {
				
				if (enemigo.obtenerDebeMantenerseSiempreEnPantalla()) {
					if (chocoBordeIzquierdo) {
						int desplazamientoHaciaFueraDeLaPantalla = Math.abs(enemigo.obtenerPosicionGrafica().x);
						Point nuevaPosicionGrafica = new Point(enemigo.obtenerPosicionGrafica().x + desplazamientoHaciaFueraDeLaPantalla, enemigo.obtenerPosicionGrafica().y);
						enemigo.establecerPosicionGrafica(nuevaPosicionGrafica);
						Point nuevaPosicionLogica = new Point(enemigo.obtenerPosicionLogica().x + desplazamientoHaciaFueraDeLaPantalla, enemigo.obtenerPosicionLogica().y);
						enemigo.establecerPosicionLogica(nuevaPosicionLogica);
						enemigo.moverHitbox(nuevaPosicionLogica);
						enemigo.invertirDireccion();
					} else if (chocoBordeDerecho) {
						int desplazamientoHaciaFueraDeLaPantalla = enemigo.obtenerPosicionGrafica().x + enemigo.obtenerAncho() - ConstantesGlobales.PANEL_ANCHO;
						Point nuevaPosicionGrafica = new Point(enemigo.obtenerPosicionGrafica().x - desplazamientoHaciaFueraDeLaPantalla, enemigo.obtenerPosicionGrafica().y);
						Point nuevaPosicionLogica = new Point(enemigo.obtenerPosicionLogica().x - desplazamientoHaciaFueraDeLaPantalla, enemigo.obtenerPosicionLogica().y);
						enemigo.establecerPosicionLogica(nuevaPosicionLogica);
						enemigo.establecerPosicionGrafica(nuevaPosicionGrafica);
						enemigo.moverHitbox(nuevaPosicionLogica);
						enemigo.invertirDireccion();
					}
				}
				enemigo.mover();
				enemigo.aplicarGravedad();
			} else{
				enemigo.establecerVelocidadDireccional(new Point(0,0));
			}
		} else {
			this.nivel.removerEntidadVisible(enemigo);
		}
		cambiarYVerificarPosicionHitboxDeEntidad(enemigo);
	}
	
	private void moverPowerUp(PowerUp powerUp) {
		if(powerUp.obtenerVisibleEnPantalla()) {
			if(!this.nivel.estaEntidadVisible(powerUp)) {
				this.nivel.agregarEntidadVisible(powerUp);
			}
			boolean ticksEnCero = powerUp.obtenerContadorTicks() ==  0;
			boolean ticksAlcanzaronMarca = powerUp.obtenerContadorTicks() ==  powerUp.obtenerTicksHastaSalirDelBloque();
			if (!powerUp.estaDentroDeBloqueDePreguntas() && ticksEnCero) {
				sacarPowerUpDeBloqueDePreguntas(powerUp);
				powerUp.incrementarContadorTicks();
			} else if (!powerUp.estaDentroDeBloqueDePreguntas() && ticksAlcanzaronMarca && powerUp.esMovible()) {
				if (powerUp.obtenerVelocidadDireccional().x ==  0) {
					powerUp.mover();
				}
				powerUp.aplicarGravedad();
				cambiarYVerificarPosicionHitboxDeEntidad(powerUp);
			} else if (!ticksEnCero && !ticksAlcanzaronMarca) {
				powerUp.incrementarContadorTicks();
			}
		}else {
			this.nivel.removerEntidadVisible(powerUp);
		}
	}
	
	private void moverBolaDeFuego(BolaDeFuego bolaFuego) {
		if(bolaFuego.obtenerVisibleEnPantalla()) {
			if(!this.nivel.estaEntidadVisible(bolaFuego)) {
				this.nivel.agregarEntidadVisible(bolaFuego);
			}
			bolaFuego.aplicarGravedad();
			this.cambiarYVerificarPosicionHitboxDeEntidad(bolaFuego);
		}else {
			this.nivel.removerEntidadVisible(bolaFuego);
		}
	}
	
	private void cambiarYVerificarPosicionHitboxDeEntidad(Entidad entidad) {
		cambiarPosicionXHitboxDeEntidad(entidad);
		verificarColisiones(entidad);
		cambiarPosicionYHitboxDeEntidad(entidad);
		verificarColisiones(entidad);
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
	
	private void verificarColisiones(Entidad entidad) {
		verificarColisionConPlataformas(entidad);
		verificarColisionesConEntidades(entidad);
	}
	
	private void verificarColisionesConEntidades(Entidad entidad) {
		if ((entidad.obtenerPosicionGrafica().x + entidad.obtenerAncho() < -50) && !entidad.obtenerDebeMantenerseSiempreEnPantalla()) {
			entidad.establecerRemovido(true);
		} else {
			for(ElementoDeJuego elemento : this.nivel.obtenerEntidadesVisiblesEnPantalla()) {
		        if (entidad.huboColision(elemento) && entidad !=  elemento) {
		            elemento.aceptarVisitante(entidad.obtenerVisitante());
		            entidad.aceptarVisitante(elemento.obtenerVisitante());
		        }
		    }
		}
		entidad.establecerPosicion(entidad.obtenerHitbox().getLocation());
	}
	
	private void verificarColisionConPlataformas(Entidad entidad) {
	    
		for (Plataforma plataforma : nivel.obtenerPlataformasAdyacentes(entidad)) {
	        if (plataforma != null && entidad.huboColision(plataforma)) {
	        	plataforma.aceptarVisitante(entidad.obtenerVisitante());
	            entidad.aceptarVisitante(plataforma.obtenerVisitante());
	        }
	    }
	    
	}
	
	private void sacarPowerUpDeBloqueDePreguntas(PowerUp powerUp) {
		powerUp.establecerPosicion(new Point(powerUp.obtenerPosicionLogica().x, powerUp.obtenerBloquePregunta().obtenerPosicionLogica().y - powerUp.obtenerAlto()));
		powerUp.moverHitbox(powerUp.obtenerPosicionLogica());
		powerUp.actualizarSprite(this.fabricaSprites);
	}

	public void desactivarMovimientoEnemigos() {
		this.movimientoEnemigosActivo = false;
	}

	public void activarMovimientoEnemigos() {
		this.movimientoEnemigosActivo = true;
	}
	
}

