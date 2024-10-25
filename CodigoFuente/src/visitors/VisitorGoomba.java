package visitors;
import elementos.enemigos.*;
import elementos.entidades.Fireball;
import elementos.personajes.*;
import elementos.plataformas.*;
import elementos.powerUps.*;
public class VisitorGoomba implements Visitante {
	
	protected Goomba miEntidad;
	
	DetectorDireccionColision detectorDireccionColision;
	
	public VisitorGoomba (Goomba miEntidad) {
		this.miEntidad = miEntidad;
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
		detectorDireccionColision.verificarColisionEntreEntidades(miEntidad, goomba);
	}

	@Override
	public void visitar(Lakitu lakitu) {
		// TODO Auto-generated method stub
		
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
	public void visitar(Monedas moneda) {
	}
	
	@Override
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
				//TODO hay que matar a mario...
			}else {
				contextoMario.perderVida();
			}
		}
	}
	
	@Override
	public void visitar(SuperMario superMario) {
		ContextoMario contextoMario = superMario.getContext();
		EstadoMario nuevoEstado= new MarioDefault();
		contextoMario.cambiarEstado(nuevoEstado);
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

