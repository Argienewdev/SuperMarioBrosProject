package visitors;

import java.awt.Point;

import elementos.enemigos.*;
import elementos.entidades.BolaDeFuego;
import elementos.personajes.*;
import elementos.plataformas.*;
import elementos.powerUps.*;

public class VisitorMarioFuego implements Visitante {

    protected EstadoMario miEstado;
    
    protected DetectorDireccionColision detectorDireccionColision;
    
    protected ContextoMario miEntidad;

    public VisitorMarioFuego(MarioFuego marioFuego) {
        this.miEstado = marioFuego;  // Cambié a marioFuego
        this.miEntidad = this.miEstado.getContext();
        this.detectorDireccionColision = new DetectorDireccionColision();
    }

    @Override
    public void visitarBuzzyBeetle(BuzzyBeetle buzzyBeetle) {
    	if (this.detectorDireccionColision.choquePorArriba(buzzyBeetle, this.miEntidad)) {
			buzzyBeetle.setRemovido(true);
			this.miEntidad.ganarPuntos(buzzyBeetle.getPuntosOtorgadosPorEliminacion());
		}
    }

    @Override
    public void visitarSpiny(Spiny spiny) {
        // TODO Auto-generated method stub
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
		contextoKoopaTroopa.getEstado().aceptarVisitante(this);
    }

    @Override
    public void visitarKoopaEnCaparazon(KoopaEnCaparazon koopaEnCaparazon) {
    }

    @Override
    public void visitarKoopaDefault(KoopaDefault koopaDefault) {
    	if (this.detectorDireccionColision.choquePorArriba(koopaDefault.getContext(), this.miEntidad)) {
			ContextoKoopaTroopa contextoKoopa = koopaDefault.getContext();
	        EstadoKoopa nuevoEstado = new KoopaEnCaparazon();
	        this.miEntidad.ganarPuntos(koopaDefault.getContext().getPuntosOtorgadosPorEliminacion());
	        contextoKoopa.cambiarEstado(nuevoEstado);
	        koopaDefault.getContext().setVelocidadDireccional(new Point(0, 0));
		}
    }
    

    @Override
    public void visitarLakitu(Lakitu lakitu) {
        // TODO Auto-generated method stub
    }

    @Override
    public void visitarPiranhaPlant(PiranhaPlant piranhaPlant) {
        // TODO Auto-generated method stub
    }

    @Override
    public void visitarSuperChampinion(SuperChampinion superChampinion) {
    	this.miEntidad.ganarPuntos(superChampinion.obtenerPuntosPorFuego());
        superChampinion.eliminarDelNivel();
    }

    @Override
    public void visitarFlorDeFuego(FlorDeFuego florDeFuego) {
    	this.miEntidad.ganarPuntos(florDeFuego.obtenerPuntosPorFuego());
        florDeFuego.eliminarDelNivel();
    }

    @Override
    public void visitarChampinionVerde(ChampinionVerde champinionVerde) {}

    @Override
    public void visitarEstrella(Estrella estrella) {
    	this.miEntidad.ganarPuntos(estrella.obtenerPuntosPorFuego());
        estrella.eliminarDelNivel();
    }

    @Override
    public void visitarMonedas(Monedas monedas) {}

    @Override
    public void visitarBloqueDePregunta(BloqueDePregunta bloqueDePregunta) {}

    @Override
    public void visitarLadrillo(Ladrillo ladrillo) {
    	if (detectorDireccionColision.choquePorAbajo(ladrillo, this.miEntidad)) {
            ladrillo.eliminarDelNivel();
        }
    }

    @Override
    public void visitarPrincesaPeach(PrincesaPeach princesaPeach) {}

    @Override
    public void visitarBandera(Bandera bandera) {}

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
    
    public void visitarMarioRecuperacion(MarioRecuperacion marioRecuperacion) {}

    @Override
    public void visitarPiso(Piso piso) {}

	@Override
	public void visitarBolaDeFuego(BolaDeFuego fireball) {
		// TODO Auto-generated method stub
	}
	
	private void otorgarPuntosYEliminar(Enemigo enemigo) {
		int puntos = enemigo.getPuntosOtorgadosPorEliminacion();
		this.miEntidad.ganarPuntos(puntos);
		enemigo.setRemovido(true);
	}

	@Override
	public void visitarVacio(Vacio vacio) {
		// TODO Auto-generated method stub
		
	}
    
}
