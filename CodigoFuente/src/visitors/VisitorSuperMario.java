package visitors;

import java.awt.Point;

import elementos.enemigos.*;
import elementos.entidades.BolaDeFuego;
import elementos.personajes.*;
import elementos.plataformas.*;
import elementos.powerUps.*;
import juego.Nivel;

public class VisitorSuperMario implements Visitante {

    protected EstadoMario miEstado;
    
    protected ContextoMario miContexto;

    protected DetectorDireccionColision detectorDireccionColision;
    
    public VisitorSuperMario(SuperMario miEstado) {
        this.miEstado = miEstado;
        this.miContexto = this.miEstado.obtenerContexto();
        this.detectorDireccionColision = new DetectorDireccionColision();
    }

    @Override
    public void visitarBuzzyBeetle(BuzzyBeetle buzzyBeetle) {
    	if (this.detectorDireccionColision.choquePorArriba(buzzyBeetle, this.miContexto)) {
			buzzyBeetle.establecerRemovido(true);
			this.miContexto.ganarPuntos(buzzyBeetle.obtenerPuntosOtorgadosPorEliminacion());
		}
    }

    @Override
    public void visitarSpiny(Spiny spiny) {
    }

    @Override
    public void visitarGoomba(Goomba goomba) {
    	if (this.detectorDireccionColision.choquePorArriba(goomba, this.miContexto)) {
    		goomba.establecerRemovido(true);
			this.miContexto.ganarPuntos(goomba.obtenerPuntosOtorgadosPorEliminacion());
		}
    }

    @Override
    public void visitarContextoKoopaTroopa(ContextoKoopaTroopa contextoKoopaTroopa) {
		contextoKoopaTroopa.obtenerEstado().aceptarVisitante(this);
    }

    @Override
    public void visitarKoopaEnCaparazon(KoopaEnCaparazon koopaEnCaparazon) {
    	if (this.detectorDireccionColision.choquePorArriba(koopaEnCaparazon.obtenerContext(), this.miContexto)
        		&& this.miContexto.obtenerVelocidadDireccional().y > koopaEnCaparazon.obtenerVelocidadNecesariaParaMatarKoopa()) {
        	   koopaEnCaparazon.obtenerContext().establecerRemovido(true);
           }
    }

    @Override
    public void visitarKoopaDefault(KoopaDefault koopaDefault) {
    	if (this.detectorDireccionColision.choquePorArriba(koopaDefault.obtenerContext(), this.miContexto)) {
			ContextoKoopaTroopa contextoKoopa = koopaDefault.obtenerContext();
	        EstadoKoopa nuevoEstado = new KoopaEnCaparazon();
	        this.miContexto.ganarPuntos(koopaDefault.obtenerContext().obtenerPuntosOtorgadosPorEliminacion());
	        contextoKoopa.cambiarEstado(nuevoEstado);
	        koopaDefault.obtenerContext().establecerVelocidadDireccional(new Point(0, 0));
		}
    }

    @Override
    public void visitarLakitu(Lakitu lakitu) {
    	if (this.detectorDireccionColision.choquePorArriba(lakitu, this.miContexto) ) {
    		lakitu.establecerRemovido(true);
			this.miContexto.ganarPuntos(lakitu.obtenerPuntosOtorgadosPorEliminacion());
		}
    }

    @Override
    public void visitarPiranhaPlant(PiranhaPlant piranhaPlant) {
    }

    @Override
    public void visitarSuperChampinion(SuperChampinion superChampinion) {
    	if (!superChampinion.obtenerRemovido()) {
			this.miContexto.ganarPuntos(superChampinion.obtenerPuntosPorSuper());
	        superChampinion.establecerRemovido(true);
		}
    }

    @Override
    public void visitarFlorDeFuego(FlorDeFuego florDeFuego) {
    	if (!florDeFuego.obtenerRemovido()) {
			this.miContexto.ganarPuntos(florDeFuego.obtenerPuntosPorSuper());
			florDeFuego.establecerRemovido(true);
		}
    }

    @Override
    public void visitarChampinionVerde(ChampinionVerde champinionVerde) {}

    @Override
    public void visitarEstrella(Estrella estrella) {}

    @Override
    public void visitarMoneda(Moneda monedas) {
    	if (!monedas.obtenerRemovido()) {
    		this.miContexto.ganarPuntos(monedas.obtenerPuntosPorSuper());
        	monedas.establecerRemovido(true);
    	}
    }

    @Override
    public void visitarBloqueDePregunta(BloqueDePregunta bloqueDePregunta) {}

    @Override
    public void visitarLadrillo(Ladrillo ladrillo) {
    	if (detectorDireccionColision.choquePorAbajo(ladrillo, this.miContexto)) {
            detectorDireccionColision.verificarColisionElementoDeJuegoYEntidad(ladrillo, miContexto);
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

	@Override
	public void visitarVacio(Vacio vacio) {
		
	}
    
}
