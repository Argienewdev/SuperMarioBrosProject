package visitors;

import elementos.enemigos.*;
import elementos.entidades.BolaDeFuego;
import elementos.personajes.*;
import elementos.plataformas.*;
import elementos.powerUps.*;
import generadores.GeneradorSonidos;

public class VisitorBuzzyBeetle implements Visitante {
    
    protected BuzzyBeetle miEntidad;
    
    protected DetectorDireccionColision detectorDireccionColision;
    
    protected GeneradorSonidos generadorSonido;
    
    public VisitorBuzzyBeetle(BuzzyBeetle miEntidad, GeneradorSonidos generadorSonido) {
    	this.generadorSonido = generadorSonido;
        this.miEntidad = miEntidad;
        this.detectorDireccionColision = new DetectorDireccionColision();
    }
    
    
    @Override
    public void visitarBuzzyBeetle(BuzzyBeetle buzzyBeetle) {
        this.detectorDireccionColision.verificarColisionEntreEntidades(this.miEntidad, buzzyBeetle);
    }
    
    @Override
    public void visitarSpiny(Spiny spiny) {}

    @Override
    public void visitarGoomba(Goomba goomba) {
        this.detectorDireccionColision.verificarColisionEntreEntidades(this.miEntidad, goomba);
    }
    
    @Override
    public void visitarContextoKoopaTroopa(ContextoKoopaTroopa contextoKoopaTroopa) {
        this.detectorDireccionColision.verificarColisionEntreEntidades(this.miEntidad, contextoKoopaTroopa);
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
    public void visitarMoneda(Moneda monedas) {}

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
        contextoMario.obtenerEstado().aceptarVisitante(this);
    }

    @Override
    public void visitarMarioDefault(MarioDefault marioDefault) {
        if (this.detectorDireccionColision.verificarImpactoLateralEntreMarioYEnemigo(marioDefault.obtenerContexto(), this.miEntidad) && !this.miEntidad.obtenerRemovido()) {
            ContextoMario contextoMario = marioDefault.obtenerContexto();
            int perdidaPuntos = this.miEntidad.obtenerPuntosSustraidosPorMuerteCausada();
            contextoMario.perderPuntos(perdidaPuntos);
            contextoMario.perderVida();
            generadorSonido.detenerMusicaFondo();
            generadorSonido.pierdeVida();
            miEntidad.obtenerNivel().obtenerPartida().reiniciarNivel();
        } else {
            detectorDireccionColision.verificarColisionElementoDeJuegoYEntidad(this.miEntidad, marioDefault.obtenerContexto());
        }
    }
    
    @Override
    public void visitarSuperMario(SuperMario superMario) {
        if (this.detectorDireccionColision.verificarImpactoLateralEntreMarioYEnemigo(superMario.obtenerContexto(), this.miEntidad)
        	&& !this.miEntidad.obtenerRemovido()) {
    		EstadoMario marioRecuperacion = new MarioRecuperacion();
    		superMario.obtenerContexto().cambiarEstado(marioRecuperacion);
        } else {
            detectorDireccionColision.verificarColisionElementoDeJuegoYEntidad(this.miEntidad, superMario.obtenerContexto());
        }
    }

    @Override
    public void visitarMarioFuego(MarioFuego marioFuego) {
    	if (this.detectorDireccionColision.verificarImpactoLateralEntreMarioYEnemigo(marioFuego.obtenerContexto(), this.miEntidad)
    		&& !this.miEntidad.obtenerRemovido()) {
    		EstadoMario marioRecuperacion = new MarioRecuperacion();
    		marioFuego.obtenerContexto().cambiarEstado(marioRecuperacion);
        } else {
            detectorDireccionColision.verificarColisionElementoDeJuegoYEntidad(this.miEntidad, marioFuego.obtenerContexto());
        }
    }
    
    @Override
    public void visitarMarioInvulnerable(MarioInvulnerable marioInvulnerable) {}
    
    public void visitarMarioRecuperacion(MarioRecuperacion marioRecuperacion) {}

	@Override
	public void visitarPiso(Piso piso) {}

	@Override
	public void visitarBolaDeFuego(BolaDeFuego fireball) {
		fireball.establecerRemovido(true);
	}

	@Override
	public void visitarVacio(Vacio vacio) {
	}
    
}
