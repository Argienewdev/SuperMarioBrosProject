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
		if (this.detectorDireccionColision.choquePorArriba(buzzyBeetle, this.miEntidad)) {
			otorgarPuntosYEliminar(buzzyBeetle);
    	}
	}

	@Override
	public void visitarSpiny(Spiny spiny) {
		//TODO no se si puedo matar al spiny asi que no lo toco
		spiny.aceptarVisitante(this.miEntidad.getEstado().getVisitor());
	}

	@Override
	public void visitarGoomba(Goomba goomba) {
		if (this.detectorDireccionColision.choquePorArriba(goomba, this.miEntidad)) {
			otorgarPuntosYEliminar(goomba);
    	}
	}

	@Override
	public void visitarContextoKoopaTroopa(ContextoKoopaTroopa contextoKoopaTroopa) {
		if (this.detectorDireccionColision.choquePorArriba(contextoKoopaTroopa, this.miEntidad)) {
			//TODO en realidad depende de a que Koopa le pegue, asi que esto va a cambiar
			otorgarPuntosYEliminar(contextoKoopaTroopa);
    	}
	}

	@Override
	public void visitarKoopaEnCaparazon(KoopaEnCaparazon koopaEnCaparazon) {
		if (this.detectorDireccionColision.choquePorArriba(koopaEnCaparazon.getContext(), this.miEntidad)) {
			//TODO que hace cuando pisa el caparazon?
			koopaEnCaparazon.getContext().setRemovido(true);
            this.miEntidad.ganarPuntos(koopaEnCaparazon.getContext().getPuntosOtorgadosPorEliminacion());
    	}
	}

	@Override
	public void visitarKoopaDefault(KoopaDefault koopaDefault) {
		if (this.detectorDireccionColision.choquePorArriba(koopaDefault.getContext(), this.miEntidad)) {
			koopaDefault.getContext().setRemovido(true);
            this.miEntidad.ganarPuntos(koopaDefault.getContext().getPuntosOtorgadosPorEliminacion());
    	}
	}

	@Override
	public void visitarLakitu(Lakitu lakitu) {
		if (this.detectorDireccionColision.choquePorArriba(lakitu, this.miEntidad)) {
			otorgarPuntosYEliminar(lakitu);
    	}
	}

	@Override
	public void visitarPiranhaPlant(PiranhaPlant piranhaPlant) {
		//TODO Tengo entendido que la planta no se muere si mario le pega
		//muere con bolas de fuego?
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
	}

	@Override
	public void visitarTuberia(Tuberia tuberia) {
		tuberia.aceptarVisitante(this.miEntidad.getEstado().getVisitor());
	}

	@Override
	public void visitarBloqueSolido(BloqueSolido bloqueSolido) {}

	@Override
	public void visitarContextoMario(ContextoMario contextoMario) {}

	@Override
	public void visitarMarioDefault(MarioDefault marioDefault) {}

	@Override
	public void visitarSuperMario(SuperMario superMario) {}

	@Override
	public void visitarMarioFuego(MarioFuego marioFuego) {}

	@Override
	public void visitarMarioInvulnerable(MarioInvulnerable marioInvulnerable) {}
	
	@Override
	public void visitarPiso(Piso piso) {}
	
	private void otorgarPuntosYEliminar(Enemigo enemigo) {
		int puntos = enemigo.getPuntosOtorgadosPorEliminacion();
		this.miEntidad.ganarPuntos(puntos);
		enemigo.setRemovido(true);
	}

	@Override
	public void visitarBolaDeFuego(BolaDeFuego fireball) {}
	
}
