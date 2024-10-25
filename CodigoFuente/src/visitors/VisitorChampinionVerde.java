package visitors;

import elementos.enemigos.*;
import elementos.entidades.Fireball;
import elementos.personajes.*;
import elementos.plataformas.*;
import elementos.powerUps.*;

public class VisitorChampinionVerde implements Visitante {
    
    protected ChampinionVerde miEntidad;
    
    public VisitorChampinionVerde(ChampinionVerde miEntidad) {
        this.miEntidad = miEntidad;
    }

    @Override
    public void visitarBuzzyBeetle(BuzzyBeetle buzzyBeetle) {
    }

    @Override
    public void visitarSpiny(Spiny spiny) {
    }

    @Override
    public void visitarGoomba(Goomba goomba) {
    }

    @Override
    public void visitarLakitu(Lakitu lakitu) {
    }

    @Override
    public void visitarPiranhaPlant(PiranhaPlant piranhaPlant) {
    }

    @Override
    public void visitarFireball(Fireball fireball) {
    }

    @Override
    public void visitarSuperChampinion(SuperChampinion superChampinion) {
    }

    @Override
    public void visitarFlorDeFuego(FlorDeFuego florDeFuego) {
    }

    @Override
    public void visitarChampinionVerde(ChampinionVerde champinionVerde) {
    }

    @Override
    public void visitarEstrella(Estrella estrella) {
    }

    @Override
    public void visitarMonedas(Monedas moneda) {
    }

    @Override
    public void visitarContextoMario(ContextoMario contextoMario) {
        contextoMario.ganarVida();
        contextoMario.getEstado().aceptarVisitante(this);
    }

    @Override
    public void visitarMarioDefault(MarioDefault marioDefault) {
        ContextoMario contextoMario = marioDefault.getContext();
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
    public void visitarContextoKoopaTroopa(ContextoKoopaTroopa contextoKoopaTroopa) {
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
