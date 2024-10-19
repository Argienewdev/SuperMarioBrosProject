package visitors;
import elementos.enemigos.*;
import elementos.entidades.Fireball;
import elementos.personajes.*;
import elementos.plataformas.*;
import elementos.powerUps.*;
import juego.Nivel;
public class VisitorSuperMario implements Visitante {
	
	protected SuperMario miEntidad;
	
	public VisitorSuperMario (SuperMario miEntidad) {
		this.miEntidad = miEntidad;
	}

	@Override
	public void visitar(BuzzyBeetle buzzy) {
		otorgarPuntosYEliminar(buzzy);
	}

	@Override
	public void visitar(Spiny spiny) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitar(Goomba goomba) {
		otorgarPuntosYEliminar(goomba);
	}

	public void visitar(KoopaDefault koopaDefault) {
		ContextoKoopaTroopa contexto = koopaDefault.getContext();
		EstadoKoopa estado = new KoopaCaparazonEstatico();
		contexto.cambiarEstado(estado);
	}

	public void visitar(KoopaCaparazonEstatico koopaEstatico) {
		ContextoKoopaTroopa contexto = koopaEstatico.getContext();
		EstadoKoopa estado = new KoopaCaparazonMovil();
		contexto.cambiarEstado(estado);
	}

	public void visitar(KoopaCaparazonMovil koopaMovil) {
		otorgarPuntosYEliminar(koopaMovil.getContext());
	}

	@Override
	public void visitar(Lakitu lakitu) {
		otorgarPuntosYEliminar(lakitu);
	}

	@Override
	public void visitar(PiranhaPlant planta) {

	}

	@Override
	public void visitar(Fireball fireball) {
		// TODO Auto-generated method stub
		
	}

	public void visitar(SuperChampinion superChamp) {
		Nivel nivel = superChamp.getNivel();
		nivel.removePowerUps(superChamp);
	}

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
		Nivel nivel = moneda.getNivel();
		nivel.removePowerUps(moneda);
	}
	
	@Override
	public void visitar(MarioDefault marioNormal) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitar(MarioInvulnerable marioInv) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitar(MarioFuego marioFuego) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitar(SuperMario superMario) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitar(BloqueDePregunta bloquePregunta) {
		if (!bloquePregunta.estaVacio()) {
			bloquePregunta.liberarPowerUp();
		}
		bloquePregunta.setVacio(true);
		Nivel nivel = bloquePregunta.getNivel();
		nivel.removePlataforma(bloquePregunta);
		
	}

	@Override
	public void visitar(Ladrillo ladrillo) {
		Nivel nivel = ladrillo.getNivel();
		nivel.removePlataforma(ladrillo);
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

	private void otorgarPuntosYEliminar(Enemigo enemigo) {
		int puntos = enemigo.getPuntosOtorgadosPorEliminacion();
		miEntidad.getContext().ganarPuntos(puntos);
		Nivel nivel = enemigo.getNivel();
		nivel.removeEnemigo(enemigo);
	}
}