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

	/*public void verificarColisiones(Entidad entidad) {
		int fila = nivel.obtenerFilaElementoDeJuegoEnLaMatriz(entidad);
		int columna = nivel.obtenerColumnaElementoDeJuegoEnLaMatriz(entidad);
		
		if(verificarColisionArriba(fila, columna, entidad)) {
			entidad.getVisitor().
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
	}*/
	
	public boolean verificarColisionDiagonalInferiorIzquierda(int fila, int columna, Entidad entidad) {
		boolean resultado = false;
		ElementoDeJuego elementoDeJuego = null;
		if(fila+1 < this.nivel.obtenerFilasMatriz() && columna-1 >= 0) {
			elementoDeJuego = this.nivel.obtenerElementoDeJuegoEnLaMatriz(fila+1,columna-1);
			if (elementoDeJuego != null) {
				resultado = entidad.huboColision(elementoDeJuego); 
			}
		}
		return resultado;
	}

	public boolean verificarColisionDiagonalInferiorDerecha(int fila, int columna, Entidad entidad) {
		boolean resultado = false;
		ElementoDeJuego elementoDeJuego = null;
		if(fila+1 < this.nivel.obtenerFilasMatriz() && columna+1 < this.nivel.obtenerColumnasMatriz()) {
			elementoDeJuego = this.nivel.obtenerElementoDeJuegoEnLaMatriz(fila+1,columna+1);
			if (elementoDeJuego != null) {
				resultado = entidad.huboColision(elementoDeJuego); 
			}
		}
		return resultado;
	}

	public boolean verificarColisionDiagonalSuperiorIzquierda(int fila, int columna, Entidad entidad) {
		boolean resultado = false;
		ElementoDeJuego elementoDeJuego = null;
		if(fila-1 >= 0 && columna-1 >= 0) {
			elementoDeJuego = this.nivel.obtenerElementoDeJuegoEnLaMatriz(fila-1,columna-1);
			if (elementoDeJuego != null) {
				resultado = entidad.huboColision(elementoDeJuego); 
			}
		}
		return resultado;
	}

	public boolean verificarColisionDiagonalSuperiorDerecha(int fila, int columna, Entidad entidad) {
		boolean resultado = false;
		ElementoDeJuego elementoDeJuego = null;
		if(fila-1 >= 0 && columna+1 < this.nivel.obtenerColumnasMatriz()) {
			elementoDeJuego = this.nivel.obtenerElementoDeJuegoEnLaMatriz(fila-1,columna+1);
			if (elementoDeJuego != null) {
				resultado = entidad.huboColision(elementoDeJuego); 
			}
		}
		return resultado;
	}

	public boolean verificarColisionAbajo(int fila, int columna, Entidad entidad) {
		boolean resultado = false;
		ElementoDeJuego elementoDeJuego = null;
		if(fila+1 < this.nivel.obtenerFilasMatriz()) {
			elementoDeJuego = this.nivel.obtenerElementoDeJuegoEnLaMatriz(fila+1,columna);
			if (elementoDeJuego != null) {
				resultado = entidad.huboColision(elementoDeJuego); 
			}
		}
		return resultado;
	}

	public boolean verificarColisionIzquierda(int fila, int columna, Entidad entidad) {
		boolean resultado = false;
		ElementoDeJuego elementoDeJuego = null;
		if(columna-1 >= 0) {
			elementoDeJuego = this.nivel.obtenerElementoDeJuegoEnLaMatriz(fila,columna-1);
			if (elementoDeJuego != null) {
				resultado = entidad.huboColision(elementoDeJuego); 
			}
		}
		return resultado;
	}

	public boolean verificarColisionDerecha(int fila, int columna, Entidad entidad) {
		boolean resultado = false;
		ElementoDeJuego elementoDeJuego = null;
		if(columna+1 < this.nivel.obtenerColumnasMatriz()) {
			elementoDeJuego = this.nivel.obtenerElementoDeJuegoEnLaMatriz(fila,columna+1);
			if (elementoDeJuego != null) {
				resultado = entidad.huboColision(elementoDeJuego); 
			}
		}
		return resultado;
	}

	public boolean verificarColisionArriba(int fila, int columna, Entidad entidad) {
		boolean resultado = false;
		ElementoDeJuego elementoDeJuego = null;
		if(fila-1 >= 0) {
			elementoDeJuego = this.nivel.obtenerElementoDeJuegoEnLaMatriz(fila-1,columna);
			if (elementoDeJuego != null) {
				resultado = entidad.huboColision(elementoDeJuego); 
			}
		}
		entidad.getVisitor();
		return resultado;
	}

	
	public void actualizar() {
		//TODO llamar a actualizadorGraficoJugador?
	}

}
