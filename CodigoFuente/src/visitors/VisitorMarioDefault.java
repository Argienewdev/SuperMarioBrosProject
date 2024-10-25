package visitors;

import elementos.enemigos.*;
import elementos.entidades.Fireball;
import elementos.personajes.*;
import elementos.plataformas.*;
import elementos.powerUps.*;

public class VisitorMarioDefault implements Visitante {

    protected MarioDefault miEstado;
    
    protected DetectorDireccionColision detectorDireccionColision;
    
    protected ContextoMario miEntidad;

    public VisitorMarioDefault(MarioDefault miEstado) {
        this.miEstado = miEstado;
        this.miEntidad = miEstado.getContext();
        this.detectorDireccionColision = new DetectorDireccionColision();
    }

    @Override
    public void visitarBuzzyBeetle(BuzzyBeetle buzzyBeetle) {
        // Implementación pendiente
    }

    @Override
    public void visitarSpiny(Spiny spiny) {
        // Implementación pendiente
    }

    @Override
    public void visitarGoomba(Goomba goomba) {
        // Implementación pendiente
    }

    @Override
    public void visitarContextoKoopaTroopa(ContextoKoopaTroopa contextoKoopaTroopa) {
        // Implementación pendiente
    }

    @Override
    public void visitarKoopaEnCaparazon(KoopaEnCaparazon koopaEnCaparazon) {
        // Implementación pendiente
    }

    @Override
    public void visitarKoopaDefault(KoopaDefault koopaDefault) {
        // Implementación pendiente
    }

    @Override
    public void visitarLakitu(Lakitu lakitu) {
        // Implementación pendiente
    }

    @Override
    public void visitarPiranhaPlant(PiranhaPlant piranhaPlant) {
        // Implementación pendiente
    }

    @Override
    public void visitarFireball(Fireball fireball) {
        // Implementación pendiente
    }

    @Override
    public void visitarSuperChampinion(SuperChampinion superChampinion) {
        this.miEntidad.ganarPuntos(10);
        superChampinion.eliminarDelNivel();
    }

    @Override
    public void visitarFlorDeFuego(FlorDeFuego florDeFuego) {
        this.miEntidad.ganarPuntos(5);
        florDeFuego.eliminarDelNivel();
    }

    @Override
    public void visitarChampinionVerde(ChampinionVerde champinionVerde) {
        // Implementación pendiente
    }

    @Override
    public void visitarEstrella(Estrella estrella) {
        this.miEntidad.ganarPuntos(20);
        estrella.eliminarDelNivel();
    }

    @Override
    public void visitarMonedas(Monedas monedas) {
        // Implementación pendiente
    }

    @Override
    public void visitarBloqueDePregunta(BloqueDePregunta bloqueDePregunta) {
        if (this.detectorDireccionColision.choquePorAbajo(bloqueDePregunta, this.miEntidad)) {
            bloqueDePregunta.liberarPowerUp();
        }
    }

    @Override
    public void visitarLadrillo(Ladrillo ladrillo) {
        // Implementación pendiente
    }

    @Override
    public void visitarPiso(Piso piso) {
        // Implementación pendiente
    }

    @Override
    public void visitarPrincesaPeach(PrincesaPeach princesaPeach) {
        // Implementación pendiente
    }

    @Override
    public void visitarBandera(Bandera bandera) {
        // Implementación pendiente
    }

    @Override
    public void visitarTuberia(Tuberia tuberia) {
        // Implementación pendiente
    }

    @Override
    public void visitarBloqueSolido(BloqueSolido bloqueSolido) {
        // Implementación pendiente
    }

    @Override
    public void visitarContextoMario(ContextoMario contextoMario) {
        // Implementación pendiente
    }

    @Override
    public void visitarMarioDefault(MarioDefault marioDefault) {
        // Implementación pendiente
    }

    @Override
    public void visitarSuperMario(SuperMario superMario) {
        // Implementación pendiente
    }

    @Override
    public void visitarMarioFuego(MarioFuego marioFuego) {
        // Implementación pendiente
    }

    @Override
    public void visitarMarioInvulnerable(MarioInvulnerable marioInvulnerable) {
        // Implementación pendiente
    }
    
}
