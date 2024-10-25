package launcher;

import java.io.Serializable;

import elementos.entidades.Jugable;

public class Jugador implements Comparable<Jugador>, Serializable {
	
	private String nombre;
	
	private int puntaje;
	
	private Jugable personaje;
	
	public Jugador (String nombre, Jugable personaje) {
		this.nombre = nombre;
		this.personaje = personaje;
		puntaje = personaje.getPuntos();
	}
	
	public void establecerNombre (String nombre) {
		this.nombre = nombre;
	}
	
	public void establecerPersonaje (Jugable personaje) {
		this.personaje = personaje;
	}
	
	public void actualizarPuntos() {
		personaje.getPuntos();
	}

	public String obtenerNombre() {
		return nombre;
	}

	public int obtenerPuntaje() {
		return puntaje;
	}
	
	@SuppressWarnings("exports")
	public Jugable obtenerPersonaje() {
		return personaje;
	}
	
	public int compareTo (Jugador jugador) {
		return Integer.compare(puntaje, jugador.obtenerPuntaje());		
	}

}
