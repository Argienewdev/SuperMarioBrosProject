package visitors;

import elementos.ElementoDeJuego;
import elementos.enemigos.BuzzyBeetle;
import elementos.enemigos.ContextoKoopaTroopa;
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
import elementos.plataformas.PrincesaPeach;
import elementos.plataformas.Tuberia;
import elementos.plataformas.Vacio;
import elementos.powerUps.ChampinionVerde;
import elementos.powerUps.Estrella;
import elementos.powerUps.FlorDeFuego;
import elementos.powerUps.Monedas;
import elementos.powerUps.SuperChampinion;

public class VisitorContextoKoopaTroopa implements Visitante {
	
	protected ContextoKoopaTroopa miEntidad;
	
	public VisitorContextoKoopaTroopa (ContextoKoopaTroopa miEntidad) {
		this.miEntidad = miEntidad;
	}

	@Override
	public void visitar(BuzzyBeetle buzzy) {
		aVisitorConcreto(buzzy);
		
	}

	@Override
	public void visitar(Spiny spiny) {
		aVisitorConcreto(spiny);
		
	}

	@Override
	public void visitar(Goomba goomba) {
		aVisitorConcreto(goomba);
	}


	@Override
	public void visitar(Lakitu lakitu) {
		aVisitorConcreto(lakitu);
	}

	@Override
	public void visitar(PiranhaPlant planta) {
		aVisitorConcreto(planta);
	}

	@Override
	public void visitar(Fireball fireball) {
		aVisitorConcreto(fireball);
	}

	@Override
	public void visitar(SuperChampinion superChamp) {
		aVisitorConcreto(superChamp);
		
	}

	@Override
	public void visitar(FlorDeFuego flor) {
		aVisitorConcreto(flor);
	}

	@Override
	public void visitar(ChampinionVerde champVerde) {
		aVisitorConcreto(champVerde);
	}

	@Override
	public void visitar(Estrella estrella) {
		aVisitorConcreto(estrella);
	}

	@Override
	public void visitar(Monedas monedas) {
		aVisitorConcreto(monedas);
	}

	@Override
	public void visitar(ContextoMario contextoMario) {
		MarioDefault estadoDefault= new MarioDefault();
		estadoDefault.setContext(contextoMario);
		SuperMario estadoSuper= new SuperMario();
		estadoSuper.setContext(contextoMario);
		MarioFuego estadoFuego= new MarioFuego();
		estadoFuego.setContext(contextoMario);
		MarioInvulnerable estadoInvulnerable= new MarioInvulnerable();
		estadoInvulnerable.setContext(contextoMario);
		
		if(contextoMario.getEstado().equals(estadoDefault)) {
			if (contextoMario.getVidas() == 1) {
				int perdidaPuntos = miEntidad.getPuntosSustraidosPorMuerteCausada();
				contextoMario.perderPuntos(perdidaPuntos);
			}
			contextoMario.perderVida();
		}else if(contextoMario.getEstado().equals(estadoSuper)|| contextoMario.getEstado().equals(estadoFuego)){
			contextoMario.cambiarEstado(estadoDefault);
		}
	}

	@Override
	public void visitar(BloqueDePregunta bloquePregunta) {
		aVisitorConcreto(bloquePregunta);
		
	}

	@Override
	public void visitar(Ladrillo ladrillo) {
		aVisitorConcreto(ladrillo);
	}

	@Override
	public void visitar(Vacio vacio) {
		aVisitorConcreto(vacio);
	}

	@Override
	public void visitar(PrincesaPeach princesa) {
		aVisitorConcreto(princesa);
	}

	@Override
	public void visitar(Bandera bandera) {
		aVisitorConcreto(bandera);
	}

	@Override
	public void visitar(Tuberia tuberia) {
		aVisitorConcreto(tuberia);
	}

	@Override
	public void visitar(BloqueSolido bloqueSolido) {
		aVisitorConcreto(bloqueSolido);
	}

	

	@Override
	public void visitar(ContextoKoopaTroopa contextoKoopa) {
		aVisitorConcreto(contextoKoopa);
	}
	
	private void aVisitorConcreto (ElementoDeJuego elemento) {
		miEntidad.aceptarVisitante(elemento.getVisitor());
		elemento.aceptarVisitante(miEntidad.getVisitor());
	}
}