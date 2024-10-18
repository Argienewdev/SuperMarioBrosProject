package elementos.plataformas;

import java.awt.Point;
import java.util.Vector;

import elementos.Sprite;
import elementos.enemigos.PiranhaPlant;
import visitors.Visitante;

public class Tuberia extends BloqueSolido{
    
    protected PiranhaPlant miPiranhaPlant;
    
    protected int altura;
    
    protected final int ancho=2;

    public Tuberia (Sprite sprite, Point pos, Visitante visitor, 
    				PiranhaPlant miPiranhaPlant, int altura) {
        super(sprite,pos,visitor);
        this.altura = altura;
        this.miPiranhaPlant = miPiranhaPlant;
    }

    public void aceptarVisitante(Visitante visitante) {
        visitante.visitarTuberia(this);
    }
    
    public int obtenerAncho() {
    	return ancho;
    }
    
    public int obtenerAlto() {
    	return altura;
    }

}