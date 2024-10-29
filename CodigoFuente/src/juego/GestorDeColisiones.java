package juego;

import elementos.ElementoDeJuego;
import elementos.entidades.Entidad;
import ventanas.ControladorVistas;

public class GestorDeColisiones {
	/*
	protected Nivel nivel;
	
	public GestorDeColisiones(Nivel nivel) {
		this.nivel = nivel;
	}

//	public boolean verificarColisiones(Entidad entidad) {
//		return huboColisiones(entidad);
//	}
	
//	private boolean huboColisiones(Entidad entidad) {
//		return verificarColisionArriba(entidad) ||
//			   verificarColisionAbajo(entidad) ||
//			   verificarColisionDerecha(entidad) ||
//			   verificarColisionIzquierda(entidad) ||
//			   verificarColisionDiagonalSuperiorDerecha(entidad) ||
//			   verificarColisionDiagonalSuperiorIzquierda(entidad) ||
//			   verificarColisionDiagonalInferiorDerecha(entidad) ||
//			   verificarColisionDiagonalInferiorIzquierda(entidad);
//	}
	public boolean verificarColisionArriba(Entidad entidad, int posX, int posY) {
		boolean huboColision = false;
		ElementoDeJuego elementoDeJuego = null;
		if(fila-1 >= 0) {
			elementoDeJuego = this.nivel.obtenerElementoDeJuegoEnLaMatriz(fila-1,columna);
			if (elementoDeJuego != null) {
				//huboColision = entidad.huboColision(elementoDeJuego);
				huboColision = elementoDeJuego.getPosicion().y + 50 == entidad.getPosicion().y;
			}
		}
		if(huboColision) {
			manejarColision(entidad, elementoDeJuego);
		}
		return huboColision;
	}
	
	public boolean verificarColisionAbajo(Entidad entidad, int posX, int posY) {
		int fila = nivel.obtenerFilaElementoDeJuegoEnLaMatriz(entidad);
		int columna = nivel.obtenerColumnaElementoDeJuegoEnLaMatriz(entidad);
		boolean huboColision = false;
		ElementoDeJuego elementoDeJuego = null;
		if(fila + 1 < this.nivel.obtenerFilasMatriz()) {
			elementoDeJuego = this.nivel.obtenerElementoDeJuegoEnLaMatriz(fila + 1,columna);
			if (elementoDeJuego != null) {
				//huboColision = entidad.huboColision(elementoDeJuego);
				huboColision = elementoDeJuego.getPosicion().y == entidad.getPosicion().y + 50;
			}
		}
		if(huboColision) {
			manejarColision(entidad, elementoDeJuego);
		}
		return huboColision;
	}
	
	public boolean verificarColisionDerecha(Entidad entidad, int posX, int posY) {
		int fila = Math.floorDiv(posY, 50);
		int columna = Math.floorDiv(posX, 50);
		boolean huboColision = false;
		ElementoDeJuego elementoDeJuego = null;
		if(columna + 1 < this.nivel.obtenerColumnasMatriz()) {
			elementoDeJuego = this.nivel.obtenerElementoDeJuegoEnLaMatriz(fila,columna + 1);
			if (elementoDeJuego != null) {
				//huboColision = entidad.huboColision(elementoDeJuego);
				huboColision = entidad.obtenerHitbox().intersects(elementoDeJuego.obtenerHitbox());
				//huboColision = elementoDeJuego.getPosicion().x < posX + 50;
			}
		}
		if(huboColision) {
			manejarColision(entidad, elementoDeJuego);
		}
		return huboColision;
	}
	
	public boolean verificarColisionIzquierda(Entidad entidad, int posX, int posY) {
		int fila = Math.floorDiv(entidad.getPosicion().y, 50);
		int columna = Math.floorDiv(entidad.getPosicion().x, 50);
		boolean huboColision = false;
		ElementoDeJuego elementoDeJuego = null;
		if(columna-1 >= 0) {
			elementoDeJuego = this.nivel.obtenerElementoDeJuegoEnLaMatriz(fila,columna-1);
			if (elementoDeJuego != null) {
				//huboColision = entidad.huboColision(elementoDeJuego);
				//huboColision = posX < (elementoDeJuego.getPosicion().x + 50);
				huboColision = entidad.obtenerHitbox().intersects(elementoDeJuego.obtenerHitbox());
			}
		}
		if(huboColision) {
			manejarColision(entidad, elementoDeJuego);
		}
		return huboColision;
	}
	
	public boolean verificarColisionDiagonalInferiorDerecha(Entidad entidad, int posX, int posY) {
		int fila = posY / 50;
		int columna = nivel.obtenerColumnaElementoDeJuegoEnLaMatriz(entidad);
		boolean huboColision = false;
		ElementoDeJuego elementoDeJuego = null;
		if(fila-1 >= 0 && columna+1 < this.nivel.obtenerColumnasMatriz()) {
			elementoDeJuego = this.nivel.obtenerElementoDeJuegoEnLaMatriz(fila - 1,columna + 1);
			if (elementoDeJuego != null) {
				//huboColision = entidad.huboColision(elementoDeJuego);
				//huboColision = (elementoDeJuego.getPosicion().x < entidad.getPosicion().x + 50) || (elementoDeJuego.getPosicion().y >= posY + 50);
				huboColision = entidad.obtenerHitbox().intersects(elementoDeJuego.obtenerHitbox());
			}
		}
		if(huboColision) {
			manejarColision(entidad, elementoDeJuego);
		}
		return huboColision;
	}
	
	public boolean verificarColisionDiagonalSuperiorIzquierda(Entidad entidad, int posX, int posY) {
		int fila = nivel.obtenerFilaElementoDeJuegoEnLaMatriz(entidad);
		int columna = nivel.obtenerColumnaElementoDeJuegoEnLaMatriz(entidad);
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
	
	public boolean verificarColisionDiagonalSuperiorDerecha(Entidad entidad, int posX, int posY) {
		int fila = nivel.obtenerFilaElementoDeJuegoEnLaMatriz(entidad);
		int columna = nivel.obtenerColumnaElementoDeJuegoEnLaMatriz(entidad);
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
	
	public boolean verificarColisionDiagonalInferiorIzquierda(Entidad entidad, int posX, int posY) {
		int fila = nivel.obtenerFilaElementoDeJuegoEnLaMatriz(entidad);
		int columna = nivel.obtenerColumnaElementoDeJuegoEnLaMatriz(entidad);
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
		//entidad.aceptarVisitante(elementoDeJuego.getVisitor());
		//elementoDeJuego.aceptarVisitante(entidad.getVisitor());
		//TODO los visitantes rompen todo
	}*/
}
