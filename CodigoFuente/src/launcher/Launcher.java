package launcher;

import juego.BucleJuego;
import juego.Juego;
import sonido.ReproductorDeMusicaFondo;
import ventanas.ControladorVistas;

public class Launcher {
    public static void main(String[] args) {
    	 Juego juego = new Juego();
         juego.establecerControladorVistas(new ControladorVistas(juego));
         new BucleJuego(juego);
        ReproductorDeMusicaFondo reproductorDeMusicaFondo = new ReproductorDeMusicaFondo();
        reproductorDeMusicaFondo.playMusic("src/sonido/musica_juego.wav");
        // Aquí puedes iniciar la partida o realizar otras configuraciones
    }
}
