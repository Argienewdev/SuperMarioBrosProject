package visitors;

import elementos.enemigos.*;
import elementos.entidades.BolaDeFuego;
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
    	//Es atravesado
    }

    @Override
    public void visitarSpiny(Spiny spiny) {
    	//Es atravesado
    }

    @Override
    public void visitarGoomba(Goomba goomba) {
    	//Es atravesado
    }

    @Override
    public void visitarLakitu(Lakitu lakitu) {
    	//Es atravesado
    }

    @Override
    public void visitarPiranhaPlant(PiranhaPlant piranhaPlant) {
    	//Es atravesado
    }

    @Override
    public void visitarSuperChampinion(SuperChampinion superChampinion) {
    	//Es atravesado
    }

    @Override
    public void visitarFlorDeFuego(FlorDeFuego florDeFuego) {
    	//Es atravesado
    }

    @Override
    public void visitarChampinionVerde(ChampinionVerde champinionVerde) {
    	//Es atravesado
    }

    @Override
    public void visitarEstrella(Estrella estrella) {}

    @Override
    public void visitarMonedas(Monedas monedas) {
    	//Es atravesado
    }

    @Override
    public void visitarBloqueDePregunta(BloqueDePregunta bloqueDePregunta) {
        // No lo afecta
    }

    @Override
    public void visitarLadrillo(Ladrillo ladrillo) {
    	// No lo afecta
    }

    @Override
    public void visitarPrincesaPeach(PrincesaPeach princesaPeach) {
    	//No lo afecta
    }

    @Override
    public void visitarBandera(Bandera bandera) {
    	//No lo afecta
    }

    @Override
    public void visitarTuberia(Tuberia tuberia) {
    	//No lo afecta
    }

    @Override
    public void visitarBloqueSolido(BloqueSolido bloqueSolido) {
    	//No lo afecta
    }

    @Override
    public void visitarContextoMario(ContextoMario contextoMario) {
        contextoMario.getEstado().aceptarVisitante(this);
    }
    
    @Override
    public void visitarMarioDefault(MarioDefault marioDefault) {
        ContextoMario contextoMario = marioDefault.getContext();
        contextoMario.ganarPuntos(this.miEntidad.obtenerPuntosPorDefault());
        EstadoMario nuevoEstado = new MarioInvulnerable(marioDefault);
        contextoMario.cambiarEstado(nuevoEstado);
    }

    @Override
    public void visitarSuperMario(SuperMario superMario) {
        ContextoMario contextoMario = superMario.getContext();
        contextoMario.ganarPuntos(this.miEntidad.obtenerPuntosPorSuper());
        EstadoMario nuevoEstado = new MarioInvulnerable(superMario);
        contextoMario.cambiarEstado(nuevoEstado);
    }

    @Override
    public void visitarMarioFuego(MarioFuego marioFuego) {
        ContextoMario contextoMario = marioFuego.getContext();
        contextoMario.ganarPuntos(this.miEntidad.obtenerPuntosPorFuego());
        EstadoMario nuevoEstado = new MarioInvulnerable(marioFuego);
        contextoMario.cambiarEstado(nuevoEstado);
    }

    @Override
    public void visitarMarioInvulnerable(MarioInvulnerable marioInvulnerable) {
    	ContextoMario contextoMario = marioInvulnerable.getContext();
    	contextoMario.ganarPuntos(this.miEntidad.obtenerPuntosPorInvulnerable());
    }
    
    public void visitarMarioRecuperacion(MarioRecuperacion marioRecuperacion) {
    	ContextoMario contextoMario = marioRecuperacion.getContext();
    	contextoMario.ganarPuntos(this.miEntidad.obtenerPuntosPorDefault());
        EstadoMario nuevoEstado = new MarioInvulnerable(new MarioDefault());
        contextoMario.cambiarEstado(nuevoEstado);
    }

    @Override
    public void visitarContextoKoopaTroopa(ContextoKoopaTroopa contextoKoopaTroopa) {
    	//Es atravesado
    }

    @Override
    public void visitarKoopaEnCaparazon(KoopaEnCaparazon koopaEnCaparazon) {
    	//Es atravesado
    }

    @Override
    public void visitarKoopaDefault(KoopaDefault koopaDefault) {
    	//Es atravesado
    }

    @Override
    public void visitarPiso(Piso piso) {}

	@Override
	public void visitarBolaDeFuego(BolaDeFuego fireball) {
		//Es atravesado
	}
}
