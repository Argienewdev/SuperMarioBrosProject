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
        this.plataformas = new ArrayList<Plataforma>();
        this.powerUps = new ArrayList<PowerUp>();
        this.enemigos = new ArrayList<Enemigo>();
        inicializarMatriz(silueta);
    }

    @SuppressWarnings("exports")
    public void addPlataforma(Plataforma plataforma) {
        this.plataformas.add(plataforma);
        agregarElementoDeJuegoALaMatriz(plataforma);
    }

    @SuppressWarnings("exports")
    public void addEnemigo(Enemigo enemigo) {
        this.enemigos.add(enemigo);
        agregarElementoDeJuegoALaMatriz(enemigo);
    }

    @SuppressWarnings("exports")
    public void addPowerUp(PowerUp powerUp) {
        this.powerUps.add(powerUp);
        agregarElementoDeJuegoALaMatriz(powerUp);
    }

    @SuppressWarnings("exports")
    public void setMario(ContextoMario mario) {
        this.mario = mario;
        agregarElementoDeJuegoALaMatriz(mario);
    }

    @SuppressWarnings("exports")
    public void removePlataforma(Plataforma plataforma) {
        this.plataformas.remove(plataforma);
        eliminarElementoDeJuegoDeLaMatriz(plataforma);
    }

    @SuppressWarnings("exports")
    public void removeEnemigo(Enemigo enemigo) {
        this.enemigos.remove(enemigo);
        eliminarElementoDeJuegoDeLaMatriz(enemigo);
    }

    @SuppressWarnings("exports")
    public void removePowerUps(PowerUp powerUp) {
        this.powerUps.remove(powerUp);
        eliminarElementoDeJuegoDeLaMatriz(powerUp);
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

    public void inicializarMatriz(Silueta silueta) {
        System.out.println(silueta.obtenerAlto());
        System.out.println(silueta.obtenerAncho());
        int filas = (int) Math.ceil((double) this.silueta.obtenerAlto() / TAMANIO_HITBOX_ENTIDADES);
        int columnas = (int) Math.ceil((double) this.silueta.obtenerAncho() / TAMANIO_HITBOX_ENTIDADES);
        this.matrizElementosDeJuego = new ElementoDeJuego[filas][columnas];
    }

    public void agregarElementoDeJuegoALaMatriz(ElementoDeJuego elementoDeJuego) {
        int fila = parsearPosicionY(elementoDeJuego);
        int columna = parsearPosicionX(elementoDeJuego);
        if (esPosicionValida(fila, columna)) {
            establecerElementoDeJuegoEnMatriz(elementoDeJuego, fila, columna);
        }
    }

    public void eliminarElementoDeJuegoDeLaMatriz(ElementoDeJuego elementoDeJuego) {
        int fila = parsearPosicionY(elementoDeJuego);
        int columna = parsearPosicionX(elementoDeJuego);
        if (esPosicionValida(fila, columna)) {
            establecerElementoDeJuegoEnMatriz(null, fila, columna);
        }
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
        if (esPosicionValida(fila, columna)) {
            return this.matrizElementosDeJuego[fila][columna];
        }
        return null; // o lanzar una excepción
    }

    private void establecerElementoDeJuegoEnMatriz(ElementoDeJuego elementoDeJuego, int fila, int columna) {
        this.matrizElementosDeJuego[fila][columna] = elementoDeJuego;
    }

    private int parsearPosicionY(ElementoDeJuego elementoDeJuego) {
        return obtenerFilasMatriz() - elementoDeJuego.getPosicion().y - 1;
    }

    private int parsearPosicionX(ElementoDeJuego elementoDeJuego) {
        return elementoDeJuego.getPosicion().x;
    }

    private boolean esPosicionValida(int fila, int columna) {
        return fila >= 0 && fila < obtenerFilasMatriz() && columna >= 0 && columna < obtenerColumnasMatriz();
    }
}
