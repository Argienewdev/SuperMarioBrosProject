package visitors;

import elementos.enemigos.*;
import elementos.entidades.Fireball;
import elementos.personajes.*;
import elementos.plataformas.*;
import elementos.powerUps.*;

public class VisitorKoopaDefault implements Visitante {

    protected EstadoKoopa miEstado;
    
    private ContextoKoopaTroopa miEntidad;

    public VisitorKoopaDefault(KoopaDefault miEstado) {
        this.miEstado = miEstado;
        this.miEntidad = miEstado.getContext();
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
        // TODO Auto-generated method stub
    }

    @Override
    public void visitarMarioDefault(MarioDefault marioDefault) {
        // TODO Auto-generated method stub
    }

    @Override
    public void visitarSuperMario(SuperMario superMario) {
        // TODO Auto-generated method stub
    }

    @Override
    public void visitarMarioFuego(MarioFuego marioFuego) {
        // TODO Auto-generated method stub
    }

    @Override
    public void visitarMarioInvulnerable(MarioInvulnerable marioInvulnerable) {
        // TODO Auto-generated method stub
    }

    @Override
    public void visitarPiso(Piso piso) {
        // TODO Auto-generated method stub
    }
    
}
