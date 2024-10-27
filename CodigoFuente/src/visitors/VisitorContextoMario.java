package visitors;

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
		contextoKoopaTroopa.aceptarVisitante(this.miEntidad.getEstado().getVisitor());
	}

	@Override
	public void visitarKoopaEnCaparazon(KoopaEnCaparazon koopaEnCaparazon) {
		koopaEnCaparazon.aceptarVisitante(this.miEntidad.getEstado().getVisitor());
	}

	@Override
	public void visitarKoopaDefault(KoopaDefault koopaDefault) {
		koopaDefault.aceptarVisitante(this.miEntidad.getEstado().getVisitor());
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
		champinionVerde.aceptarVisitante(this.miEntidad.getEstado().getVisitor());
	}

	@Override
	public void visitarEstrella(Estrella estrella) {
		estrella.aceptarVisitante(this.miEntidad.getEstado().getVisitor());
	}

	@Override
	public void visitarMonedas(Monedas monedas) {
		monedas.aceptarVisitante(this.miEntidad.getEstado().getVisitor());
	}

	@Override
	public void visitarBloqueDePregunta(BloqueDePregunta bloqueDePregunta) {
		if (this.detectorDireccionColision.choquePorAbajo(bloqueDePregunta, this.miEntidad)) {
            bloqueDePregunta.liberarPowerUp();
        }
	}

	@Override
	public void visitarLadrillo(Ladrillo ladrillo) {
		ladrillo.aceptarVisitante(this.miEntidad.getEstado().getVisitor());
	}
	
	@Override
	public void visitarPrincesaPeach(PrincesaPeach princesaPeach) {
		princesaPeach.aceptarVisitante(this.miEntidad.getEstado().getVisitor());
	}

	@Override
	public void visitarBandera(Bandera bandera) {
		bandera.aceptarVisitante(this.miEntidad.getEstado().getVisitor());
	}

	@Override
	public void visitarTuberia(Tuberia tuberia) {
		tuberia.aceptarVisitante(this.miEntidad.getEstado().getVisitor());
	}

	@Override
	public void visitarBloqueSolido(BloqueSolido bloqueSolido) {
		bloqueSolido.aceptarVisitante(this.miEntidad.getEstado().getVisitor());
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
	
	@Override
	public void visitarPiso(Piso piso) {
		piso.aceptarVisitante(this.miEntidad.getEstado().getVisitor());
	}
	
	private void otorgarPuntosYEliminar(Enemigo enemigo) {
		int puntos = enemigo.getPuntosOtorgadosPorEliminacion();
		this.miEntidad.ganarPuntos(puntos);
		enemigo.eliminarDelNivel();
	}

	@Override
	public void visitarBolaDeFuego(BolaDeFuego fireball) {
		// TODO Auto-generated method stub
		
	}
	
}
