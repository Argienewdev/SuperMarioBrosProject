package visitors;

import elementos.enemigos.*;
import elementos.entidades.BolaDeFuego;
import elementos.personajes.*;
import elementos.plataformas.*;
import elementos.powerUps.*;

public class VisitorMarioRecuperacion implements Visitante{
	
	private MarioRecuperacion miEstado;
	
	protected DetectorDireccionColision detectorDireccionColision;
	
	private ContextoMario miEntidad;
	 
	public VisitorMarioRecuperacion (MarioRecuperacion miEstado) {
		this.miEstado = miEstado;
		this.miEntidad = miEstado.getContext();
		this.detectorDireccionColision = new DetectorDireccionColision();
	}
	
	public void visitarBuzzyBeetle(BuzzyBeetle buzzyBeetle) {
		if (this.detectorDireccionColision.choquePorArriba(buzzyBeetle, this.miEntidad)) {
			buzzyBeetle.setRemovido(true);
			this.miEntidad.ganarPuntos(buzzyBeetle.getPuntosOtorgadosPorEliminacion());
		}
    }

    @Override
    public void visitarSpiny(Spiny spiny) {
        // TODO Implementación pendiente
    }

    @Override
    public void visitarGoomba(Goomba goomba) {
    	if (this.detectorDireccionColision.choquePorArriba(goomba, this.miEntidad)) {
            goomba.setRemovido(true);
            this.miEntidad.ganarPuntos(goomba.getPuntosOtorgadosPorEliminacion());
    	}
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
    	if (this.detectorDireccionColision.choquePorArriba(koopaDefault.getContext(), this.miEntidad)) {
    		koopaDefault.getContext().setRemovido(true);
            this.miEntidad.ganarPuntos(koopaDefault.getContext().getPuntosOtorgadosPorEliminacion());
    	}
    }

    @Override
    public void visitarLakitu(Lakitu lakitu) {
    	if (this.detectorDireccionColision.choquePorArriba(lakitu, this.miEntidad)) {
    		lakitu.setRemovido(true);
            this.miEntidad.ganarPuntos(lakitu.getPuntosOtorgadosPorEliminacion());
    	}
    }

    @Override
    public void visitarPiranhaPlant(PiranhaPlant piranhaPlant) {}

    @Override
    public void visitarSuperChampinion(SuperChampinion superChampinion) {
		this.miEntidad.ganarPuntos(superChampinion.obtenerPuntosPorDefault());
        superChampinion.setRemovido(true);
    }

    @Override
    public void visitarFlorDeFuego(FlorDeFuego florDeFuego) {
    	this.miEntidad.ganarPuntos(florDeFuego.obtenerPuntosPorDefault());
    	florDeFuego.setRemovido(true);
    }

    @Override
    public void visitarChampinionVerde(ChampinionVerde champinionVerde) {
    	this.miEntidad.ganarPuntos(champinionVerde.obtenerPuntosPorDefault());
    	champinionVerde.setRemovido(true);
    }

    @Override
    public void visitarEstrella(Estrella estrella) {
    	this.miEntidad.ganarPuntos(estrella.obtenerPuntosPorDefault());
        estrella.setRemovido(true);
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
    public void visitarPrincesaPeach(PrincesaPeach princesaPeach) {
    }

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
	public void visitarMarioRecuperacion(MarioRecuperacion marioRecuperacion) {}

    @Override
    public void visitarMarioInvulnerable(MarioInvulnerable marioInvulnerable) {}

	@Override
	public void visitarBolaDeFuego(BolaDeFuego fireball) {}

	@Override
	public void visitarVacio(Vacio vacio) {
		// TODO Auto-generated method stub
		
	}

}
