package visitors;

import elementos.enemigos.*;
import elementos.entidades.BolaDeFuego;
import elementos.personajes.*;
import elementos.plataformas.*;
import elementos.powerUps.*;
import fabricas.FabricaEntidades;

public class VisitorFlorDeFuego implements Visitante {

    protected FlorDeFuego miEntidad;
    
    protected FabricaEntidades fabricaEntidades;

    public VisitorFlorDeFuego(FlorDeFuego miEntidad, FabricaEntidades fabricaEntidades) {
        this.miEntidad = miEntidad;
        this.fabricaEntidades=fabricaEntidades;
    }

    @Override
    public void visitarBuzzyBeetle(BuzzyBeetle buzzyBeetle) {}

    @Override
    public void visitarSpiny(Spiny spiny) {}

    @Override
    public void visitarGoomba(Goomba goomba) {}

    @Override
    public void visitarLakitu(Lakitu lakitu) {}

    @Override
    public void visitarPiranhaPlant(PiranhaPlant piranhaPlant) {}

    @Override
    public void visitarSuperChampinion(SuperChampinion superChampinion) {}

    @Override
    public void visitarFlorDeFuego(FlorDeFuego florDeFuego) {}

    @Override
    public void visitarChampinionVerde(ChampinionVerde champinionVerde) {}

    @Override
    public void visitarEstrella(Estrella estrella) {}

    @Override
    public void visitarMonedas(Monedas monedas) {}

    @Override
    public void visitarContextoMario(ContextoMario contextoMario) {
        contextoMario.getEstado().aceptarVisitante(this);
    }

    @Override
    public void visitarMarioDefault(MarioDefault marioDefault) {
        ContextoMario contextoMario = marioDefault.getContext();
        EstadoMario nuevoEstado = new MarioFuego(fabricaEntidades);
        contextoMario.cambiarEstado(nuevoEstado);
    }

    @Override
    public void visitarSuperMario(SuperMario superMario) {
        ContextoMario contextoMario = superMario.getContext();
        EstadoMario nuevoEstado = new MarioFuego(fabricaEntidades);
        contextoMario.cambiarEstado(nuevoEstado);
    }

    @Override
    public void visitarMarioFuego(MarioFuego marioFuego) {}

    @Override
    public void visitarMarioInvulnerable(MarioInvulnerable marioInvulnerable) {
        ContextoMario contextoMario = marioInvulnerable.getContext();
        contextoMario.ganarPuntos(this.miEntidad.obtenerPuntosPorInvulnerable());
    }

    @Override
    public void visitarBloqueDePregunta(BloqueDePregunta bloqueDePregunta) {}

    @Override
    public void visitarLadrillo(Ladrillo ladrillo) {}

    @Override
    public void visitarPrincesaPeach(PrincesaPeach princesaPeach) {}

    @Override
    public void visitarBandera(Bandera bandera) {}

    @Override
    public void visitarTuberia(Tuberia tuberia) {}

    @Override
    public void visitarBloqueSolido(BloqueSolido bloqueSolido) {}

    @Override
    public void visitarContextoKoopaTroopa(ContextoKoopaTroopa contextoKoopaTroopa) {}

    @Override
    public void visitarKoopaEnCaparazon(KoopaEnCaparazon koopaEnCaparazon) {}

    @Override
    public void visitarKoopaDefault(KoopaDefault koopaDefault) {}

    @Override
    public void visitarPiso(Piso piso) {}

	@Override
	public void visitarBolaDeFuego(BolaDeFuego fireball) {
		// TODO Auto-generated method stub
		
	}
  
}
