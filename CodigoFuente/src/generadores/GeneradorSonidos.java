package generadores;


import fabricas.FabricaSonidos;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import elementos.Sonido;

import java.io.File;
import java.io.IOException;


public class GeneradorSonidos {
	
	FabricaSonidos fabrica;

	public GeneradorSonidos(FabricaSonidos fabrica){
		this.fabrica= fabrica;
	}
	
	public void emitirSonidoAplastarEnemigo(){
		  try {
			    Sonido sonido= fabrica.obtenerAplastarEnemigo();
	            
	            File archivoSonido = new File(sonido.obtenerRutaSonido());
	            
	            AudioInputStream audioStream = AudioSystem.getAudioInputStream(archivoSonido);
	            
	            Clip clip = AudioSystem.getClip();
	            
	            clip.open(audioStream);
	            
	            clip.start();
	            
	            clip.addLineListener(event -> {
	                if (event.getType() == LineEvent.Type.STOP) {
	                    clip.close();
	                }
	            });
	        } catch (UnsupportedAudioFileException e) {
	            System.err.println("El formato de archivo de audio no es compatible: " + e.getMessage());
	        } catch (IOException e) {
	            System.err.println("Error al leer el archivo de audio: " + e.getMessage());
	        } catch (LineUnavailableException e) {
	            System.err.println("Línea de audio no disponible: " + e.getMessage());
	        }
		
	}
	
	public void choqueFireball(){
		 try {
			    Sonido sonido= fabrica.obtenerChoqueFireball();
	            
	            File archivoSonido = new File(sonido.obtenerRutaSonido());
	            
	            AudioInputStream audioStream = AudioSystem.getAudioInputStream(archivoSonido);
	            
	            Clip clip = AudioSystem.getClip();
	            
	            clip.open(audioStream);
	            
	            clip.start();
	            
	            clip.addLineListener(event -> {
	                if (event.getType() == LineEvent.Type.STOP) {
	                    clip.close();
	                }
	            });
	        } catch (UnsupportedAudioFileException e) {
	            System.err.println("El formato de archivo de audio no es compatible: " + e.getMessage());
	        } catch (IOException e) {
	            System.err.println("Error al leer el archivo de audio: " + e.getMessage());
	        } catch (LineUnavailableException e) {
	            System.err.println("Línea de audio no disponible: " + e.getMessage());
	        }
	}
	
	public void disparoBolaFuego(){
		 try {
			    Sonido sonido= fabrica.obtenerDisparoBolaFuego();
	            
	            File archivoSonido = new File(sonido.obtenerRutaSonido());
	            
	            AudioInputStream audioStream = AudioSystem.getAudioInputStream(archivoSonido);
	            
	            Clip clip = AudioSystem.getClip();
	            
	            clip.open(audioStream);
	            
	            clip.start();
	            
	            clip.addLineListener(event -> {
	                if (event.getType() == LineEvent.Type.STOP) {
	                    clip.close();
	                }
	            });
	        } catch (UnsupportedAudioFileException e) {
	            System.err.println("El formato de archivo de audio no es compatible: " + e.getMessage());
	        } catch (IOException e) {
	            System.err.println("Error al leer el archivo de audio: " + e.getMessage());
	        } catch (LineUnavailableException e) {
	            System.err.println("Línea de audio no disponible: " + e.getMessage());
	        }
	}
	
	public void golpeBloque(){
		try {
		    Sonido sonido= fabrica.obtenerGolpeBloque();
            
            File archivoSonido = new File(sonido.obtenerRutaSonido());
            
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(archivoSonido);
            
            Clip clip = AudioSystem.getClip();
            
            clip.open(audioStream);
            
            clip.start();
            
            clip.addLineListener(event -> {
                if (event.getType() == LineEvent.Type.STOP) {
                    clip.close();
                }
            });
        } catch (UnsupportedAudioFileException e) {
            System.err.println("El formato de archivo de audio no es compatible: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error al leer el archivo de audio: " + e.getMessage());
        } catch (LineUnavailableException e) {
            System.err.println("Línea de audio no disponible: " + e.getMessage());
        }
	}
	
