package visitors;

import elementos.enemigos.BuzzyBeetle;
import elementos.enemigos.ContextoKoopaTroopa;
import elementos.enemigos.Enemigo;
import elementos.enemigos.Goomba;
import elementos.enemigos.KoopaEnCaparazon;
import elementos.enemigos.KoopaDefault;
import elementos.enemigos.Lakitu;
import elementos.enemigos.PiranhaPlant;
import elementos.enemigos.Spiny;
import elementos.entidades.Fireball;
import elementos.personajes.ContextoMario;
import elementos.personajes.MarioDefault;
import elementos.personajes.MarioFuego;
import elementos.personajes.MarioInvulnerable;
import elementos.personajes.SuperMario;
import elementos.plataformas.Bandera;
import elementos.plataformas.BloqueDePregunta;
import elementos.plataformas.BloqueSolido;
import elementos.plataformas.Ladrillo;
import elementos.plataformas.Piso;
import elementos.plataformas.PrincesaPeach;
import elementos.plataformas.Tuberia;
import elementos.plataformas.Vacio;
import elementos.powerUps.ChampinionVerde;
import elementos.powerUps.Estrella;
import elementos.powerUps.FlorDeFuego;
import elementos.powerUps.Monedas;
import elementos.powerUps.SuperChampinion;
import juego.Nivel;

public class VisitorContextoMario implements Visitante {
	
	protected ContextoMario miEntidad;
	
	public VisitorContextoMario (ContextoMario miEntidad) {
		this.miEntidad = miEntidad;
	}

	@Override
	public void visitar(BuzzyBeetle buzzy) {
		otorgarPuntosYEliminar(buzzy);
	}

	@Override
	public void visitar(Spiny spiny) {
		//Solo es afectado por FireBall
	}

	@Override
	public void visitar(Goomba goomba) {
		otorgarPuntosYEliminar(goomba);
	}

	public void visitar(ContextoKoopaTroopa ContextoKoopa) {
		ContextoKoopa.getEstado().aceptarVisitante(this);
	}
	@Override
	public void visitar(KoopaEnCaparazon koopaEnCaparazon) {
		otorgarPuntosYEliminar(koopaEnCaparazon.getContext());
	}
	

	@Override
	public void visitar(KoopaDefault koopaDefault) {
		ContextoKoopaTroopa contextoKoopa = koopaDefault.getContext();
		KoopaEnCaparazon nuevoEstado=new KoopaEnCaparazon();
		contextoKoopa.cambiarEstado(nuevoEstado);
	}

	@Override
	public void visitar(Lakitu lakitu) {
		otorgarPuntosYEliminar(lakitu);
	}

	@Override
	public void visitar(PiranhaPlant planta) {
		//Solo es afectado por FireBall
	}

	@Override
	public void visitar(Fireball fireball) {
	}

	@Override
	public void visitar(SuperChampinion superChamp) {
		Nivel nivel = superChamp.getNivel();
		nivel.removePowerUp(superChamp);
		
	}

	@Override
	public void visitar(FlorDeFuego flor) {
		Nivel nivel = flor.getNivel();
		nivel.removePowerUp(flor);
	}

	@Override
	public void visitar(ChampinionVerde champVerde) {
		Nivel nivel = champVerde.getNivel();
		nivel.removePowerUp(champVerde);
	}

	@Override
	public void visitar(Estrella estrella) {
		Nivel nivel = estrella.getNivel();
		nivel.removePowerUp(estrella);
	}

	@Override
	public void visitar(Monedas moneda) {
		Nivel nivel = moneda.getNivel();
		nivel.removePowerUp(moneda);
	}

	@Override
	public void visitar(BloqueDePregunta bloquePregunta) {
		bloquePregunta.aceptarVisitante(miEntidad.getEstado().getVisitor());
	}

	@Override
	public void visitar(Ladrillo ladrillo) {
		ladrillo.aceptarVisitante(miEntidad.getEstado().getVisitor());
	}
	
	
	
	@Override
	public void visitar(Vacio vacio) {
	}

	@Override
	public void visitar(PrincesaPeach princesa) {
	}

	@Override
	public void visitar(Bandera bandera) {
	}

	@Override
	public void visitar(Tuberia tuberia) {
	}

	@Override
	public void visitar(BloqueSolido bloqueSolido) {
	}

	@Override
	public void visitar(ContextoMario contextoMario) {
		
	}

	@Override
	public void visitar(MarioDefault marioDefault) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitar(SuperMario superMario) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitar(MarioFuego marioFuego) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitar(MarioInvulnerable marioInvulnerable) {
		// TODO Auto-generated method stub
		
	}
	
	private void otorgarPuntosYEliminar(Enemigo enemigo) {
		int puntos = enemigo.getPuntosOtorgadosPorEliminacion();
		miEntidad.ganarPuntos(puntos);
		Nivel nivel = enemigo.getNivel();
		nivel.removeEnemigo(enemigo);
	}

	@Override
	public void visitar(Piso piso) {
		// TODO Auto-generated method stub
		
	}
}
