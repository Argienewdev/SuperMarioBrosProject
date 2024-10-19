package visitors;

import elementos.enemigos.*;
import elementos.entidades.Fireball;
import elementos.personajes.*;
import elementos.plataformas.*;
import elementos.powerUps.*;
import juego.Nivel;
public class VisitorMarioFuego implements Visitante{
	
	protected MarioFuego miEntidad;
	
	@SuppressWarnings("exports")
	public VisitorMarioFuego (MarioFuego miEntidad) {
		this.miEntidad = miEntidad;
	}
	
	@Override
	public void visitar(BuzzyBeetle buzzy) {
		int puntosGanados = buzzy.getPuntosOtorgadosPorEliminacion();
		ContextoMario contexto = miEntidad.getContext();
		contexto.ganarPuntos(puntosGanados);
		Nivel nivel = buzzy.getNivel();
		nivel.removeEnemigo(buzzy);
		
	}

	@Override
	public void visitar(Spiny spiny) {
	
	}

	@Override
	public void visitar(Goomba goomba) {
		int puntosGanados = goomba.getPuntosOtorgadosPorEliminacion();
		ContextoMario contexto = miEntidad.getContext();
		contexto.ganarPuntos(puntosGanados);
		Nivel nivel = goomba.getNivel();
		nivel.removeEnemigo(goomba);
	}

	@Override
	public void visitar(KoopaCaparazonEstatico koopaEstatico) {
		ContextoKoopaTroopa contexto = koopaEstatico.getContext();
		EstadoKoopa estado = new KoopaCaparazonMovil();
		contexto.cambiarEstado(estado);
	}

	@Override
	public void visitar(KoopaCaparazonMovil koopaMovil) {
		ContextoKoopaTroopa contexto = koopaMovil.getContext();
		int puntosGanados = contexto.getPuntosOtorgadosPorEliminacion();
		ContextoMario contextoM = miEntidad.getContext();
		contextoM.ganarPuntos(puntosGanados);
		contexto.getNivel().removeEnemigo(contexto);
		
	}

	@Override
	public void visitar(KoopaDefault koopaDefault) {
		ContextoKoopaTroopa contexto = koopaDefault.getContext();
		EstadoKoopa estado = new KoopaCaparazonEstatico();
		contexto.cambiarEstado(estado);
		
	}

	@Override
	public void visitar(Lakitu lakitu) {
		int puntosGanados = lakitu.getPuntosOtorgadosPorEliminacion();
		ContextoMario contexto = miEntidad.getContext();
		contexto.ganarPuntos(puntosGanados);
		Nivel nivel = lakitu.getNivel();
		nivel.removeEnemigo(lakitu);
		
	}

	@Override
	public void visitar(PiranhaPlant planta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitar(Fireball fireball) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitar(SuperChampinion superChamp) {
		ContextoMario contexto = miEntidad.getContext();
		EstadoMario estado = new SuperMario();
		contexto.cambiarEstado(estado);
		int puntosGandos = superChamp.obtenerPuntosPorFuego();
		contexto.ganarPuntos(puntosGandos);
		
	}

	@Override
	public void visitar(FlorDeFuego flor) {
		ContextoMario contexto = miEntidad.getContext();
		int puntosGandos = flor.obtenerPuntosPorFuego();
		contexto.ganarPuntos(puntosGandos);
		
	}

	@Override
	public void visitar(ChampinionVerde champVerde) {
		ContextoMario contexto = miEntidad.getContext();
		contexto.ganarVida();
		int puntosGandos = champVerde.obtenerPuntosPorDefault();
		contexto.ganarPuntos(puntosGandos);
	}

	@Override
	public void visitar(Estrella estrella) {
		ContextoMario contexto = miEntidad.getContext();
		EstadoMario estado = new MarioInvulnerable();
		contexto.cambiarEstado(estado);
		int puntosGandos = estrella.obtenerPuntosPorDefault();
		contexto.ganarPuntos(puntosGandos);
	}

	@Override
	public void visitar(Monedas moneda) {
		ContextoMario contexto = miEntidad.getContext();
		int puntosGandos = moneda.obtenerPuntosPorDefault();
		contexto.ganarPuntos(puntosGandos);
	}

	@Override
	public void visitar(MarioDefault marioNormal) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitar(MarioInvulnerable marioInv) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitar(MarioFuego marioFuego) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitar(SuperMario superMario) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitar(BloqueDePregunta bloquePregunta) {
		if (!bloquePregunta.estaVacio()) 
			bloquePregunta.liberarPowerUp();
		Nivel nivel = bloquePregunta.getNivel();
		nivel.removePlataforma(bloquePregunta);
	}

	@Override
	public void visitar(Ladrillo ladrillo) {
		Nivel nivel = ladrillo.getNivel();
		nivel.removePlataforma(ladrillo);
		
	}

	@Override
	public void visitar(Vacio vacio) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitar(PrincesaPeach princesa) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitar(Bandera bandera) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitar(Tuberia tuberia) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitar(BloqueSolido bloqueSolido) {
		// TODO Auto-generated method stub
		

	}


	@Override
	public void visitar(ContextoMario contextoMario) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitar(ContextoKoopaTroopa contextoKoopa) {
		// TODO Auto-generated method stub
		
	}
}
