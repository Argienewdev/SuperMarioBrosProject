package juego;

public class BucleJuego implements Runnable{
	
	private static final int MILISEGUNDOS_POR_SEGUNDO = 1000;
	
	private static final int NANOSEGUNDOS_POR_SEGUNDO = 1000000000;
	
	private static final double CANTIDAD_TICKS = 60.0;
	
	private boolean running;
	
	private Juego juego;
	
	private Thread thread;
	
	public BucleJuego(Juego juego) {
		initialize(juego);
	}
	
	private void initialize(Juego juego) {
		this.juego = juego;
		start();
	}
	
	private synchronized void start() {
		thread = new Thread(this);
		thread.start();
		running = true;
	}
	
	public synchronized void stop() {
		try {
			thread.join();
			running = false;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
	    long lastTime = System.nanoTime();
	    
	    double cantidadTicks = CANTIDAD_TICKS;
	    double nanoSegundosPorTick = NANOSEGUNDOS_POR_SEGUNDO / cantidadTicks;
	    
	    double delta = 0;
	    
	    long timer = System.currentTimeMillis();
	    
	    int frames = 0;
	    int updates = 0;

	    while (running) {
	        long now = System.nanoTime();
	        
	        delta += (now - lastTime);
	        
	        lastTime = now;
	        
	        while (delta >= nanoSegundosPorTick) {
	            tick();
	            updates++;
	            delta -= nanoSegundosPorTick;
	        }
	        
	        if (running) {
	            render();
	            frames++;
	        }
	        
	        if (System.currentTimeMillis() - timer > MILISEGUNDOS_POR_SEGUNDO) {
	            timer += MILISEGUNDOS_POR_SEGUNDO;
	            //System.out.println("FPS: " + frames + " TPS: " + updates);
	            updates = 0;
	            frames = 0;
	        }
	    }
	    
	    System.out.println("Ejecuto stop");
	    stop();
	}

	
	private void tick() {
		juego.actualizar();
	}
	
	private void render() {
		
	}
}
