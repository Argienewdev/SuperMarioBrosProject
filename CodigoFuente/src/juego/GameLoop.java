package juego;

import java.awt.Canvas;

import ventanas.Ventana;

public class GameLoop extends Canvas implements Runnable{
	
	//Constantes
	private static final int MillisPorSegundo = 1000;
	private static final int NanosPorSegundo = 1000000000;
	private static final double NumTicks = 60.0;
	private static final String Nombre = "Super Mario Bros";
	
	private static final int AnchoVentana = 960;
	private static final int AlturaVentana = 720;
	
	//Variables
	private boolean running;
	private Ventana ventana;
	//Componentes
	private Thread thread;
	
	public GameLoop() {
		initialize();
	}
	
	public static void main(String args[]) {
		new GameLoop();
	}
	
	private void initialize() {
		ventana = new Ventana(AnchoVentana, AlturaVentana, Nombre, this);
		
		start();
	}
	
	private synchronized void start() {
		thread = new Thread(this);
		thread.start();
		running = true;
	}
	
	private synchronized void stop() {
		try {
			thread.join();
			running = false;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
	    // Marca el momento inicial en nanosegundos
	    long lastTime = System.nanoTime();
	    
	    // Se calcula cuántos nanosegundos corresponden a cada tick basado en 60 ticks por segundo
	    double cantidadTicks = NumTicks; // 60 ticks por segundo
	    double ns = NanosPorSegundo / cantidadTicks; // Cuántos nanosegundos por tick
	    
	    // delta controla cuántos ticks se deben ejecutar antes de volver a renderizar
	    double delta = 0;
	    
	    // Temporizador para calcular los FPS y TPS (Frames y Ticks por segundo)
	    long timer = System.currentTimeMillis();
	    
	    // Contadores de cuadros y actualizaciones
	    int frames = 0;
	    int updates = 0;

	    // Bucle principal del juego, se ejecuta mientras el juego esté en ejecución
	    while (running) {
	        // Calcula el tiempo actual
	        long now = System.nanoTime();
	        
	        // Suma al delta la fracción del tiempo transcurrido desde el último ciclo
	        delta += (now - lastTime);
	        
	        // Actualiza lastTime para la próxima iteración
	        lastTime = now;
	        
	        // Si delta es mayor o igual a 1, significa que ha pasado suficiente tiempo para un tick
	        while (delta >= ns) {
	            tick(); // Llama a la actualización lógica del juego
	            updates++; // Incrementa el número de actualizaciones (ticks)
	            delta -= ns; // Decrementa delta para seguir controlando el tiempo
	        }
	        
	        // Renderiza el juego si está corriendo
	        if (running) {
	            render(); // Llama al método que maneja la visualización
	            frames++; // Incrementa el número de cuadros (frames)
	        }
	        
	        // Si ha pasado más de un segundo (MillisPorSegundo = 1000 ms), imprime los FPS y TPS
	        if (System.currentTimeMillis() - timer > MillisPorSegundo) {
	            timer += MillisPorSegundo; // Actualiza el temporizador
	            System.out.println("FPS: " + frames + " TPS: " + updates); // Imprime los resultados
	            updates = 0; // Reinicia el conteo de actualizaciones
	            frames = 0;  // Reinicia el conteo de cuadros
	        }
	    }
	    
	    stop(); // Si el bucle sale, detiene el juego
	}

	
	private void tick() {
		ventana.moveMario();
	}
	
	private void render() {
		ventana.render();
	}
}
