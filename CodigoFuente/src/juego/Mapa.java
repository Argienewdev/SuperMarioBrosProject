package juego;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import elementos.plataformas.Plataforma;

public class Mapa {
	
	private HashMap<Integer,List<Plataforma>> columnas;	

	private int anchoMapa;
	
	public Mapa (int anchoMapa) {
		this.columnas = new HashMap<>();
		this.anchoMapa = anchoMapa;
		inicializarColumnas();
	}
	
	private void inicializarColumnas() {
		for (int i = 0; i <= anchoMapa; i++) {
			List<Plataforma> plataformasEnColumna = new ArrayList<>();
			columnas.put(i,plataformasEnColumna);
		}
	}

	public void agregarPlataforma (Plataforma plataforma) {
		int posX = plataforma.obtenerPosicionLogica().x;
		List<Plataforma> plataformasEnColumna = columnas.get(posX);
		plataformasEnColumna.add(plataforma);
	}
	
	public void removerPlataforma (Plataforma plataforma) {
		int posX = plataforma.obtenerPosicionLogica().x;
		List<Plataforma> plataformasEnColumna = columnas.get(posX);
		plataformasEnColumna.remove(plataforma); 
	}
	
	public List<Plataforma> obtenerPlataformaEnColumna (int x) {
		return columnas.getOrDefault(x, new ArrayList<>());
	}
	
}
