package visitors;

import elementos.enemigos.*;
import elementos.entidades.BolaDeFuego;
import elementos.personajes.*;
import elementos.plataformas.*;
import elementos.powerUps.*;

public class VisitorContextoMario implements Visitante {
	
	protected ContextoMario miEntidad;
	
	protected DetectorDireccionColision detectorDireccionColision;
	
	public VisitorContextoMario (ContextoMario miEntidad) {
		this.miEntidad = miEntidad;
		this.detectorDireccionColision = new DetectorDireccionColision();
	}

	
	public void visitarBuzzyBeetle(BuzzyBeetle buzzyBeetle) {
		buzzyBeetle.aceptarVisitante(this.miEntidad.obtenerEstado().obtenerVisitante());
	}

	
	public void visitarSpiny(Spiny spiny) {
		spiny.aceptarVisitante(this.miEntidad.obtenerEstado().obtenerVisitante());
	}

	
	public void visitarGoomba(Goomba goomba) {
		goomba.aceptarVisitante(this.miEntidad.obtenerEstado().obtenerVisitante());
	}

	
	public void visitarContextoKoopaTroopa(ContextoKoopaTroopa contextoKoopaTroopa) {
		contextoKoopaTroopa.obtenerEstado().aceptarVisitante(this);
	}

	
	public void visitarKoopaEnCaparazon(KoopaEnCaparazon koopaEnCaparazon) {
		koopaEnCaparazon.obtenerContext().aceptarVisitante(this.miEntidad.obtenerEstado().obtenerVisitante());
	}

	
	public void visitarKoopaDefault(KoopaDefault koopaDefault) {
		koopaDefault.obtenerContext().aceptarVisitante(this.miEntidad.obtenerEstado().obtenerVisitante());
	}

	
	public void visitarLakitu(Lakitu lakitu) {
		lakitu.aceptarVisitante(this.miEntidad.obtenerEstado().obtenerVisitante());
	}

	
	public void visitarPiranhaPlant(PiranhaPlant piranhaPlant) {
		piranhaPlant.aceptarVisitante(this.miEntidad.obtenerEstado().obtenerVisitante());
	}

	
	public void visitarSuperChampinion(SuperChampinion superChampinion) {
		superChampinion.aceptarVisitante(this.miEntidad.obtenerEstado().obtenerVisitante());
	}

	
	public void visitarFlorDeFuego(FlorDeFuego florDeFuego) {
		florDeFuego.aceptarVisitante(this.miEntidad.obtenerEstado().obtenerVisitante());
	}

	
	public void visitarChampinionVerde(ChampinionVerde champinionVerde) {
		if (!champinionVerde.obtenerRemovido()) {
			this.miEntidad.ganarPuntos(champinionVerde.obtenerPuntosPorDefault());
			this.miEntidad.ganarVida();
			champinionVerde.establecerRemovido(true);
		}
	}

	
	public void visitarEstrella(Estrella estrella) {
		estrella.aceptarVisitante(this.miEntidad.obtenerEstado().obtenerVisitante());
	}

	
	public void visitarMoneda(Moneda monedas) {
		if (!monedas.obtenerRemovido()) {
    		this.miEntidad.ganarPuntos(monedas.obtenerPuntosPorDefault());
        	monedas.establecerRemovido(true);
    	}
	}

	
	public void visitarBloqueDePregunta(BloqueDePregunta bloqueDePregunta) {
		if (this.detectorDireccionColision.choquePorAbajo(bloqueDePregunta, this.miEntidad)) {
            bloqueDePregunta.liberarPowerUp();
        }
	}

	
	public void visitarLadrillo(Ladrillo ladrillo) {
		ladrillo.aceptarVisitante(this.miEntidad.obtenerEstado().obtenerVisitante());
	}
	
	
	public void visitarPrincesaPeach(PrincesaPeach princesaPeach) {
		this.miEntidad.obtenerNivel().obtenerPartida().finalizarPartida();
	}

	
	public void visitarBandera(Bandera bandera) {
        this.detectorDireccionColision.verificarColisionElementoDeJuegoYEntidad(miEntidad, this.miEntidad);
        this.miEntidad.reiniciarEstado();
		this.miEntidad.obtenerNivel().establecerCompletado(true);
	}

	
	public void visitarTuberia(Tuberia tuberia) {
		this.detectorDireccionColision.verificarColisionElementoDeJuegoYEntidad(tuberia, this.miEntidad);
	}

	
	public void visitarBloqueSolido(BloqueSolido bloqueSolido) {
		this.detectorDireccionColision.verificarColisionElementoDeJuegoYEntidad(bloqueSolido, this.miEntidad);
	}

	
	public void visitarContextoMario(ContextoMario contextoMario) {
	}

	
	public void visitarMarioDefault(MarioDefault marioDefault) {
	}

	
	public void visitarSuperMario(SuperMario superMario) {
	}

	
	public void visitarMarioFuego(MarioFuego marioFuego) {
	}

	
	public void visitarMarioInvulnerable(MarioInvulnerable marioInvulnerable) {
	}
	
	public void visitarMarioRecuperacion(MarioRecuperacion marioRecuperacion) {
	}
	
	
	public void visitarPiso(Piso piso) {
		this.detectorDireccionColision.verificarColisionElementoDeJuegoYEntidad(piso, this.miEntidad);
	}
	
	
	public void visitarBolaDeFuego(BolaDeFuego fireball) {}

	
	public void visitarVacio(Vacio vacio) {
	}
	
}
