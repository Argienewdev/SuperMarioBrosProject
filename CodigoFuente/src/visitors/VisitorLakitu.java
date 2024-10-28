package visitors;

import elementos.enemigos.*;
import elementos.entidades.BolaDeFuego;
import elementos.personajes.*;
import elementos.plataformas.*;
import elementos.powerUps.*;

public class VisitorLakitu implements Visitante {
    
    protected Lakitu miEntidad;
    
    protected DetectorDireccionColision detectorDireccionColision;
    
    public VisitorLakitu(Lakitu miEntidad) {
        this.miEntidad = miEntidad;
        this.detectorDireccionColision = new DetectorDireccionColision();
    }

    @Override
    public void visitarBuzzyBeetle(BuzzyBeetle buzzyBeetle) {
    }

    @Override
    public void visitarSpiny(Spiny spiny) {
    }

    @Override
    public void visitarGoomba(Goomba goomba) {
    }

    @Override
    public void visitarLakitu(Lakitu lakitu) {
    }

    @Override
    public void visitarPiranhaPlant(PiranhaPlant piranhaPlant) {
    }

    @Override
    public void visitarSuperChampinion(SuperChampinion superChampinion) {
    }

    @Override
    public void visitarFlorDeFuego(FlorDeFuego florDeFuego) {
    }

    @Override
    public void visitarChampinionVerde(ChampinionVerde champinionVerde) {
    }

    @Override
    public void visitarEstrella(Estrella estrella) {
    }

    @Override
    public void visitarMonedas(Monedas moneda) {
    }

    @Override
    public void visitarContextoMario(ContextoMario contextoMario) {
        contextoMario.getEstado().aceptarVisitante(this);
    }

    @Override
    public void visitarMarioDefault(MarioDefault marioDefault) {
    	if (this.detectorDireccionColision.verficiarImpactoLateralEntreEnemigoYMario(marioDefault.getContext(), this.miEntidad)) {
            ContextoMario contextoMario = marioDefault.getContext();
            int perdidaPuntos = this.miEntidad.getPuntosSustraidosPorMuerteCausada();
            contextoMario.perderPuntos(perdidaPuntos);
            contextoMario.perderVida();
            miEntidad.getNivel().reiniciarNivel();
        }
    }

    @Override
    public void visitarSuperMario(SuperMario superMario) {
    	superMario.getContext().reiniciarEstado();
    }

    @Override
    public void visitarMarioFuego(MarioFuego marioFuego) {
    	marioFuego.getContext().reiniciarEstado();
    }

    @Override
    public void visitarMarioInvulnerable(MarioInvulnerable marioInvulnerable) {}
    
    public void visitarMarioRecuperacion(MarioRecuperacion marioRecuperacion) {}

    @Override
    public void visitarBloqueDePregunta(BloqueDePregunta bloqueDePregunta) {
    	//Se encarga el bloque
    }

    @Override
    public void visitarLadrillo(Ladrillo ladrillo) {
        //Se encarga el bloque
    }

    @Override
    public void visitarPrincesaPeach(PrincesaPeach princesaPeach) {
        //Se encarga la princesa
    }

    @Override
    public void visitarBandera(Bandera bandera) {
        //Se encarga la bandera
    }

    @Override
    public void visitarTuberia(Tuberia tuberia) {
        //Se encarga el bloque
    }

    @Override
    public void visitarBloqueSolido(BloqueSolido bloqueSolido) {
        //Se encarga el bloque
    }

    @Override
    public void visitarContextoKoopaTroopa(ContextoKoopaTroopa contextoKoopaTroopa) {
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
	public void visitarBolaDeFuego(BolaDeFuego bolaDeFuego) {
		bolaDeFuego.eliminarDelNivel();
	}
    
}
