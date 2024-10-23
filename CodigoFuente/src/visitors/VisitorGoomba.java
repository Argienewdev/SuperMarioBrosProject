package visitors;
import elementos.enemigos.*;
import elementos.entidades.Fireball;
import elementos.personajes.*;
import elementos.plataformas.*;
import elementos.powerUps.*;
public class VisitorGoomba implements Visitante {
	
	protected Goomba miEntidad;
	
	public VisitorGoomba (Goomba miEntidad) {
		this.miEntidad = miEntidad;
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
	public void visitar(ContextoKoopaTroopa contextoKoopa) {
		// TODO Auto-generated method stub
		
	}
	
}

