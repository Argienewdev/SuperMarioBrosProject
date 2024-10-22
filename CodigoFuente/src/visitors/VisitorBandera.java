package visitors;

import elementos.enemigos.*;
import elementos.entidades.Fireball;
import elementos.personajes.*;
import elementos.plataformas.*;
import elementos.powerUps.*;
import ventanas.ControladorVistas;



public class VisitorBandera implements Visitante{
	
	private ControladorVistas controlador;
	
	public VisitorBandera (ControladorVistas controlador) {
		this.controlador = controlador;
	}

	public void visitar(BuzzyBeetle buzzy) {	
	}

	public void visitar(Spiny spiny) {	
	}

	public void visitar(Goomba goomba) {	
	}
	
	public void visitar(ContextoKoopaTroopa koopaEstatico) {	
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
		controlador.cambiarNivel();
	}
	
	public void visitar(MarioInvulnerable marioInv) {		
		controlador.cambiarNivel();
		EstadoMario estado = new MarioDefault();
		marioInv.getContext().cambiarEstado(estado);
	}

	public void visitar(MarioFuego marioFuego) {
		controlador.cambiarNivel();
		EstadoMario estado = new MarioDefault();
		marioFuego.getContext().cambiarEstado(estado);
	}

	public void visitar(SuperMario superMario) {
		controlador.cambiarNivel();
		EstadoMario estado = new MarioDefault();
		superMario.getContext().cambiarEstado(estado);
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
	}
	
	
}