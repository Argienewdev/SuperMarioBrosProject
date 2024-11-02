package juego;

import java.awt.Point;
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
    
    protected Mapa mapa;
    
    protected Collection<PowerUp> powerUps;
    
    protected Collection<Enemigo> enemigos;
    
    protected Collection<BolaDeFuego> bolasDeFuego;
    
    protected Collection<BolaDeFuego> bolasDeFuegoAAgregar;
    
    protected Collection<ElementoDeJuego> entidadesAEliminar;
    
    protected Collection<Enemigo> spinysAAgregar;
    
    protected Silueta silueta;
    
    protected ContextoMario mario;
    
    protected boolean nivelCompletado;
    
    protected Partida partida;

    public Nivel(Silueta silueta, Partida partida) {
        this.silueta = silueta;
        this.mapa = new Mapa(silueta.obtenerAncho(), silueta.obtenerAlto());
        inicializarColecciones();
        this.nivelCompletado = false;
        this.partida = partida;
        this.mario = null;
        this.generadorDeNivel = null;
    }
    
    private void inicializarColecciones() {
        this.powerUps = new ArrayList<>();
        this.enemigos = new ArrayList<>();
        this.bolasDeFuego = new ArrayList<>();
        this.bolasDeFuegoAAgregar = new ArrayList<>();
        this.entidadesAEliminar = new ArrayList<>();
        this.spinysAAgregar = new ArrayList<>();
    }

    public void agregarPlataforma(Plataforma plataforma) {
        mapa.agregarPlataforma(plataforma);
        plataforma.establecerNivel(this);
    }

    public void removerPlataforma(Plataforma plataforma) {
        mapa.removerPlataforma(plataforma);
    }

    public void agregarPlataformasAfectables(Plataforma plataforma) {
        mapa.agregarPlataformaAfectable(plataforma);
    }

    public Iterable<Plataforma> obtenerPlataformasAfectables() {
        return mapa.obtenerPlataformasAfectables();
    }

    public Iterable<Plataforma> obtenerPlataformas() {
        return mapa.obtenerTodasLasPlataformas();
    }

    public Plataforma obtenerPlataformaEnPunto(Point punto) {
        return mapa.obtenerPlataformaEnPunto(punto);
    }

    public void agregarEnemigo(Enemigo enemigo) {
        this.enemigos.add(enemigo);
        enemigo.establecerNivel(this);
    }

    public void agregarSpinyAAgregar(Enemigo spiny) {
        this.spinysAAgregar.add(spiny);
    }


    public void agregarPowerUp(PowerUp powerUp) {
        this.powerUps.add(powerUp);
        powerUp.establecerNivel(this);
    }
	
	
	public void agregarPlataformasAfectables(Plataforma plataforma) {
        this.plataformasAfectables.add(plataforma);
    }
	

    public void agregarBolaDeFuegoAAgregar(BolaDeFuego bolaDeFuego) {
        this.bolasDeFuegoAAgregar.add(bolaDeFuego);
    }

    public void agregarBolaDeFuegoAAgregar() {
        for(BolaDeFuego bolaDeFuego : bolasDeFuegoAAgregar) {
            bolaDeFuego.establecerNivel(this);
        }
        bolasDeFuego.addAll(bolasDeFuegoAAgregar);
        bolasDeFuegoAAgregar = new ArrayList<>();
    }

    public void agregarEntidadesAEliminar(ElementoDeJuego entidad) {
        this.entidadesAEliminar.add(entidad);
    }

    public void removerEntidadesAEliminar() {
        enemigos.removeAll(entidadesAEliminar);
        powerUps.removeAll(entidadesAEliminar);
        mapa.limpiarMapa();
        mapa.obtenerPlataformasAfectables().removeAll(entidadesAEliminar);
        bolasDeFuego.removeAll(entidadesAEliminar);
        entidadesAEliminar = new ArrayList<>();
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
}