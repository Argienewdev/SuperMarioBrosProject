package visitors;

import elementos.enemigos.*;
import elementos.entidades.Fireball;
import elementos.personajes.*;
import elementos.plataformas.*;
import elementos.powerUps.*;

public class VisitorPiso implements Visitante{

	private Piso miEntidad;
	
	protected DetectorDireccionColision detectorDireccionColision;
	
	public VisitorPiso(Piso miEntidad) {
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
		detectorDireccionColision.verificarColision(miEntidad, superChamp);
	}
	
	public void visitar(FlorDeFuego flor) {		
	}

	public void visitar(ChampinionVerde champVerde) {	
	}
	
	public void visitar(Estrella estrella) {	
	}
	
	public void visitar(Monedas monedas) {
		
	}
	
	public void visitar(MarioDefault marioNormal) {
		detectorDireccionColision.verificarColision(miEntidad, marioNormal.getContext());
	}
	
	public void visitar(MarioInvulnerable marioInv) {
		detectorDireccionColision.verificarColision(miEntidad, marioInv.getContext());
	}

	public void visitar(MarioFuego marioFuego) {
		detectorDireccionColision.verificarColision(miEntidad, marioFuego.getContext());
	}

	public void visitar(SuperMario superMario) {
		detectorDireccionColision.verificarColision(miEntidad, superMario.getContext());
	}

	public void visitar(BloqueDePregunta bloquePregunta) {		
	}

	public void visitar(Ladrillo ladrillo) {	
	}
	
	public void visitar(Vacio vacio) {	
	}
	
	public void visitar(PrincesaPeach princesa) {
	}

	public void visitar(Bandera bandera) {
	}
	
	public void visitar(Tuberia tuberia) {	
	}

	public void visitar(BloqueSolido bloqueSolido) {		
	}

	public void visitar(ContextoMario contextoMario) {		
		detectorDireccionColision.verificarColision(miEntidad, contextoMario);
	}
	
	public void visitar(ContextoKoopaTroopa contextoKoopa) {	
	}

	@Override
	public void visitar(KoopaEnCaparazon koopaEnCaparazon) {
	}

	@Override
	public void visitar(KoopaDefault koopaDefault) {
	}

	@Override
	public void visitar(Piso piso) {
	}

}
