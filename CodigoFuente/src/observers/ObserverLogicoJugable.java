package observers;

import juego.Juego;

public class ObserverLogicoJugable implements Observer {
	
	private Juego juego;
	
	public ObserverLogicoJugable (Juego juego) {
		this.juego = juego;
	}
	
	public void establecerPartida (Juego juego) {
		this.juego = juego;
	}
	
	public void actualizar() { 
		juego.finalizarPartida();
	}

}
