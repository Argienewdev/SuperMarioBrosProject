package visitors;

import elementos.enemigos.*;
import elementos.entidades.BolaDeFuego;
import elementos.personajes.*;
import elementos.plataformas.*;
import elementos.powerUps.*;
import fabricas.FabricaEntidades;

public class VisitorFlorDeFuego implements Visitante {

    protected FlorDeFuego miEntidad;
    
    protected FabricaEntidades fabricaEntidades;

    public VisitorFlorDeFuego(FlorDeFuego miEntidad, FabricaEntidades fabricaEntidades) {
        this.miEntidad = miEntidad;
        this.fabricaEntidades=fabricaEntidades;
    }

    @Override
    public void visitarBuzzyBeetle(BuzzyBeetle buzzyBeetle) {
    	//Se traspasan
    }

    @Override
    public void visitarSpiny(Spiny spiny) {
    	//Se traspasan
    }

    @Override
    public void visitarGoomba(Goomba goomba) {
    	//Se traspasan
    }

    @Override
    public void visitarLakitu(Lakitu lakitu) {
    	//Se traspasan
    }

    @Override
    public void visitarPiranhaPlant(PiranhaPlant piranhaPlant) {
    	//Se traspasan
    }

    @Override
    public void visitarSuperChampinion(SuperChampinion superChampinion) {
    	//Se traspasan
    }

    @Override
    public void visitarFlorDeFuego(FlorDeFuego florDeFuego) {
    	//Se traspasan
    }

    @Override
    public void visitarChampinionVerde(ChampinionVerde champinionVerde) {
    	//Se traspasan
    }

    @Override
    public void visitarEstrella(Estrella estrella) {
    	//Se traspasan
    }

    @Override
    public void visitarMonedas(Monedas monedas) {
    	//Se traspasan
    }

    @Override
    public void visitarContextoMario(ContextoMario contextoMario) {
        contextoMario.getEstado().aceptarVisitante(this);
    }

    @Override
    public void visitarMarioDefault(MarioDefault marioDefault) {
        ContextoMario contextoMario = marioDefault.getContext();
        contextoMario.ganarPuntos(this.miEntidad.obtenerPuntosPorDefault());
        contextoMario.cambiarEstado(new MarioFuego(fabricaEntidades));
    }

    @Override
    public void visitarSuperMario(SuperMario superMario) {
        ContextoMario contextoMario = superMario.getContext();
        contextoMario.ganarPuntos(this.miEntidad.obtenerPuntosPorSuper());
        contextoMario.cambiarEstado(new MarioFuego(fabricaEntidades));
    }

    @Override
    public void visitarMarioFuego(MarioFuego marioFuego) {
    	ContextoMario contextoMario = marioFuego.getContext();
    	contextoMario.ganarPuntos(this.miEntidad.obtenerPuntosPorFuego());
    }

    @Override
    public void visitarMarioInvulnerable(MarioInvulnerable marioInvulnerable) {
        ContextoMario contextoMario = marioInvulnerable.getContext();
        contextoMario.ganarPuntos(this.miEntidad.obtenerPuntosPorInvulnerable());
    }
    
    public void visitarMarioRecuperacion(MarioRecuperacion marioRecuperacion) {
    	ContextoMario contextoMario = marioRecuperacion.getContext();
    	contextoMario.ganarPuntos(this.miEntidad.obtenerPuntosPorDefault());
        contextoMario.cambiarEstado(new MarioFuego(fabricaEntidades));
    }

    @Override
    public void visitarBloqueDePregunta(BloqueDePregunta bloqueDePregunta) {
    	//Se encarga el bloque
    }

    @Override
    public void visitarLadrillo(Ladrillo ladrillo) {
    	//Se encarga el bloque
    }

    @Override
    public void visitarPrincesaPeach(PrincesaPeach princesaPeach) {
    	//Se encarga la princesa
    }

    @Override
    public void visitarBandera(Bandera bandera) {
    	//Se encarga la bandera
    }

    @Override
    public void visitarTuberia(Tuberia tuberia) {
    	//Se enncarga el bloque
    }

    @Override
    public void visitarBloqueSolido(BloqueSolido bloqueSolido) {
    	//Se enncarga el bloque
    }

    @Override
    public void visitarContextoKoopaTroopa(ContextoKoopaTroopa contextoKoopaTroopa) {
    	//Se atraviesan
    }

    @Override
    public void visitarKoopaEnCaparazon(KoopaEnCaparazon koopaEnCaparazon) {
    	//Se atraviesan
    }

    @Override
    public void visitarKoopaDefault(KoopaDefault koopaDefault) {
    	//Se atraviesan
    }

    @Override
    public void visitarPiso(Piso piso) {}

	@Override
	public void visitarBolaDeFuego(BolaDeFuego bolaDeFuego) {
		bolaDeFuego.eliminarDelNivel();
	}
  
}
