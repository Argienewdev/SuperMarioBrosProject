package visitors;

import elementos.enemigos.*;
import elementos.entidades.Fireball;
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
		if(this.detectorDireccionColision.choquePorArriba(buzzyBeetle, this.miEntidad)) {
			otorgarPuntosYEliminar(buzzyBeetle);
		}
	}

	@Override
	public void visitarSpiny(Spiny spiny) {
		//Solo es afectado por FireBall
	}

	@Override
	public void visitarGoomba(Goomba goomba) {
		if(this.detectorDireccionColision.choquePorArriba(goomba, this.miEntidad)) {
			otorgarPuntosYEliminar(goomba);
		}
	}

	@Override
	public void visitarContextoKoopaTroopa(ContextoKoopaTroopa contextoKoopaTroopa) {
		if(this.detectorDireccionColision.choquePorArriba(contextoKoopaTroopa, this.miEntidad)) {
			contextoKoopaTroopa.getEstado().aceptarVisitante(this.miEntidad.getVisitor());
		}
	}

	@Override
	public void visitarKoopaEnCaparazon(KoopaEnCaparazon koopaEnCaparazon) {
		otorgarPuntosYEliminar(koopaEnCaparazon.getContext());
	}

	@Override
	public void visitarKoopaDefault(KoopaDefault koopaDefault) {
		ContextoKoopaTroopa contextoKoopaTroopa = koopaDefault.getContext();
		KoopaEnCaparazon nuevoEstado = new KoopaEnCaparazon();
		contextoKoopaTroopa.cambiarEstado(nuevoEstado);
	}

	@Override
	public void visitarLakitu(Lakitu lakitu) {
		otorgarPuntosYEliminar(lakitu);
	}

	@Override
	public void visitarPiranhaPlant(PiranhaPlant piranhaPlant) {
		//Solo es afectado por FireBall
	}

	@Override
	public void visitarFireball(Fireball fireball) {
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
		Nivel nivel = champinionVerde.getNivel();
		this.miEntidad.ganarPuntos(100);
		champinionVerde.eliminarDelNivel();
	}

	@Override
	public void visitarEstrella(Estrella estrella) {
		estrella.aceptarVisitante(this.miEntidad.getEstado().getVisitor());
	}

	@Override
	public void visitarMonedas(Monedas moneda) {
		Nivel nivel = moneda.getNivel();
		this.miEntidad.ganarPuntos(5);
		moneda.eliminarDelNivel();
	}

	@Override
	public void visitarBloqueDePregunta(BloqueDePregunta bloqueDePregunta) {
		bloqueDePregunta.aceptarVisitante(this.miEntidad.getEstado().getVisitor());
	}

	@Override
	public void visitarLadrillo(Ladrillo ladrillo) {
		ladrillo.aceptarVisitante(this.miEntidad.getEstado().getVisitor());
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
		bloqueSolido.aceptarVisitante(this.miEntidad.getEstado().getVisitor());
	}

	@Override
	public void visitarContextoMario(ContextoMario contextoMario) {
	}

	@Override
	public void visitarMarioDefault(MarioDefault marioDefault) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitarSuperMario(SuperMario superMario) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitarMarioFuego(MarioFuego marioFuego) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitarMarioInvulnerable(MarioInvulnerable marioInvulnerable) {
		// TODO Auto-generated method stub
		
	}
	
	private void otorgarPuntosYEliminar(Enemigo enemigo) {
		int puntos = enemigo.getPuntosOtorgadosPorEliminacion();
		this.miEntidad.ganarPuntos(puntos);
		enemigo.eliminarDelNivel();
	}
	
	@Override
	public void visitarPiso(Piso piso) {
		piso.aceptarVisitante(this.miEntidad.getEstado().getVisitor());
	}
}
