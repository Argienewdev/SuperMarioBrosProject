package visitors;

import elementos.enemigos.*;
import elementos.entidades.BolaDeFuego;
import elementos.personajes.*;
import elementos.plataformas.*;
import elementos.powerUps.*;

public class VisitorGoomba implements Visitante {

    protected Goomba miEntidad;
    
    protected DetectorDireccionColision detectorDireccionColision;

    public VisitorGoomba(Goomba miEntidad) {
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
    public void visitarMonedas(Monedas monedas) {
    	
    }

    @Override
    public void visitarContextoMario(ContextoMario contextoMario) {
        contextoMario.getEstado().aceptarVisitante(this);
    }

    @Override
    public void visitarMarioDefault(MarioDefault marioDefault) {
        if (this.detectorDireccionColision.verificarImpactoLateralEntreMarioYEnemigo(marioDefault.getContext(), this.miEntidad) 
        	&& !this.miEntidad.getRemovido()) {
            ContextoMario contextoMario = marioDefault.getContext();
            int perdidaPuntos = this.miEntidad.getPuntosSustraidosPorMuerteCausada();
            contextoMario.perderPuntos(perdidaPuntos);
            contextoMario.perderVida();
            miEntidad.getNivel().obtenerPartida().reiniciarNivel();
        } else {
            detectorDireccionColision.verificarColisionElementoDeJuegoYEntidad(this.miEntidad, marioDefault.getContext());
        }
    }

    @Override
    public void visitarSuperMario(SuperMario superMario) {
    	if (this.detectorDireccionColision.verificarImpactoLateralEntreMarioYEnemigo(superMario.getContext(), this.miEntidad)) {
    		EstadoMario marioRecuperacion = new MarioRecuperacion();
	        superMario.getContext().cambiarEstado(marioRecuperacion);
    	}
    }

    @Override
    public void visitarMarioFuego(MarioFuego marioFuego) {
    	if (this.detectorDireccionColision.verificarImpactoLateralEntreMarioYEnemigo(marioFuego.getContext(), this.miEntidad)) {
    		EstadoMario marioRecuperacion = new MarioRecuperacion();
    		marioFuego.getContext().cambiarEstado(marioRecuperacion);
    	}
    }
    
    @Override
    public void visitarMarioInvulnerable(MarioInvulnerable marioInvulnerable) {
    	
    }

    public void visitarMarioRecuperacion(MarioRecuperacion marioRecuperacion) {
    	
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
		fireball.setRemovido(true);
	}

	@Override
	public void visitarVacio(Vacio vacio) {
	}
    
}
