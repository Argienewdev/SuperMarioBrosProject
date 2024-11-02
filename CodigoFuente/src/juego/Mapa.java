package juego;

import java.util.HashMap;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import elementos.plataformas.Plataforma;

public class Mapa {
    
    private static final int TAMANIOCELDA = 50;
    
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
        
        for (int i = posX; i < posX + anchoPlataforma; i += TAMANIOCELDA)
        	for (int j = posY; j < posY + altoPlataforma; j += TAMANIOCELDA) {
        		Point celda = new Point (i / TAMANIOCELDA, j / TAMANIOCELDA);
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
        
        for (int i = posX; i < posX + anchoPlataforma; i += TAMANIOCELDA)
        	for (int j = posY; j < posY + altoPlataforma; j += TAMANIOCELDA) {
        		Point celda = new Point (i / TAMANIOCELDA, j / TAMANIOCELDA);
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
    	Point celda = new Point ((posX / TAMANIOCELDA), (posY / TAMANIOCELDA));
    	
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
   
}