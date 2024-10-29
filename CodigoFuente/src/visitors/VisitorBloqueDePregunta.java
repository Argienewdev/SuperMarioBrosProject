package visitors;

import elementos.enemigos.*;
import elementos.entidades.BolaDeFuego;
import elementos.personajes.*;
import elementos.plataformas.*;
import elementos.powerUps.*;

public class VisitorBloqueDePregunta implements Visitante {
    
    private BloqueDePregunta miEntidad;
    
    protected DetectorDireccionColision detectorDireccionColision;
    
    public VisitorBloqueDePregunta(BloqueDePregunta miEntidad) {
        this.miEntidad = miEntidad;
        this.detectorDireccionColision = new DetectorDireccionColision();
    }

    @Override
    public void visitarBuzzyBeetle(BuzzyBeetle buzzyBeetle) {
        this.detectorDireccionColision.verificarColision(this.miEntidad, buzzyBeetle);
    }

    @Override
    public void visitarSpiny(Spiny spiny) {
        this.detectorDireccionColision.verificarColision(this.miEntidad, spiny);
    }

    @Override
    public void visitarGoomba(Goomba goomba) {
        this.detectorDireccionColision.verificarColision(this.miEntidad, goomba);
    }
    
    @Override
    public void visitarContextoMario(ContextoMario contextoMario) {
        this.detectorDireccionColision.verificarColision(this.miEntidad, contextoMario);
    }
    
    @Override
    public void visitarContextoKoopaTroopa(ContextoKoopaTroopa contextoKoopaTroopa) {
        this.detectorDireccionColision.verificarColision(this.miEntidad, contextoKoopaTroopa);
    }

    @Override
    public void visitarLakitu(Lakitu lakitu) {    
        this.detectorDireccionColision.verificarColision(this.miEntidad, lakitu);
    }
    
    @Override
    public void visitarPiranhaPlant(PiranhaPlant piranhaPlant) {}
    
    
    @Override
    public void visitarSuperChampinion(SuperChampinion superChampinion) {   
        this.detectorDireccionColision.verificarColision(this.miEntidad, superChampinion);
    }
    
    @Override
    public void visitarFlorDeFuego(FlorDeFuego florDeFuego) {}

    @Override
    public void visitarChampinionVerde(ChampinionVerde champinionVerde) {
        this.detectorDireccionColision.verificarColision(this.miEntidad, champinionVerde);

    }
    
    @Override
    public void visitarEstrella(Estrella estrella) {    
        this.detectorDireccionColision.verificarColision(this.miEntidad, estrella);
    }
    
    @Override
    public void visitarMonedas(Monedas monedas) {}

    @Override
    public void visitarMarioDefault(MarioDefault marioDefault) {}

    @Override
    public void visitarMarioInvulnerable(MarioInvulnerable marioInvulnerable) {}

    @Override
    public void visitarMarioFuego(MarioFuego marioFuego) {  }
    
    @Override
    public void visitarMarioRecuperacion(MarioRecuperacion marioRecuperacion) {}

    @Override
    public void visitarSuperMario(SuperMario superMario) {}

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
    public void visitarKoopaEnCaparazon(KoopaEnCaparazon koopaEnCaparazon) {}

    @Override
    public void visitarKoopaDefault(KoopaDefault koopaDefault) {}

	@Override
	public void visitarPiso(Piso piso) {}

	@Override
	public void visitarBolaDeFuego(BolaDeFuego fireball) {
		//TODO Si la bola de fuego choca de costado a este bloque, es eliminada
	}

	@Override
	public void visitarVacio(Vacio vacio) {
		// TODO Auto-generated method stub
		
	}

}
