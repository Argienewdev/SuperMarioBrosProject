package visitors;

import elementos.enemigos.*;
import elementos.entidades.BolaDeFuego;
import elementos.personajes.*;
import elementos.plataformas.*;
import elementos.powerUps.*;

public class VisitorKoopaDefault implements Visitante {

    protected EstadoKoopa miEstado;
    
    private ContextoKoopaTroopa miContexto;
    
    private DetectorDireccionColision detectorDireccionColision;

    public VisitorKoopaDefault(KoopaDefault miEstado) {
        this.miEstado = miEstado;
        this.miContexto = miEstado.getContext();
        this.detectorDireccionColision = new DetectorDireccionColision();
    }

    @Override
    public void visitarBuzzyBeetle(BuzzyBeetle buzzyBeetle) {
        // TODO Auto-generated method stub
    }

    @Override
    public void visitarSpiny(Spiny spiny) {
        // TODO Auto-generated method stub
    }

    @Override
    public void visitarGoomba(Goomba goomba) {
        // TODO Auto-generated method stub
    }

    @Override
    public void visitarContextoKoopaTroopa(ContextoKoopaTroopa contextoKoopaTroopa) {
        // TODO Auto-generated method stub
    }

    @Override
    public void visitarKoopaEnCaparazon(KoopaEnCaparazon koopaEnCaparazon) {
        // TODO Auto-generated method stub
    }

    @Override
    public void visitarKoopaDefault(KoopaDefault koopaDefault) {
        // TODO Auto-generated method stub
    }

    @Override
    public void visitarLakitu(Lakitu lakitu) {
        // TODO Auto-generated method stub
    }

    @Override
    public void visitarPiranhaPlant(PiranhaPlant piranhaPlant) {
        // TODO Auto-generated method stub
    }

    @Override
    public void visitarSuperChampinion(SuperChampinion superChampinion) {
        // TODO Auto-generated method stub
    }

    @Override
    public void visitarFlorDeFuego(FlorDeFuego florDeFuego) {
        // TODO Auto-generated method stub
    }

    @Override
    public void visitarChampinionVerde(ChampinionVerde champinionVerde) {
        // TODO Auto-generated method stub
    }

    @Override
    public void visitarEstrella(Estrella estrella) {
        // TODO Auto-generated method stub
    }

    @Override
    public void visitarMonedas(Monedas monedas) {
        // TODO Auto-generated method stub
    }

    @Override
    public void visitarBloqueDePregunta(BloqueDePregunta bloqueDePregunta) {
        // TODO Auto-generated method stub
    }

    @Override
    public void visitarLadrillo(Ladrillo ladrillo) {
        // TODO Auto-generated method stub
    }

    @Override
    public void visitarPrincesaPeach(PrincesaPeach princesaPeach) {
        // TODO Auto-generated method stub
    }

    @Override
    public void visitarBandera(Bandera bandera) {
        // TODO Auto-generated method stub
    }

    @Override
    public void visitarTuberia(Tuberia tuberia) {
        // TODO Auto-generated method stub
    }

    @Override
    public void visitarBloqueSolido(BloqueSolido bloqueSolido) {
        // TODO Auto-generated method stub
    }

    @Override
    public void visitarContextoMario(ContextoMario contextoMario) {
        contextoMario.getEstado().aceptarVisitante(this);
    }

    @Override
    public void visitarMarioDefault(MarioDefault marioDefault) {
    	if (this.detectorDireccionColision.verificarImpactoLateralEntreEnemigoYMario(marioDefault.getContext(), this.miContexto)) {
    		System.out.println("KOOPA VISITO A MARIO");
            ContextoMario contextoMario = marioDefault.getContext();
            int perdidaPuntos = this.miContexto.getPuntosSustraidosPorMuerteCausada();
            contextoMario.perderPuntos(perdidaPuntos);
            contextoMario.perderVida();
            miContexto.getNivel().obtenerPartida().reiniciarNivel();
        } 
    }

    @Override
    public void visitarSuperMario(SuperMario superMario) {
    	if (this.detectorDireccionColision.verificarImpactoLateralEntreEnemigoYMario(superMario.getContext(), this.miContexto)) {
	        superMario.getContext().reiniciarEstado();
    	}
    }

    @Override
    public void visitarMarioFuego(MarioFuego marioFuego) {
    	if (this.detectorDireccionColision.verificarImpactoLateralEntreEnemigoYMario(marioFuego.getContext(), this.miContexto)) {
    		marioFuego.getContext().reiniciarEstado();
    	}
    }
    @Override
    public void visitarMarioInvulnerable(MarioInvulnerable marioInvulnerable) {
    }
    
    public void visitarMarioRecuperacion(MarioRecuperacion marioRecuperacion) {}

    @Override
    public void visitarPiso(Piso piso) {
    }

	@Override
	public void visitarBolaDeFuego(BolaDeFuego fireball) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitarVacio(Vacio vacio) {
		// TODO Auto-generated method stub
		
	}
    
}
