package visitors;

import java.awt.Point;

import elementos.enemigos.*;
import elementos.entidades.BolaDeFuego;
import elementos.personajes.*;
import elementos.plataformas.*;
import elementos.powerUps.*;
import ventanas.ConstantesGlobales;

public class VisitorMarioDefault implements Visitante {

    protected EstadoMario miEstado;
    
    protected DetectorDireccionColision detectorDireccionColision;
    
    protected ContextoMario miContexto;

    public VisitorMarioDefault(MarioDefault miEstado) {
        this.miEstado = miEstado;
        this.miContexto = miEstado.getContext();
        this.detectorDireccionColision = new DetectorDireccionColision();
    }

    @Override
    public void visitarBuzzyBeetle(BuzzyBeetle buzzyBeetle) {
    	if(this.detectorDireccionColision.choquePorArriba(buzzyBeetle, this.miContexto) &&
    	   !buzzyBeetle.getRemovido()) {
    		buzzyBeetle.setRemovido(true);
            this.miContexto.ganarPuntos(buzzyBeetle.getPuntosOtorgadosPorEliminacion());
    	}
    }

    @Override
    public void visitarSpiny(Spiny spiny) {
    }

    @Override
    public void visitarGoomba(Goomba goomba) {
    	if(this.detectorDireccionColision.choquePorArriba(goomba, this.miContexto) &&
    		!goomba.getRemovido()) {
            goomba.setRemovido(true);
            this.miContexto.ganarPuntos(goomba.getPuntosOtorgadosPorEliminacion());
        }
    }

    @Override
    public void visitarContextoKoopaTroopa(ContextoKoopaTroopa contextoKoopaTroopa) {
		contextoKoopaTroopa.getEstado().aceptarVisitante(this);
    }

    @Override
    public void visitarKoopaEnCaparazon(KoopaEnCaparazon koopaEnCaparazon) {
    	System.out.println(this.miContexto.getVelocidadDireccional().y);
    	if (this.detectorDireccionColision.choquePorArriba(koopaEnCaparazon.getContext(), this.miContexto)  
    		&& !koopaEnCaparazon.getContext().getRemovido()
    		&& this.miContexto.getVelocidadDireccional().y > 10) {
    	   koopaEnCaparazon.getContext().setRemovido(true);
        }
    }

    @Override
    public void visitarKoopaDefault(KoopaDefault koopaDefault) {
    	if (this.detectorDireccionColision.choquePorArriba(koopaDefault.getContext(), this.miContexto)) {
	        EstadoKoopa nuevoEstado = new KoopaEnCaparazon();
	        koopaDefault.getContext().cambiarEstado(nuevoEstado);
	        this.miContexto.ganarPuntos(koopaDefault.getContext().getPuntosOtorgadosPorEliminacion());
	        koopaDefault.getContext().setVelocidadDireccional(new Point(0, 0));
		}
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
		if(!superChampinion.getRemovido()) {
			EstadoMario nuevoEstado = new SuperMario();
			this.miContexto.ganarPuntos(superChampinion.obtenerPuntosPorDefault());
			this.miContexto.cambiarEstado(nuevoEstado);
	        superChampinion.setRemovido(true);
		}
    }

    @Override
    public void visitarFlorDeFuego(FlorDeFuego florDeFuego) {
    	if(!florDeFuego.getRemovido()) {
    		this.miContexto.ganarPuntos(florDeFuego.obtenerPuntosPorDefault());
            florDeFuego.setRemovido(true);
    	}
    }

    @Override
    public void visitarChampinionVerde(ChampinionVerde champinionVerde) {
    }

    @Override
    public void visitarEstrella(Estrella estrella) {
    	if(!estrella.getRemovido()) {
    		this.miContexto.ganarPuntos(estrella.obtenerPuntosPorDefault());
            estrella.setRemovido(true);
    	}
    }

    @Override
    public void visitarMonedas(Monedas monedas) {
    }

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
    	bandera.aceptarVisitante(miContexto.getVisitor());
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
    
    public void visitarMarioRecuperacion(MarioRecuperacion marioRecuperacion) {}

    @Override
    public void visitarMarioFuego(MarioFuego marioFuego) {}

    @Override
    public void visitarMarioInvulnerable(MarioInvulnerable marioInvulnerable) {}

	@Override
	public void visitarBolaDeFuego(BolaDeFuego fireball) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitarVacio(Vacio vacio) {
		// TODO Auto-generated method stub
		
	}
    
}
