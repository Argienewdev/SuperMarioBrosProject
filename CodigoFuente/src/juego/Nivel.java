package juego;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import elementos.Silueta;
import elementos.enemigos.Enemigo;
import elementos.entidades.BolaDeFuego;
import elementos.entidades.Entidad;
import elementos.entidades.Jugable;
import elementos.personajes.ContextoMario;
import elementos.plataformas.Plataforma;
import elementos.powerUps.PowerUp;
import generadores.GeneradorDeNivel;

public class Nivel {
    protected static final int ANCHO_ALTO_BLOQUES_PLATAFORMA = 50;
    
    protected MatrizPlataforma matrizPlataformas;
    
    protected List<PowerUp> powerUps;
    
    protected List<Enemigo> enemigos;
    
    protected List<BolaDeFuego> bolasDeFuego;
    
    protected List<Plataforma> plataformasAfectables;
   
    protected List<Entidad> entidadesVisiblesEnPantalla;
       
    protected Silueta silueta;
    
    protected Jugable mario;
    
    protected boolean nivelCompletado;
    
    protected Partida partida;
    
    protected boolean princesaAccionada;
    
    protected boolean banderaAccionada;

    public Nivel(Silueta silueta, Partida partida) {
        this.silueta = silueta;
        this.matrizPlataformas = new MatrizPlataforma(silueta.obtenerAncho(), silueta.obtenerAlto());
        this.inicializarColecciones();
        this.nivelCompletado = false;
        this.partida = partida;
        this.mario = null;
        this.banderaAccionada = false;
        this.princesaAccionada = false;
    }
    
    private void inicializarColecciones() {
        this.powerUps = new CopyOnWriteArrayList<>();
        this.enemigos = new CopyOnWriteArrayList<>();
        this.bolasDeFuego = new CopyOnWriteArrayList<>();
        this.plataformasAfectables = new CopyOnWriteArrayList<>();
        this.entidadesVisiblesEnPantalla = new CopyOnWriteArrayList<>();
    }

    public boolean obtenerBanderaAccionada() {
    	return this.banderaAccionada;
    }
    
    public void accionarBandera() {
    	this.banderaAccionada = true;
    }
    
    public boolean obtenerPrincesaAccionada() {
    	return this.banderaAccionada;
    }
    
    public void accionarPrincesa(){
    	this.princesaAccionada = true;
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

    public void establecerMario(Jugable mario) {
        this.mario = mario;
        this.mario.establecerNivel(this);
    }

    public Jugable obtenerMario() {
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
	
	public void removerEnemigo(Enemigo enemigo) {
		this.enemigos.remove(enemigo);
		this.entidadesVisiblesEnPantalla.remove(enemigo);
	}
	
	public void removerPowerUp(PowerUp powerUp) {
		this.powerUps.remove(powerUp);
		this.entidadesVisiblesEnPantalla.remove(powerUp);
	}
	
	public void removerBolaDeFuego(BolaDeFuego bolaDeFuego) {
		this.bolasDeFuego.remove(bolaDeFuego);
		this.entidadesVisiblesEnPantalla.remove(bolaDeFuego);
	}
	
	public void removerPlataformaAfectable(Plataforma plataforma) {
		this.plataformasAfectables.remove(plataforma);
	}
	
	public void agregarEntidadVisible(Entidad entidad) {
		this.entidadesVisiblesEnPantalla.add(entidad);
		entidad.establecerNivel(this);
	}
	 
	public void removerEntidadVisible(Entidad entidad) {
		this.entidadesVisiblesEnPantalla.remove(entidad);
	}
	
	public Iterable<Entidad> obtenerEntidadesVisiblesEnPantalla(){
		return this.entidadesVisiblesEnPantalla;
	}
	
	public boolean estaEntidadVisible(Entidad entidad) {
		return this.entidadesVisiblesEnPantalla.contains(entidad);
}
}