package visitors;

import elementos.enemigos.*;
import elementos.entidades.BolaDeFuego;
import elementos.personajes.*;
import elementos.plataformas.*;
import elementos.powerUps.*;

public class VisitorMarioInvulnerable implements Visitante {

    protected EstadoMario miEstado;
    
    protected ContextoMario miContexto;
    
    protected DetectorDireccionColision detectorDireccionColision;

    public VisitorMarioInvulnerable(MarioInvulnerable miEstado) {
        this.miEstado = miEstado;
        this.miContexto = this.miEstado.obtenerContexto();
        this.detectorDireccionColision = new DetectorDireccionColision();
    }

    @Override
    public void visitarBuzzyBeetle(BuzzyBeetle buzzyBeetle) {
    	buzzyBeetle.establecerRemovido(true);
        this.miContexto.ganarPuntos(buzzyBeetle.obtenerPuntosOtorgadosPorEliminacion());
    }

    @Override
    public void visitarSpiny(Spiny spiny) {
    	spiny.establecerRemovido(true);
    	this.miContexto.ganarPuntos(spiny.obtenerPuntosOtorgadosPorEliminacion());
    }

    @Override
    public void visitarGoomba(Goomba goomba) {
    	goomba.establecerRemovido(true);
    	this.miContexto.ganarPuntos(goomba.obtenerPuntosOtorgadosPorEliminacion());
    }

    @Override
    public void visitarContextoKoopaTroopa(ContextoKoopaTroopa contextoKoopaTroopa) {
    	contextoKoopaTroopa.obtenerEstado().aceptarVisitante(this.miContexto.obtenerEstado().obtenerVisitante());
    }

    @Override
    public void visitarKoopaDefault(KoopaDefault koopaDefault) {
    	int puntos = koopaDefault.obtenerContext().obtenerPuntosOtorgadosPorEliminacion();
		this.miContexto.ganarPuntos(puntos);
		koopaDefault.obtenerContext().establecerRemovido(true);
    }

    @Override
    public void visitarKoopaEnCaparazon(KoopaEnCaparazon koopaEnCaparazon) {
    	koopaEnCaparazon.obtenerContext().establecerRemovido(true);
    }

    @Override
    public void visitarLakitu(Lakitu lakitu) {
    	lakitu.establecerRemovido(true);
    	this.miContexto.ganarPuntos(lakitu.obtenerPuntosOtorgadosPorEliminacion());
    }

    @Override
    public void visitarPiranhaPlant(PiranhaPlant piranhaPlant) {
    	piranhaPlant.establecerRemovido(true);
    	this.miContexto.ganarPuntos(piranhaPlant.obtenerPuntosOtorgadosPorEliminacion());
    }

    @Override
    public void visitarSuperChampinion(SuperChampinion superChampinion) {
    	this.miContexto.ganarPuntos(superChampinion.obtenerPuntosPorInvulnerable());
        superChampinion.establecerRemovido(true);
    }

    @Override
    public void visitarFlorDeFuego(FlorDeFuego florDeFuego) {
    	this.miContexto.ganarPuntos(florDeFuego.obtenerPuntosPorInvulnerable());
        florDeFuego.establecerRemovido(true);
    }

    @Override
    public void visitarChampinionVerde(ChampinionVerde champinionVerde) {
    }

    @Override
    public void visitarEstrella(Estrella estrella) {
    	this.miContexto.ganarPuntos(estrella.obtenerPuntosPorInvulnerable());
        estrella.establecerRemovido(true);
    }

    @Override
    public void visitarMoneda(Moneda monedas) {}

    @Override
    public void visitarBloqueDePregunta(BloqueDePregunta bloqueDePregunta) {}

    @Override
    public void visitarLadrillo(Ladrillo ladrillo) {
    	if (detectorDireccionColision.choquePorAbajo(ladrillo, this.miContexto)) {
            detectorDireccionColision.verificarColisionElementoDeJuegoYEntidad(ladrillo, miContexto);
            ladrillo.eliminarDelNivel();
        }
    }

    @Override
    public void visitarPrincesaPeach(PrincesaPeach princesaPeach) {}

    @Override
    public void visitarBandera(Bandera bandera) {}

    @Override
    public void visitarTuberia(Tuberia tuberia) {}

    @Override
    public void visitarBloqueSolido(BloqueSolido bloqueSolido) {}

    @Override
    public void visitarContextoMario(ContextoMario contextoMario) {}

    @Override
    public void visitarMarioDefault(MarioDefault marioDefault) {}

    @Override
    public void visitarSuperMario(SuperMario superMario) {}

    @Override
    public void visitarMarioFuego(MarioFuego marioFuego) {}

    @Override
    public void visitarMarioInvulnerable(MarioInvulnerable marioInvulnerable) {}
    
    public void visitarMarioRecuperacion(MarioRecuperacion marioRecuperacion) {}

    @Override
    public void visitarPiso(Piso piso) {}

	@Override
	public void visitarBolaDeFuego(BolaDeFuego fireball) {
	}

	@Override
	public void visitarVacio(Vacio vacio) {
		// TODO Auto-generated method stub
		
	}

    
}
