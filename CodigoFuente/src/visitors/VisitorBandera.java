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

    @Override
    public void visitarBuzzyBeetle(BuzzyBeetle buzzyBeetle) {    
    }

    @Override
    public void visitarSpiny(Spiny spiny) {    
    }

    @Override
    public void visitarGoomba(Goomba goomba) {    
    }
    
    @Override
    public void visitarContextoKoopaTroopa(ContextoKoopaTroopa contextoKoopaTroopa) {    
    }

    @Override
    public void visitarLakitu(Lakitu lakitu) {    
    }
    
    @Override
    public void visitarPiranhaPlant(PiranhaPlant piranhaPlant) {    
    }

    @Override
    public void visitarSuperChampinion(SuperChampinion superChampinion) {    
    }
    
    @Override
    public void visitarFlorDeFuego(FlorDeFuego florDeFuego) {        
    }

    @Override
    public void visitarChampinionVerde(ChampinionVerde champinionVerde) {    
    }
    
    @Override
    public void visitarEstrella(Estrella estrella) {    
    }
    
    @Override
    public void visitarMonedas(Monedas monedas) {    
    }

    @Override
    public void visitarContextoMario(ContextoMario contextoMario) {
    	//TODO el visitor de mario visita a la bandera y termina el nivel, es al reves 
    	this.miEntidad.getNivel().setCompletado(true);
        this.controlador.eliminarNivelActual();
        contextoMario.reiniciarEstado();
        this.detectorDireccionColision.verificarColision(miEntidad, contextoMario);
    }

    @Override
    public void visitarMarioDefault(MarioDefault marioDefault) {}
    
    @Override
    public void visitarMarioInvulnerable(MarioInvulnerable marioInvulnerable) {}

    @Override
    public void visitarMarioFuego(MarioFuego marioFuego) {}

    @Override
    public void visitarSuperMario(SuperMario superMario) {}
    
    public void visitarMarioRecuperacion(MarioRecuperacion marioRecuperacion) {}

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
    public void visitarKoopaEnCaparazon(KoopaEnCaparazon koopaEnCaparazon) {        
    }

    @Override
    public void visitarKoopaDefault(KoopaDefault koopaDefault) {        
    }

	@Override
	public void visitarPiso(Piso piso) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitarBolaDeFuego(BolaDeFuego fireball) {
		// TODO Auto-generated method stub
		
	}

}
