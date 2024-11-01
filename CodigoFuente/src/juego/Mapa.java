package juego;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import elementos.plataformas.Plataforma;

public class Mapa {
	
    private ConcurrentHashMap<Integer, List<Plataforma>> columnas;
    
    private final int anchoMapa;

    public Mapa(int anchoMapa) {
        this.anchoMapa = anchoMapa;
        this.columnas = new ConcurrentHashMap<>();
        inicializarColumnas();
    }

    private void inicializarColumnas() {
        for (int i = 0; i <= anchoMapa; i++) {
            columnas.put(i, new ArrayList<>());
        }
    }

    public synchronized void agregarPlataforma(Plataforma plataforma) {
        int posX = plataforma.obtenerPosicionLogica().x;
        
        List<Plataforma> plataformasEnColumna = columnas.get(posX);
        if (plataformasEnColumna == null) {
            plataformasEnColumna = new ArrayList<>();
            columnas.put(posX, plataformasEnColumna);
        }
        synchronized (plataformasEnColumna) {
            plataformasEnColumna.add(plataforma);
        }
    }

    public synchronized void removerPlataforma(Plataforma plataforma) {
        int posX = plataforma.obtenerPosicionLogica().x;
        List<Plataforma> plataformasEnColumna = columnas.get(posX);
        
        if (plataformasEnColumna != null) {
            synchronized (plataformasEnColumna) {
                plataformasEnColumna.remove(plataforma);
            }
        }
    }

    public List<Plataforma> obtenerPlataformaEnColumna(int x) {
        List<Plataforma> plataformasEnColumna = columnas.get(x);
        if (plataformasEnColumna == null) {
            return new ArrayList<>();
        }
        synchronized (plataformasEnColumna) {
            return plataformasEnColumna;
        }
    }

    public List<Plataforma> obtenerTodasLasPlataformas() {
        List<Plataforma> todasLasPlataformas = new ArrayList<>();
        
        for (Integer columna : new ArrayList<>(columnas.keySet())) {
            List<Plataforma> plataformasEnColumna = columnas.get(columna);
            if (plataformasEnColumna != null) {
                synchronized (plataformasEnColumna) {
                    todasLasPlataformas.addAll(new ArrayList<>(plataformasEnColumna));
                }
            }
        }
        
        return todasLasPlataformas;
    }

    public synchronized void limpiarMapa() {
        columnas.clear();
        inicializarColumnas();
    }

    public int obtenerAnchoMapa() {
        return anchoMapa;
    }
}