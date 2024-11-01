package visitors;

import java.awt.Point;

import elementos.enemigos.*;
import elementos.entidades.BolaDeFuego;
import elementos.personajes.*;
import elementos.plataformas.*;
import elementos.powerUps.*;

public class VisitorMarioRecuperacion implements Visitante{
	
	private MarioRecuperacion miEstado;
	
	protected DetectorDireccionColision detectorDireccionColision;
	
	private ContextoMario miContexto;
	 
	public VisitorMarioRecuperacion (MarioRecuperacion miEstado) {
		this.miEstado = miEstado;
		this.miContexto = miEstado.obtenerContexto();
		this.detectorDireccionColision = new DetectorDireccionColision();
	}
	
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
    	contextoKoopaTroopa.obtenerEstado().aceptarVisitante(this.miEstado.obtenerVisitante());
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
	        EstadoKoopa nuevoEstado = new KoopaEnCaparazon();
	        koopaDefault.obtenerContext().cambiarEstado(nuevoEstado);
	        this.miContexto.ganarPuntos(koopaDefault.obtenerContext().obtenerPuntosOtorgadosPorEliminacion());
	        koopaDefault.obtenerContext().establecerVelocidadDireccional(new Point(0, 0));
		}
    }

    @Override
    public void visitarLakitu(Lakitu lakitu) {
    	if (this.detectorDireccionColision.choquePorArriba(lakitu, this.miContexto)) {
    		lakitu.establecerRemovido(true);
            this.miContexto.ganarPuntos(lakitu.obtenerPuntosOtorgadosPorEliminacion());
    	}
    }

    @Override
    public void visitarPiranhaPlant(PiranhaPlant piranhaPlant) {}

    @Override
    public void visitarSuperChampinion(SuperChampinion superChampinion) {
		if (!superChampinion.obtenerRemovido()) {
			EstadoMario nuevoEstado = new SuperMario();
			this.miContexto.ganarPuntos(superChampinion.obtenerPuntosPorDefault());
			this.miContexto.cambiarEstado(nuevoEstado);
	        superChampinion.establecerRemovido(true);
		}
    }

    @Override
    public void visitarFlorDeFuego(FlorDeFuego florDeFuego) {
    	if (!florDeFuego.obtenerRemovido()) {
    		this.miContexto.ganarPuntos(florDeFuego.obtenerPuntosPorDefault());
            florDeFuego.establecerRemovido(true);
    	}
    }

    @Override
    public void visitarChampinionVerde(ChampinionVerde champinionVerde) {
    }

    @Override
    public void visitarEstrella(Estrella estrella) {
    	if (!estrella.obtenerRemovido()) {
    		this.miContexto.ganarPuntos(estrella.obtenerPuntosPorDefault());
            estrella.establecerRemovido(true);
    	}
    }

    @Override
    public void visitarMoneda(Moneda monedas) {}

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
    	bandera.aceptarVisitante(miContexto.obtenerVisitante());
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
