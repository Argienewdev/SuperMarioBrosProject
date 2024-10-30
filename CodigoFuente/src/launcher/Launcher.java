package launcher;


import juego.Juego;
import sonido.sonidoModoOriginal.ReproductorDeMusicaFondo;
import ventanas.ControladorVistas;

public class Launcher {
	
    public static void main(String[] args) {
    	Juego juego = new Juego();
        juego.establecerControladorVistas(new ControladorVistas(juego));
        ReproductorDeMusicaFondo reproductorDeMusicaFondo = new ReproductorDeMusicaFondo();
 //       reproductorDeMusicaFondo.playMusic("src/sonido/sonidoModoOriginal/musicaModoOriginal.wav");   
    }
    
}