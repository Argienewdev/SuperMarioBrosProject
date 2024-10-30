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
	
	private ContextoMario miEntidad;
	 
	public VisitorMarioRecuperacion (MarioRecuperacion miEstado) {
		this.miEstado = miEstado;
		this.miEntidad = miEstado.obtenerContexto();
		this.detectorDireccionColision = new DetectorDireccionColision();
	}
	
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
    	contextoKoopaTroopa.obtenerEstado().aceptarVisitante(this.miEstado.obtenerVisitante());
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
	        EstadoKoopa nuevoEstado = new KoopaEnCaparazon();
	        koopaDefault.obtenerContext().cambiarEstado(nuevoEstado);
	        this.miEntidad.ganarPuntos(koopaDefault.obtenerContext().obtenerPuntosOtorgadosPorEliminacion());
	        koopaDefault.obtenerContext().establecerVelocidadDireccional(new Point(0, 0));
		}
    }

    @Override
    public void visitarLakitu(Lakitu lakitu) {
    	if (this.detectorDireccionColision.choquePorArriba(lakitu, this.miEntidad)) {
    		lakitu.establecerRemovido(true);
            this.miEntidad.ganarPuntos(lakitu.obtenerPuntosOtorgadosPorEliminacion());
    	}
    }

    @Override
    public void visitarPiranhaPlant(PiranhaPlant piranhaPlant) {}

    @Override
    public void visitarSuperChampinion(SuperChampinion superChampinion) {
		this.miEntidad.ganarPuntos(superChampinion.obtenerPuntosPorDefault());
        superChampinion.establecerRemovido(true);
    }

    @Override
    public void visitarFlorDeFuego(FlorDeFuego florDeFuego) {
    	this.miEntidad.ganarPuntos(florDeFuego.obtenerPuntosPorDefault());
    	florDeFuego.establecerRemovido(true);
    }

    @Override
    public void visitarChampinionVerde(ChampinionVerde champinionVerde) {
    	this.miEntidad.ganarPuntos(champinionVerde.obtenerPuntosPorDefault());
    	champinionVerde.establecerRemovido(true);
    }

    @Override
    public void visitarEstrella(Estrella estrella) {
    	this.miEntidad.ganarPuntos(estrella.obtenerPuntosPorDefault());
        estrella.establecerRemovido(true);
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
    	bandera.aceptarVisitante(miEntidad.obtenerVisitante());
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
