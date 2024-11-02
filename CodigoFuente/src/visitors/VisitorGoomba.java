package visitors;

import elementos.enemigos.*;
import elementos.entidades.BolaDeFuego;
import elementos.personajes.*;
import elementos.plataformas.*;
import elementos.powerUps.*;
import generadores.GeneradorSonidos;

public class VisitorGoomba implements Visitante {

    protected Goomba miEntidad;
    
    protected DetectorDireccionColision detectorDireccionColision;
    
    protected GeneradorSonidos generadorSonidos;

    public VisitorGoomba(Goomba miEntidad, GeneradorSonidos generadorSonido) {
    	this.generadorSonidos = generadorSonido;
        this.miEntidad = miEntidad;
        this.detectorDireccionColision = new DetectorDireccionColision();
    }

    @Override
    public void visitarBuzzyBeetle(BuzzyBeetle buzzyBeetle) {
        this.detectorDireccionColision.verificarColisionEntreEntidades(this.miEntidad, buzzyBeetle);
    }

    @Override
    public void visitarSpiny(Spiny spiny) {
        this.detectorDireccionColision.verificarColisionEntreEntidades(this.miEntidad, spiny);
    }

    @Override
    public void visitarGoomba(Goomba goomba) {
        this.detectorDireccionColision.verificarColisionEntreEntidades(this.miEntidad, goomba);
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
    public void visitarContextoMario(ContextoMario contextoMario) {
        contextoMario.obtenerEstado().aceptarVisitante(this);
    }

    @Override
    public void visitarMarioDefault(MarioDefault marioDefault) {
        if (this.detectorDireccionColision.verificarImpactoLateralEntreMarioYEnemigo(marioDefault.obtenerContexto(), this.miEntidad) 
        	&& !this.miEntidad.obtenerRemovido()) {
            this.generadorSonidos.detenerMusicaFondo();
        	this.generadorSonidos.pierdeVida();
            ContextoMario contextoMario = marioDefault.obtenerContexto();
            int perdidaPuntos = this.miEntidad.obtenerPuntosSustraidosPorMuerteCausada();
            contextoMario.perderPuntos(perdidaPuntos);
            contextoMario.perderVida();
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
    public void visitarMarioInvulnerable(MarioInvulnerable marioInvulnerable) {
    }

    public void visitarMarioRecuperacion(MarioRecuperacion marioRecuperacion) {
    	if (this.miEntidad.obtenerRemovido()) {
            detectorDireccionColision.verificarColisionElementoDeJuegoYEntidad(this.miEntidad, marioRecuperacion.obtenerContexto());
    	}
    }

    @Override
    public void visitarBloqueDePregunta(BloqueDePregunta bloqueDePregunta) {
    	
    }

    @Override
    public void visitarLadrillo(Ladrillo ladrillo) {
    	
    }

    @Override
    public void visitarPiso(Piso piso) {
    	
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
    public void visitarContextoKoopaTroopa(ContextoKoopaTroopa contextoKoopaTroopa) {
        this.detectorDireccionColision.verificarColisionEntreEntidades(this.miEntidad, contextoKoopaTroopa);
    }

    @Override
    public void visitarKoopaEnCaparazon(KoopaEnCaparazon koopaEnCaparazon) {
    }

    @Override
    public void visitarKoopaDefault(KoopaDefault koopaDefault) {
    }

	@Override
	public void visitarBolaDeFuego(BolaDeFuego fireball) {
		generadorSonidos.matarBolaDeFuego();
		fireball.establecerRemovido(true);
	}

	@Override
	public void visitarVacio(Vacio vacio) {
	}
    
}
