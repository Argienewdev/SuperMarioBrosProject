package visitors;

import java.awt.Point;

import elementos.ElementoDeJuego;
import elementos.enemigos.BuzzyBeetle;
import elementos.enemigos.ContextoKoopaTroopa;
import elementos.enemigos.Goomba;
import elementos.enemigos.KoopaCaparazonEstatico;
import elementos.enemigos.KoopaCaparazonMovil;
import elementos.enemigos.KoopaDefault;
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

public class VisitorContextoMario implements Visitante {
	
	protected ContextoMario miEntidad;
	
	public VisitorContextoMario (ContextoMario miEntidad) {
		this.miEntidad = miEntidad;
	}

	@Override
	public void visitar(BuzzyBeetle buzzy) {
		
	}

	@Override
	public void visitar(Spiny spiny) {
		
	}

	@Override
	public void visitar(Goomba goomba) {
	}

	@Override
	public void visitar(KoopaCaparazonEstatico koopaEstatico) {
	}

	@Override
	public void visitar(KoopaCaparazonMovil koopaMovil) {
	}

	@Override
	public void visitar(KoopaDefault koopaDefault) {
	}

	@Override
	public void visitar(Lakitu lakitu) {
	}

	@Override
	public void visitar(PiranhaPlant planta) {
	}

	@Override
	public void visitar(Fireball fireball) {
	}

	@Override
	public void visitar(SuperChampinion superChamp) {
		
	}

	@Override
	public void visitar(FlorDeFuego flor) {
	}

	@Override
	public void visitar(ChampinionVerde champVerde) {
	}

	@Override
	public void visitar(Estrella estrella) {
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

	@Override
	public void visitar(ContextoKoopaTroopa contextoKoopa) {
	}
	
	private void aVisitorConcreto (ElementoDeJuego elemento) {
	}
}
