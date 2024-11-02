package juego;

import java.util.HashMap;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import elementos.ElementoDeJuego;
import elementos.entidades.Entidad;
import elementos.plataformas.Plataforma;

public class Mapa {
    
    private static final int TAMANIO_CELDA = 50;
    
    private int anchoMapa;
    
    private int altoMapa;
    
    private HashMap<Point, Plataforma> grilla;
    
    private Collection<Plataforma> todasLasPlataformas;
    
    private Collection<Plataforma> plataformasAfectables;
    
    public Mapa(int anchoMapa, int altoMapa) {
        this.anchoMapa = anchoMapa;
        this.altoMapa = altoMapa;
        this.grilla = new HashMap<>();
        this.todasLasPlataformas = new ArrayList<>();
        this.plataformasAfectables = new ArrayList<>();;
    }
    
    
    public void agregarPlataforma(Plataforma plataforma) {
    	Point posicionPlataforma = plataforma.obtenerPosicionLogica();
        int altoPlataforma = plataforma.obtenerAlto();
        int anchoPlataforma = plataforma.obtenerAncho();
        int posX = posicionPlataforma.x;
        int posY = posicionPlataforma.y;
        
        for (int i = posX; i < posX + anchoPlataforma; i += TAMANIO_CELDA)
        	for (int j = posY; j < posY + altoPlataforma; j += TAMANIO_CELDA) {
        		Point celda = new Point (i / TAMANIO_CELDA, j / TAMANIO_CELDA);
        		grilla.put(celda, plataforma);
        	}
        todasLasPlataformas.add(plataforma);
        }
    
    public void removerPlataforma(Plataforma plataforma) {
    	Point posicionPlataforma = plataforma.obtenerPosicionLogica();
        int altoPlataforma = plataforma.obtenerAlto();
        int anchoPlataforma = plataforma.obtenerAncho();
        int posX = posicionPlataforma.x;
        int posY = posicionPlataforma.y;
        
        for (int i = posX; i < posX + anchoPlataforma; i += TAMANIO_CELDA)
        	for (int j = posY; j < posY + altoPlataforma; j += TAMANIO_CELDA) {
        		Point celda = new Point (i / TAMANIO_CELDA, j / TAMANIO_CELDA);
        		grilla.remove(celda);
        	}
        todasLasPlataformas.remove(plataforma);
    }
    
    public void agregarPlataformaAfectable(Plataforma plataforma) {
    	plataformasAfectables.add(plataforma);
    }
    
    public Collection<Plataforma> obtenerPlataformasAfectables() {
    	return this.plataformasAfectables;
    }
    
    public Collection<Plataforma> obtenerTodasLasPlataformas() {
    	return this.todasLasPlataformas;
    }
    
    public Plataforma obtenerPlataformaEnPunto (Point punto) {
    	int posX = punto.x;
    	int posY = punto.y;
    	Point celda = new Point ((posX), (posY));
    	
    	return grilla.get(celda);
    }
    
   public void limpiarMapa() {
	   ArrayList<Plataforma> plataformasARemover = new ArrayList<>();
	   
	   for (Plataforma plataforma : todasLasPlataformas)
		   if (plataforma.obtenerRemovido())
			   plataformasARemover.add(plataforma);
	   
	   for (Plataforma plataforma : plataformasARemover)
		   removerPlataforma(plataforma);
   }


public Iterable<Plataforma> obtenerAdyacentes(Entidad entidad) {
	ArrayList<Plataforma> listaDePlataformasAdyacentes = new ArrayList<Plataforma>();
	int posicionXDeElementoEnLaGrilla = entidad.obtenerPosicionLogica().x/TAMANIO_CELDA;
	int posicionYDeElementoEnLaGrilla = (entidad.obtenerPosicionLogica().y)/TAMANIO_CELDA;
	for(int y=posicionYDeElementoEnLaGrilla-2;y<=posicionYDeElementoEnLaGrilla+2;y++) {
		for(int x=posicionXDeElementoEnLaGrilla-2;x<=posicionXDeElementoEnLaGrilla+2;x++) {
			Point punto = new Point(x,y);
			Plataforma plataforma = this.obtenerPlataformaEnPunto(punto);
			if( plataforma!=null) {
				listaDePlataformasAdyacentes.add(plataforma);
			}
		}
		System.out.println();
	}
	return listaDePlataformasAdyacentes;
}
   
}