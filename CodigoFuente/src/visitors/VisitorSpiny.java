package visitors;

import elementos.enemigos.*;
import elementos.entidades.BolaDeFuego;
import elementos.personajes.*;
import elementos.plataformas.*;
import elementos.powerUps.*;

public class VisitorSpiny implements Visitante {
	
	protected Spiny miEntidad;
	
	public VisitorSpiny(Spiny miEntidad) {
		this.miEntidad = miEntidad;
	}

	@Override
	public void visitarBuzzyBeetle(BuzzyBeetle buzzyBeetle) {
		//No se colisionan nunca
	}

	@Override
	public void visitarSpiny(Spiny spiny) {
		//No se colisionan nunca
	}

	@Override
	public void visitarGoomba(Goomba goomba) {
		//No se colisionan nunca
		
	}

	@Override
	public void visitarLakitu(Lakitu lakitu) {
		//No se colisionan nunca
		
	}

	@Override
	public void visitarPiranhaPlant(PiranhaPlant piranhaPlant) {
		//No se colisionan nunca
		
	}

	@Override
	public void visitarSuperChampinion(SuperChampinion superChampinion) {
		
	}

	@Override
	public void visitarFlorDeFuego(FlorDeFuego florDeFuego) {
		
	}

	@Override
	public void visitarChampinionVerde(ChampinionVerde champinionVerde) {
		
	}

	@Override
	public void visitarEstrella(Estrella estrella) {
		
	}

	@Override
	public void visitarMonedas(Monedas monedas) {
		
	}

	@Override
	public void visitarBloqueDePregunta(BloqueDePregunta bloqueDePregunta) {
		
	}

	@Override
	public void visitarLadrillo(Ladrillo ladrillo) {
		
	}

	@Override
	public void visitarPrincesaPeach(PrincesaPeach princesaPeach) {
		
	}

	@Override
	public void visitarBandera(Bandera bandera) {
		
	}

	@Override
	public void visitarTuberia(Tuberia tuberia) {
		
	}

	@Override
	public void visitarBloqueSolido(BloqueSolido bloqueSolido) {
	}

	@Override
	public void visitarContextoMario(ContextoMario contextoMario) {
		contextoMario.getEstado().aceptarVisitante(this);
	}

	@Override
	public void visitarKoopaEnCaparazon(KoopaEnCaparazon koopaEnCaparazon) {
		
	}

	@Override
	public void visitarKoopaDefault(KoopaDefault koopaDefault) {
		
	}

	@Override
	public void visitarMarioDefault(MarioDefault marioDefault) {
		ContextoMario contextoMario = marioDefault.getContext();
		if (contextoMario.getVidas() == 1) {
			int perdidaPuntos = this.miEntidad.getPuntosSustraidosPorMuerteCausada();
			contextoMario.perderPuntos(perdidaPuntos);
		}
		contextoMario.perderVida();
	}
	
	@Override
	public void visitarSuperMario(SuperMario superMario) {
		ContextoMario contextoMario = superMario.getContext();
		EstadoMario nuevoEstado = new MarioDefault();
		contextoMario.cambiarEstado(nuevoEstado);
	}

	@Override
	public void visitarMarioFuego(MarioFuego marioFuego) {
		ContextoMario contextoMario = marioFuego.getContext();
		EstadoMario nuevoEstado = new MarioDefault();
		contextoMario.cambiarEstado(nuevoEstado);
	}
	
	@Override
	public void visitarMarioInvulnerable(MarioInvulnerable marioInvulnerable) {
	}
	
	public void visitarMarioRecuperacion(MarioRecuperacion marioRecuperacion) {}

	@Override
	public void visitarPiso(Piso piso) {
	}

	@Override
	public void visitarContextoKoopaTroopa(ContextoKoopaTroopa contextoKoopaTroopa) {
	}

	@Override
	public void visitarBolaDeFuego(BolaDeFuego bolaDeFuego) {
		bolaDeFuego.eliminarDelNivel();
	}
	
}
