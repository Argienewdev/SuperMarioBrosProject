package visitors;
import elementos.enemigos.*;
import elementos.entidades.Fireball;
import elementos.personajes.*;
import elementos.plataformas.*;
import elementos.powerUps.*;
public class VisitorChampinionVerde implements Visitante {
	
	public VisitorChampinionVerde() {
		
	}

	
	public void visitarBuzzyBeetle(BuzzyBeetle buzzy) {
		
		
	}

	
	public void visitarSpiny(Spiny spiny) {
		
		
	}

	
	public void visitarGoomba(Goomba goomba) {
		
		
	}

	
	public void visitarKoopaCaparazonEstatico(KoopaCaparazonEstatico koopaEstatico) {
		
		
	}

	
	public void visitarKoopaCaparazonMovil(KoopaCaparazonMovil koopaMovil) {
		
		
	}

	
	public void visitarKoopaDefault(KoopaDefault koopaDefault) {
		
		
	}

	
	public void visitarLakitu(Lakitu lakitu) {
		
		
	}

	
	public void visitarPiranhaPlant(PiranhaPlant planta) {
		
		
	}

	
	public void visitarFireball(Fireball fireball) {
		
		
	}

	
	public void visitarSuperChampinion(SuperChampinion superChamp) {
		
		
	}

	
	public void visitarFlorDeFuego(FlorDeFuego flor) {
		
		
	}

	
	public void visitarChampinionVerde(ChampinionVerde champVerde) {
		
		
	}

	
	public void visitarEstrella(Estrella estrella) {
		
		
	}

	
	public void visitarMonedas(Monedas moneda) {
		
		
	}

	
	public void visitarMarioDefault(MarioDefault marioNormal) {
		ContextoMario contexto = marioNormal.getContext();
		contexto.ganarVida();
		
	}

	
	public void visitarMarioInvulnerable(MarioInvulnerable marioInv) {
		ContextoMario contexto = marioInv.getContext();
		contexto.ganarVida();
		
	}

	
	public void visitarMarioFuego(MarioFuego marioFuego) {
		ContextoMario contexto = marioFuego.getContext();
		contexto.ganarVida();
		
	}

	
	public void visitarSuperMario(SuperMario superMario) {
		ContextoMario contexto = superMario.getContext();
		contexto.ganarVida();
		
	}

	
	public void visitarBloqueDePregunta(BloqueDePregunta bloquePregunta) {
		
		
	}

	
	public void visitarLadrillo(Ladrillo ladrillo) {
		
		
	}

	
	public void visitarVacio(Vacio vacio) {
		
		
	}

	
	public void visitarPrincesaPeach(PrincesaPeach princesa) {
		
		
	}

	
	public void visitarBandera(Bandera bandera) {
		
		
	}

	
	public void visitarTuberia(Tuberia tuberia) {
		
		
	}

	
	public void visitarBloqueSolido(BloqueSolido bloqueSolido) {
		
		
	}

	
	public void visitarContextoMario(ContextoMario contextoMario) {
		
		
	}

	
	public void visitarContextoKoopaTroopa(ContextoKoopaTroopa contextoKoopa) {
		
		
	}

	
}
