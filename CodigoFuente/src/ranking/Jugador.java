package ranking;

import java.io.Serializable;

public class Jugador implements Comparable<Jugador>, Serializable {
	
	private static final long serialVersionUID = 1L;

	private String nombre;
	
	private int puntaje;
	
	
	
	public Jugador () {
		nombre = null;
		puntaje = 0;
	}
	
	public void establecerNombre (String nombre) {
		this.nombre = nombre;
	}
	
	
	public void actualizarPuntos(int puntaje) {
		this.puntaje = puntaje;
	}

	public String obtenerNombre() {
		return nombre;
	}

	public int obtenerPuntaje() {
		return puntaje;
	}
	
	public int compareTo (Jugador jugador) {
		return Integer.compare(puntaje, jugador.obtenerPuntaje());		
	}

}
