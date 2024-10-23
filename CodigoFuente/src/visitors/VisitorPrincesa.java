package visitors;
import elementos.enemigos.*;
import elementos.entidades.Fireball;
import elementos.personajes.*;
import elementos.plataformas.*;
import elementos.powerUps.*;
import ventanas.ControladorVistas;
public class VisitorPrincesa implements Visitante {
	
	protected ControladorVistas controlador;
	
	public VisitorPrincesa (ControladorVistas controlador) {
		this.controlador = controlador;
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
		controlador.mostrarPantallaFinal();		
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

