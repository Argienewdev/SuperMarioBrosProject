package juego;

import java.util.HashMap;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import elementos.ElementoDeJuego;
import elementos.entidades.Entidad;
import elementos.plataformas.Plataforma;

public class MatrizPlataforma {
    
    private static final int TAMANIO_CELDA = 50;
    
    private int columnas;
    
    private int filas;
    
    private Plataforma [][]grilla;
    
    public MatrizPlataforma(int anchoMapa, int altoMapa) {
        this.columnas = anchoMapa*2/TAMANIO_CELDA;
        this.filas = (altoMapa/TAMANIO_CELDA)+2;
        //Se le añaden dos a las filas para modelar el vacio que se encuentra en -1
        this.grilla = new Plataforma[filas][columnas];
    }
    
    
    public void agregarPlataforma(Plataforma plataforma) {
    	Point posicionPlataforma = plataforma.obtenerPosicionLogica();
        int altoPlataforma = plataforma.obtenerAlto();
        int anchoPlataforma = plataforma.obtenerAncho();
        int posX = posicionPlataforma.x;
        int posY = posicionPlataforma.y;
        
        for (int i = posX; i < posX + anchoPlataforma; i += TAMANIO_CELDA) {
        	for (int j = posY; j < posY + altoPlataforma; j += TAMANIO_CELDA) {
        		grilla[j/TAMANIO_CELDA][i/TAMANIO_CELDA]=plataforma;
        		
        	}
        }
    }
    
    public void removerPlataforma(Plataforma plataforma) {
    	Point posicionPlataforma = plataforma.obtenerPosicionLogica();
        int altoPlataforma = plataforma.obtenerAlto();
        int anchoPlataforma = plataforma.obtenerAncho();
        int posX = posicionPlataforma.x;
        int posY = posicionPlataforma.y;
        
        for (int i = posX; i < posX + anchoPlataforma; i += TAMANIO_CELDA)
        	for (int j = posY; j < posY + altoPlataforma; j += TAMANIO_CELDA) {
        		grilla[j/TAMANIO_CELDA][i/TAMANIO_CELDA]=null;
        	}
    }
    
    
    public Plataforma obtenerPlataformaEnPunto (Point punto) {
    	int posX = punto.x/TAMANIO_CELDA;
    	int posY = punto.y/TAMANIO_CELDA;
    	return grilla[posY][posX];
    }
    
   public void limpiarMapa() {
	   this.grilla = new Plataforma[filas][columnas];
   }


	public Iterable<Plataforma> obtenerAdyacentes(Entidad entidad) {
		ArrayList<Plataforma> listaDePlataformasAdyacentes = new ArrayList<Plataforma>();
		int posicionXDeElementoEnLaGrilla = entidad.obtenerPosicionLogica().x/TAMANIO_CELDA;
		int posicionYDeElementoEnLaGrilla = (entidad.obtenerPosicionLogica().y)/TAMANIO_CELDA;
		for(int y=posicionYDeElementoEnLaGrilla-2;y<=posicionYDeElementoEnLaGrilla+2;y++) {
			for(int x=posicionXDeElementoEnLaGrilla-2;x<=posicionXDeElementoEnLaGrilla+2;x++) {
				if(estanEnRango(x, y)) {
					Plataforma plataforma = grilla[y][x];
					if( plataforma!=null) {
						listaDePlataformasAdyacentes.add(plataforma);
					}
					else {
					}
				}else {
				}
			}
		}
		return listaDePlataformasAdyacentes;
	}
	
	
	public Iterable<Plataforma> obtenerTodasLasPlataformas() {
		ArrayList<Plataforma> listaDePlataformas = new ArrayList<Plataforma>();
		for(int y=0-2;y<=this.filas;y++) {
			for(int x=0;x<=this.columnas;x++) {
				if(estanEnRango(x, y)) {
					Plataforma plataforma = grilla[y][x];
					if( plataforma!=null) {
						listaDePlataformas.add(plataforma);
					}
				}
			}
		}
		return listaDePlataformas;
	}
	
	private boolean estanEnRango(int x, int y) {
		return (x>=0 && x<this.columnas && y>=0 && y<this.filas);
	  
	}
}