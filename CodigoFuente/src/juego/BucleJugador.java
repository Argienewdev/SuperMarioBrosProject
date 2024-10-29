package juego;

public class BucleJugador implements Runnable {
	
	private static final int MILISEGUNDOS_POR_SEGUNDO = 1000;
	
	private static final int NANOSEGUNDOS_POR_SEGUNDO = 1_000_000_000;
	
	private static final double CANTIDAD_TICKS = 60.0;
	
	private volatile boolean bucleJugadorEnEjecucion;
	
	private Partida partida;
	
	private Thread hilo;
	
	public BucleJugador(Partida partida) {
		this.partida = partida;
		iniciarBucleJugador();
	}
	
	private synchronized void iniciarBucleJugador() {
		this.bucleJugadorEnEjecucion = true;
		this.hilo = new Thread(this);
		this.hilo.start();
	}
	
	public synchronized void detenerBucleJugador() {
		if (!this.bucleJugadorEnEjecucion) {
			return;
		}
		this.bucleJugadorEnEjecucion = false;
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

	    while (this.bucleJugadorEnEjecucion) {
	        long tiempoActual = System.nanoTime();
	        
	        delta += (tiempoActual - ultimoTiempoCapturado);
	        
	        ultimoTiempoCapturado = tiempoActual;
	        
	        while (delta >= nanoSegundosPorTick) {
	            actualizarBucleJugador();
	            actualizaciones++;
	            delta -= nanoSegundosPorTick;
	        }
	        
	        if (this.bucleJugadorEnEjecucion) {
	            renderizarBucleJugador();
	            frames++;
	        }
	        
	        if (System.currentTimeMillis() - cronometro > MILISEGUNDOS_POR_SEGUNDO) {
	            cronometro += MILISEGUNDOS_POR_SEGUNDO;
	            //System.out.println("FPS: " + frames + " TPS: " + updates);
	            actualizaciones = 0;
	            frames = 0;
	        }
	    }
	    
	    detenerBucleJugador();
	}

	
	private void actualizarBucleJugador() {
		this.partida.actualizar();
	}
	
	private void renderizarBucleJugador() {
	}
}
