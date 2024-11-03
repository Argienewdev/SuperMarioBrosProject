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
	
	FabricaSonidos fabricaSonidos;
	File archivoCancion;
	Clip clipCancion;
	
	public GeneradorSonidos(FabricaSonidos fabricaSonidos){
		this.fabricaSonidos = fabricaSonidos;
		establecerArchivo();
	}

	protected void establecerArchivo(){
		archivoCancion = new File(fabricaSonidos.obtenerMusica().obtenerRutaSonido());
		System.out.println(fabricaSonidos.obtenerMusica().obtenerRutaSonido());
		establecerMusicaFondo();
	}
	
	public void emitirSonidoAplastarEnemigo(){
		  try {
			    Sonido sonido = fabricaSonidos.obtenerAplastarEnemigo();
	            
	            File archivoSonido = new File(sonido.obtenerRutaSonido());
	            
	            AudioInputStream audioStream = AudioSystem.getAudioInputStream(archivoSonido);
	            
	            Clip clip = AudioSystem.getClip();
	            
	            clip.open(audioStream);
	            
	            clip.start();
	            
	            clip.addLineListener(event -> {
	                if (event.getType() ==  LineEvent.Type.STOP) {
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
	
	public void emitirSonidoAplastarEnemigo2(){
		try {
			Sonido sonido = fabricaSonidos.obtenerAplastarEnemigo2();
			
			File archivoSonido = new File(sonido.obtenerRutaSonido());
			
			AudioInputStream audioStream = AudioSystem.getAudioInputStream(archivoSonido);
			
			Clip clip = AudioSystem.getClip();
			
			clip.open(audioStream);
			
			clip.start();
			
			clip.addLineListener(event -> {
				if (event.getType() ==  LineEvent.Type.STOP) {
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
	
	public void emitirSonidoAplastarEnemigo3(){
		try {
			Sonido sonido = fabricaSonidos.obtenerAplastarEnemigo3();
			
			File archivoSonido = new File(sonido.obtenerRutaSonido());
			
			AudioInputStream audioStream = AudioSystem.getAudioInputStream(archivoSonido);
			
			Clip clip = AudioSystem.getClip();
			
			clip.open(audioStream);
			
			clip.start();
			
			clip.addLineListener(event -> {
				if (event.getType() ==  LineEvent.Type.STOP) {
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
	
	public void establecerMusicaFondo(){
		try {
			AudioInputStream audioStream = AudioSystem.getAudioInputStream(archivoCancion);
			clipCancion = AudioSystem.getClip();
			clipCancion.open(audioStream);
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
			e.printStackTrace();
		}
        
	}
	
	public void reproducirMusicaFondo(){
		clipCancion.start();
		clipCancion.loop(Clip.LOOP_CONTINUOUSLY);
	}
	
	public void detenerMusicaFondo(){
		clipCancion.stop();
	}
	
	public void choqueFireball(){
		 try {
			    Sonido sonido= fabricaSonidos.obtenerChoqueFireball();
	            
	            File archivoSonido = new File(sonido.obtenerRutaSonido());
	            
	            AudioInputStream audioStream = AudioSystem.getAudioInputStream(archivoSonido);
	            
	            Clip clip = AudioSystem.getClip();
	            
	            clip.open(audioStream);
	            
	            clip.start();
	            
	            clip.addLineListener(event -> {
	                if (event.getType() ==  LineEvent.Type.STOP) {
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
	
	public void matarBolaDeFuego(){
		try {
			Sonido sonido= fabricaSonidos.obtenerMatarBolaDeFuego();
			
			File archivoSonido = new File(sonido.obtenerRutaSonido());
			
			AudioInputStream audioStream = AudioSystem.getAudioInputStream(archivoSonido);
			
			Clip clip = AudioSystem.getClip();
			
			clip.open(audioStream);
			
			clip.start();
			
			clip.addLineListener(event -> {
				if (event.getType() ==  LineEvent.Type.STOP) {
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
			    Sonido sonido= fabricaSonidos.obtenerDisparoBolaFuego();
	            
	            File archivoSonido = new File(sonido.obtenerRutaSonido());
	            
	            AudioInputStream audioStream = AudioSystem.getAudioInputStream(archivoSonido);
	            
	            Clip clip = AudioSystem.getClip();
	            
	            clip.open(audioStream);
	            
	            clip.start();
	            
	            clip.addLineListener(event -> {
	                if (event.getType() ==  LineEvent.Type.STOP) {
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
		    Sonido sonido= fabricaSonidos.obtenerGolpeBloque();
            
            File archivoSonido = new File(sonido.obtenerRutaSonido());
            
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(archivoSonido);
            
            Clip clip = AudioSystem.getClip();
            
            clip.open(audioStream);
            
            clip.start();
            
            clip.addLineListener(event -> {
                if (event.getType() ==  LineEvent.Type.STOP) {
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
		    Sonido sonido= 	fabricaSonidos.obtenerModoInvencible();
            
            File archivoSonido = new File(sonido.obtenerRutaSonido());
            
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(archivoSonido);
            
            Clip clip = AudioSystem.getClip();
            
            clip.open(audioStream);
            
            clip.start();
            
            clip.addLineListener(event -> {
                if (event.getType() ==  LineEvent.Type.STOP) {
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
	
	public void modoRecuperacion(){
		try {
			Sonido sonido= 	fabricaSonidos.obtenerModoRecuperacion();
			
			File archivoSonido = new File(sonido.obtenerRutaSonido());
			
			AudioInputStream audioStream = AudioSystem.getAudioInputStream(archivoSonido);
			
			Clip clip = AudioSystem.getClip();
			
			clip.open(audioStream);
			
			clip.start();
			
			clip.addLineListener(event -> {
				if (event.getType() ==  LineEvent.Type.STOP) {
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
	
	public void modoFuego(){
		try {
			Sonido sonido= 	fabricaSonidos.obtenerModoFuego();
			
			File archivoSonido = new File(sonido.obtenerRutaSonido());
			
			AudioInputStream audioStream = AudioSystem.getAudioInputStream(archivoSonido);
			
			Clip clip = AudioSystem.getClip();
			
			clip.open(audioStream);
			
			clip.start();
			
			clip.addLineListener(event -> {
				if (event.getType() ==  LineEvent.Type.STOP) {
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
		    Sonido sonido= fabricaSonidos.obtenerSonidoMoneda();

            File archivoSonido = new File(sonido.obtenerRutaSonido());
            
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(archivoSonido);
            
            Clip clip = AudioSystem.getClip();
            
            clip.open(audioStream);
            
            clip.start();
            
            clip.addLineListener(event -> {
                if (event.getType() ==  LineEvent.Type.STOP) {
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
		    Sonido sonido= fabricaSonidos.obtenerPierdeJuego();
            
            File archivoSonido = new File(sonido.obtenerRutaSonido());
            
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(archivoSonido);
            
            Clip clip = AudioSystem.getClip();
            
            clip.open(audioStream);
            
            clip.start();
            
            clip.addLineListener(event -> {
                if (event.getType() ==  LineEvent.Type.STOP) {
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
		    Sonido sonido= fabricaSonidos.obtenerPierdeVida();
            
            File archivoSonido = new File(sonido.obtenerRutaSonido());
            
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(archivoSonido);
            
            Clip clip = AudioSystem.getClip();
            
            clip.open(audioStream);
            
            clip.start();
            
            clip.addLineListener(event -> {
                if (event.getType() ==  LineEvent.Type.STOP) {
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
		    Sonido sonido= fabricaSonidos.obtenerPowerUpAgarrado();
            
            File archivoSonido = new File(sonido.obtenerRutaSonido());
            
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(archivoSonido);
            
            Clip clip = AudioSystem.getClip();
            
            clip.open(audioStream);
            
            clip.start();
            
            clip.addLineListener(event -> {
                if (event.getType() ==  LineEvent.Type.STOP) {
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
		    Sonido sonido= fabricaSonidos.obtenerPowerUpEmerge();
            
            File archivoSonido = new File(sonido.obtenerRutaSonido());
            
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(archivoSonido);
            
            Clip clip = AudioSystem.getClip();
            
            clip.open(audioStream);
            
            clip.start();
            
            clip.addLineListener(event -> {
                if (event.getType() ==  LineEvent.Type.STOP) {
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
		    Sonido sonido= 	fabricaSonidos.obtenerRecuperarVida();
            
            File archivoSonido = new File(sonido.obtenerRutaSonido());
            
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(archivoSonido);
            
            Clip clip = AudioSystem.getClip();
            
            clip.open(audioStream);
            
            clip.start();
            
            clip.addLineListener(event -> {
                if (event.getType() ==  LineEvent.Type.STOP) {
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
		    Sonido sonido= 	fabricaSonidos.obtenerRomperLadrillo();
            
            File archivoSonido = new File(sonido.obtenerRutaSonido());
            
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(archivoSonido);
            
            Clip clip = AudioSystem.getClip();
            
            clip.open(audioStream);
            
            clip.start();
            
            clip.addLineListener(event -> {
                if (event.getType() ==  LineEvent.Type.STOP) {
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
		    Sonido sonido= 	fabricaSonidos.obtenerSalto();
            
            File archivoSonido = new File(sonido.obtenerRutaSonido());
            
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(archivoSonido);
            
            Clip clip = AudioSystem.getClip();
            
            clip.open(audioStream);
            
            clip.start();
            
            clip.addLineListener(event -> {
                if (event.getType() ==  LineEvent.Type.STOP) {
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
		    Sonido sonido= 	fabricaSonidos.obtenerTocarBanderaFinNivel();
            
            File archivoSonido = new File(sonido.obtenerRutaSonido());
            
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(archivoSonido);
            
            Clip clip = AudioSystem.getClip();
            
            clip.open(audioStream);
            
            clip.start();
            
            clip.addLineListener(event -> {
                if (event.getType() ==  LineEvent.Type.STOP) {
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
	
	public void seAcaboElTiempo(){
		try {
		    Sonido sonido= 	fabricaSonidos.obtenerSeAcaboElTiempo();
            
            File archivoSonido = new File(sonido.obtenerRutaSonido());
            
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(archivoSonido);
            
            Clip clip = AudioSystem.getClip();
            
            clip.open(audioStream);
            
            clip.start();
            
            clip.addLineListener(event -> {
                if (event.getType() ==  LineEvent.Type.STOP) {
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
