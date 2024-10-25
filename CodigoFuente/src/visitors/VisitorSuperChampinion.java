package visitors;

import elementos.enemigos.*;
import elementos.entidades.Fireball;
import elementos.personajes.*;
import elementos.plataformas.*;
import elementos.powerUps.*;

public class VisitorSuperChampinion implements Visitante {

    protected SuperChampinion miEntidad;
    
    protected DetectorDireccionColision detectorDireccionColision;

    public VisitorSuperChampinion(SuperChampinion miEntidad) {
        this.miEntidad = miEntidad;
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
    public void visitarLakitu(Lakitu lakitu) {
        // TODO Auto-generated method stub
    }

    @Override
    public void visitarPiranhaPlant(PiranhaPlant piranhaPlant) {
        // TODO Auto-generated method stub
    }

    @Override
    public void visitarFireball(Fireball fireball) {
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
    public void visitarContextoMario(ContextoMario contextoMario) {
        contextoMario.getEstado().aceptarVisitante(this);
    }

    @Override
    public void visitarMarioDefault(MarioDefault marioDefault) {
        ContextoMario contextoMario = marioDefault.getContext();
        EstadoMario nuevoEstado = new SuperMario();
        contextoMario.cambiarEstado(nuevoEstado);
        contextoMario.ganarPuntos(this.miEntidad.obtenerPuntosPorDefault());
    }

    @Override
    public void visitarSuperMario(SuperMario superMario) {
        ContextoMario contextoMario = superMario.getContext();
        contextoMario.ganarPuntos(this.miEntidad.obtenerPuntosPorSuper());
    }

    @Override
    public void visitarMarioFuego(MarioFuego marioFuego) {
        ContextoMario contextoMario = marioFuego.getContext();
        contextoMario.ganarPuntos(this.miEntidad.obtenerPuntosPorFuego());
    }

    @Override
    public void visitarMarioInvulnerable(MarioInvulnerable marioInvulnerable) {
        ContextoMario contextoMario = marioInvulnerable.getContext();
        contextoMario.ganarPuntos(this.miEntidad.obtenerPuntosPorInvulnerable());
    }

    @Override
    public void visitarBloqueDePregunta(BloqueDePregunta bloquePregunta) {
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
    public void visitarPiso(Piso piso) {
        // TODO Auto-generated method stub
    }
    
}
