package visitors;

import java.awt.Point;

import elementos.enemigos.*;
import elementos.entidades.BolaDeFuego;
import elementos.personajes.*;
import elementos.plataformas.*;
import elementos.powerUps.*;

public class VisitorTuberia implements Visitante {

    protected Tuberia miEntidad;

    protected DetectorDireccionColision detectorDireccionColision;

    public VisitorTuberia(Tuberia miEntidad) {
        this.miEntidad = miEntidad;
        this.detectorDireccionColision = new DetectorDireccionColision();
    }

    @Override
    public void visitarBuzzyBeetle(BuzzyBeetle buzzyBeetle) {
        this.detectorDireccionColision.verificarColisionElementoDeJuegoYEntidad(this.miEntidad, buzzyBeetle);
    }

    @Override
    public void visitarSpiny(Spiny spiny) {
        this.detectorDireccionColision.verificarColisionElementoDeJuegoYEntidad(this.miEntidad, spiny);
    }

    @Override
    public void visitarGoomba(Goomba goomba) {
        this.detectorDireccionColision.verificarColisionElementoDeJuegoYEntidad(this.miEntidad, goomba);
    }

    @Override
    public void visitarLakitu(Lakitu lakitu) {
        this.detectorDireccionColision.verificarColisionElementoDeJuegoYEntidad(this.miEntidad, lakitu);
    }

    @Override
    public void visitarPiranhaPlant(PiranhaPlant planta) {}

    @Override
    public void visitarSuperChampinion(SuperChampinion superChampinion) {
        this.detectorDireccionColision.verificarColisionElementoDeJuegoYEntidad(this.miEntidad, superChampinion);
    }

    @Override
    public void visitarFlorDeFuego(FlorDeFuego florDeFuego) {}

    @Override
    public void visitarChampinionVerde(ChampinionVerde champinionVerde) {
        this.detectorDireccionColision.verificarColisionElementoDeJuegoYEntidad(this.miEntidad, champinionVerde);
    }

    @Override
    public void visitarEstrella(Estrella estrella) {
        this.detectorDireccionColision.verificarColisionElementoDeJuegoYEntidad(this.miEntidad, estrella);
    }

    @Override
    public void visitarMonedas(Monedas monedas) {}

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
        this.detectorDireccionColision.verificarColisionElementoDeJuegoYEntidad(this.miEntidad, contextoMario);
    }

    @Override
    public void visitarContextoKoopaTroopa(ContextoKoopaTroopa contextoKoopaTroopa) {
        this.detectorDireccionColision.verificarColisionElementoDeJuegoYEntidad(this.miEntidad, contextoKoopaTroopa);
    }

    @Override
    public void visitarKoopaEnCaparazon(KoopaEnCaparazon koopaEnCaparazon) {}

    @Override
    public void visitarKoopaDefault(KoopaDefault koopaDefault) {}

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

	public void visitarBolaDeFuego(BolaDeFuego fireball) {
		if(detectorDireccionColision.choquePorArriba(this.miEntidad, fireball)) {
   			fireball.retrotraerMovimientoVertical(this.miEntidad.obtenerHitbox().y - fireball.obtenerAlto());
   			int velocidadActualEnX = fireball.getVelocidadDireccional().x;
   			Point salto = new Point(velocidadActualEnX, -30);
   			fireball.setVelocidadDireccional(salto);
   		} else {
   			fireball.setRemovido(true);
   		}	
	}

	@Override
	public void visitarVacio(Vacio vacio) {
		// TODO Auto-generated method stub
		
	}
}
