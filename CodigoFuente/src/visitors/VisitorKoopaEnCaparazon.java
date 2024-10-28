package visitors;

import elementos.enemigos.*;
import elementos.entidades.BolaDeFuego;
import elementos.personajes.*;
import elementos.plataformas.*;
import elementos.powerUps.*;

public class VisitorKoopaEnCaparazon implements Visitante {

    protected EstadoKoopa miEstado;
    
    private ContextoKoopaTroopa miEntidad;
    
    protected DetectorDireccionColision detectorDireccionColision;

    public VisitorKoopaEnCaparazon(KoopaEnCaparazon miEstado) {
        this.miEstado = miEstado;
        this.miEntidad = miEstado.getContext();
        this.detectorDireccionColision = new DetectorDireccionColision();
    }

    @Override
    public void visitarBuzzyBeetle(BuzzyBeetle buzzyBeetle) {
        detectorDireccionColision.verificarColision(this.miEntidad, buzzyBeetle);
    }

    @Override
    public void visitarSpiny(Spiny spiny) {
        detectorDireccionColision.verificarColision(this.miEntidad, spiny);
    }

    @Override
    public void visitarGoomba(Goomba goomba) {
        detectorDireccionColision.verificarColision(this.miEntidad, goomba);
    }

    @Override
    public void visitarContextoKoopaTroopa(ContextoKoopaTroopa contextoKoopaTroopa) {
        detectorDireccionColision.verificarColision(this.miEntidad, contextoKoopaTroopa);
    }

    @Override
    public void visitarKoopaEnCaparazon(KoopaEnCaparazon koopaEnCaparazon) {}

    @Override
    public void visitarKoopaDefault(KoopaDefault koopaDefault) {
        detectorDireccionColision.verificarColision(this.miEntidad, koopaDefault.getContext());
    }

    @Override
    public void visitarLakitu(Lakitu lakitu) {
        detectorDireccionColision.verificarColision(this.miEntidad, lakitu);
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
        detectorDireccionColision.verificarColision(this.miEntidad, contextoMario);
    }

    @Override
    public void visitarMarioDefault(MarioDefault marioDefault) {
        detectorDireccionColision.verificarColision(this.miEntidad, marioDefault.getContext());
    }

    @Override
    public void visitarSuperMario(SuperMario superMario) {
    	detectorDireccionColision.verificarColision(this.miEntidad, superMario.getContext());
    }

    @Override
    public void visitarMarioFuego(MarioFuego marioFuego) {
    	detectorDireccionColision.verificarColision(this.miEntidad, marioFuego.getContext());
    }

    @Override
    public void visitarMarioInvulnerable(MarioInvulnerable marioInvulnerable) {
    	detectorDireccionColision.verificarColision(this.miEntidad, marioInvulnerable.getContext());
    }
    
    public void visitarMarioRecuperacion(MarioRecuperacion marioRecuperacion) {
    	detectorDireccionColision.verificarColision(this.miEntidad, marioRecuperacion.getContext());
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
