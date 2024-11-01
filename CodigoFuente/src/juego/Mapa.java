package juego;

import java.awt.Point;
import java.util.HashMap;

import elementos.plataformas.Plataforma;

public class Mapa {
	
	private HashMap<Integer,Plataforma> columnas;	
	private int anchoMapa;
	
	private int altoMapa;
	
	
	private int altoCelda;
	
	public Mapa ( int anchoMapa, int altoMapa) {
		this.cuadricula = new HashMap<>();
		this.anchoMapa = anchoMapa;
		this.altoMapa = altoMapa;
		inicializarCuadricula();
	}

	private void inicializarCuadricula() {
		int totalFilas = altoMapa / tamanioCelda;
		int totalColumnas = anchoMapa / tamanioCelda;
		
		for (int i = 0; i < totalFilas; i++)
			for (int j = 0; j < totalColumnas; j++) {
				Point clave = new Point (j,i);
				cuadricula.put(clave,null);
			}
	}
	
	public void agregarPlataforma (Plataforma plataforma) {
		int celdaX = plataforma.obtenerAncho();
		int celdaY = plataforma.obtenerAlto();
		
		Point clave = new Point(celdaX,celdaY);
		
//		cuadricula.put(clave, plataforma);
	}
	
	public void removerPlataforma (Plataforma plataforma) {
		
	}
}
