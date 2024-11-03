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
       
	public Iterable<Plataforma> obtenerAdyacentes(Entidad entidad) {
		ArrayList<Plataforma> listaDePlataformasAdyacentes = new ArrayList<Plataforma>();
		Point puntoEnLaGrilla = posicionEnLaGrilla(entidad);
		for(int y=puntoEnLaGrilla.y-2;y<=puntoEnLaGrilla.y+2;y++) {
			for(int x=puntoEnLaGrilla.x-2;x<=puntoEnLaGrilla.x+2;x++) {
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
	
	private Point posicionEnLaGrilla(Entidad entidad) {
		//TODO se puede sacar el casteo?
		//Se castea el tamanio de la celda, para que la division de un float y asi poder redondear al mas cercano
		float posicionXDeElementoSinRedondear = entidad.obtenerPosicionLogica().x/((float)TAMANIO_CELDA);
		float posicionYDeElementoSinRedondear = entidad.obtenerPosicionLogica().y/((float)TAMANIO_CELDA);
		int posicionXDeElementoEnLaGrilla = Math.round(posicionXDeElementoSinRedondear);
		int posicionYDeElementoEnLaGrilla = Math.round(posicionYDeElementoSinRedondear);
		Point puntoADevolver = new Point(posicionXDeElementoEnLaGrilla,posicionYDeElementoEnLaGrilla);
		return puntoADevolver;
	}
}