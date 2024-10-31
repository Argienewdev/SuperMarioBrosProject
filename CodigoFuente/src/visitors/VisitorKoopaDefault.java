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
        this.miContexto = miEstado.obtenerContext();
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
    public void visitarContextoKoopaTroopa(ContextoKoopaTroopa contextoKoopaTroopa) {
        
    }

    @Override
    public void visitarKoopaEnCaparazon(KoopaEnCaparazon koopaEnCaparazon) {
        
    }

    @Override
    public void visitarKoopaDefault(KoopaDefault koopaDefault) {
        
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
    public void visitarMoneda(Moneda monedas) {
        
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
        contextoMario.obtenerEstado().aceptarVisitante(this);
    }

    @Override
    public void visitarMarioDefault(MarioDefault marioDefault) {
    	if (this.detectorDireccionColision.verificarImpactoLateralEntreMarioYEnemigo(marioDefault.obtenerContexto(), this.miContexto)
    		&& !this.miContexto.obtenerRemovido()) {
            ContextoMario contextoMario = marioDefault.obtenerContexto();
            int perdidaPuntos = this.miContexto.obtenerPuntosSustraidosPorMuerteCausada();
            contextoMario.perderPuntos(perdidaPuntos);
            contextoMario.perderVida();
            miContexto.obtenerNivel().obtenerPartida().reiniciarNivel();
        }
    }

    @Override
    public void visitarSuperMario(SuperMario superMario) {
    	if (this.detectorDireccionColision.verificarImpactoLateralEntreMarioYEnemigo(superMario.obtenerContexto(), this.miContexto)
        	&& !this.miContexto.obtenerRemovido()) {
    		EstadoMario marioRecuperacion = new MarioRecuperacion();
	        superMario.obtenerContexto().cambiarEstado(marioRecuperacion);
    	}else {
            detectorDireccionColision.verificarColisionElementoDeJuegoYEntidad(this.miContexto, superMario.obtenerContexto());
    	}
    }

    @Override
    public void visitarMarioFuego(MarioFuego marioFuego) {
    	if (this.detectorDireccionColision.verificarImpactoLateralEntreMarioYEnemigo(marioFuego.obtenerContexto(), this.miContexto)
        	&& !this.miContexto.obtenerRemovido()) {
    		EstadoMario marioRecuperacion = new MarioRecuperacion();
    		marioFuego.obtenerContexto().cambiarEstado(marioRecuperacion);
    	}else {
            detectorDireccionColision.verificarColisionElementoDeJuegoYEntidad(this.miContexto, marioFuego.obtenerContexto());
    	}
    }
    @Override
    public void visitarMarioInvulnerable(MarioInvulnerable marioInvulnerable) {
    }
    
    public void visitarMarioRecuperacion(MarioRecuperacion marioRecuperacion) {
    	if(this.miContexto.obtenerRemovido()) {
            detectorDireccionColision.verificarColisionElementoDeJuegoYEntidad(this.miContexto, marioRecuperacion.obtenerContexto());
    	}
    }

    @Override
    public void visitarPiso(Piso piso) {
    }

	@Override
	public void visitarBolaDeFuego(BolaDeFuego fireball) {
	}

	@Override
	public void visitarVacio(Vacio vacio) {
	}
    
}