	public void modoInvencible(){
		try {
		    Sonido sonido= 	fabrica.obtenerModoInvencible();;
            
            File archivoSonido = new File(sonido.obtenerRutaSonido());
            
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(archivoSonido);
            
            Clip clip = AudioSystem.getClip();
            
            clip.open(audioStream);
            
            clip.start();
            
            clip.addLineListener(event -> {
                if (event.getType() == LineEvent.Type.STOP) {
                    clip.close();
                }
            });
        } catch (UnsupportedAudioFileException e) {
            System.err.println("El formato de archivo de audio no es compatible: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error al leer el archivo de audio: " + e.getMessage());
        } catch (LineUnavailableException e) {
            System.err.println("Línea de audio no disponible: " + e.getMessage());
        }
	}
	
	public void moneda(){
		try {
		    Sonido sonido= fabrica.obtenerSonidoMoneda();
            
            File archivoSonido = new File(sonido.obtenerRutaSonido());
            
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(archivoSonido);
            
            Clip clip = AudioSystem.getClip();
            
            clip.open(audioStream);
            
            clip.start();
            
            clip.addLineListener(event -> {
                if (event.getType() == LineEvent.Type.STOP) {
                    clip.close();
                }
            });
        } catch (UnsupportedAudioFileException e) {
            System.err.println("El formato de archivo de audio no es compatible: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error al leer el archivo de audio: " + e.getMessage());
        } catch (LineUnavailableException e) {
            System.err.println("Línea de audio no disponible: " + e.getMessage());
        }
	}
	
	public void musicaModoOriginal(){
		
	}
	
	public void pierdeJuego(){
		try {
		    Sonido sonido= fabrica.obtenerPierdeJuego();
            
            File archivoSonido = new File(sonido.obtenerRutaSonido());
            
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(archivoSonido);
            
            Clip clip = AudioSystem.getClip();
            
            clip.open(audioStream);
            
            clip.start();
            
            clip.addLineListener(event -> {
                if (event.getType() == LineEvent.Type.STOP) {
                    clip.close();
                }
            });
        } catch (UnsupportedAudioFileException e) {
            System.err.println("El formato de archivo de audio no es compatible: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error al leer el archivo de audio: " + e.getMessage());
        } catch (LineUnavailableException e) {
            System.err.println("Línea de audio no disponible: " + e.getMessage());
        }
	}
	
	public void pierdeVida(){
		try {
		    Sonido sonido= fabrica.obtenerPierdeVida();
            
            File archivoSonido = new File(sonido.obtenerRutaSonido());
            
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(archivoSonido);
            
            Clip clip = AudioSystem.getClip();
            
            clip.open(audioStream);
            
            clip.start();
            
            clip.addLineListener(event -> {
                if (event.getType() == LineEvent.Type.STOP) {
                    clip.close();
                }
            });
        } catch (UnsupportedAudioFileException e) {
            System.err.println("El formato de archivo de audio no es compatible: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error al leer el archivo de audio: " + e.getMessage());
        } catch (LineUnavailableException e) {
            System.err.println("Línea de audio no disponible: " + e.getMessage());
        }
	}
	
	public void PowerupAgarrado(){
		try {
		    Sonido sonido= fabrica.obtenerPowerUpAgarrado();
            
            File archivoSonido = new File(sonido.obtenerRutaSonido());
            
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(archivoSonido);
            
            Clip clip = AudioSystem.getClip();
            
            clip.open(audioStream);
            
            clip.start();
            
            clip.addLineListener(event -> {
                if (event.getType() == LineEvent.Type.STOP) {
                    clip.close();
                }
            });
        } catch (UnsupportedAudioFileException e) {
            System.err.println("El formato de archivo de audio no es compatible: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error al leer el archivo de audio: " + e.getMessage());
        } catch (LineUnavailableException e) {
            System.err.println("Línea de audio no disponible: " + e.getMessage());
        }
	}
	
