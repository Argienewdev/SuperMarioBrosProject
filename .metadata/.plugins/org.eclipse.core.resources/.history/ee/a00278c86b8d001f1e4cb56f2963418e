package visitors;

import elementos.enemigos.*;
import elementos.entidades.Fireball;
import elementos.personajes.*;
import elementos.plataformas.*;
import elementos.powerUps.*;
import juego.Nivel;
import ventanas.ControladorVistas;

public class VisitorMarioDefault implements Visitante {
	
	protected MarioDefault miEntidad;
	protected ControladorVistas controlador;
	
	public VisitorMarioDefault (MarioDefault miEntidad) {
		this.miEntidad = miEntidad;
	}
	
	public void visitarBuzzyBeetle(BuzzyBeetle buzzy) {
		int puntosGanados = buzzy.getPuntosOtorgadosPorEliminacion();
		ContextoMario contexto = miEntidad.getContext();
		contexto.ganarPuntos(puntosGanados);
		Nivel nivel = buzzy.getNivel();
		nivel.removeEnemigo(buzzy);
	}
	
	public void visitarSpiny(Spiny spiny) {
		//Solo es afectado por MarioFuego
	}

	
	public void visitarGoomba(Goomba goomba) {
		int puntosGanados = goomba.getPuntosOtorgadosPorEliminacion();
		ContextoMario contexto = miEntidad.getContext();
		contexto.ganarPuntos(puntosGanados);
		Nivel nivel = goomba.getNivel();
		nivel.removeEnemigo(goomba);
		
	}
	
	public void visitarKoopaDefault(KoopaDefault koopaDefault) {
		ContextoKoopaTroopa contexto = koopaDefault.getContext();
		EstadoKoopa estado = new KoopaCaparazonEstatico();
		contexto.cambiarEstado(estado);
	}

	public void visitarKoopaCaparazonEstatico(KoopaCaparazonEstatico koopaEstatico) {
		ContextoKoopaTroopa contexto = koopaEstatico.getContext();
		EstadoKoopa estado = new KoopaCaparazonMovil();
		contexto.cambiarEstado(estado);
	}

	
	public void visitarKoopaCaparazonMovil(KoopaCaparazonMovil koopaMovil) {
		ContextoKoopaTroopa contexto = koopaMovil.getContext();
		contexto.getNivel().removeEnemigo(contexto);
	}
	
	public void visitarLakitu(Lakitu lakitu) {
		int puntosGanados = lakitu.getPuntosOtorgadosPorEliminacion();
		ContextoMario contexto = miEntidad.getContext();
		contexto.ganarPuntos(puntosGanados);
		Nivel nivel = lakitu.getNivel();
		nivel.removeEnemigo(lakitu);
	}

	public void visitarPiranhaPlant(PiranhaPlant planta) {
		//Solo es afectado por MarioFuego
	}

	public void visitarFireball(Fireball fireball) {
		
	}

	public void visitarSuperChampinion(SuperChampinion superChamp) {
		ContextoMario contexto = miEntidad.getContext();
		MarioState estado = new SuperMario();
		contexto.cambiarEstado(estado);
		int puntosGandos = superChamp.getPuntosOtorgados();
		contexto.ganarPuntos(puntosGandos);
	}

	public void visitarFlorDeFuego(FlorDeFuego flor) {
		ContextoMario contexto = miEntidad.getContext();
		MarioState estado = new MarioFuego();
		contexto.cambiarEstado(estado);
		int puntosGandos = flor.getPuntosOtorgados();
		contexto.ganarPuntos(puntosGandos);
	}

	public void visitarChampinionVerde(ChampinionVerde champVerde) {
		ContextoMario contexto = miEntidad.getContext();
		contexto.ganarVida();
		int puntosGandos = champVerde.getPuntosOtorgados();
		contexto.ganarPuntos(puntosGandos);
	}

	
	public void visitarEstrella(Estrella estrella) {
		ContextoMario contexto = miEntidad.getContext();
		MarioState estado = new MarioInvulnerable();
		contexto.cambiarEstado(estado);
		int puntosGandos = estrella.getPuntosOtorgados();
		contexto.ganarPuntos(puntosGandos);
	}

	
	public void visitarMonedas(Monedas moneda) {
		ContextoMario contexto = miEntidad.getContext();
		int puntosGandos = moneda.getPuntosOtorgados();
		contexto.ganarPuntos(puntosGandos);
		miEntidad.incrementarMonedas(moneda.getMonedas());
	}
	
	public void visitarMarioDefault(MarioDefault marioNormal) {	
		
	}

	public void visitarMarioInvulnerable(MarioInvulnerable marioInv) {
				
	}
	
	public void visitarMarioFuego(MarioFuego marioFuego) {
			
	}

	public void visitarSuperMario(SuperMario superMario) {		
		
	}

	public void visitarBloqueDePregunta(BloqueDePregunta bloquePregunta) {
		if (!bloquePregunta.estaVacio()) {
			bloquePregunta.liberarPowerUp();
		}
		bloquePregunta.setVacio(true);
	}

	public void visitarLadrillo(Ladrillo ladrillo) {
		
	}

	
	public void visitarVacio(Vacio vacio) {
		
	}

	public void visitarPrincesaPeach(PrincesaPeach princesa) {
		
	}

	
	public void visitarBandera(Bandera bandera) {
		
	}

	
	public void visitarTuberia(Tuberia tuberia) {
		
	}

	
	public void visitarBloqueSolido(BloqueSolido bloqueSolido) {
		
	}

	
	public void visitarContextoMario(ContextoMario contextoMario) {
		
	}

	
	public void visitarContextoKoopaTroopa(ContextoKoopaTroopa contextoKoopa) {
		
	}

}
