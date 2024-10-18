package ventanas;

import juego.EntidadJugador;
import juego.EntidadLogica;

public interface ControladorEntreJuegoVista {
	
	public Observer registrarEntidad(EntidadLogica entidadLogica);
	
	public Observer registrarEntidad(EntidadJugador entidadJugador);
	
	public Observer registrarSilueta(EntidadLogica silueta);
	
	public void mostrarPantallaDeJuego();
	
	public void mostrarPantallaFinal();
	
	public void mostrarPantallaInicial();
	
	public void mostrarHUD();
}
