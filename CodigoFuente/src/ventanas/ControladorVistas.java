package ventanas;

import javax.swing.JFrame;

import juego.EntidadLogica;

public class ControladorVistas implements ControladorDeVistas, ControladorEntreJuegoVista {
	
	private JFrame ventana;
	
	private HUD HUD;
	
	private PantallaDeJuego pantallaDeJuego;
	
	private PantallaFinal pantallaFinal;
	
	private PantallaInicial pantallaInicial;

	@Override
	public void accionarInicioJuego() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void accionarPantallaPuntajes() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void accionarPantallaModoDeJuego() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cambiarModoDeJuego() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Observer registrarEntidad(EntidadLogica entidadLogica) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Observer registrarEntidad(EntidadJugador entidadJugador) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Observer registrarSilueta(EntidadLogica silueta) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void mostrarPantallaDeJuego() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mostrarPantallaFinal() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mostrarPantallaInicial() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mostrarHUD() {
		// TODO Auto-generated method stub
		
	}
	
}
