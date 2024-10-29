package launcher;

import juego.BucleJuego;
import juego.Juego;
import sonido.sonidoModoOriginal.ReproductorDeMusicaFondo;
import ventanas.ControladorVistas;

public class Launcher {
	
	private static BucleJuego bucleJuego;
	
    public static void main(String[] args) {
    	Juego juego = new Juego();
        juego.establecerControladorVistas(new ControladorVistas(juego));
        bucleJuego = new BucleJuego(juego);
        juego.setBucleJuego(bucleJuego);
        ReproductorDeMusicaFondo reproductorDeMusicaFondo = new ReproductorDeMusicaFondo();
        // reproductorDeMusicaFondo.playMusic("src/sonido/sonidoModoOriginal/musicaModoOriginal.wav");
        // Aquí puedes iniciar la partida o realizar otras configuraciones
    }
    
}

