package visitors;

import elementos.enemigos.*;
import elementos.entidades.BolaDeFuego;
import elementos.personajes.*;
import elementos.plataformas.*;
import elementos.powerUps.*;
import generadores.GeneradorSonidos;

public class VisitorEstrella implements Visitante {
    
    protected Estrella miEntidad;
    
    protected GeneradorSonidos generadorSonidos;
    
    public VisitorEstrella(Estrella miEntidad, GeneradorSonidos generadorSonidos) {
        this.generadorSonidos = generadorSonidos;
    	this.miEntidad = miEntidad;
    }

    @Override
    public void visitarBuzzyBeetle(BuzzyBeetle buzzyBeetle) {}

    @Override
    public void visitarSpiny(Spiny spiny) {}

    @Override
    public void visitarGoomba(Goomba goomba) {}

    @Override
    public void visitarLakitu(Lakitu lakitu) {}

    @Override
    public void visitarPiranhaPlant(PiranhaPlant piranhaPlant) {
        // Lógica para visitar PiranhaPlant
    }

    @Override
    public void visitarSuperChampinion(SuperChampinion superChampinion) {
        // Lógica para visitar SuperChampinion
    }

    @Override
    public void visitarFlorDeFuego(FlorDeFuego florDeFuego) {
        // Lógica para visitar FlorDeFuego
    }

    @Override
    public void visitarChampinionVerde(ChampinionVerde champinionVerde) {
        // Lógica para visitar ChampinionVerde
    }

    @Override
    public void visitarEstrella(Estrella estrella) {
        // Lógica para visitar Estrella
    }

    @Override
    public void visitarMoneda(Moneda monedas) {
        // Lógica para visitar Monedas
    }

    @Override
    public void visitarBloqueDePregunta(BloqueDePregunta bloqueDePregunta) {
        // Lógica para visitar BloqueDePregunta
    }

    @Override
    public void visitarLadrillo(Ladrillo ladrillo) {
        // Lógica para visitar Ladrillo
    }

    @Override
    public void visitarPrincesaPeach(PrincesaPeach princesaPeach) {
        // Lógica para visitar PrincesaPeach
    }

    @Override
    public void visitarBandera(Bandera bandera) {
        // Lógica para visitar Bandera
    }

    @Override
    public void visitarTuberia(Tuberia tuberia) {
        // Lógica para visitar Tuberia
    }

    @Override
    public void visitarBloqueSolido(BloqueSolido bloqueSolido) {
        // Lógica para visitar BloqueSolido
    }

    @Override
    public void visitarContextoMario(ContextoMario contextoMario) {
        contextoMario.obtenerEstado().aceptarVisitante(this);
    }
    
    @Override
    public void visitarMarioDefault(MarioDefault marioDefault) {
        ContextoMario contextoMario = marioDefault.obtenerContexto();
        EstadoMario nuevoEstado = new MarioInvulnerable(marioDefault);
        contextoMario.cambiarEstado(nuevoEstado);
    }

    @Override
    public void visitarSuperMario(SuperMario superMario) {
        ContextoMario contextoMario = superMario.obtenerContexto();
        EstadoMario nuevoEstado = new MarioInvulnerable(superMario);
        contextoMario.cambiarEstado(nuevoEstado);
    }

    @Override
    public void visitarMarioFuego(MarioFuego marioFuego) {
        ContextoMario contextoMario = marioFuego.obtenerContexto();
        EstadoMario nuevoEstado = new MarioInvulnerable(marioFuego);
        contextoMario.cambiarEstado(nuevoEstado);
    }

    @Override
    public void visitarMarioInvulnerable(MarioInvulnerable marioInvulnerable) {}
    
    public void visitarMarioRecuperacion(MarioRecuperacion marioRecuperacion) {
    	ContextoMario contextoMario = marioRecuperacion.obtenerContexto();
        EstadoMario nuevoEstado = new MarioInvulnerable(new MarioDefault());
        contextoMario.cambiarEstado(nuevoEstado);
    }

    @Override
    public void visitarContextoKoopaTroopa(ContextoKoopaTroopa contextoKoopaTroopa) {}

    @Override
    public void visitarKoopaEnCaparazon(KoopaEnCaparazon koopaEnCaparazon) {}

    @Override
    public void visitarKoopaDefault(KoopaDefault koopaDefault) {}

    @Override
    public void visitarPiso(Piso piso) {}

	@Override
	public void visitarBolaDeFuego(BolaDeFuego fireball) {
	}

	@Override
	public void visitarVacio(Vacio vacio) {
	}
}
