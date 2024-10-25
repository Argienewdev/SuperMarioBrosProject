package visitors;

import elementos.enemigos.BuzzyBeetle;
import elementos.enemigos.ContextoKoopaTroopa;
import elementos.enemigos.Goomba;
import elementos.enemigos.KoopaDefault;
import elementos.enemigos.KoopaEnCaparazon;
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

public class VisitorMarioDefault implements Visitante{

	protected MarioDefault miEstado;
	
	protected DetectorDireccionColision detectorDireccionColision;
	
	private ContextoMario miEntidad;
	
	public VisitorMarioDefault (MarioDefault miEstado) {
		this.miEstado = miEstado;
		this.miEntidad = miEstado.getContext();
		this.detectorDireccionColision = new DetectorDireccionColision();
	}
	
	@Override
	public void visitar(BuzzyBeetle buzzy) {
		
	}

	@Override
	public void visitar(Spiny spiny) {
		
	}

	@Override
	public void visitar(Goomba goomba) {
		
	}

	@Override
	public void visitar(ContextoKoopaTroopa contextoKoopa) {
		
	}

	@Override
	public void visitar(KoopaEnCaparazon koopaEnCaparazon) {

	}

	@Override
	public void visitar(KoopaDefault koopaDefault) {
	}

	@Override
	public void visitar(Lakitu lakitu) {
	}

	@Override
	public void visitar(PiranhaPlant planta) {
	}

	@Override
	public void visitar(Fireball fireball) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitar(SuperChampinion superChamp) {
	}

	@Override
	public void visitar(FlorDeFuego flor) {
	}

	@Override
	public void visitar(ChampinionVerde champVerde) {
	}

	@Override
	public void visitar(Estrella estrella) {
	}

	@Override
	public void visitar(Monedas monedas) {
	}

	@Override
	public void visitar(BloqueDePregunta bloquePregunta) {
		if(detectorDireccionColision.choquePorAbajo(bloquePregunta, miEntidad)) {
			bloquePregunta.liberarPowerUp();
		}
	}

	@Override
	public void visitar(Ladrillo ladrillo) {
	}

	@Override
	public void visitar(Piso piso) {
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
		// TODO Auto-generated method stub
		
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

}
