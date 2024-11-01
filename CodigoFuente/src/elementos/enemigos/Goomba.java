package elementos.enemigos;

import java.awt.Point;

import elementos.Sprite;
import fabricas.FabricaSprites;
import observers.ObserverGrafico;
import visitors.Visitante;

public class Goomba extends Enemigo {
	
	private static final int TICKS_PARA_ELIMINAR = 10;
	
    public Goomba(Sprite sprite, Point posicion, Visitante visitor, ObserverGrafico observerGrafico) {
        super(sprite, posicion, visitor, observerGrafico);
        this.puntosOtorgadosPorEliminacion = 60;
        this.puntosSustraidosPorMuerteCausada = 30;
        this.ticksAnimacion = TICKS_PARA_ELIMINAR;
    }
    
    @Override
    public void aceptarVisitante(Visitante visitante) {
        visitante.visitarGoomba(this);
    }

    @Override
	public void actualizarSprite(FabricaSprites fabricaSprites) {
		if (this.removido) {
			this.establecerVelocidadDireccional(new Point(0, 0));
			eliminarEntidadGrafica(fabricaSprites);
		} else if (mirandoAlFrente()) {
			this.establecerSprite(fabricaSprites.obtenerGoombaFrontalCaminando());
		} else {
			this.establecerSprite(fabricaSprites.obtenerGoombaReversoCaminando());
		}
	}
	
	@Override
	protected Sprite obtenerSpriteDeMuerte(FabricaSprites fabricaSprites) {
		return fabricaSprites.obtenerGoombaMuerto();
	}
	
	private boolean mirandoAlFrente() {
		return this.obtenerMirandoAlFrente();
	}
} 