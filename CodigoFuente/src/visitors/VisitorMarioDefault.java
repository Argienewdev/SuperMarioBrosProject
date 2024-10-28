package visitors;

import java.awt.Point;

import elementos.enemigos.*;
import elementos.entidades.BolaDeFuego;
import elementos.personajes.*;
import elementos.plataformas.*;
import elementos.powerUps.*;

public class VisitorMarioDefault implements Visitante {

    protected MarioDefault miEstado;
    
    protected DetectorDireccionColision detectorDireccionColision;
    
    protected ContextoMario miEntidad;

    public VisitorMarioDefault(MarioDefault miEstado) {
        this.miEstado = miEstado;
        this.miEntidad = miEstado.getContext();
        this.detectorDireccionColision = new DetectorDireccionColision();
    }

    @Override
    public void visitarBuzzyBeetle(BuzzyBeetle buzzyBeetle) {
    	if (this.detectorDireccionColision.choquePorArriba(buzzyBeetle, this.miEntidad)) {
    		buzzyBeetle.setRemovido(true);
            this.miEntidad.ganarPuntos(buzzyBeetle.getPuntosOtorgadosPorEliminacion());
    	}
    }

    @Override
    public void visitarSpiny(Spiny spiny) {
        // TODO Implementación pendiente
    }

    @Override
    public void visitarGoomba(Goomba goomba) {
    	if (this.detectorDireccionColision.choquePorArriba(goomba, this.miEntidad)) {
            goomba.setRemovido(true);
            this.miEntidad.ganarPuntos(goomba.getPuntosOtorgadosPorEliminacion());
    	}
    }

    @Override
    public void visitarContextoKoopaTroopa(ContextoKoopaTroopa contextoKoopaTroopa) {
		contextoKoopaTroopa.getEstado().aceptarVisitante(this);
    }

    @Override
    public void visitarKoopaEnCaparazon(KoopaEnCaparazon koopaEnCaparazon) {
        // TODO Implementación pendiente
    }

    @Override
    public void visitarKoopaDefault(KoopaDefault koopaDefault) {
    	if (this.detectorDireccionColision.choquePorArriba(koopaDefault.getContext(), this.miEntidad)) {
			ContextoKoopaTroopa contextoKoopa = koopaDefault.getContext();
	        EstadoKoopa nuevoEstado = new KoopaEnCaparazon();
	        contextoKoopa.cambiarEstado(nuevoEstado);
	        this.miEntidad.ganarPuntos(koopaDefault.getContext().getPuntosOtorgadosPorEliminacion());
	        koopaDefault.getContext().setVelocidadDireccional(new Point(0, 0));
		}
    }

    @Override
    public void visitarLakitu(Lakitu lakitu) {
        // TODO Implementación pendiente
    }

    @Override
    public void visitarPiranhaPlant(PiranhaPlant piranhaPlant) {
        // TODO Implementación pendiente
    }

    @Override
    public void visitarSuperChampinion(SuperChampinion superChampinion) {
        superChampinion.setRemovido(true);
    }

    @Override
    public void visitarFlorDeFuego(FlorDeFuego florDeFuego) {
        florDeFuego.setRemovido(true);
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
    	monedas.setRemovido(true);
    }

    @Override
    public void visitarBloqueDePregunta(BloqueDePregunta bloqueDePregunta) {}

    @Override
    public void visitarLadrillo(Ladrillo ladrillo) {}

    @Override
    public void visitarPiso(Piso piso) {}

    @Override
    public void visitarPrincesaPeach(PrincesaPeach princesaPeach) {
    	miEntidad.getNivel().obtenerPartida().obtenerJuego().finalizarPartida();
    }

    @Override
    public void visitarBandera(Bandera bandera) {
    	bandera.aceptarVisitante(miEntidad.getVisitor());
    }

    @Override
    public void visitarTuberia(Tuberia tuberia) {}

    @Override
    public void visitarBloqueSolido(BloqueSolido bloqueSolido) {}

    @Override
    public void visitarContextoMario(ContextoMario contextoMario) {}

    @Override
    public void visitarMarioDefault(MarioDefault marioDefault) {}

    @Override
    public void visitarSuperMario(SuperMario superMario) {}
    
    public void visitarMarioRecuperacion(MarioRecuperacion marioRecuperacion) {}

    @Override
    public void visitarMarioFuego(MarioFuego marioFuego) {}

    @Override
    public void visitarMarioInvulnerable(MarioInvulnerable marioInvulnerable) {}

	@Override
	public void visitarBolaDeFuego(BolaDeFuego fireball) {
		
	}
    
}
