package visitors;

import elementos.enemigos.*;
import elementos.entidades.BolaDeFuego;
import elementos.personajes.*;
import elementos.plataformas.*;
import elementos.powerUps.*;
import juego.Nivel;

public class VisitorBolaDeFuego implements Visitante {

    protected BolaDeFuego miEntidad;

    public VisitorBolaDeFuego(BolaDeFuego miEntidad) {
        this.miEntidad = miEntidad;
    }

    @Override
    public void visitarBuzzyBeetle(BuzzyBeetle buzzyBeetle) {
        otorgarPuntosYEliminar(buzzyBeetle);
    }

    @Override
    public void visitarSpiny(Spiny spiny) {
        otorgarPuntosYEliminar(spiny);
    }

    @Override
    public void visitarGoomba(Goomba goomba) {
    	otorgarPuntosYEliminar(goomba);
    }

    @Override
    public void visitarContextoKoopaTroopa(ContextoKoopaTroopa contextoKoopaTroopa) {
        otorgarPuntosYEliminar(contextoKoopaTroopa);
    }

    @Override
    public void visitarKoopaDefault(KoopaDefault koopaDefault) {
    	koopaDefault.obtenerContext().establecerRemovido(true);
    }

    @Override
    public void visitarKoopaEnCaparazon(KoopaEnCaparazon koopaEnCaparazon) {
    	koopaEnCaparazon.obtenerContext().establecerRemovido(true);
    }

    @Override
    public void visitarLakitu(Lakitu lakitu) {
        otorgarPuntosYEliminar(lakitu);
    }

    @Override
    public void visitarPiranhaPlant(PiranhaPlant piranhaPlant) {
        otorgarPuntosYEliminar(piranhaPlant);
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
    public void visitarMarioDefault(MarioDefault marioDefault) {
    }

    @Override
    public void visitarMarioInvulnerable(MarioInvulnerable marioInvulnerable) {
    }

    @Override
    public void visitarMarioFuego(MarioFuego marioFuego) {
    }

    @Override
    public void visitarSuperMario(SuperMario superMario) {
    }
    
    public void visitarMarioRecuperacion(MarioRecuperacion marioRecuperacion) {
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
    }

    @Override
    public void visitarPiso(Piso piso) {
    }

	@Override
	public void visitarBolaDeFuego(BolaDeFuego fireball) {
	}

	@Override
	public void visitarVacio(Vacio vacio) {
	}
	
	// Método auxiliar para otorgar puntos y eliminar enemigos
	private void otorgarPuntosYEliminar(Enemigo enemigo) {
		int puntos = enemigo.obtenerPuntosOtorgadosPorEliminacion();
		this.miEntidad.obtenerJugador().ganarPuntos(puntos);
		enemigo.establecerRemovido(true);
	}
}
