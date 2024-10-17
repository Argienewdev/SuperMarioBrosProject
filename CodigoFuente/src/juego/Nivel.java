package juego;

import java.util.ArrayList;

import elementos.*;
import generadores.GeneradorDeNivel;

public class Nivel {
	
	protected GeneradorDeNivel generadorDeNivel;
	private ArrayList<Plataforma> plataformas;
	private ArrayList<PowerUp> powerUps;
	private ArrayList<Enemigo> enemigos;
	protected Silueta silueta;
	
	public Nivel(Silueta silueta) {
		this.silueta=silueta;
	}
	
	public void addPlataforma(Plataforma plataforma) {
		plataformas.add(plataforma);
	}
	
	public void addEnemigo(Enemigo enemigo) {
		enemigos.add(enemigo);
	}
	
	public void addPowerUps(PowerUp powerUp) {
		powerUps.add(powerUp);
	}
	
	public void removePlataforma(Plataforma plataforma) {
		plataformas.remove(plataforma);

	}
	public void removeEnemigo(Enemigo enemigo) {
		enemigos.remove(enemigo);
	}
	
	public void removePowerUps(PowerUp powerUp) {
		powerUps.remove(powerUp);
	}
	
	public Iterable<Plataforma> getPlataformas(){
		return plataformas;
	}
	
	public Iterable<PowerUp> getPowerUps(){
		return powerUps;
	}
	
	public Iterable<Enemigo> getEnemigo(){
		return enemigos;
	}

}
