package elementos.enemigos;

import java.util.Vector;

import visitors.Visitante;

public interface EstadoKoopa {

	public void moverAIzquierda(Vector<Integer> direccion);
	
	public void moverADerecha(Vector<Integer> direccion);
	
	public void aceptarVisitante(Visitante visitante);
	
}
