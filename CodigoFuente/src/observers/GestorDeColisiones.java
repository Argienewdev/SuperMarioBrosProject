package observers;

import java.util.ArrayList;

import elementos.entidades.Entidad;
import juego.EntidadLogica;

public class GestorDeColisiones implements ObserverColisiones {
	
	protected ArrayList<EntidadLogica> entidadesObservadas;
	
	
	public GestorDeColisiones() {
		entidadesObservadas = new ArrayList<>();
	}
	
	public void agregarEntidad (EntidadLogica entidad) {
		entidadesObservadas.add(entidad);
	}
	
	public void eliminarEntidad (EntidadLogica entidad) {
		 entidadesObservadas.remove(entidad);
	}
	
	public boolean verificarColisiones(Entidad entidad) {
		//TODO o verificar todos con todos
		// o dividir el nivel por zonas
		return false;
	}
	
	public void actualizar() {
		//TODO llamar a actualizadorGraficoJugador?
	}
	
	
	

}
