package elementos.enemigos;

import java.awt.Point;

import visitors.Visitante;

public interface EstadoKoopa {

	public void moverAIzquierda(Point direccion);
	
	public void moverADerecha(Point direccion);
	
	public void aceptarVisitante(Visitante visitante);
	
}
