package juego;

import java.util.ArrayList;
import java.util.Collection;

import elementos.ElementoDeJuego;
import elementos.Silueta;
import elementos.enemigos.Enemigo;
import elementos.personajes.ContextoMario;
import elementos.plataformas.Plataforma;
import elementos.powerUps.PowerUp;
import generadores.GeneradorDeNivel;

public class Nivel {

    protected GeneradorDeNivel generadorDeNivel;

    private Collection<Plataforma> plataformas;

    private Collection<PowerUp> powerUps;

    private Collection<Enemigo> enemigos;

    protected Silueta silueta;

    protected ContextoMario mario;

    public Nivel(Silueta silueta) {
        this.silueta = silueta;
        this.plataformas = new ArrayList<Plataforma>();
        this.powerUps = new ArrayList<PowerUp>();
        this.enemigos = new ArrayList<Enemigo>();
    }

    @SuppressWarnings("exports")
    public void addPlataforma(Plataforma plataforma) {
        this.plataformas.add(plataforma);
    }

    @SuppressWarnings("exports")
    public void addEnemigo(Enemigo enemigo) {
        this.enemigos.add(enemigo);
    }

    @SuppressWarnings("exports")
    public void addPowerUp(PowerUp powerUp) {
        this.powerUps.add(powerUp);
    }

    @SuppressWarnings("exports")
    public void setMario(ContextoMario mario) {
        this.mario = mario;
    }

    @SuppressWarnings("exports")
    public void removePlataforma(Plataforma plataforma) {
        this.plataformas.remove(plataforma);
    }

    @SuppressWarnings("exports")
    public void removeEnemigo(Enemigo enemigo) {
        this.enemigos.remove(enemigo);
    }

    @SuppressWarnings("exports")
    public void removePowerUp(PowerUp powerUp) {
        this.powerUps.remove(powerUp);
    }

    @SuppressWarnings("exports")
    public Iterable<Plataforma> getPlataformas() {
        return this.plataformas;
    }

    @SuppressWarnings("exports")
    public Iterable<PowerUp> getPowerUps() {
        return this.powerUps;
    }

    @SuppressWarnings("exports")
    public Iterable<Enemigo> getEnemigos() {
        return this.enemigos;
    }
    
    @SuppressWarnings("exports")
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
