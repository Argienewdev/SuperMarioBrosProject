package visitors;

import elementos.enemigos.*;
import elementos.entidades.BolaDeFuego;
import elementos.personajes.*;
import elementos.plataformas.*;
import elementos.powerUps.*;
import juego.Nivel;

public class VisitorBolaDeFuego implements Visitante {

    protected BolaDeFuego miEntidad;

    public VisitorBolaDeFuego(BolaDeFuego miEntidad) {
        this.miEntidad = miEntidad;
    }

    @Override
    public void visitarBuzzyBeetle(BuzzyBeetle buzzyBeetle) {
        otorgarPuntosYEliminar(buzzyBeetle);
    }

    @Override
    public void visitarSpiny(Spiny spiny) {
        otorgarPuntosYEliminar(spiny);
    }

    @Override
    public void visitarGoomba(Goomba goomba) {
        otorgarPuntosYEliminar(goomba);
    }

    @Override
    public void visitarContextoKoopaTroopa(ContextoKoopaTroopa contextoKoopaTroopa) {
        otorgarPuntosYEliminar(contextoKoopaTroopa);
    }

    @Override
    public void visitarKoopaDefault(KoopaDefault koopaDefault) {
        // Sin lógica específica
    }

    @Override
    public void visitarKoopaEnCaparazon(KoopaEnCaparazon koopaEnCaparazon) {
        // Sin lógica específica
    }

    @Override
    public void visitarLakitu(Lakitu lakitu) {
        otorgarPuntosYEliminar(lakitu);
    }

    @Override
    public void visitarPiranhaPlant(PiranhaPlant piranhaPlant) {
        otorgarPuntosYEliminar(piranhaPlant);
    }

    @Override
    public void visitarSuperChampinion(SuperChampinion superChampinion) {
        // Sin lógica específica
    }

    @Override
    public void visitarFlorDeFuego(FlorDeFuego florDeFuego) {
        // Sin lógica específica
    }

    @Override
    public void visitarChampinionVerde(ChampinionVerde champinionVerde) {
        // Sin lógica específica
    }

    @Override
    public void visitarEstrella(Estrella estrella) {
        // Sin lógica específica
    }

    @Override
    public void visitarMonedas(Monedas monedas) {
        // Sin lógica específica
    }

    @Override
    public void visitarMarioDefault(MarioDefault marioDefault) {
        // Sin lógica específica
    }

    @Override
    public void visitarMarioInvulnerable(MarioInvulnerable marioInvulnerable) {
        // Sin lógica específica
    }

    @Override
    public void visitarMarioFuego(MarioFuego marioFuego) {
        // Sin lógica específica
    }

    @Override
    public void visitarSuperMario(SuperMario superMario) {
        // Sin lógica específica
    }
    
    public void visitarMarioRecuperacion(MarioRecuperacion marioRecuperacion) {
    	// Sin logica especifica
    }

    @Override
    public void visitarBloqueDePregunta(BloqueDePregunta bloqueDePregunta) {
        // Sin lógica específica
    }

    @Override
    public void visitarLadrillo(Ladrillo ladrillo) {
        // Sin lógica específica
    }

    @Override
    public void visitarPrincesaPeach(PrincesaPeach princesaPeach) {
        // Sin lógica específica
    }

    @Override
    public void visitarBandera(Bandera bandera) {
        // Sin lógica específica
    }

    @Override
    public void visitarTuberia(Tuberia tuberia) {
        // Sin lógica específica
    }

    @Override
    public void visitarBloqueSolido(BloqueSolido bloqueSolido) {
        // Sin lógica específica
    }

    @Override
    public void visitarContextoMario(ContextoMario contextoMario) {
        // Sin lógica específica
    }

    @Override
    public void visitarPiso(Piso piso) {
        // Sin lógica específica
    }

    // Método auxiliar para otorgar puntos y eliminar enemigos
    private void otorgarPuntosYEliminar(Enemigo enemigo) {
        int puntos = enemigo.getPuntosOtorgadosPorEliminacion();
        this.miEntidad.obtenerJugador().ganarPuntos(puntos);
        Nivel nivel = enemigo.getNivel();
        nivel.addEntidadesAEliminar(enemigo);
    }

	@Override
	public void visitarBolaDeFuego(BolaDeFuego fireball) {
		// TODO Auto-generated method stub
		
	}
}
