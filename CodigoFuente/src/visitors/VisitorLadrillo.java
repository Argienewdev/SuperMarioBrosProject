package visitors;

import elementos.enemigos.*;
import elementos.entidades.BolaDeFuego;
import elementos.personajes.*;
import elementos.plataformas.*;
import elementos.powerUps.*;
import generadores.GeneradorSonidos;

public class VisitorLadrillo implements Visitante {
    
    private Ladrillo miEntidad;
    
    protected DetectorDireccionColision detectorDireccionColision;
    
    protected GeneradorSonidos generadorSonidos;

    public VisitorLadrillo(Ladrillo miEntidad, GeneradorSonidos generadorSonidos) {
        this.generadorSonidos = generadorSonidos;
    	this.miEntidad = miEntidad;
        this.detectorDireccionColision = new DetectorDireccionColision();
    }

    @Override
    public void visitarBuzzyBeetle(BuzzyBeetle buzzyBeetle) {
        this.detectorDireccionColision.verificarColisionElementoDeJuegoYEntidad(this.miEntidad, buzzyBeetle);
    }

    @Override
    public void visitarSpiny(Spiny spiny) {
    	if (!spiny.obtenerAterrizo()) {
    		spiny.establecerAterrizo(true);
    	}
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
    public void visitarPiranhaPlant(PiranhaPlant piranhaPlant) {    
    }
    
    @Override
    public void visitarSuperChampinion(SuperChampinion superChampinion) {    
        this.detectorDireccionColision.verificarColisionElementoDeJuegoYEntidad(this.miEntidad, superChampinion);
    }
    
    @Override
    public void visitarFlorDeFuego(FlorDeFuego florDeFuego) {        
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
    public void visitarMoneda(Moneda moneda) {
    	this.detectorDireccionColision.verificarColisionElementoDeJuegoYEntidad(this.miEntidad, moneda);
    }
    
    @Override
    public void visitarMarioDefault(MarioDefault marioDefault) {
        this.detectorDireccionColision.verificarColisionElementoDeJuegoYEntidad(this.miEntidad, marioDefault.obtenerContexto());
    }
    
    @Override
    public void visitarMarioInvulnerable(MarioInvulnerable marioInvulnerable) {
        this.detectorDireccionColision.verificarColisionElementoDeJuegoYEntidad(this.miEntidad, marioInvulnerable.obtenerContexto());
    }

    @Override
    public void visitarMarioFuego(MarioFuego marioFuego) {
        this.detectorDireccionColision.verificarColisionElementoDeJuegoYEntidad(this.miEntidad, marioFuego.obtenerContexto());
    }

    @Override
    public void visitarSuperMario(SuperMario superMario) {
        this.detectorDireccionColision.verificarColisionElementoDeJuegoYEntidad(this.miEntidad, superMario.obtenerContexto());
    }
    
    public void visitarMarioRecuperacion(MarioRecuperacion marioRecuperacion) {
    	this.detectorDireccionColision.verificarColisionElementoDeJuegoYEntidad(this.miEntidad, marioRecuperacion.obtenerContexto());
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
    }

    @Override
	public void visitarBolaDeFuego(BolaDeFuego fireball) {
		if (this.detectorDireccionColision.choquePorArriba(miEntidad, fireball)) {
   			fireball.retrotraerMovimientoVertical(miEntidad.obtenerHitbox().y - fireball.obtenerAlto());
   			fireball.rebotar();
   		} else if(!fireball.obtenerRemovido()){
   			generadorSonidos.choqueFireball();
   			fireball.establecerRemovido(true);
   		}
	}

	@Override
	public void visitarVacio(Vacio vacio) {
	}
    
}
