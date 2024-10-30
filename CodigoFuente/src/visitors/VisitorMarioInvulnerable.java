package visitors;

import elementos.enemigos.*;
import elementos.entidades.BolaDeFuego;
import elementos.personajes.*;
import elementos.plataformas.*;
import elementos.powerUps.*;

public class VisitorMarioInvulnerable implements Visitante {

    protected EstadoMario miEstado;
    
    protected ContextoMario miEntidad;
    
    protected DetectorDireccionColision detectorDireccionColision;

    public VisitorMarioInvulnerable(MarioInvulnerable miEstado) {
        this.miEstado = miEstado;
        this.miEntidad = this.miEstado.obtenerContexto();
        this.detectorDireccionColision = new DetectorDireccionColision();
    }

    @Override
    public void visitarBuzzyBeetle(BuzzyBeetle buzzyBeetle) {
    	buzzyBeetle.establecerRemovido(true);
        this.miEntidad.ganarPuntos(buzzyBeetle.obtenerPuntosOtorgadosPorEliminacion());
    }

    @Override
    public void visitarSpiny(Spiny spiny) {
    	spiny.establecerRemovido(true);
    	this.miEntidad.ganarPuntos(spiny.obtenerPuntosOtorgadosPorEliminacion());
    }

    @Override
    public void visitarGoomba(Goomba goomba) {
    	goomba.establecerRemovido(true);
    	this.miEntidad.ganarPuntos(goomba.obtenerPuntosOtorgadosPorEliminacion());
    }

    @Override
    public void visitarContextoKoopaTroopa(ContextoKoopaTroopa contextoKoopaTroopa) {
    }

    @Override
    public void visitarKoopaEnCaparazon(KoopaEnCaparazon koopaEnCaparazon) {
    	koopaEnCaparazon.obtenerContext().establecerRemovido(true);
    	this.miEntidad.ganarPuntos(koopaEnCaparazon.obtenerContext().obtenerPuntosOtorgadosPorEliminacion());
    }

    @Override
    public void visitarKoopaDefault(KoopaDefault koopaDefault) {
    	koopaDefault.obtenerContext().establecerRemovido(true);
    	this.miEntidad.ganarPuntos(koopaDefault.obtenerContext().obtenerPuntosOtorgadosPorEliminacion());
    }

    @Override
    public void visitarLakitu(Lakitu lakitu) {
    	lakitu.establecerRemovido(true);
    	this.miEntidad.ganarPuntos(lakitu.obtenerPuntosOtorgadosPorEliminacion());
    }

    @Override
    public void visitarPiranhaPlant(PiranhaPlant piranhaPlant) {
    	piranhaPlant.establecerRemovido(true);
    	this.miEntidad.ganarPuntos(piranhaPlant.obtenerPuntosOtorgadosPorEliminacion());
    }

    @Override
    public void visitarSuperChampinion(SuperChampinion superChampinion) {
    	this.miEntidad.ganarPuntos(superChampinion.obtenerPuntosPorInvulnerable());
        superChampinion.establecerRemovido(true);
    }

    @Override
    public void visitarFlorDeFuego(FlorDeFuego florDeFuego) {
    	this.miEntidad.ganarPuntos(florDeFuego.obtenerPuntosPorInvulnerable());
        florDeFuego.establecerRemovido(true);
    }

    @Override
    public void visitarChampinionVerde(ChampinionVerde champinionVerde) {
    }

    @Override
    public void visitarEstrella(Estrella estrella) {
    	this.miEntidad.ganarPuntos(estrella.obtenerPuntosPorInvulnerable());
        estrella.establecerRemovido(true);
    }

    @Override
    public void visitarMonedas(Monedas monedas) {}

    @Override
    public void visitarBloqueDePregunta(BloqueDePregunta bloqueDePregunta) {}

    @Override
    public void visitarLadrillo(Ladrillo ladrillo) {
    	if (detectorDireccionColision.choquePorAbajo(ladrillo, this.miEntidad)) {
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
