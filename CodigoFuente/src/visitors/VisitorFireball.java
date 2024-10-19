package visitors;

import elementos.enemigos.*;
import elementos.entidades.Fireball;
import elementos.personajes.*;
import elementos.plataformas.*;
import elementos.powerUps.*;
import juego.Nivel;

public class VisitorFireball implements Visitante {

    protected Fireball miEntidad;

    public VisitorFireball(Fireball miEntidad) {
        this.miEntidad = miEntidad;
    }

    public void visitar(BuzzyBeetle buzzy) {
        otorgarPuntosYEliminar(buzzy);
    }

    public void visitar(Spiny spiny) {
        otorgarPuntosYEliminar(spiny);
    }

    public void visitar(Goomba goomba) {
        otorgarPuntosYEliminar(goomba);
    }

    public void visitar(KoopaCaparazonEstatico koopaEstatico) {
        koopaEstatico.getContext().cambiarEstado(new KoopaCaparazonMovil());
    }

    public void visitar(KoopaCaparazonMovil koopaMovil) {
        ContextoKoopaTroopa contexto = koopaMovil.getContext();
        otorgarPuntosYEliminar(contexto);
    }

    public void visitar(KoopaDefault koopaDefault) {
        koopaDefault.getContext().cambiarEstado(new KoopaCaparazonEstatico());
    }

    public void visitar(Lakitu lakitu) {
        otorgarPuntosYEliminar(lakitu);
    }

    public void visitar(PiranhaPlant planta) {
        otorgarPuntosYEliminar(planta);
    }

    public void visitar(Fireball fireball) {
        // Sin lógica específica por ahora
    }

    public void visitar(SuperChampinion superChamp) { }

    public void visitar(FlorDeFuego flor) { }

    public void visitar(ChampinionVerde champVerde) { }

    public void visitar(Estrella estrella) { }

    public void visitar(Monedas moneda) { }

    public void visitar(MarioDefault marioNormal) { }

    public void visitar(MarioInvulnerable marioInv) { }

    public void visitar(MarioFuego marioFuego) { }

    public void visitar(SuperMario superMario) { }

    public void visitar(BloqueDePregunta bloquePregunta) { }

    public void visitar(Ladrillo ladrillo) { }

    public void visitar(Vacio vacio) { }

    public void visitar(PrincesaPeach princesa) { }

    public void visitar(Bandera bandera) { }

    public void visitar(Tuberia tuberia) { }

    public void visitar(BloqueSolido bloqueSolido) { }

    public void visitar(ContextoMario contextoMario) { }

    public void visitar(ContextoKoopaTroopa contextoKoopa) { }

    // Método auxiliar para otorgar puntos y eliminar enemigos
    private void otorgarPuntosYEliminar(Enemigo enemigo) {
        int puntos = enemigo.getPuntosOtorgadosPorEliminacion();
        miEntidad.obtenerJugador().ganarPuntos(puntos);
        Nivel nivel = enemigo.getNivel();
        nivel.removeEnemigo(enemigo);
    }
}
