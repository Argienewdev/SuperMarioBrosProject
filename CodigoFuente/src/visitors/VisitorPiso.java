package visitors;

import elementos.enemigos.*;
import elementos.entidades.Fireball;
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
    public void visitarLakitu(Lakitu lakitu) {    
    }

    @Override
    public void visitarPiranhaPlant(PiranhaPlant planta) {    
    }

    @Override
    public void visitarFireball(Fireball fireball) {    
        detectorDireccionColision.verificarColision(this.miEntidad, fireball);
    }

    @Override
    public void visitarSuperChampinion(SuperChampinion superChampinion) {    
        detectorDireccionColision.verificarColision(this.miEntidad, superChampinion);
    }

    @Override
    public void visitarFlorDeFuego(FlorDeFuego flor) {        
    }

    @Override
    public void visitarChampinionVerde(ChampinionVerde champinionVerde) {    
        detectorDireccionColision.verificarColision(this.miEntidad, champinionVerde);
    }

    @Override
    public void visitarEstrella(Estrella estrella) {
        detectorDireccionColision.verificarColision(this.miEntidad, estrella);
    }

    @Override
    public void visitarMonedas(Monedas monedas) {
    }

    @Override
    public void visitarMarioDefault(MarioDefault marioDefault) {
        detectorDireccionColision.verificarColision(this.miEntidad, marioDefault.getContext());
    }

    @Override
    public void visitarMarioInvulnerable(MarioInvulnerable marioInvulnerable) {
        detectorDireccionColision.verificarColision(this.miEntidad, marioInvulnerable.getContext());
    }

    @Override
    public void visitarMarioFuego(MarioFuego marioFuego) {
        detectorDireccionColision.verificarColision(this.miEntidad, marioFuego.getContext());
    }

    @Override
    public void visitarSuperMario(SuperMario superMario) {
        System.out.println("visitorPiso visitar(superMario)");
        detectorDireccionColision.verificarColision(this.miEntidad, superMario.getContext());
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
        detectorDireccionColision.verificarColision(this.miEntidad, contextoMario);
    }

    @Override
    public void visitarContextoKoopaTroopa(ContextoKoopaTroopa contextoKoopaTroopa) {    
        detectorDireccionColision.verificarColision(this.miEntidad, contextoKoopaTroopa);
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
    
}
