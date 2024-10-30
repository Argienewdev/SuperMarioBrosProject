package visitors;

import elementos.enemigos.*;
import elementos.entidades.BolaDeFuego;
import elementos.personajes.*;
import elementos.plataformas.*;
import elementos.powerUps.*;

public class VisitorContextoKoopaTroopa implements Visitante {
    
    protected ContextoKoopaTroopa miEntidad;
    
    protected DetectorDireccionColision detectorDireccionColision;
    
    public VisitorContextoKoopaTroopa(ContextoKoopaTroopa miEntidad) {
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
    public void visitarContextoKoopaTroopa(ContextoKoopaTroopa contextoKoopaTroopa) {
		contextoKoopaTroopa.obtenerEstado().aceptarVisitante(this);
    }

    @Override
    public void visitarKoopaEnCaparazon(KoopaEnCaparazon koopaEnCaparazon) {
        this.detectorDireccionColision.verificarColisionElementoDeJuegoYEntidad(koopaEnCaparazon.obtenerContext() ,this.miEntidad);
    }

    @Override
    public void visitarKoopaDefault(KoopaDefault koopaDefault) {
        this.detectorDireccionColision.verificarColisionEntreEntidades(koopaDefault.obtenerContext(), this.miEntidad);
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
    	marioDefault.aceptarVisitante(this.miEntidad.obtenerEstado().obtenerVisitante());
    }

    @Override
    public void visitarSuperMario(SuperMario superMario) {  
    	superMario.aceptarVisitante(this.miEntidad.obtenerEstado().obtenerVisitante());
    }

    @Override
    public void visitarMarioFuego(MarioFuego marioFuego) {
    	marioFuego.aceptarVisitante(this.miEntidad.obtenerEstado().obtenerVisitante());
    }

    @Override
    public void visitarMarioInvulnerable(MarioInvulnerable marioInvulnerable) {}
    
    @Override
    public void visitarMarioRecuperacion(MarioRecuperacion marioRecuperacion) {
    	marioRecuperacion.aceptarVisitante(this.miEntidad.obtenerEstado().obtenerVisitante());
    }
    
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
