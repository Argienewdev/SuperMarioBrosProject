package visitors;

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
        this.detectorDireccionColision.verificarColision(this.miEntidad, buzzy);
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
    public void visitarLakitu(Lakitu lakitu) {    
    }
    
    @Override
    public void visitarPiranhaPlant(PiranhaPlant planta) {    
    }
    
    @Override
    public void visitarSuperChampinion(SuperChampinion superChamp) {
        this.detectorDireccionColision.verificarColision(this.miEntidad, superChamp);
    }
    
    @Override
    public void visitarFlorDeFuego(FlorDeFuego flor) {        
    }

    @Override
    public void visitarChampinionVerde(ChampinionVerde champVerde) {
        this.detectorDireccionColision.verificarColision(this.miEntidad, champVerde);
    }
    
    @Override
    public void visitarEstrella(Estrella estrella) {
        this.detectorDireccionColision.verificarColision(this.miEntidad, estrella);
    }
    
    @Override
    public void visitarMonedas(Monedas monedas) {
        
    }
    
    @Override
    public void visitarMarioDefault(MarioDefault marioNormal) {
        this.detectorDireccionColision.verificarColision(this.miEntidad, marioNormal.getContext());
    }
    
    @Override
    public void visitarMarioInvulnerable(MarioInvulnerable marioInv) {
        this.detectorDireccionColision.verificarColision(this.miEntidad, marioInv.getContext());
    }

    @Override
    public void visitarMarioFuego(MarioFuego marioFuego) {
        this.detectorDireccionColision.verificarColision(this.miEntidad, marioFuego.getContext());
    }

    @Override
    public void visitarSuperMario(SuperMario superMario) {
        this.detectorDireccionColision.verificarColision(this.miEntidad, superMario.getContext());
    }

    @Override
    public void visitarBloqueDePregunta(BloqueDePregunta bloquePregunta) {        
    }

    @Override
    public void visitarLadrillo(Ladrillo ladrillo) {    
    }
    
    @Override
    public void visitarPrincesaPeach(PrincesaPeach princesa) {
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
        this.detectorDireccionColision.verificarColision(this.miEntidad, contextoMario);
    }
    
    @Override
    public void visitarContextoKoopaTroopa(ContextoKoopaTroopa contextoKoopa) {    
        this.detectorDireccionColision.verificarColision(this.miEntidad, contextoKoopa);
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
