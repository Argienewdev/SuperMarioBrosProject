package visitors;

import elementos.enemigos.*;
import elementos.entidades.Fireball;
import elementos.personajes.*;
import elementos.plataformas.*;
import elementos.powerUps.*;

public class VisitorCaparazonEstatico implements Visitante {

    protected KoopaCaparazonEstatico miEntidad;

    public VisitorCaparazonEstatico(KoopaCaparazonEstatico miEntidad) {
        this.miEntidad = miEntidad;
    }

    public void visitar(BuzzyBeetle buzzy) {
    }

    public void visitar(Spiny spiny) {
    }

    public void visitar(Goomba goomba) {
    }

    public void visitar(KoopaCaparazonEstatico koopaEstatico) {
    }

    public void visitar(KoopaCaparazonMovil koopaMovil) {
    }

    public void visitar(KoopaDefault koopaDefault) {
    }

    public void visitar(Lakitu lakitu) {
    }

    public void visitar(PiranhaPlant planta) {
    }

    public void visitar(Fireball fireball) {
    }

    public void visitar(SuperChampinion superChamp) {
    }

    public void visitar(FlorDeFuego flor) {
    }

    public void visitar(ChampinionVerde champVerde) {
    }

    public void visitar(Estrella estrella) {
    }

    public void visitar(Monedas moneda) {
    }

    public void visitar(MarioDefault marioNormal) {
        ContextoMario contextoMario = marioNormal.getContext();
        if (contextoMario.getVidas() == 1) {
            ContextoKoopaTroopa contextoTroopa = miEntidad.getContext();
            int perdidaPuntos = contextoTroopa.getPuntosSustraidosPorMuerteCausada();
            contextoMario.perderPuntos(perdidaPuntos);
        }
        contextoMario.perderVida();
    }

    public void visitar(MarioInvulnerable marioInv) {
    }

    public void visitar(MarioFuego marioFuego) {
        ContextoMario contexto = marioFuego.getContext();
        EstadoMario estado = new SuperMario();
        contexto.cambiarEstado(estado);
    }

    public void visitar(SuperMario superMario) {
        ContextoMario contexto = superMario.getContext();
        EstadoMario estado = new MarioDefault();
        contexto.cambiarEstado(estado);
    }

    public void visitar(BloqueDePregunta bloquePregunta) {
    }

    public void visitar(Ladrillo ladrillo) {
    }

    public void visitar(Vacio vacio) {
    }

    public void visitar(PrincesaPeach princesa) {
    }

    public void visitar(Bandera bandera) {
    }

    public void visitar(Tuberia tuberia) {
    }

    public void visitar(BloqueSolido bloqueSolido) {
    }

    public void visitar(ContextoMario contextoMario) {
    }

    public void visitar(ContextoKoopaTroopa contextoKoopa) {
    }
}

