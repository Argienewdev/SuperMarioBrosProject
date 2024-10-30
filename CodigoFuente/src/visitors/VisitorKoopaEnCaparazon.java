package visitors;

import java.awt.Point;

import elementos.enemigos.*;
import elementos.entidades.BolaDeFuego;
import elementos.personajes.*;
import elementos.plataformas.*;
import elementos.powerUps.*;

public class VisitorKoopaEnCaparazon implements Visitante {

    protected EstadoKoopa miEstado;
    
    private ContextoKoopaTroopa miContexto;
    
    protected DetectorDireccionColision detectorDireccionColision;

    public VisitorKoopaEnCaparazon(KoopaEnCaparazon miEstado) {
        this.miEstado = miEstado;
        this.miContexto = miEstado.obtenerContext();
        this.detectorDireccionColision = new DetectorDireccionColision();
    }

    @Override
    public void visitarBuzzyBeetle(BuzzyBeetle buzzyBeetle) {
        detectorDireccionColision.verificarColisionElementoDeJuegoYEntidad(this.miContexto, buzzyBeetle);
    }

    @Override
    public void visitarSpiny(Spiny spiny) {
        detectorDireccionColision.verificarColisionElementoDeJuegoYEntidad(this.miContexto, spiny);
    }

    @Override
    public void visitarGoomba(Goomba goomba) {
        detectorDireccionColision.verificarColisionElementoDeJuegoYEntidad(this.miContexto, goomba);
    }

    @Override
    public void visitarContextoKoopaTroopa(ContextoKoopaTroopa contextoKoopaTroopa) {
        detectorDireccionColision.verificarColisionElementoDeJuegoYEntidad(this.miContexto, contextoKoopaTroopa);
    }

    @Override
    public void visitarKoopaEnCaparazon(KoopaEnCaparazon koopaEnCaparazon) {}

    @Override
    public void visitarKoopaDefault(KoopaDefault koopaDefault) {
        detectorDireccionColision.verificarColisionElementoDeJuegoYEntidad(this.miContexto, koopaDefault.obtenerContext());
    }

    @Override
    public void visitarLakitu(Lakitu lakitu) {
        detectorDireccionColision.verificarColisionElementoDeJuegoYEntidad(this.miContexto, lakitu);
    }

    @Override
    public void visitarPiranhaPlant(PiranhaPlant piranhaPlant) {}

    @Override
    public void visitarSuperChampinion(SuperChampinion superChampinion) {}

    @Override
    public void visitarFlorDeFuego(FlorDeFuego florDeFuego) {}

    @Override
    public void visitarChampinionVerde(ChampinionVerde champinionVerde) {}

    @Override
    public void visitarEstrella(Estrella estrella) {}

    @Override
    public void visitarMoneda(Moneda monedas) {}

    @Override
    public void visitarBloqueDePregunta(BloqueDePregunta bloqueDePregunta) {}

    @Override
    public void visitarLadrillo(Ladrillo ladrillo) {}

    @Override
    public void visitarPrincesaPeach(PrincesaPeach princesaPeach) {}

    @Override
    public void visitarBandera(Bandera bandera) {}

    @Override
    public void visitarTuberia(Tuberia tuberia) {}

    @Override
    public void visitarBloqueSolido(BloqueSolido bloqueSolido) {}

    @Override
    public void visitarContextoMario(ContextoMario contextoMario) {
    }

    @Override
    public void visitarMarioDefault(MarioDefault marioDefault) {
    	this.detectorDireccionColision.verificarColisionElementoDeJuegoYEntidad(this.miContexto, marioDefault.obtenerContexto());
    }

    @Override
    public void visitarSuperMario(SuperMario superMario) {
    	this.detectorDireccionColision.verificarColisionElementoDeJuegoYEntidad(this.miContexto, superMario.obtenerContexto());
    }

    @Override
    public void visitarMarioFuego(MarioFuego marioFuego) {
    	this.detectorDireccionColision.verificarColisionElementoDeJuegoYEntidad(this.miContexto, marioFuego.obtenerContexto());
    }

    @Override
    public void visitarMarioInvulnerable(MarioInvulnerable marioInvulnerable) {
    	this.detectorDireccionColision.verificarColisionElementoDeJuegoYEntidad(this.miContexto, marioInvulnerable.obtenerContexto());
    }
    
    public void visitarMarioRecuperacion(MarioRecuperacion marioRecuperacion) {
    	this.detectorDireccionColision.verificarColisionElementoDeJuegoYEntidad(this.miContexto, marioRecuperacion.obtenerContexto());
    }

    @Override
    public void visitarPiso(Piso piso) {
        // TODO Auto-generated method stub
    }

	@Override
	public void visitarBolaDeFuego(BolaDeFuego fireball) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitarVacio(Vacio vacio) {
		// TODO Auto-generated method stub
		
	}
    
}
