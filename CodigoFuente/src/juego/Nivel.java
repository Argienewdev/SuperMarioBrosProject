package juego;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import elementos.ElementoDeJuego;
import elementos.Silueta;
import elementos.enemigos.Enemigo;
import elementos.enemigos.Spiny;
import elementos.entidades.BolaDeFuego;
import elementos.entidades.Entidad;
import elementos.personajes.ContextoMario;
import elementos.plataformas.Plataforma;
import elementos.powerUps.PowerUp;
import generadores.GeneradorDeNivel;

public class Nivel {
    protected static final int ANCHO_ALTO_BLOQUES_PLATAFORMA = 50;

    protected GeneradorDeNivel generadorDeNivel;
    
    protected MatrizPlataforma matrizPlataformas;
    
    protected List<PowerUp> powerUps;
    
    protected List<Enemigo> enemigos;
    
    protected List<BolaDeFuego> bolasDeFuego;
    
    protected List<Plataforma> plataformasAfectables;
    
    protected Silueta silueta;
    
    protected ContextoMario mario;
    
    protected boolean nivelCompletado;
    
    protected Partida partida;

    public Nivel(Silueta silueta, Partida partida) {
        this.silueta = silueta;
        this.matrizPlataformas = new MatrizPlataforma(silueta.obtenerAncho(), silueta.obtenerAlto());
        inicializarColecciones();
        this.nivelCompletado = false;
        this.partida = partida;
        this.mario = null;
        this.generadorDeNivel = null;
    }
    
    private void inicializarColecciones() {
        this.powerUps = new CopyOnWriteArrayList<PowerUp>();
        this.enemigos = new CopyOnWriteArrayList<Enemigo>();
        this.bolasDeFuego = new CopyOnWriteArrayList<BolaDeFuego>();
        this.plataformasAfectables = new CopyOnWriteArrayList<Plataforma>();
    }

    public void agregarPlataforma(Plataforma plataforma) {
        matrizPlataformas.agregarPlataforma(plataforma);
        plataforma.establecerNivel(this);
    }

    public void removerPlataforma(Plataforma plataforma) {
        matrizPlataformas.removerPlataforma(plataforma);
    }
    

    public Iterable<Plataforma> obtenerPlataformasAfectables() {
        return this.plataformasAfectables;
    }

    public Iterable<Plataforma> obtenerPlataformas() {
        return this.matrizPlataformas.obtenerTodasLasPlataformas();
    }

    public void agregarEnemigo(Enemigo enemigo) {
        this.enemigos.add(enemigo);
        enemigo.establecerNivel(this);
    }

    public void agregarPowerUp(PowerUp powerUp) {
        this.powerUps.add(powerUp);
        powerUp.establecerNivel(this);
    }
	
	public void agregarPlataformaAfectable(Plataforma plataforma) {
        this.plataformasAfectables.add(plataforma);
    }

    public void agregarBolaDeFuego(BolaDeFuego bolaDeFuego) {
        this.bolasDeFuego.add(bolaDeFuego);
    }

    public Iterable<ElementoDeJuego> obtenerElementosDeJuego() {
        ArrayList<ElementoDeJuego> elementosDeJuego = new ArrayList<>();
        for(Plataforma plataforma : obtenerPlataformas()) {
            elementosDeJuego.add(plataforma);
        }
        for(PowerUp powerup : obtenerPowerUps()) {
            elementosDeJuego.add(powerup);
        }
        for(Enemigo enemigo : obtenerEnemigos()) {
            elementosDeJuego.add(enemigo);
        }
        for(BolaDeFuego bolaDeFuego: obtenerBolasDeFuego()) {
            elementosDeJuego.add(bolaDeFuego);
        }
        return elementosDeJuego;
    }

    public void establecerMario(ContextoMario mario) {
        this.mario = mario;
        this.mario.establecerNivel(this);
    }

    public ContextoMario obtenerMario() {
        return this.mario;
    }

    public Iterable<PowerUp> obtenerPowerUps() {
        return this.powerUps;
    }

    public Iterable<Enemigo> obtenerEnemigos() {
        return this.enemigos;
    }

    public Iterable<BolaDeFuego> obtenerBolasDeFuego() {
        return this.bolasDeFuego;
    }

    public boolean fueCompletado() {
        return this.nivelCompletado;
    }

    public void establecerCompletado(boolean completado) {
        this.nivelCompletado = completado;
    }

    public Partida obtenerPartida() {
        return this.partida;
    }

    public int obtenerNumeroNivel() {
        return partida.obtenerNumeroDeNivelActual();
    }

    public Iterable<Plataforma> obtenerPlataformasAdyacentes(Entidad entidad){
    	return this.matrizPlataformas.obtenerAdyacentes( entidad);
    }

	public Iterable<Entidad> obtenerEntidades() {
		ArrayList<Entidad> entidadesDeJuego = new ArrayList<Entidad>();

        for(PowerUp powerup : obtenerPowerUps()) {
        	entidadesDeJuego.add(powerup);
        }
        for(Enemigo enemigo : obtenerEnemigos()) {
        	entidadesDeJuego.add(enemigo);
        }
        for(BolaDeFuego bolaDeFuego: obtenerBolasDeFuego()) {
        	entidadesDeJuego.add(bolaDeFuego);
        }
        
        return entidadesDeJuego;
	}
	
	public void removerEnemigo(Enemigo enemigo) {
		this.enemigos.remove(enemigo);
	}
	
	public void removerPowerUp(PowerUp powerUp) {
		this.powerUps.remove(powerUp);
	}
	
	public void removerBolaDeFuego(BolaDeFuego bolaDeFuego) {
		this.bolasDeFuego.remove(bolaDeFuego);
	}
	
	public void removerPlataformaAfectable(Plataforma plataforma) {
		this.plataformasAfectables.remove(plataforma);
	}
	
}