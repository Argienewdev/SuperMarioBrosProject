package visitors;

import java.awt.Point;

import elementos.enemigos.*;
import elementos.entidades.BolaDeFuego;
import elementos.personajes.*;
import elementos.plataformas.*;
import elementos.powerUps.*;
import juego.Nivel;

public class VisitorContextoMario implements Visitante {
	
	protected ContextoMario miEntidad;
	
	protected DetectorDireccionColision detectorDireccionColision;
	
	public VisitorContextoMario (ContextoMario miEntidad) {
		this.miEntidad = miEntidad;
		this.detectorDireccionColision = new DetectorDireccionColision();
	}

	@Override
	public void visitarBuzzyBeetle(BuzzyBeetle buzzyBeetle) {
		buzzyBeetle.aceptarVisitante(this.miEntidad.getEstado().getVisitor());
	}

	@Override
	public void visitarSpiny(Spiny spiny) {
		spiny.aceptarVisitante(this.miEntidad.getEstado().getVisitor());
	}

	@Override
	public void visitarGoomba(Goomba goomba) {
		goomba.aceptarVisitante(this.miEntidad.getEstado().getVisitor());
	}

	@Override
	public void visitarContextoKoopaTroopa(ContextoKoopaTroopa contextoKoopaTroopa) {
		contextoKoopaTroopa.getEstado().aceptarVisitante(this);
	}

	@Override
	public void visitarKoopaEnCaparazon(KoopaEnCaparazon koopaEnCaparazon) {
		koopaEnCaparazon.getContext().aceptarVisitante(this.miEntidad.getEstado().getVisitor());
	}

	@Override
	public void visitarKoopaDefault(KoopaDefault koopaDefault) {
		koopaDefault.getContext().aceptarVisitante(this.miEntidad.getEstado().getVisitor());
	}

	@Override
	public void visitarLakitu(Lakitu lakitu) {
		lakitu.aceptarVisitante(this.miEntidad.getEstado().getVisitor());
	}

	@Override
	public void visitarPiranhaPlant(PiranhaPlant piranhaPlant) {
		piranhaPlant.aceptarVisitante(this.miEntidad.getEstado().getVisitor());
	}

	@Override
	public void visitarSuperChampinion(SuperChampinion superChampinion) {
		superChampinion.aceptarVisitante(this.miEntidad.getEstado().getVisitor());
	}

	@Override
	public void visitarFlorDeFuego(FlorDeFuego florDeFuego) {
		florDeFuego.aceptarVisitante(this.miEntidad.getEstado().getVisitor());
	}

	@Override
	public void visitarChampinionVerde(ChampinionVerde champinionVerde) {
		if(!champinionVerde.getRemovido()) {
			this.miEntidad.ganarPuntos(champinionVerde.obtenerPuntosPorDefault());
			this.miEntidad.ganarVida();
			champinionVerde.setRemovido(true);
		}
	}

	@Override
	public void visitarEstrella(Estrella estrella) {
		estrella.aceptarVisitante(this.miEntidad.getEstado().getVisitor());
	}

	@Override
	public void visitarMonedas(Monedas monedas) {
		if(!monedas.getRemovido()) {
    		this.miEntidad.ganarPuntos(monedas.obtenerPuntosPorDefault());
        	monedas.setRemovido(true);
    	}
	}

	@Override
	public void visitarBloqueDePregunta(BloqueDePregunta bloqueDePregunta) {
		if(this.detectorDireccionColision.choquePorAbajo(bloqueDePregunta, this.miEntidad)) {
            bloqueDePregunta.liberarPowerUp();
        }
	}

	@Override
	public void visitarLadrillo(Ladrillo ladrillo) {
		ladrillo.aceptarVisitante(this.miEntidad.getEstado().getVisitor());
	}
	
	@Override
	public void visitarPrincesaPeach(PrincesaPeach princesaPeach) {
		this.miEntidad.getNivel().obtenerPartida().finalizarPartida();
	}

	@Override
	public void visitarBandera(Bandera bandera) {
        this.detectorDireccionColision.verificarColisionElementoDeJuegoYEntidad(miEntidad, this.miEntidad);
        this.miEntidad.reiniciarEstado();
		this.miEntidad.getNivel().setCompletado(true);
	}

	@Override
	public void visitarTuberia(Tuberia tuberia) {
		this.detectorDireccionColision.verificarColisionElementoDeJuegoYEntidad(tuberia, this.miEntidad);
	}

	@Override
	public void visitarBloqueSolido(BloqueSolido bloqueSolido) {
		this.detectorDireccionColision.verificarColisionElementoDeJuegoYEntidad(bloqueSolido, this.miEntidad);
	}

	@Override
	public void visitarContextoMario(ContextoMario contextoMario) {
	}

	@Override
	public void visitarMarioDefault(MarioDefault marioDefault) {
	}

	@Override
	public void visitarSuperMario(SuperMario superMario) {
	}

	@Override
	public void visitarMarioFuego(MarioFuego marioFuego) {
	}

	@Override
	public void visitarMarioInvulnerable(MarioInvulnerable marioInvulnerable) {
	}
	
	public void visitarMarioRecuperacion(MarioRecuperacion marioRecuperacion) {
	}
	
	@Override
	public void visitarPiso(Piso piso) {
		this.detectorDireccionColision.verificarColisionElementoDeJuegoYEntidad(piso, this.miEntidad);
	}

	@Override
	public void visitarBolaDeFuego(BolaDeFuego fireball) {}

	@Override
	public void visitarVacio(Vacio vacio) {
		// TODO Auto-generated method stub
		
	}
	
}
