package juego;

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
	
	protected static final int TAMANIO_HEATBOX_ENTIDADES = 50;
	
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
		this.mario=mario;
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
	
	@SuppressWarnings("exports")
	public ContextoMario setMario() {
		return this.mario;
	}
		
	public void inicializarMatriz(Silueta silueta) {
		int filas = silueta.obtenerAlto() / TAMANIO_HEATBOX_ENTIDADES;
		int columnas = silueta.obtenerAncho() / TAMANIO_HEATBOX_ENTIDADES;
		this.matrizElementosDeJuego = new ElementoDeJuego[filas][columnas];
	}
	
	public void agregarElementoDeJuegoALaMatriz(ElementoDeJuego elementoDeJuego) {
		elementoDeJuego.getPosicion();
	}
	
	public void quitarElementoDeJuegoDeLaMatriz(ElementoDeJuego elementoDeJuego) {
		//
	}

}
