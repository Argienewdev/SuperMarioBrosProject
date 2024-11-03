package visitors;

import elementos.enemigos.*;
import elementos.entidades.BolaDeFuego;
import elementos.personajes.*;
import elementos.plataformas.*;
import elementos.powerUps.*;
import generadores.GeneradorSonidos;
import juego.Nivel;

public class VisitorBolaDeFuego implements Visitante {

    protected BolaDeFuego miEntidad;
    
    protected GeneradorSonidos generadorSonidos;

    public VisitorBolaDeFuego(BolaDeFuego miEntidad, GeneradorSonidos generadorSonidos) {
        this.generadorSonidos = generadorSonidos;
    	this.miEntidad = miEntidad;
    }

    @Override
    public void visitarBuzzyBeetle(BuzzyBeetle buzzyBeetle) {
		this.generadorSonidos.emitirSonidoAplastarEnemigo2();
        otorgarPuntosYEliminar(buzzyBeetle);
    }

    @Override
    public void visitarSpiny(Spiny spiny) {
		this.generadorSonidos.emitirSonidoAplastarEnemigo3();
        otorgarPuntosYEliminar(spiny);
    }

    @Override
    public void visitarGoomba(Goomba goomba) {
		this.generadorSonidos.emitirSonidoAplastarEnemigo();
    	otorgarPuntosYEliminar(goomba);
    }

    @Override
    public void visitarContextoKoopaTroopa(ContextoKoopaTroopa contextoKoopaTroopa) {
    	contextoKoopaTroopa.obtenerEstado().aceptarVisitante(this.miEntidad.obtenerVisitante());
    }

    @Override
    public void visitarKoopaDefault(KoopaDefault koopaDefault) {
		this.generadorSonidos.emitirSonidoAplastarEnemigo2();
    	otorgarPuntosYEliminar(koopaDefault.obtenerContext());
    }

    @Override
    public void visitarKoopaEnCaparazon(KoopaEnCaparazon koopaEnCaparazon) {
		this.generadorSonidos.emitirSonidoAplastarEnemigo2();
    	koopaEnCaparazon.obtenerContext().establecerRemovido(true);
    }

    @Override
    public void visitarLakitu(Lakitu lakitu) {
		this.generadorSonidos.emitirSonidoAplastarEnemigo();
        otorgarPuntosYEliminar(lakitu);
    }

    @Override
    public void visitarPiranhaPlant(PiranhaPlant piranhaPlant) {
		this.generadorSonidos.emitirSonidoAplastarEnemigo3();
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
    public void visitarMoneda(Moneda monedas) {
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
