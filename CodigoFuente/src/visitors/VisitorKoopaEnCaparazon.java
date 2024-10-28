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
        // TODO Auto-generated method stub
    }

    @Override
    public void visitarSpiny(Spiny spiny) {
        // TODO Auto-generated method stub
    }

    @Override
    public void visitarGoomba(Goomba goomba) {
        // TODO Auto-generated method stub
    }

    @Override
    public void visitarContextoKoopaTroopa(ContextoKoopaTroopa contextoKoopaTroopa) {
        // TODO Auto-generated method stub
    }

    @Override
    public void visitarKoopaEnCaparazon(KoopaEnCaparazon koopaEnCaparazon) {
        // TODO Auto-generated method stub
    }

    @Override
    public void visitarKoopaDefault(KoopaDefault koopaDefault) {
        // TODO Auto-generated method stub
    }

    @Override
    public void visitarLakitu(Lakitu lakitu) {
        // TODO Auto-generated method stub
    }

    @Override
    public void visitarPiranhaPlant(PiranhaPlant piranhaPlant) {
        // TODO Auto-generated method stub
    }

    @Override
    public void visitarSuperChampinion(SuperChampinion superChampinion) {
        // TODO Auto-generated method stub
    }

    @Override
    public void visitarFlorDeFuego(FlorDeFuego florDeFuego) {
        // TODO Auto-generated method stub
    }

    @Override
    public void visitarChampinionVerde(ChampinionVerde champinionVerde) {
        // TODO Auto-generated method stub
    }

    @Override
    public void visitarEstrella(Estrella estrella) {
        // TODO Auto-generated method stub
    }

    @Override
    public void visitarMonedas(Monedas monedas) {
        // TODO Auto-generated method stub
    }

    @Override
    public void visitarBloqueDePregunta(BloqueDePregunta bloqueDePregunta) {
        // TODO Auto-generated method stub
    }

    @Override
    public void visitarLadrillo(Ladrillo ladrillo) {
        // TODO Auto-generated method stub
    }

    @Override
    public void visitarPrincesaPeach(PrincesaPeach princesaPeach) {
        // TODO Auto-generated method stub
    }

    @Override
    public void visitarBandera(Bandera bandera) {
        // TODO Auto-generated method stub
    }

    @Override
    public void visitarTuberia(Tuberia tuberia) {
        // TODO Auto-generated method stub
    }

    @Override
    public void visitarBloqueSolido(BloqueSolido bloqueSolido) {
        // TODO Auto-generated method stub
    }

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
