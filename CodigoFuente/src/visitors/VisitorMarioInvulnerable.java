package visitors;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import elementos.enemigos.*;
import elementos.entidades.BolaDeFuego;
import elementos.personajes.*;
import elementos.plataformas.*;
import elementos.powerUps.*;
import generadores.GeneradorSonidos;

public class VisitorMarioInvulnerable implements Visitante {

    protected EstadoMario miEstado;
    
    protected ContextoMario miContexto;
    
    protected DetectorDireccionColision detectorDireccionColision;
    
    protected GeneradorSonidos generadorSonidos;

    public VisitorMarioInvulnerable(MarioInvulnerable miEstado, GeneradorSonidos generadorSonidos) {
    	this.generadorSonidos = generadorSonidos;
        this.miEstado = miEstado;
        this.miContexto = this.miEstado.obtenerContexto();
        this.detectorDireccionColision = new DetectorDireccionColision();
    }

    @Override
    public void visitarBuzzyBeetle(BuzzyBeetle buzzyBeetle) {
    	if(!buzzyBeetle.obtenerRemovido()) {
    		this.generadorSonidos.emitirSonidoAplastarEnemigo2();
    		this.otorgarPuntosYEliminar(buzzyBeetle);
    	}
    }

    @Override
    public void visitarSpiny(Spiny spiny) {
    	if(!spiny.obtenerRemovido()) {
    		this.generadorSonidos.emitirSonidoAplastarEnemigo3();
    		this.otorgarPuntosYEliminar(spiny);
    	}
    }

    @Override
    public void visitarGoomba(Goomba goomba) {
    	if(!goomba.obtenerRemovido()) {
    		this.generadorSonidos.emitirSonidoAplastarEnemigo();
    		this.otorgarPuntosYEliminar(goomba);
    	}
    }

    @Override
    public void visitarContextoKoopaTroopa(ContextoKoopaTroopa contextoKoopaTroopa) {
    	contextoKoopaTroopa.obtenerEstado().aceptarVisitante(this.miContexto.obtenerEstado().obtenerVisitante());
    }

    @Override
    public void visitarKoopaDefault(KoopaDefault koopaDefault) {
    	if(!koopaDefault.obtenerContext().obtenerRemovido()) {
    		this.generadorSonidos.emitirSonidoAplastarEnemigo2();
    		this.otorgarPuntosYEliminar(koopaDefault.obtenerContext());
    	}
    }

    @Override
    public void visitarKoopaEnCaparazon(KoopaEnCaparazon koopaEnCaparazon) {
    	if(!koopaEnCaparazon.obtenerContext().obtenerRemovido()) {
    		this.generadorSonidos.emitirSonidoAplastarEnemigo2();
    		koopaEnCaparazon.obtenerContext().establecerRemovido(true);
    	}
    }

    @Override
    public void visitarLakitu(Lakitu lakitu) {
    	if(!lakitu.obtenerRemovido()) {
    		this.generadorSonidos.emitirSonidoAplastarEnemigo();
    		this.otorgarPuntosYEliminar(lakitu);
    	}
    }

    @Override
    public void visitarPiranhaPlant(PiranhaPlant piranhaPlant) {
    	if(!piranhaPlant.obtenerRemovido()) {
    		this.generadorSonidos.emitirSonidoAplastarEnemigo3();
    		this.otorgarPuntosYEliminar(piranhaPlant);
    	}
    }

    @Override
    public void visitarSuperChampinion(SuperChampinion superChampinion) {
    	if(!superChampinion.obtenerRemovido()) {
    		this.miContexto.ganarPuntos(superChampinion.obtenerPuntosPorInvulnerable());
    		superChampinion.establecerRemovido(true);
    	}
    }

    @Override
    public void visitarFlorDeFuego(FlorDeFuego florDeFuego) {
    	if(!florDeFuego.obtenerRemovido()) {
    		this.miContexto.ganarPuntos(florDeFuego.obtenerPuntosPorInvulnerable());
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
            generadorSonidos.PowerupAgarrado();
            generadorSonidos.modoInvencible();
            generadorSonidos.detenerMusicaFondo();
            Timer timer = new Timer(5000, new ActionListener() {
    	    	public void actionPerformed(ActionEvent e) {
    	    		generadorSonidos.reproducirMusicaFondo();
    	        }
    	    });
            timer.setRepeats(false); // Para que el timer se ejecute solo una vez
            timer.start(); // Inicia el timer
    	}
    }

    @Override
    public void visitarMoneda(Moneda monedas) {
    }

    @Override
    public void visitarBloqueDePregunta(BloqueDePregunta bloqueDePregunta) {
    }

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
    
    @Override
    public void visitarMarioRecuperacion(MarioRecuperacion marioRecuperacion) {}

    @Override
    public void visitarPiso(Piso piso) {}

	@Override
	public void visitarBolaDeFuego(BolaDeFuego fireball) {
	}

	@Override
	public void visitarVacio(Vacio vacio) {
	}

	// Método auxiliar para otorgar puntos y eliminar enemigos
	private void otorgarPuntosYEliminar(Enemigo enemigo) {
		int puntos = enemigo.obtenerPuntosOtorgadosPorEliminacion();
		this.miContexto.ganarPuntos(puntos);
		enemigo.establecerRemovido(true);
	}
    
}
