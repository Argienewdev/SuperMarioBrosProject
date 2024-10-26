package visitors;

import elementos.enemigos.*;
import elementos.entidades.BolaDeFuego;
import elementos.personajes.*;
import elementos.plataformas.*;
import elementos.powerUps.*;

public class VisitorBuzzyBeetle implements Visitante {
    
    protected BuzzyBeetle miEntidad;
    
    protected DetectorDireccionColision detectorDireccionColision;
    
    public VisitorBuzzyBeetle(BuzzyBeetle miEntidad) {
        this.miEntidad = miEntidad;
        this.detectorDireccionColision = new DetectorDireccionColision();
    }
    
    @Override
    public void visitarBuzzyBeetle(BuzzyBeetle buzzyBeetle) {
    }
    
    @Override
    public void visitarSpiny(Spiny spiny) {
    }

    @Override
    public void visitarGoomba(Goomba goomba) {
    }
    
    @Override
    public void visitarContextoKoopaTroopa(ContextoKoopaTroopa contextoKoopaTroopa) {
    }

    @Override
    public void visitarKoopaEnCaparazon(KoopaEnCaparazon koopaEnCaparazon) {
    }

    @Override
    public void visitarKoopaDefault(KoopaDefault koopaDefault) {
    }
    
    @Override
    public void visitarLakitu(Lakitu lakitu) {
    }
    
    @Override
    public void visitarPiranhaPlant(PiranhaPlant piranhaPlant) {
    }

    @Override
    public void visitarSuperChampinion(SuperChampinion superChampinion) {
    }

    @Override
    public void visitarFlorDeFuego(FlorDeFuego florDeFuego) {
    }

    @Override
    public void visitarChampinionVerde(ChampinionVerde champinionVerde) {
    }
    
    @Override
    public void visitarEstrella(Estrella estrella) {
    }

    @Override
    public void visitarMonedas(Monedas monedas) {
    }

    @Override
    public void visitarBloqueDePregunta(BloqueDePregunta bloqueDePregunta) {
    }

    @Override
    public void visitarLadrillo(Ladrillo ladrillo) {
    }
    
    @Override
    public void visitarPrincesaPeach(PrincesaPeach princesaPeach) {
        // TODO Auto-generated method stub
    }

    @Override
    public void visitarBandera(Bandera bandera) {
    }

    @Override
    public void visitarTuberia(Tuberia tuberia) {
    }

    @Override
    public void visitarBloqueSolido(BloqueSolido bloqueSolido) {
    }
    
    @Override
    public void visitarContextoMario(ContextoMario contextoMario) {
        contextoMario.getEstado().aceptarVisitante(this);
    }

    @Override
    public void visitarMarioDefault(MarioDefault marioDefault) {
        if(this.detectorDireccionColision.choquePorDerecha(marioDefault.getContext(), this.miEntidad) ||
           this.detectorDireccionColision.choquePorIzquierda(marioDefault.getContext(), this.miEntidad)) {
            ContextoMario contextoMario = marioDefault.getContext();
            if (contextoMario.getVidas() == 1) {
                int perdidaPuntos = miEntidad.getPuntosSustraidosPorMuerteCausada();
                contextoMario.perderPuntos(perdidaPuntos);
                // TODO hay que matar a mario...
            } else {
                contextoMario.perderVida();
                contextoMario.setImpactado(true);
            }
        }
    }
    
    @Override
    public void visitarSuperMario(SuperMario superMario) {
        if(this.detectorDireccionColision.choquePorDerecha(superMario.getContext(), this.miEntidad) ||
           this.detectorDireccionColision.choquePorIzquierda(superMario.getContext(), this.miEntidad)) {
            ContextoMario contextoMario = superMario.getContext();
            EstadoMario nuevoEstado = new MarioDefault();
            contextoMario.cambiarEstado(nuevoEstado);
            contextoMario.setImpactado(true);
        }
    }

    @Override
    public void visitarMarioFuego(MarioFuego marioFuego) {
    	if(this.detectorDireccionColision.choquePorDerecha(marioFuego.getContext(), this.miEntidad) ||
    		this.detectorDireccionColision.choquePorIzquierda(marioFuego.getContext(), this.miEntidad)) {
    		ContextoMario contextoMario = marioFuego.getContext();
            EstadoMario nuevoEstado = new MarioDefault();
            contextoMario.cambiarEstado(nuevoEstado);
            contextoMario.setImpactado(true);
        }
    }
    
    @Override
    public void visitarMarioInvulnerable(MarioInvulnerable marioInvulnerable) {
        // TODO Auto-generated method stub
    }

	@Override
	public void visitarPiso(Piso piso) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitarBolaDeFuego(BolaDeFuego fireball) {
		// TODO Auto-generated method stub
		
	}
    
}
