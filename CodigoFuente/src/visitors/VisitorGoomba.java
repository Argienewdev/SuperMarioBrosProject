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
		detectorDireccionColision= new DetectorDireccionColision(miEntidad);
	}

	@Override
	public void visitar(BuzzyBeetle buzzy) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitar(Spiny spiny) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitar(Goomba goomba) {
		// TODO Auto-generated method stub
		
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitar(FlorDeFuego flor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitar(ChampinionVerde champVerde) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitar(Estrella estrella) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitar(Monedas moneda) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void visitar(ContextoMario contextoMario) {
		/*
		if(detectorDireccionColision.choquePorDerecha(contextoMario)||detectorDireccionColision.choquePorIzquierda(contextoMario)) {
			contextoMario.getEstado().aceptarVisitante(this);
		}*/
	}
	@Override
	public void visitar(MarioDefault marioDefault) {
		ContextoMario contextoMario = marioDefault.getContext();
		if (contextoMario.getVidas() == 1) {
			int perdidaPuntos = miEntidad.getPuntosSustraidosPorMuerteCausada();
			contextoMario.perderPuntos(perdidaPuntos);
		}
		contextoMario.perderVida();
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitar(Ladrillo ladrillo) {
		
		
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
	public void visitar(ContextoKoopaTroopa contextoKoopa) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitar(KoopaEnCaparazon koopaEnCaparazon) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitar(KoopaDefault koopaDefault) {
		// TODO Auto-generated method stub
		
	}
	private boolean choquePorDerecha(BloqueSolido bloque) {
		boolean parte1 = miEntidad.obtenerHitbox().x + miEntidad.obtenerHitbox().width > bloque.obtenerHitbox().x;
		boolean parte2 = !(miEntidad.getPosicion().x + miEntidad.obtenerAncho() > bloque.getPosicion().x);
		return parte1 && parte2;
	}
	
	private boolean choquePorIzquierda(BloqueSolido bloque) {
		boolean parte1 = miEntidad.obtenerHitbox().x < bloque.obtenerHitbox().x + bloque.obtenerHitbox().width;
		boolean parte2 = !(miEntidad.getPosicion().x < bloque.getPosicion().x + bloque.obtenerAncho());
		return parte1 && parte2;
	}

	@Override
	public void visitar(Piso piso) {
		// TODO Auto-generated method stub
		
	}
	
}

