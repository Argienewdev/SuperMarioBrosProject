package visitors;

import java.awt.Point;

import elementos.enemigos.*;
import elementos.entidades.BolaDeFuego;
import elementos.personajes.*;
import elementos.plataformas.*;
import elementos.powerUps.*;

public class VisitorBloqueSolido implements Visitante {
    
    private BloqueSolido miEntidad;
    
    protected DetectorDireccionColision detectorDireccionColision;
    
    public VisitorBloqueSolido(BloqueSolido miEntidad) {
        this.miEntidad = miEntidad;
        this.detectorDireccionColision = new DetectorDireccionColision();
    }
    
    @Override
    public void visitarBuzzyBeetle(BuzzyBeetle buzzy) {
        this.detectorDireccionColision.verificarColisionElementoDeJuegoYEntidad(this.miEntidad, buzzy);
    }

    @Override
    public void visitarSpiny(Spiny spiny) {
    	if(!spiny.obtenerAterrizo()) {
    		spiny.establecerAterrizo(true);
    	}
        detectorDireccionColision.verificarColisionElementoDeJuegoYEntidad(this.miEntidad, spiny);
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
    public void visitarPiranhaPlant(PiranhaPlant planta) {    
    }
    
    @Override
    public void visitarSuperChampinion(SuperChampinion superChamp) {
        this.detectorDireccionColision.verificarColisionElementoDeJuegoYEntidad(this.miEntidad, superChamp);
    }
    
    @Override
    public void visitarFlorDeFuego(FlorDeFuego flor) {        
    }

    @Override
    public void visitarChampinionVerde(ChampinionVerde champVerde) {
        this.detectorDireccionColision.verificarColisionElementoDeJuegoYEntidad(this.miEntidad, champVerde);
    }
    
    @Override
    public void visitarEstrella(Estrella estrella) {
        this.detectorDireccionColision.verificarColisionElementoDeJuegoYEntidad(this.miEntidad, estrella);
    }
    
    @Override
    public void visitarMoneda(Moneda monedas) {
        
    }
    
    @Override
    public void visitarMarioDefault(MarioDefault marioNormal) {
    }
    
    @Override
    public void visitarMarioInvulnerable(MarioInvulnerable marioInv) {
    }

    @Override
    public void visitarMarioFuego(MarioFuego marioFuego) {
    }

    @Override
    public void visitarSuperMario(SuperMario superMario) {
    }
    
    @Override
    public void visitarMarioRecuperacion(MarioRecuperacion marioRecuperacion) {
    }

    @Override
    public void visitarBloqueDePregunta(BloqueDePregunta bloquePregunta) {        
    }

    @Override
    public void visitarLadrillo(Ladrillo ladrillo) {    }
    
    @Override
    public void visitarPrincesaPeach(PrincesaPeach princesa) {}

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
    public void visitarContextoKoopaTroopa(ContextoKoopaTroopa contextoKoopa) {    
        this.detectorDireccionColision.verificarColisionElementoDeJuegoYEntidad(this.miEntidad, contextoKoopa);
    }

    @Override
    public void visitarKoopaEnCaparazon(KoopaEnCaparazon koopaEnCaparazon) {}

    @Override
    public void visitarKoopaDefault(KoopaDefault koopaDefault) {}

	@Override
	public void visitarPiso(Piso piso) {}

	@Override
	public void visitarBolaDeFuego(BolaDeFuego fireball) {
		if(detectorDireccionColision.choquePorArriba(miEntidad, fireball)) {
   			fireball.retrotraerMovimientoVertical(miEntidad.obtenerHitbox().y - fireball.obtenerAlto());
   			fireball.rebotar();
   		} else {
   			fireball.establecerRemovido(true);
   		}
	}

	@Override
	public void visitarVacio(Vacio vacio) {
	}

}
