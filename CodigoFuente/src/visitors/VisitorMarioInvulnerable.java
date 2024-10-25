package visitors;

import elementos.enemigos.*;
import elementos.entidades.Fireball;
import elementos.personajes.*;
import elementos.plataformas.*;
import elementos.powerUps.*;

public class VisitorMarioInvulnerable implements Visitante {

    protected EstadoMario miEstado;
    
    protected ContextoMario miEntidad;
    
    protected DetectorDireccionColision detectorDireccionColision;

    public VisitorMarioInvulnerable(MarioInvulnerable miEstado) {
        this.miEstado = miEstado;
        this.miEntidad = this.miEstado.getContext();
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
    public void visitarFireball(Fireball fireball) {}

    @Override
    public void visitarSuperChampinion(SuperChampinion superChampinion) {
    	this.miEntidad.ganarPuntos(superChampinion.obtenerPuntosPorInvulnerable());
        superChampinion.eliminarDelNivel();
    }

    @Override
    public void visitarFlorDeFuego(FlorDeFuego florDeFuego) {
    	this.miEntidad.ganarPuntos(florDeFuego.obtenerPuntosPorInvulnerable());
        florDeFuego.eliminarDelNivel();
    }

    @Override
    public void visitarChampinionVerde(ChampinionVerde champinionVerde) {}

    @Override
    public void visitarEstrella(Estrella estrella) {
    	this.miEntidad.ganarPuntos(estrella.obtenerPuntosPorInvulnerable());
        estrella.eliminarDelNivel();
    }

    @Override
    public void visitarMonedas(Monedas monedas) {}

    @Override
    public void visitarBloqueDePregunta(BloqueDePregunta bloqueDePregunta) {}

    @Override
    public void visitarLadrillo(Ladrillo ladrillo) {
    	if (detectorDireccionColision.choquePorAbajo(ladrillo, this.miEntidad)) {
            ladrillo.eliminarDelNivel();
        }
    }

    @Override
    public void visitarPrincesaPeach(PrincesaPeach princesaPeach) {}

    @Override
    public void visitarBandera(Bandera bandera) {}

    @Override
    public void visitarTuberia(Tuberia tuberia) {}

    @Override
    public void visitarBloqueSolido(BloqueSolido bloqueSolido) {}

    @Override
    public void visitarContextoMario(ContextoMario contextoMario) {}

    @Override
    public void visitarMarioDefault(MarioDefault marioDefault) {}

    @Override
    public void visitarSuperMario(SuperMario superMario) {}

    @Override
    public void visitarMarioFuego(MarioFuego marioFuego) {}

    @Override
    public void visitarMarioInvulnerable(MarioInvulnerable marioInvulnerable) {}

    @Override
    public void visitarPiso(Piso piso) {}
    
}
