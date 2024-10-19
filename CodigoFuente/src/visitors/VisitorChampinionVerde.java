package visitors;

import elementos.enemigos.*;
import elementos.entidades.Fireball;
import elementos.personajes.*;
import elementos.plataformas.*;
import elementos.powerUps.*;

public class VisitorChampinionVerde implements Visitante {

    public VisitorChampinionVerde() {
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
        ContextoMario contexto = marioNormal.getContext();
        contexto.ganarVida();
    }

    public void visitar(MarioInvulnerable marioInv) {
        ContextoMario contexto = marioInv.getContext();
        contexto.ganarVida();
    }

    public void visitar(MarioFuego marioFuego) {
        ContextoMario contexto = marioFuego.getContext();
        contexto.ganarVida();
    }

    public void visitar(SuperMario superMario) {
        ContextoMario contexto = superMario.getContext();
        contexto.ganarVida();
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
