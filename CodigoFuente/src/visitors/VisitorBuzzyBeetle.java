package visitors;

import elementos.enemigos.*;
import elementos.entidades.Fireball;
import elementos.personajes.*;
import elementos.plataformas.*;
import elementos.powerUps.*;

public class VisitorBuzzyBeetle implements Visitante{
	
	protected BuzzyBeetle miEntidad;
	
	protected DetectorDireccionColision detectorDireccionColision;
	
	public VisitorBuzzyBeetle (BuzzyBeetle miEntidad) {
		this.miEntidad = miEntidad;
		this.detectorDireccionColision = new DetectorDireccionColision();
	}
	
	public void visitar(BuzzyBeetle buzzy) {
		
	}
	
	public void visitar(Spiny spiny) {
	
	}

	
	public void visitar(Goomba goomba) {
	}
	
	public void visitar(Lakitu lakitu) {
	}
	
	public void visitar(PiranhaPlant planta) {
		
	}

	
	public void visitar(Fireball fireball) {
	}

	
	public void visitar(SuperChampinion superChamp) {
	}

	public void visitar(FlorDeFuego flor) {
	}

	public void visitar(ChampinionVerde champVerde) {
	}
	
	public void visitar(Estrella estrella) {
	}

	@Override
	public void visitar(Monedas moneda) {
		
	}
	public void visitar(ContextoMario contextoMario) {
		contextoMario.getEstado().aceptarVisitante(this);
	}
	@Override
	public void visitar(MarioDefault marioDefault) {
		if(detectorDireccionColision.choquePorDerecha(marioDefault.getContext(), miEntidad) || detectorDireccionColision.choquePorIzquierda(marioDefault.getContext(), miEntidad)) {
			ContextoMario contextoMario = marioDefault.getContext();
			if (contextoMario.getVidas() == 1) {
				int perdidaPuntos = miEntidad.getPuntosSustraidosPorMuerteCausada();
				contextoMario.perderPuntos(perdidaPuntos);
			}
			contextoMario.perderVida();
		}
	}
	
	@Override
	public void visitar(SuperMario superMario) {
		if(detectorDireccionColision.choquePorDerecha(superMario.getContext(), miEntidad) || detectorDireccionColision.choquePorIzquierda(superMario.getContext(), miEntidad)) {
			ContextoMario contextoMario = superMario.getContext();
			EstadoMario nuevoEstado= new MarioDefault();
			contextoMario.cambiarEstado(nuevoEstado);
		}
	}

	@Override
	public void visitar(MarioFuego marioFuego) {
		ContextoMario contextoMario = marioFuego.getContext();
		EstadoMario nuevoEstado= new MarioDefault();
		contextoMario.cambiarEstado(nuevoEstado);
	}
	
	@Override
	public void visitar(MarioInvulnerable marioInvulnerable) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitar(BloqueDePregunta bloquePregunta) {
	}

	@Override
	public void visitar(Ladrillo ladrillo) {
	}

	@Override
	public void visitar(Piso piso) {
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
	}

	@Override
	public void visitar(Tuberia tuberia) {
	}

	@Override
	public void visitar(BloqueSolido bloqueSolido) {
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

}
