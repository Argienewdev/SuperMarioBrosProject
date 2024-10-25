package visitors;

import elementos.enemigos.*;
import elementos.entidades.Fireball;
import elementos.personajes.*;
import elementos.plataformas.*;
import elementos.powerUps.*;

public class VisitorBloqueDePregunta implements Visitante {
	
	private BloqueDePregunta miEntidad;
	
	protected DetectorDireccionColision detectorDireccionColision;
	
	public VisitorBloqueDePregunta(BloqueDePregunta miEntidad) {
		this.miEntidad = miEntidad;
		this.detectorDireccionColision = new DetectorDireccionColision();
	}

	public void visitar(BuzzyBeetle buzzy) {	
	}

	public void visitar(Spiny spiny) {	
	}

	public void visitar(Goomba goomba) {	
	}
	
	public void visitar(ContextoMario contextoMario) {
		detectorDireccionColision.verificarColision(miEntidad, contextoMario);
	}
	
	public void visitar(ContextoKoopaTroopa contextoKoopa) {	
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
	
	public void visitar(Monedas monedas) {		
	}
	
	public void visitar(MarioDefault marioNormal) {		
	}
	
	public void visitar(MarioInvulnerable marioInv) {		
	}

	public void visitar(MarioFuego marioFuego) {		
	}

	public void visitar(SuperMario superMario) {		
	}

	public void visitar(BloqueDePregunta bloquePregunta) {		
	}

	public void visitar(Ladrillo ladrillo) {	
	}
	
	public void visitar(PrincesaPeach princesa) {
	}

	public void visitar(Bandera bandera) {
	}
	
	public void visitar(Tuberia tuberia) {	
	}

	public void visitar(BloqueSolido bloqueSolido) {		
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
