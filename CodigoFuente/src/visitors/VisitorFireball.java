package visitors;

import elementos.enemigos.*;
import elementos.entidades.Fireball;
import elementos.personajes.*;
import elementos.plataformas.*;
import elementos.powerUps.*;
import juego.Nivel;

public class VisitorFireball implements Visitante {
<<<<<<< HEAD
	
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
=======

    protected Fireball miEntidad;

    public VisitorFireball(Fireball miEntidad) {
        this.miEntidad = miEntidad;
    }

    public void visitar(BuzzyBeetle buzzy) {
        otorgarPuntosYEliminar(buzzy);
    }

    public void visitar(Spiny spiny) {
        otorgarPuntosYEliminar(spiny);
    }

    public void visitar(Goomba goomba) {
        otorgarPuntosYEliminar(goomba);
    }

    public void visitar(KoopaCaparazonEstatico koopaEstatico) {
        koopaEstatico.getContext().cambiarEstado(new KoopaCaparazonMovil());
    }

    public void visitar(KoopaCaparazonMovil koopaMovil) {
        ContextoKoopaTroopa contexto = koopaMovil.getContext();
        otorgarPuntosYEliminar(contexto);
    }

    public void visitar(KoopaDefault koopaDefault) {
        koopaDefault.getContext().cambiarEstado(new KoopaCaparazonEstatico());
    }
>>>>>>> 05d0b3a3d21377cd747608863f04eee1714edc52

    public void visitar(Lakitu lakitu) {
        otorgarPuntosYEliminar(lakitu);
    }

    public void visitar(PiranhaPlant planta) {
        otorgarPuntosYEliminar(planta);
    }

    public void visitar(Fireball fireball) {
        // Sin lógica específica por ahora
    }

    public void visitar(SuperChampinion superChamp) { }

    public void visitar(FlorDeFuego flor) { }

    public void visitar(ChampinionVerde champVerde) { }

    public void visitar(Estrella estrella) { }

    public void visitar(Monedas moneda) { }

    public void visitar(MarioDefault marioNormal) { }

    public void visitar(MarioInvulnerable marioInv) { }

    public void visitar(MarioFuego marioFuego) { }

    public void visitar(SuperMario superMario) { }

    public void visitar(BloqueDePregunta bloquePregunta) { }

    public void visitar(Ladrillo ladrillo) { }

    public void visitar(Vacio vacio) { }

    public void visitar(PrincesaPeach princesa) { }

    public void visitar(Bandera bandera) { }

    public void visitar(Tuberia tuberia) { }

    public void visitar(BloqueSolido bloqueSolido) { }

    public void visitar(ContextoMario contextoMario) { }

    public void visitar(ContextoKoopaTroopa contextoKoopa) { }

    // Método auxiliar para otorgar puntos y eliminar enemigos
    private void otorgarPuntosYEliminar(Enemigo enemigo) {
        int puntos = enemigo.getPuntosOtorgadosPorEliminacion();
        miEntidad.obtenerJugador().ganarPuntos(puntos);
        Nivel nivel = enemigo.getNivel();
        nivel.removeEnemigo(enemigo);
    }
}
