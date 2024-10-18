package visitors;

import elementos.enemigos.*;
import elementos.entidades.Fireball;
import elementos.personajes.*;
import elementos.plataformas.*;
import elementos.powerUps.*;
import juego.Nivel;

public class VisitorFireball implements Visitante {
	
	protected Fireball miEntidad;
	
	public VisitorFireball (Fireball miEntidad) {
		this.miEntidad = miEntidad;
	}

	@Override
	public void visitarBuzzyBeetle(BuzzyBeetle buzzy) {
		int puntos = buzzy.getPuntosOtorgadosPorEliminacion();
		miEntidad.obtenerJugador().ganarPuntos(puntos);
		Nivel nivel = buzzy.getNivel();
		nivel.removeEnemigo(buzzy);
		
	}

	@Override
	public void visitarSpiny(Spiny spiny) {
		int puntos = spiny.getPuntosOtorgadosPorEliminacion();
		miEntidad.obtenerJugador().ganarPuntos(puntos);
		Nivel nivel = spiny.getNivel();
		nivel.removeEnemigo(spiny);
	}

	@Override
	public void visitarGoomba(Goomba goomba) {
		int puntos = goomba.getPuntosOtorgadosPorEliminacion();
		miEntidad.obtenerJugador().ganarPuntos(puntos);
		Nivel nivel = goomba.getNivel();
		nivel.removeEnemigo(goomba);
		
	}

	@Override
	public void visitarKoopaCaparazonEstatico(KoopaCaparazonEstatico koopaEstatico) {
		ContextoKoopaTroopa contexto = koopaEstatico.getContext();
		EstadoKoopa estado = new KoopaCaparazonMovil();
		contexto.cambiarEstado(estado);
		
	}

	@Override
	public void visitarKoopaCaparazonMovil(KoopaCaparazonMovil koopaMovil) {
		ContextoKoopaTroopa contexto = koopaMovil.getContext();
		int puntos = contexto.getPuntosOtorgadosPorEliminacion();
		miEntidad.obtenerJugador().ganarPuntos(puntos);
		Nivel nivel = contexto.getNivel();
		nivel.removeEnemigo(contexto);
	}

	@Override
	public void visitarKoopaDefault(KoopaDefault koopaDefault) {
		ContextoKoopaTroopa contexto = koopaDefault.getContext();
		EstadoKoopa estado = new KoopaCaparazonEstatico();
		contexto.cambiarEstado(estado);
		
	}

	@Override
	public void visitarLakitu(Lakitu lakitu) {
		int puntos = lakitu.getPuntosOtorgadosPorEliminacion();
		miEntidad.obtenerJugador().ganarPuntos(puntos);
		Nivel nivel = lakitu.getNivel();
		nivel.removeEnemigo(lakitu);
		
	}

	@Override
	public void visitarPiranhaPlant(PiranhaPlant planta) {
		int puntos = planta.getPuntosOtorgadosPorEliminacion();
		miEntidad.obtenerJugador().ganarPuntos(puntos);
		Nivel nivel = planta.getNivel();
		nivel.removeEnemigo(planta);
		
	}

	@Override
	public void visitarFireball(Fireball fireball) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitarSuperChampinion(SuperChampinion superChamp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitarFlorDeFuego(FlorDeFuego flor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitarChampinionVerde(ChampinionVerde champVerde) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitarEstrella(Estrella estrella) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitarMonedas(Monedas moneda) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitarMarioDefault(MarioDefault marioNormal) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitarMarioInvulnerable(MarioInvulnerable marioInv) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitarMarioFuego(MarioFuego marioFuego) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitarSuperMario(SuperMario superMario) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitarBloqueDePregunta(BloqueDePregunta bloquePregunta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitarLadrillo(Ladrillo ladrillo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitarVacio(Vacio vacio) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitarPrincesaPeach(PrincesaPeach princesa) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitarBandera(Bandera bandera) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitarTuberia(Tuberia tuberia) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitarBloqueSolido(BloqueSolido bloqueSolido) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitarContextoMario(ContextoMario contextoMario) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitarContextoKoopaTroopa(ContextoKoopaTroopa contextoKoopa) {
		// TODO Auto-generated method stub
		
	}

	
}
