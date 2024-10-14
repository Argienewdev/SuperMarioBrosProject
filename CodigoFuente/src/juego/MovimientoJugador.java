package juego;

import ventanas.PantallaDeJuego;

/**
 * POR EL MOMENTO ESTA CLASE CONTROLA TANTO LA PARTE LOGICA COMO
 * LA PARTE GRAFICA DEL MOVIMIENTO, LO CUAL NO DEBERIA PASAR.
 */

public class MovimientoJugador {
	
	private static final int POSICION_X_INICIAL_MARIO = 50;
	
	private static final int POSICION_Y_INICIAL_MARIO = 400;

	private static final int VELOCIDAD_MOVIMIENTO_HORIZONTAL_PISO = 20;

	private static final int VELOCIDAD_MOVIMIENTO_HORIZONTAL_AIRE = 20;
	
	private static final int FUERZA_SALTO = -30;
	
	private static final int GRAVEDAD = 3;
	
	private boolean saltando;
	
	private int velHorizontal;
	
	private int velVertical;
	
	private int posX;
	
	private int posY;
	
	private int contadorDeTicks;
	
	private PantallaDeJuego pantallaDeJuego;
	
	public MovimientoJugador(PantallaDeJuego pantallaDeJuego){
		this.pantallaDeJuego = pantallaDeJuego; 
		this.velHorizontal = 0;
		this.velVertical = 0;
		this.saltando = false;
		this.posX = POSICION_X_INICIAL_MARIO;
		this.posY = POSICION_Y_INICIAL_MARIO;
	}
	
	public void moveMario() {
		contadorDeTicks++;
		//Sirve de algo? no quiero que los ticks se vayan al carajo cuando jugas por mucho tiempo
		if(contadorDeTicks == 1000) {
			contadorDeTicks = 0;
		}
		
		//Habilita movimiento en el aire (no considera caida, solo salto)
		if(saltando && pantallaDeJuego.teclaAPresionada() && !pantallaDeJuego.choqueBordeIzquierdo()) {
			moveMarioIzquierdaSaltando();
		}else if(saltando && pantallaDeJuego.teclaDPresionada() && !pantallaDeJuego.choqueBordeDerecho()) {
			moveMarioDerechaSaltando();
		}
		
		//Habilita el movimiento y se encarga de actualizar sprites
		if(pantallaDeJuego.teclaWPresionada() && !saltando) {
			moveMarioSalto();
		}else if(pantallaDeJuego.teclaDPresionada() && !saltando && !pantallaDeJuego.teclaAPresionada() && !pantallaDeJuego.choqueBordeDerecho()) {
			moveMarioDerecha();
		}	
		else if(pantallaDeJuego.teclaAPresionada() && !saltando && !pantallaDeJuego.teclaDPresionada() && !pantallaDeJuego.choqueBordeIzquierdo()) {
			moveMarioIzquierda();
		}else if(!saltando){
			//Cuando mario se deja de mover, se chequea en que posicion estaba y se le asigna el sprite correspondiente
			if(pantallaDeJuego.marioHaciaAdelante()) {
				pantallaDeJuego.cambiarSpriteMarioQuieto1();
			}else if(pantallaDeJuego.marioHaciaAtras()) {
				pantallaDeJuego.cambiarSpriteMarioQuieto2();
			}
		}
		
		if(velVertical < 40)
			velVertical += GRAVEDAD;
		if(posY < 400 && saltando) {
			posY += velVertical;
		}else if(saltando){ //Mario llego al piso
			saltando = false;
			velHorizontal = 0;
			if(pantallaDeJuego.marioHaciaAdelante()) {
				pantallaDeJuego.cambiarSpriteMarioQuieto1();
			}else if(pantallaDeJuego.marioHaciaAtras()) {
				pantallaDeJuego.cambiarSpriteMarioQuieto2();
			}
		}
		pantallaDeJuego.actualizarPosicionMario(posX, posY);
	}
	
	public void moveMarioDerecha() {
		velHorizontal = VELOCIDAD_MOVIMIENTO_HORIZONTAL_PISO;
		actualizarPosX(velHorizontal);
		if(contadorDeTicks % 10 == 0) {
			pantallaDeJuego.cambiarSpriteMarioCaminando1();
		}else if(contadorDeTicks % 5 == 0){					
			pantallaDeJuego.cambiarSpriteMarioCaminando2();
		}
	}
	
	public void moveMarioIzquierda() {
		velHorizontal = -VELOCIDAD_MOVIMIENTO_HORIZONTAL_PISO;
		actualizarPosX(velHorizontal);
		if(contadorDeTicks % 10 == 0) {
			pantallaDeJuego.cambiarSpriteMarioVolviendo1();;
		}else if(contadorDeTicks % 5 == 0){
			pantallaDeJuego.cambiarSpriteMarioVolviendo2();;
		}
	}
	
	public void moveMarioIzquierdaSaltando() {
		velHorizontal = -VELOCIDAD_MOVIMIENTO_HORIZONTAL_AIRE;
		actualizarPosX(velHorizontal);
		pantallaDeJuego.cambiarSpriteMarioSaltando2();
	}
	
	public void moveMarioDerechaSaltando() {
		velHorizontal = VELOCIDAD_MOVIMIENTO_HORIZONTAL_AIRE;
		actualizarPosX(velHorizontal);
		pantallaDeJuego.cambiarSpriteMarioSaltando();
	}
		
	public void moveMarioSalto() {
		velVertical = FUERZA_SALTO;
		actualizarPosY(velVertical);
		saltando = true;
		if(pantallaDeJuego.teclaDPresionada() || pantallaDeJuego.marioHaciaAdelante()) {
			pantallaDeJuego.cambiarSpriteMarioSaltando();
		}else if(pantallaDeJuego.teclaAPresionada() || pantallaDeJuego.marioHaciaAtras()) {
			pantallaDeJuego.cambiarSpriteMarioSaltando2();
		}
	}

	public void actualizarPosX(int modificacion) {
		posX += modificacion;
	}
	
	public void actualizarPosY(int modificacion) {
		posY += modificacion;
	}
	
	public int obtenerPosicionInicialX() {
		return POSICION_X_INICIAL_MARIO;
	}
	
	public int obtenerPosicionInicialY() {
		return POSICION_Y_INICIAL_MARIO;
	}
	
	public int obtenerPosX() {
		return posX;
	}
	
	public int obtenerPosY() {
		return posY;
	}
}
