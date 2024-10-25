package visitors;

import elementos.enemigos.*;
import elementos.entidades.Fireball;
import elementos.personajes.*;
import elementos.plataformas.*;
import elementos.powerUps.*;
import ventanas.ControladorVistas;



public class VisitorBandera implements Visitante {
	
	private Bandera miEntidad;
	
	private ControladorVistas controlador;
	
	public VisitorBandera (ControladorVistas controlador, Bandera miEntidad) {
		this.controlador = controlador;
		this.miEntidad = miEntidad;
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
	public void visitar(ContextoMario contextoMario) {
		contextoMario.getEstado().aceptarVisitante(this);
	}
	@Override
	public void visitar(MarioDefault marioDefault) {
		controlador.cambiarNivel();
	}
	
	public void visitar(MarioInvulnerable marioInv) {		
		controlador.cambiarNivel();
	}

	public void visitar(MarioFuego marioFuego) {
		controlador.cambiarNivel();
	}

	public void visitar(SuperMario superMario) {
		controlador.cambiarNivel();
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