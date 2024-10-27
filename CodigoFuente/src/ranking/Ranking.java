package ranking;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Ranking implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
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
	
    public void cargarEstado() {
        try {
            FileInputStream fileInputStream = new FileInputStream("./src/puntajes");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Ranking rankingCargado = (Ranking) objectInputStream.readObject();
            this.topJugadores = rankingCargado.topJugadores;
            objectInputStream.close();
        } catch (FileNotFoundException e) {
            System.out.println("Archivo de puntajes no encontrado. Se creará un nuevo ranking.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

	
	public void guardarEstado() {
		try {
			FileOutputStream  fileOutputStream = new FileOutputStream("./src/puntajes");
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(this);
			objectOutputStream.flush();
			objectOutputStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		  catch (IOException e) {
			e.printStackTrace();
		}
	}

}
