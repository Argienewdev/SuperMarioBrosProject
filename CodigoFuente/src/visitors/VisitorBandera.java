package visitors;

import elementos.enemigos.*;
import elementos.entidades.BolaDeFuego;
import elementos.personajes.*;
import elementos.plataformas.*;
import elementos.powerUps.*;
import ventanas.ControladorVistas;

public class VisitorBandera implements Visitante {
    
    private Bandera miEntidad;
    
    private ControladorVistas controlador;
    
    protected DetectorDireccionColision detectorDireccionColision;
   
    public VisitorBandera(ControladorVistas controlador, Bandera miEntidad) {
        this.controlador = controlador;
        this.miEntidad = miEntidad;
        this.detectorDireccionColision = new DetectorDireccionColision();
    }

    
    public void visitarBuzzyBeetle(BuzzyBeetle buzzyBeetle) {    
    }

    
    public void visitarSpiny(Spiny spiny) {    
    }

    
    public void visitarGoomba(Goomba goomba) {    
    }
    
    
    public void visitarContextoKoopaTroopa(ContextoKoopaTroopa contextoKoopaTroopa) {    
    }

    
    public void visitarLakitu(Lakitu lakitu) {    
    }
    
    
    public void visitarPiranhaPlant(PiranhaPlant piranhaPlant) {    
    }

    
    public void visitarSuperChampinion(SuperChampinion superChampinion) {    
    }
    
    
    public void visitarFlorDeFuego(FlorDeFuego florDeFuego) {        
    }

    
    public void visitarChampinionVerde(ChampinionVerde champinionVerde) {    
    }
    
    
    public void visitarEstrella(Estrella estrella) {    
    }
    
    
    public void visitarMoneda(Moneda monedas) {    
    }

    
    public void visitarContextoMario(ContextoMario contextoMario) {
    }

    
    public void visitarMarioDefault(MarioDefault marioDefault) {}
    
    
    public void visitarMarioInvulnerable(MarioInvulnerable marioInvulnerable) {}

    
    public void visitarMarioFuego(MarioFuego marioFuego) {}

    
    public void visitarSuperMario(SuperMario superMario) {}
    
    public void visitarMarioRecuperacion(MarioRecuperacion marioRecuperacion) {}

    
    public void visitarBloqueDePregunta(BloqueDePregunta bloqueDePregunta) {        
    }

    
    public void visitarLadrillo(Ladrillo ladrillo) {    
    }
    
    
    public void visitarPrincesaPeach(PrincesaPeach princesaPeach) {
    }

    
    public void visitarBandera(Bandera bandera) {
    }
    
    
    public void visitarTuberia(Tuberia tuberia) {    
    }

    
    public void visitarBloqueSolido(BloqueSolido bloqueSolido) {        
    }

    
    public void visitarKoopaEnCaparazon(KoopaEnCaparazon koopaEnCaparazon) {        
    }

    
    public void visitarKoopaDefault(KoopaDefault koopaDefault) {        
    }

	
	public void visitarPiso(Piso piso) {
	}
	
	public void visitarBolaDeFuego(BolaDeFuego fireball) {
		fireball.establecerRemovido(true);
	}

	
	public void visitarVacio(Vacio vacio) {

	}
}