	public void powerUpEmerge(){
		try {
		    Sonido sonido= fabrica.obtenerPowerUpEmerge();
            
            File archivoSonido = new File(sonido.obtenerRutaSonido());
            
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(archivoSonido);
            
            Clip clip = AudioSystem.getClip();
            
            clip.open(audioStream);
            
            clip.start();
            
            clip.addLineListener(event -> {
                if (event.getType() == LineEvent.Type.STOP) {
                    clip.close();
                }
            });
        } catch (UnsupportedAudioFileException e) {
            System.err.println("El formato de archivo de audio no es compatible: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error al leer el archivo de audio: " + e.getMessage());
        } catch (LineUnavailableException e) {
            System.err.println("Línea de audio no disponible: " + e.getMessage());
        }
	}
	
	public void recuperaVida(){
		try {
		    Sonido sonido= 	fabrica.obtenerRecuperarVida();
            
            File archivoSonido = new File(sonido.obtenerRutaSonido());
            
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(archivoSonido);
            
            Clip clip = AudioSystem.getClip();
            
            clip.open(audioStream);
            
            clip.start();
            
            clip.addLineListener(event -> {
                if (event.getType() == LineEvent.Type.STOP) {
                    clip.close();
                }
            });
        } catch (UnsupportedAudioFileException e) {
            System.err.println("El formato de archivo de audio no es compatible: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error al leer el archivo de audio: " + e.getMessage());
        } catch (LineUnavailableException e) {
            System.err.println("Línea de audio no disponible: " + e.getMessage());
        }
	}
	
	public void romperLadrillo(){
		try {
		    Sonido sonido= 	fabrica.obtenerRomperLadrillo();
            
            File archivoSonido = new File(sonido.obtenerRutaSonido());
            
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(archivoSonido);
            
            Clip clip = AudioSystem.getClip();
            
            clip.open(audioStream);
            
            clip.start();
            
            clip.addLineListener(event -> {
                if (event.getType() == LineEvent.Type.STOP) {
                    clip.close();
                }
            });
        } catch (UnsupportedAudioFileException e) {
            System.err.println("El formato de archivo de audio no es compatible: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error al leer el archivo de audio: " + e.getMessage());
        } catch (LineUnavailableException e) {
            System.err.println("Línea de audio no disponible: " + e.getMessage());
        }
	}
	
	public void salto(){
		try {
		    Sonido sonido= 	fabrica.obtenerSalto();
            
            File archivoSonido = new File(sonido.obtenerRutaSonido());
            
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(archivoSonido);
            
            Clip clip = AudioSystem.getClip();
            
            clip.open(audioStream);
            
            clip.start();
            
            clip.addLineListener(event -> {
                if (event.getType() == LineEvent.Type.STOP) {
                    clip.close();
                }
            });
        } catch (UnsupportedAudioFileException e) {
            System.err.println("El formato de archivo de audio no es compatible: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error al leer el archivo de audio: " + e.getMessage());
        } catch (LineUnavailableException e) {
            System.err.println("Línea de audio no disponible: " + e.getMessage());
        }
	}
	
	public void tocarBanderaFinNivel(){
		try {
		    Sonido sonido= 	fabrica.obtenerTocarBanderaFinNivel();
            
            File archivoSonido = new File(sonido.obtenerRutaSonido());
            
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(archivoSonido);
            
            Clip clip = AudioSystem.getClip();
            
            clip.open(audioStream);
            
            clip.start();
            
            clip.addLineListener(event -> {
                if (event.getType() == LineEvent.Type.STOP) {
                    clip.close();
                }
            });
        } catch (UnsupportedAudioFileException e) {
            System.err.println("El formato de archivo de audio no es compatible: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error al leer el archivo de audio: " + e.getMessage());
        } catch (LineUnavailableException e) {
            System.err.println("Línea de audio no disponible: " + e.getMessage());
        }
	}
}
