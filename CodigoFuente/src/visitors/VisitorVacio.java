package visitors;
import elementos.enemigos.*;
import elementos.entidades.Fireball;
import elementos.personajes.*;
import elementos.plataformas.*;
import elementos.powerUps.*;
import juego.Nivel;
public class VisitorVacio implements Visitante {
	
	private Vacio miEntidad;

	public VisitorVacio(Vacio miEntidad) {
		this.miEntidad = miEntidad;
	}

	@Override
	public void visitar(BuzzyBeetle buzzy) {
		Nivel nivel = buzzy.getNivel();
		nivel.removeNoJugable(buzzy);
		
	}

	@Override
	public void visitar(Spiny spiny) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitar(Goomba goomba) {
		Nivel nivel = goomba.getNivel();
		nivel.removeNoJugable(goomba);
	}

	@Override
	public void visitar(ContextoKoopaTroopa contextoKoopa) {
		Nivel nivel =contextoKoopa.getNivel();
		nivel.removeNoJugable(contextoKoopa);		
	}


	@Override
	public void visitar(Lakitu lakitu) {
		Nivel nivel = lakitu.getNivel();
		nivel.removeNoJugable(lakitu);
		
	}

	@Override
	public void visitar(PiranhaPlant planta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitar(Fireball fireball) {
		
	}

	@Override
	public void visitar(SuperChampinion superChamp) {
		Nivel nivel = superChamp.getNivel();
		nivel.removeNoJugable(superChamp);
		
	}

	@Override
	public void visitar(FlorDeFuego flor) {
		Nivel nivel = flor.getNivel();
		nivel.removeNoJugable(flor);
	}

	@Override
	public void visitar(ChampinionVerde champVerde) {
		Nivel nivel = champVerde.getNivel();
		nivel.removeNoJugable(champVerde);
	}

	@Override
	public void visitar(Estrella estrella) {
		Nivel nivel = estrella.getNivel();
		nivel.removeNoJugable(estrella);
		
	}

	@Override
	public void visitar(Monedas moneda) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitar(ContextoMario contextoMario) {
		contextoMario.perderPuntos(15);
		contextoMario.perderVida();
		contextoMario.getEstado().aceptarVisitante(this);
	}
	
	@Override
	public void visitar(MarioDefault marioDefault) {
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
		ContextoMario contextoMario = marioInvulnerable.getContext();
		EstadoMario nuevoEstado= new MarioDefault();
		contextoMario.cambiarEstado(nuevoEstado);
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
	public void visitar(KoopaEnCaparazon koopaEnCaparazon) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitar(KoopaDefault koopaDefault) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitar(Piso piso) {
		// TODO Auto-generated method stub
		
	}


}