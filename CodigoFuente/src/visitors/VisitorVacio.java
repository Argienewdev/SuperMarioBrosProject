package visitors;
import elementos.enemigos.*;
import elementos.entidades.Fireball;
import elementos.personajes.*;
import elementos.plataformas.*;
import elementos.powerUps.*;
import juego.Nivel;
public class VisitorVacio implements Visitante{

	@Override
	public void visitar(BuzzyBeetle buzzy) {
		Nivel nivel = buzzy.getNivel();
		nivel.removeEnemigo(buzzy);
		
	}

	@Override
	public void visitar(Spiny spiny) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitar(Goomba goomba) {
		Nivel nivel = goomba.getNivel();
		nivel.removeEnemigo(goomba);
	}

	@Override
	public void visitar(KoopaCaparazonEstatico koopaEstatico) {
		Nivel nivel = koopaEstatico.getContext().getNivel();
		nivel.removeEnemigo(koopaEstatico.getContext());
		
	}

	@Override
	public void visitar(KoopaCaparazonMovil koopaMovil) {
		Nivel nivel = koopaMovil.getContext().getNivel();
		nivel.removeEnemigo(koopaMovil.getContext());
	}

	@Override
	public void visitar(KoopaDefault koopaDefault) {
		Nivel nivel = koopaDefault.getContext().getNivel();
		nivel.removeEnemigo(koopaDefault.getContext());
	}

	@Override
	public void visitar(Lakitu lakitu) {
		Nivel nivel = lakitu.getNivel();
		nivel.removeEnemigo(lakitu);
		
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
		nivel.removePowerUps(superChamp);
		
	}

	@Override
	public void visitar(FlorDeFuego flor) {
		Nivel nivel = flor.getNivel();
		nivel.removePowerUps(flor);
	}

	@Override
	public void visitar(ChampinionVerde champVerde) {
		Nivel nivel = champVerde.getNivel();
		nivel.removePowerUps(champVerde);
	}

	@Override
	public void visitar(Estrella estrella) {
		Nivel nivel = estrella.getNivel();
		nivel.removePowerUps(estrella);
		
	}

	@Override
	public void visitar(Monedas moneda) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitar(MarioDefault marioNormal) {
		marioNormal.getContext().perderVida();
	}

	@Override
	public void visitar(MarioInvulnerable marioInv) {
		ContextoMario contexto = marioInv.getContext();
		contexto.cambiarEstado(new MarioDefault());
		contexto.perderVida();
	}

	@Override
	public void visitar(MarioFuego marioFuego) {
		ContextoMario contexto = marioFuego.getContext();
		contexto.cambiarEstado(new MarioDefault());
		contexto.perderVida();
	}

	@Override
	public void visitar(SuperMario superMario) {
		ContextoMario contexto = superMario.getContext();
		contexto.cambiarEstado(new MarioDefault());
		contexto.perderVida();
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
		// TODO Auto-generated method stub
		
	}

}