package sonido.sonidoModoOriginal;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class ReproductorDeMusicaFondo {
	
	private Clip clip;

    public void playMusic(String filepath) {
        try {
            // Abrir el archivo de audio
            File audioFile = new File(filepath);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);

            // Obtener el clip de audio
            clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start(); // Iniciar la reproducción
            
            // Loop infinito (opcional si quieres que la música se repita)
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    public void stopMusic() {
        if (clip != null && clip.isRunning()) {
            clip.stop(); // Detener la reproducción
        }
    }
}
