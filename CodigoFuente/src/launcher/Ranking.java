package launcher;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Ranking implements Serializable {
	
	private List<Jugador> topJugadores;
	
	public Ranking () {
		this.topJugadores = new ArrayList<>();
	}
	
	public void agregarJugador (Jugador jugador) {
		topJugadores.add(jugador);
	}
	
	public List<Jugador> obtenerTopRanking() {
		//Ordena la lista en forma descendente
		Collections.sort(topJugadores,Collections.reverseOrder());
		List<Jugador> top5 = new ArrayList<>();
		Iterator<Jugador> iterador = topJugadores.iterator();
		int i = 0;
		while (iterador.hasNext() && i < 5) {
			top5.add(iterador.next());
			i++;
		}
		return top5;
	}
	

}
