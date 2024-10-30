package launcher;


import juego.Juego;
import sonido.sonidoModoOriginal.ReproductorDeMusicaFondo;
import ventanas.ControladorVistas;

public class Launcher {
	

	
    public static void main(String[] args) {
    	Juego juego = new Juego();
        juego.establecerControladorVistas(new ControladorVistas(juego));
        ReproductorDeMusicaFondo reproductorDeMusicaFondo = new ReproductorDeMusicaFondo();
<<<<<<< HEAD
//        reproductorDeMusicaFondo.playMusic("src/sonido/sonidoModoOriginal/musicaModoOriginal.wav");   
=======
        reproductorDeMusicaFondo.playMusic("src/sonido/sonidoModoOriginal/musicaModoOriginal.wav");   
>>>>>>> 9fd2a8e49ec904bb24ff29f86b7c85a300785565
    }
    
}