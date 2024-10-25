package visitors;

import elementos.enemigos.*;
import elementos.entidades.Fireball;
import elementos.personajes.*;
import elementos.plataformas.*;
import elementos.powerUps.*;

public class VisitorEstrella implements Visitante {
    
    protected Estrella miEntidad;
    
    public VisitorEstrella(Estrella miEntidad) {
        this.miEntidad = miEntidad;
    }

    @Override
    public void visitarBuzzyBeetle(BuzzyBeetle buzzyBeetle) {
        // Lógica para visitar BuzzyBeetle
    }

    @Override
    public void visitarSpiny(Spiny spiny) {
        // Lógica para visitar Spiny
    }

    @Override
    public void visitarGoomba(Goomba goomba) {
        // Lógica para visitar Goomba
    }

    @Override
    public void visitarLakitu(Lakitu lakitu) {
        // Lógica para visitar Lakitu
    }

    @Override
    public void visitarPiranhaPlant(PiranhaPlant piranhaPlant) {
        // Lógica para visitar PiranhaPlant
    }

    @Override
    public void visitarFireball(Fireball fireball) {
        // Lógica para visitar Fireball
    	
    }

    @Override
    public void visitarSuperChampinion(SuperChampinion superChampinion) {
        // Lógica para visitar SuperChampinion
    }

    @Override
    public void visitarFlorDeFuego(FlorDeFuego florDeFuego) {
        // Lógica para visitar FlorDeFuego
    }

    @Override
    public void visitarChampinionVerde(ChampinionVerde champinionVerde) {
        // Lógica para visitar ChampinionVerde
    }

    @Override
    public void visitarEstrella(Estrella estrella) {
        // Lógica para visitar Estrella
    }

    @Override
    public void visitarMonedas(Monedas monedas) {
        // Lógica para visitar Monedas
    }

    @Override
    public void visitarBloqueDePregunta(BloqueDePregunta bloqueDePregunta) {
        // Lógica para visitar BloqueDePregunta
    }

    @Override
    public void visitarLadrillo(Ladrillo ladrillo) {
        // Lógica para visitar Ladrillo
    }

    @Override
    public void visitarPrincesaPeach(PrincesaPeach princesaPeach) {
        // Lógica para visitar PrincesaPeach
    }

    @Override
    public void visitarBandera(Bandera bandera) {
        // Lógica para visitar Bandera
    }

    @Override
    public void visitarTuberia(Tuberia tuberia) {
        // Lógica para visitar Tuberia
    }

    @Override
    public void visitarBloqueSolido(BloqueSolido bloqueSolido) {
        // Lógica para visitar BloqueSolido
    }

    @Override
    public void visitarContextoMario(ContextoMario contextoMario) {
        contextoMario.getEstado().aceptarVisitante(this);
    }
    
    @Override
    public void visitarMarioDefault(MarioDefault marioDefault) {
        ContextoMario contextoMario = marioDefault.getContext();
        EstadoMario nuevoEstado = new MarioInvulnerable();
        contextoMario.cambiarEstado(nuevoEstado);
    }

    @Override
    public void visitarSuperMario(SuperMario superMario) {
        ContextoMario contextoMario = superMario.getContext();
        EstadoMario nuevoEstado = new MarioInvulnerable();
        contextoMario.cambiarEstado(nuevoEstado);
    }

    @Override
    public void visitarMarioFuego(MarioFuego marioFuego) {
        ContextoMario contextoMario = marioFuego.getContext();
        EstadoMario nuevoEstado = new MarioInvulnerable();
        contextoMario.cambiarEstado(nuevoEstado);
    }

    @Override
    public void visitarMarioInvulnerable(MarioInvulnerable marioInvulnerable) {}

    @Override
    public void visitarContextoKoopaTroopa(ContextoKoopaTroopa contextoKoopaTroopa) {}

    @Override
    public void visitarKoopaEnCaparazon(KoopaEnCaparazon koopaEnCaparazon) {}

    @Override
    public void visitarKoopaDefault(KoopaDefault koopaDefault) {}

    @Override
    public void visitarPiso(Piso piso) {}
}
