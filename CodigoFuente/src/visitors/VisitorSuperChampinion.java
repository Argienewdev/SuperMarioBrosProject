package visitors;
import elementos.enemigos.*;
import elementos.entidades.Fireball;
import elementos.personajes.*;
import elementos.plataformas.*;
import elementos.powerUps.*;
public class VisitorSuperChampinion implements Visitante {
	
	protected SuperChampinion miEntidad;
	
	protected DetectorDireccionColision detectarDireccionColision;
	
	public VisitorSuperChampinion (SuperChampinion miEntidad) {
		this.miEntidad = miEntidad;
		this.detectarDireccionColision= new DetectorDireccionColision(miEntidad);
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
		contextoMario.getEstado().aceptarVisitante(this);
	}
	
	@Override
	public void visitar(MarioDefault marioDefault) {
		ContextoMario contextoMario= marioDefault.getContext();
		EstadoMario nuevoEstado=new SuperMario();
		contextoMario.cambiarEstado(nuevoEstado);
		contextoMario.ganarPuntos(miEntidad.obtenerPuntosPorDefault());
	}

	@Override
	public void visitar(SuperMario superMario) {
		ContextoMario contextoMario= superMario.getContext();
		contextoMario.ganarPuntos(miEntidad.obtenerPuntosPorSuper());
	}

	@Override
	public void visitar(MarioFuego marioFuego) {
		ContextoMario contextoMario= marioFuego.getContext();
		contextoMario.ganarPuntos(miEntidad.obtenerPuntosPorFuego());
	}

	@Override
	public void visitar(MarioInvulnerable marioInvulnerable) {
		ContextoMario contextoMario = marioInvulnerable.getContext();
		contextoMario.ganarPuntos(miEntidad.obtenerPuntosPorInvulnerable());
	}

	@Override
	public void visitar(BloqueDePregunta bloquePregunta) {
		if (detectarDireccionColision.choquePorDerecha(bloquePregunta) || detectarDireccionColision.choquePorIzquierda(bloquePregunta)) {
			miEntidad.retrotraerMovimientoHorizontal();
		}
		if(detectarDireccionColision.choquePorArriba(bloquePregunta)) {
			miEntidad.setColisionAbajo(true);
			miEntidad.retrotraerMovimientoVertical(bloquePregunta.obtenerHitbox().y - miEntidad.obtenerHitbox().height);
		}
		if(detectarDireccionColision.choquePorAbajo(bloquePregunta)){
			miEntidad.setColisionArriba(true);
			miEntidad.retrotraerMovimientoVertical(bloquePregunta.obtenerHitbox().y + miEntidad.obtenerHitbox().height); 
		}
	}

	@Override
	public void visitar(Ladrillo ladrillo) {
		if (detectarDireccionColision.choquePorDerecha(ladrillo) || detectarDireccionColision.choquePorIzquierda(ladrillo)) {
			miEntidad.retrotraerMovimientoHorizontal();
		}
		if(detectarDireccionColision.choquePorArriba(ladrillo)) {
			miEntidad.setColisionAbajo(true);
			miEntidad.retrotraerMovimientoVertical(ladrillo.obtenerHitbox().y - miEntidad.obtenerHitbox().height);
		}
		if(detectarDireccionColision.choquePorAbajo(ladrillo)){
			miEntidad.setColisionArriba(true);
			miEntidad.retrotraerMovimientoVertical(ladrillo.obtenerHitbox().y + miEntidad.obtenerHitbox().height); 
		}
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
		if (detectarDireccionColision.choquePorDerecha(bloqueSolido) || detectarDireccionColision.choquePorIzquierda(bloqueSolido)) {
			miEntidad.retrotraerMovimientoHorizontal();
		}
		if(detectarDireccionColision.choquePorArriba(bloqueSolido)) {
			miEntidad.setColisionAbajo(true);
			miEntidad.retrotraerMovimientoVertical(bloqueSolido.obtenerHitbox().y - miEntidad.obtenerHitbox().height);
		}
		if(detectarDireccionColision.choquePorAbajo(bloqueSolido)){
			miEntidad.setColisionArriba(true);
			miEntidad.retrotraerMovimientoVertical(bloqueSolido.obtenerHitbox().y + miEntidad.obtenerHitbox().height); 
		}
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

	@Override
	public void visitar(Piso piso) {
		if (detectarDireccionColision.choquePorDerecha(piso) || detectarDireccionColision.choquePorIzquierda(piso)) {
			miEntidad.retrotraerMovimientoHorizontal();
		}
		if(detectarDireccionColision.choquePorArriba(piso)) {
			miEntidad.setColisionAbajo(true);
			miEntidad.retrotraerMovimientoVertical(piso.obtenerHitbox().y - miEntidad.obtenerHitbox().height);
		}
		if(detectarDireccionColision.choquePorAbajo(piso)){
			miEntidad.setColisionArriba(true);
			miEntidad.retrotraerMovimientoVertical(piso.obtenerHitbox().y + miEntidad.obtenerHitbox().height); 
		}
	}
	
}
