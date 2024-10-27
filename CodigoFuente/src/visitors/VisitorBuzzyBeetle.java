package visitors;

import elementos.enemigos.*;
import elementos.entidades.BolaDeFuego;
import elementos.personajes.*;
import elementos.plataformas.*;
import elementos.powerUps.*;

public class VisitorBuzzyBeetle implements Visitante {
    
    protected BuzzyBeetle miEntidad;
    
    protected DetectorDireccionColision detectorDireccionColision;
    
    public VisitorBuzzyBeetle(BuzzyBeetle miEntidad) {
        this.miEntidad = miEntidad;
        this.detectorDireccionColision = new DetectorDireccionColision();
    }
    
    @Override
    public void visitarBuzzyBeetle(BuzzyBeetle buzzyBeetle) {
        this.detectorDireccionColision.verificarColision(this.miEntidad, buzzyBeetle);
    }
    
    @Override
    public void visitarSpiny(Spiny spiny) {}

    @Override
    public void visitarGoomba(Goomba goomba) {
        this.detectorDireccionColision.verificarColision(this.miEntidad, goomba);
    }
    
    @Override
    public void visitarContextoKoopaTroopa(ContextoKoopaTroopa contextoKoopaTroopa) {
        this.detectorDireccionColision.verificarColision(this.miEntidad, contextoKoopaTroopa);
    }

    @Override
    public void visitarKoopaEnCaparazon(KoopaEnCaparazon koopaEnCaparazon) {
    	//TODO
    }

    @Override
    public void visitarKoopaDefault(KoopaDefault koopaDefault) {
    	//TODO
    }
    
    @Override
    public void visitarLakitu(Lakitu lakitu) {}
    
    @Override
    public void visitarPiranhaPlant(PiranhaPlant piranhaPlant) {}

    @Override
    public void visitarSuperChampinion(SuperChampinion superChampinion) {}

    @Override
    public void visitarFlorDeFuego(FlorDeFuego florDeFuego) {}

    @Override
    public void visitarChampinionVerde(ChampinionVerde champinionVerde) {}
    
    @Override
    public void visitarEstrella(Estrella estrella) {}

    @Override
    public void visitarMonedas(Monedas monedas) {}

    @Override
    public void visitarBloqueDePregunta(BloqueDePregunta bloqueDePregunta) {}

    @Override
    public void visitarLadrillo(Ladrillo ladrillo) {}
    
    @Override
    public void visitarPrincesaPeach(PrincesaPeach princesaPeach) {}

    @Override
    public void visitarBandera(Bandera bandera) {}

    @Override
    public void visitarTuberia(Tuberia tuberia) {}

    @Override
    public void visitarBloqueSolido(BloqueSolido bloqueSolido) {}
    
    @Override
    public void visitarContextoMario(ContextoMario contextoMario) {
        contextoMario.getEstado().aceptarVisitante(this);
    }

    @Override
    public void visitarMarioDefault(MarioDefault marioDefault) {
        if(this.detectorDireccionColision.verficiarImpactoLateralEntreEnemigoYMario(marioDefault.getContext(), this.miEntidad)) {
            ContextoMario contextoMario = marioDefault.getContext();
            int perdidaPuntos = this.miEntidad.getPuntosSustraidosPorMuerteCausada();
            contextoMario.perderPuntos(perdidaPuntos);
            contextoMario.perderVida();
            miEntidad.getNivel().reiniciarNivel();
        }
    }
    
    @Override
    public void visitarSuperMario(SuperMario superMario) {
        if(this.detectorDireccionColision.verficiarImpactoLateralEntreEnemigoYMario(superMario.getContext(), this.miEntidad)) {
        	superMario.getContext().reiniciarEstado();
        }
    }

    @Override
    public void visitarMarioFuego(MarioFuego marioFuego) {
    	if(this.detectorDireccionColision.verficiarImpactoLateralEntreEnemigoYMario(marioFuego.getContext(), this.miEntidad)) {
    		marioFuego.getContext().reiniciarEstado();
        }
    }
    
    @Override
    public void visitarMarioInvulnerable(MarioInvulnerable marioInvulnerable) {}

	@Override
	public void visitarPiso(Piso piso) {}

	@Override
	public void visitarBolaDeFuego(BolaDeFuego fireball) {}
    
}
