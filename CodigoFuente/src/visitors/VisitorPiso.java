package visitors;

import java.awt.Point;

import elementos.enemigos.*;
import elementos.entidades.BolaDeFuego;
import elementos.personajes.*;
import elementos.plataformas.*;
import elementos.powerUps.*;

public class VisitorPiso implements Visitante {

    protected Piso miEntidad;
    
    protected DetectorDireccionColision detectorDireccionColision;

    public VisitorPiso(Piso miEntidad) {
        this.miEntidad = miEntidad;
        this.detectorDireccionColision = new DetectorDireccionColision();
    }

    @Override
    public void visitarBuzzyBeetle(BuzzyBeetle buzzyBeetle) {
        detectorDireccionColision.verificarColisionElementoDeJuegoYEntidad(this.miEntidad, buzzyBeetle);
    }

    @Override
    public void visitarSpiny(Spiny spiny) {    
        detectorDireccionColision.verificarColisionElementoDeJuegoYEntidad(this.miEntidad, spiny);
    }

    @Override
    public void visitarGoomba(Goomba goomba) {
        detectorDireccionColision.verificarColisionElementoDeJuegoYEntidad(this.miEntidad, goomba);
    }

    @Override
    public void visitarLakitu(Lakitu lakitu) {
    }

    @Override
    public void visitarPiranhaPlant(PiranhaPlant planta) {
    }

    @Override
    public void visitarSuperChampinion(SuperChampinion superChampinion) {    
        detectorDireccionColision.verificarColisionElementoDeJuegoYEntidad(this.miEntidad, superChampinion);
    }

    @Override
    public void visitarFlorDeFuego(FlorDeFuego flor) {
    }

    @Override
    public void visitarChampinionVerde(ChampinionVerde champinionVerde) {    
        detectorDireccionColision.verificarColisionElementoDeJuegoYEntidad(this.miEntidad, champinionVerde);
    }

    @Override
    public void visitarEstrella(Estrella estrella) {
        detectorDireccionColision.verificarColisionElementoDeJuegoYEntidad(this.miEntidad, estrella);
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
<<<<<<< HEAD
        detectorDireccionColision.verificarColisionElementoDeJuegoYEntidad(this.miEntidad, contextoMario);
=======
        detectorDireccionColision.verificarColision(this.miEntidad, contextoMario);
>>>>>>> refs/remotes/origin/main
        contextoMario.setColisionAbajo(true);
    }

    @Override
    public void visitarContextoKoopaTroopa(ContextoKoopaTroopa contextoKoopaTroopa) {    
        detectorDireccionColision.verificarColisionElementoDeJuegoYEntidad(this.miEntidad, contextoKoopaTroopa);
    }

    @Override
    public void visitarKoopaEnCaparazon(KoopaEnCaparazon koopaEnCaparazon) {}

    @Override
    public void visitarKoopaDefault(KoopaDefault koopaDefault) {}

    @Override
    public void visitarPiso(Piso piso) {
    }

    @Override
   	public void visitarBolaDeFuego(BolaDeFuego fireball) {
   		if(detectorDireccionColision.choquePorArriba(miEntidad, fireball)) {
   			fireball.retrotraerMovimientoVertical(miEntidad.obtenerHitbox().y - fireball.obtenerAlto());
   			int velocidadActualEnX = fireball.getVelocidadDireccional().x;
   			Point salto = new Point(velocidadActualEnX, -20);
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
