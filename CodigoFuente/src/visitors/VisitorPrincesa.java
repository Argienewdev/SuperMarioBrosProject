package visitors;

import elementos.enemigos.*;
import elementos.entidades.BolaDeFuego;
import elementos.personajes.*;
import elementos.plataformas.*;
import elementos.powerUps.*;
import ventanas.ControladorVistas;

public class VisitorPrincesa implements Visitante {
    
    protected ControladorVistas controlador;
    
    protected DetectorDireccionColision detectorDireccionColision;
    
    protected PrincesaPeach miEntidad;
    
    public VisitorPrincesa(ControladorVistas controlador, PrincesaPeach miEntidad) {
        this.controlador = controlador;
        this.miEntidad = miEntidad;
        this.detectorDireccionColision = new DetectorDireccionColision();
    }

    @Override
    public void visitarBuzzyBeetle(BuzzyBeetle buzzyBeetle) {
        detectorDireccionColision.verificarColision(this.miEntidad, buzzyBeetle);
    }

    @Override
    public void visitarSpiny(Spiny spiny) {
    	detectorDireccionColision.verificarColision(this.miEntidad, spiny);
    }

    @Override
    public void visitarGoomba(Goomba goomba) {
    	detectorDireccionColision.verificarColision(this.miEntidad, goomba);
    }

    @Override
    public void visitarLakitu(Lakitu lakitu) {
    	detectorDireccionColision.verificarColision(this.miEntidad, lakitu);
    }

    @Override
    public void visitarPiranhaPlant(PiranhaPlant piranhaPlant) {
        //Ambos estaticos
    }

    @Override
    public void visitarSuperChampinion(SuperChampinion superChampinion) {
    	detectorDireccionColision.verificarColision(this.miEntidad, superChampinion);
    }

    @Override
    public void visitarFlorDeFuego(FlorDeFuego florDeFuego) {
    	detectorDireccionColision.verificarColision(this.miEntidad, florDeFuego);
    }

    @Override
    public void visitarChampinionVerde(ChampinionVerde champinionVerde) {
    	detectorDireccionColision.verificarColision(this.miEntidad, champinionVerde);
    }

    @Override
    public void visitarEstrella(Estrella estrella) {
    	detectorDireccionColision.verificarColision(this.miEntidad, estrella);
    }

    @Override
    public void visitarMonedas(Monedas moneda) {
    	detectorDireccionColision.verificarColision(this.miEntidad, moneda);
    }

    @Override
    public void visitarBloqueDePregunta(BloqueDePregunta bloqueDePregunta) {
    	//Ambos estaticos
    }

    @Override
    public void visitarLadrillo(Ladrillo ladrillo) {
    	//Ambos estaticos
    }

    @Override
    public void visitarPrincesaPeach(PrincesaPeach princesaPeach) {}

    @Override
    public void visitarBandera(Bandera bandera) {
    	//Ambos estaticos, no pueden aparecer en el mismo nivel
    }

    @Override
    public void visitarTuberia(Tuberia tuberia) {
    	//Ambos estaticos
    }

    @Override
    public void visitarBloqueSolido(BloqueSolido bloqueSolido) {
    	//Ambos estaticos
    }

    @Override
    public void visitarContextoMario(ContextoMario contextoMario) {
    	this.controlador.mostrarPantallaFinal(); 
    }

    @Override
    public void visitarContextoKoopaTroopa(ContextoKoopaTroopa contextoKoopaTroopa) {
    	detectorDireccionColision.verificarColision(this.miEntidad, contextoKoopaTroopa);
    }

    @Override
    public void visitarKoopaEnCaparazon(KoopaEnCaparazon koopaEnCaparazon) {}

    @Override
    public void visitarKoopaDefault(KoopaDefault koopaDefault) {}

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
	public void visitarBolaDeFuego(BolaDeFuego bolaDeFuego) {
		bolaDeFuego.eliminarDelNivel();
	}
    
}
