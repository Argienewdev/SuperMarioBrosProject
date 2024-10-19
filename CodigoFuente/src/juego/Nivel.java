package juego;

import java.awt.Point;
import java.util.ArrayList;

import elementos.ElementoDeJuego;
import elementos.Silueta;
import elementos.enemigos.Enemigo;
import elementos.entidades.Entidad;
import elementos.personajes.ContextoMario;
import elementos.plataformas.Plataforma;
import elementos.powerUps.PowerUp;
import generadores.GeneradorDeNivel;

public class Nivel {
	
	protected static final int TAMANIO_HITBOX_ENTIDADES = 50;
	
	protected GeneradorDeNivel generadorDeNivel;
	
	private ArrayList<Plataforma> plataformas;
	
	private ArrayList<PowerUp> powerUps;
	
	private ArrayList<Enemigo> enemigos;
	
	protected Silueta silueta;
	
	protected ContextoMario mario;
	
	protected ElementoDeJuego matrizElementosDeJuego[][];
	
	public Nivel(Silueta silueta) {
		this.silueta = silueta;
		inicializarMatriz(silueta);
	}
	
	@SuppressWarnings("exports")
	public void addPlataforma(Plataforma plataforma) {
		plataformas.add(plataforma);
		agregarElementoDeJuegoALaMatriz(plataforma);
	}
	
	@SuppressWarnings("exports")
	public void addEnemigo(Enemigo enemigo) {
		enemigos.add(enemigo);
		agregarElementoDeJuegoALaMatriz(enemigo);
	}
	
	@SuppressWarnings("exports")
	public void addPowerUps(PowerUp powerUp) {
		powerUps.add(powerUp);
		agregarElementoDeJuegoALaMatriz(powerUp);
	}
	
	@SuppressWarnings("exports")
	public void setMario(ContextoMario mario) {
<<<<<<< HEAD
		this.mario=mario;
=======
		this.mario = mario;
>>>>>>> 05d0b3a3d21377cd747608863f04eee1714edc52
		agregarElementoDeJuegoALaMatriz(mario);
	}
	
	@SuppressWarnings("exports")
	public void removePlataforma(Plataforma plataforma) {
		plataformas.remove(plataforma);
		quitarElementoDeJuegoDeLaMatriz(plataforma);

	}
	@SuppressWarnings("exports")
	public void removeEnemigo(Enemigo enemigo) {
		enemigos.remove(enemigo);
		quitarElementoDeJuegoDeLaMatriz(enemigo);
	}
	
	@SuppressWarnings("exports")
	public void removePowerUps(PowerUp powerUp) {
		powerUps.remove(powerUp);
		quitarElementoDeJuegoDeLaMatriz(powerUp);
	}
	
	@SuppressWarnings("exports")
	public Iterable<Plataforma> getPlataformas(){
		return this.plataformas;
	}
	
	@SuppressWarnings("exports")
	public Iterable<PowerUp> getPowerUps(){
		return this.powerUps;
	}
	
	@SuppressWarnings("exports")
	public Iterable<Enemigo> getEnemigo(){
		return this.enemigos;
	}
	
<<<<<<< HEAD
	public void inicializarMatriz() {
		int filas = obtenerFilasMatriz();
		int columnas = obtenerColumnasMatriz();
	}
	
	@SuppressWarnings("exports")
	public ContextoMario setMario() {
=======
	@SuppressWarnings("exports")
	public ContextoMario getMario() {
>>>>>>> 05d0b3a3d21377cd747608863f04eee1714edc52
		return this.mario;
	}
		
	public void inicializarMatriz(Silueta silueta) {
		int filas = silueta.obtenerAlto() / TAMANIO_HITBOX_ENTIDADES;
		int columnas = silueta.obtenerAncho() / TAMANIO_HITBOX_ENTIDADES;
		this.matrizElementosDeJuego = new ElementoDeJuego[filas][columnas];
	}
	
	public void agregarElementoDeJuegoALaMatriz(ElementoDeJuego elementoDeJuego) {
	    int fila = parsearPosicionY(elementoDeJuego);
		int columna = parsearPosicionX(elementoDeJuego);
		establecerElementoDeJuegoEnMatriz(elementoDeJuego, fila, columna);
	}
	
	public void quitarElementoDeJuegoDeLaMatriz(ElementoDeJuego elementoDeJuego) {
		int fila = parsearPosicionY(elementoDeJuego);
		int columna = parsearPosicionX(elementoDeJuego);
		establecerElementoDeJuegoEnMatriz(null, fila, columna);
	}
	
	public int obtenerFilaElementoDeJuegoEnLaMatriz(ElementoDeJuego elementoDeJuego) {
		return parsearPosicionY(elementoDeJuego);
	}
	
	public int obtenerColumnaElementoDeJuegoEnLaMatriz(ElementoDeJuego elementoDeJuego) {
		return parsearPosicionX(elementoDeJuego);
	}
	
	public int obtenerFilasMatriz() {
		return this.silueta.obtenerAlto() / TAMANIO_HITBOX_ENTIDADES;
	}
	
	public int obtenerColumnasMatriz() {
		return this.silueta.obtenerAncho() / TAMANIO_HITBOX_ENTIDADES;
	}
	
	public ElementoDeJuego obtenerElementoDeJuegoEnLaMatriz(int fila, int columna) {
		return this.matrizElementosDeJuego[fila][columna];
	}
	
	private void establecerElementoDeJuegoEnMatriz(ElementoDeJuego elementoDeJuego, int fila, int columna) {
		 this.matrizElementosDeJuego[fila][columna] = elementoDeJuego;
	}
	
	private int parsearPosicionY(ElementoDeJuego elementoDeJuego) {
		return obtenerFilasMatriz() - elementoDeJuego.getPosicion().y;
	}
	
	private int parsearPosicionX(ElementoDeJuego elementoDeJuego) {
		return elementoDeJuego.getPosicion().x;
	}

}
