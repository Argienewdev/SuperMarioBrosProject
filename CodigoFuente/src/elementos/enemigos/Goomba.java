package elementos.enemigos;

import java.awt.Point;
import elementos.Sprite;
import fabricas.FabricaSprites;
import observers.ObserverGrafico;
import visitors.Visitante;

public class Goomba extends Enemigo {
	
	private int cont;
	
    public Goomba(Sprite sprite, Point posicion, Visitante visitor,
    			   Point velocidadDireccional, ObserverGrafico observerGrafico) {
        super(sprite, posicion, visitor, velocidadDireccional, observerGrafico);
        this.puntosOtorgadosPorEliminacion = 60;
        this.puntosSustraidosPorMuerteCausada = 30;
        this.cont = 0;
    }
    
    @Override
    public void aceptarVisitante(Visitante visitante) {
        visitante.visitar(this);
    }

	@Override
	public void actualizarSprite(FabricaSprites fabricaSprites) {
		if(cont%10 == 0) {
			this.setSprite(fabricaSprites.getGoombaCaminandoPrimeraTransicion());
		} else if(cont%5 == 0){
			this.setSprite(fabricaSprites.getGoombaCaminandoSegundaTransicion());
		}
		cont++;
		if(cont == 999) {
			cont = 1;
		}
	}
    
}