package juego;

public class BucleJuego implements Runnable{
	
	private static final int MILISEGUNDOS_POR_SEGUNDO = 1000;
	
	private static final int NANOSEGUNDOS_POR_SEGUNDO = 1_000_000_000;
	
	private static final double CANTIDAD_TICKS = 60.0;
	
	private volatile boolean bucleJuegoEnEjecucion;
	
	private Juego juego;
	
	private Thread hilo;
	
	public BucleJuego(Juego juego) {
		this.juego = juego;
		iniciarBucleJuego();
	}
	
	private synchronized void iniciarBucleJuego() {
		this.bucleJuegoEnEjecucion = true;
		this.hilo = new Thread(this);
		this.hilo.start();	
	}
	
	public synchronized void detenerBucleJuego() {
		if (!this.bucleJuegoEnEjecucion) {
			return;
		}
		this.bucleJuegoEnEjecucion = false;
        try {
            if (this.hilo != null && this.hilo.isAlive()) {
                this.hilo.join();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
	}

	@Override
	public void run() {
	    long ultimoTiempoCapturado = System.nanoTime();
	    
	    double cantidadTicks = CANTIDAD_TICKS;
	    double nanoSegundosPorTick = NANOSEGUNDOS_POR_SEGUNDO / cantidadTicks;
	    
	    double delta = 0;
	    
	    long cronometro = System.currentTimeMillis();
	    
	    int frames = 0;
	    int actualizaciones = 0;

	    while (this.bucleJuegoEnEjecucion) {
	        long tiempoActual = System.nanoTime();
	        
	        delta += (tiempoActual - ultimoTiempoCapturado);
	        
	        ultimoTiempoCapturado = tiempoActual;
	        
	        while (delta >= nanoSegundosPorTick) {
	            actualizarJuego();
	            actualizaciones++;
	            delta -= nanoSegundosPorTick;
	        }
	        
	        if (this.bucleJuegoEnEjecucion) {
	            renderizarBucleJuego();
	            frames++;
	        }
	        
	        if (System.currentTimeMillis() - cronometro > MILISEGUNDOS_POR_SEGUNDO) {
	            cronometro += MILISEGUNDOS_POR_SEGUNDO;
	            //System.out.println("FPS: " + frames + " TPS: " + updates);
	            actualizaciones = 0;
	            frames = 0;
	        }
	    }
	    
	    detenerBucleJuego();
	}

	
	private void actualizarJuego() {
		this.juego.actualizar();
	}
	
	private void renderizarBucleJuego() {
	}
	
}
