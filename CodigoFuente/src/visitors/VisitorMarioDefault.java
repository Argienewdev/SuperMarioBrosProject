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
	
	public void visitar(BuzzyBeetle buzzy) {
		int puntosGanados = buzzy.getPuntosOtorgadosPorEliminacion();
		ContextoMario contexto = miEntidad.getContext();
		contexto.ganarPuntos(puntosGanados);
		Nivel nivel = buzzy.getNivel();
		nivel.removeEnemigo(buzzy);
	}
	
	public void visitar(Spiny spiny) {
		//Solo es afectado por FireBall
	}

	
	public void visitar(Goomba goomba) {
		int puntosGanados = goomba.getPuntosOtorgadosPorEliminacion();
		ContextoMario contexto = miEntidad.getContext();
		contexto.ganarPuntos(puntosGanados);
		Nivel nivel = goomba.getNivel();
		nivel.removeEnemigo(goomba);
		
	}
	
	public void visitar(KoopaDefault koopaDefault) {
		ContextoKoopaTroopa contexto = koopaDefault.getContext();
		EstadoKoopa estado = new KoopaCaparazonEstatico();
		contexto.cambiarEstado(estado);
	}

	public void visitar(KoopaCaparazonEstatico koopaEstatico) {
		ContextoKoopaTroopa contexto = koopaEstatico.getContext();
		EstadoKoopa estado = new KoopaCaparazonMovil();
		contexto.cambiarEstado(estado);
	}

	
	public void visitar(KoopaCaparazonMovil koopaMovil) {
		ContextoKoopaTroopa contexto = koopaMovil.getContext();
		int puntosGanados = contexto.getPuntosOtorgadosPorEliminacion();
		ContextoMario contextoM = miEntidad.getContext();
		contextoM.ganarPuntos(puntosGanados);
		contexto.getNivel().removeEnemigo(contexto);;
	}
	
	public void visitar(Lakitu lakitu) {
		int puntosGanados = lakitu.getPuntosOtorgadosPorEliminacion();
		ContextoMario contexto = miEntidad.getContext();
		contexto.ganarPuntos(puntosGanados);
		Nivel nivel = lakitu.getNivel();
		nivel.removeEnemigo(lakitu);
	}

	public void visitar(PiranhaPlant planta) {
		//Solo es afectado por una Fireball
	}

	public void visitar(Fireball fireball) {
		
	}

	public void visitar(SuperChampinion superChamp) {
		ContextoMario contexto = miEntidad.getContext();
		EstadoMario estado = new SuperMario();
		contexto.cambiarEstado(estado);
		int puntosGandos = superChamp.obtenerPuntosPorDefault();
		contexto.ganarPuntos(puntosGandos);
	}

	public void visitar(FlorDeFuego flor) {
		ContextoMario contexto = miEntidad.getContext();
		EstadoMario estado = new MarioFuego();
		contexto.cambiarEstado(estado);
		int puntosGandos = flor.obtenerPuntosPorDefault();
		contexto.ganarPuntos(puntosGandos);
	}

	public void visitar(ChampinionVerde champVerde) {
		ContextoMario contexto = miEntidad.getContext();
		int puntosGandos = champVerde.obtenerPuntosPorDefault();
		contexto.ganarPuntos(puntosGandos);
	}

	
	public void visitar(Estrella estrella) {
		ContextoMario contexto = miEntidad.getContext();
		EstadoMario estado = new MarioInvulnerable();
		contexto.cambiarEstado(estado);
		int puntosGandos = estrella.obtenerPuntosPorDefault();
		contexto.ganarPuntos(puntosGandos);
	}

	
	public void visitar(Monedas moneda) {
		Nivel nivel = moneda.getNivel();
		nivel.removePowerUps(moneda);
	}
	
	public void visitar(MarioDefault marioNormal) {	
		
	}

	public void visitar(MarioInvulnerable marioInv) {
				
	}
	
	public void visitar(MarioFuego marioFuego) {
			
	}

	public void visitar(SuperMario superMario) {		
		
	}

	public void visitar(BloqueDePregunta bloquePregunta) {
		if (!bloquePregunta.estaVacio()) {
			bloquePregunta.liberarPowerUp();
		}
		bloquePregunta.setVacio(true);
	}

	public void visitar(Ladrillo ladrillo) {
		
	}

	
	public void visitar(Vacio vacio) {
		
	}

	public void visitar(PrincesaPeach princesa) {
		
	}

	
	public void visitar(Bandera bandera) {
		
	}

	
	public void visitar(Tuberia tuberia) {
		
	}

	
	public void visitar(BloqueSolido bloqueSolido) {
		
	}

	
	public void visitar(ContextoMario contextoMario) {
		
	}

	
	public void visitar(ContextoKoopaTroopa contextoKoopa) {
		
	}

}
