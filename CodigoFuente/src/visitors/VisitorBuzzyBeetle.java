package visitors;

import elementos.enemigos.*;
import elementos.entidades.Fireball;
import elementos.personajes.*;
import elementos.plataformas.*;
import elementos.powerUps.*;

public class VisitorBuzzyBeetle implements Visitante{
	
	protected BuzzyBeetle miEntidad;
	
	public VisitorBuzzyBeetle (BuzzyBeetle miEntidad) {
		this.miEntidad = miEntidad;
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
		
	}

	
	public void visitar(FlorDeFuego flor) {
		
	}

	
	public void visitar(ChampinionVerde champVerde) {
		
	}

	
	public void visitar(Estrella estrella) {
		
	}

	@Override
	public void visitar(Monedas moneda) {
		
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


	
	public void visitar(ContextoKoopaTroopa contextoKoopa) {
		
	}

	
}
