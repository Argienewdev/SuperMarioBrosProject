package elementos.personajes;

import java.util.Vector;

import visitors.Visitante;

public interface MarioState {
	
	public void moverAIzquierda(Vector<Integer> direccion);
		
	public void moverADerecha(Vector<Integer> direccion);
	
	public void saltar(Visitante visitante);
		
	public void aceptarVisitante(Visitante visitante);
	
	public void incrementarMonedas(int cantidad);
}
