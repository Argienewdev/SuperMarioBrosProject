package visitors;

import elementos.enemigos.*;
import elementos.entidades.BolaDeFuego;
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
        // TODO Implementación pendiente
    }

    @Override
    public void visitarSpiny(Spiny spiny) {
        // TODO Implementación pendiente
    }

    @Override
    public void visitarGoomba(Goomba goomba) {
        // TODO Implementación pendiente
    }

    @Override
    public void visitarContextoKoopaTroopa(ContextoKoopaTroopa contextoKoopaTroopa) {
        // TODO Implementación pendiente
    }

    @Override
    public void visitarKoopaEnCaparazon(KoopaEnCaparazon koopaEnCaparazon) {
        // TODO Implementación pendiente
    }

    @Override
    public void visitarKoopaDefault(KoopaDefault koopaDefault) {
        // TODO Implementación pendiente
    }

    @Override
    public void visitarLakitu(Lakitu lakitu) {
        // TODO Implementación pendiente
    }

    @Override
    public void visitarPiranhaPlant(PiranhaPlant piranhaPlant) {
        // TODO Implementación pendiente
    }

    @Override
    public void visitarSuperChampinion(SuperChampinion superChampinion) {
    	this.miEntidad.ganarPuntos(superChampinion.obtenerPuntosPorDefault());
        superChampinion.eliminarDelNivel();
    }

    @Override
    public void visitarFlorDeFuego(FlorDeFuego florDeFuego) {
        this.miEntidad.ganarPuntos(florDeFuego.obtenerPuntosPorDefault());
        florDeFuego.eliminarDelNivel();
    }

    @Override
    public void visitarChampinionVerde(ChampinionVerde champinionVerde) {}

    @Override
    public void visitarEstrella(Estrella estrella) {
        this.miEntidad.ganarPuntos(estrella.obtenerPuntosPorDefault());
        estrella.eliminarDelNivel();
    }

    @Override
    public void visitarMonedas(Monedas monedas) {}

    @Override
    public void visitarBloqueDePregunta(BloqueDePregunta bloqueDePregunta) {}

    @Override
    public void visitarLadrillo(Ladrillo ladrillo) {}

    @Override
    public void visitarPiso(Piso piso) {}

    @Override
    public void visitarPrincesaPeach(PrincesaPeach princesaPeach) {}

    @Override
    public void visitarBandera(Bandera bandera) {
    	bandera.aceptarVisitante(miEntidad.getVisitor());
    }

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
	public void visitarBolaDeFuego(BolaDeFuego fireball) {
		// TODO Auto-generated method stub
		
	}
    
}
