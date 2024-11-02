package visitors;

import elementos.enemigos.*;
import elementos.entidades.BolaDeFuego;
import elementos.personajes.*;
import elementos.plataformas.*;
import elementos.powerUps.*;
import generadores.GeneradorSonidos;

public class VisitorVacio implements Visitante {

    protected Vacio miEntidad;
    
    protected DetectorDireccionColision detectorDireccionColision;
    
    protected GeneradorSonidos generadorSonidos;

    public VisitorVacio(Vacio miEntidad, GeneradorSonidos generadorSonidos) {
    	this.generadorSonidos = generadorSonidos;
        this.miEntidad = miEntidad;
        this.detectorDireccionColision = new DetectorDireccionColision();
    }

    
    public void visitarBuzzyBeetle(BuzzyBeetle buzzyBeetle) {
    	buzzyBeetle.establecerRemovido(true);
    }

    
    public void visitarSpiny(Spiny spiny) {    
    	spiny.establecerRemovido(true);
    }
    
    
    public void visitarGoomba(Goomba goomba) {
    	goomba.establecerRemovido(true);
    }

    
    public void visitarLakitu(Lakitu lakitu) {
    	lakitu.establecerRemovido(true);
    }

    
    public void visitarPiranhaPlant(PiranhaPlant planta) {
    }

    
    public void visitarSuperChampinion(SuperChampinion superChampinion) {    
    	superChampinion.establecerRemovido(true);
    }

    
    public void visitarFlorDeFuego(FlorDeFuego flor) {
    	flor.establecerRemovido(true);
    }

    
    public void visitarChampinionVerde(ChampinionVerde champinionVerde) {    
    	champinionVerde.establecerRemovido(true);
    }

    
    public void visitarEstrella(Estrella estrella) {
    	estrella.establecerRemovido(true);
    }

    
    public void visitarMoneda(Moneda monedas) {
    }

    
    public void visitarMarioDefault(MarioDefault marioDefault) {
    }

    public void visitarMarioInvulnerable(MarioInvulnerable marioInvulnerable) {
    }
    
    public void visitarMarioFuego(MarioFuego marioFuego) {
    }

    public void visitarSuperMario(SuperMario superMario) {
    }
    
    public void visitarMarioRecuperacion(MarioRecuperacion marioRecuperacion) {
    }

    public void visitarBloqueDePregunta(BloqueDePregunta bloqueDePregunta) {
    }

    public void visitarLadrillo(Ladrillo ladrillo) {
    }

    public void visitarPrincesaPeach(PrincesaPeach princesaPeach) {
    }

    public void visitarBandera(Bandera bandera) {
    }

    public void visitarTuberia(Tuberia tuberia) {
    }

    public void visitarBloqueSolido(BloqueSolido bloqueSolido) {
    }

    public void visitarContextoMario(ContextoMario contextoMario) {
    	this.generadorSonidos.pierdeVida();
    	int puntajeASustraer = this.miEntidad.obtenerPuntosSustraidosPorMuerteCausada();
    	contextoMario.perderPuntos(puntajeASustraer);
    	contextoMario.perderVida();
    	contextoMario.reiniciarEstado();
        miEntidad.obtenerNivel().obtenerPartida().reiniciarNivel();
    }

    
    public void visitarContextoKoopaTroopa(ContextoKoopaTroopa contextoKoopaTroopa) { 
    	contextoKoopaTroopa.establecerRemovido(true);
    }

    public void visitarKoopaEnCaparazon(KoopaEnCaparazon koopaEnCaparazon) {
    }

    public void visitarKoopaDefault(KoopaDefault koopaDefault) {
    }

    public void visitarPiso(Piso piso) {
    }

   	public void visitarBolaDeFuego(BolaDeFuego fireball) {
   		generadorSonidos.choqueFireball();
    	fireball.establecerRemovido(true);
   	}

	public void visitarVacio(Vacio vacio) {
	}

    
}
