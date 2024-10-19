package observers;

import java.util.ArrayList;

import elementos.ElementoDeJuego;
import elementos.entidades.Entidad;
import juego.EntidadLogica;
import juego.Nivel;

public class GestorDeColisiones implements ObserverColisiones {
	
	protected Nivel nivel;
	
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

	public void verificarColisiones(Entidad entidad) {
		int fila = nivel.obtenerFilaElementoDeJuegoEnLaMatriz(entidad);
		int columna = nivel.obtenerColumnaElementoDeJuegoEnLaMatriz(entidad);
		
		if(verificarColisionArriba(fila, columna, entidad)) {
			//
		} else if(verificarColisionAbajo(fila, columna, entidad)) {
			//
		} else if(verificarColisionDerecha(fila, columna, entidad)) {
			//
		} else if(verificarColisionDerecha(fila, columna, entidad)) {
			//
		} else if(verificarColisionIzquierda(fila, columna, entidad)) {
			//
		} else if(verificarColisionDiagonalSuperiorDerecha(fila, columna, entidad)) {
			//
		} else if(verificarColisionDiagonalSuperiorIzquierda(fila, columna, entidad)) {
			//
		} else if(verificarColisionDiagonalInferiorDerecha(fila, columna, entidad)) {
			//
		} else if(verificarColisionDiagonalInferiorIzquierda(fila, columna, entidad)) {
			//
		}
	}
	
	private boolean verificarColisionDiagonalInferiorIzquierda(int fila, int columna, Entidad entidad) {
		boolean huboColision = false;
		ElementoDeJuego elementoDeJuego = null;
		if(fila+1 < this.nivel.obtenerFilasMatriz() && columna-1 >= 0) {
			elementoDeJuego = this.nivel.obtenerElementoDeJuegoEnLaMatriz(fila+1,columna-1);
			if (elementoDeJuego != null) {
				huboColision = entidad.huboColision(elementoDeJuego); 
			}
		}
		if(huboColision) {
			manejarColision(entidad, elementoDeJuego);
		}
		return huboColision;
	}

	private boolean verificarColisionDiagonalInferiorDerecha(int fila, int columna, Entidad entidad) {
		boolean huboColision = false;
		ElementoDeJuego elementoDeJuego = null;
		if(fila+1 < this.nivel.obtenerFilasMatriz() && columna+1 < this.nivel.obtenerColumnasMatriz()) {
			elementoDeJuego = this.nivel.obtenerElementoDeJuegoEnLaMatriz(fila+1,columna+1);
			if (elementoDeJuego != null) {
				huboColision = entidad.huboColision(elementoDeJuego); 
			}
		}
		if(huboColision) {
			manejarColision(entidad, elementoDeJuego);
		}
		return huboColision;
	}

	private boolean verificarColisionDiagonalSuperiorIzquierda(int fila, int columna, Entidad entidad) {
		boolean huboColision = false;
		ElementoDeJuego elementoDeJuego = null;
		if(fila-1 >= 0 && columna-1 >= 0) {
			elementoDeJuego = this.nivel.obtenerElementoDeJuegoEnLaMatriz(fila-1,columna-1);
			if (elementoDeJuego != null) {
				huboColision = entidad.huboColision(elementoDeJuego); 
			}
		}
		if(huboColision) {
			manejarColision(entidad, elementoDeJuego);
		}
		return huboColision;
	}

	private boolean verificarColisionDiagonalSuperiorDerecha(int fila, int columna, Entidad entidad) {
		ElementoDeJuego toReturn = null;
		boolean huboColision = false;
		ElementoDeJuego elementoDeJuego = null;
		if(fila-1 >= 0 && columna+1 < this.nivel.obtenerColumnasMatriz()) {
			elementoDeJuego = this.nivel.obtenerElementoDeJuegoEnLaMatriz(fila-1,columna+1);
			if (elementoDeJuego != null) {
				huboColision = entidad.huboColision(elementoDeJuego); 
			}
		}
		if(huboColision) {
			manejarColision(entidad, elementoDeJuego);
		}
		return huboColision;
	}

	private boolean verificarColisionAbajo(int fila, int columna, Entidad entidad) {
		boolean huboColision = false;
		ElementoDeJuego elementoDeJuego = null;
		if(fila+1 < this.nivel.obtenerFilasMatriz()) {
			elementoDeJuego = this.nivel.obtenerElementoDeJuegoEnLaMatriz(fila+1,columna);
			if (elementoDeJuego != null) {
				huboColision = entidad.huboColision(elementoDeJuego); 
			}
		}
		if(huboColision) {
			manejarColision(entidad, elementoDeJuego);
		}
		return huboColision;
	}

	private boolean verificarColisionIzquierda(int fila, int columna, Entidad entidad) {
		boolean huboColision = false;		
		ElementoDeJuego elementoDeJuego = null;
		if(columna-1 >= 0) {
			elementoDeJuego = this.nivel.obtenerElementoDeJuegoEnLaMatriz(fila,columna-1);
			if (elementoDeJuego != null) {
				huboColision = entidad.huboColision(elementoDeJuego); 
			}
		}
		if(huboColision) {
			manejarColision(entidad, elementoDeJuego);
		}
		return huboColision;
	}

	private boolean verificarColisionDerecha(int fila, int columna, Entidad entidad) {
		boolean huboColision = false;	
		ElementoDeJuego elementoDeJuego = null;
		if(columna+1 < this.nivel.obtenerColumnasMatriz()) {
			elementoDeJuego = this.nivel.obtenerElementoDeJuegoEnLaMatriz(fila,columna+1);
			if (elementoDeJuego != null) {
				huboColision = entidad.huboColision(elementoDeJuego); 
			}
		}
		if(huboColision) {
			manejarColision(entidad, elementoDeJuego);
		}
		return huboColision;
	}

	private boolean verificarColisionArriba(int fila, int columna, Entidad entidad) {
		boolean huboColision = false;
		ElementoDeJuego elementoDeJuego = null;
		if(fila-1 >= 0) {
			elementoDeJuego = this.nivel.obtenerElementoDeJuegoEnLaMatriz(fila-1,columna);
			if (elementoDeJuego != null) {
				huboColision = entidad.huboColision(elementoDeJuego); 
			}
		}
		if(huboColision) {
			manejarColision(entidad, elementoDeJuego);
		}
		return huboColision;
	}
	
	private void manejarColision(Entidad entidad, ElementoDeJuego elementoDeJuego) {
		entidad.aceptarVisitante(elementoDeJuego.getVisitor());
		elementoDeJuego.aceptarVisitante(entidad.getVisitor());
	}

	
	public void actualizar() {
		//TODO llamar a actualizadorGraficoJugador?
	}

}
