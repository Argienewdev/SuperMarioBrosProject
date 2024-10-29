package visitors;

import java.awt.Point;

import elementos.enemigos.*;
import elementos.entidades.BolaDeFuego;
import elementos.personajes.*;
import elementos.plataformas.*;
import elementos.powerUps.*;

public class VisitorLadrillo implements Visitante {
    
    private Ladrillo miEntidad;
    
    protected DetectorDireccionColision detectorDireccionColision;

    public VisitorLadrillo(Ladrillo miEntidad) {
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
        // Implementar lógica aquí si es necesario
    }
    
    @Override
    public void visitarPiranhaPlant(PiranhaPlant piranhaPlant) {    
        // Implementar lógica aquí si es necesario
    }
    
    @Override
    public void visitarSuperChampinion(SuperChampinion superChampinion) {    
        this.detectorDireccionColision.verificarColisionElementoDeJuegoYEntidad(this.miEntidad, superChampinion);
    }
    
    @Override
    public void visitarFlorDeFuego(FlorDeFuego florDeFuego) {        
        // Implementar lógica aquí si es necesario
    }

    @Override
    public void visitarChampinionVerde(ChampinionVerde champinionVerde) {    
        this.detectorDireccionColision.verificarColisionElementoDeJuegoYEntidad(this.miEntidad, champinionVerde);
    }
    
    @Override
    public void visitarEstrella(Estrella estrella) {
        this.detectorDireccionColision.verificarColisionElementoDeJuegoYEntidad(this.miEntidad, estrella);
    }
    
    @Override
    public void visitarMonedas(Monedas monedas) {
        // Implementar lógica aquí si es necesario
    }
    
    @Override
    public void visitarMarioDefault(MarioDefault marioDefault) {
        this.detectorDireccionColision.verificarColisionElementoDeJuegoYEntidad(this.miEntidad, marioDefault.getContext());
    }
    
    @Override
    public void visitarMarioInvulnerable(MarioInvulnerable marioInvulnerable) {
        this.detectorDireccionColision.verificarColisionElementoDeJuegoYEntidad(this.miEntidad, marioInvulnerable.getContext());
    }

    @Override
    public void visitarMarioFuego(MarioFuego marioFuego) {
        this.detectorDireccionColision.verificarColisionElementoDeJuegoYEntidad(this.miEntidad, marioFuego.getContext());
    }

    @Override
    public void visitarSuperMario(SuperMario superMario) {
        this.detectorDireccionColision.verificarColisionElementoDeJuegoYEntidad(this.miEntidad, superMario.getContext());
    }
    
    public void visitarMarioRecuperacion(MarioRecuperacion marioRecuperacion) {
    	this.detectorDireccionColision.verificarColisionElementoDeJuegoYEntidad(this.miEntidad, marioRecuperacion.getContext());
    }

    @Override
    public void visitarBloqueDePregunta(BloqueDePregunta bloqueDePregunta) {        
        // Implementar lógica aquí si es necesario
    }

    @Override
    public void visitarLadrillo(Ladrillo ladrillo) {    
        // Implementar lógica aquí si es necesario
    }
    
    @Override
    public void visitarPrincesaPeach(PrincesaPeach princesaPeach) {
        // Implementar lógica aquí si es necesario
    }

    @Override
    public void visitarBandera(Bandera bandera) {
        // Implementar lógica aquí si es necesario
    }
    
    @Override
    public void visitarTuberia(Tuberia tuberia) {    
        // Implementar lógica aquí si es necesario
    }

    @Override
    public void visitarBloqueSolido(BloqueSolido bloqueSolido) {        
        // Implementar lógica aquí si es necesario
    }

    @Override
    public void visitarContextoMario(ContextoMario contextoMario) {        
        this.detectorDireccionColision.verificarColisionElementoDeJuegoYEntidad(this.miEntidad, contextoMario);
    }
    
    @Override
    public void visitarContextoKoopaTroopa(ContextoKoopaTroopa contextoKoopaTroopa) { 
        this.detectorDireccionColision.verificarColisionElementoDeJuegoYEntidad(this.miEntidad, contextoKoopaTroopa);
    }

    @Override
    public void visitarKoopaEnCaparazon(KoopaEnCaparazon koopaEnCaparazon) {
    }

    @Override
    public void visitarKoopaDefault(KoopaDefault koopaDefault) {
    }

    @Override
    public void visitarPiso(Piso piso) {
        // Implementar lógica aquí si es necesario
    }

    @Override
	public void visitarBolaDeFuego(BolaDeFuego fireball) {
		if(detectorDireccionColision.choquePorArriba(miEntidad, fireball)) {
   			fireball.retrotraerMovimientoVertical(miEntidad.obtenerHitbox().y - fireball.obtenerAlto());
   			int velocidadActualEnX = fireball.getVelocidadDireccional().x;
   			Point salto = new Point(velocidadActualEnX,-20);
   			fireball.setVelocidadDireccional(salto);
   		}else {
   			fireball.setRemovido(true);
   		}
	}
    
}
