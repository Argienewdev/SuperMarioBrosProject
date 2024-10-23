package visitors;

import elementos.ElementoDeJuego;
import elementos.enemigos.BuzzyBeetle;
import elementos.enemigos.ContextoKoopaTroopa;
import elementos.enemigos.Enemigo;
import elementos.enemigos.Goomba;
import elementos.enemigos.KoopaEnCaparazon;
import elementos.enemigos.KoopaDefault;
import elementos.enemigos.Lakitu;
import elementos.enemigos.PiranhaPlant;
import elementos.enemigos.Spiny;
import elementos.entidades.Fireball;
import elementos.personajes.ContextoMario;
import elementos.personajes.EstadoMario;
import elementos.personajes.MarioDefault;
import elementos.personajes.MarioFuego;
import elementos.personajes.MarioInvulnerable;
import elementos.personajes.SuperMario;
import elementos.plataformas.Bandera;
import elementos.plataformas.BloqueDePregunta;
import elementos.plataformas.BloqueSolido;
import elementos.plataformas.Ladrillo;
import elementos.plataformas.PrincesaPeach;
import elementos.plataformas.Tuberia;
import elementos.plataformas.Vacio;
import elementos.powerUps.ChampinionVerde;
import elementos.powerUps.Estrella;
import elementos.powerUps.FlorDeFuego;
import elementos.powerUps.Monedas;
import elementos.powerUps.SuperChampinion;
import juego.Nivel;

public class VisitorContextoMario implements Visitante {
	
	protected ContextoMario miEntidad;
	
	public VisitorContextoMario (ContextoMario miEntidad) {
		this.miEntidad = miEntidad;
	}

	@Override
	public void visitar(BuzzyBeetle buzzy) {
		otorgarPuntosYEliminar(buzzy);
	}

	@Override
	public void visitar(Spiny spiny) {
		//Solo es afectado por FireBall
	}

	@Override
	public void visitar(Goomba goomba) {
		otorgarPuntosYEliminar(goomba);
	}

	public void visitar(ContextoKoopaTroopa koopaTroopa) {
		KoopaDefault estadoDefault=new KoopaDefault();
		if(koopaTroopa.getEstado().equals(estadoDefault)) {
			KoopaEnCaparazon estadoEstatico=new KoopaEnCaparazon();
			koopaTroopa.cambiarEstado(estadoEstatico);
		}else {
			otorgarPuntosYEliminar(koopaTroopa);
		}
	}

	@Override
	public void visitar(Lakitu lakitu) {
		otorgarPuntosYEliminar(lakitu);
	}

	@Override
	public void visitar(PiranhaPlant planta) {
		//Solo es afectado por FireBall
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
		Nivel nivel = moneda.getNivel();
		nivel.removePowerUps(moneda);
	}

	@Override
	public void visitar(BloqueDePregunta bloquePregunta) {
		if (!bloquePregunta.estaVacio()) {
			bloquePregunta.liberarPowerUp();
		}
		bloquePregunta.setVacio(true);
	}

	@Override
	public void visitar(Ladrillo ladrillo) {
		if (choquePorDerecha(ladrillo) || choquePorIzquierda(ladrillo)) {
			miEntidad.retrotraerMovimientoHorizontal();
		}
		if(choquePorArriba(ladrillo)) {
			miEntidad.setColisionAbajo(true);
			miEntidad.retrotraerMovimientoVertical(ladrillo.obtenerHitbox().y - miEntidad.obtenerHitbox().height);
		}
		if(choquePorAbajo(ladrillo)){
			miEntidad.setColisionArriba(true);
			miEntidad.retrotraerMovimientoVertical(ladrillo.obtenerHitbox().y + miEntidad.obtenerHitbox().height);
		}
			
			MarioDefault estadoDefault= new MarioDefault();
			estadoDefault.setContext(miEntidad);
			
			//No se porque se da falso el equals, ambos son de la clase MarioDefault y tienen el mismo contexto
			/*
			if(!miEntidad.getEstado().equals(estadoDefault)){
				nivel = ladrillo.getNivel();
				nivel.removePlataforma(ladrillo);
			}
			*/
			
			
		
	}
	
	private boolean choquePorDerecha(BloqueSolido bloque) {
		boolean parte1 = miEntidad.obtenerHitbox().x + miEntidad.obtenerHitbox().width > bloque.obtenerHitbox().x;
		boolean parte2 = !(miEntidad.getPosicion().x + miEntidad.obtenerAncho() > bloque.getPosicion().x);
		return parte1 && parte2;
	}
	
	private boolean choquePorIzquierda(BloqueSolido bloque) {
		boolean parte1 = miEntidad.obtenerHitbox().x < bloque.obtenerHitbox().x + bloque.obtenerHitbox().width;
		boolean parte2 = !(miEntidad.getPosicion().x < bloque.getPosicion().x + bloque.obtenerAncho());
		return parte1 && parte2;
	}
	
	private boolean choquePorArriba(BloqueSolido bloque) {
		boolean parte1 = miEntidad.obtenerHitbox().y + miEntidad.obtenerHitbox().height > bloque.obtenerHitbox().y;
		boolean parte2 = !(miEntidad.getPosicion().y + miEntidad.obtenerAlto() > bloque.getPosicion().y);
		boolean parte3 = miEntidad.getVelocidadDireccional().y > 0;
		return parte1 && parte2 && parte3;
	}
	
	private boolean choquePorAbajo(BloqueSolido bloque) {
		boolean parte1 = miEntidad.obtenerHitbox().y < bloque.obtenerHitbox().y + bloque.obtenerHitbox().height;
		boolean parte2 = !(miEntidad.getPosicion().y < bloque.getPosicion().y + bloque.obtenerAlto());
		boolean parte3 = miEntidad.getVelocidadDireccional().y < 0;
		return parte1 && parte2 && parte3;
	}
	
	@Override
	public void visitar(Vacio vacio) {
	}

	@Override
	public void visitar(PrincesaPeach princesa) {
	}

	@Override
	public void visitar(Bandera bandera) {
	}

	@Override
	public void visitar(Tuberia tuberia) {
	}

	@Override
	public void visitar(BloqueSolido bloqueSolido) {
	}

	@Override
	public void visitar(ContextoMario contextoMario) {
		
	}
	
	private void aVisitorConcreto (ElementoDeJuego elemento) {
	}
	
	private void otorgarPuntosYEliminar(Enemigo enemigo) {
		int puntos = enemigo.getPuntosOtorgadosPorEliminacion();
		miEntidad.ganarPuntos(puntos);
		Nivel nivel = enemigo.getNivel();
		nivel.removeEnemigo(enemigo);
	}
}
