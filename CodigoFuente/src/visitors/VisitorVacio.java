package visitors;

import elementos.enemigos.*;
import elementos.entidades.BolaDeFuego;
import elementos.personajes.*;
import elementos.plataformas.*;
import elementos.powerUps.*;

public class VisitorVacio implements Visitante {

    protected Vacio miEntidad;
    
    protected DetectorDireccionColision detectorDireccionColision;

    public VisitorVacio(Vacio miEntidad) {
        this.miEntidad = miEntidad;
        this.detectorDireccionColision = new DetectorDireccionColision();
    }

    @Override
    public void visitarBuzzyBeetle(BuzzyBeetle buzzyBeetle) {
    	buzzyBeetle.establecerRemovido(true);
    }

    @Override
    public void visitarSpiny(Spiny spiny) {    
    	spiny.establecerRemovido(true);
    }
    
    @Override
    public void visitarGoomba(Goomba goomba) {
    	goomba.establecerRemovido(true);
    }

    @Override
    public void visitarLakitu(Lakitu lakitu) {
    	lakitu.establecerRemovido(true);
    }

    @Override
    public void visitarPiranhaPlant(PiranhaPlant planta) {
    }

    @Override
    public void visitarSuperChampinion(SuperChampinion superChampinion) {    
    	superChampinion.establecerRemovido(true);
    }

    @Override
    public void visitarFlorDeFuego(FlorDeFuego flor) {
    	flor.establecerRemovido(true);
    }

    @Override
    public void visitarChampinionVerde(ChampinionVerde champinionVerde) {    
    	champinionVerde.establecerRemovido(true);
    }

    @Override
    public void visitarEstrella(Estrella estrella) {
    	estrella.establecerRemovido(true);
    }

    @Override
    public void visitarMonedas(Monedas monedas) {
    }

    @Override
    public void visitarMarioDefault(MarioDefault marioDefault) {
    }

    @Override
    public void visitarMarioInvulnerable(MarioInvulnerable marioInvulnerable) {
    }

    @Override
    public void visitarMarioFuego(MarioFuego marioFuego) {
    }

    @Override
    public void visitarSuperMario(SuperMario superMario) {
    }
    
    @Override
    public void visitarMarioRecuperacion(MarioRecuperacion marioRecuperacion) {
    }

    @Override
    public void visitarBloqueDePregunta(BloqueDePregunta bloqueDePregunta) {
    }

    @Override
    public void visitarLadrillo(Ladrillo ladrillo) {
    }

    @Override
    public void visitarPrincesaPeach(PrincesaPeach princesaPeach) {
    }

    @Override
    public void visitarBandera(Bandera bandera) {
    }

    @Override
    public void visitarTuberia(Tuberia tuberia) {
    }

    @Override
    public void visitarBloqueSolido(BloqueSolido bloqueSolido) {
    }

    @Override
    public void visitarContextoMario(ContextoMario contextoMario) {
    	int puntajeASustraer = this.miEntidad.getPuntosSustraidosPorMuerteCausada();
    	contextoMario.perderPuntos(puntajeASustraer);
    	contextoMario.perderVida();
    	contextoMario.reiniciarEstado();
        miEntidad.obtenerNivel().obtenerPartida().reiniciarNivel();
    }

    @Override
    public void visitarContextoKoopaTroopa(ContextoKoopaTroopa contextoKoopaTroopa) { 
    	contextoKoopaTroopa.establecerRemovido(true);
    }

    @Override
    public void visitarKoopaEnCaparazon(KoopaEnCaparazon koopaEnCaparazon) {
    }

    @Override
    public void visitarKoopaDefault(KoopaDefault koopaDefault) {
    }

    @Override
    public void visitarPiso(Piso piso) {
    }

    @Override
   	public void visitarBolaDeFuego(BolaDeFuego fireball) {
    	fireball.establecerRemovido(true);
   	}

	@Override
	public void visitarVacio(Vacio vacio) {
	}

    
}
