package visitors;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import elementos.enemigos.*;
import elementos.entidades.BolaDeFuego;
import elementos.personajes.*;
import elementos.plataformas.*;
import elementos.powerUps.*;
import generadores.GeneradorSonidos;
import juego.Nivel;

public class VisitorSuperMario implements Visitante {

    protected EstadoMario miEstado;
    
    protected ContextoMario miContexto;

    protected DetectorDireccionColision detectorDireccionColision;
    
    protected GeneradorSonidos generadorSonidos;
    
    public VisitorSuperMario(SuperMario miEstado, GeneradorSonidos generadorSonidos) {
        this.generadorSonidos = generadorSonidos;
    	this.miEstado = miEstado;
        this.miContexto = this.miEstado.obtenerContexto();
        this.detectorDireccionColision = new DetectorDireccionColision();
    }

    @Override
    public void visitarBuzzyBeetle(BuzzyBeetle buzzyBeetle) {
    	if (this.detectorDireccionColision.choquePorArriba(buzzyBeetle, this.miContexto) &&
    	   !buzzyBeetle.obtenerRemovido()) {
    		this.generadorSonidos.emitirSonidoAplastarEnemigo2();
    		buzzyBeetle.establecerRemovido(true);
            this.miContexto.ganarPuntos(buzzyBeetle.obtenerPuntosOtorgadosPorEliminacion());
    	}
    }

    @Override
    public void visitarSpiny(Spiny spiny) {
    }

    @Override
    public void visitarGoomba(Goomba goomba) {
    	if (this.detectorDireccionColision.choquePorArriba(goomba, this.miContexto) 
    	   && !goomba.obtenerRemovido()) {
    		this.generadorSonidos.emitirSonidoAplastarEnemigo();
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
    	   this.generadorSonidos.emitirSonidoAplastarEnemigo2();
        }
    }

    @Override
    public void visitarKoopaDefault(KoopaDefault koopaDefault) {
    	if (this.detectorDireccionColision.choquePorArriba(koopaDefault.obtenerContext(), this.miContexto)) {
    		this.generadorSonidos.emitirSonidoAplastarEnemigo2();
    		EstadoKoopa nuevoEstado = new KoopaEnCaparazon();
	        koopaDefault.obtenerContext().cambiarEstado(nuevoEstado);
	        this.miContexto.ganarPuntos(koopaDefault.obtenerContext().obtenerPuntosOtorgadosPorEliminacion());
	        koopaDefault.obtenerContext().establecerVelocidadDireccional(new Point(0, 0));
		}
    }

    @Override
    public void visitarLakitu(Lakitu lakitu) {
    	if (this.detectorDireccionColision.choquePorArriba(lakitu, this.miContexto) 
    	   && !lakitu.obtenerRemovido()) {
    		this.generadorSonidos.emitirSonidoAplastarEnemigo();
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
    public void visitarEstrella(Estrella estrella) {
    	if (!estrella.obtenerRemovido()) {
    		this.miContexto.ganarPuntos(estrella.obtenerPuntosPorSuper());
    		generadorSonidos.PowerupAgarrado();
            estrella.establecerRemovido(true);
            generadorSonidos.modoInvencible();
            generadorSonidos.detenerMusicaFondo();
            Timer timer = new Timer(5500, new ActionListener() {
    	    	public void actionPerformed(ActionEvent e) {
    	    		generadorSonidos.reproducirMusicaFondo();
    	        }
    	    });
            timer.setRepeats(false); 
            timer.start(); 
    	}
    }

    @Override
    public void visitarMoneda(Moneda monedas) {
    	if (!monedas.obtenerRemovido()) {
    		this.miContexto.ganarPuntos(monedas.obtenerPuntosPorSuper());
        	monedas.establecerRemovido(true);
    	}
    }

    @Override
    public void visitarBloqueDePregunta(BloqueDePregunta bloqueDePregunta) {
    	if (detectorDireccionColision.choquePorAbajo(bloqueDePregunta, this.miContexto)) {
            detectorDireccionColision.verificarColisionElementoDeJuegoYEntidad(bloqueDePregunta, miContexto);
    		generadorSonidos.golpeBloque();
        }
    }

    @Override
    public void visitarLadrillo(Ladrillo ladrillo) {
    	if (detectorDireccionColision.choquePorAbajo(ladrillo, this.miContexto)) {
            detectorDireccionColision.verificarColisionElementoDeJuegoYEntidad(ladrillo, miContexto);
    		ladrillo.eliminarDelNivel();
    		generadorSonidos.romperLadrillo();
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
