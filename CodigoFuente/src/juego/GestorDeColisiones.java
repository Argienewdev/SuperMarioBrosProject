package juego;

import java.util.ArrayList;

import elementos.ElementoDeJuego;
import elementos.entidades.Entidad;

public class GestorDeColisiones {
	
	protected Nivel nivel;

	public boolean verificarColisiones(Entidad entidad) {
		int fila = nivel.obtenerFilaElementoDeJuegoEnLaMatriz(entidad);
		int columna = nivel.obtenerColumnaElementoDeJuegoEnLaMatriz(entidad);
		return huboColisiones(fila, columna, entidad);
	}
	
	private boolean huboColisiones(int fila, int columna, Entidad entidad) {
		return verificarColisionArriba(fila, columna, entidad) ||
			   verificarColisionAbajo(fila, columna, entidad) ||
			   verificarColisionDerecha(fila, columna, entidad) ||
			   verificarColisionIzquierda(fila, columna, entidad) ||
			   verificarColisionDiagonalSuperiorDerecha(fila, columna, entidad) ||
			   verificarColisionDiagonalSuperiorIzquierda(fila, columna, entidad) ||
			   verificarColisionDiagonalInferiorDerecha(fila, columna, entidad) ||
			   verificarColisionDiagonalInferiorIzquierda(fila, columna, entidad);
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
	
	private void manejarColision(Entidad entidad, ElementoDeJuego elementoDeJuego) {
		entidad.aceptarVisitante(elementoDeJuego.getVisitor());
		elementoDeJuego.aceptarVisitante(entidad.getVisitor());
	}

}
