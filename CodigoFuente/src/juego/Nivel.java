package juego;

import java.util.ArrayList;
import java.util.Collection;

import elementos.ElementoDeJuego;
import elementos.Silueta;
import elementos.enemigos.Enemigo;
import elementos.entidades.BolaDeFuego;
import elementos.personajes.ContextoMario;
import elementos.plataformas.Plataforma;
import elementos.powerUps.PowerUp;
import generadores.GeneradorDeNivel;

public class Nivel {
	
	protected static final int ANCHO_ALTO_BLOQUES_PLATAFORMA = 50;

    protected GeneradorDeNivel generadorDeNivel;

    protected Collection<Plataforma> plataformas;

    protected Collection<PowerUp> powerUps;

    protected Collection<Enemigo> enemigos;
    
    protected Collection<BolaDeFuego> bolasDeFuego;
    
    protected Collection<ElementoDeJuego> entidadesAEliminar;
    
    protected Collection<Plataforma> plataformasAfectables;
    
    protected Silueta silueta;

    protected ContextoMario mario;
    
    protected boolean nivelCompletado;
    
    protected Partida partida;

    public Nivel(Silueta silueta, Partida partida) {
        this.silueta = silueta;
        this.plataformas = new ArrayList<Plataforma>();
        this.plataformasAfectables = new ArrayList<Plataforma>();
        this.powerUps = new ArrayList<PowerUp>();
        this.enemigos = new ArrayList<Enemigo>();
        this.bolasDeFuego=new ArrayList<BolaDeFuego>();
        this.entidadesAEliminar = new ArrayList<ElementoDeJuego>();
        this.nivelCompletado = false;
        this.partida = partida;
        this.mario = null;
        this.generadorDeNivel = null;
    }
    
    public void addPlataforma(Plataforma plataforma) {
        this.plataformas.add(plataforma);
        plataforma.setNivel(this);
    }

    public void addEnemigo(Enemigo enemigo) {
        this.enemigos.add(enemigo);
        enemigo.setNivel(this);
    }

    public void addPowerUp(PowerUp powerUp) {
        this.powerUps.add(powerUp);
        powerUp.setNivel(this);
    }
    
    public void addBolaDeFuego(BolaDeFuego bolaDefuego) {
        this.bolasDeFuego.add(bolaDefuego);
        bolaDefuego.setNivel(this);
    }
    
	public void addEntidadesAEliminar(ElementoDeJuego entidad) {
        this.entidadesAEliminar.add(entidad);
    }
	
	public void addPlataformasAfectables(Plataforma plataforma) {
        this.plataformasAfectables.add(plataforma);
    }
	
	public Iterable<Plataforma> getPlataformasAfectables() {
        return plataformasAfectables;
    }

    public void setMario(ContextoMario mario) {
        this.mario = mario;
        this.mario.setNivel(this);
    }

    public void removePlataforma(Plataforma plataforma) {
        this.plataformas.remove(plataforma);
    }

    public void removerEntidadesAEliminar() {
    	enemigos.removeAll(entidadesAEliminar);
    	powerUps.removeAll(entidadesAEliminar);
    	plataformas.removeAll(entidadesAEliminar);
    	plataformasAfectables.removeAll(entidadesAEliminar);
    	entidadesAEliminar = new ArrayList<ElementoDeJuego>();
    }
    
    public Iterable<Plataforma> getPlataformas() {
        return this.plataformas;
    }

    public Iterable<PowerUp> getPowerUps() {
        return this.powerUps;
    }

    public Iterable<Enemigo> getEnemigos() {
        return this.enemigos;
    }
    
    public Iterable<BolaDeFuego> getBolasDeFuego() {
        return this.bolasDeFuego;
    }
    
    public ContextoMario getMario() {
        return this.mario;
    }
    
    public boolean fueCompletado() {
    	return this.nivelCompletado;
    }
    
    public void reiniciarNivel() {
    	this.partida.reiniciarNivel();
    }
    
    public void setCompletado(boolean completado) {
    	this.nivelCompletado = completado;
    }
    
    public Partida obtenerPartida() {
    	return this.partida;
    }
    
    public Iterable<ElementoDeJuego> getElementosDeJuego() {
        ArrayList<ElementoDeJuego> elementosDeJuego = new ArrayList<ElementoDeJuego>();
        for(Plataforma plataforma : getPlataformas()) {
            elementosDeJuego.add(plataforma);
        }
        for(PowerUp powerup : getPowerUps()) {
            elementosDeJuego.add(powerup);
        }
        for(Enemigo enemigo : getEnemigos()) {
            elementosDeJuego.add(enemigo);
        }
        for(BolaDeFuego bolaDeFuego: getBolasDeFuego() ){
            elementosDeJuego.add(bolaDeFuego);
        }
        return elementosDeJuego;
    }

}
