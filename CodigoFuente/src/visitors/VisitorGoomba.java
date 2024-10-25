package visitors;

import elementos.enemigos.*;
import elementos.entidades.Fireball;
import elementos.personajes.*;
import elementos.plataformas.*;
import elementos.powerUps.*;

public class VisitorGoomba implements Visitante {

    protected Goomba miEntidad;
    
    DetectorDireccionColision detectorDireccionColision;

    public VisitorGoomba(Goomba miEntidad) {
        this.miEntidad = miEntidad;
        this.detectorDireccionColision = new DetectorDireccionColision();
    }

    @Override
    public void visitarBuzzyBeetle(BuzzyBeetle buzzyBeetle) {
        // No se requiere comportamiento específico por ahora
    }

    @Override
    public void visitarSpiny(Spiny spiny) {
        // No se requiere comportamiento específico por ahora
    }

    @Override
    public void visitarGoomba(Goomba goomba) {
        this.detectorDireccionColision.verificarColisionEntreEntidades(this.miEntidad, goomba);
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
    public void visitarFireball(Fireball fireball) {
        // TODO Auto-generated method stub
    }

    @Override
    public void visitarSuperChampinion(SuperChampinion superChampinion) {
        // No se requiere comportamiento específico por ahora
    }

    @Override
    public void visitarFlorDeFuego(FlorDeFuego florDeFuego) {
        // No se requiere comportamiento específico por ahora
    }

    @Override
    public void visitarChampinionVerde(ChampinionVerde champinionVerde) {
        // No se requiere comportamiento específico por ahora
    }

    @Override
    public void visitarEstrella(Estrella estrella) {
        // No se requiere comportamiento específico por ahora
    }

    @Override
    public void visitarMonedas(Monedas monedas) {
        // No se requiere comportamiento específico por ahora
    }

    @Override
    public void visitarContextoMario(ContextoMario contextoMario) {
        contextoMario.getEstado().aceptarVisitante(this);
    }

    @Override
    public void visitarMarioDefault(MarioDefault marioDefault) {
        if (this.detectorDireccionColision.choquePorDerecha(marioDefault.getContext(), this.miEntidad) ||
            this.detectorDireccionColision.choquePorIzquierda(marioDefault.getContext(), this.miEntidad)) {

            ContextoMario contextoMario = marioDefault.getContext();
            if (contextoMario.getVidas() == 1) {
                int perdidaPuntos = this.miEntidad.getPuntosSustraidosPorMuerteCausada();
                contextoMario.perderPuntos(perdidaPuntos);
                // TODO: Implementar la lógica para "matar" a Mario.
            } else {
                contextoMario.perderVida();
                contextoMario.setImpactado(true);
            }
        }
    }

    @Override
    public void visitarSuperMario(SuperMario superMario) {
    	if (this.detectorDireccionColision.choquePorDerecha(superMario.getContext(), this.miEntidad) ||
                this.detectorDireccionColision.choquePorIzquierda(superMario.getContext(), this.miEntidad)) {
	        ContextoMario contextoMario = superMario.getContext();
	        EstadoMario nuevoEstado = new MarioDefault();
	        contextoMario.cambiarEstado(nuevoEstado);
            contextoMario.setImpactado(true);
    	}
    }

    @Override
    public void visitarMarioFuego(MarioFuego marioFuego) {
    	if (this.detectorDireccionColision.choquePorDerecha(marioFuego.getContext(), this.miEntidad) ||
                this.detectorDireccionColision.choquePorIzquierda(marioFuego.getContext(), this.miEntidad)) {
	        ContextoMario contextoMario = marioFuego.getContext();
	        EstadoMario nuevoEstado = new MarioDefault();
	        contextoMario.cambiarEstado(nuevoEstado);
            contextoMario.setImpactado(true);
    	}
    }

    @Override
    public void visitarMarioInvulnerable(MarioInvulnerable marioInvulnerable) {}

    @Override
    public void visitarBloqueDePregunta(BloqueDePregunta bloqueDePregunta) {
        // No se requiere comportamiento específico por ahora
    }

    @Override
    public void visitarLadrillo(Ladrillo ladrillo) {
        // No se requiere comportamiento específico por ahora
    }

    @Override
    public void visitarPiso(Piso piso) {
        // No se requiere comportamiento específico por ahora
    }

    @Override
    public void visitarPrincesaPeach(PrincesaPeach princesaPeach) {
        // TODO Auto-generated method stub
    }

    @Override
    public void visitarBandera(Bandera bandera) {
        // No se requiere comportamiento específico por ahora
    }

    @Override
    public void visitarTuberia(Tuberia tuberia) {
        // No se requiere comportamiento específico por ahora
    }

    @Override
    public void visitarBloqueSolido(BloqueSolido bloqueSolido) {
        // No se requiere comportamiento específico por ahora
    }

    @Override
    public void visitarContextoKoopaTroopa(ContextoKoopaTroopa contextoKoopaTroopa) {
        // No se requiere comportamiento específico por ahora
    }

    @Override
    public void visitarKoopaEnCaparazon(KoopaEnCaparazon koopaEnCaparazon) {
        // No se requiere comportamiento específico por ahora
    }

    @Override
    public void visitarKoopaDefault(KoopaDefault koopaDefault) {
        // No se requiere comportamiento específico por ahora
    }
    
}
