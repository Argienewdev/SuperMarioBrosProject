package visitors;
import elementos.enemigos.*;
import elementos.entidades.Fireball;
import elementos.personajes.*;
import elementos.plataformas.*;
import elementos.powerUps.*;
import juego.Nivel;
public class VisitorMarioInvulnerable implements Visitante {
	
	protected MarioInvulnerable miEntidad;
	
	@SuppressWarnings("exports")
	public VisitorMarioInvulnerable (MarioInvulnerable miEntidad) {
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
		int puntosGanados = spiny.getPuntosOtorgadosPorEliminacion();
		ContextoMario contexto = miEntidad.getContext();
		contexto.ganarPuntos(puntosGanados);
		Nivel nivel = spiny.getNivel();
		nivel.removeEnemigo(spiny);
		
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
		int puntosGanados = contexto.getPuntosOtorgadosPorEliminacion();
		ContextoMario contextoM = miEntidad.getContext();
		contextoM.ganarPuntos(puntosGanados);
		contexto.getNivel().removeEnemigo(contexto);
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
		int puntosGanados = contexto.getPuntosOtorgadosPorEliminacion();
		ContextoMario contextoM = miEntidad.getContext();
		contextoM.ganarPuntos(puntosGanados);
		contexto.getNivel().removeEnemigo(contexto);
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
		int puntosGanados = planta.getPuntosOtorgadosPorEliminacion();
		ContextoMario contexto = miEntidad.getContext();
		contexto.ganarPuntos(puntosGanados);
		Nivel nivel = planta.getNivel();
		nivel.removeEnemigo(planta);
		
	}

	@Override
	public void visitar(Fireball fireball) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitar(SuperChampinion superChamp) {
		Nivel nivel = superChamp.getNivel();
		nivel.removePowerUps(superChamp);
	}

	@Override
	public void visitar(FlorDeFuego flor) {
		Nivel nivel = flor.getNivel();
		nivel.removePowerUps(flor);
	}

	@Override
	public void visitar(ChampinionVerde champVerde) {
		Nivel nivel = champVerde.getNivel();
		nivel.removePowerUps(champVerde);
		
	}

	@Override
	public void visitar(Estrella estrella) {
		Nivel nivel = estrella.getNivel();
		nivel.removePowerUps(estrella);
		
	}

	@Override
	public void visitar(Monedas moneda) {
		Nivel nivel = moneda.getNivel();
		nivel.removePowerUps(moneda);
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitar(Ladrillo ladrillo) {
		// TODO Auto-generated method stub
		
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

