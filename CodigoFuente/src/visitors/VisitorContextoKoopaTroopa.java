package visitors;

import elementos.ElementoDeJuego;
import elementos.enemigos.BuzzyBeetle;
import elementos.enemigos.ContextoKoopaTroopa;
import elementos.enemigos.Goomba;
import elementos.enemigos.KoopaCaparazonEstatico;
import elementos.enemigos.KoopaCaparazonMovil;
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
	public void visitar(KoopaCaparazonEstatico koopaEstatico) {
		
	}

	@Override
	public void visitar(KoopaCaparazonMovil koopaMovil) {
		
	}

	@Override
	public void visitar(KoopaDefault koopaDefault) {
		
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
	public void visitar(MarioDefault marioNormal) {
		aVisitorConcreto(marioNormal.getContext());
		
	}

	@Override
	public void visitar(MarioInvulnerable marioInv) {
		aVisitorConcreto(marioInv.getContext());
		
	}

	@Override
	public void visitar(MarioFuego marioFuego) {
		aVisitorConcreto(marioFuego.getContext());
		
	}

	@Override
	public void visitar(SuperMario superMario) {
		aVisitorConcreto(superMario.getContext());
		
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
	public void visitar(ContextoMario contextoMario) {
		
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