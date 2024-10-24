package visitors;

import elementos.enemigos.BuzzyBeetle;
import elementos.enemigos.ContextoKoopaTroopa;
import elementos.enemigos.Goomba;
import elementos.enemigos.KoopaDefault;
import elementos.enemigos.KoopaEnCaparazon;
import elementos.enemigos.Lakitu;
import elementos.enemigos.PiranhaPlant;
import elementos.enemigos.Spiny;
import elementos.entidades.Fireball;
import elementos.personajes.ContextoMario;
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

public class VisitorMarioDefault implements Visitante{

	protected MarioDefault miEstado;
	
	private ContextoMario miEntidad;
	
	public VisitorMarioDefault (MarioDefault miEstado) {
		this.miEstado = miEstado;
		miEntidad=miEstado.getContext();
	}
	
	@Override
	public void visitar(BuzzyBeetle buzzy) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitar(Spiny spiny) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitar(Goomba goomba) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitar(ContextoKoopaTroopa contextoKoopa) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitar(KoopaEnCaparazon koopaEnCaparazon) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitar(KoopaDefault koopaDefault) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitar(Lakitu lakitu) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitar(PiranhaPlant planta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitar(Fireball fireball) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitar(SuperChampinion superChamp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitar(FlorDeFuego flor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitar(ChampinionVerde champVerde) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitar(Estrella estrella) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitar(Monedas monedas) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitar(BloqueDePregunta bloquePregunta) {
		if (choquePorDerecha(bloquePregunta) || choquePorIzquierda(bloquePregunta)) {
			miEntidad.retrotraerMovimientoHorizontal();
		}
		if(choquePorArriba(bloquePregunta)) {
			miEntidad.setColisionAbajo(true);
			miEntidad.retrotraerMovimientoVertical(bloquePregunta.obtenerHitbox().y - miEntidad.obtenerHitbox().height);
		}
		if(choquePorAbajo(bloquePregunta)){
			miEntidad.retrotraerMovimientoVertical(bloquePregunta.obtenerHitbox().y + miEntidad.obtenerHitbox().height);
		}
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
			miEntidad.retrotraerMovimientoVertical(ladrillo.obtenerHitbox().y + miEntidad.obtenerHitbox().height); 
		}
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
	public void visitar(MarioDefault marioDefault) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitar(SuperMario superMario) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitar(MarioFuego marioFuego) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitar(MarioInvulnerable marioInvulnerable) {
		// TODO Auto-generated method stub
		
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
}
