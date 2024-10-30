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
        this.miEntidad = this.miEstado.obtenerContexto();
        this.detectorDireccionColision = new DetectorDireccionColision();
    }

    @Override
    public void visitarBuzzyBeetle(BuzzyBeetle buzzyBeetle) {
    	if (this.detectorDireccionColision.choquePorArriba(buzzyBeetle, this.miEntidad)) {
			buzzyBeetle.establecerRemovido(true);
			this.miEntidad.ganarPuntos(buzzyBeetle.obtenerPuntosOtorgadosPorEliminacion());
		}
    }

    @Override
    public void visitarSpiny(Spiny spiny) {
    }

    @Override
    public void visitarGoomba(Goomba goomba) {
    	if (this.detectorDireccionColision.choquePorArriba(goomba, this.miEntidad)) {
    		goomba.establecerRemovido(true);
			this.miEntidad.ganarPuntos(goomba.obtenerPuntosOtorgadosPorEliminacion());
		}
    }

    @Override
    public void visitarContextoKoopaTroopa(ContextoKoopaTroopa contextoKoopaTroopa) {
		contextoKoopaTroopa.obtenerEstado().aceptarVisitante(this);
    }

    @Override
    public void visitarKoopaEnCaparazon(KoopaEnCaparazon koopaEnCaparazon) {
    	if (this.detectorDireccionColision.choquePorArriba(koopaEnCaparazon.obtenerContext(), this.miEntidad)
        		&& this.miEntidad.obtenerVelocidadDireccional().y > koopaEnCaparazon.obtenerVelocidadNecesariaParaMatarKoopa()) {
        	   koopaEnCaparazon.obtenerContext().establecerRemovido(true);
            }
    }

    @Override
    public void visitarKoopaDefault(KoopaDefault koopaDefault) {
    	if (this.detectorDireccionColision.choquePorArriba(koopaDefault.obtenerContext(), this.miEntidad)) {
			ContextoKoopaTroopa contextoKoopa = koopaDefault.obtenerContext();
	        EstadoKoopa nuevoEstado = new KoopaEnCaparazon();
	        this.miEntidad.ganarPuntos(koopaDefault.obtenerContext().obtenerPuntosOtorgadosPorEliminacion());
	        contextoKoopa.cambiarEstado(nuevoEstado);
	        koopaDefault.obtenerContext().establecerVelocidadDireccional(new Point(0, 0));
		}
    }

    @Override
    public void visitarLakitu(Lakitu lakitu) {
    }

    @Override
    public void visitarPiranhaPlant(PiranhaPlant piranhaPlant) {
    }

    @Override
    public void visitarSuperChampinion(SuperChampinion superChampinion) {
    	this.miEntidad.ganarPuntos(superChampinion.obtenerPuntosPorFuego());
        superChampinion.eliminarDelNivel();
    }

    @Override
    public void visitarFlorDeFuego(FlorDeFuego florDeFuego) {
    	if(!florDeFuego.obtenerRemovido()) {
    		this.miEntidad.ganarPuntos(florDeFuego.obtenerPuntosPorDefault());
            florDeFuego.establecerRemovido(true);
    	}
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
	}
	
	private void otorgarPuntosYEliminar(Enemigo enemigo) {
		int puntos = enemigo.obtenerPuntosOtorgadosPorEliminacion();
		this.miEntidad.ganarPuntos(puntos);
		enemigo.establecerRemovido(true);
	}

	@Override
	public void visitarVacio(Vacio vacio) {
	}
    
}
