package elementos.powerUps;

import java.awt.Point;
import elementos.Sprite;
import elementos.entidades.NoJugable;
import elementos.personajes.ContextoMario;
import observers.ObserverGrafico;
import visitors.Visitante;

public abstract class PowerUp extends NoJugable {
	
	protected boolean esMovible;
	
	protected boolean estaFueraDeBloqueDePreguntas;
	
	protected Point posicionOriginal; // Almacenar la posición original
	
    protected int alturaDeseada; // Altura que desea alcanzar

	public PowerUp(Sprite sprite, Point posicion, Visitante visitor, 
				    Point velocidadDireccional, ObserverGrafico observerGrafico) {
		super(sprite, posicion, visitor, velocidadDireccional, observerGrafico);
		this.posicionOriginal = posicion;
		this.alturaDeseada = 596;
	}
	
	public abstract void aceptarVisitante(Visitante visitante);
	
	public abstract int obtenerPuntosPorDefault();
	
	public abstract int obtenerPuntosPorSuper();
	
	public abstract int obtenerPuntosPorInvulnerable();
	
	public abstract int obtenerPuntosPorFuego();
	
	public boolean estaFueraDeBloqueDePreguntas() {
		return this.estaFueraDeBloqueDePreguntas;
	}

	public boolean esMovible() {
		return this.esMovible;
	}
	
	public void establecerEsMovible(boolean esMovible) {
		this.esMovible = esMovible;
	}
	
	public void establecerEstaFueraDeBloqueDePreguntas(boolean estaFueraDelBloqueDePreguntas) {
		this.estaFueraDeBloqueDePreguntas = estaFueraDelBloqueDePreguntas;
	}

	public void eliminarDelNivel() {
		this.miNivel.removePowerUp(this);
	}
	
	public Point getPosicionOriginal() {
        return this.posicionOriginal;
    }

    public int getAlturaDeseada() {
        return this.alturaDeseada;
    }

}
