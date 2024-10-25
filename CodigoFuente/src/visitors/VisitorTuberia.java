package visitors;
import elementos.enemigos.*;
import elementos.entidades.Fireball;
import elementos.personajes.*;
import elementos.plataformas.*;
import elementos.powerUps.*;
public class VisitorTuberia implements Visitante {
	
	private Tuberia miEntidad;

	protected DetectorDireccionColision detectorDireccionColision;

	
	public VisitorTuberia(Tuberia miEntidad) {
		this.miEntidad = miEntidad;
		this.detectorDireccionColision = new DetectorDireccionColision();
	}

	@Override
	public void visitar(BuzzyBeetle buzzy) {
		detectorDireccionColision.verificarColision(miEntidad, buzzy);
	}

	@Override
	public void visitar(Spiny spiny) {
		detectorDireccionColision.verificarColision(miEntidad, spiny);
	}

	@Override
	public void visitar(Goomba goomba) {
		detectorDireccionColision.verificarColision(miEntidad, goomba);
	}

	@Override
	public void visitar(Lakitu lakitu) {}

	@Override
	public void visitar(PiranhaPlant planta) {}

	@Override
	public void visitar(Fireball fireball) {
		detectorDireccionColision.verificarColision(miEntidad, fireball);
	}

	@Override
	public void visitar(SuperChampinion superChamp) {
		detectorDireccionColision.verificarColision(miEntidad, superChamp);
	}

	@Override
	public void visitar(FlorDeFuego flor) {}

	@Override
	public void visitar(ChampinionVerde champVerde) {
		detectorDireccionColision.verificarColision(miEntidad, champVerde);
	}

	@Override
	public void visitar(Estrella estrella) {
		detectorDireccionColision.verificarColision(miEntidad, estrella);
	}

	@Override
	public void visitar(Monedas moneda) {}

	@Override
	public void visitar(BloqueDePregunta bloquePregunta) {}

	@Override
	public void visitar(Ladrillo ladrillo) {}

	@Override
	public void visitar(Vacio vacio) {}

	@Override
	public void visitar(PrincesaPeach princesa) {}

	@Override
	public void visitar(Bandera bandera) {}

	@Override
	public void visitar(Tuberia tuberia) {}

	@Override
	public void visitar(BloqueSolido bloqueSolido) {}
	
	@Override
	public void visitar(ContextoMario contextoMario) {
		detectorDireccionColision.verificarColision(miEntidad, contextoMario);
	}

	@Override
	public void visitar(ContextoKoopaTroopa contextoKoopa) {
		detectorDireccionColision.verificarColision(miEntidad, contextoKoopa);
	}

	@Override
	public void visitar(KoopaEnCaparazon koopaEnCaparazon) {}

	@Override
	public void visitar(KoopaDefault koopaDefault) {}

	@Override
	public void visitar(MarioDefault marioDefault) {}

	@Override
	public void visitar(SuperMario superMario) {}

	@Override
	public void visitar(MarioFuego marioFuego) {}

	@Override
	public void visitar(MarioInvulnerable marioInvulnerable) {}

	@Override
	public void visitar(Piso piso) {}
	
}

