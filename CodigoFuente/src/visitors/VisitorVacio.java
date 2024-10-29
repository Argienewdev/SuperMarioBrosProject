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
    	buzzyBeetle.setRemovido(true);
    }

    @Override
    public void visitarSpiny(Spiny spiny) {    
    	spiny.setRemovido(true);
    }
    
    @Override
    public void visitarGoomba(Goomba goomba) {
    	goomba.setRemovido(true);
    }

    @Override
    public void visitarLakitu(Lakitu lakitu) {
    	lakitu.setRemovido(true);
    }

    @Override
    public void visitarPiranhaPlant(PiranhaPlant planta) {
    }

    @Override
    public void visitarSuperChampinion(SuperChampinion superChampinion) {    
    	superChampinion.setRemovido(true);
    }

    @Override
    public void visitarFlorDeFuego(FlorDeFuego flor) {
    	flor.setRemovido(true);
    }

    @Override
    public void visitarChampinionVerde(ChampinionVerde champinionVerde) {    
    	champinionVerde.setRemovido(true);
    }

    @Override
    public void visitarEstrella(Estrella estrella) {
    	estrella.setRemovido(true);
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
        miEntidad.getNivel().reiniciarNivel();
    }

    @Override
    public void visitarContextoKoopaTroopa(ContextoKoopaTroopa contextoKoopaTroopa) { 
    	contextoKoopaTroopa.setRemovido(true);
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
    	fireball.setRemovido(true);
   	}

	@Override
	public void visitarVacio(Vacio vacio) {
	}

    
}
