package juego;

import java.util.ArrayList;
import java.util.Collection;

import elementos.ElementoDeJuego;
import elementos.Silueta;
import elementos.enemigos.Enemigo;
import elementos.entidades.NoJugable;
import elementos.personajes.ContextoMario;
import elementos.plataformas.Plataforma;
import elementos.powerUps.PowerUp;
import generadores.GeneradorDeNivel;

public class Nivel {

    protected GeneradorDeNivel generadorDeNivel;

    private Collection<Plataforma> plataformas;

    private Collection<PowerUp> powerUps;

    private Collection<Enemigo> enemigos;
    
    private Collection<NoJugable> entidadesAEliminar;
    
    private Collection<Plataforma> plataformasAfectables;

    protected Silueta silueta;

    protected ContextoMario mario;

    public Nivel(Silueta silueta) {
        this.silueta = silueta;
        this.plataformas = new ArrayList<Plataforma>();
        this.plataformasAfectables = new ArrayList<Plataforma>();
        this.powerUps = new ArrayList<PowerUp>();
        this.enemigos = new ArrayList<Enemigo>();
        this.entidadesAEliminar = new ArrayList<NoJugable>();
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
    
	public void addEntidadesAEliminar(NoJugable entidad) {
        this.entidadesAEliminar.add(entidad);
    }

    public void setMario(ContextoMario mario) {
        this.mario = mario;
    }

    public void removePlataforma(Plataforma plataforma) {
        this.plataformas.remove(plataforma);
    }

    public void removerEntidadesAEliminar() {
    	enemigos.removeAll(entidadesAEliminar);
    	powerUps.removeAll(entidadesAEliminar);
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
    
    public ContextoMario getMario() {
        return this.mario;
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
        return elementosDeJuego;
    }

}
